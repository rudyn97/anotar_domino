package com.example.rudyn.anotar_domino;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;

/**
 * Created by Valia on 22/12/2020.
 */

public class Idioma extends AppCompatActivity {

    String idioma;
    private Locale locale;
    private Configuration config = new Configuration();

    TextView idTextViewEsp;
    TextView idTextViewIng;
    TextView idTextViewAle;
    TextView idTextViewFra;
    TextView idTextViewInd;
    TextView idTextViewIndo;
    TextView idTextViewIta;
    TextView idTextViewJap;
    TextView idTextViewPort;
    TextView idTextViewRus;
    TextView idTextViewTai;
    TextView idTextViewTur;
    TextView idTextViewChi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout1);



        String font_path = "font/letra.TTF";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        idTextViewEsp=(TextView)findViewById(R.id.idTextViewEsp);
        idTextViewIng=(TextView)findViewById(R.id.idTextViewIng);
        idTextViewAle=(TextView)findViewById(R.id.idTextViewAle);
        idTextViewFra=(TextView)findViewById(R.id.idTextViewFra);
        idTextViewInd=(TextView)findViewById(R.id.idTextViewIn);
        idTextViewIndo=(TextView)findViewById(R.id.idTextViewIndo);
        idTextViewIta=(TextView)findViewById(R.id.idTextViewIta);
        idTextViewJap=(TextView)findViewById(R.id.idTextViewJap);
        idTextViewPort=(TextView)findViewById(R.id.idTextViewPort);
        idTextViewRus=(TextView)findViewById(R.id.idTextViewRuso);
        idTextViewTai=(TextView)findViewById(R.id.idTextViewTai);
        idTextViewTur=(TextView)findViewById(R.id.idTextViewTurc);
        idTextViewChi=(TextView)findViewById(R.id.idTextViewChin);

        idTextViewEsp.setTypeface(TF);
        idTextViewIng.setTypeface(TF);
        idTextViewAle.setTypeface(TF);
        idTextViewFra.setTypeface(TF);
        idTextViewInd.setTypeface(TF);
        idTextViewIndo.setTypeface(TF);
        idTextViewIta.setTypeface(TF);
        idTextViewJap.setTypeface(TF);
        idTextViewPort.setTypeface(TF);
        idTextViewRus.setTypeface(TF);
        idTextViewTai.setTypeface(TF);
        idTextViewTur.setTypeface(TF);
        idTextViewChi.setTypeface(TF);

        ponerTamañoLetra();

    }

    private void ponerTamañoLetra(){

        LetraTamaño letraTamaño=new LetraTamaño(this);

        int tamañoLetra=letraTamaño.getTamaño();

        switch (tamañoLetra){
            case 0:{
                idTextViewEsp.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewIng.setTextSize(letraTamaño.getCustom1Pequeño());

                idTextViewAle.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewFra.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewInd.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewIndo.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewIta.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewJap.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewPort.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewRus.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewTai.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewTur.setTextSize(letraTamaño.getCustom1Pequeño());
                idTextViewChi.setTextSize(letraTamaño.getCustom1Pequeño());

                break;
            }
            case 1:{
                idTextViewEsp.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewIng.setTextSize(letraTamaño.getCustom1Mediano());

                idTextViewAle.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewFra.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewInd.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewIndo.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewIta.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewJap.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewPort.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewRus.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewTai.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewTur.setTextSize(letraTamaño.getCustom1Mediano());
                idTextViewChi.setTextSize(letraTamaño.getCustom1Mediano());
                break;
            }
            case 2:{
                idTextViewEsp.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewIng.setTextSize(letraTamaño.getCustom1Grande());

                idTextViewAle.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewFra.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewInd.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewIndo.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewIta.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewJap.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewPort.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewRus.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewTai.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewTur.setTextSize(letraTamaño.getCustom1Grande());
                idTextViewChi.setTextSize(letraTamaño.getCustom1Grande());
                break;
            }
        }
    }




    public void español(View view){idioma="espannol";cambiarIdiomaAqui("es");}
    public void ingles(View view){idioma="ingles"; cambiarIdiomaAqui("en"); }
    public void aleman(View view){idioma="aleman"; cambiarIdiomaAqui("de"); }
    public void frances(View view){idioma="frances"; cambiarIdiomaAqui("fr"); }
    public void indio(View view){idioma="indio"; cambiarIdiomaAqui("hi"); }
    public void indonesio(View view){idioma="indonesio"; cambiarIdiomaAqui("in"); }
    public void italiano(View view){idioma="italiano"; cambiarIdiomaAqui("it"); }
    public void japones(View view){idioma="japones"; cambiarIdiomaAqui("ja"); }
    public void portugal(View view){idioma="portugal"; cambiarIdiomaAqui("pt"); }
    public void ruso(View view){idioma="ruso"; cambiarIdiomaAqui("ru"); }
    public void tailandes(View view){idioma="tailandes"; cambiarIdiomaAqui("th"); }
    public void turco(View view){idioma="turco"; cambiarIdiomaAqui("tr"); }
    public void chino(View view){idioma="chino"; cambiarIdiomaAqui("zh"); }


    private void cambiarIdiomaAqui(String siglas){
        locale = new Locale(siglas);
        config.locale =locale;
        getResources().updateConfiguration(config, null);
        Intent refresh = new Intent(Idioma.this, Opcion.class);
        startActivity(refresh);
        finish();

        saveFile();
    }


    private void saveFile() {
        try{
            File file = new File(getCacheDir(),"ArchivoAnotarDomino");
            FileOutputStream fos = new FileOutputStream(file);
            String g=""+idioma;
            fos.write(g.getBytes());
            fos.close();
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        onBackPressed();
    }


}
