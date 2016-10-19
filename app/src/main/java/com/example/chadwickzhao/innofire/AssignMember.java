package com.example.chadwickzhao.innofire;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.vision.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//This class is used for Assign memebr into the Group
public class AssignMember extends AppCompatActivity {
//here is the declaration of every variable
    TextView tv1;
    final Group1 g = new Group1();
    user u;
    ArrayAdapter<String> adapter;
    ListView lv1;
    String[] Username;
    String companyname = "Nothing";
    String transfername = "";
    private int totaltoday;
    int SleepHoursinToday;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_member);
        //here is get the intent contain during the turn into this page
        Intent i = getIntent();
        //here will get the user class from the last page
        u = (user)i.getSerializableExtra("User-entity");
        companyname = u.getCompany().toString();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            totaltoday = extras.getInt("total");
            SleepHoursinToday = extras.getInt("sleep");
            id = extras.getInt("id");
            // and get whatever type user account id is
        }
        //this one is show the list of the member in the same company
        showlistinback(companyname);
       // showadd = (TextView) findViewById(R.id.show_add);
       // btndone = (Button) findViewById(R.id.comfirm);
        //this one is used for matching the element in the assign member layout.
        tv1 = (TextView) findViewById(R.id.testttt);
        lv1 = (ListView) findViewById(R.id.trythis);
        //this one is used for the listview on select item when we click
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //this is the pop up message about who you have already added in the group
                transfername = adapterView.getItemAtPosition(i).toString();
                //this used to upload the member into database
                if(transfername.trim().length()>0){
                    getUserProfile(transfername);
                    checkTheGroup(transfername);
                    Toast.makeText(AssignMember.this, "Add " +
                            adapterView.getItemAtPosition(i).toString() , Toast.LENGTH_LONG).show();
                }
               // tv1.append(transfername);
            }
        });
//        btndone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(AssignMember.this, ManagerFunction.class);
//                intent.putExtra("transfername", transfername);
//                startActivity(intent);
//            }
//        });
    }
//doing the connection and upload in backgroud
    public void showlistinback(final String companyname){
        new AsyncTask<Void, Void, List<user>>(){
            @Override
            protected List<user> doInBackground(Void... voids) {
                //connection's method calling
                return Connection.findbycompany(companyname);
            }
            @Override
            protected void onPostExecute(final List<user> users) {
                //if there is not a user then it will be show the alert message
                if(users == null){
                    AlertDialog alertDialog = new AlertDialog.Builder(AssignMember.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("No member here");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }else {
                    //if there is a user in the list, it will show the user in a list view cell
                    if(users.size() != 0){
                        String name1, name2, name3, name4, name5, name6, name7, name8, name9;
                        String name = users.get(0).getUsername().toString();
                        if(users.size() > 1 &&  users.get(1) != null){
                             name1 = users.get(1).getUsername().toString();
                        }else{
                             name1 = "";
                        }
                        if(users.size() > 2 && users.get(2) != null){
                             name2 = users.get(2).getUsername().toString();
                        }else{
                             name2 = "";
                        }
                        if(users.size() > 3 && users.get(3) != null){
                             name3 = users.get(3).getUsername().toString();
                        }else{
                             name3 = "";
                        }
                        if(users.size() > 4 && users.get(4) != null){
                             name4 = users.get(4).getUsername().toString();
                        }else{
                             name4 = "";
                        }
                        if(users.size() > 5 && users.get(5) != null){
                             name5 = users.get(5).getUsername().toString();
                        }else{
                             name5 = "";
                        }
                        if(users.size() > 6 && users.get(6) != null){
                             name6 = users.get(6).getUsername().toString();
                        }else{
                             name6 = "";
                        }
                        if(users.size() > 7 && users.get(7) != null){
                            name7 = users.get(7).getUsername().toString();
                        }else{
                            name7 = "";
                        }
                        if(users.size() > 8 && users.get(8) != null){
                            name8 = users.get(4).getUsername().toString();
                        }else{
                            name8 = "";
                        } if(users.size() > 9 && users.get(9) != null){
                            name9 = users.get(9).getUsername().toString();
                        }else{
                            name9 = "";
                        }
                        Username = new String[]{name, name1, name2, name3, name4, name5, name6, name7, name8, name9};
                        // adapter.add();
                        //this adapter is used to fill the name into list
                        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Username);
                        lv1.setAdapter(adapter);
                    }else{
                        AlertDialog alertDialog = new AlertDialog.Builder(AssignMember.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("No member here");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }
            }
        }.execute();
    }
//get the member's member user information
    public void getUserProfile(final String username){
        new AsyncTask<String, Void, List<user>>() {
            @Override
            protected List<user> doInBackground(String... strings) {
                return Connection.getbyUsername(username);
            }
            @Override
            protected void onPostExecute(final List<user> users) {
                //here will get the user who is assigned by the manager
                u = users.get(0);
                Random r = new Random();
                int i1 = (r.nextInt(80) + 65);
                g.setUsername(new user[]{u});
                g.setGroupId(id);
                // g.setGroupId(Integer.parseInt(groupid.getText().toString()));
                g.setGroupUserId(i1);
                processCreateGroup();
            }
        }.execute();
    }
//Assign the member into the same group and assign the member
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


    public void checkTheGroup(final String username) {
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return Connection.findthegroupidingroup(username);
            }
            @Override
            protected void onPostExecute(String s) {
                if(s.equals("y")){
                    AlertDialog alertDialog = new AlertDialog.Builder(AssignMember.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("This member has already been in group");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        }.execute();
    }

}
