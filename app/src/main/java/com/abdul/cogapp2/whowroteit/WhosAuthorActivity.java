package com.abdul.cogapp2.whowroteit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.abdul.cogapp2.R;

public class WhosAuthorActivity extends AppCompatActivity {
    EditText mBookInput;
    TextView mTitleText, mAuthorText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whos_author);
        mBookInput = findViewById(R.id.bookInput);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    private void saveData() {
        //get the data from edittext
        String data = mBookInput.getText().toString();
        //create a file
        SharedPreferences preferences = getSharedPreferences("cognizant_prefs",MODE_PRIVATE);
        //open the file
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString("bookname", data);
        //save the file
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    void restoreData(){
        //open the file
        SharedPreferences preferences = getSharedPreferences("cognizant_prefs",MODE_PRIVATE);
        //read from the file
        String dataRead = preferences.getString("bookname","");
        //set the data into the edittext
        mBookInput.setText(dataRead);
    }

    
    
    
    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
        new FetchBookTask(mTitleText, mAuthorText).execute(queryString);
    }
}