package com.example.chadwickzhao.innofire;

import java.sql.Date;

/**
 * Created by chadwickzhao on 4/09/16.
 * entity class of Caffeine intake
 */
public class Caffeineintake {
    private Integer caffeineintakeid;
    private String date;
    private String caffeinetake;
    private String totalcaffeinetake;
    private user[] username;


    public Caffeineintake() {
    }

    public Caffeineintake(Integer caffeineintakeid) {
        this.caffeineintakeid = caffeineintakeid;
    }

    public Integer getCaffeineintakeid() {
        return caffeineintakeid;
    }

    public void setCaffeineintakeid(Integer caffeineintakeid) {
        this.caffeineintakeid = caffeineintakeid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCaffeinetake() {
        return caffeinetake;
    }

    public void setCaffeinetake(String caffeinetake) {
        this.caffeinetake = caffeinetake;
    }

    public String getTotalcaffeinetake() {
        return totalcaffeinetake;
    }

    public void setTotalcaffeinetake(String totalcaffeinetake) {
        this.totalcaffeinetake = totalcaffeinetake;
    }

    public user[] getUsername() {
         return username;
    }

    public void setUsername(user[] username) {
        this.username = username;
    }

}
