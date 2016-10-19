package com.example.chadwickzhao.innofire;

/**
 * Created by chadwickzhao on 10/10/16.
 */
public class StresslevelReportTest {
    public int stresslevel;
    public String name;
    public String date;

    public StresslevelReportTest(){

    }
    public StresslevelReportTest(int stresslevel, String name, String date){
        this.stresslevel = stresslevel;
        this.name = name;
        this.date = date;
    }

    public Integer getStressLevel() {
        return stresslevel;
    }

    public void setStressLevel(Integer stressLevel) {
        this.stresslevel = stressLevel;
    }

    public String getUsername() {
        return name;
    }

    public String getDate() {return  date;}

    public void setDate() {
        this.date = date;
    }

    public void setUsername(String username) {
        this.name = username;
    }

}
