package com.example.rudyn.anotar_domino;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.icu.util.TimeZone;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Valia on 14/9/2020.
 */

public class AnotarJuegos extends AppCompatActivity implements View.OnClickListener{


    AlertDialog dialog;

    String ganador;

    EditText editTextE1;
    EditText editTextE2;
    Spinner spinnerE1;
    Spinner spinnerE2;
    CheckBox checkBoxE1;
    CheckBox checkBoxE2;

    Handler mHandler;
    Equipos equipo;

    ArrayList<String> nombresEquipos;

    //PARA GUARDAR LO DEL EQUIPO DE LA 1RA LISTA
    ArrayList<EditText> editTextsPos;
    ArrayList<TextView> textViewsPos;
    ArrayList<TextView> textViewsPosRaya;
    ArrayList<LinearLayout> linearLayoutsPos;

    //PARA GUARDAR LO DEL EQUIPO DE LA 2DA LISTA
    ArrayList<EditText> editTexts1Pos;
    ArrayList<TextView> textViews1Pos;
    ArrayList<TextView> textViews1PosRaya;
    ArrayList<LinearLayout> linearLayouts1Pos;

    //LO DE EL EQUIPO 1
    EditText editTextPos1;
    EditText editTextPos2;
    EditText editTextPos3;
    EditText editTextPos4;
    EditText editTextPos5;
    EditText editTextPos6;
    EditText editTextPos7;
    EditText editTextPos8;
    EditText editTextPos9;
    EditText editTextPos10;
    EditText editTextPos11;
    EditText editTextPos12;

    //LO DEL EQUIPO 2
    EditText editText1Pos1;
    EditText editText1Pos2;
    EditText editText1Pos3;
    EditText editText1Pos4;
    EditText editText1Pos5;
    EditText editText1Pos6;
    EditText editText1Pos7;
    EditText editText1Pos8;
    EditText editText1Pos9;
    EditText editText1Pos10;
    EditText editText1Pos11;
    EditText editText1Pos12;

    //LO DE EL EQUIPO 1
    TextView textViewPos1;
    TextView textViewPos2;
    TextView textViewPos3;
    TextView textViewPos4;
    TextView textViewPos5;
    TextView textViewPos6;
    TextView textViewPos7;
    TextView textViewPos8;
    TextView textViewPos9;
    TextView textViewPos10;
    TextView textViewPos11;
    TextView textViewPos12;

    //LO DE EL EQUIPO 2
    TextView textView1Pos1;
    TextView textView1Pos2;
    TextView textView1Pos3;
    TextView textView1Pos4;
    TextView textView1Pos5;
    TextView textView1Pos6;
    TextView textView1Pos7;
    TextView textView1Pos8;
    TextView textView1Pos9;
    TextView textView1Pos10;
    TextView textView1Pos11;
    TextView textView1Pos12;

    //LO DE EL EQUIPO 1
    TextView textViewPos1Raya;
    TextView textViewPos2Raya;
    TextView textViewPos3Raya;
    TextView textViewPos4Raya;
    TextView textViewPos5Raya;
    TextView textViewPos6Raya;
    TextView textViewPos7Raya;
    TextView textViewPos8Raya;
    TextView textViewPos9Raya;
    TextView textViewPos10Raya;
    TextView textViewPos11Raya;
    TextView textViewPos12Raya;

    //LO DE EL EQUIPO 2
    TextView textView1Pos1Raya;
    TextView textView1Pos2Raya;
    TextView textView1Pos3Raya;
    TextView textView1Pos4Raya;
    TextView textView1Pos5Raya;
    TextView textView1Pos6Raya;
    TextView textView1Pos7Raya;
    TextView textView1Pos8Raya;
    TextView textView1Pos9Raya;
    TextView textView1Pos10Raya;
    TextView textView1Pos11Raya;
    TextView textView1Pos12Raya;

    //LO DE EL EQUIPO 1
    LinearLayout linearLayoutPos2;
    LinearLayout linearLayoutPos3;
    LinearLayout linearLayoutPos4;
    LinearLayout linearLayoutPos5;
    LinearLayout linearLayoutPos6;
    LinearLayout linearLayoutPos7;
    LinearLayout linearLayoutPos8;
    LinearLayout linearLayoutPos9;
    LinearLayout linearLayoutPos10;
    LinearLayout linearLayoutPos11;
    LinearLayout linearLayoutPos12;

    //LO DE EL EQUIPO 2
    LinearLayout linearLayout1Pos2;
    LinearLayout linearLayout1Pos3;
    LinearLayout linearLayout1Pos4;
    LinearLayout linearLayout1Pos5;
    LinearLayout linearLayout1Pos6;
    LinearLayout linearLayout1Pos7;
    LinearLayout linearLayout1Pos8;
    LinearLayout linearLayout1Pos9;
    LinearLayout linearLayout1Pos10;
    LinearLayout linearLayout1Pos11;
    LinearLayout linearLayout1Pos12;

    Button idBton1P10;
    Button idBton1P20;

    int pase11=10;
    int pase12=20;
    int pase21=10;
    int pase22=20;

    int selectedListEquipo1=0;
    int selectedListEquipo2=0;

    ArrayList<Integer> listaPases1;
    ArrayList<Integer> listaPases1Pos;

    ArrayList<Integer> listaPases2;
    ArrayList<Integer> listaPases2Pos;

    DatosDlaPartida datosDlaPartida;

    CargarJuegos cargarJuegos;

    TextInputLayout inputA;
    TextInputLayout inputA1;

    boolean verificar = true;
    String font_path;
    Typeface TF;
    EquiposAdapter adapter1;
    LetraTamaño letraTamaño;
    int tipoDeJuego=-1;


