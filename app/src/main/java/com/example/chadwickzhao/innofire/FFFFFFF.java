package com.example.chadwickzhao.innofire;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FFFFFFF extends AppCompatActivity {

    Spinner sp;
    Button addc;
    Button goback;
    private int intakeca;
    private int totaltoday;
    int SleepHoursinToday;
    private String test;
    final Caffeineintake c = new Caffeineintake();
    user u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fffffff);
        goback = (Button) findViewById(R.id.back1221111);
        sp = (Spinner) findViewById(R.id.spiiii1111);
        addc = (Button) findViewById(R.id.addpoo1111);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }

        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBacktoMain();;
            }
        });
        addc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test = sp.getSelectedItem().toString();

                if(test.equals("Chocolate drink with added milk solids 20mg/100ml")){
                    intakeca = 100;
                    Toast.makeText(FFFFFFF.this, "Chocolate drink with added milk solids 20mg/100ml", Toast.LENGTH_LONG).show();
                }else if(test.equals("Chocolate drink with high cocoa solids 59mg/100ml")){
                    intakeca = 100;
                    Toast.makeText(FFFFFFF.this, "Chocolate drink with high cocoa solids 59mg/100ml", Toast.LENGTH_LONG).show();
                }

                totaltoday += intakeca;
                String currentDateTimeString;
                Date date1;
                date1 = new Date();
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("yyyy-M-dd");
                currentDateTimeString = simpleDateFormat.format(date1);
                String input_caff = String.valueOf(intakeca);
                Random r = new Random();
                int i1 = (r.nextInt(80) + 65);
                c.setUsername(new user[]{u});
                c.setCaffeineintakeid(i1);
                c.setCaffeinetake(input_caff);
                c.setDate(currentDateTimeString);
                c.setTotalcaffeinetake(null);
                check2();
                if(totaltoday > 400){
                    AlertDialog alertDialog = new AlertDialog.Builder(FFFFFFF.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("too Much Caffeine intake");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }else {

                }
            }
        });
    }

    public void check2(){
        new AsyncTask<String, Void, String>(){
            @Override
            protected String doInBackground(String... strings) {
                return Connection.createRp(c);
            }

            @Override
            protected void onPostExecute(String s) {

            }
        }.execute();
    }
    public void goBacktoMain(){
        Intent intent = new Intent(FFFFFFF.this, MainActivity.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        startActivity(intent);
    }









}
