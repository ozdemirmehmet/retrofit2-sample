package com.happydigital.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.google.gson.JsonElement;
import com.happydigital.retrofit2.Models.dataModels.PostModel;
import com.happydigital.retrofit2.Models.restRequestModels.PostModelRequest;
import com.happydigital.retrofit2.Models.restResponseModel.PostModelResponse;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import io.fabric.sdk.android.Fabric;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tyrantgit.explosionfield.ExplosionField;

public class MainActivity extends AppCompatActivity {

    private static final long RIPPLE_DURATION = 250;



    private static final String TOKEN = "OTDKQBFYEW1D0C4ABF0795D2871F";
    private static final String BASE_URL = "http://fauna.happydigital.com.tr/api/v1.0/";
    public static final String URL = "wall/entries";


    Toolbar toolbar;
    FrameLayout root;
    View contentHamburger;

    private ExplosionField mExplosionField;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);


        mExplosionField = ExplosionField.attach2Window(this);
        addListener(findViewById(R.id.explosionLayout));

        findViewById(R.id.text_view_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View root = findViewById(R.id.explosionLayout);
                reset(root);
                addListener(root);
                mExplosionField.clear();
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        root = (FrameLayout) findViewById(R.id.root);
        contentHamburger = (View) findViewById(R.id.content_hamburger);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu,
                guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();

        PostModelRequest postModelRequest = new PostModelRequest(TOKEN, 0, 1, "");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
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
                //throw new RuntimeException("This is a crash");
            }

            @Override
            public void onFailure(Call<PostModelResponse> call, Throwable t) {
                Log.d("Fail", t.toString());
            }
        });
    }



    private void addListener(View root) {
        if (root instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++) {
                addListener(parent.getChildAt(i));
            }
        } else {
            root.setClickable(true);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mExplosionField.explode(v);
                    v.setOnClickListener(null);
                }
            });
        }
    }
    private void reset(View root) {
        if (root instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++) {
                reset(parent.getChildAt(i));
            }
        } else {
            root.setScaleX(1);
            root.setScaleY(1);
            root.setAlpha(1);
        }
    }
}
