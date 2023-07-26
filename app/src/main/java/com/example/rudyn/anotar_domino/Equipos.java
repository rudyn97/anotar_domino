package com.example.rudyn.anotar_domino;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by Valia on 15/9/2020.
 */

public class Equipos {

    ArrayList<String> nombresJ1;
    int posicion;

    String cadenaApasar="";

    ArrayList<String> nombres1 = new ArrayList<>();
    ArrayList<String> nombres2 = new ArrayList<>();


    DataBaseHelperEquipos myDb;

    public Equipos(String e1, String e2, Context context) {

        añadirNombresFijos();

        nombresJ1=new ArrayList<>();

        nombresJ1.add(e1);
        nombresJ1.add(e2);

        posicion=-1;

        myDb=new DataBaseHelperEquipos(context);

        if (!mostrarPuntos()){
            guardarPuntos();
        }else {
            mostrarPuntos();
        }

    }

    private void añadirNombresFijos(){
        //AQUI VAN LOS EQUIPOS EN TODOS LOS IDIOMAS
        /**********************************************************************************/
        nombres1.add("Equipo1");
        nombres1.add("Team 1");
        nombres1.add("Équipe 1");
        nombres1.add("टीम 1");
        nombres1.add("Tim 1");
        nombres1.add("チーム1");
        nombres1.add("Equipe 1");
        nombres1.add("Команда 1");
        nombres1.add("ทีม 1");
        nombres1.add("Takım 1");
        nombres1.add("团队1");

        nombres2.add("Equipo2");
        nombres2.add("Team 2");
        nombres2.add("Équipe 2");
        nombres2.add("टीम 2");
        nombres2.add("Tim 2");
        nombres2.add("チーム2");
        nombres2.add("Equipe 2");
        nombres2.add("Команда 2");
        nombres2.add("ทีม 2");
        nombres2.add("Takım 2");
        nombres2.add("2队");
    }

    public ArrayList<String> añadirEquipo(String name){

        boolean guardar=true;
        //AQUI PARA TODOS LOS IDIOMAS PONER LO QUE ES

        if (nombres1.contains(nombresJ1.get(0))){

            String nombreBorrado=nombresJ1.get(0);

            nombresJ1.add(name);
            nombresJ1.remove(0);
            nombresJ1.remove(0);

            for (int i =0;i<nombres1.size();i++){
                if (nombreBorrado.equals(nombres1.get(i))){
                    nombresJ1.add(nombres2.get(i));
                }
            }

           posicion=0;
        }else{
            if (nombres2.contains(nombresJ1.get(1))){
                nombresJ1.add(name);
                nombresJ1.remove(1);
                guardar=false;
                posicion=1;
            }

            if (guardar){
                if (nombresJ1.contains(name)){
                    for (int i=0;i<nombresJ1.size();i++){
                        if (name.equals(nombresJ1.get(i))){
                            posicion=i;
                        }
                    }
                }else {
                    nombresJ1.add(name);
                   posicion=nombresJ1.size()-1;
                }
            }
        }

        //actualizarPuntos();

        return nombresJ1;

    }

    public ArrayList<String> quitarEquipo(String name){

        if (nombresJ1.contains(name)){
            for (int i=0;i<nombresJ1.size();i++){
                if (nombresJ1.get(i).equals(name)){
                    nombresJ1.remove(i);
                }
            }
        }

        return nombresJ1;

    }

    /**ESTO ES LO QUE TRABAJA CON LA BASE DE DATOS*/

    public Boolean guardarPuntos(){
        //AQUI PONGO PA QUE GUARDE LAS COSAS EN BASE DE DATOS

        boolean resultado=true;

        for (int i=0;i<nombresJ1.size();i++){
            Boolean result0 = myDb.insertData(nombresJ1.get(i),i+"");
            if (!result0){
                resultado=false;
            }
        }

        if (resultado){
            return true;
        }else {
            return false;
        }
    }

    public Boolean mostrarPuntos(){
        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if(res!=null && res.getCount()>0 ){
            while(res.moveToNext()){
                stringBuffer.append(res.getString(1)+"/");

            }
            //txtResult.setText(stringBuffer.toString());
            cadenaApasar=stringBuffer.toString()+"*";
            //Toast.makeText(this, "Datos cargados"+cadenaApasar, Toast.LENGTH_SHORT).show();

            trabajoConCadena(cadenaApasar);
            return true;
            //AQUI LO GUARDO EN EL ARRAY DE LOS NOMBRES

        }else {
            //Toast.makeText(this, "NO Cargados", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public Boolean actualizarPuntos(){
        borrarPuntos();
        Boolean return1= guardarPuntos();

        if (return1){
            return true;
        }else {
            return false;
        }
    }

    public void borrarPuntos(){

        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        int contador=0;
        if(res!=null && res.getCount()>0 ) {
            while (res.moveToNext()) {
                //stringBuffer.append(res.getString(0) + "////" + res.getString(1) + "\n");
                contador++;
            }
        }

        for (int i=0;i<contador;i++){
            myDb.deleteData(i+"");

        }
    }

    private void trabajoConCadena(String cadena){

        //Toast.makeText(this, "cadena pasada al TCC:  "+cadena, Toast.LENGTH_SHORT).show();

        ArrayList<String> nombres=new ArrayList<>();

        String result="";

        //int contador=0;
        for (int i=0;i<cadena.length()-1;i++){

            if((cadena.charAt(i)+"").equals("/")){

                nombres.add(result);
                result="";
                i++;
            }
            result=result+(cadena.charAt(i)+"");
        }

        /*for (int y=0;y<nombres.size();y++){
            Toast.makeText(this, ""+nombres.get(y), Toast.LENGTH_SHORT).show();
        }*/

        nombresJ1=nombres;

    }


    /********************************************************/

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public ArrayList<String> getNombresJ1() {
        return nombresJ1;
    }

    public void setNombresJ1(ArrayList<String> nombresJ1) {
        this.nombresJ1 = nombresJ1;
    }
}
