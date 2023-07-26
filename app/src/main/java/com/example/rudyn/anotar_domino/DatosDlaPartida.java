package com.example.rudyn.anotar_domino;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Valia on 17/9/2020.
 */

public class DatosDlaPartida {

    int cantidadPtosPartido=100;
    boolean juegoConPases=false;
    int ptosPrimerPase=10;
    int ptosSegundoPase=20;

    DataBaseHelper myDb;

    public DatosDlaPartida(Context context) {

        myDb = new DataBaseHelper(context);
    }


    public int getCantidadPtosPartido() {
        return cantidadPtosPartido;
    }

    public void setCantidadPtosPartido(int cantidadPtosPartido) {
        this.cantidadPtosPartido = cantidadPtosPartido;
    }

    public boolean isJuegoConPases() {
        return juegoConPases;
    }

    public void setJuegoConPases(boolean juegoConPases) {
        this.juegoConPases = juegoConPases;
    }

    public int getPtosPrimerPase() {
        return ptosPrimerPase;
    }

    public void setPtosPrimerPase(int ptosPrimerPase) {
        this.ptosPrimerPase = ptosPrimerPase;
    }

    public int getPtosSegundoPase() {
        return ptosSegundoPase;
    }

    public void setPtosSegundoPase(int ptosSegundoPase) {
        this.ptosSegundoPase = ptosSegundoPase;
    }

    public void reiniciarPtos(){
        int cantidadPtosPartido=100;
        boolean juegoConPases=false;
        int ptosPrimerPase=10;
        int ptosSegundoPase=20;
    }

    public boolean guardarPuntos(){
        //AQUI PONGO PA QUE GUARDE LAS COSAS EN BASE DE DATOS

        reiniciarPtos();
        //String name="Rudyn";
        Boolean result = myDb.insertData(cantidadPtosPartido+"","1");
        Boolean result1 = myDb.insertData(juegoConPases+"","2");
        Boolean result2 = myDb.insertData(ptosPrimerPase+"","3");
        Boolean result3 = myDb.insertData(ptosSegundoPase+"","4");

        if (result && result1 && result2 && result3){
            return true;
        }else {
            return false;
        }
    }

    public boolean actualizarPuntos(){

        Boolean result = myDb.updateData("1",cantidadPtosPartido+"");
        Boolean result1 = myDb.updateData("2",juegoConPases+"");
        Boolean result2 = myDb.updateData("3",ptosPrimerPase+"");
        Boolean result3 = myDb.updateData("4",ptosSegundoPase+"");

        if (result && result1 && result2 && result3){
            return true;
        }else {
            return false;
        }
    }

    public String borrarPuntos(){

        int result =myDb.deleteData("1");
        int result1 =myDb.deleteData("2");
        int result2 =myDb.deleteData("3");
        int result3 =myDb.deleteData("4");

        return ""+result+"///"+result1+"///"+result2+"///"+result3;

    }

    public String cargarPuntos(){

        String resultado="";

        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if(res!=null && res.getCount()>0 ){
            while(res.moveToNext()){
                stringBuffer.append(res.getString(1)+"/");
            }
            resultado=stringBuffer.toString();

            //txtResult.setText(stringBuffer.toString());
            trabajoConCadena(resultado);
            //return trabajoConCadena(resultado);

            return resultado;
        }else {
            return "Datos no cargados";
        }

    }

    private void trabajoConCadena(String cadena){

        String CPPs="";
        String JCPs="";
        String PPPs="";
        String PSPs="";

        int contador=0;
        for (int i=0;i<cadena.length()-1;i++){
            if ((cadena.charAt(i)+"").equals("/")){
                i++;
                contador++;
            }
            switch (contador){
                case 0:{
                    CPPs=CPPs+(cadena.charAt(i)+"");    break;
                }
                case 1:{
                    JCPs=JCPs+(cadena.charAt(i)+"");    break;
                }
                case 2:{
                    PPPs=PPPs+(cadena.charAt(i)+"");    break;
                }
                case 3:{
                    PSPs=PSPs+(cadena.charAt(i)+"");    break;
                }
            }
        }
        cantidadPtosPartido=Integer.parseInt(CPPs);
        juegoConPases=Boolean.parseBoolean(JCPs);
        ptosPrimerPase=Integer.parseInt(PPPs);
        ptosSegundoPase=Integer.parseInt(PSPs);

    }


}
