package com.mr_mir.testjsonparsingusingretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://raw.githubusercontent.com/appinion-dev/intern-dcr-data/master/";

    @GET("data.json")
    Call<List<Data>> getProductGroupList();

    @GET("data.json")
    Call<List<Data>> getLiteratureList();

    @GET("data.json")
    Call<List<Data>> getGiftList();

    @GET("data.json")
    Call<List<Data>> getPhysicianSampleList();
}
