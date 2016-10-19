package com.example.chadwickzhao.innofire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SelectyourOwnEntertainment extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView lv1;
    String [] selection_entertainment = {
            "Take stress seriously",
            "Communicate well",
            "Give feedback",
            "Remember the team",
            "Ask for opinions",
            "Risk control measures",
            "Risk control measures-1",
            "Risk control measures-2",
            "Risk control measures-3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectyour_own_entertainment);
        lv1 = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, selection_entertainment);

        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(SelectyourOwnEntertainment.this, ShowEntertainment.class);
                intent.putExtra("selected", adapterView.getItemAtPosition(i).toString());
                startActivity(intent);

            }
        });
    }
}
