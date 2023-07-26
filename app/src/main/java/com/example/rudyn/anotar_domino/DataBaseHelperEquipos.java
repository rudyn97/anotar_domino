package com.example.rudyn.anotar_domino;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Valia on 20/9/2020.
 */

public class DataBaseHelperEquipos extends SQLiteOpenHelper{


    public static final String DATABASE_NAME = "Equipos.db";
    public static final String TABLE_NAME = "Equipos_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "EQUIPOS";


    public DataBaseHelperEquipos(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, EQUIPOS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_NAME);
    }



    public boolean insertData(String name, String id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        long result = db.insert(TABLE_NAME,null,contentValues);
        db.close();
        if (result==-1){
            return false;

        }else {
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME,null);
        return res;
    }


    public boolean updateData(String id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        int result =db.update(TABLE_NAME, contentValues,"ID =?",new String[]{id});
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_NAME,"ID=?",new String[]{id});
        return i;
    }

}
