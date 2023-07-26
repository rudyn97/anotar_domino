package com.example.rudyn.anotar_domino;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Valia on 16/02/2021.
 */

public class LetraTamaño {

    /**0-PEQUEÑO
     * 1-MEDIO
     * 2-GRANDE
     */
    private int tamaño=1;

    /**TAMAÑOS QUE TOMA EL ACTIVITY MAIN*/
    private int [] activityPequeño={90,30};
    private int [] activityMediano={100,40};
    private int [] activityGrande={110,50};

    /**TAMAÑOS QUE TOMA EL ANOTAR JUEGOS*/
    private int [] anotarPequeño={30,30,30,30,20};
    private int [] anotarMediano={40,40,40,40,30};
    private int [] anotarGrande={50,50,50,50,40};

    /**HACER PARA EL CUSTOM LAYOUT*/
    private int [] customPequeño={30,20,15,25};
    private int [] customMediano={40,30,25,35};
    private int [] customGrande={50,40,35,45};

    /**HACER PARA EL CUSTOM LAYOUT1*/
    private int custom1Pequeño=35;
    private int custom1Mediano=45;
    private int custom1Grande=55;

    /**HACER PARA INFORMACION*/
    private int [] informacionPequeño={35,25,20,15,10};
    private int [] informacionMediano={45,35,30,25,20};
    private int [] informacionGrande={55,45,40,35,30};

    /**HACER PARA LETRA*/
    private int [] letraPequeño={30,22};
    private int [] letraMediano={40,33};
    private int [] letraGrande={50,44};

    /**HACER PARA MOSTRARJUEGOS*/
    private int [] mostrarPequeño={15,15,20};
    private int [] mostrarMediano={25,25,30};
    private int [] mostrarGrande={35,35,40};

    /**HACER PARA OPCIONES*/
    private int [] opcionesPequeño={20,25,20,15,30,30,25,25};
    private int [] opcionesMediano={30,35,30,25,40,40,35,35};
    private int [] opcionesGrande={40,45,40,35,50,50,45,45};

    /**HACER PARA OPCION*/
    private int [] opcionPequeño={25,15,30,25};
    private int [] opcionMediano={35,25,40,35};
    private int [] opcionGrande={45,35,50,45};

    /**HACER PARA ENTREMAINYANOTAR*/
    private int [] entrePequeño={43,28,18,17};
    private int [] entreMediano={53,38,28,27};
    private int [] entreGrande={63,48,38,37};

    /**HACER PARA JUEGOOPCIONES*/
    private int [] juegoOpcionesPequeño={30,15,30};
    private int [] juegoOpcionesMediano={40,25,40};
    private int [] juegoOpcionesGrande={50,35,50};

    public LetraTamaño(Context context) {
        tamaño=readFiles(context);
    }


    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(Context context, int tamaño) {
        this.tamaño = tamaño;
        saveFiles(context, tamaño);
    }

    //TOMAR TAMAÑOS DEL ACTIVITY MAIN

    public int[] getActivityPequeño() {
        return activityPequeño;
    }

    public int[] getActivityMediano() {
        return activityMediano;
    }

    public int[] getActivityGrande() {
        return activityGrande;
    }

    //TOMAR TAMAÑOS DEL ANOTARJUEGOS

    public int[] getAnotarPequeño() {
        return anotarPequeño;
    }

    public int[] getAnotarMediano() {
        return anotarMediano;
    }

    public int[] getAnotarGrande() {
        return anotarGrande;
    }

    //TOMAR TAMAÑOS DEL CUSTOMLAYOUT

    public int[] getCustomPequeño() {
        return customPequeño;
    }

    public int[] getCustomMediano() {
        return customMediano;
    }

    public int[] getCustomGrande() {
        return customGrande;
    }

    //TOMAR TAMAÑOS DEL CUSTOMLAYOUT1


    public int getCustom1Pequeño() {
        return custom1Pequeño;
    }

    public int getCustom1Mediano() {
        return custom1Mediano;
    }

    public int getCustom1Grande() {
        return custom1Grande;
    }

    //TOMAR TAMAÑOS DEL INFORMACION


    public int[] getInformacionPequeño() {
        return informacionPequeño;
    }

    public int[] getInformacionMediano() {
        return informacionMediano;
    }

    public int[] getInformacionGrande() {
        return informacionGrande;
    }

    //TOMAR TAMAÑOS DEL LETRA

    public int[] getLetraPequeño() {
        return letraPequeño;
    }

    public int[] getLetraMediano() {
        return letraMediano;
    }

    public int[] getLetraGrande() {
        return letraGrande;
    }

    //TOMAR TAMAÑOS DEL MOSTRAR

    public int[] getMostrarPequeño() {
        return mostrarPequeño;
    }

    public int[] getMostrarMediano() {
        return mostrarMediano;
    }

    public int[] getMostrarGrande() {
        return mostrarGrande;
    }

    //TOMAR TAMAÑOS DEL OPCION

    public int[] getOpcionPequeño() {
        return opcionPequeño;
    }

    public void setOpcionPequeño(int[] opcionPequeño) {
        this.opcionPequeño = opcionPequeño;
    }

    public int[] getOpcionMediano() {
        return opcionMediano;
    }

    public void setOpcionMediano(int[] opcionMediano) {
        this.opcionMediano = opcionMediano;
    }

    public int[] getOpcionGrande() {
        return opcionGrande;
    }

    public void setOpcionGrande(int[] opcionGrande) {
        this.opcionGrande = opcionGrande;
    }


    //TOMAR TAMAÑOS DEL OPCIONES


    public int[] getOpcionesPequeño() {
        return opcionesPequeño;
    }

    public int[] getOpcionesMediano() {
        return opcionesMediano;
    }

    public int[] getOpcionesGrande() {
        return opcionesGrande;
    }

    public int[] getEntrePequeño() {
        return entrePequeño;
    }

    public int[] getEntreMediano() {
        return entreMediano;
    }

    public int[] getEntreGrande() {
        return entreGrande;
    }

    //TOMAR TAMAÑOS DEL JUEGO OPCIONES

    public int[] getJuegoOpcionesPequeño() {
        return juegoOpcionesPequeño;
    }

    public void setJuegoOpcionesPequeño(int[] juegoOpcionesPequeño) {
        this.juegoOpcionesPequeño = juegoOpcionesPequeño;
    }

    public int[] getJuegoOpcionesMediano() {
        return juegoOpcionesMediano;
    }

    public void setJuegoOpcionesMediano(int[] juegoOpcionesMediano) {
        this.juegoOpcionesMediano = juegoOpcionesMediano;
    }

    public int[] getJuegoOpcionesGrande() {
        return juegoOpcionesGrande;
    }

    public void setJuegoOpcionesGrande(int[] juegoOpcionesGrande) {
        this.juegoOpcionesGrande = juegoOpcionesGrande;
    }

    private void saveFiles(Context context, int tamaño1){

        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor mieditor=datos.edit();

        mieditor.putInt("TAMAÑO", tamaño1);

        mieditor.apply();

        //Toast.makeText(context, "Actualizo tamaño", Toast.LENGTH_SHORT).show();

    }

    private int readFiles(Context context){

        int tam=1;

        SharedPreferences datos=PreferenceManager.getDefaultSharedPreferences(context);
        try{
            tam=datos.getInt("TAMAÑO",1);
        }catch (Exception e){
            //Toast.makeText(context, "NO cargo el tamaño", Toast.LENGTH_SHORT).show();
        }


        //Toast.makeText(context, "Cargo tamaño"+tam, Toast.LENGTH_SHORT).show();

        return tam;

    }



}
