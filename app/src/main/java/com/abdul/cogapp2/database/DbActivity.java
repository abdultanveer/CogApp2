package com.abdul.cogapp2.database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.abdul.cogapp2.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbActivity extends AppCompatActivity {
EditText etTitle,etNotes;
DbAccessObj dbAccessObj;
TodoRoomDb todoRoomDb;
TodoDao todoDao;
public  static String TAG = DbActivity.class.getSimpleName();
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        todoRoomDb = TodoRoomDb.getDatabase(this);
        todoDao = todoRoomDb.todoDao();
        etTitle = findViewById(R.id.etTitle);
        etNotes = findViewById(R.id.etNotes);
        dbAccessObj = new DbAccessObj(this);
        dbAccessObj.openDb();
    }

    @Override
    protected void onStart() {
        super.onStart();
         db = FirebaseFirestore.getInstance();
    }

    public void dbHandler(View view) {
        switch (view.getId()){
            case R.id.btnCommit:
                String title = etTitle.getText().toString();
                String notes = etNotes.getText().toString();
                insertAsync(title,notes);
                /*dbAccessObj.createRow(title,notes);
                etTitle.setText("");
                etNotes.setText("");*/
                break;
            case R.id.btnRetrevie:
                /*TextView dbTextView = findViewById(R.id.tvDb);
                dbTextView.setText(dbAccessObj.readRow());*/
                searchTodo(etTitle.getText().toString());
                break;
        }
    }

    private void searchTodo(String searchString) {
        TextView dbTextView = findViewById(R.id.tvDb);

        new SearchTask(searchString,dbTextView).execute();
    }

    private void insertAsync(String title, String notes) {
        new InsertTask(title,notes).execute();
        etTitle.setText("");
        etNotes.setText("");
    }

    public void firestoreHandler(View view) {
        switch (view.getId()){
            case R.id.btnFirecommit:
                fireCommit();
                break;
            case R.id.btnFireRetreive:
                break;
        }
    }

    private void fireCommit() {
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }


    class InsertTask extends AsyncTask<Void,Void,Void>{
        String mTitle, mNotes;


        public InsertTask(String title, String notes) {
            mTitle = title;
            mNotes = notes;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            todoDao.insert(new Todo(mTitle,mNotes));

            return null;
        }
    }

    class SearchTask extends AsyncTask<Void,Void, List<Todo>> {
        String mString;
        TextView mTextView;
        public SearchTask(String searchString, TextView dbTextView) {
            mString = searchString;
            mTextView = dbTextView;
        }

        @Override
        protected List<Todo> doInBackground(Void... voids) {
            return todoDao.findWord(mString);

        }

        @Override
        protected void onPostExecute(List<Todo> todos) {
            super.onPostExecute(todos);
            mTextView.setText(todos.get(0).title + "\n"+ todos.get(0).notes);
        }
    }
}