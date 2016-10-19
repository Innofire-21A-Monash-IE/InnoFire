package com.example.chadwickzhao.innofire;

import android.app.TabActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("deprecation")
public class Report extends TabActivity {
    TabHost TabHostWindow;

    private int totaltoday;
    int SleepHoursinToday;
    user u;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        username = u.getUsername().toString();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }

        TabHostWindow = (TabHost)findViewById(android.R.id.tabhost);
        TabSpec TabMenu1 = TabHostWindow.newTabSpec("First tab");
        TabSpec TabMenu2 = TabHostWindow.newTabSpec("Second Tab");
        TabSpec TabMenu3 = TabHostWindow.newTabSpec("Third Tab");
        //Setting up tab 1 name.
        TabMenu1.setIndicator("Caffeine intake");
        //Set tab 1 activity to tab 1 menu.
        Intent pass1 = new Intent();
        pass1.putExtra("total", totaltoday);
        pass1.putExtra("uname", username);
        pass1.setClass(this, TabActivity_1.class);
        TabMenu1.setContent(pass1);
        //Setting up tab 2 name.
        TabMenu2.setIndicator("Sleep Hour");
        //Set tab 3 activity to tab 1 menu.
        Intent pass2 = new Intent();
        pass2.putExtra("sleep", SleepHoursinToday);
        pass2.putExtra("uname", username);
        pass2.setClass(this, TabActivity_2.class);
        TabMenu2.setContent(pass2);

        //Setting up tab 2 name.
        TabMenu3.setIndicator("Stress Level");
        //Set tab 3 activity to tab 3 menu.
        Intent pass3 = new Intent();
        pass3.putExtra("sleep", SleepHoursinToday);
        pass3.putExtra("total", totaltoday);
        pass3.putExtra("uname", username);
        pass3.setClass(this, TabActivity_3.class);
        TabMenu3.setContent(pass3);
        //Adding tab1, tab2, tab3 to tabhost view.
        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);
        TabHostWindow.addTab(TabMenu3);
    }

}