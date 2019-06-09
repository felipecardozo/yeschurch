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
    private Boolean hasKids;
    private Boolean hasParking;
    private Boolean hasParkingOutside;
    private Boolean hasAccessibility;
    private List<String> idioms;
    private Boolean hasSignLanguage;
    private Boolean hasBathrooms;

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

    public Boolean getHasKids() {
        return hasKids;
    }

    public void setHasKids(Boolean hasKids) {
        this.hasKids = hasKids;
    }

    public Boolean getHasParking() {
        return hasParking;
    }

    public void setHasParking(Boolean hasParking) {
        this.hasParking = hasParking;
    }

    public Boolean getHasParkingOutside() {
        return hasParkingOutside;
    }

    public void setHasParkingOutside(Boolean hasParkingOutside) {
        this.hasParkingOutside = hasParkingOutside;
    }

    public Boolean getHasAccessibility() {
        return hasAccessibility;
    }

    public void setHasAccessibility(Boolean hasAccessibility) {
        this.hasAccessibility = hasAccessibility;
    }

    public List<String> getIdioms() {
        return idioms;
    }

    public void setIdioms(List<String> idioms) {
        this.idioms = idioms;
    }

    public Boolean getHasSignLanguage() {
        return hasSignLanguage;
    }

    public void setHasSignLanguage(Boolean hasSignLanguage) {
        this.hasSignLanguage = hasSignLanguage;
    }

    public Boolean getHasBathrooms() {
        return hasBathrooms;
    }

    public void setHasBathrooms(Boolean hasBathrooms) {
        this.hasBathrooms = hasBathrooms;
    }
}
