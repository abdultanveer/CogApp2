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

        String[] fromColNames = new String[]{"address","body"};
        int[] toTextviews = new int[]{R.id.tvPhoneno,R.id.tvSms};
                //android.R.id.text1,android.R.id.text2};

        CursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.cp_row_listview,
                //android.R.layout.simple_list_item_2,
                dataCursor,
                fromColNames,toTextviews);
        cpListView.setAdapter(adapter);

    }
}
