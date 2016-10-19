package com.example.chadwickzhao.innofire;

/**
 * Created by chadwickzhao on 28/09/16.
 */
public class Park1 {
    private Integer parkid;
    private String parkname;
    private Double latitude;
    private Double longtitude;

    public Park1() {
    }

    public Park1(Integer parkid) {
        this.parkid = parkid;
    }

    public Integer getParkid() {
        return parkid;
    }

    public void setParkid(Integer parkid) {
        this.parkid = parkid;
    }

    public String getParkname() {
        return parkname;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }


}
