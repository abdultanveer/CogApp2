package com.abdul.cogapp2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class AdditionService extends Service {
    private final IBinder binder = new LocalBinder(); //step 2

    public AdditionService() {
    }

    public int add(int a, int b){ //step a
        return a + b;
    }

    @Override // binder is a pipe[unix] through which you can pass the data synchronously
    public IBinder onBind(Intent intent) { //this onbind method gets called when you say bindService from the activity
        return binder;//step 3
    }

    //step 1
    public class LocalBinder extends Binder {
        AdditionService getService() {
            // Return this instance of LocalService so clients can call public methods
            return AdditionService.this;
        }
    }
}