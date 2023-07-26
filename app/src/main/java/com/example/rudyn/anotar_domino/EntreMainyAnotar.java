package com.example.rudyn.anotar_domino;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Valia on 28/02/2021.
 */

public class EntreMainyAnotar extends AppCompatActivity {

    String font_path1;
    TextView ultimaPartida;
    TextView nombre1;
    TextView nombre2;
    TextView puntos1;
    TextView puntos2;

    Button botonAceptar;
    Button botonCancelar;
    ArrayList <String> todo=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entre_main_y_anotar);

        font_path1 = "font/letra.TTF";
        Typeface TF1 = Typeface.createFromAsset(getAssets(), font_path1);

        ultimaPartida=(TextView)findViewById(R.id.idTextViewUltPartida);
        nombre1=(TextView)findViewById(R.id.textViewNombre1);
        nombre2=(TextView)findViewById(R.id.textViewNombre2);
        puntos1=(TextView)findViewById(R.id.textViewPtos1);
        puntos2=(TextView)findViewById(R.id.textViewPtos2);

        botonAceptar=(Button)findViewById(R.id.buttonAcept);
        botonCancelar=(Button)findViewById(R.id.buttonCanc);

        ultimaPartida.setTypeface(TF1);
        nombre1.setTypeface(TF1);
        nombre2.setTypeface(TF1);
        puntos1.setTypeface(TF1);
        puntos2.setTypeface(TF1);
        botonAceptar.setTypeface(TF1);
        botonCancelar.setTypeface(TF1);

        ponerTamañoLetra();

        String archivo=readFiles(this);
        String cadena="";

        for (int i=0;i<archivo.length();i++){
            if ((""+archivo.charAt(i)).equals("/")){
                todo.add(cadena);
                cadena="";
            }else {
                cadena=cadena+archivo.charAt(i);
            }
        }

        nombre1.setText(todo.get(0));
        nombre2.setText(todo.get(1));
        puntos1.setText(todo.get(2));
        puntos2.setText(todo.get(3));

    }

    public void acepta(View view){
        Intent intent=new Intent(this, AnotarJuegos.class);
        intent.putExtra("CONTINUAR",true);
        startActivity(intent);
    }

    public void cancelar(View view){
        Intent intent=new Intent(this, AnotarJuegos.class);
        intent.putExtra("CONTINUAR",false);
        startActivity(intent);
    }


    private void ponerTamañoLetra(){

        LetraTamaño letraTamaño=new LetraTamaño(this);

        int tamañoLetra=letraTamaño.getTamaño();

        switch (tamañoLetra){
            case 0:{
                ultimaPartida.setTextSize(letraTamaño.getEntrePequeño()[0]);
                nombre1.setTextSize(letraTamaño.getEntrePequeño()[1]);
                nombre2.setTextSize(letraTamaño.getEntrePequeño()[1]);
                puntos1.setTextSize(letraTamaño.getEntrePequeño()[2]);
                puntos2.setTextSize(letraTamaño.getEntrePequeño()[2]);
                botonAceptar.setTextSize(letraTamaño.getEntrePequeño()[3]);
                botonCancelar.setTextSize(letraTamaño.getEntrePequeño()[3]);
                break;
            }
            case 1:{
                ultimaPartida.setTextSize(letraTamaño.getEntreMediano()[0]);
                nombre1.setTextSize(letraTamaño.getEntreMediano()[1]);
                nombre2.setTextSize(letraTamaño.getEntreMediano()[1]);
                puntos1.setTextSize(letraTamaño.getEntreMediano()[2]);
                puntos2.setTextSize(letraTamaño.getEntreMediano()[2]);
                botonAceptar.setTextSize(letraTamaño.getEntreMediano()[3]);
                botonCancelar.setTextSize(letraTamaño.getEntreMediano()[3]);
                break;
            }
            case 2:{
                ultimaPartida.setTextSize(letraTamaño.getEntreGrande()[0]);
                nombre1.setTextSize(letraTamaño.getEntreGrande()[1]);
                nombre2.setTextSize(letraTamaño.getEntreGrande()[1]);
                puntos1.setTextSize(letraTamaño.getEntreGrande()[2]);
                puntos2.setTextSize(letraTamaño.getEntreGrande()[2]);
                botonAceptar.setTextSize(letraTamaño.getEntreGrande()[3]);
                botonCancelar.setTextSize(letraTamaño.getEntreGrande()[3]);
                break;
            }
        }
    }


    private String readFiles(Context context){

        String part="";

        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(context);
        try{
            part=datos.getString("PARTIDAULT","1");
        }catch (Exception e){
            //Toast.makeText(context, "NO cargo la partida", Toast.LENGTH_SHORT).show();
        }

        //Toast.makeText(context, "Cargo partida"+part, Toast.LENGTH_SHORT).show();

        return part;

    }



}
