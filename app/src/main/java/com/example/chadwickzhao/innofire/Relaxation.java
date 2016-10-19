package com.example.chadwickzhao.innofire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Relaxation extends AppCompatActivity {

    Button gotoVideo;
    Button gotoBreathe;
    Button gotoImage;
    Button gotoRelaxationPlace;
    user u;
    int totaltoday;
    int SleepHoursinToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxation);
        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            //The key argument here must match that used in the other activity
        }
        gotoVideo = (Button) findViewById(R.id.video);
        gotoVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transferToVideo();
            }
        });
        gotoBreathe = (Button) findViewById(R.id.breathe);
        gotoBreathe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transferToBreath();
            }
        });
        gotoImage = (Button) findViewById(R.id.imagemusic);
        gotoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transferToImage();
            }
        });
        gotoRelaxationPlace = (Button) findViewById(R.id.relaxationplace);
        gotoRelaxationPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfertoParkMap();
            }
        });
    }

    public void transferToVideo(){
        Intent intent = new Intent(Relaxation.this, Video_activity.class);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("User-entity",u);
        startActivity(intent);
    }

    public void transferToBreath(){
        Intent intent = new Intent(Relaxation.this, Breathe.class);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("User-entity",u);
        startActivity(intent);
    }

    public void transferToImage(){
        Intent intent = new Intent(Relaxation.this, Image_view_activity.class);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("User-entity",u);
        startActivity(intent);
    }


    public void transfertoParkMap(){
        Intent intent = new Intent(Relaxation.this, Map.class);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        intent.putExtra("User-entity",u);
        startActivity(intent);
    }



}
