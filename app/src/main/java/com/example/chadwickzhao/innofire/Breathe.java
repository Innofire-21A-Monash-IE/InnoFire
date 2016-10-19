package com.example.chadwickzhao.innofire;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//this class is used to show the image of breathe
public class Breathe extends AppCompatActivity {
    ViewPager viewPager;
    BreatheSwipeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe);
        viewPager = (ViewPager) findViewById(R.id.view_pager1);
        adapter = new BreatheSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
