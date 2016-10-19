package com.example.chadwickzhao.innofire;

/**
 * Created by chadwickzhao on 23/09/16.
 */
public class Group1 {


    private user[] username;
    private Integer groupcapacity;
    private String groupname;
    private Integer groupId;
    private Integer groupUserId;



    public Group1() {
    }

    public Group1(Integer groupUserId) {
        this.groupUserId = groupUserId;
    }

    public Integer getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(Integer groupUserId) {
        this.groupUserId = groupUserId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Integer getGroupcapacity() {
        return groupcapacity;
    }

    public void setGroupcapacity(Integer groupcapacity) {
        this.groupcapacity = groupcapacity;
    }

    public user[] getUsername() {
        return username;
    }

    public void setUsername(user[] username) {
        this.username = username;
    }
}
