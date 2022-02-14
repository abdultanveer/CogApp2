package com.abdul.cogapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clickHandler(View view) {
        EditText etEmail = findViewById(R.id.etEmail);
        String enteredString = etEmail.getText().toString();
        TextView opTextView = findViewById(R.id.tvResult);
        opTextView.setText(enteredString);
    }
}