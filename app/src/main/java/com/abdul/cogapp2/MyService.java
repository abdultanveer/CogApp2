package com.abdul.cogapp2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

//service runs on the main thread
public class MyService extends Service {
    public static String TAG = MyService.class.getSimpleName();
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
        Log.i(TAG,"received request to---"+ intent.getExtras().getString("url"));

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"service destroyed");

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}