package com.abdul.cogapp2.database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo {

    public Todo(){}

    @PrimaryKey(autoGenerate = true)
    public int tid;

    public String title;
    public String notes;

    public Todo(String mTitle, String mNotes) {
        this.title = mTitle;
        this.notes = mNotes;
    }
}
