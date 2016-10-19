package com.example.chadwickzhao.innofire;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Sleephour_input extends AppCompatActivity {
    NumberPicker np;
    Button bt1;
    Button bt2;
    int try1;
    final Sleepinghours s = new Sleepinghours();
    user u;
    int totaltoday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleephour_input);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            //The key argument here must match that used in the other activity
        }
        np = (NumberPicker)findViewById(R.id.hours_pick);
        final TextView tv1 = (TextView) findViewById(R.id.Trythetimepicker);
        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        np.setMaxValue(24);
        np.setMinValue(0);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                tv1.setText("Selected Hour : " + i1);
                try1 = i1;
            }
        });
        bt1 = (Button) findViewById(R.id.input_sleephuor);
        bt2 = (Button) findViewById(R.id.gobacktommmm);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(try1 < 7){
                    AlertDialog alertDialog = new AlertDialog.Builder(Sleephour_input.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Lack of sleep");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(Sleephour_input.this).create();
                    alertDialog.setTitle("Reminder");
                    alertDialog.setMessage("Sleep Hours: " + try1);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

                Random r = new Random();
                int i1 = (r.nextInt(80) + 65);
                Date date1;
                date1 = new Date();
                String currentDateTimeString;
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("yyyy-M-dd");
                currentDateTimeString = simpleDateFormat.format(date1);
                String duration = String.valueOf(try1);
                s.setUsername(new user[]{u});
                s.setSdate(currentDateTimeString);
                s.setSduration(duration);
                s.setSleepingHourId(i1);
                process_ct();

            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                g_back();
            }
        });
    }

    public void g_back(){
        Intent intent = new Intent(Sleephour_input.this, MainActivity.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("sleep", try1);
        intent.putExtra("total", totaltoday);
        startActivity(intent);
    }


    public void process_ct(){
        new AsyncTask<String, Void, String>(){
            @Override
            protected String doInBackground(String... strings) {
                return Connection.createSleepRp(s);
            }

            @Override
            protected void onPostExecute(String s) {

            }
        }.execute();
    }
}
