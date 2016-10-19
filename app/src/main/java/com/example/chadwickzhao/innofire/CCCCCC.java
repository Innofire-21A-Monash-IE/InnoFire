package com.example.chadwickzhao.innofire;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CCCCCC extends AppCompatActivity {

    Spinner sp;

    Button addc;
    Button goback;
    private int intakeca;
    private int totaltoday;
    int SleepHoursinToday;

    private String test;
    final Caffeineintake c = new Caffeineintake();
    user u;
    TextView tv1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cccccc);
        goback = (Button) findViewById(R.id.back1);

        tv1 = (TextView) findViewById(R.id.testfortrans);
        sp = (Spinner) findViewById(R.id.spinnnn);
        addc = (Button) findViewById(R.id.addp);
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

                if(test.equals("Cappuccino/Short(235ml)")){
                    intakeca = 240;
                    tv1.append(test+ "\n" );
                    Toast.makeText(CCCCCC.this, "Cappuccino/Short(235ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Cappuccino/Tall(235ml)")){
                    intakeca = 362;
                    tv1.append(test+ "\n");
                    Toast.makeText(CCCCCC.this, "Cappuccino/Tall(235ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Flat white/Short(235ml)")){
                    Toast.makeText(CCCCCC.this, "Flat white/Short(235ml)", Toast.LENGTH_LONG).show();
                    intakeca = 204;
                    tv1.append(test+ "\n");
                }else if(test.equals("Flat white/Tall(355ml)")){
                    intakeca = 308;
                    tv1.append(test+ "\n");
                    Toast.makeText(CCCCCC.this, "Flat white/Tall(355ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Longblack/Short(235ml)")){
                    tv1.append(test+ "\n");
                    Toast.makeText(CCCCCC.this, "Longblack/Short(235ml)", Toast.LENGTH_LONG).show();
                    intakeca = 176;
                }else if(test.equals("Longblack/Tall(355ml)")){
                    tv1.append(test+ "\n");
                    intakeca = 265;
                    Toast.makeText(CCCCCC.this, "Longblack/Tall(355ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Mocchaccino/Short(235ml)")){
                    tv1.append(test+ "\n");
                    Toast.makeText(CCCCCC.this, "Mocchaccino/Short(235ml)", Toast.LENGTH_LONG).show();
                    intakeca = 229;
                }else if(test.equals("Mocchaccino/Short(235ml)")){
                    tv1.append(test+ "\n");
                    Toast.makeText(CCCCCC.this, "Mocchaccino/Tall(355ml)", Toast.LENGTH_LONG).show();
                    intakeca = 346;
                }else if(test.equals("From ground coffee beans, espresso style@ (285ml)")){
                    tv1.append(test+ "\n");
                    Toast.makeText(CCCCCC.this, "From ground coffee beans, espresso style@ (285ml)", Toast.LENGTH_LONG).show();
                    intakeca = 194;
                }

                totaltoday += intakeca;
                String currentDateTimeString;
                Date date1;
                date1 = new Date();
                Date finalDate;
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("yyyy-M-dd");
                currentDateTimeString = simpleDateFormat.format(date1);
                try {
                    finalDate = simpleDateFormat.parse(simpleDateFormat.format(date1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String input_caff = String.valueOf(intakeca);
                Random r = new Random();
                java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                int i1 = (r.nextInt(80) + 65);
                c.setUsername(new user[]{u});
                c.setCaffeineintakeid(i1);
                c.setCaffeinetake(input_caff);
                c.setDate(currentDateTimeString);
                c.setTotalcaffeinetake(null);
                check2();
                if(totaltoday > 400){
                    AlertDialog alertDialog = new AlertDialog.Builder(CCCCCC.this).create();
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
        Intent intent = new Intent(CCCCCC.this, MainActivity.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("total", totaltoday);
        startActivity(intent);
    }

}
