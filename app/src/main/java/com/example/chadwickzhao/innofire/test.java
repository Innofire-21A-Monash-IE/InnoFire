package com.example.chadwickzhao.innofire;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class test extends AppCompatActivity {



    com.github.mikephil.charting.charts.BarChart chart;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;
    int totaltoday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("username");
            //The key argument here must match that used in the other activity
        }



        chart = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY(totaltoday);

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Caffeine intake date");

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(3000);

        chart =(com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts);







    }

    public void AddValuesToBARENTRY(int totaltoday){

        BARENTRY.add(new BarEntry(2f, 0));




    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("January");
        BarEntryLabels.add("February");
        BarEntryLabels.add("March");
        BarEntryLabels.add("April");
        BarEntryLabels.add("May");
        BarEntryLabels.add("June");

    }

    public void check1(){
        new AsyncTask<String, Void, String>(){
            @Override
            protected String doInBackground(String... strings) {
                return Connection.findAll();
            }

            @Override
            protected void onPostExecute(String s) {

            }
        }.execute();
    }


}
