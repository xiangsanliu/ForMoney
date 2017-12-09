package org.chengjian.java.feidian.collectdata.mvp.model;

/**
 * Created by xiang on 2017/12/9.
 *
 */

public class LocationMessage {

    private double longitude;
    private double latitude;
    private String address;
    private boolean editable;

    public LocationMessage() {
    }

    public LocationMessage(double longitude, double latitude, String address) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.editable = false;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

}
