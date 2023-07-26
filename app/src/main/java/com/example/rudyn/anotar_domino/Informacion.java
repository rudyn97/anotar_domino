package com.example.rudyn.anotar_domino;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Valia on 16/12/2020.
 */

public class Informacion extends AppCompatActivity{

    TextView idNombreApp;
    TextView idCreado;
    TextView idNombreR;
    TextView idContacto;
    TextView idContactoCorreo;
    TextView idVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion);

        String font_path = "font/letra.TTF";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        idNombreApp=(TextView)findViewById(R.id.idStringNombre);
        idCreado=(TextView)findViewById(R.id.idStringCreado);
        idNombreR=(TextView)findViewById(R.id.idStringRudyn);
        idContacto=(TextView)findViewById(R.id.idStringContacto);
        idContactoCorreo=(TextView)findViewById(R.id.idStringContactoCorreo);
        idVersion=(TextView)findViewById(R.id.idStringVersion);

        idNombreApp.setTypeface(TF);
        idCreado.setTypeface(TF);
        idNombreR.setTypeface(TF);
        idContacto.setTypeface(TF);
        idContactoCorreo.setTypeface(TF);
        idVersion.setTypeface(TF);

        ponerTamañoLetra();

        idVersion.setText(getResources().getString(R.string.version)+""+BuildConfig.VERSION_NAME);

    }

    private void ponerTamañoLetra(){

        LetraTamaño letraTamaño=new LetraTamaño(this);

        int tamañoLetra=letraTamaño.getTamaño();

        switch (tamañoLetra){
            case 0:{
                idNombreApp.setTextSize(letraTamaño.getInformacionPequeño()[0]);
                idCreado.setTextSize(letraTamaño.getInformacionPequeño()[1]);
                idNombreR.setTextSize(letraTamaño.getInformacionPequeño()[2]);
                idContacto.setTextSize(letraTamaño.getInformacionPequeño()[3]);
                idContactoCorreo.setTextSize(letraTamaño.getInformacionPequeño()[3]);
                idVersion.setTextSize(letraTamaño.getInformacionPequeño()[4]);
                break;
            }
            case 1:{
                idNombreApp.setTextSize(letraTamaño.getInformacionMediano()[0]);
                idCreado.setTextSize(letraTamaño.getInformacionMediano()[1]);
                idNombreR.setTextSize(letraTamaño.getInformacionMediano()[2]);
                idContacto.setTextSize(letraTamaño.getInformacionMediano()[3]);
                idContactoCorreo.setTextSize(letraTamaño.getInformacionMediano()[3]);
                idVersion.setTextSize(letraTamaño.getInformacionMediano()[4]);
                break;
            }
            case 2:{
                idNombreApp.setTextSize(letraTamaño.getInformacionGrande()[0]);
                idCreado.setTextSize(letraTamaño.getInformacionGrande()[1]);
                idNombreR.setTextSize(letraTamaño.getInformacionGrande()[2]);
                idContacto.setTextSize(letraTamaño.getInformacionGrande()[3]);
                idContactoCorreo.setTextSize(letraTamaño.getInformacionGrande()[3]);
                idVersion.setTextSize(letraTamaño.getInformacionGrande()[4]);
                break;
            }
        }
    }
}
