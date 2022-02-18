package com.abdul.cogapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class AsyncActivity extends AppCompatActivity {
    public static String TAG = AsyncActivity.class.getSimpleName();
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        progressBar = findViewById(R.id.progressBar);
    }


    @Override
    protected void onStart() {
        super.onStart();
       /* FirebaseMessaging.getInstance().getToken().addOnCompleteListener(
                new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                       // val token: String = task.getResult().toString()
                       String token = task.getResult().toString();
                        Log.i(TAG,"token is--"+token);

                    }
                }
        );*/

    }

    public void startDownload(View view) {
        DownloadTask downloadTask = new DownloadTask(progressBar);
        downloadTask.execute("http://youtube.com/movie");
    }

    public void showNotification(View view) {
        createNotificationChannel();
        Intent intent = new Intent(this, CalendarActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "123") // context and channel id are required
                //all these below are optional
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("Title notification")
                .setContentText("content text longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(007, builder.build());

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel name";
                    //getString(R.string.channel_name);
            String description = "channel description";
                    //getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("123", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void serviceHandler(View view) {
        Intent sIntent = new Intent(AsyncActivity.this, MyService.class);

        switch (view.getId()){
            case R.id.btnStart:
                sIntent.putExtra("url","http:downloadurl.com");
                startService(sIntent);
                break;
            case R.id.btnStop:
                stopService(sIntent);
                break;
            case R.id.btnBind:
                Intent bIntent = new Intent(AsyncActivity.this, AdditionService.class);
                bindService(bIntent,serviceConnection,BIND_AUTO_CREATE);//BIND_AUTO_CREATE -- if the service is not running then create one
               // unbindService(serviceConnection);
                break;
        }

    }
    public AdditionService additionService;

    //additionService = new AdditionService(); i am not creating the object of AdditionService instead im getting a running instance
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) { //  additionservice on bind method return this iBinder
            AdditionService.LocalBinder localBinder = (AdditionService.LocalBinder) iBinder; //im not creating an instance but getting it
            additionService = localBinder.getService();
           int result = additionService.add(10,20);

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}