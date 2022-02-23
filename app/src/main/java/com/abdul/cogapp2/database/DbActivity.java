package com.abdul.cogapp2.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.abdul.cogapp2.R;

public class DbActivity extends AppCompatActivity {
EditText etTitle,etNotes;
DbAccessObj dbAccessObj;
TodoRoomDb todoRoomDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        todoRoomDb = TodoRoomDb.getDatabase(this);

        etTitle = findViewById(R.id.etTitle);
        etNotes = findViewById(R.id.etNotes);
        dbAccessObj = new DbAccessObj(this);
        dbAccessObj.openDb();
    }

    public void dbHandler(View view) {
        switch (view.getId()){
            case R.id.btnCommit:
                String title = etTitle.getText().toString();
                String notes = etNotes.getText().toString();
                dbAccessObj.createRow(title,notes);
                etTitle.setText("");
                etNotes.setText("");
                break;
            case R.id.btnRetrevie:
                TextView dbTextView = findViewById(R.id.tvDb);
                dbTextView.setText(dbAccessObj.readRow());
                break;
        }
    }
}