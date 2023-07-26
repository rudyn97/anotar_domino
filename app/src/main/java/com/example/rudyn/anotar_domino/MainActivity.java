package com.example.rudyn.anotar_domino;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatosDlaPartida datosDlaPartida;
    Equipos equipos;

    TextView NombreApk;
    Button  btnIniciar;
    Button  btnCargar;
    Button  btnOpciones;
    Button  btnInfo;

    String font_path1;
    String idioma="";

    LetraTamaño letraTamaño;

    private Locale locale;
    private Configuration config = new Configuration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NombreApk =(TextView)findViewById(R.id.idNombreApk);
        btnIniciar=(Button)findViewById(R.id.idBtnIniciar);
        btnCargar=(Button)findViewById(R.id.idBtnPartidasGuardadas);
        btnOpciones=(Button)findViewById(R.id.idBtnOpciones);
        btnInfo=(Button)findViewById(R.id.idBtnInformacion);


        cambiarIdioma();

        font_path1 = "font/letra.TTF";
        Typeface TF1 = Typeface.createFromAsset(getAssets(), font_path1);

        NombreApk.setTypeface(TF1);
        btnIniciar.setTypeface(TF1);
        btnCargar.setTypeface(TF1);
        btnOpciones.setTypeface(TF1);
        btnInfo.setTypeface(TF1);

        letraTamaño=new LetraTamaño(this);

        datosDlaPartida=new DatosDlaPartida(this);

        equipos=new Equipos(getResources().getString(R.string.equipo_1),getResources().getString(R.string.equipo_2),this);

        //Borra los datos y luego los crea para q empiencen desde los mismos en los datos de la partida
        //borrar();
        //crear();
        //SE QUITA PARA QUE NO LOS BORRE O SEA QUE NO BORRE LA INFORMACION QUE SE LE PUSO

    }

    @Override
    protected void onStart() {
        btnIniciar.setClickable(true);

        ponerTamañoLetra();

        super.onStart();
    }

    private void ponerTamañoLetra(){

        //PONER TAMAÑO DE LETRA
        int tamañoLetra=letraTamaño.getTamaño();


        switch (tamañoLetra){
            case 0:{
                NombreApk.setTextSize(letraTamaño.getActivityPequeño()[0]);
                btnIniciar.setTextSize(letraTamaño.getActivityPequeño()[1]);
                btnCargar.setTextSize(letraTamaño.getActivityPequeño()[1]);
                btnOpciones.setTextSize(letraTamaño.getActivityPequeño()[1]);
                btnInfo.setTextSize(letraTamaño.getActivityPequeño()[1]);
                break;
            }
            case 1:{
                NombreApk.setTextSize(letraTamaño.getActivityMediano()[0]);
                btnIniciar.setTextSize(letraTamaño.getActivityMediano()[1]);
                btnCargar.setTextSize(letraTamaño.getActivityMediano()[1]);
                btnOpciones.setTextSize(letraTamaño.getActivityMediano()[1]);
                btnInfo.setTextSize(letraTamaño.getActivityMediano()[1]);
                break;
            }
            case 2:{
                NombreApk.setTextSize(letraTamaño.getActivityGrande()[0]);
                btnIniciar.setTextSize(letraTamaño.getActivityGrande()[1]);
                btnCargar.setTextSize(letraTamaño.getActivityGrande()[1]);
                btnOpciones.setTextSize(letraTamaño.getActivityGrande()[1]);
                btnInfo.setTextSize(letraTamaño.getActivityGrande()[1]);
                break;
            }
        }
    }

    public void empezar(View view){
            btnIniciar.setClickable(false);

            if (readFiles(this).equals("")){
                Intent intent=new Intent(this, AnotarJuegos.class);
                intent.putExtra("CONTINUAR",false);
                startActivity(intent);
            }else {
                Intent intent=new Intent(this, EntreMainyAnotar.class);
                startActivity(intent);
            }


    }

    public void opciones(View view){
        Intent intent=new Intent(this, Opcion.class);
        startActivity(intent);
    }

    public void partidasGuardadas(View view){
        Intent intent=new Intent(this, MostrarJuegos.class);
        intent.putExtra("posicion",0);
        startActivity(intent);
    }

    public void info(View view){
        Intent intent=new Intent(this, Informacion.class);
        startActivity(intent);
    }

    private void crear(){
        boolean creado = datosDlaPartida.guardarPuntos();
    }

    private void borrar(){
        String borrados=datosDlaPartida.borrarPuntos();
    }

    private void cambiarIdioma(){
        //Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();

        /*************IDIOMA AQUI Y EN OPCIONES***************/

        String [] nombreIdioma={"espannol","ingles","aleman","frances","indio","indonesio","italiano","japones","portugal","ruso","tailandes","turco","chino"};
        String [] siglasIdioma={"es","en","de","fr","hi","in","it","ja","pt","ru","th","tr","zh"};

        readFile();

        for (int i=0;i<nombreIdioma.length-1;i++){
            if (idioma.equals(nombreIdioma[i]) && !NombreApk.getText().equals(getResources().getString(R.string.app_name))){
                //cambiarIdiomaAqui("es");
                locale = new Locale(siglasIdioma[i]);
                config.locale =locale;
                getResources().updateConfiguration(config, null);
                Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                startActivity(refresh);
                finish();
            }

        }

    }

    private void readFile() {
        try{
            File file = new File(getCacheDir(),"ArchivoAnotarDomino");
            FileInputStream fin = new FileInputStream(file);
            InputStreamReader inputStream=new InputStreamReader(fin);
            BufferedReader bufferedReader=new BufferedReader(inputStream);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
            fin.close();
            inputStream.close();
            String c=""+stringBuilder;
            idioma=c;
        }catch (java.io.IOException e){
            e.printStackTrace();
        }

    }

    private String readFiles(Context context){

        String part="";

        try{
        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(context);

            part=datos.getString("PARTIDAULT","");
        }catch (Exception e){
            //Toast.makeText(context, "NO cargo la partida", Toast.LENGTH_SHORT).show();
        }

        //Toast.makeText(context, "Cargo partida"+part, Toast.LENGTH_SHORT).show();

        return part;

    }


}
