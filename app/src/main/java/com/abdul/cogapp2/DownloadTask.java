package com.abdul.cogapp2;

import android.os.AsyncTask;
import android.util.Log;

//input type is string -- url, progress type - Integer,
public class DownloadTask extends AsyncTask<String,Integer,Void> {
    public  static  String TAG =  DownloadTask.class.getSimpleName();
    //this method will execute on a seperate thread in the background
    //so i plan to download the movie in this method
    @Override
    protected Void doInBackground(String... url) {
        Log.i(TAG,"downloading movie from the url"+ url[0]);
        return null;
    }
}
