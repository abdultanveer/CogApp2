package com.abdul.cogapp2.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.abdul.cogapp2.R;

public class DbActivity extends AppCompatActivity {
EditText etTitle,etNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        etTitle = findViewById(R.id.etTitle);
        etNotes = findViewById(R.id.etNotes);
    }

    public void dbHandler(View view) {
        switch (view.getId()){
            case R.id.btnCommit:
                String title = etTitle.getText().toString();
                String notes = etNotes.getText().toString();
                break;
            case R.id.btnRetrevie:
                break;
        }
    }
}