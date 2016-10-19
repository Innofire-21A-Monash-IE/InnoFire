package com.example.chadwickzhao.innofire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//this is used to transfer to different type of caffeine intake layout
public class Caffeine_intake extends AppCompatActivity {

    //declaration of buttons and transfer data.
    Button bt1;
    Button bt2;
    Button bt4;
    Button bt5;
    Button bt6;
    private int totaltoday;
    int SleepHoursinToday;
    user u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caffeine_intake);

        bt1 = (Button)findViewById(R.id.type_coffee);
        bt2 = (Button)findViewById(R.id.type_energy);
        bt4 = (Button)findViewById(R.id.type_soft);
        bt5 = (Button)findViewById(R.id.type_tea);
        bt6 = (Button)findViewById(R.id.goback_toMain);

        //here is getting the data from the other layout
        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tocoffeetype();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toenergytype();
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tosofttype();
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toteatype();
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tobackmain();
            }
        });
    }

    //change to coffee intake page
    public void tocoffeetype(){
        Intent intent = new Intent(Caffeine_intake.this, CCCCCC.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("total", totaltoday);
        startActivity(intent);
    }

    //change to energy drink intake page
    public void toenergytype(){
        Intent intent = new Intent(Caffeine_intake.this, EEEEEE.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("total", totaltoday);
        startActivity(intent);
    }

    //change to tea intake page
    public void toteatype(){
        Intent intent = new Intent(Caffeine_intake.this, TTTTTTT.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("total", totaltoday);
        startActivity(intent);
    }

    //change to soft drink intake page
    public void tosofttype(){
        Intent intent = new Intent(Caffeine_intake.this, SSSSSSS.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("total", totaltoday);
        startActivity(intent);
    }

    //go back to main page
    public void tobackmain(){
        Intent intent = new Intent(Caffeine_intake.this, MainActivity.class);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("User-entity",u);
        startActivity(intent);
    }



}
