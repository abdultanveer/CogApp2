package com.abdul.cogapp2.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.abdul.cogapp2.R;

public class DbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
    }

    public void dbHandler(View view) {
        switch (view.getId()){
            case R.id.btnCommit:
                break;
            case R.id.btnRetrevie:
                break;
        }
    }
}