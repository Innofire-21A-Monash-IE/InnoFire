package com.example.chadwickzhao.innofire;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Input_layoutforRelax extends AppCompatActivity {


    Button sleepingHour;
    Button workingHour;
    Button caffeineTake;
    user u;
    int totaltoday;
    int SleepHoursinToday;
    AlertDialog alertDialog;

    String check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_layoutfor_relax);
        Intent i = getIntent();
        alertDialog = new AlertDialog.Builder(Input_layoutforRelax.this).create();
        alertDialog.setTitle("Reminder");
        alertDialog.setMessage("Sleep Hours have already stored in database, you can change the sleep hour input today");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        transferToSleep();
                        dialog.dismiss();
                    }
                });
        u = (user)i.getSerializableExtra("User-entity");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            //The key argument here must match that used in the other activity
        }

        sleepingHour = (Button) findViewById(R.id.sh);
        sleepingHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentDateTimeString;
                Date date1;
                date1 = new Date();
                Date finalDate;
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("yyyy-M-dd");
                currentDateTimeString = simpleDateFormat.format(date1);
                checktheSleepinghour(u.getUsername().toString(),currentDateTimeString);

            }
        });


        workingHour = (Button) findViewById(R.id.wh);
        workingHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transferToWork();
            }
        });
        caffeineTake = (Button) findViewById(R.id.ci);
        caffeineTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfertoCaffintake();
            }
        });

    }

    public void transfertoCaffintake(){
        Intent intent = new Intent(Input_layoutforRelax.this, Caffeine_intake.class);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("User-entity",u);
        startActivity(intent);
    }

    public void transferToSleep(){
        Intent intent = new Intent(Input_layoutforRelax.this, Sleephour_input.class);
        intent.putExtra("total", totaltoday);
        intent.putExtra("User-entity",u);
        startActivity(intent);
    }

    public void transferToWork(){
        Intent intent = new Intent(Input_layoutforRelax.this, Workinghour_input.class);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("User-entity",u);
        startActivity(intent);
    }


    public void checktheSleepinghour(final String username, final String currentdate){

        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                 check = Connection.checktheSleeping(username, currentdate);
                if(check.equals("0")){
                    transferToSleep();
                }
                else if(check.equals("1")){

                }
               return check;
            }
            protected void onPostExecute(String s) {
                alertDialog.show();

            }
        }.execute();
    }



}
