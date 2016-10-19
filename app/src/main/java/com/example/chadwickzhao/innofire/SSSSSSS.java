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

public class SSSSSSS extends AppCompatActivity {

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
        setContentView(R.layout.activity_sssssss);
        goback = (Button) findViewById(R.id.btsgohou);

        sp = (Spinner) findViewById(R.id.spinnersss);
        tv1 = (TextView) findViewById(R.id.showsoft);
        addc = (Button) findViewById(R.id.btsssss);
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
//                if(test.equals("Pepsi MAX")){
//                    intakeca = 69;
//                    Toast.makeText(SSSSSSS.this, "Pepsi MAX 69mg Caffeine", Toast.LENGTH_LONG).show();
//                }else if(test.equals("Mountain Zevia (Zevia)")){
//                    intakeca = 55;
//                    Toast.makeText(SSSSSSS.this, "Mountain Zevia (Zevia) 55mg Caffeine", Toast.LENGTH_LONG).show();
//                }
//

                if(test.equals("Coke Zero(375ml)")){
                    intakeca = 36;
                    tv1.append(test+ "\n");

                    Toast.makeText(SSSSSSS.this, "Coke Zero(375ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Coke Zero(500ml)")){
                    Toast.makeText(SSSSSSS.this, "Coke Zero(500ml)", Toast.LENGTH_LONG).show();
                    tv1.append(test+ "\n");
                    intakeca = 48;
                }else if(test.equals("Coca Cola(375ml)")){
                    Toast.makeText(SSSSSSS.this, "Coca Cola(375ml)", Toast.LENGTH_LONG).show();
                    intakeca = 34;
                    tv1.append(test+ "\n");
                }else if(test.equals("Coca Cola(500ml)")){
                    Toast.makeText(SSSSSSS.this, "Coca Cola(500ml)", Toast.LENGTH_LONG).show();
                    intakeca = 45;
                    tv1.append(test+ "\n");
                }else if(test.equals("Mountain Dew(Aus)(375ml)")){
                    Toast.makeText(SSSSSSS.this, "Mountain Dew(Aus)(375ml)", Toast.LENGTH_LONG).show();
                    intakeca = 51;
                    tv1.append(test+ "\n");
                }else if(test.equals("Mountain Dew(Aus)(500ml)")){
                    Toast.makeText(SSSSSSS.this, "Mountain Dew(Aus)(500ml)", Toast.LENGTH_LONG).show();
                    intakeca = 68;
                    tv1.append(test+ "\n");
                }else if(test.equals("Mountain Dew(NZ)(375ml)")){
                    Toast.makeText(SSSSSSS.this, "Mountain Dew(NZ)(375ml)", Toast.LENGTH_LONG).show();
                    intakeca = 56;
                    tv1.append(test+ "\n");
                }else if(test.equals("Mountain Dew(NZ)(500ml)")){
                    Toast.makeText(SSSSSSS.this, "Mountain Dew(NZ)(375ml)", Toast.LENGTH_LONG).show();
                    intakeca = 75;
                    tv1.append(test+ "\n");
                }else if(test.equals("Pepsi(375ml)")){
                    Toast.makeText(SSSSSSS.this, "Pepsi(375ml)", Toast.LENGTH_LONG).show();
                    intakeca = 40;
                }else if(test.equals("Pepsi(500ml)")){
                    Toast.makeText(SSSSSSS.this, "Pepsi(500ml)", Toast.LENGTH_LONG).show();
                    intakeca = 54;
                    tv1.append(test+ "\n");
                }else if(test.equals("Pepsi Max(375ml)")){
                    Toast.makeText(SSSSSSS.this, "Pepsi Max(375ml)", Toast.LENGTH_LONG).show();
                    intakeca = 45;
                    tv1.append(test+ "\n");
                }else if(test.equals("Pepsi Max(500ml)")){
                    Toast.makeText(SSSSSSS.this, "Pepsi Max(500ml)", Toast.LENGTH_LONG).show();
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

                    AlertDialog alertDialog = new AlertDialog.Builder(SSSSSSS.this).create();
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
        Intent intent = new Intent(SSSSSSS.this, MainActivity.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        startActivity(intent);
    }



}
