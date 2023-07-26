package com.example.rudyn.anotar_domino;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Valia on 15/07/2021.
 */

public class EquipoOpciones extends AppCompatActivity{

    String font_path;
    Spinner spinnerJ1;
    EditText editTextJ1;
    TextView idTextViewListaEquipos;
    Button idBAplicar;


    ArrayList<String> nombresJ1;
    Equipos equipos;
    EquiposAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipo_opciones);


        font_path = "font/letra.TTF";

        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        spinnerJ1 = (Spinner) findViewById(R.id.idSpinerJ1);
        editTextJ1 = (EditText) findViewById(R.id.masked);
        idTextViewListaEquipos = (TextView) findViewById(R.id.idTextViewListaEquipos);
        idBAplicar=(Button)findViewById(R.id.idBAplicar);

        editTextJ1.setTypeface(TF);
        idTextViewListaEquipos.setTypeface(TF);
        idBAplicar.setTypeface(TF);


        nombresJ1=new ArrayList<>();

        equipos=new Equipos(getResources().getString(R.string.equipo_1),getResources().getString(R.string.equipo_2),this);

        //equipos.cargarPuntos();
        nombresJ1=equipos.getNombresJ1();

        adapter1 = new EquiposAdapter(getApplicationContext(),nombresJ1, TF);
        spinnerJ1.setAdapter(adapter1);


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
                editTextJ1.setTextSize(letraTamaño.getOpcionPequeño()[1]);
                idTextViewListaEquipos.setTextSize(letraTamaño.getOpcionPequeño()[2]);
                idBAplicar.setTextSize(letraTamaño.getOpcionesPequeño()[3]);
                break;
            }
            case 1:{
                editTextJ1.setTextSize(letraTamaño.getOpcionMediano()[1]);
                idTextViewListaEquipos.setTextSize(letraTamaño.getOpcionMediano()[2]);
                idBAplicar.setTextSize(letraTamaño.getOpcionesMediano()[3]);
                break;
            }
            case 2:{
                editTextJ1.setTextSize(letraTamaño.getOpcionGrande()[1]);
                idTextViewListaEquipos.setTextSize(letraTamaño.getOpcionGrande()[2]);
                idBAplicar.setTextSize(letraTamaño.getOpcionesGrande()[3]);
                break;
            }
        }
    }




    public void añadirNombre(View view){

        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);

        añadirNombre(editTextJ1.getText().toString());
    }

    private void añadirNombre(String name){

        if(editTextJ1.getText().length()!=0){

            nombresJ1=equipos.añadirEquipo(name);

            //ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,nombresJ1);
            spinnerJ1.setAdapter(adapter1);
            spinnerJ1.setSelection(equipos.getPosicion());

        }else {
            Toast.makeText(this, getResources().getString(R.string.aclaracion1), Toast.LENGTH_SHORT).show();
        }

        editTextJ1.setText("");

        guardarEquipos();

    }


    public void quitarNombre(View view){
        if (spinnerJ1.getCount()<=2){
            Toast.makeText(this, getResources().getString(R.string.aclaracion2), Toast.LENGTH_SHORT).show();
        }else {
            quitarNombre(nombresJ1.get(spinnerJ1.getSelectedItemPosition()));
        }
    }

    private void quitarNombre(String nombre){

        nombresJ1=equipos.quitarEquipo(nombre);

        //ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,nombresJ1);
        spinnerJ1.setAdapter(adapter1);

        guardarEquipos();
    }

    public void guardarEquipos(){
        Boolean actualizo=equipos.actualizarPuntos();

        if (actualizo){
            //Toast.makeText(this, "Datos Incertados", Toast.LENGTH_SHORT).show();
            //onBackPressed();
        }else {
            //Toast.makeText(this, "Datos no cambiados", Toast.LENGTH_SHORT).show();
        }

    }

    public void onBackPressed(View view){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
