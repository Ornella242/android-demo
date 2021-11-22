package Ornella242.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

//import static Ornella242.demo.R.id.button1;


public class CalculatriceActivity extends AppCompatActivity {

    //Récupération de tous les éléments de l'interface grâce aux identifiants
    //Déclaration de toutes les variables
    //Déclaration de toutes les variables
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonAC;
    Button buttonPlusouMoins;
    Button buttonPourcentage;
    Button buttonDivision;
    Button buttonMultiplier;
    Button buttonMoins;
    Button buttonPlus;
    Button buttonEgal;
    Button buttonVirgule;
    TextView ecran;

    private double chiffre1;
    private boolean
            clicOperateur = false;
    private boolean update = false;
    private String operateur = "";

    //Appeler lorsque l'activité vient d'être créer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        //Récupération de tous les éléments de l'interface grâce aux identifiants
        button0 = (Button)
                findViewById(R.id.button0);
        button1 = (Button)
                findViewById(R.id.button1);
        button2 = (Button)
                findViewById(R.id.button2);
        button3 = (Button)
                findViewById(R.id.button3);
        button4 = (Button)
                findViewById(R.id.button4);
        button5 = (Button)
                findViewById(R.id.button5);
        button6 = (Button)
                findViewById(R.id.button6);
        button7 = (Button)
                findViewById(R.id.button7);
        button8 = (Button)
                findViewById(R.id.button8);
        button9 = (Button)
                findViewById(R.id.button9);
        buttonAC = (Button)
                findViewById(R.id.buttonAC);
        buttonPlusouMoins = (Button)
                findViewById(R.id.buttonPlusouMoins);
        buttonPourcentage = (Button)
                findViewById(R.id.buttonPourcentage);
        buttonDivision = (Button)
                findViewById(R.id.buttonDivision);
        buttonMultiplier = (Button)
                findViewById(R.id.buttonMultiplier);
        buttonMoins = (Button)
                findViewById(R.id.buttonMoins);
        buttonPlus = (Button)
                findViewById(R.id.buttonPlus);
        buttonEgal = (Button)
                findViewById(R.id.buttonEgal);
        buttonVirgule = (Button)
                findViewById(R.id.buttonVirgule);
        ecran = (TextView)
                findViewById(R.id.textview_first);

        //Attribution d'écouteur d'évenement à tous les éléments

        button0.setOnClickListener(v -> chiffreClick(" 0 "));

        button1.setOnClickListener(v -> chiffreClick(" 1 "));

        button2.setOnClickListener(v -> chiffreClick(" 2 "));

        button3.setOnClickListener(v -> chiffreClick(" 3 "));

        button4.setOnClickListener(v -> chiffreClick( "4 "));

        button5.setOnClickListener(v -> chiffreClick(" 5 "));

        button6.setOnClickListener(v -> chiffreClick(" 6 "));

        button7.setOnClickListener(v -> chiffreClick(" 7 "));

        button8.setOnClickListener(v -> chiffreClick(" 8 "));

        button9.setOnClickListener(v -> chiffreClick(" 9 "));

        buttonAC.setOnClickListener(v -> resetClick());

        buttonPlusouMoins.setOnClickListener(v -> plusouMoinsClick());

        buttonPourcentage.setOnClickListener(v -> pourcentageClick());

        buttonDivision.setOnClickListener(v -> divisionClick());

        buttonMultiplier.setOnClickListener(v -> multiplierClick());

        buttonMoins.setOnClickListener(v -> moinsClick());

        buttonPlus.setOnClickListener(v -> plusClick());

        buttonEgal.setOnClickListener(v -> egalClick());

        buttonVirgule.setOnClickListener(v -> virguleClick());


    }

    //Les méthodes exécutées lorsqu'on clique sur un bouton
    // bouton chiffre

    private void plusouMoinsClick() {
        if (clicOperateur) {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        } else {
            chiffre1= Double.parseDouble(ecran.getText().toString());
            clicOperateur=true;
        }
        operateur="+/-";
        update=true;
    }

    private void pourcentageClick() {
        if (clicOperateur) {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        } else {
            chiffre1= Double.parseDouble(ecran.getText().toString());
            clicOperateur=true;
        }
        operateur="%";
        update=true;
    }

    private void divisionClick() {
        if (clicOperateur) {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        } else {
            chiffre1= Double.parseDouble(ecran.getText().toString());
            clicOperateur=true;
        }
        operateur="/";
        update=true;
    }

    private void multiplierClick() {
        if (clicOperateur) {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        } else {
            chiffre1= Double.parseDouble(ecran.getText().toString());
            clicOperateur=true;
        }
        operateur="*";
        update=true;
    }

    private void moinsClick() {
        if (clicOperateur) {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        } else {
            chiffre1= Double.parseDouble(ecran.getText().toString());
            clicOperateur=true;
        }
        operateur="-";
        update=true;
    }

    //Lorsqu'on clique sur +
    private void plusClick() {
        if (clicOperateur) {
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        } else {
            chiffre1= Double.parseDouble(ecran.getText().toString());
            clicOperateur=true;
        }
        operateur="+";
        update=true;
    }



    private void egalClick() {
        calcul();
        update=true;
        clicOperateur=false;
    }

    private void virguleClick() {

    }

    private void resetClick() {
        clicOperateur=false;
        update=true;
        chiffre1=0;
        operateur="";
        ecran.setText(" ");
    }


    private void chiffreClick(String s) {
        if (update) {
            update=false;
        }else{
            if(!ecran.getText().equals("0"))
                s=ecran.getText()+s;
        }
        ecran.setText(s);
    }

    private void calcul() {
        if (operateur.equals("+")){
            chiffre1=chiffre1+ Double.parseDouble(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre1));
        }

        if (operateur.equals("-")){
            chiffre1=chiffre1- Double.parseDouble(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre1));
        }



        if (operateur.equals("*")){
            chiffre1=chiffre1* Double.parseDouble(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre1));
        }

        if (operateur.equals("/")){
            try{
                chiffre1=chiffre1/ Double.parseDouble(ecran.getText().toString());
                ecran.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                ecran.setText(" 0 ");
            }
        }

        if (operateur.equals("%")){
            chiffre1=chiffre1% Double.parseDouble(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre1));
        }



    }

}