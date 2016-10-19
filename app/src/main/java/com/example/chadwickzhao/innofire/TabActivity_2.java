package com.example.chadwickzhao.innofire;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chadwickzhao on 6/09/16.
 */
public class TabActivity_2 extends Activity {
    com.github.mikephil.charting.charts.BarChart chart;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;
    int SleepHoursinToday;
    int tototot;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_activity_2);
        Intent in = getIntent();
        username = in.getExtras().get("uname").toString();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }

        chart = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts2);

        BARENTRY = new ArrayList<>();

        chart.setDescription("hour");
        BarEntryLabels = new ArrayList<String>();
        connectionofSleepinghours(username);

        AlertDialog alertDialog = new AlertDialog.Builder(TabActivity_2.this).create();
        alertDialog.setTitle("Notification");
        alertDialog.setMessage("Less than 8 hours- sleeping not enough");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
     //   AddValuesToBARENTRY(SleepHoursinToday);

    }

    public void connectionofSleepinghours(final String username){
        new AsyncTask<String, Void, List<Duration>>(){
            @Override
            protected List<Duration> doInBackground(String... strings) {
                String currentDateTimeString;
                Date date1;
                date1 = new Date();
                Date finalDate;
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("yyyy-M-dd");
                currentDateTimeString = simpleDateFormat.format(date1);
                return Connection.getDurationofSleep(username,currentDateTimeString);
            }

            protected void onPostExecute(final List<Duration> d) {
                if(d.size() > 0) {
                    for (int i = 0; i < d.size(); i++) {
                        int dur = Integer.parseInt(d.get(i).getWduration());
                        tototot = tototot + dur;
                    }

                    BARENTRY.add(new BarEntry(tototot, 0));

                    BarEntryLabels.add("Today");

                    Bardataset = new BarDataSet(BARENTRY, "Sleep Hours");

                    BARDATA = new BarData(BarEntryLabels, Bardataset);

                    Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

                    chart.setData(BARDATA);

                    chart.animateY(3000);

                    chart = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts);
                }else{

                }

            }
        }.execute();

    }
}
