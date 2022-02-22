package com.abdul.cogapp2.whowroteit;

import androidx.appcompat.app.AppCompatActivity;

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

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
        new FetchBookTask(mTitleText, mAuthorText).execute(queryString);
    }
}