package com.example.rudyn.anotar_domino;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Valia on 20/1/2021.
 */

public class Letra extends AppCompatActivity {

    TextView letra;
    RadioButton pequeño;
    RadioButton mediano;
    RadioButton grande;

    int tamaño=-1;

    int pequeñoInt=30;
    int medianoInt=40;
    int grandeInt=50;

    Button idBotonAceptar;
    Button idBotonCancelar;

    LetraTamaño letraTamaño;
    int tamañoLetra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letra);

        String font_path1 = "font/letra.TTF";
        Typeface TF1 = Typeface.createFromAsset(getAssets(), font_path1);

        letra=(TextView)findViewById(R.id.idTextLetra);
        pequeño=(RadioButton)findViewById(R.id.idRadioButtonPeque);
        mediano=(RadioButton)findViewById(R.id.idRadioButtonMed);
        grande=(RadioButton)findViewById(R.id.idRadioButtonGrand);

        idBotonAceptar=(Button)findViewById(R.id.idButtonAceptarLetra);
        idBotonCancelar=(Button)findViewById(R.id.idButtonCancelarLetra);

        letra.setTypeface(TF1);
        pequeño.setTypeface(TF1);
        mediano.setTypeface(TF1);
        grande.setTypeface(TF1);

        idBotonAceptar.setTypeface(TF1);
        idBotonCancelar.setTypeface(TF1);

        ponerTamañoLetra();

    }

    private void ponerTamañoLetra(){

         letraTamaño=new LetraTamaño(this);

         tamañoLetra=letraTamaño.getTamaño();

        switch (tamañoLetra){
            case 0:{
                letra.setTextSize(letraTamaño.getLetraPequeño()[0]);
                pequeño.setTextSize(letraTamaño.getLetraPequeño()[0]);
                mediano.setTextSize(letraTamaño.getLetraPequeño()[0]);
                grande.setTextSize(letraTamaño.getLetraPequeño()[0]);

                idBotonAceptar.setTextSize(letraTamaño.getLetraPequeño()[1]);
                idBotonCancelar.setTextSize(letraTamaño.getLetraPequeño()[1]);
                tamaño=0;
                pequeño.setChecked(true);
                break;
            }
            case 1:{
                letra.setTextSize(letraTamaño.getLetraMediano()[0]);
                pequeño.setTextSize(letraTamaño.getLetraMediano()[0]);
                mediano.setTextSize(letraTamaño.getLetraMediano()[0]);
                grande.setTextSize(letraTamaño.getLetraMediano()[0]);

                idBotonAceptar.setTextSize(letraTamaño.getLetraMediano()[1]);
                idBotonCancelar.setTextSize(letraTamaño.getLetraMediano()[1]);
                tamaño=1;
                mediano.setChecked(true);
                break;
            }
            case 2:{
                letra.setTextSize(letraTamaño.getLetraGrande()[0]);
                pequeño.setTextSize(letraTamaño.getLetraGrande()[0]);
                mediano.setTextSize(letraTamaño.getLetraGrande()[0]);
                grande.setTextSize(letraTamaño.getLetraGrande()[0]);

                idBotonAceptar.setTextSize(letraTamaño.getLetraGrande()[1]);
                idBotonCancelar.setTextSize(letraTamaño.getLetraGrande()[1]);
                tamaño=2;
                grande.setChecked(true);
                break;
            }
        }
    }


    public void pequeño(View view){
        letra.setTextSize(pequeñoInt);
        tamaño=0;
    }
    public void mediano(View view){
        letra.setTextSize(medianoInt);
        tamaño=1;
    }
    public void grande(View view){
        letra.setTextSize(grandeInt);
        tamaño=2;
    }


    public void aceptar(View view){
        letraTamaño.setTamaño(view.getContext(), tamaño);

        Intent refresh = new Intent(Letra.this, Opcion.class);
        startActivity(refresh);
        finish();

    }
    public void onBackPressed(View view){
        onBackPressed();
    }
}
