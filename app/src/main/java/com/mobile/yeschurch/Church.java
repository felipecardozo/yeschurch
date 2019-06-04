package com.mobile.yeschurch;

import com.google.android.gms.maps.model.LatLng;

public class Church {

    private String name;
    private LatLng latLng;
    private String city;
    private ChurchType type;

    public Church(){}

    public Church(String name, LatLng latLng, String city, ChurchType type) {
        this.name = name;
        this.latLng = latLng;
        this.city = city;
        this.type = type;
    }

    public ChurchType getType() {
        return type;
    }

    public void setType(ChurchType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
