package com.arju.sqlite.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private static final String databaseName = "DictonayDB";
    private static final int dbVersion = 1;

    private static final String tblWord= "tblWord";
    private static final String WordID= "WordID";
    private static final String Word= "Word";
    private static final String Meaning = "Meaning";

    public MyHelper(Context context){
        super(context, databaseName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tblWord + "("
                + WordID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Word + "TEXT, "
                + Meaning + " TEXT " +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean InsertData(String word, String meaning, SQLiteDatabase db){
        try{
            String query = "insert into words(word,meaning) values('" + word + "','" + meaning + "')";
            db.execSQL(query);
            return true;
        }catch (Exception e){
            Log.d(tag:"Error : ", e.toString());
            return false;
        }
    }
}