    ArrayList <String> todo=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anotar_juegos);

        font_path = "font/letra.TTF";

        TF = Typeface.createFromAsset(getAssets(), font_path);

        cargarJuegos=new CargarJuegos(this);

        editTextE1=(EditText)findViewById(R.id.editTextEquipo1);
        editTextE2=(EditText)findViewById(R.id.editTextEquipo2);


        spinnerE1=(Spinner)findViewById(R.id.spinnerEquipo1);
        spinnerE2=(Spinner)findViewById(R.id.spinnerEquipo2);


        checkBoxE1=(CheckBox) findViewById(R.id.checkBoxEquipo1);
        checkBoxE2=(CheckBox) findViewById(R.id.checkBoxEquipo2);

        editTextE1.setTypeface(TF);
        editTextE2.setTypeface(TF);

        inputA=(TextInputLayout)findViewById(R.id.inputA);
        inputA1=(TextInputLayout)findViewById(R.id.inputA1);

        idBton1P10=(Button)findViewById(R.id.idBton1P10);
        idBton1P20=(Button)findViewById(R.id.idBton1P20);

        idBton1P10.setTypeface(TF);
        idBton1P20.setTypeface(TF);

        idBton1P10.setOnClickListener(this);
        idBton1P20.setOnClickListener(this);

        mHandler = new Handler();

        equipo=new Equipos(getResources().getString(R.string.equipo_1),getResources().getString(R.string.equipo_2),this);


        nombresEquipos=new ArrayList<>();
        nombresEquipos=equipo.getNombresJ1();

        datosDlaPartida=new DatosDlaPartida(this);
        datosDlaPartida.cargarPuntos();

        listaPases1=new ArrayList<>();
        listaPases1Pos=new ArrayList<>();

        listaPases2=new ArrayList<>();
        listaPases2Pos=new ArrayList<>();

        letraTamaño=new LetraTamaño(this);

        iniciarDatosEditTexts();
        iniciarDatosTextViews();
        iniciarDatosTextViewsRaya();
        iniciarDatosLinearLayouts();

        for (int i =0; i<editTextsPos.size();i++){

            editTextsPos.get(i).setTypeface(TF);
            editTexts1Pos.get(i).setTypeface(TF);

            textViewsPos.get(i).setTypeface(TF);
            textViews1Pos.get(i).setTypeface(TF);

            textViewsPosRaya.get(i).setTypeface(TF);
            textViews1PosRaya.get(i).setTypeface(TF);

        }

        actualizarSoloListas();
        actualizarDiferenteSpinner();

        actualizarPaseOno();

        Bundle datos = getIntent().getExtras();
        Boolean continuar=datos.getBoolean("CONTINUAR");
        String nombre=datos.getString("NOMBRE");
        int puntos=datos.getInt("PUNTOS");


        if (nombre!=null && puntos!=0){
            continuar(nombre,puntos);
        }


        continuarOno(continuar);

            switch (readFiles1(this)){
                case -1:{
                    tipoDeJuego=0;
                    break;
                }
                case 0:{
                    tipoDeJuego=0;
                 break;
                }
                case 1:{
                    tipoDeJuego=1;
                    break;
                }
            }

    }

    @Override
    protected void onStart() {

        ponerTamañoLetra();
        super.onStart();
    }

    private void ponerTamañoLetra(){

        //PONER TAMAÑO DE LETRA
        int tamañoLetra=letraTamaño.getTamaño();

        switch (tamañoLetra){
            case 0:{

                for (int i=0; i<textViewsPos.size();i++){
                    editTextsPos.get(i).setTextSize(letraTamaño.getAnotarPequeño()[0]);
                    editTexts1Pos.get(i).setTextSize(letraTamaño.getAnotarPequeño()[0]);

                    textViewsPosRaya.get(i).setTextSize(letraTamaño.getAnotarPequeño()[1]);
                    textViews1PosRaya.get(i).setTextSize(letraTamaño.getAnotarPequeño()[1]);

                    textViewsPos.get(i).setTextSize(letraTamaño.getAnotarPequeño()[2]);
                    textViews1Pos.get(i).setTextSize(letraTamaño.getAnotarPequeño()[2]);
                }

                idBton1P10.setTextSize(letraTamaño.getAnotarPequeño()[3]);
                idBton1P20.setTextSize(letraTamaño.getAnotarPequeño()[3]);

                editTextE1.setTextSize(letraTamaño.getAnotarPequeño()[4]);
                editTextE2.setTextSize(letraTamaño.getAnotarPequeño()[4]);

                break;
            }
            case 1:{
                for (int i=0; i<textViewsPos.size();i++){
                    editTextsPos.get(i).setTextSize(letraTamaño.getAnotarMediano()[0]);
                    editTexts1Pos.get(i).setTextSize(letraTamaño.getAnotarMediano()[0]);

                    textViewsPosRaya.get(i).setTextSize(letraTamaño.getAnotarMediano()[1]);
                    textViews1PosRaya.get(i).setTextSize(letraTamaño.getAnotarMediano()[1]);

                    textViewsPos.get(i).setTextSize(letraTamaño.getAnotarMediano()[2]);
                    textViews1Pos.get(i).setTextSize(letraTamaño.getAnotarMediano()[2]);
                }

                idBton1P10.setTextSize(letraTamaño.getAnotarMediano()[3]);
                idBton1P20.setTextSize(letraTamaño.getAnotarMediano()[3]);

                editTextE1.setTextSize(letraTamaño.getAnotarMediano()[4]);
                editTextE2.setTextSize(letraTamaño.getAnotarMediano()[4]);

                break;
            }
            case 2:{
                for (int i=0; i<textViewsPos.size();i++){
                    editTextsPos.get(i).setTextSize(letraTamaño.getAnotarGrande()[0]);
                    editTexts1Pos.get(i).setTextSize(letraTamaño.getAnotarGrande()[0]);

                    textViewsPosRaya.get(i).setTextSize(letraTamaño.getAnotarGrande()[1]);
                    textViews1PosRaya.get(i).setTextSize(letraTamaño.getAnotarGrande()[1]);

                    textViewsPos.get(i).setTextSize(letraTamaño.getAnotarGrande()[2]);
                    textViews1Pos.get(i).setTextSize(letraTamaño.getAnotarGrande()[2]);
                }

                idBton1P10.setTextSize(letraTamaño.getAnotarGrande()[3]);
                idBton1P20.setTextSize(letraTamaño.getAnotarGrande()[3]);

                editTextE1.setTextSize(letraTamaño.getAnotarGrande()[4]);
                editTextE2.setTextSize(letraTamaño.getAnotarGrande()[4]);

                break;
            }
        }

    }

    public void seleccionCheckBox1(View view){

        if (checkBoxE1.isChecked()){
            spinnerE1.setVisibility(View.INVISIBLE);
            inputA.setVisibility(View.VISIBLE);
            editTextE1.requestFocus();
        }else {

            spinnerE1.setVisibility(View.VISIBLE);

            inputA.setVisibility(View.INVISIBLE);
           if (editTextE1.getText().length()!=0){
               nombresEquipos=equipo.añadirEquipo(editTextE1.getText().toString());
               editTextE1.setText("");
               actualizarListasConPos(true);
           }else{
               Toast.makeText(this, ""+getString(R.string.noEscribioNombre), Toast.LENGTH_SHORT).show();
           }
        }
    }

    public void seleccionCheckBox2(View view){

        if (checkBoxE2.isChecked()){
            spinnerE2.setVisibility(View.INVISIBLE);
            inputA1.setVisibility(View.VISIBLE);
            editTextE2.requestFocus();
        }else {
            spinnerE2.setVisibility(View.VISIBLE);
            inputA1.setVisibility(View.INVISIBLE);

            if (editTextE2.getText().length()!=0){
                nombresEquipos=equipo.añadirEquipo(editTextE2.getText().toString());
                editTextE2.setText("");
                actualizarListasConPos(false);
            }else {
                Toast.makeText(this, ""+getString(R.string.noEscribioNombre), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void actualizarSoloListas(){

        adapter1 = new EquiposAdapter(getApplicationContext(),nombresEquipos, TF);
        spinnerE1.setAdapter(adapter1);
        spinnerE2.setAdapter(adapter1);

    }

    private void actualizarListasConPos(boolean primero){
        /*ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,nombresEquipos);
        spinnerE1.setAdapter(adapter1);
        spinnerE2.setAdapter(adapter1);*/

        actualizarSoloListas();

        if (primero){
            spinnerE1.setSelection(equipo.getPosicion());
        }else {
            spinnerE2.setSelection(equipo.getPosicion());
        }

    }

    private void continuarOno(boolean continuar){
        if (continuar){
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

            checkBoxE1.performClick();
            editTextE1.setText(todo.get(0));

            checkBoxE2.performClick();
            editTextE2.setText(todo.get(1));

            editTextsPos.get(0).setText(todo.get(2));
            editTexts1Pos.get(0).setText(todo.get(3));

            entro=false;
        }
    }

    private void continuar(String nombre, int puntos){

            checkBoxE1.performClick();
            editTextE1.setText(nombre);
            checkBoxE1.performClick();

            editTextsPos.get(0).setText(""+puntos);
    }

    private void actualizarPaseOno(){
        /**SALE O NO LOS PASES*/
        if (datosDlaPartida.isJuegoConPases()){
            idBton1P10.setVisibility(View.VISIBLE);
            idBton1P20.setVisibility(View.VISIBLE);

            pase11=datosDlaPartida.getPtosPrimerPase();
            pase12=datosDlaPartida.getPtosSegundoPase();
            pase21=datosDlaPartida.getPtosPrimerPase();
            pase22=datosDlaPartida.getPtosSegundoPase();

            //PARA QUE LO SAQUE COMO TEXTO
            idBton1P10.setText(pase11+"");
            idBton1P20.setText(pase12+"");

        }else {
            idBton1P10.setVisibility(View.INVISIBLE);
            idBton1P20.setVisibility(View.INVISIBLE);
        }
    }

    boolean entro=true;

    public void actualizarDiferenteSpinner(){
        mHandler.postDelayed(mUpdateTimeTask,100);
    }

    private Runnable mUpdateTimeTask = new Runnable() {
        @Override
        public void run() {
            diferenteSeleccion();
            sumarDatosEquipo1();

            sumarDatosEquipo2();

            if (entro){
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextPos1.getWindowToken(),0);
            }

            /**ESTO PONER QUE LO REVISE CDO ANOTE EN EL MISMO QUE ANOTO*/
            if (verificar){
                verificarPuntos(true);
            }


            mHandler.postDelayed(this,100);
        }
    };

    public void diferenteSeleccion(){
        if(spinnerE1.getSelectedItemPosition()==spinnerE2.getSelectedItemPosition()){
            int aleatorio=(int) (Math.random() * nombresEquipos.size());

            while(aleatorio==spinnerE1.getSelectedItemPosition()){
                aleatorio=(int) (Math.random() * nombresEquipos.size());
            }
            spinnerE2.setSelection(aleatorio);
        }
    }


    private void iniciarDatosEditTexts(){
        //EQUIPO 1
        editTextsPos=new ArrayList<>();
        //EQUIPO 2
        editTexts1Pos=new ArrayList<>();

        //EQUIPO 1
         editTextPos1=(EditText) findViewById(R.id.editTextPtos1);
         editTextPos2=(EditText) findViewById(R.id.editTextPtos2);
         editTextPos3=(EditText) findViewById(R.id.editTextPtos3);
         editTextPos4=(EditText) findViewById(R.id.editTextPtos4);
         editTextPos5=(EditText) findViewById(R.id.editTextPtos5);
         editTextPos6=(EditText) findViewById(R.id.editTextPtos6);
         editTextPos7=(EditText) findViewById(R.id.editTextPtos7);
         editTextPos8=(EditText) findViewById(R.id.editTextPtos8);
         editTextPos9=(EditText) findViewById(R.id.editTextPtos9);
         editTextPos10=(EditText) findViewById(R.id.editTextPtos10);
         editTextPos11=(EditText) findViewById(R.id.editTextPtos11);
         editTextPos12=(EditText) findViewById(R.id.editTextPtos12);

        //EQUIPO 2
        editText1Pos1=(EditText) findViewById(R.id.editText1Ptos1);
        editText1Pos2=(EditText) findViewById(R.id.editText1Ptos2);
        editText1Pos3=(EditText) findViewById(R.id.editText1Ptos3);
        editText1Pos4=(EditText) findViewById(R.id.editText1Ptos4);
        editText1Pos5=(EditText) findViewById(R.id.editText1Ptos5);
        editText1Pos6=(EditText) findViewById(R.id.editText1Ptos6);
        editText1Pos7=(EditText) findViewById(R.id.editText1Ptos7);
        editText1Pos8=(EditText) findViewById(R.id.editText1Ptos8);
        editText1Pos9=(EditText) findViewById(R.id.editText1Ptos9);
        editText1Pos10=(EditText) findViewById(R.id.editText1Ptos10);
        editText1Pos11=(EditText) findViewById(R.id.editText1Ptos11);
        editText1Pos12=(EditText) findViewById(R.id.editText1Ptos12);

        //EQUIPO 1
        editTextsPos.add(editTextPos1);
        editTextsPos.add(editTextPos2);
        editTextsPos.add(editTextPos3);
        editTextsPos.add(editTextPos4);
        editTextsPos.add(editTextPos5);
        editTextsPos.add(editTextPos6);
        editTextsPos.add(editTextPos7);
        editTextsPos.add(editTextPos8);
        editTextsPos.add(editTextPos9);
        editTextsPos.add(editTextPos10);
        editTextsPos.add(editTextPos11);
        editTextsPos.add(editTextPos12);

        //EQUIPO 2
        editTexts1Pos.add(editText1Pos1);
        editTexts1Pos.add(editText1Pos2);
        editTexts1Pos.add(editText1Pos3);
        editTexts1Pos.add(editText1Pos4);
        editTexts1Pos.add(editText1Pos5);
        editTexts1Pos.add(editText1Pos6);
        editTexts1Pos.add(editText1Pos7);
        editTexts1Pos.add(editText1Pos8);
        editTexts1Pos.add(editText1Pos9);
        editTexts1Pos.add(editText1Pos10);
        editTexts1Pos.add(editText1Pos11);
        editTexts1Pos.add(editText1Pos12);


    }

    private void iniciarDatosTextViews(){
        //EQUIPO 1
        textViewsPos=new ArrayList<>();

        //EQUIPO 2
        textViews1Pos=new ArrayList<>();

        //EQUIPO 1
        textViewPos1=(TextView) findViewById(R.id.textViewPos1);
        textViewPos2=(TextView) findViewById(R.id.textViewPos2);
        textViewPos3=(TextView) findViewById(R.id.textViewPos3);
        textViewPos4=(TextView) findViewById(R.id.textViewPos4);
        textViewPos5=(TextView) findViewById(R.id.textViewPos5);
        textViewPos6=(TextView) findViewById(R.id.textViewPos6);
        textViewPos7=(TextView) findViewById(R.id.textViewPos7);
        textViewPos8=(TextView) findViewById(R.id.textViewPos8);
        textViewPos9=(TextView) findViewById(R.id.textViewPos9);
        textViewPos10=(TextView) findViewById(R.id.textViewPos10);
        textViewPos11=(TextView) findViewById(R.id.textViewPos11);
        textViewPos12=(TextView) findViewById(R.id.textViewPos12);

        //EQUIPO 2
        textView1Pos1=(TextView) findViewById(R.id.textView1Pos1);
        textView1Pos2=(TextView) findViewById(R.id.textView1Pos2);
        textView1Pos3=(TextView) findViewById(R.id.textView1Pos3);
        textView1Pos4=(TextView) findViewById(R.id.textView1Pos4);
        textView1Pos5=(TextView) findViewById(R.id.textView1Pos5);
        textView1Pos6=(TextView) findViewById(R.id.textView1Pos6);
        textView1Pos7=(TextView) findViewById(R.id.textView1Pos7);
        textView1Pos8=(TextView) findViewById(R.id.textView1Pos8);
        textView1Pos9=(TextView) findViewById(R.id.textView1Pos9);
        textView1Pos10=(TextView) findViewById(R.id.textView1Pos10);
        textView1Pos11=(TextView) findViewById(R.id.textView1Pos11);
        textView1Pos12=(TextView) findViewById(R.id.textView1Pos12);

        //EQUIPO 1
        textViewsPos.add(textViewPos1);
        textViewsPos.add(textViewPos2);
        textViewsPos.add(textViewPos3);
        textViewsPos.add(textViewPos4);
        textViewsPos.add(textViewPos5);
        textViewsPos.add(textViewPos6);
        textViewsPos.add(textViewPos7);
        textViewsPos.add(textViewPos8);
        textViewsPos.add(textViewPos9);
        textViewsPos.add(textViewPos10);
        textViewsPos.add(textViewPos11);
        textViewsPos.add(textViewPos12);

        //EQUIPO 2
        textViews1Pos.add(textView1Pos1);
        textViews1Pos.add(textView1Pos2);
        textViews1Pos.add(textView1Pos3);
        textViews1Pos.add(textView1Pos4);
        textViews1Pos.add(textView1Pos5);
        textViews1Pos.add(textView1Pos6);
        textViews1Pos.add(textView1Pos7);
        textViews1Pos.add(textView1Pos8);
        textViews1Pos.add(textView1Pos9);
        textViews1Pos.add(textView1Pos10);
        textViews1Pos.add(textView1Pos11);
        textViews1Pos.add(textView1Pos12);

    }

    private void iniciarDatosTextViewsRaya(){
        //EQUIPO 1
        textViewsPosRaya=new ArrayList<>();

        //EQUIPO 2
        textViews1PosRaya=new ArrayList<>();

        //EQUIPO 1
        textViewPos1Raya=(TextView) findViewById(R.id.textView1);
        textViewPos2Raya=(TextView) findViewById(R.id.textView2);
        textViewPos3Raya=(TextView) findViewById(R.id.textView3);
        textViewPos4Raya=(TextView) findViewById(R.id.textView4);
        textViewPos5Raya=(TextView) findViewById(R.id.textView5);
        textViewPos6Raya=(TextView) findViewById(R.id.textView6);
        textViewPos7Raya=(TextView) findViewById(R.id.textView7);
        textViewPos8Raya=(TextView) findViewById(R.id.textView8);
        textViewPos9Raya=(TextView) findViewById(R.id.textView9);
        textViewPos10Raya=(TextView) findViewById(R.id.textView10);
        textViewPos11Raya=(TextView) findViewById(R.id.textView11);
        textViewPos12Raya=(TextView) findViewById(R.id.textView12);

        //EQUIPO 2
        textView1Pos1Raya=(TextView) findViewById(R.id.text1View1);
        textView1Pos2Raya=(TextView) findViewById(R.id.text1View2);
        textView1Pos3Raya=(TextView) findViewById(R.id.text1View3);
        textView1Pos4Raya=(TextView) findViewById(R.id.text1View4);
        textView1Pos5Raya=(TextView) findViewById(R.id.text1View5);
        textView1Pos6Raya=(TextView) findViewById(R.id.text1View6);
        textView1Pos7Raya=(TextView) findViewById(R.id.text1View7);
        textView1Pos8Raya=(TextView) findViewById(R.id.text1View8);
        textView1Pos9Raya=(TextView) findViewById(R.id.text1View9);
        textView1Pos10Raya=(TextView) findViewById(R.id.text1View10);
        textView1Pos11Raya=(TextView) findViewById(R.id.text1View11);
        textView1Pos12Raya=(TextView) findViewById(R.id.text1View12);

        //EQUIPO 1
        textViewsPosRaya.add(textViewPos1Raya);
        textViewsPosRaya.add(textViewPos2Raya);
        textViewsPosRaya.add(textViewPos3Raya);
        textViewsPosRaya.add(textViewPos4Raya);
        textViewsPosRaya.add(textViewPos5Raya);
        textViewsPosRaya.add(textViewPos6Raya);
        textViewsPosRaya.add(textViewPos7Raya);
        textViewsPosRaya.add(textViewPos8Raya);
        textViewsPosRaya.add(textViewPos9Raya);
        textViewsPosRaya.add(textViewPos10Raya);
        textViewsPosRaya.add(textViewPos11Raya);
        textViewsPosRaya.add(textViewPos12Raya);

        //EQUIPO 2
        textViews1PosRaya.add(textView1Pos1Raya);
        textViews1PosRaya.add(textView1Pos2Raya);
        textViews1PosRaya.add(textView1Pos3Raya);
        textViews1PosRaya.add(textView1Pos4Raya);
        textViews1PosRaya.add(textView1Pos5Raya);
        textViews1PosRaya.add(textView1Pos6Raya);
        textViews1PosRaya.add(textView1Pos7Raya);
        textViews1PosRaya.add(textView1Pos8Raya);
        textViews1PosRaya.add(textView1Pos9Raya);
        textViews1PosRaya.add(textView1Pos10Raya);
        textViews1PosRaya.add(textView1Pos11Raya);
        textViews1PosRaya.add(textView1Pos12Raya);

    }


    private void iniciarDatosLinearLayouts(){
        //EQUIPO 1
        linearLayoutsPos=new ArrayList<>();

        //EQUIPO 2
        linearLayouts1Pos=new ArrayList<>();

        //EQUIPO 1
        linearLayoutPos2=(LinearLayout) findViewById(R.id.LinearLayoutPos2);
        linearLayoutPos3=(LinearLayout) findViewById(R.id.LinearLayoutPos3);
        linearLayoutPos4=(LinearLayout) findViewById(R.id.LinearLayoutPos4);
        linearLayoutPos5=(LinearLayout) findViewById(R.id.LinearLayoutPos5);
        linearLayoutPos6=(LinearLayout) findViewById(R.id.LinearLayoutPos6);
        linearLayoutPos7=(LinearLayout) findViewById(R.id.LinearLayoutPos7);
        linearLayoutPos8=(LinearLayout) findViewById(R.id.LinearLayoutPos8);
        linearLayoutPos9=(LinearLayout) findViewById(R.id.LinearLayoutPos9);
        linearLayoutPos10=(LinearLayout) findViewById(R.id.LinearLayoutPos10);
        linearLayoutPos11=(LinearLayout) findViewById(R.id.LinearLayoutPos11);
        linearLayoutPos12=(LinearLayout) findViewById(R.id.LinearLayoutPos12);

        //EQUIPO 2
        linearLayout1Pos2=(LinearLayout) findViewById(R.id.LinearLayout1Pos2);
        linearLayout1Pos3=(LinearLayout) findViewById(R.id.LinearLayout1Pos3);
        linearLayout1Pos4=(LinearLayout) findViewById(R.id.LinearLayout1Pos4);
        linearLayout1Pos5=(LinearLayout) findViewById(R.id.LinearLayout1Pos5);
        linearLayout1Pos6=(LinearLayout) findViewById(R.id.LinearLayout1Pos6);
        linearLayout1Pos7=(LinearLayout) findViewById(R.id.LinearLayout1Pos7);
        linearLayout1Pos8=(LinearLayout) findViewById(R.id.LinearLayout1Pos8);
        linearLayout1Pos9=(LinearLayout) findViewById(R.id.LinearLayout1Pos9);
        linearLayout1Pos10=(LinearLayout) findViewById(R.id.LinearLayout1Pos10);
        linearLayout1Pos11=(LinearLayout) findViewById(R.id.LinearLayout1Pos11);
        linearLayout1Pos12=(LinearLayout) findViewById(R.id.LinearLayout1Pos12);

        //EQUIPO 1
        linearLayoutsPos.add(linearLayoutPos2);
        linearLayoutsPos.add(linearLayoutPos3);
        linearLayoutsPos.add(linearLayoutPos4);
        linearLayoutsPos.add(linearLayoutPos5);
        linearLayoutsPos.add(linearLayoutPos6);
        linearLayoutsPos.add(linearLayoutPos7);
        linearLayoutsPos.add(linearLayoutPos8);
        linearLayoutsPos.add(linearLayoutPos9);
        linearLayoutsPos.add(linearLayoutPos10);
        linearLayoutsPos.add(linearLayoutPos11);
        linearLayoutsPos.add(linearLayoutPos12);

        //EQUIPO 2
        linearLayouts1Pos.add(linearLayout1Pos2);
        linearLayouts1Pos.add(linearLayout1Pos3);
        linearLayouts1Pos.add(linearLayout1Pos4);
        linearLayouts1Pos.add(linearLayout1Pos5);
        linearLayouts1Pos.add(linearLayout1Pos6);
        linearLayouts1Pos.add(linearLayout1Pos7);
        linearLayouts1Pos.add(linearLayout1Pos8);
        linearLayouts1Pos.add(linearLayout1Pos9);
        linearLayouts1Pos.add(linearLayout1Pos10);
        linearLayouts1Pos.add(linearLayout1Pos11);
        linearLayouts1Pos.add(linearLayout1Pos12);

    }

    int posSiguientePase1=-1;
    int posSiguientePase2=-1;


    private void sumarDatosEquipo1(){

        /**TOMA EL QUE ESTE SELECCIONADO*/
        for (int a=0;a<editTextsPos.size();a++){
            if (editTextsPos.get(a).isInputMethodTarget()){
                selectedListEquipo1=a;
            }
        }
        /**QUE NO PUEDAS HACER NADA EN LOS QUE ESTAN DELANTE D EL SI TIENE VALORES*/
        if (!editTextsPos.get(selectedListEquipo1).getText().toString().isEmpty()){
            for (int b=0;b<selectedListEquipo1;b++){
                editTextsPos.get(b).setEnabled(false);
            }
        }
        /**QUE NO PUEDAS HACER NADA EN LOS QUE ESTAN DELANTE D EL EXCEPTO EL ANTERIOR PQ ESTA VACIO*/
        if (selectedListEquipo1!=0){
            editTextsPos.get(selectedListEquipo1-1).setEnabled(true);
        }
        /**QUE NO SE MUESTREN O SI LOS LINEAR LAYOUT*/
            int c=selectedListEquipo1;
        if (c!=editTextsPos.size()-1){

            if (editTextsPos.get(c).getText().toString().isEmpty()){
                linearLayoutsPos.get(c).setVisibility(View.INVISIBLE);
            }else{
                linearLayoutsPos.get(c).setVisibility(View.VISIBLE);
            }
        }

        /**PARA SUMAR LOS VALORES Y LOS PASES*/

        //SI ES LA PRIMERA POSICION HACE ESTO////////////////////////////////////////////////

        //si esta en la primera posicion es igual lo q escribe a lo que se ve
        if (selectedListEquipo1==0){

            //para sabe si la primera posicion esta en la lista o no
            boolean ent=false;
            //para sumar los pases que hay en esa posicion
            int sumar=0;
            //recorrer los pases
            for (int a=0;a<listaPases1.size();a++){
                //saber si la posicion primera tiene algun pase
                    if (listaPases1Pos.get(a)==0){
                        //suma los pases que haya
                        sumar=sumar+listaPases1.get(a);
                        //puede entrar a las opcion cdo esta en la lista
                        ent=true;
                    }
            }
            //si tenia posiciones en la lista entra aqui
            if (ent){
                //si esta vacia la posicion
                if (editTextsPos.get(selectedListEquipo1).getText().toString().isEmpty()){
                    //si tiene pase se lo suma a la salida
                    textViewsPos.get(selectedListEquipo1).setText(sumar+"");
                }else{
                    //si tiene pase y no esta vacio se lo suma a lo q haya
                    textViewsPos.get(selectedListEquipo1).setText((Integer.parseInt(editTextsPos.get(selectedListEquipo1).getText().toString())
                            +sumar)+"");
                }
                //si no tiene pases le pone los valores de dond escribes
            }else {
                textViewsPos.get(selectedListEquipo1).setText(editTextsPos.get(selectedListEquipo1).getText().toString()+"");
            }
        }else {
            //SI NO ES LA PRIMERA POSICION HACE ESTO/////////////////////////////////////////////////

            //para sabe si la primera posicion esta en la lista o no
            boolean ent=false;
            //para sumar los pases que hay en esa posicion
            int sumar=0;
            //recorrer los pases
            for (int a=0;a<listaPases1.size();a++){
                //saber si la posicion primera tiene algun pase
                if (listaPases1Pos.get(a)==selectedListEquipo1){
                    //suma los pases que haya
                    sumar=sumar+listaPases1.get(a);
                    //puede entrar a las opcion cdo esta en la lista
                    ent=true;
                }
            }
            if (ent){
                //Si entra en la lista de los pases

                //sino, si esta vacio escribe vacio mas el pase que haya en esa posicion
                if (editTextsPos.get(selectedListEquipo1).getText().toString().isEmpty()){
                    textViewsPos.get(selectedListEquipo1).setText((sumar)+"");
                    //sino suma los valores
                }else {
                    textViewsPos.get(selectedListEquipo1).setText((sumar+Integer.parseInt(editTextsPos.get(selectedListEquipo1).getText().toString()) +
                            Integer.parseInt(textViewsPos.get(selectedListEquipo1-1).getText().toString()))+"");
                }
            }else {
                //Si no entra en la lista de los pases lo hace como estaba

                //sino, si esta vacio escribe vacio
                if (editTextsPos.get(selectedListEquipo1).getText().toString().isEmpty()){
                    textViewsPos.get(selectedListEquipo1).setText("");
                    //sino suma los valores
                }else {
                    textViewsPos.get(selectedListEquipo1).setText((Integer.parseInt(editTextsPos.get(selectedListEquipo1).getText().toString()) +
                            Integer.parseInt(textViewsPos.get(selectedListEquipo1-1).getText().toString()))+"");
                }

            }
        }
        }

    private void sumarDatosEquipo2(){

        /**TOMA EL QUE ESTE SELECCIONADO*/
        for (int a=0;a<editTexts1Pos.size();a++){
            if (editTexts1Pos.get(a).isInputMethodTarget()){
                selectedListEquipo2=a;
            }
        }
        /**QUE NO PUEDAS HACER NADA EN LOS QUE ESTAN DELANTE D EL SI TIENE VALORES*/
        if (!editTexts1Pos.get(selectedListEquipo2).getText().toString().isEmpty()){
            for (int b=0;b<selectedListEquipo2;b++){
                editTexts1Pos.get(b).setEnabled(false);
            }

        }
        /**QUE NO PUEDAS HACER NADA EN LOS QUE ESTAN DELANTE D EL EXCEPTO EL ANTERIOR PQ ESTA VACIO*/
        if (selectedListEquipo2!=0){
            editTexts1Pos.get(selectedListEquipo2-1).setEnabled(true);

        }
        /**QUE NO SE MUESTREN O SI LOS LINEAR LAYOUT*/
        int c=selectedListEquipo2;
        if (c!=editTexts1Pos.size()-1){

            if (editTexts1Pos.get(c).getText().toString().isEmpty()){
                linearLayouts1Pos.get(c).setVisibility(View.INVISIBLE);
            }else{
                linearLayouts1Pos.get(c).setVisibility(View.VISIBLE);
            }
        }


        /**PARA SUMAR LOS VALORES Y LOS PASES*/

        //SI ES LA PRIMERA POSICION HACE ESTO////////////////////////////////////////////////

        //si esta en la primera posicion es igual lo q escribe a lo que se ve
        if (selectedListEquipo2==0){

            //para sabe si la primera posicion esta en la lista o no
            boolean ent=false;
            //para sumar los pases que hay en esa posicion
            int sumar=0;
            //recorrer los pases
            for (int a=0;a<listaPases2.size();a++){
                //saber si la posicion primera tiene algun pase
                if (listaPases2Pos.get(a)==0){
                    //suma los pases que haya
                    sumar=sumar+listaPases2.get(a);
                    //puede entrar a las opcion cdo esta en la lista
                    ent=true;
                }
            }
            //si tenia posiciones en la lista entra aqui
            if (ent){
                //si esta vacia la posicion
                if (editTexts1Pos.get(selectedListEquipo2).getText().toString().isEmpty()){
                    //si tiene pase se lo suma a la salida
                    textViews1Pos.get(selectedListEquipo2).setText(sumar+"");
                }else{
                    //si tiene pase y no esta vacio se lo suma a lo q haya
                    textViews1Pos.get(selectedListEquipo2).setText((Integer.parseInt(editTexts1Pos.get(selectedListEquipo2).getText().toString())
                            +sumar)+"");
                }
                //si no tiene pases le pone los valores de dond escribes
            }else {
                textViews1Pos.get(selectedListEquipo2).setText(editTexts1Pos.get(selectedListEquipo2).getText().toString()+"");
            }
        }else {
            //SI NO ES LA PRIMERA POSICION HACE ESTO/////////////////////////////////////////////////

            //para sabe si la primera posicion esta en la lista o no
            boolean ent=false;
            //para sumar los pases que hay en esa posicion
            int sumar=0;
            //recorrer los pases
            for (int a=0;a<listaPases2.size();a++){
                //saber si la posicion primera tiene algun pase
                if (listaPases2Pos.get(a)==selectedListEquipo2){
                    //suma los pases que haya
                    sumar=sumar+listaPases2.get(a);
                    //puede entrar a las opcion cdo esta en la lista
                    ent=true;
                }
            }
            if (ent){
                //Si entra en la lista de los pases

                //sino, si esta vacio escribe vacio mas el pase que haya en esa posicion
                if (editTexts1Pos.get(selectedListEquipo2).getText().toString().isEmpty()){
                    textViews1Pos.get(selectedListEquipo2).setText((sumar)+"");
                    //sino suma los valores
                }else {
                    textViews1Pos.get(selectedListEquipo2).setText((sumar+Integer.parseInt(editTexts1Pos.get(selectedListEquipo2).getText().toString()) +
                            Integer.parseInt(textViews1Pos.get(selectedListEquipo2-1).getText().toString()))+"");
                }
            }else {
                //Si no entra en la lista de los pases lo hace como estaba

                //sino, si esta vacio escribe vacio
                if (editTexts1Pos.get(selectedListEquipo2).getText().toString().isEmpty()){
                    textViews1Pos.get(selectedListEquipo2).setText("");
                    //sino suma los valores
                }else {
                    textViews1Pos.get(selectedListEquipo2).setText((Integer.parseInt(editTexts1Pos.get(selectedListEquipo2).getText().toString()) +
                            Integer.parseInt(textViews1Pos.get(selectedListEquipo2-1).getText().toString()))+"");
                }

            }
        }
    }

    //Datos para mostrar el dialogo
    int ultimoEditTextE1=-1;
    int ultimoEditTextE2=-1;
    boolean ultimoEditTextIs1;

    String nombreE1;
    String nombreE2;
    String ptosE1="0";
    String ptosE2="0";

    private void verificarPuntos(boolean mostrar_dialog){

        if (checkBoxE1.isChecked()){

            if (editTextE1.getText().toString().equals("")){
                nombreE1=getResources().getString(R.string.equipo_1);
            }else {
                nombreE1=editTextE1.getText().toString();
            }

        }else {
            nombreE1=nombresEquipos.get(spinnerE1.getSelectedItemPosition());
        }

        if (checkBoxE2.isChecked()){

            if (editTextE2.getText().toString().equals("")){
                nombreE2=getResources().getString(R.string.equipo_2);
            }else {
                nombreE2=editTextE2.getText().toString();
            }

        }else {
            nombreE2=nombresEquipos.get(spinnerE2.getSelectedItemPosition());
        }


        /**SALE EL CARTEL PARA EL JUGADOR QUE GANE*/
        for (int a=0;a<textViewsPos.size();a++){
            //Entra aqui si dond escribe los numeros no esta vacio
            if (!textViewsPos.get(a).getText().toString().isEmpty()){

                ptosE1=textViewsPos.get(a).getText().toString();
                ultimoEditTextE1=a;
                //Entra aqui cdo los puntos del juego sean mayor que los puntos del partido
                if (Integer.parseInt(textViewsPos.get(a).getText().toString())>= datosDlaPartida.getCantidadPtosPartido()){
                    //Toast.makeText(this, "Gano el Jugador 1", Toast.LENGTH_SHORT).show();
                    verificar=false;
                    //PARA QUE SALGA CDO GANE EL JUGADOR 1

                    ultimoEditTextE1=a;
                    ultimoEditTextIs1=true;

                    //Crea el dialogo si gana el jugador 1
                    //crearDialogo("E1","E1","E2","100","1");

                    //Toast.makeText(this, ""+crearCadenaPaGuardar(ultimoEditTextE1, ultimoEditTextE2), Toast.LENGTH_SHORT).show();

                    if(editTexts1Pos.get(0).getText().toString().equals("")){
                        ptosE2="0";
                    }

                    //Toast.makeText(this, " "+nombreE1+" "+nombreE2+" "+ptosE1+" "+ptosE2, Toast.LENGTH_SHORT).show();

                    if (mostrar_dialog){
                        crearDialogo(nombreE1,nombreE1,nombreE2,ptosE1,ptosE2);
                    }


                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(textViewsPos.get(ultimoEditTextE1).getWindowToken(),0);

                    //onBackPressed();
                }
            }

            //Entra aqui si dond escribe los numeros no esta vacio
            if (!textViews1Pos.get(a).getText().toString().isEmpty()){

                ptosE2=textViews1Pos.get(a).getText().toString();
                ultimoEditTextE2=a;
                //Entra aqui cdo los puntos del juego sean mayor que los puntos del partido
                if (Integer.parseInt(textViews1Pos.get(a).getText().toString())>= datosDlaPartida.getCantidadPtosPartido()){
                    //Toast.makeText(this, "Gano el Jugador 2", Toast.LENGTH_SHORT).show();
                    verificar=false;
                    //PARA QUE SALGA CDO GANE EL JUGADOR 2

                    ultimoEditTextE2=a;
                    ultimoEditTextIs1=false;

                    //crearCadenaPaGuardar(ultimoEditTextE1, ultimoEditTextE2);

                    //Crea el dialogo si gana el jugador 2
                    //crearDialogo("E2","E1","E2","1","100");

                    if(editTextsPos.get(0).getText().toString().equals("")){
                        ptosE1="0";
                    }

                    if (mostrar_dialog){
                        crearDialogo(nombreE2,nombreE1,nombreE2,ptosE1,ptosE2);
                    }


                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(textViews1Pos.get(ultimoEditTextE2).getWindowToken(),0);



                    //onBackPressed();
                }
            }
        }
    }

    /**MOSTRAR DIALOGO PAL EQUIPO QUE GANO*/

    String nombreGanador="";
    MediaPlayer pollo;

    public void crearDialogo(String ganador, String nombreE1, String nombreE2, String ptos1, String ptos2){

        nombreGanador=ganador;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final View customLayout = getLayoutInflater().inflate(R.layout.custom_layout,null);

        builder.setView(customLayout);

        dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        TextView text=(TextView) dialog.findViewById(R.id.idTextViewGrande);
        TextView text1=(TextView) dialog.findViewById(R.id.idTextViewNombreE1);
        TextView text2=(TextView) dialog.findViewById(R.id.idTextViewNombreE2);
        TextView text3=(TextView) dialog.findViewById(R.id.idTextViewPtosE1);
        TextView text4=(TextView) dialog.findViewById(R.id.idTextViewPtosE2);
        TextView text5=(TextView) dialog.findViewById(R.id.idBtnOk);
        TextView text6=(TextView) dialog.findViewById(R.id.idBtnCancel);
        CheckBox check=(CheckBox) dialog.findViewById(R.id.idCheckBoxContinuarJ);

        ImageView imageView=(ImageView) dialog.findViewById(R.id.imagePolloL);
        ImageView imageView1=(ImageView) dialog.findViewById(R.id.imagePolloL1);


        text.setTypeface(TF);
        text1.setTypeface(TF);
        text2.setTypeface(TF);
        text3.setTypeface(TF);
        text4.setTypeface(TF);
        text5.setTypeface(TF);
        text6.setTypeface(TF);
        check.setTypeface(TF);

        //Cambiar el tamaño de la letra

        int tamañoLetra=letraTamaño.getTamaño();

        switch (tamañoLetra){
            case 0:{
                text.setTextSize(letraTamaño.getCustomPequeño()[0]);
                text1.setTextSize(letraTamaño.getCustomPequeño()[1]);
                text2.setTextSize(letraTamaño.getCustomPequeño()[1]);

                text3.setTextSize(letraTamaño.getCustomPequeño()[2]);
                text4.setTextSize(letraTamaño.getCustomPequeño()[2]);

                text5.setTextSize(letraTamaño.getCustomPequeño()[3]);
                text6.setTextSize(letraTamaño.getCustomPequeño()[3]);

                check.setTextSize(letraTamaño.getCustomPequeño()[2]);
                break;
            }
            case 1:{
                text.setTextSize(letraTamaño.getCustomMediano()[0]);
                text1.setTextSize(letraTamaño.getCustomMediano()[1]);
                text2.setTextSize(letraTamaño.getCustomMediano()[1]);

                text3.setTextSize(letraTamaño.getCustomMediano()[2]);
                text4.setTextSize(letraTamaño.getCustomMediano()[2]);

                text5.setTextSize(letraTamaño.getCustomMediano()[3]);
                text6.setTextSize(letraTamaño.getCustomMediano()[3]);

                check.setTextSize(letraTamaño.getCustomMediano()[2]);
                break;
            }
            case 2:{
                text.setTextSize(letraTamaño.getCustomGrande()[0]);
                text1.setTextSize(letraTamaño.getCustomGrande()[1]);
                text2.setTextSize(letraTamaño.getCustomGrande()[1]);

                text3.setTextSize(letraTamaño.getCustomGrande()[2]);
                text4.setTextSize(letraTamaño.getCustomGrande()[2]);

                text5.setTextSize(letraTamaño.getCustomGrande()[3]);
                text6.setTextSize(letraTamaño.getCustomGrande()[3]);

                check.setTextSize(letraTamaño.getCustomGrande()[2]);
                break;
            }
        }

        switch (tipoDeJuego){
            case 0:{
                check.setVisibility(View.INVISIBLE);
                break;
            }
            case 1:{
                check.setVisibility(View.VISIBLE);
                if (readFilesCheck(this)){
                    aceptado=true;
                    check.setChecked(true);
                }else {
                    aceptado=false;
                    check.setChecked(false);
                }
                break;
            }
        }


        text.setText(getResources().getString(R.string.ha_ganado)+" "+ganador);

        text1.setText(""+nombreE1);
        text2.setText(""+nombreE2);



        if (ptos1.equals("0")){
            imageView.setVisibility(View.VISIBLE);
            text3.setVisibility(View.INVISIBLE);
            pollo = MediaPlayer.create(this,R.raw.chicken1);
            pollo.start();

        }else {
            text3.setVisibility(View.VISIBLE);
            text3.setText(""+ptos1);
            imageView.setVisibility(View.INVISIBLE);
        }

        if (ptos2.equals("0")){
            imageView1.setVisibility(View.VISIBLE);
            text4.setVisibility(View.INVISIBLE);
            pollo = MediaPlayer.create(this,R.raw.chicken2);
            pollo.start();

        }else {
            text4.setVisibility(View.VISIBLE);
            text4.setText(""+ptos2);
            imageView1.setVisibility(View.INVISIBLE);
        }

    }

    boolean aceptado=false;

    public void cambiarChecked(View view){
        if (aceptado){
            aceptado=false;
            saveFilesCheck(view.getContext(),aceptado);
        }else {
            aceptado=true;
            saveFilesCheck(view.getContext(),aceptado);
        }
    }

    /**CREAR LA CADENA A PASAR A LA BASE DE DATOS*/

    public String crearCadenaPaGuardar(int ultimaPosE1, int ultimaPosE2){

        //Toast.makeText(this, ""+ultimaPosE1, Toast.LENGTH_SHORT).show();

        /*******IMPORTANTE****AQUI COGER FECHA DEL SISTEMA****************************/

        String cadena="";

        String date="";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            date = new SimpleDateFormat("dd:MM:yyyy").format(new Date());
        }else {
            date="No:soporta:fecha";
        }

        //AQUI TIENE DOS PUNTOS LA FECHA QUE REPRESENTA QUE CAMBIA

        cadena=cadena+(date+"/");

        cadena=cadena+(nombreE1+"/");

        //Toast.makeText(this, ""+cadena, Toast.LENGTH_SHORT).show();

        if (editTextsPos.get(0).getText().toString().equals("")){
            cadena=cadena+"0/";
        }else {
            for (int y = 0; y <= ultimaPosE1; y++) {
                cadena = cadena + (editTextsPos.get(y).getText().toString() + "-" + textViewsPos.get(y).getText().toString() + "/");
            }
        }
        cadena=cadena+("!");

        cadena=cadena+(nombreE2+"/");

        if (editTexts1Pos.get(0).getText().toString().equals("")){
            cadena=cadena+"0/";
        }else {
            for (int y=0;y<=ultimaPosE2;y++){
                cadena=cadena+(editTexts1Pos.get(y).getText().toString()+"-"+textViews1Pos.get(y).getText().toString()+"/");
            }
        }

        cadena=cadena+("* ");
        return cadena;
    }

    public void ok(View view){
        if (tipoDeJuego==0){
            onBackPressed();
            dialog.cancel();

            cargarJuegos.añadirJuego(crearCadenaPaGuardar(ultimoEditTextE1, ultimoEditTextE2));
            saveFiles(this,nombreE1,nombreE2,ptosE1,ptosE2,false);
            entrarOnStop=false;
        }
        if (tipoDeJuego==1 && !aceptado){
            onBackPressed();
            dialog.cancel();
            cargarJuegos.añadirJuego(crearCadenaPaGuardar(ultimoEditTextE1, ultimoEditTextE2));
            saveFiles(this,nombreE1,nombreE2,ptosE1,ptosE2,false);
            entrarOnStop=false;
        }

        if (tipoDeJuego==1 && aceptado){
            //Toast.makeText(this, "continuo", Toast.LENGTH_SHORT).show();
            //dialog.cancel();
            String nombre="";
            int puntos=-1;
            boolean carga=false;

            if (nombreGanador.equals(nombreE1)){
                nombre=nombreE1;
                puntos=Integer.parseInt(ptosE1)-datosDlaPartida.getCantidadPtosPartido();
                cargarJuegos.añadirJuego(crearCadenaPaGuardar(ultimoEditTextE1, ultimoEditTextE2));

                saveFiles(this,nombreE1,nombreE2,""+puntos,ptosE2,false);
                carga=true;
            }
            if (nombreGanador.equals(nombreE2)){
                nombre=nombreE2;
                puntos=Integer.parseInt(ptosE2)-datosDlaPartida.getCantidadPtosPartido();
                cargarJuegos.añadirJuego(crearCadenaPaGuardar(ultimoEditTextE1, ultimoEditTextE2));

                saveFiles(this,nombreE1,nombreE2,ptosE1,""+puntos,false);
                carga=true;
            }

            entrarOnStop=false;

            if (carga){
                Intent refresh = new Intent(AnotarJuegos.this, AnotarJuegos.class);
                refresh.putExtra("NOMBRE",nombre);
                refresh.putExtra("PUNTOS",puntos);
                refresh.putExtra("CONTINUAR",false);
                startActivity(refresh);
                finish();
            }
        }

    }

    public void Cancel(View view){

        if (ultimoEditTextIs1){

            if (ultimoEditTextE1!=-1){
                editTextsPos.get(ultimoEditTextE1).setText("");
                verificar=true;
            }

        }else {
            if (ultimoEditTextE2!=-1){
                editTexts1Pos.get(ultimoEditTextE2).setText("");
                verificar=true;
            }

        }

        dialog.dismiss();
    }


    /**TOMA LOS PASES QUE SE ANOTEN*/
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case (R.id.idBton1P10): {

                for (int i = 0; i < editTextsPos.size(); i++) {
                    if (editTextsPos.get(i).isInputMethodTarget()) {
                        listaPases1.add(pase11);
                        listaPases1Pos.add(i);
                    }
                }
                /**EL PAS PAL "*/
                for (int i = 0; i < editTexts1Pos.size(); i++) {
                    if (editTexts1Pos.get(i).isInputMethodTarget()) {
                        listaPases2.add(pase21);
                        listaPases2Pos.add(i);
                    }
                }
                break;
            }
            case (R.id.idBton1P20): {

                for (int i = 0; i < editTextsPos.size(); i++) {
                    if (editTextsPos.get(i).isInputMethodTarget()) {
                        listaPases1.add(pase12);
                        listaPases1Pos.add(i);
                    }
                }

                /**EL PAS PAL "*/
                for (int i = 0; i < editTexts1Pos.size(); i++) {
                    if (editTexts1Pos.get(i).isInputMethodTarget()) {
                        listaPases2.add(pase22);
                        listaPases2Pos.add(i);
                    }
                }
                break;
            }
        }
    }

    public void mostrarTeclado(View view){
        entro=false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        super.onSupportNavigateUp();
    }

    boolean entrarOnStop=true;

    @Override
    protected void onStop() {
        super.onStop();
        if (entrarOnStop){
            verificarPuntos(false);
            if (ptosE1.equals("0") && ptosE2.equals("0")){
                saveFiles(this,nombreE1,nombreE2,ptosE1,ptosE2,false);
            }else {
                saveFiles(this,nombreE1,nombreE2,ptosE1,ptosE2,true);
            }

        }
    }

    private void saveFiles(Context context, String nombre1, String nombre2, String ptos1, String ptos2, boolean guardar){

        String partida="";
        if (guardar){
            partida=nombre1+"/"+nombre2+"/"+ptos1+"/"+ptos2+"/";
        }
        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor mieditor=datos.edit();
        mieditor.putString("PARTIDAULT", partida);
        mieditor.apply();
    }

    private String readFiles(Context context){

        String part="";
        SharedPreferences datos=PreferenceManager.getDefaultSharedPreferences(context);
        try{
            part=datos.getString("PARTIDAULT","1");
        }catch (Exception e){
            //Toast.makeText(context, "NO cargo la partida", Toast.LENGTH_SHORT).show();
        }
        return part;
    }

    private int readFiles1(Context context){

        int tam=-1;

        SharedPreferences datos=PreferenceManager.getDefaultSharedPreferences(context);
        try{
            tam=datos.getInt("TIPOJUEGO",-1);
        }catch (Exception e){
            //Toast.makeText(context, "NO cargo el tamaño", Toast.LENGTH_SHORT).show();
        }

        return tam;

    }

    private void saveFilesCheck(Context context, boolean juego){
        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor mieditor=datos.edit();
        mieditor.putBoolean("CHECKEDSEGUIR", juego);
        mieditor.apply();
    }

    private boolean readFilesCheck(Context context){
        boolean tam=false;
        SharedPreferences datos=PreferenceManager.getDefaultSharedPreferences(context);
        try{
            tam=datos.getBoolean("CHECKEDSEGUIR",false);
        }catch (Exception e){
            //Toast.makeText(context, "NO cargo el tamaño", Toast.LENGTH_SHORT).show();
        }
        return tam;
    }



}
