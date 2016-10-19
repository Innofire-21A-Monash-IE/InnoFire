package com.example.chadwickzhao.innofire;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class text2 extends AppCompatActivity {
    TextView tv1;
    Button bt1;
    //user u;
   // Caffeineintake c;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text2);



//        final user u = new user();
//        u.setUsername("qia");
//        username = u.getUsername();


        username = "qia";


       // tv1.setText(stringCourseJson);


        tv1 = (TextView) findViewById(R.id.kankankanaknaknanimabi);
        bt1 = (Button) findViewById(R.id.tttttttttttttttttttttttttt);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           test1();


            }
        });

    }



    public void test1(){
        new AsyncTask<String, Void, List<CaffeineintakeTest>>(){
            @Override
            protected List<CaffeineintakeTest> doInBackground(String... strings) {
                return Connection.getCaffeinbyusername("Jack","abc");
            }
            @Override
            protected void onPostExecute(List<CaffeineintakeTest> s) {

                tv1.append(s.get(1).getCaffeinetake());
            }
        }.execute();
    }

    public void dotheconncetion(final int id){
        new AsyncTask<String, Void, List<StresslevelReportTest>>() {
            @Override
            protected List<StresslevelReportTest> doInBackground(String... strings) {
                return Connection.getStreebyGroupid(1);
            }
            @Override
            protected void onPostExecute(List<StresslevelReportTest> s) {


//                   inputvalue.add(0,StressLevel.intValue());


                // BarEntryLabels.add(s.get(i).getUsername());
                // }


            }
        }.execute();
    }
}
