package com.happydigital.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonElement;
import com.happydigital.retrofit2.Models.dataModels.PostModel;
import com.happydigital.retrofit2.Models.restRequestModels.PostModelRequest;
import com.happydigital.retrofit2.Models.restResponseModel.PostModelResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostModelRequest postModelRequest = new PostModelRequest("OTDKQBFYEW1D0C4ABF0795D2871F", 0, 1, "");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fauna.happydigital.com.tr/api/v1.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        /*Call<JsonElement> postCall = retrofitInterface.getPost(postModelRequest);
        Log.d("Req", postCall.request().toString());
        postCall.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.d("Res", call.toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });*/


        Call<PostModelResponse> postCall = retrofitInterface.getPostViaModel(postModelRequest);
        postCall.enqueue(new Callback<PostModelResponse>() {
            @Override
            public void onResponse(Call<PostModelResponse> call, Response<PostModelResponse> response) {
                Log.d("Res", call.toString());
            }

            @Override
            public void onFailure(Call<PostModelResponse> call, Throwable t) {
                Log.d("Fail", t.toString());
            }
        });
    }
}
