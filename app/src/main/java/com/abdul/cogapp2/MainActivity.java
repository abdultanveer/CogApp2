package com.abdul.cogapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mainTv =  findViewById(R.id.tvMenu); //taking handle on the textview

        registerForContextMenu(mainTv);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_textview,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
         super.onContextItemSelected(item);
         switch (item.getItemId()){
             case R.id.edit:
                 Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.delete:
                 Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();

                 break;
         }

        return true;
    }
}