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

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Random;

public class CaffeineIntakeAu extends AppCompatActivity {
    private int intakeca;
    private int totaltoday;
    Spinner sp;

    Button addc;
    Button goback;

    private String test;
    final Caffeineintake c = new Caffeineintake();
    user u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caffeine_intake_au);
        goback = (Button) findViewById(R.id.back11);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBacktoMain();;
            }
        });
        sp = (Spinner) findViewById(R.id.spinnnn1);
        addc = (Button) findViewById(R.id.addp1);
        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            // and get whatever type user account id is
        }


        addc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                test = sp.getSelectedItem().toString();


                totaltoday += intakeca;
                String currentDateTimeString;
                Date date1;
                //date1 = new Date();
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
               // currentDateTimeString = simpleDateFormat.format(date1);
                String input_caff = String.valueOf(intakeca);
                Random r = new Random();
                int i1 = (r.nextInt(80) + 65);
                c.setUsername(new user[]{u});
                c.setCaffeineintakeid(i1);
                c.setCaffeinetake(input_caff);
               // c.setDate(date1);
                c.setTotalcaffeinetake(null);
                check2();


                if(totaltoday > 400){

                    AlertDialog alertDialog = new AlertDialog.Builder(CaffeineIntakeAu.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Be aware you have exceeded your caffeine intake for today");
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
        Intent intent = new Intent(CaffeineIntakeAu.this, MainActivity.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("total", totaltoday);
        startActivity(intent);
    }
}
