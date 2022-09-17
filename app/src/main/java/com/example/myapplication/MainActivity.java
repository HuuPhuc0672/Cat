package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Api.Api;
import com.example.myapplication.Mode.Cat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvView;
    ArrayList<Cat>list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvView = findViewById(R.id.rcvView);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thecatapi.com/v1/images/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);

        Call<ArrayList<Cat>> call = api.GetList();
        call.enqueue(new Callback<ArrayList<Cat>>() {
            @Override
            public void onResponse(Call<ArrayList<Cat>> call, Response<ArrayList<Cat>> response) {
                list = response.body();
                rcvView.setHasFixedSize(true);
                rcvView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                Adapter adapter = new Adapter(list,MainActivity.this);
                rcvView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Cat>> call, Throwable t) {
                System.out.println(t);
            }
        });

    }


}