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
public class TabActivity_3 extends Activity{
    com.github.mikephil.charting.charts.BarChart chart;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA;
    int totaltoday;
    int SleepHoursinToday;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_activity_3);
        Intent in = getIntent();
        username = in.getExtras().get("uname").toString();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }

        AlertDialog alertDialog = new AlertDialog.Builder(TabActivity_3.this).create();
        alertDialog.setTitle("Notification");
        alertDialog.setMessage("0-400 not stress\n" +
                "400-600 normal\n" +
                "> 600 stress ");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        chart = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts3);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();
        connectoServer(username);

    }
    public void connectoServer(final String username){
        new AsyncTask<String, Void, List<StresslevelReportTest>>(){
            @Override
            protected List<StresslevelReportTest> doInBackground(String... strings) {
                return Connection.getbyUsernameofStress(username);
            }

            protected void onPostExecute(final List<StresslevelReportTest> s) {
                if(s != null) {
                    if (s.size() > 0) {
                        for (int i = 0; i < s.size(); i++) {
                            BARENTRY.add(new BarEntry(s.get(i).getStressLevel(), 0));
                            BarEntryLabels.add(s.get(i).getDate());
                        }
                        Bardataset = new BarDataSet(BARENTRY, "Stress Level");

                        BARDATA = new BarData(BarEntryLabels, Bardataset);

                        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

                        chart.setData(BARDATA);

                        chart.animateY(3000);

                        chart = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts3);
                    } else {

                    }
                }

            }
        }.execute();

    }


}
