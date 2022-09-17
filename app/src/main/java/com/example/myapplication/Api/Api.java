package com.example.myapplication.Api;

import com.example.myapplication.Mode.Cat;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("search?limit=10&breed_ids=beng&api_key=REPLACE_ME")
    Call<ArrayList<Cat>> GetList();

    @GET("{id}")
    Call<Cat> getId(@Path(value = "id") String id );



}
