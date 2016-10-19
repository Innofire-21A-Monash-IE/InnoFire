package com.example.chadwickzhao.innofire;

/**
 * Created by chadwickzhao on 28/09/16.
 */
public class Spa {
    private Integer spaid;
    private String spaname;
    private Double latitude;
    private Double longitude;

    public Spa() {
    }

    public Spa(Integer spaid) {
        this.spaid = spaid;
    }

    public Integer getSpaid() {
        return spaid;
    }

    public void setSpaid(Integer spaid) {
        this.spaid = spaid;
    }

    public String getSpaname() {
        return spaname;
    }

    public void setSpaname(String spaname) {
        this.spaname = spaname;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


}
