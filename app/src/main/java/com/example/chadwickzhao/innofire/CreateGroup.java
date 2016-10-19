package com.example.chadwickzhao.innofire;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.charset.CodingErrorAction;
import java.util.Random;

public class CreateGroup extends AppCompatActivity {

    EditText groupname, groupid, groupcapacity;
    Button btnfinish;
    user u;
    final Group1 g = new Group1();
    private int totaltoday;
    int SleepHoursinToday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            // and get whatever type user account id is
        }
        Intent i = getIntent();
        u = (user)i.getSerializableExtra("User-entity");
        groupname = (EditText) findViewById(R.id.input_groupname);
        groupid = (EditText) findViewById(R.id.input_groupid);
        groupcapacity = (EditText) findViewById(R.id.input_capaciity);
        btnfinish = (Button) findViewById(R.id.done_input_group);
        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (groupid.getText().toString().trim().length() > 0 && groupcapacity.getText().toString().trim().length() >
                        0) {
                    Random r = new Random();
                    int i1 = (r.nextInt(80) + 65);
                    g.setUsername(new user[]{u});
                    g.setGroupcapacity(Integer.parseInt(groupcapacity.getText().toString()));
                    g.setGroupId(Integer.parseInt(groupid.getText().toString()));
                    g.setGroupname(groupname.getText().toString());
                    g.setGroupUserId(i1);
                    processCreateGroup();
                    AlertDialog alertDialog = new AlertDialog.Builder(CreateGroup.this).create();
                    alertDialog.setTitle("Reminder");
                    alertDialog.setMessage("The group have been created");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    transfertoManager();
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(CreateGroup.this).create();
                    alertDialog.setTitle("Reminder");
                    alertDialog.setMessage("The groupid or capacity need fill");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    transfertoManager();
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }

    public void processCreateGroup(){
        new AsyncTask<String, Void, String>(){
            @Override
            protected String doInBackground(String... strings) {
                return Connection.createGroup(g);
            }
            @Override
            protected void onPostExecute(String s) {
            }
        }.execute();
    }

    public void transfertoManager(){
        Intent intent = new Intent(CreateGroup.this, ManagerFunction.class);
        startActivity(intent);
    }

}
