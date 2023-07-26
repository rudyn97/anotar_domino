package com.example.rudyn.anotar_domino;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Valia on 24/07/2021.
 */

public class JuegoOpciones extends AppCompatActivity{

    String font_path;

    ArrayList<String> juegos;
    LetraTamaño letraTamaño;
    RadioButton idRadioButton1;
    RadioButton idRadioButton2;

    TextView idTextoCentro;
    Button idButtonAp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_opciones);

        font_path = "font/letra.TTF";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        idTextoCentro =(TextView) findViewById(R.id.idTextoCentro);
        idButtonAp = (Button) findViewById(R.id.idButtonAp);
        idRadioButton1 = (RadioButton) findViewById(R.id.idRadioButton1);
        idRadioButton2 = (RadioButton) findViewById(R.id.idRadioButton2);

        idTextoCentro.setTypeface(TF);
        idButtonAp.setTypeface(TF);
        idRadioButton1.setTypeface(TF);
        idRadioButton2.setTypeface(TF);

        juegos=new ArrayList<>();
        añadirJuegos();
        tamañoLetra();


        if (readFiles(this)!=-1){
            switch (readFiles(this)){
                case 0:{
                    idRadioButton1.setChecked(true);
                    ponerTexto();
                    break;
                }
                case 1:{
                    idRadioButton2.setChecked(true);
                    ponerTexto();
                    break;
                }
            }
        }else{
            idRadioButton1.setChecked(true);
            ponerTexto();
        }


    }

    private void añadirJuegos(){
        //AQUI VAN TODOS LOS NOMBRES DE LOS TIPOS DE JUEGOS
        juegos.add(getResources().getString(R.string.tipoJuego1));
        juegos.add(getResources().getString(R.string.tipoJuego2));

    }

    public void clasico(View view){
        idRadioButton1.setChecked(true);
        ponerTexto();
    }
    public void continua(View view){
        idRadioButton2.setChecked(true);
        ponerTexto();
    }

    private void ponerTexto(){
        if (idRadioButton1.isChecked()){
            idTextoCentro.setText(getResources().getString(R.string.tipoJuego1Explicacion));
        }
        if (idRadioButton2.isChecked()){
            idTextoCentro.setText(getResources().getString(R.string.tipoJuego2Explicacion));
        }
    }

    private void tamañoLetra(){
        letraTamaño=new LetraTamaño(this);

        switch (letraTamaño.getTamaño()){
            case 0:{
                idRadioButton1.setTextSize(letraTamaño.getJuegoOpcionesPequeño()[0]);
                idRadioButton2.setTextSize(letraTamaño.getJuegoOpcionesPequeño()[0]);
                idTextoCentro.setTextSize(letraTamaño.getJuegoOpcionesPequeño()[2]);
                idButtonAp.setTextSize(letraTamaño.getJuegoOpcionesPequeño()[1]);
                break;
            }
            case 1:{
                idRadioButton1.setTextSize(letraTamaño.getJuegoOpcionesMediano()[0]);
                idRadioButton2.setTextSize(letraTamaño.getJuegoOpcionesMediano()[0]);
                idTextoCentro.setTextSize(letraTamaño.getJuegoOpcionesMediano()[2]);
                idButtonAp.setTextSize(letraTamaño.getJuegoOpcionesMediano()[1]);
                break;
            }
            case 2:{
                idRadioButton1.setTextSize(letraTamaño.getJuegoOpcionesGrande()[0]);
                idRadioButton2.setTextSize(letraTamaño.getJuegoOpcionesGrande()[0]);
                idTextoCentro.setTextSize(letraTamaño.getJuegoOpcionesGrande()[2]);
                idButtonAp.setTextSize(letraTamaño.getJuegoOpcionesGrande()[1]);
                break;
            }

        }

    }

    public void aplicar(View view){
        if (idRadioButton1.isChecked()){
            saveFiles(this,0);
        }
        if (idRadioButton2.isChecked()){
            saveFiles(this,1);
        }
        onBackPressed();
    }


    private void saveFiles(Context context, int juego){

        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor mieditor=datos.edit();

        mieditor.putInt("TIPOJUEGO", juego);

        mieditor.apply();

        //Toast.makeText(context, "Actualizo tamaño", Toast.LENGTH_SHORT).show();

    }

    private int readFiles(Context context){

        int tam=-1;

        SharedPreferences datos=PreferenceManager.getDefaultSharedPreferences(context);
        try{
            tam=datos.getInt("TIPOJUEGO",-1);
        }catch (Exception e){
            //Toast.makeText(context, "NO cargo el tamaño", Toast.LENGTH_SHORT).show();
        }

        return tam;

    }



}
