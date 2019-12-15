package com.qhung.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Final_Project_Manger";
    public MyDatabase(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        String script = "Create table chuoi(pheptoan Text)";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addchuoi(String chuoi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("pheptoan",chuoi);
        db.insert("chuoi",null,values);
    }
    public ArrayList<String> getAllchuoi(){
        ArrayList<String> chuois = new ArrayList<String>();
        String script = "Select * from chuoi";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(script,null);
        while(cursor.moveToNext()){
            String chuoi = cursor.getString(0);
            chuois.add(chuoi);
        }
        return chuois;
    }
    public void deletechuoi(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("chuoi",null,null);
        db.close();
    }
}
