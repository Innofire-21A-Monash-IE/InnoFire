package com.example.chadwickzhao.innofire;

import java.io.Serializable;

/**
 * Created by chadwickzhao on 24/08/16.
 */
public class user implements Serializable{
    private int age;
    private String company;
    private String gender;
    private String occupation;
    private String password;
    private String position;
    private String username;


    public user() {
    }

    public user(String username, String password, String gender, int age, String occupation, String position, String company ){
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.position = position;
        this.company = company;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

