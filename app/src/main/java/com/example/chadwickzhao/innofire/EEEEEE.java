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

public class EEEEEE extends AppCompatActivity {

    Spinner sp;
    Button addc;
    Button goback;
    private int intakeca;
    private int totaltoday;
    private String test;
    int SleepHoursinToday;
    user u;
    TextView tv1;
    final Caffeineintake c = new Caffeineintake();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eeeeee);

        goback = (Button) findViewById(R.id.back122);
        sp = (Spinner) findViewById(R.id.spiiii);
        addc = (Button) findViewById(R.id.addpoo);
        tv1 = (TextView) findViewById(R.id.showenergy);
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
                if(test.equals("V(300ml)")){
                    intakeca = 84;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "V(300ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("V(500ml)")){
                    intakeca = 141;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "V(500ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Powerade Fuel Plus(300ml)")){
                    intakeca = 96;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "Powerade Fuel Plus(300ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Powerade Fuel Plus(500ml)")){
                    intakeca = 160;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "Powerade Fuel Plus(500ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Rockstar(300ml)")){
                    intakeca = 96;
                    Toast.makeText(EEEEEE.this, "Rockstar(300ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Rockstar(500ml)")){
                    intakeca = 160;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "Rockstar(500ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Red Bull(300ml)")){
                    intakeca = 96;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "Red Bull(300ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Red Bull(500ml)")){
                    intakeca = 160;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "Red Bull(500ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Monster(300ml)")){
                    intakeca = 96;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "Monster(300ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Monster(500ml)")){
                    intakeca = 160;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "Monster(500ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Mother(300ml)")){
                    intakeca = 96;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "Mother(300ml)", Toast.LENGTH_LONG).show();
                }else if(test.equals("Mother(500ml)")){
                    intakeca = 160;
                    tv1.append(test+ "\n");
                    Toast.makeText(EEEEEE.this, "Mother(500ml)", Toast.LENGTH_LONG).show();
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

                    AlertDialog alertDialog = new AlertDialog.Builder(EEEEEE.this).create();
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
        Intent intent = new Intent(EEEEEE.this, MainActivity.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        startActivity(intent);
    }
}
