package com.example.chadwickzhao.innofire;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.chadwickzhao.innofire.Connection.createUser;
import static com.example.chadwickzhao.innofire.Connection.findAll;

public class User_information extends AppCompatActivity {

    EditText name;
    EditText age;
    EditText occ;
    Spinner gender;
    EditText company;
    EditText position;
    Button done;
    user u;
    EditText edPassword;


    private String Username;
    private int Userage;
    private String Occupation;
    private String Gender;
    private String genderoption;
    private String Company;
    private String Position;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        name = (EditText) findViewById(R.id.ed_name);

        age = (EditText) findViewById(R.id.ed_age);

        gender = (Spinner) findViewById(R.id.gd);

        occ = (EditText) findViewById(R.id.ed_occ);


        company = (EditText) findViewById(R.id.ed_cy);

        position = (EditText) findViewById(R.id.ed_po);

        edPassword = (EditText) findViewById(R.id.ed_password);



        done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //check name is not empty
                if(name.getText().toString().trim().length()>0){


                    // check age is not empty
                    //check age is a number
                    String regexStr = "^[0-9]*$";
                    if(age.getText().toString().trim().matches(regexStr) && age.getText().toString().trim().length() > 0)
                    {
                        //write code here for success


                        genderoption = gender.getSelectedItem().toString();
                        if(genderoption.equals("Male")){
                            Gender = "Male";
                        }else if(genderoption.equals("Female")){
                            Gender = "Female";
                        }else if(genderoption.equals("Others")){
                            Gender = "Others";
                        }


                        Username = name.getText().toString();
                        u = new user();
                        Occupation = occ.getText().toString();
                        Position = position.getText().toString();
                        Company = company.getText().toString();

                        password = edPassword.getText().toString();
                        // Username = name.getText().toString();
                        Userage = Integer.parseInt(age.getText().toString());
                        u.setUsername(Username);
                        u.setPassword(password);
                        u.setGender(Gender);
                        u.setAge(Userage);
                        u.setOccupation(Occupation);
                        u.setPosition(Position);
                        u.setCompany(Company);

                        check2();
                        gobacktomain();
                    }
                    else{
                        // write code for failure
                        AlertDialog alertDialog = new AlertDialog.Builder(User_information.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("Age must be number");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }

                }else {

                    AlertDialog alertDialog = new AlertDialog.Builder(User_information.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Name cannot be empty");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }


            }
        });
    }


    public void check2(){
        new AsyncTask<String, Void, String>(){
            @Override
            protected String doInBackground(String... strings) {
                return Connection.createUser(u);
            }

            @Override
            protected void onPostExecute(String s) {

            }
        }.execute();
    }

    public void gobacktomain(){
        Intent intent = new Intent(User_information.this, MainActivity.class);
        intent.putExtra("User-entity", u);
        startActivity(intent);
    }
}
