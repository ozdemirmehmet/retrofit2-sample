package com.happydigital.retrofit2;

import com.google.gson.JsonElement;
import com.happydigital.retrofit2.Models.dataModels.PostModel;
import com.happydigital.retrofit2.Models.restRequestModels.PostModelRequest;
import com.happydigital.retrofit2.Models.restResponseModel.PostModelResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Mehmet ÖZDEMİR on 4.7.2017.
 * Copyright (c) 2017 Happy Digital. All rights reserved.
 */

public interface RetrofitInterface {

    @POST("wall/entries")
    Call<JsonElement> getPost(@Body PostModelRequest postModelRequest);

    @POST("wall/entries")
    Call<PostModelResponse> getPostViaModel(@Body PostModelRequest postModelRequest);
}
