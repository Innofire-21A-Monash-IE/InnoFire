package com.example.chadwickzhao.innofire;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.github.mikephil.charting.components.LimitLine;
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
public class TabActivity_1 extends Activity {
    com.github.mikephil.charting.charts.BarChart chart;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;
    int totaltoday;
    String username;
    int caffe5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_activity_1);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            // and get whatever type user account id is
        }
        Intent in = getIntent();
        username = in.getExtras().get("uname").toString();
        chart = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts1);
        chart.setDescription("mg");
        String currentDateTimeString;
        Date date1;
        date1 = new Date();
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-M-dd");
        currentDateTimeString = simpleDateFormat.format(date1);
        BARENTRY = new ArrayList<>();
        BarEntryLabels = new ArrayList<String>();
        connectionshow(username, currentDateTimeString);

        AlertDialog alertDialog = new AlertDialog.Builder(TabActivity_1.this).create();
        alertDialog.setTitle("Notification");
        alertDialog.setMessage("More than 400mg Caffeinintake -too much caffeine intake");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }

    public void connectionshow(final String username, final String dateString){
        new AsyncTask<String, Void, List<CaffeineintakeTest>>() {
            @Override
            protected List<CaffeineintakeTest> doInBackground(String... strings) {
                return Connection.getCaffeinbyusername(username, dateString);
            }
            @Override
            protected void onPostExecute(final List<CaffeineintakeTest> caffeineintakes) {
                if(caffeineintakes.size()>0) {
                    BarEntryLabels.add("total");
                    for (int i = 0; i < caffeineintakes.size(); i++) {
                        BARENTRY.add(new BarEntry(Integer.parseInt(caffeineintakes.get(i).getCaffeinetake()), i + 1));
                        BarEntryLabels.add(String.valueOf(i + 1));
                        caffe5 = caffe5 + Integer.parseInt(caffeineintakes.get(i).getCaffeinetake());
                    }
                    BARENTRY.add(new BarEntry(caffe5, 0));

                    Bardataset = new BarDataSet(BARENTRY, "Caffeine intake date");
                    Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                    BARDATA = new BarData(BarEntryLabels, Bardataset);
                    chart.setData(BARDATA);
                    chart.animateY(3000);
                    chart =(com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts);
                }else{


                }
            }
        }.execute();
    }

}
