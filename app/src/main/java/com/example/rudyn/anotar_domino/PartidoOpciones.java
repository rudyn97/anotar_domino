package com.example.rudyn.anotar_domino;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Valia on 14/9/2020.
 */

public class PartidoOpciones extends AppCompatActivity {

    AlertDialog dialog;

    String font_path;

    CheckBox checkBoxPasesSelect;
    TextView cantDpuntos;
    EditText idEditarCantPtos;
    TextView idTextViewJugarCpases;
    Button idBtnAplicar;
    Button idBtnCancelar;


    EditText editTextPase1;
    EditText editTextPase2;

    DatosDlaPartida datosDlaPartida;

    EquiposAdapter adapter1;

    ImageView idImageIdioma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partido_opciones);



        font_path = "font/letra.TTF";

        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        cantDpuntos=(TextView) findViewById(R.id.cantidad_puntos);
        idEditarCantPtos=(EditText)findViewById(R.id.idAnotarCantPuntos);
        idTextViewJugarCpases=(TextView)findViewById(R.id.idTextViewJugarCpases);
        idBtnAplicar=(Button)findViewById(R.id.idBtnAplicar);
        idBtnCancelar=(Button)findViewById(R.id.idBtnCancelar);
        editTextPase1=(EditText)findViewById(R.id.editTextPase1);
        editTextPase2=(EditText)findViewById(R.id.editTextPase2);

        cantDpuntos.setTypeface(TF);
        idEditarCantPtos.setTypeface(TF);
        idTextViewJugarCpases.setTypeface(TF);
        editTextPase1.setTypeface(TF);
        editTextPase2.setTypeface(TF);
        idBtnAplicar.setTypeface(TF);
        idBtnCancelar.setTypeface(TF);

        checkBoxPasesSelect=(CheckBox)findViewById(R.id.idCheckBoxPases);
        editTextPase1=(EditText)findViewById(R.id.editTextPase1);
        editTextPase2=(EditText)findViewById(R.id.editTextPase2);

        idImageIdioma=(ImageView)findViewById(R.id.idImageIdioma);

        datosDlaPartida=new DatosDlaPartida(this);

        //Aqui carga de la base y le pone las cosas en opcion de acuerdo a lo que cargo
        ponerTodoDlaBase();


    }

    @Override
    protected void onStart() {
        ponerTamañoLetra();
        super.onStart();
    }

    private void ponerTodoDlaBase(){

        //Primeramente debe cargar los puntos que estan guardados en la base de datos
        datosDlaPartida.cargarPuntos();
        idEditarCantPtos.setHint(""+datosDlaPartida.getCantidadPtosPartido());

        if (datosDlaPartida.isJuegoConPases()){
            checkBoxPasesSelect.setChecked(true);
            editTextPase1.setVisibility(View.VISIBLE);
            editTextPase2.setVisibility(View.VISIBLE);

            editTextPase1.setHint(""+datosDlaPartida.getPtosPrimerPase());
            editTextPase2.setHint(""+datosDlaPartida.getPtosSegundoPase());
        }else{
            checkBoxPasesSelect.setChecked(false);
            editTextPase1.setVisibility(View.INVISIBLE);
            editTextPase2.setVisibility(View.INVISIBLE);
        }

    }

    private void ponerTamañoLetra(){

        LetraTamaño letraTamaño=new LetraTamaño(this);

        int tamañoLetra=letraTamaño.getTamaño();

        switch (tamañoLetra){
            case 0:{
                cantDpuntos.setTextSize(letraTamaño.getOpcionesPequeño()[1]);
                idEditarCantPtos.setTextSize(letraTamaño.getOpcionesPequeño()[2]);
                idTextViewJugarCpases.setTextSize(letraTamaño.getOpcionesPequeño()[5]);
                editTextPase1.setTextSize(letraTamaño.getOpcionesPequeño()[6]);
                editTextPase2.setTextSize(letraTamaño.getOpcionesPequeño()[6]);
                idBtnAplicar.setTextSize(letraTamaño.getOpcionesPequeño()[7]);
                idBtnCancelar.setTextSize(letraTamaño.getOpcionesPequeño()[7]);
                break;
            }
            case 1:{
                cantDpuntos.setTextSize(letraTamaño.getOpcionesMediano()[1]);
                idEditarCantPtos.setTextSize(letraTamaño.getOpcionesMediano()[2]);
                idTextViewJugarCpases.setTextSize(letraTamaño.getOpcionesMediano()[5]);
                editTextPase1.setTextSize(letraTamaño.getOpcionesMediano()[6]);
                editTextPase2.setTextSize(letraTamaño.getOpcionesMediano()[6]);
                idBtnAplicar.setTextSize(letraTamaño.getOpcionesMediano()[7]);
                idBtnCancelar.setTextSize(letraTamaño.getOpcionesMediano()[7]);
                break;
            }
            case 2:{
                cantDpuntos.setTextSize(letraTamaño.getOpcionesGrande()[1]);
                idEditarCantPtos.setTextSize(letraTamaño.getOpcionesGrande()[2]);
                idTextViewJugarCpases.setTextSize(letraTamaño.getOpcionesGrande()[5]);
                editTextPase1.setTextSize(letraTamaño.getOpcionesGrande()[6]);
                editTextPase2.setTextSize(letraTamaño.getOpcionesGrande()[6]);
                idBtnAplicar.setTextSize(letraTamaño.getOpcionesGrande()[7]);
                idBtnCancelar.setTextSize(letraTamaño.getOpcionesGrande()[7]);
                break;
            }
        }
    }


    public void visibilidadJugarConPases(View view){
        if (checkBoxPasesSelect.isChecked()){
            editTextPase1.setVisibility(View.VISIBLE);
            editTextPase2.setVisibility(View.VISIBLE);
            editTextPase1.requestFocus();
        }else {
            //checkBoxPasesSelect.setBackgroundResource(R.drawable.select);
            editTextPase1.setVisibility(View.INVISIBLE);
            editTextPase2.setVisibility(View.INVISIBLE);
        }
    }


    /**ESTO SE AÑADE CDO PONGA APLICAR*/
    public void añadirPasesPtosFinalesCantidad(View view){

        datosDlaPartida.borrarPuntos();
        datosDlaPartida.guardarPuntos();

            if (idEditarCantPtos.getText().length()!=0){
                datosDlaPartida.setCantidadPtosPartido(Integer.parseInt(idEditarCantPtos.getText().toString()));
            }
            if (checkBoxPasesSelect.isChecked()){
                datosDlaPartida.setJuegoConPases(true);

                if (editTextPase1.getText().length()!=0){
                    datosDlaPartida.setPtosPrimerPase(Integer.parseInt(editTextPase1.getText().toString()));
                }
                if (editTextPase2.getText().length()!=0) {
                    datosDlaPartida.setPtosSegundoPase(Integer.parseInt(editTextPase2.getText().toString()));
                }
            }else {
                datosDlaPartida.setJuegoConPases(false);
            }

        //Toast.makeText(this, ""+datosDlaPartida.getCantidadPtosPartido(), Toast.LENGTH_SHORT).show();

        Boolean actualizo=datosDlaPartida.actualizarPuntos();

        if (actualizo){
            //Toast.makeText(this, "Datos Incertados", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }else {
            Toast.makeText(this, "Datos no incertados", Toast.LENGTH_SHORT).show();
        }


        /**AQUI SE GUARDAN LOS DATOS PA QUE VAYAN PA LA BASE DE DATOS DE LOS DATOS DE PASE Y PUNTOS*/

    }


    public void onBackPressed(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }


}
