package com.example.chadwickzhao.innofire;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by chadwickzhao on 2/09/16.
 */
public class Repeating_activity extends AppCompatActivity{
    TextView tv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repeating_activity_layout);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv1.setText("-          Good job  your first 2 Hours of work has passed walk for 5 minutes and start fresh\n" +
                "-          Way to go you completed 4 hours of work , get a healthy  well balanced meal\n" +
                "-          You are doing great, you are nearly there , Don’t forget to smile\n" +
                "-          You are here, Congratulation on a productive day\n" +
                "-          I am well organized and doing well at my work\n" +
                "-           I love life and I respect the people surrounding me\n" +
                "-          Feeling thirsty, hydrate your body with a glass of water\n" +
                "-          Taking the stairs helps you improve your blood circulation\n" +
                "-          I can achieve anything I want\n" +
                "-          I'm coping well given what's on my plate\n" +
                "-          Planning your daily activities a head help you being less stressed\n" +
                "-          Walking for 30 minutes a day segmented to three 10 minutes  sessions help you change your mood\n" +
                "-          I am able to take full charge of my life\n" +
                "-          I am well established person and great employee\n" +
                "-          Finishing my work on time with less stress is my motto\n" +
                "-          I believe there are great things coming my way\n");

    }
}
