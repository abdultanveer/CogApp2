package com.abdul.cogapp2;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        ListView cpListView = findViewById(R.id.lv_contentprovider);

        ContentResolver contentResolver = getContentResolver(); //fetch the content provider
        Uri uriSms = Uri.parse("content://sms/inbox");

        Cursor dataCursor = contentResolver.query(uriSms,null,null,null,null);

        String[] fromColNames = new String[]{"body"};
        int[] toTextviews = new int[]{android.R.id.text1};

        CursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                dataCursor,
                fromColNames,toTextviews);
        cpListView.setAdapter(adapter);

    }
}
