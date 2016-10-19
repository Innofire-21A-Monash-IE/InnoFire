package com.example.chadwickzhao.innofire;

/**
 * Created by chadwickzhao on 3/10/16.
 */
public class Stresslevelreport {
    private Integer stresslevelid;
    private Integer stressLevel;
    private Integer groupId;
    private String username;

    public Stresslevelreport() {
    }

    public Stresslevelreport(Integer stresslevelid) {
        this.stresslevelid = stresslevelid;
    }

    public Stresslevelreport(Integer stresslevelid, String username) {
        this.stresslevelid = stresslevelid;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(Integer stressLevel) {
        this.stressLevel = stressLevel;
    }

    public Integer getStresslevelid() {
        return stresslevelid;
    }

    public void setStresslevelid(Integer stresslevelid) {
        this.stresslevelid = stresslevelid;
    }
}
