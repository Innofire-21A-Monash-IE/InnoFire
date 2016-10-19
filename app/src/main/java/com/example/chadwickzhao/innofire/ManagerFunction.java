package com.example.chadwickzhao.innofire;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ManagerFunction extends AppCompatActivity {
    Button showGroupReport, AssignMemberbtn, CreateGroupbtn, ShowTips;
    user u;
    ArrayList<String> NameList;
    private int totaltoday;
    int SleepHoursinToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_function);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }

        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        NameList = i.getStringArrayListExtra("transfername");
        showGroupReport = (Button) findViewById(R.id.groupreprot);
        AssignMemberbtn = (Button) findViewById(R.id.AssignMember);
        CreateGroupbtn = (Button) findViewById(R.id.CreateGroup);
        ShowTips = (Button) findViewById(R.id.showtips);

        ShowTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfertoTips();
            }
        });

        showGroupReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGroupid2();
            }
        });

        AssignMemberbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGroupid();
            }
        });

        CreateGroupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transfertoCreateGroup();
            }
        });
    }


    public void transfertoCreateGroup(){
        Intent intent = new Intent(ManagerFunction.this, CreateGroup.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        startActivity(intent);
    }
    public void transfettoAssignmember(int id){
        Intent intent = new Intent(ManagerFunction.this, AssignMember.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("id", id);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        startActivity(intent);
    }
    public void transfertoGroupReport(int id){
        Intent intent = new Intent(ManagerFunction.this, ShowGroupReport.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("total", totaltoday);
        intent.putExtra("id", id);
        intent.putExtra("sleep", SleepHoursinToday);
        startActivity(intent);
    }

    public void transfertoTips(){
        Intent intent = new Intent(ManagerFunction.this, SelectyourOwnEntertainment.class);
        intent.putExtra("User-entity",u);
        intent.putExtra("total", totaltoday);
        intent.putExtra("sleep", SleepHoursinToday);
        startActivity(intent);
    }

    public void getGroupid(){
        new AsyncTask<String, Void, List<GetthegroupID>>(){
            @Override
            protected List<GetthegroupID> doInBackground(String... strings) {
                String username =  u.getUsername();
                return Connection.getbyUsernameofGroupid(username);
            }
            @Override
            protected void onPostExecute(List<GetthegroupID> s) {
                int id = s.get(0).groupid;
                transfettoAssignmember(id);
            }
        }.execute();
    }

    public void getGroupid2(){
        new AsyncTask<String, Void, List<GetthegroupID>>(){
            @Override
            protected List<GetthegroupID> doInBackground(String... strings) {
                String username =  u.getUsername();
                return Connection.getbyUsernameofGroupid(username);
            }
            @Override
            protected void onPostExecute(List<GetthegroupID> s) {
                int id = s.get(0).groupid;
                transfertoGroupReport(id);
            }
        }.execute();
    }

}
