package com.happydigital.retrofit2.Models.restRequestModels;

/**
 * Created by Mehmet ÖZDEMİR on 4.7.2017.
 * Copyright (c) 2017 Happy Digital. All rights reserved.
 */

public class PostModelRequest {

    private String token;
    private int page;
    private int type;
    private String search_text;

    public PostModelRequest(String token,
                            int page,
                            int type,
                            String search_text) {
        this.token = token;
        this.page = page;
        this.type = type;
        this.search_text = search_text;
    }
}
