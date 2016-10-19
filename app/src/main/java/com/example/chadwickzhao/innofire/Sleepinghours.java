package com.example.chadwickzhao.innofire;

/**
 * Created by chadwickzhao on 5/09/16.
 */
public class Sleepinghours {
    private Integer sleepingHourId;
    private String sduration;
    private String sdate;
    private user[] username;

    public Sleepinghours() {
    }

    public Sleepinghours(Integer sleepingHourId) {
        this.sleepingHourId = sleepingHourId;
    }

    public Integer getSleepingHourId() {
        return sleepingHourId;
    }

    public void setSleepingHourId(Integer sleepingHourId) {
        this.sleepingHourId = sleepingHourId;
    }

    public String getSduration() {
        return sduration;
    }

    public void setSduration(String sduration) {
        this.sduration = sduration;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public user[] getUsername() {
        return username;
    }

    public void setUsername(user[] username) {
        this.username = username;
    }

}
