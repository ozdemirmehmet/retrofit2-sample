package com.happydigital.retrofit2.Models.restResponseModel;

import com.google.gson.annotations.SerializedName;
import com.happydigital.retrofit2.Models.dataModels.PostModel;

import java.util.List;

/**
 * Created by Mehmet ÖZDEMİR on 4.7.2017.
 * Copyright (c) 2017 Happy Digital. All rights reserved.
 */

public class PostModelResponse {

    @SerializedName("errno")
    private int errorNo;
    @SerializedName("err")
    private String error;
    @SerializedName("data")
    private List<PostModel> postList;

    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<PostModel> getPostList() {
        return postList;
    }

    public void setPostList(List<PostModel> postList) {
        this.postList = postList;
    }
}
