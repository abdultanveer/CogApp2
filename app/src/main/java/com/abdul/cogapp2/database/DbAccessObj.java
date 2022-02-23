package com.abdul.cogapp2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.abdul.cogapp2.database.FeedReaderContract.FeedEntry;


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


    void createRow(String title, String notes){
       // database.execSQL("insert into entry values ()");
        ContentValues values = new ContentValues(); //values = 1 row in the db
        values.put(FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,notes);
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }
    String readRow(){
       // database.rawQuery("select * from entry",null);
        Cursor cursor = database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE);
        int notesIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);
        String title = cursor.getString(titleIndex);
        String notes = cursor.getString(notesIndex);
        return title + "\n" + notes;

    }
    void updateRow(){}
    void deleteRow(){}



}
