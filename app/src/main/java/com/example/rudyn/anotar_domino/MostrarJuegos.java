package com.example.rudyn.anotar_domino;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Valia on 2/10/2020.
 */

public class MostrarJuegos extends AppCompatActivity {

    ImageView idImagePollo;
    ImageView idImagePollo1;
    ImageView idImage1Pollo;
    ImageView idImage1Pollo1;
    ImageView idImage2Pollo;
    ImageView idImage2Pollo1;
    ImageView idImage3Pollo;
    ImageView idImage3Pollo1;
    ImageView idImage4Pollo;
    ImageView idImage4Pollo1;
    ImageView idImage5Pollo;
    ImageView idImage5Pollo1;
    ImageView idImage6Pollo;
    ImageView idImage6Pollo1;
    ImageView idImage7Pollo;
    ImageView idImage7Pollo1;
    ImageView idImage8Pollo;
    ImageView idImage8Pollo1;
    ImageView idImage9Pollo;
    ImageView idImage9Pollo1;

    ArrayList<ImageView> arrayImagesPollo;
    ArrayList<ImageView> arrayImagesPollo1;

    TextView idPuntos;
    TextView idPuntos1;
    TextView id1Puntos;
    TextView id1Puntos1;
    TextView id2Puntos;
    TextView id2Puntos1;
    TextView id3Puntos;
    TextView id3Puntos1;
    TextView id4Puntos;
    TextView id4Puntos1;
    TextView id5Puntos;
    TextView id5Puntos1;
    TextView id6Puntos;
    TextView id6Puntos1;
    TextView id7Puntos;
    TextView id7Puntos1;
    TextView id8Puntos;
    TextView id8Puntos1;
    TextView id9Puntos;
    TextView id9Puntos1;

    ArrayList<TextView> arrayListsTexts;
    ArrayList<TextView> arrayListsTexts1;


    TextView idPuntosP;
    TextView idPuntosP1;
    TextView id1PuntosP;
    TextView id1PuntosP1;
    TextView id2PuntosP;
    TextView id2PuntosP1;
    TextView id3PuntosP;
    TextView id3PuntosP1;
    TextView id4PuntosP;
    TextView id4PuntosP1;
    TextView id5PuntosP;
    TextView id5PuntosP1;
    TextView id6PuntosP;
    TextView id6PuntosP1;
    TextView id7PuntosP;
    TextView id7PuntosP1;
    TextView id8PuntosP;
    TextView id8PuntosP1;
    TextView id9PuntosP;
    TextView id9PuntosP1;

    ArrayList<TextView> arrayListsTextsP;
    ArrayList<TextView> arrayListsTextsP1;


    TextView idPuntosFecha;
    TextView idPuntosFecha1;
    TextView idPuntosFecha2;
    TextView idPuntosFecha3;
    TextView idPuntosFecha4;
    TextView idPuntosFecha5;
    TextView idPuntosFecha6;
    TextView idPuntosFecha7;
    TextView idPuntosFecha8;
    TextView idPuntosFecha9;

    Button botonBorrar1;
    Button botonBorrar2;
    Button botonBorrar3;
    Button botonBorrar4;
    Button botonBorrar5;
    Button botonBorrar6;
    Button botonBorrar7;
    Button botonBorrar8;
    Button botonBorrar9;
    Button botonBorrar10;



    ArrayList<TextView> arrayListsTextsFecha;
    ArrayList<TextView> arrayListsBotonesBorrar;


    CargarJuegos cargarJuegos;

    Button idBotonAnterior;
    Button idBotonSiguiente;


    int [] fotosPollos={R.drawable.pollo,R.drawable.pollo1,R.drawable.pollo2,R.drawable.pollo3
            ,R.drawable.pollo4,R.drawable.pollo5,R.drawable.pollo6,R.drawable.pollo7
            ,R.drawable.pollo8};

    ArrayList<String > arrayList;
    ArrayList<String > arrayList1;

    int pos=0;
    int pos1=0;

    String font_path;
    Typeface TF;

    String fecha="";

