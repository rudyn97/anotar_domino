package com.example.rudyn.anotar_domino;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by Valia on 2/10/2020.
 */

public class CargarJuegos {

    String puntos="";
    String addPuntos="";
    int cantidadDpartidos=0;

    //String paraMostrar="Ailin/10-20/20-10/29-14/!Rudyn/35-4/26-3/*Henry/12-1/!Robyn/23-12/* ";

    DataBaseHelperPartidos myDb;

    ArrayList<String> devolver;
    ArrayList<String> devolver1;


    public CargarJuegos(Context context) {
        myDb=new DataBaseHelperPartidos(context);

        if (!mostrarPuntos()){
            guardarJuego();
        }else {
            cantidadDpartidos();
        }

        devolver=new ArrayList<>();
        devolver1=new ArrayList<>();

    }

    /**GUARDA EL JUEGO VACIO PARA SI INICIA SIN NADA*/

    private Boolean guardarJuego(){
        //AQUI PONGO PA QUE GUARDE LAS COSAS EN BASE DE DATOS

        //String name="Rudyn";
        Boolean result = myDb.insertData("","1");
        /*Boolean result1 = dataBaseHelper.insertData("SEGUNDO","2");
        Boolean result2 = dataBaseHelper.insertData("TERCERO","3");
        Boolean result3 = dataBaseHelper.insertData("CUARTO","4");*/

        if (result /*&& result1 && result2 && result3*/){
            //Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            //Toast.makeText(this, "No Guardado", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    /**PARA SI SE AÑADE ALGUN JUEGO QUE SE HAYA JUGADO*/

    public void añadirJuego(String cadena ){
        actualizarPuntos(cadena);
    }

    /**PARA SI SE BORRA ALGUN JUEGO INTERMEDIO*/
    public void cambiarJuego(String cadena ){
        cambiarPuntos(cadena);
    }

    /**PARA SI HAY JUEGOS PARA MOSTRAR QUE ORGANICE LOS PUNTOS EN DOS ARREGLOS*/

    public Boolean mostrarJuegos(){
        if (mostrarPuntos()){

            organizarPuntos();
            return true;
        }else {
            return false;
        }
    }


    /**PARA CARGAR DE LA BASE DE DATOS EL STRING DE LOS PUNTOS PARA ADDPUNTOS*/

    private Boolean mostrarPuntos(){
        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if(res!=null && res.getCount()>0 ){
            while(res.moveToNext()){
                stringBuffer.append(res.getString(1));

            }

            addPuntos=stringBuffer.toString();

            //txtResult.setText(stringBuffer.toString());
            //Toast.makeText(this, "Datos cargados", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            return false;
            //Toast.makeText(this, "NO Cargados", Toast.LENGTH_SHORT).show();
        }
    }

    //ESTE ACTUALIZA LOS PUNTOS PA LA BASE DE DATOS

    private Boolean actualizarPuntos(String cadena){

        String devolver="";
        boolean entrar=false;

        //Esto carga lo q esta guardado en la BD y te pone la cantidad de partidos que hay

        cantidadDpartidos();

        puntos=addPuntos.concat(cadena);

        Boolean result = myDb.updateData("1",puntos);


        if (result){
            return true;
        }else {
            return false;
        }
    }

    private Boolean cambiarPuntos(String cadena){

        //Esto carga lo q esta guardado en la BD y te pone la cantidad de partidos que hay
        //En la variable cantidad de partidos
        cantidadDpartidos();

        addPuntos="";

        puntos=addPuntos.concat(cadena);

        Boolean result = myDb.updateData("1",puntos);


        if (result){
            addPuntos=puntos;
            return true;

        }else {
            return false;
        }
    }


    public int borrarPuntos(){
        int result =myDb.deleteData("1");
        /*int result1 =dataBaseHelper.deleteData("2");
        int result2 =dataBaseHelper.deleteData("3");
        int result3 =dataBaseHelper.deleteData("4");*/
        //Toast.makeText(this, ""+result/*+"\n"+result1+"\n"+result2+"\n"+result3+"\n"*/, Toast.LENGTH_SHORT).show();
        return result;
    }

    private void cantidadDpartidos(){
        cantidadDpartidos=0;
        mostrarPuntos();

        for (int i=0;i<addPuntos.length()-1;i++){
            if ((addPuntos.charAt(i)+"").equals("*")){
                cantidadDpartidos++;
            }
        }
    }


    public void organizarPuntos(){

        /**FORMA DE GUARDAR LOS PUNTOS Y COMO LOS CARGA
         * /*********************************************/

        /**         "10-20/20-10/29-14/!35-4/26-3/*12-1/!23-12/* "       */

        //mostrarPuntos();
        String cadena=addPuntos;
        String guardando="";

        String g="";

        devolver=new ArrayList<>();
        devolver1=new ArrayList<>();

        boolean ent=true;
        boolean ent1=true;



        for (int i=0;i<cadena.length()-1;i++){

            if ((cadena.charAt(i)+"").equals("!")){

                for (int y=0;y<guardando.length()-1;y++){

                    if ((guardando.charAt(y)+"").equals("/")){

                        devolver.add(g);
                        //devolver.add("/");
                        y++;
                        g="";
                    }

                    g=g.concat(guardando.charAt(y)+"");

                }

                devolver.add(g);
                devolver.add("!");
                i++;
                guardando="";
                g="";
            }


            if ((cadena.charAt(i)+"").equals("*")){

                for (int y=0;y<guardando.length()-1;y++){

                    if ((guardando.charAt(y)+"").equals("/")){

                        devolver1.add(g);
                        //devolver1.add("/");
                        y++;
                        g="";
                    }
                    g=g.concat(guardando.charAt(y)+"");
                }

                devolver1.add(g);
                devolver1.add("!");
                i++;
                guardando="";
                g="";
            }

            if ((cadena.charAt(i)+"").equals(" ")){

            }else {
                guardando=guardando.concat(cadena.charAt(i)+"");
            }
        }
    }


    public String sustituir2PtosPorDiv(String fecha_entrante){
        String fecha_salida="";

        for (int i=0;i<fecha_entrante.length();i++){
            if ((""+fecha_entrante.charAt(i)).equals(":")){
                fecha_salida=fecha_salida+"/";
            }else {
                fecha_salida=fecha_salida+fecha_entrante.charAt(i);
            }

        }
        return fecha_salida;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getAddPuntos() {

        return addPuntos;
    }

    public void setAddPuntos(String addPuntos) {
        this.addPuntos = addPuntos;
    }

    public ArrayList<String> getDevolver() {
        return devolver;
    }

    public void setDevolver(ArrayList<String> devolver) {
        this.devolver = devolver;
    }

    public ArrayList<String> getDevolver1() {
        return devolver1;
    }

    public void setDevolver1(ArrayList<String> devolver1) {
        this.devolver1 = devolver1;
    }

    public int getCantidadDpartidos() {
        return cantidadDpartidos;
    }

    public void setCantidadDpartidos(int cantidadDpartidos) {
        this.cantidadDpartidos = cantidadDpartidos;
    }
}
