package com.example.chadwickzhao.innofire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowEntertainment extends AppCompatActivity {
    TextView tv1;
    String gettheName;
    TextView tv2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_entertainment);
        tv1 = (TextView) findViewById(R.id.showtheentertainmen);
        tv2 = (TextView) findViewById(R.id.content_oflist);
        tv3 = (TextView) findViewById(R.id.showRef);
        Intent i = getIntent();
        gettheName = i.getExtras().get("selected").toString();
        tv1.setText(gettheName);
        if(gettheName.equals("Take stress seriously")){

            String ref= "www.stressmanagementsociety.com Corporate Wellbeing Solutions";
            String show = "Tackling stress is part of Health and Safety responsibilities and employers are legally obliged to take action if you have such a problem at work.";
            tv2.setText(show);
            tv3.setText(ref);
        }else if(gettheName.equals("Communicate well")){

            String ref= "www.stressmanagementsociety.com Corporate Wellbeing Solutions";
            String show = "Keep employees informed about workplace changes. Be clear about job roles and targets, and be sensitive in the way you communicate.\n";
            tv2.setText(show);
            tv3.setText(ref);
        }else if(gettheName.equals("Give feedback")){

            String ref= "www.stressmanagementsociety.com Corporate Wellbeing Solutions";
            String show = "Feedback can improve employee’s confidence and keep them informed on areas to work on. This can provide a consistent approach to prevent an overload of criticisms which can impact on stress levels.\n";
            tv2.setText(show);
            tv3.setText(ref);
        }else if(gettheName.equals("Remember the team")){

            String ref= "www.stressmanagementsociety.com Corporate Wellbeing Solutions";
            String show = "Focus on creating good team spirit and get all staff involved and engaged. Organize company events out and wellbeing days. Being valued and involved like this is a major factor in happiness at work.\n";
            tv2.setText(show);
            tv3.setText(ref);
        }else if(gettheName.equals("Ask for opinions")){

            String ref= "www.stressmanagementsociety.com Corporate Wellbeing Solutions";
            String show = "People often feel stressed when they are powerless over their job content. So if change is required, consult those involved so they can have a say in work-related decisions.";
            tv2.setText(show);
            tv3.setText(ref);
        }else if(gettheName.equals("Risk control measures")){

            String ref= "Work Safe Victoria April 2016\n" +
                    "A guidebook for employers";
            String show = "Risk control measures to control work-related stress should target organizational and environmental factors specific to the workplace and the specific circumstances of individuals. Interventions (risk control measures) to control work-related stress may be ineffective if not targeted at the appropriate level(s).";
            tv2.setText(show);
            tv3.setText(ref);
        }else if(gettheName.equals("Risk control measures-1")){
            String ref= "Work Safe Victoria April 2016\n" +
                    "A guidebook for employers";
            String show = "Examples of risk control measures that can be put in place to manage the risk of employee work-related stress may include: \n" +
                    "• developing supervisor/managerial skills through coaching, mentoring and/or training to improve support provided to employees\n" +
                    " • planning workloads to address job demands and level of control\n" +
                    "WorkSafe Victoria Preventing and Managing Work-Related Stress  7";
            tv2.setText(show);
            tv3.setText(ref);
        }else if(gettheName.equals("Risk control measures-2")){
            String ref= "Work Safe Victoria April 2016\n" +
                    "A guidebook for employers";
            String show = " • setting clear performance goals/accountability to ensure role clarity \n" +
                    "• reassessing job descriptions to ensure role clarity \n" +
                    "• setting new or adjusting current HR procedures to ensure role clarity and improved support";
            tv2.setText(show);
            tv3.setText(ref);
        }else if(gettheName.equals("Risk control measures-3")){
            String ref= "Work Safe Victoria April 2016\n" +
                    "A guidebook for employers";
            String show = " • providing assistance (eg an employee assistance program) to increase level of job support • communicating with employees regarding availability of assistance to address job demands and levels of control \n" +
                    "• checking employee understanding and implementation of changes as part of change management \n" +
                    "• promoting effective early intervention to improve support provided to employees and quality of relationships.";
            tv2.setText(show);
            tv3.setText(ref);
        }

    }
}
