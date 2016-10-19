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

public class TTTTTTT extends AppCompatActivity {
    Spinner sp;
    Button addc;
    Button goback;
    private int intakeca;
    private int totaltoday;
    int SleepHoursinToday;
    TextView tv1;
    private String test;
    final Caffeineintake c = new Caffeineintake();
    user u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttttttt);
        goback = (Button) findViewById(R.id.ttttbbback);

        sp = (Spinner) findViewById(R.id.ttttspiner);
        tv1 = (TextView) findViewById(R.id.shotea);
        addc = (Button) findViewById(R.id.ttttbbbb1);
        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }

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

                if(test.equals("Black Tea(500ml)")){

                    Toast.makeText(TTTTTTT.this, "Black Tea(500ml)", Toast.LENGTH_LONG).show();
                    intakeca = 112;
                    tv1.append(test+ "\n");
                }else if(test.equals("Green Tea(500ml)")){

                    Toast.makeText(TTTTTTT.this, "Green ea(500ml)", Toast.LENGTH_LONG).show();
                    intakeca = 60;
                    tv1.append(test+ "\n");
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

                    AlertDialog alertDialog = new AlertDialog.Builder(TTTTTTT.this).create();
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
        Intent intent = new Intent(TTTTTTT.this, MainActivity.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        startActivity(intent);
    }
}
