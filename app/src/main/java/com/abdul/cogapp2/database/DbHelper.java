package com.abdul.cogapp2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.abdul.cogapp2.database.FeedReaderContract.FeedEntry;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    //CREATE TABLE entry (_id INTEGER PRIMARY KEY,title TEXT,subtitle TEXT)

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    public DbHelper(@Nullable Context context) {
        super(context, "cogdb", null, 1);
    }

    //oncreate gets called when the db is created for the first time
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    //onupgrade when user upgrades from older version to a newer version
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
