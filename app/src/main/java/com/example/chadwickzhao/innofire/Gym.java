package com.example.chadwickzhao.innofire;

/**
 * Created by chadwickzhao on 28/09/16.
 */
public class Gym {
    private Integer gymid;
    private String gymname;
    private Double latitude;
    private Double longitutde;

    public Gym() {
    }

    public Gym(Integer gymid) {
        this.gymid = gymid;
    }

    public Integer getGymid() {
        return gymid;
    }

    public void setGymid(Integer gymid) {
        this.gymid = gymid;
    }

    public String getGymname() {
        return gymname;
    }

    public void setGymname(String gymname) {
        this.gymname = gymname;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitutde() {
        return longitutde;
    }

    public void setLongitutde(Double longitutde) {
        this.longitutde = longitutde;
    }


}
