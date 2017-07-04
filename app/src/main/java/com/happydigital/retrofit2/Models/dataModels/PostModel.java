package com.happydigital.retrofit2.Models.dataModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mehmet ÖZDEMİR on 4.7.2017.
 * Copyright (c) 2017 Happy Digital. All rights reserved.
 */

public class PostModel {

    @SerializedName("body")
    private String body;
    @SerializedName("entry_date")
    private String entryDate;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("gender")
    private int gender;
    @SerializedName("like_count")
    private int likeCount;
    @SerializedName("cmmnts_count")
    private int commentCount;
    @SerializedName("liked")
    private int liked;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("type")
    private int type;
    @SerializedName("entry_id")
    private int entryId;
    @SerializedName("aspect_ratio")
    private double aspectRatio;
    @SerializedName("venue")
    private Venue venue;
    @SerializedName("attchmnt")
    private int attachment;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getAttachment() {
        return attachment;
    }

    public void setAttachment(int attachment) {
        this.attachment = attachment;
    }
}
