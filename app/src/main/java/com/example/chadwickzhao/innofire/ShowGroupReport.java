package com.example.chadwickzhao.innofire;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ShowGroupReport extends AppCompatActivity {


    com.github.mikephil.charting.charts.BarChart chart;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_group_report);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           id = extras.getInt("id");
            // and get whatever type user account id is
        }
        chart = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts3);
        BARENTRY = new ArrayList<>();
        BarEntryLabels = new ArrayList<String>();
        dotheconncetion();
    }

    public void dotheconncetion(){
        new AsyncTask<String, Void, List<StresslevelReportTest>>() {
            @Override
            protected List<StresslevelReportTest> doInBackground(String... strings) {
                return Connection.getStreebyGroupid(id);
            }
            @Override
            protected void onPostExecute(List<StresslevelReportTest> s) {
                if (s != null) {
                    if (s.size() > 0) {

                        for (int i = 0; i < s.size(); i++) {
                            int StressLevel = s.get(i).getStressLevel();
                            String name1 = s.get(i).getUsername();
                            BARENTRY.add(new BarEntry(StressLevel, i));
                            BarEntryLabels.add(name1);

                        }

                        Bardataset = new BarDataSet(BARENTRY, "Stress Level");

                        BARDATA = new BarData(BarEntryLabels, Bardataset);

                        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

                        chart.setData(BARDATA);

                        chart.animateY(3000);

                        chart = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.barcharts);

                    }

                }
            }
        }.execute();
    }

}
