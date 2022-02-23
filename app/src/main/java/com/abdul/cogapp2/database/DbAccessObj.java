package com.abdul.cogapp2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbAccessObj {
    DbHelper dbHelper;
    SQLiteDatabase database;

    public DbAccessObj(Context context){
        dbHelper = new DbHelper(context);
    }
    public  void openDb(){
        database = dbHelper.getWritableDatabase();
    }

    public  void closeDb(){
        database.close();
    }


    void createRow(String title, String notes){}
    void readRow(){}
    void updateRow(){}
    void deleteRow(){}



}