    int posicionDeTodosLosJuegos=0;
    int variableCargar=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_juegos);

        Bundle datos = getIntent().getExtras();

        variableCargar=datos.getInt("posicion");

        //Toast.makeText(this, ""+posicionDeTodosLosJuegos, Toast.LENGTH_SHORT).show();


        font_path="font/letra.TTF";

        TF = Typeface.createFromAsset(getAssets(), font_path);

        iniciarImagenPollo();
        iniciarTextPtos();
        iniciarTextPtosP();
        iniciarTextFecha();
        iniciarBotonBorrar();

        idBotonAnterior=(Button)findViewById(R.id.idButtonAnterior);
        idBotonSiguiente=(Button)findViewById(R.id.idButtonSiguiente);

        for (int i =0; i<arrayImagesPollo.size(); i++){
            arrayListsTexts.get(i).setTypeface(TF);
            arrayListsTexts1.get(i).setTypeface(TF);
            arrayListsTextsP.get(i).setTypeface(TF);
            arrayListsTextsP1.get(i).setTypeface(TF);
        }
        for (int i =0; i<arrayListsTextsFecha.size(); i++){
            arrayListsTextsFecha.get(i).setTypeface(TF);
        }

        ponerTamañoLetra();

        cargarJuegos=new CargarJuegos(this);

        arrayList=new ArrayList<>();
        arrayList1=new ArrayList<>();

        mostrarPuntos(true);

        for (int i=variableCargar;i>0;i=i-10){
            //Mientras vaya vajando Darle Siguiente si esta visible el boton de siguiente
            if (idBotonSiguiente.getVisibility()==View.VISIBLE){
                //Apretar boton siguiente
                idBotonSiguiente.performClick();
            }
        }

        mostrarBotonesBorrar();

    }

    private void ponerTamañoLetra(){
        LetraTamaño letraTamaño=new LetraTamaño(this);
        int tamañoLetra=letraTamaño.getTamaño();

        switch (tamañoLetra){
            case 0:{
                for (int i =0; i<arrayImagesPollo.size(); i++){
                    arrayListsTexts.get(i).setTextSize(letraTamaño.getMostrarPequeño()[1]);
                    arrayListsTexts1.get(i).setTextSize(letraTamaño.getMostrarPequeño()[1]);
                    arrayListsTextsP.get(i).setTextSize(letraTamaño.getMostrarPequeño()[2]);
                    arrayListsTextsP1.get(i).setTextSize(letraTamaño.getMostrarPequeño()[2]);
                }
                for (int i =0; i<arrayListsTextsFecha.size(); i++){
                    arrayListsTextsFecha.get(i).setTextSize(letraTamaño.getMostrarPequeño()[0]);
                }

                break;
            }
            case 1:{
                for (int i =0; i<arrayImagesPollo.size(); i++){
                    arrayListsTexts.get(i).setTextSize(letraTamaño.getMostrarMediano()[1]);
                    arrayListsTexts1.get(i).setTextSize(letraTamaño.getMostrarMediano()[1]);
                    arrayListsTextsP.get(i).setTextSize(letraTamaño.getMostrarMediano()[2]);
                    arrayListsTextsP1.get(i).setTextSize(letraTamaño.getMostrarMediano()[2]);
                }
                for (int i =0; i<arrayListsTextsFecha.size(); i++){
                    arrayListsTextsFecha.get(i).setTextSize(letraTamaño.getMostrarMediano()[0]);
                }
                break;
            }
            case 2:{
                for (int i =0; i<arrayImagesPollo.size(); i++){
                    arrayListsTexts.get(i).setTextSize(letraTamaño.getMostrarGrande()[1]);
                    arrayListsTexts1.get(i).setTextSize(letraTamaño.getMostrarGrande()[1]);
                    arrayListsTextsP.get(i).setTextSize(letraTamaño.getMostrarGrande()[2]);
                    arrayListsTextsP1.get(i).setTextSize(letraTamaño.getMostrarGrande()[2]);
                }
                for (int i =0; i<arrayListsTextsFecha.size(); i++){
                    arrayListsTextsFecha.get(i).setTextSize(letraTamaño.getMostrarGrande()[0]);
                }
                break;
            }
        }
    }

    public void sig(View view){
        //AUMENTAR LA CANTIDAD DE PANTALLAS Q LLEVA PA SABER EN CUAL ESTA
        posicionDeTodosLosJuegos=posicionDeTodosLosJuegos+10;
        //VACIAR LOS DATOS
        iniciarDatosEnBlanco();

        mostrarPuntos(true);
        mostrarBotonesBorrar();
    }

    public void ant(View view){
        //RESTAR LA CANTIDAD DE PANTALLAS Q LLEVA PA SABER EN CUAL ESTA
        posicionDeTodosLosJuegos=posicionDeTodosLosJuegos-10;
        //VACIAR LOS DATOS
        iniciarDatosEnBlanco();

        mostrarPuntos(false);

        mostrarBotonesBorrar();
    }

    int valorInicioOtro=0;
    int valorInicioOtroAnterior=0;
    int valorInicioOtro1=0;
    int valorInicioOtroAnterior1=0;

    int cantInicial;
    int cantInicial1;


    boolean habilitarBotonSiguiente=true;
    //boolean habilitarBotonAnterior=false;

    public void mostrarPuntos(Boolean b){

        String cadena="";
        String cadenaPtos="";

        String cadena1="";
        String cadenaPtos1="";

        cargarJuegos.mostrarJuegos();

        arrayList=cargarJuegos.getDevolver();
        arrayList1=cargarJuegos.getDevolver1();


        pos=0;
        pos1=0;


        if (b){
            cantInicial=valorInicioOtro;
            cantInicial1=valorInicioOtro1;
        }else{
            cantInicial=valorInicioOtroAnterior;
            cantInicial1=valorInicioOtroAnterior1;
        }

        int cantidadJuegos=0;

        int cantFinal=10;

        int cantidadJuegos1=0;

        int cantFinal1=10;


        for (int i=cantInicial;i<arrayList.size();i++){

            if (arrayList.get(i).contains(":")){
                cantidadJuegos=cantidadJuegos+1;
                valorInicioOtro=i;
            }

            if (cantidadJuegos>cantFinal){
                //EL BOTON DE SIGUIENTE SE hABILITA
                habilitarBotonSiguiente=true;
                valorInicioOtroAnterior=cantInicial;
                break;
            }else{
                //EL BOTON DE SIGUIENTE SE INABILITA
                habilitarBotonSiguiente=false;
            }

            int numeroAleatorio = (int) (Math.random() * fotosPollos.length);

            if (arrayList.get(i).equals("!")){

                arrayListsTexts.get(pos).setText(cadena);
                arrayListsTextsP.get(pos).setText(cadenaPtos);

                //Como las fechas son la mitad de datos para que coja hasta 10
                if(pos<10){
                    arrayListsTextsFecha.get(pos).setText(fecha);
                }
                pos++;
                cadena="";
                cadenaPtos="";

            }else {


                if (arrayList.get(i).equals("0")){

                    /**AQUI PONGO Q SI PASA ESTO PONGO QUE SEA EL TEXTO ARRIBA Y LA IMAGEN DEL POLLO ABAJO
                     * Y LA IMAGEN TENGA 0 DE ALTURA
                     * */

                    arrayImagesPollo.get(pos).setBackgroundResource(fotosPollos[numeroAleatorio]);

                    arrayImagesPollo.get(pos).setVisibility(View.VISIBLE);
                    arrayListsTextsP.get(pos).setVisibility(View.INVISIBLE);
                }else {
                    arrayImagesPollo.get(pos).setVisibility(View.INVISIBLE);
                    arrayListsTextsP.get(pos).setVisibility(View.VISIBLE);

                    /**SI NO TIENE - ES EL NOMBRE*/
                    if (!(arrayList.get(i).contains("-"))){
                        /**SI TIENE : ES LA FECHA*/
                        if (arrayList.get(i).contains(":")){
                            fecha=cargarJuegos.sustituir2PtosPorDiv(arrayList.get(i));

                        }else {
                            cadena=cadena+arrayList.get(i)+"\n";
                        }
                    }else {
                            cadenaPtos=cadenaPtos+arrayList.get(i)+"\n";
                    }

                }

            }

        }

        for (int y=cantInicial1;y<arrayList1.size();y++){

            if (cantidadJuegos1>=cantFinal1){
                valorInicioOtroAnterior1=cantInicial1;
                break;
            }

            int numeroAleatorio = (int) (Math.random() * fotosPollos.length);

            if (arrayList1.get(y).equals("!")){

                arrayListsTexts1.get(pos1).setText(cadena1);
                arrayListsTextsP1.get(pos1).setText(cadenaPtos1);

                pos1++;
                cadena1="";
                cadenaPtos1="";

            }else {


                if (arrayList1.get(y).equals("0")){

                    /**AQUI PONGO Q SI PASA ESTO PONGO QUE SEA EL TEXTO ARRIBA Y LA IMAGEN DEL POLLO ABAJO
                     * Y LA IMAGEN TENGA 0 DE ALTURA
                     * */

                    arrayImagesPollo1.get(pos1).setBackgroundResource(fotosPollos[numeroAleatorio]);

                    arrayImagesPollo1.get(pos1).setVisibility(View.VISIBLE);
                    arrayListsTextsP1.get(pos1).setVisibility(View.INVISIBLE);
                }else {

                    arrayImagesPollo1.get(pos1).setVisibility(View.INVISIBLE);
                    arrayListsTextsP1.get(pos1).setVisibility(View.VISIBLE);


                    if (!(arrayList1.get(y).contains("-"))){
                        cadena1=cadena1+arrayList1.get(y)+"\n";
                    }else {
                        cadenaPtos1=cadenaPtos1+arrayList1.get(y)+"\n";
                    }
                }
            }

            if (arrayList1.get(y).contains("!")){
                cantidadJuegos1=cantidadJuegos1+1;
                valorInicioOtro1=y+1;
            }
        }

        //PARA QUE LOS BOTONES SE HABILITEN O NO SI TIENE MAS O MENOS

        if (cantInicial==0){
            idBotonAnterior.setEnabled(false);
            idBotonAnterior.setVisibility(View.INVISIBLE);
        }else{
            idBotonAnterior.setEnabled(true);
            idBotonAnterior.setVisibility(View.VISIBLE);
        }

        if (habilitarBotonSiguiente){
            idBotonSiguiente.setEnabled(true);
            idBotonSiguiente.setVisibility(View.VISIBLE);
        }else{
            idBotonSiguiente.setEnabled(false);
            idBotonSiguiente.setVisibility(View.INVISIBLE);
        }

        if (cargarJuegos.cantidadDpartidos<10){
            idBotonAnterior.setEnabled(false);
            idBotonAnterior.setVisibility(View.INVISIBLE);

            idBotonSiguiente.setEnabled(false);
            idBotonSiguiente.setVisibility(View.INVISIBLE);
        }
        if (cargarJuegos.cantidadDpartidos==0){
            idBotonAnterior.setEnabled(false);
            idBotonAnterior.setVisibility(View.INVISIBLE);

            idBotonSiguiente.setEnabled(false);
            idBotonSiguiente.setVisibility(View.INVISIBLE);
        }



    }


    public void borrarPartida(View view){

        String cadenaAguardar="";
        String cadenaCargada=cargarJuegos.getAddPuntos();
        int inicioBorrar=-1;

        //Recorrer la cadena y de acuerdo al que dio click borrar

        //De acuerdo al que seleccione va a ser valorAborrar
        switch (view.getId()){
            case R.id.idBotonBorrar1:{
                inicioBorrar=posicionDeTodosLosJuegos;
                break;
            }
            case R.id.idBotonBorrar2:{
                inicioBorrar=1+posicionDeTodosLosJuegos;
                break;
            }
            case R.id.idBotonBorrar3:{
                inicioBorrar=2+posicionDeTodosLosJuegos;
                break;
            }
            case R.id.idBotonBorrar4:{
                inicioBorrar=3+posicionDeTodosLosJuegos;
                break;
            }
            case R.id.idBotonBorrar5:{
                inicioBorrar=4+posicionDeTodosLosJuegos;
                break;
            }
            case R.id.idBotonBorrar6:{
                inicioBorrar=5+posicionDeTodosLosJuegos;
                break;
            }
            case R.id.idBotonBorrar7:{
                inicioBorrar=6+posicionDeTodosLosJuegos;
                break;
            }
            case R.id.idBotonBorrar8:{
                inicioBorrar=7+posicionDeTodosLosJuegos;
                break;
            }
            case R.id.idBotonBorrar9:{
                inicioBorrar=8+posicionDeTodosLosJuegos;
                break;
            }
            case R.id.idBotonBorrar10:{
                inicioBorrar=9+posicionDeTodosLosJuegos;
                break;
            }
        }

        //AQUI ES EL ULTIMO A BORRAR EN LA MISMA POS DE INICIOBORRAR
        ArrayList<Integer> finBorrar = new ArrayList<>();
        finBorrar.add(0);
        for(int i=0;i<cadenaCargada.length()-1;i++){

            if ((cadenaCargada.charAt(i)+"").equals("*")){
                finBorrar.add(i);
            }
        }
        //En finBorrar estan desde dond hasta dond borrar eso se hace
        //con la pos de inicioBorrar desde su pos hasta +1 incluyendo los 2

        //A CADENA CARGADA BORRARLE LAS POSICIONES DE LO QUE DICE ARRIBA
        //AÑADIRLE DESDE 0 HASTA POS INICIO Y DESDE FIN HASTA EL ULTIMO. ESO SE GUARDA

        if (finBorrar.get(inicioBorrar)!=0){
            cadenaAguardar=cadenaCargada.substring(0,finBorrar.get(inicioBorrar)+1);
        }
        cadenaAguardar=cadenaAguardar.concat(cadenaCargada.substring(finBorrar.get(inicioBorrar+1)+1,cadenaCargada.length()));

        //Guarda la cadena que le pase
        cargarJuegos.cambiarJuego(cadenaAguardar);

        //Carga la cadena
        cargarJuegos.mostrarJuegos();

        Intent refresh = new Intent(MostrarJuegos.this, MostrarJuegos.class);
        refresh.putExtra("posicion",posicionDeTodosLosJuegos);
        startActivity(refresh);
        finish();

    }

    private void mostrarBotonesBorrar(){

        for (int i=0;i<arrayListsBotonesBorrar.size();i++){
            arrayListsBotonesBorrar.get(i).setVisibility(View.INVISIBLE);
        }

        int cantidadHabilitar=cargarJuegos.getCantidadDpartidos()-(posicionDeTodosLosJuegos);

        if (cantidadHabilitar>10){
            for (int i=0;i<arrayListsBotonesBorrar.size();i++){
                arrayListsBotonesBorrar.get(i).setVisibility(View.VISIBLE);
            }
        }else{
            for (int i=0;i<cantidadHabilitar;i++){
                arrayListsBotonesBorrar.get(i).setVisibility(View.VISIBLE);
            }
        }
        //Toast.makeText(this, ""+cantidadHabilitar, Toast.LENGTH_SHORT).show();

    }

    private void iniciarDatosEnBlanco(){

        for (int i=0;i<arrayListsTexts.size();i++){
            arrayListsTexts.get(i).setText("");
            arrayListsTexts1.get(i).setText("");
            arrayListsTextsP.get(i).setText("");
            arrayListsTextsP1.get(i).setText("");
            arrayListsTextsFecha.get(i).setText("");
            arrayImagesPollo.get(i).setVisibility(View.INVISIBLE);
            arrayImagesPollo1.get(i).setVisibility(View.INVISIBLE);

        }


    }

    private void iniciarImagenPollo(){

        arrayImagesPollo=new ArrayList<>();
        arrayImagesPollo1=new ArrayList<>();

        idImagePollo=(ImageView)findViewById(R.id.idImagePollo);
        arrayImagesPollo.add(idImagePollo);
        idImagePollo1=(ImageView)findViewById(R.id.idImagePollo1);
        arrayImagesPollo1.add(idImagePollo1);
        idImage1Pollo=(ImageView)findViewById(R.id.idImage1Pollo);
        arrayImagesPollo.add(idImage1Pollo);
        idImage1Pollo1=(ImageView)findViewById(R.id.idImage1Pollo1);
        arrayImagesPollo1.add(idImage1Pollo1);
        idImage2Pollo=(ImageView)findViewById(R.id.idImage2Pollo);
        arrayImagesPollo.add(idImage2Pollo);
        idImage2Pollo1=(ImageView)findViewById(R.id.idImage2Pollo1);
        arrayImagesPollo1.add(idImage2Pollo1);
        idImage3Pollo=(ImageView)findViewById(R.id.idImage3Pollo);
        arrayImagesPollo.add(idImage3Pollo);
        idImage3Pollo1=(ImageView)findViewById(R.id.idImage3Pollo1);
        arrayImagesPollo1.add(idImage3Pollo1);
        idImage4Pollo=(ImageView)findViewById(R.id.idImage4Pollo);
        arrayImagesPollo.add(idImage4Pollo);
        idImage4Pollo1=(ImageView)findViewById(R.id.idImage4Pollo1);
        arrayImagesPollo1.add(idImage4Pollo1);
        idImage5Pollo=(ImageView)findViewById(R.id.idImage5Pollo);
        arrayImagesPollo.add(idImage5Pollo);
        idImage5Pollo1=(ImageView)findViewById(R.id.idImage5Pollo1);
        arrayImagesPollo1.add(idImage5Pollo1);
        idImage6Pollo=(ImageView)findViewById(R.id.idImage6Pollo);
        arrayImagesPollo.add(idImage6Pollo);
        idImage6Pollo1=(ImageView)findViewById(R.id.idImage6Pollo1);
        arrayImagesPollo1.add(idImage6Pollo1);
        idImage7Pollo=(ImageView)findViewById(R.id.idImage7Pollo);
        arrayImagesPollo.add(idImage7Pollo);
        idImage7Pollo1=(ImageView)findViewById(R.id.idImage7Pollo1);
        arrayImagesPollo1.add(idImage7Pollo1);
        idImage8Pollo=(ImageView)findViewById(R.id.idImage8Pollo);
        arrayImagesPollo.add(idImage8Pollo);
        idImage8Pollo1=(ImageView)findViewById(R.id.idImage8Pollo1);
        arrayImagesPollo1.add(idImage8Pollo1);
        idImage9Pollo=(ImageView)findViewById(R.id.idImage9Pollo);
        arrayImagesPollo.add(idImage9Pollo);
        idImage9Pollo1=(ImageView)findViewById(R.id.idImage9Pollo1);
        arrayImagesPollo1.add(idImage9Pollo1);

    }

    private void iniciarTextPtos(){

        arrayListsTexts=new ArrayList<>();
        arrayListsTexts1=new ArrayList<>();

        idPuntos=(TextView)findViewById(R.id.idPuntos);
        arrayListsTexts.add(idPuntos);
        idPuntos1=(TextView)findViewById(R.id.idPuntos1);
        arrayListsTexts1.add(idPuntos1);
        id1Puntos=(TextView)findViewById(R.id.id1Puntos);
        arrayListsTexts.add(id1Puntos);
        id1Puntos1=(TextView)findViewById(R.id.id1Puntos1);
        arrayListsTexts1.add(id1Puntos1);
        id2Puntos=(TextView)findViewById(R.id.id2Puntos);
        arrayListsTexts.add(id2Puntos);
        id2Puntos1=(TextView)findViewById(R.id.id2Puntos1);
        arrayListsTexts1.add(id2Puntos1);
        id3Puntos=(TextView)findViewById(R.id.id3Puntos);
        arrayListsTexts.add(id3Puntos);
        id3Puntos1=(TextView)findViewById(R.id.id3Puntos1);
        arrayListsTexts1.add(id3Puntos1);
        id4Puntos=(TextView)findViewById(R.id.id4Puntos);
        arrayListsTexts.add(id4Puntos);
        id4Puntos1=(TextView)findViewById(R.id.id4Puntos1);
        arrayListsTexts1.add(id4Puntos1);
        id5Puntos=(TextView)findViewById(R.id.id5Puntos);
        arrayListsTexts.add(id5Puntos);
        id5Puntos1=(TextView)findViewById(R.id.id5Puntos1);
        arrayListsTexts1.add(id5Puntos1);
        id6Puntos=(TextView)findViewById(R.id.id6Puntos);
        arrayListsTexts.add(id6Puntos);
        id6Puntos1=(TextView)findViewById(R.id.id6Puntos1);
        arrayListsTexts1.add(id6Puntos1);
        id7Puntos=(TextView)findViewById(R.id.id7Puntos);
        arrayListsTexts.add(id7Puntos);
        id7Puntos1=(TextView)findViewById(R.id.id7Puntos1);
        arrayListsTexts1.add(id7Puntos1);
        id8Puntos=(TextView)findViewById(R.id.id8Puntos);
        arrayListsTexts.add(id8Puntos);
        id8Puntos1=(TextView)findViewById(R.id.id8Puntos1);
        arrayListsTexts1.add(id8Puntos1);
        id9Puntos=(TextView)findViewById(R.id.id9Puntos);
        arrayListsTexts.add(id9Puntos);
        id9Puntos1=(TextView)findViewById(R.id.id9Puntos1);
        arrayListsTexts1.add(id9Puntos1);

    }

    private void iniciarTextPtosP(){

        arrayListsTextsP=new ArrayList<>();
        arrayListsTextsP1=new ArrayList<>();

        idPuntosP=(TextView)findViewById(R.id.idPuntosP);
        arrayListsTextsP.add(idPuntosP);
        idPuntosP1=(TextView)findViewById(R.id.idPuntosP1);
        arrayListsTextsP1.add(idPuntosP1);
        id1PuntosP=(TextView)findViewById(R.id.id1PuntosP);
        arrayListsTextsP.add(id1PuntosP);
        id1PuntosP1=(TextView)findViewById(R.id.id1PuntosP1);
        arrayListsTextsP1.add(id1PuntosP1);
        id2PuntosP=(TextView)findViewById(R.id.id2PuntosP);
        arrayListsTextsP.add(id2PuntosP);
        id2PuntosP1=(TextView)findViewById(R.id.id2PuntosP1);
        arrayListsTextsP1.add(id2PuntosP1);
        id3PuntosP=(TextView)findViewById(R.id.id3PuntosP);
        arrayListsTextsP.add(id3PuntosP);
        id3PuntosP1=(TextView)findViewById(R.id.id3PuntosP1);
        arrayListsTextsP1.add(id3PuntosP1);
        id4PuntosP=(TextView)findViewById(R.id.id4PuntosP);
        arrayListsTextsP.add(id4PuntosP);
        id4PuntosP1=(TextView)findViewById(R.id.id4PuntosP1);
        arrayListsTextsP1.add(id4PuntosP1);
        id5PuntosP=(TextView)findViewById(R.id.id5PuntosP);
        arrayListsTextsP.add(id5PuntosP);
        id5PuntosP1=(TextView)findViewById(R.id.id5PuntosP1);
        arrayListsTextsP1.add(id5PuntosP1);
        id6PuntosP=(TextView)findViewById(R.id.id6PuntosP);
        arrayListsTextsP.add(id6PuntosP);
        id6PuntosP1=(TextView)findViewById(R.id.id6PuntosP1);
        arrayListsTextsP1.add(id6PuntosP1);
        id7PuntosP=(TextView)findViewById(R.id.id7PuntosP);
        arrayListsTextsP.add(id7PuntosP);
        id7PuntosP1=(TextView)findViewById(R.id.id7PuntosP1);
        arrayListsTextsP1.add(id7PuntosP1);
        id8PuntosP=(TextView)findViewById(R.id.id8PuntosP);
        arrayListsTextsP.add(id8PuntosP);
        id8PuntosP1=(TextView)findViewById(R.id.id8PuntosP1);
        arrayListsTextsP1.add(id8PuntosP1);
        id9PuntosP=(TextView)findViewById(R.id.id9PuntosP);
        arrayListsTextsP.add(id9PuntosP);
        id9PuntosP1=(TextView)findViewById(R.id.id9PuntosP1);
        arrayListsTextsP1.add(id9PuntosP1);

    }

    private void iniciarTextFecha(){

        arrayListsTextsFecha=new ArrayList<>();

        idPuntosFecha=(TextView)findViewById(R.id.idTextViewFecha);
        arrayListsTextsFecha.add(idPuntosFecha);
        idPuntosFecha1=(TextView)findViewById(R.id.idTextViewFecha1);
        arrayListsTextsFecha.add(idPuntosFecha1);
        idPuntosFecha2=(TextView)findViewById(R.id.idTextViewFecha2);
        arrayListsTextsFecha.add(idPuntosFecha2);
        idPuntosFecha3=(TextView)findViewById(R.id.idTextViewFecha3);
        arrayListsTextsFecha.add(idPuntosFecha3);
        idPuntosFecha4=(TextView)findViewById(R.id.idTextViewFecha4);
        arrayListsTextsFecha.add(idPuntosFecha4);
        idPuntosFecha5=(TextView)findViewById(R.id.idTextViewFecha5);
        arrayListsTextsFecha.add(idPuntosFecha5);
        idPuntosFecha6=(TextView)findViewById(R.id.idTextViewFecha6);
        arrayListsTextsFecha.add(idPuntosFecha6);
        idPuntosFecha7=(TextView)findViewById(R.id.idTextViewFecha7);
        arrayListsTextsFecha.add(idPuntosFecha7);
        idPuntosFecha8=(TextView)findViewById(R.id.idTextViewFecha8);
        arrayListsTextsFecha.add(idPuntosFecha8);
        idPuntosFecha9=(TextView)findViewById(R.id.idTextViewFecha9);
        arrayListsTextsFecha.add(idPuntosFecha9);

    }

    private void iniciarBotonBorrar(){

        arrayListsBotonesBorrar=new ArrayList<>();

        botonBorrar1=(Button) findViewById(R.id.idBotonBorrar1);
        arrayListsBotonesBorrar.add(botonBorrar1);
        botonBorrar2=(Button) findViewById(R.id.idBotonBorrar2);
        arrayListsBotonesBorrar.add(botonBorrar2);
        botonBorrar3=(Button) findViewById(R.id.idBotonBorrar3);
        arrayListsBotonesBorrar.add(botonBorrar3);
        botonBorrar4=(Button) findViewById(R.id.idBotonBorrar4);
        arrayListsBotonesBorrar.add(botonBorrar4);
        botonBorrar5=(Button) findViewById(R.id.idBotonBorrar5);
        arrayListsBotonesBorrar.add(botonBorrar5);
        botonBorrar6=(Button) findViewById(R.id.idBotonBorrar6);
        arrayListsBotonesBorrar.add(botonBorrar6);
        botonBorrar7=(Button) findViewById(R.id.idBotonBorrar7);
        arrayListsBotonesBorrar.add(botonBorrar7);
        botonBorrar8=(Button) findViewById(R.id.idBotonBorrar8);
        arrayListsBotonesBorrar.add(botonBorrar8);
        botonBorrar9=(Button) findViewById(R.id.idBotonBorrar9);
        arrayListsBotonesBorrar.add(botonBorrar9);
        botonBorrar10=(Button) findViewById(R.id.idBotonBorrar10);
        arrayListsBotonesBorrar.add(botonBorrar10);


    }

}
