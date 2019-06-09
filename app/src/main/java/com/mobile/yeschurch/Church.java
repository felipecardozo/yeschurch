package com.mobile.yeschurch;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class Church {

    private String name;
    private LatLng latLng;
    private String city;
    private ChurchType type;
    private String webPage;
    private List<String> phones;
    private Integer assistance;
    private List<String> schedule;
    private boolean kids;
    private boolean parking;
    private boolean parkingOutside;
    private boolean accessibility;
    private List<String> idioms;
    private boolean signLanguage;
    private boolean bathrooms;

    public Church(){}

    public Church(String name, LatLng latLng, String city, ChurchType type) {
        this.name = name;
        this.latLng = latLng;
        this.city = city;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ChurchType getType() {
        return type;
    }

    public void setType(ChurchType type) {
        this.type = type;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Integer getAssistance() {
        return assistance;
    }

    public void setAssistance(Integer assistance) {
        this.assistance = assistance;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }

    public boolean isKids() {
        return kids;
    }

    public void setKids(boolean kids) {
        this.kids = kids;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isParkingOutside() {
        return parkingOutside;
    }

    public void setParkingOutside(boolean parkingOutside) {
        this.parkingOutside = parkingOutside;
    }

    public boolean isAccessibility() {
        return accessibility;
    }

    public void setAccessibility(boolean accessibility) {
        this.accessibility = accessibility;
    }

    public List<String> getIdioms() {
        return idioms;
    }

    public void setIdioms(List<String> idioms) {
        this.idioms = idioms;
    }

    public boolean isSignLanguage() {
        return signLanguage;
    }

    public void setSignLanguage(boolean signLanguage) {
        this.signLanguage = signLanguage;
    }

    public boolean isBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(boolean bathrooms) {
        this.bathrooms = bathrooms;
    }
}
