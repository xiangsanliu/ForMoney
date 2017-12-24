package org.chengjian.java.feidian.collectdata.beans.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by xiang on 2017/12/9.
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class LocationMessage {

    private double longitude;
    private double latitude;
    private String address;
    private boolean editable;

    public LocationMessage(double longitude, double latitude, String address) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
    }

    public LocationMessage(double longitude, double latitude, String address, boolean editable) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.editable = editable;
    }
}