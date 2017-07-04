package com.happydigital.retrofit2.Models.dataModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mehmet ÖZDEMİR on 4.7.2017.
 * Copyright (c) 2017 Happy Digital. All rights reserved.
 */

public class Venue {

    @SerializedName("id")
    private int venueId;
    @SerializedName("cat")
    private int catId;
    @SerializedName("name")
    private String venueName;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lng")
    private double lng;
    @SerializedName("chkc")
    private int chkc;

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getChkc() {
        return chkc;
    }

    public void setChkc(int chkc) {
        this.chkc = chkc;
    }
}
