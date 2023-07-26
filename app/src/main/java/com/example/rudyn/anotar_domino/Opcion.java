package com.example.rudyn.anotar_domino;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Valia on 14/07/2021.
 */

public class Opcion extends AppCompatActivity{

    TextView equipos;
    TextView partido;
    TextView letra;
    TextView idioma;
    TextView juego;

    String font_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcion);

        font_path = "font/letra.TTF";

        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        equipos=(TextView)findViewById(R.id.idTextViewEquipos);
        partido=(TextView)findViewById(R.id.idTextViewPartidos);
        letra=(TextView)findViewById(R.id.idTextViewLetra);
        idioma=(TextView)findViewById(R.id.idTextViewIdioma);
        juego=(TextView)findViewById(R.id.idTextViewJuego);

        equipos.setTypeface(TF);
        partido.setTypeface(TF);
        letra.setTypeface(TF);
        idioma.setTypeface(TF);
        juego.setTypeface(TF);

    }

    @Override
    protected void onStart() {
        ponerTamañoLetra();
        super.onStart();
    }

    private void ponerTamañoLetra(){

        LetraTamaño letraTamaño=new LetraTamaño(this);

        int tamañoLetra=letraTamaño.getTamaño();

        switch (tamañoLetra){
            case 0:{
                equipos.setTextSize(letraTamaño.getOpcionPequeño()[0]);
                partido.setTextSize(letraTamaño.getOpcionPequeño()[0]);
                letra.setTextSize(letraTamaño.getOpcionPequeño()[0]);
                idioma.setTextSize(letraTamaño.getOpcionPequeño()[0]);
                juego.setTextSize(letraTamaño.getOpcionPequeño()[0]);
                break;
            }
            case 1:{
                equipos.setTextSize(letraTamaño.getOpcionMediano()[0]);
                partido.setTextSize(letraTamaño.getOpcionMediano()[0]);
                letra.setTextSize(letraTamaño.getOpcionMediano()[0]);
                idioma.setTextSize(letraTamaño.getOpcionMediano()[0]);
                juego.setTextSize(letraTamaño.getOpcionMediano()[0]);
                break;
            }
            case 2:{
                equipos.setTextSize(letraTamaño.getOpcionGrande()[0]);
                partido.setTextSize(letraTamaño.getOpcionGrande()[0]);
                letra.setTextSize(letraTamaño.getOpcionGrande()[0]);
                idioma.setTextSize(letraTamaño.getOpcionGrande()[0]);
                juego.setTextSize(letraTamaño.getOpcionGrande()[0]);
                break;
            }
        }
    }

    public void cambiarEquipoOpciones(View view){
        Intent intent=new Intent(this, EquipoOpciones.class);
        startActivity(intent);
    }

    public void cambiarPartidoOpciones(View view){
        Intent intent=new Intent(this, PartidoOpciones.class);
        startActivity(intent);
    }

    public void cambiarIdioma(View view){
        Intent intent=new Intent(this, Idioma.class);
        startActivity(intent);
    }

    public void entrarAletra(View view){
        Intent intent=new Intent(this, Letra.class);
        startActivity(intent);
    }

    public void cambiarJuego(View view){
        Intent intent=new Intent(this, JuegoOpciones.class);
        startActivity(intent);
    }






    @Override
    public void onBackPressed() {
        super.onSupportNavigateUp();
        //super.onBackPressed();
    }
}
