package com.example.chadwickzhao.innofire;

/**
 * Created by chadwickzhao on 5/09/16.
 */
public class Workinghours {
    private Integer workinghourid;
    private String wduration;
    private String wdate;
    private user[] username;


    public Workinghours() {
    }

    public Workinghours(Integer workinghourid) {
        this.workinghourid = workinghourid;
    }

    public Integer getWorkinghourid() {
        return workinghourid;
    }

    public void setWorkinghourid(Integer workinghourid) {
        this.workinghourid = workinghourid;
    }

    public String getWduration() {
        return wduration;
    }

    public void setWduration(String wduration) {
        this.wduration = wduration;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public user[] getUsername() {
        return username;
    }

    public void setUsername(user[] username) {
        this.username = username;
    }

}
