package com.example.rudyn.anotar_domino;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Valia on 13/10/2020.
 */

    /**ESTE ES EL ADAPTADOR PAL SPINNER*/

public class EquiposAdapter extends ArrayAdapter {


        public ArrayList<String> equipos=new ArrayList<>();
        private Typeface TF;
        private Context cont;
        LetraTamaño letraTamaño;


    public EquiposAdapter(@NonNull Context context, ArrayList<String> equipos1, Typeface TF1) {

        super(context,R.layout.simple_spinner_item,R.id.textViewCustom,equipos1);
        cont=context;
        equipos=equipos1;
        TF=TF1;
        letraTamaño= new LetraTamaño(cont);
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView,parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        return initView(position, convertView,parent);
    }

    private  View initView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.simple_spinner_item,parent,false);
        TextView equiposText= (TextView) row.findViewById(R.id.textViewCustom);
        equiposText.setTypeface(TF);

            switch (letraTamaño.getTamaño()){
                case 0: equiposText.setTextSize(letraTamaño.getAnotarPequeño()[4]); break;
                case 1: equiposText.setTextSize(letraTamaño.getAnotarMediano()[4]); break;
                case 2: equiposText.setTextSize(letraTamaño.getAnotarGrande()[4]); break;
            }


        equiposText.setText((equipos.get(position))+"");
        return row;
    }


}
