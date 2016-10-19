package com.example.chadwickzhao.innofire;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Workinghour_input extends AppCompatActivity {
    Button bt_start;
    Button bt_end;
    TextView showdiff;
    String currentDateTimeString;
    int totaltoday;
    int SleepHoursinToday;
    StoreDate sd;
    final Workinghours w = new Workinghours();
    user u;
    Date date1;
    Date date2;

    SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("dd/M/yyyy hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workinghour_input);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }

        bt_start = (Button)findViewById(R.id.start_record);
        bt_end = (Button)findViewById(R.id.end_record);
        showdiff = (TextView)findViewById(R.id.showdifferent);
        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date1 = new Date();
                sd = new StoreDate();
                sd.setDate1(date1);
                currentDateTimeString = simpleDateFormat.format(date1);
                showdiff.setText(currentDateTimeString);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, 21);
                calendar.set(Calendar.MINUTE, 34);
                calendar.set(Calendar.SECOND, 0);
                Intent intent = new Intent(getApplicationContext(), Notification_Reciever.class);
                PendingIntent pendingIntent =  PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
            }
        });

        bt_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date2 = new Date();
            //    date1 = sd.getDate1();
                if (date1 == null){
                    android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(Workinghour_input.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Before your click end, you need start first");
                    alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();


                }else{
                long diff = date2.getTime() - date1.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000);

                showdiff.setText(String.valueOf(diffHours) + ":" + diffMinutes + ":" + diffSeconds);
                String recordtime;
                String duration;
                duration = String.valueOf(diffHours) + ":" + diffMinutes + ":" + diffSeconds;
                Random r = new Random();
                int i1 = (r.nextInt(80) + 65);
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
                recordtime = simpleDateFormat.format(date2);
                w.setUsername(new user[]{u});
                w.setWdate(recordtime);
                w.setWduration(duration);
                w.setWorkinghourid(i1);
                process_ct();


                Toast.makeText(Workinghour_input.this, "You have already work for " + String.valueOf(diffHours) + ":" + diffMinutes + ":" + diffSeconds, Toast.LENGTH_LONG).show();

            }}
        });

    }


    public void process_ct() {
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return Connection.createWorkRp(w);
            }

            @Override
            protected void onPostExecute(String s) {

            }
        }.execute();
    }




}
