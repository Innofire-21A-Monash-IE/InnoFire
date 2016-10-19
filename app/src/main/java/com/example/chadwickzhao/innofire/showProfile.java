package com.example.chadwickzhao.innofire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showProfile extends AppCompatActivity {

    TextView showName, showAge,showCompany, showPosition, showGender;
    Button btnBack;
    user u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);


        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        showName = (TextView) findViewById(R.id.showUsername);
        showAge = (TextView) findViewById(R.id.showAge);
        showCompany = (TextView) findViewById(R.id.showCompany);
        showPosition = (TextView) findViewById(R.id.showPosition);
        showGender = (TextView) findViewById(R.id.showGender);
        btnBack = (Button) findViewById(R.id.backtoMain1);


        if(u.getUsername() != null){
            showName.setText(u.getUsername());
        }
        if(u.getAge() != null){
            showAge.setText(u.getAge().toString());
        }
        if(u.getCompany() != null){
            showCompany.setText(u.getCompany());
        }
        if(u.getPosition() != null){
            showPosition.setText(u.getPosition());
        }
        if(u.getGender() != null){
            showGender.setText(u.getGender());
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfertoMain();
            }
        });

    }

    public void transfertoMain(){
        Intent intent = new Intent(showProfile.this, MainActivity.class);
        intent.putExtra("User-entity",u);
        startActivity(intent);

    }

}
