package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Api.Api;
import com.example.myapplication.Mode.Cat;
import com.example.myapplication.Mode.DetaiCat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailCatActivity extends AppCompatActivity {
    private ImageView imgCatt;
    private TextView txtName1;
    private TextView txtNguon;



    Cat cat =new Cat();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cat);
        imgCatt = findViewById(R.id.img_catt);
        txtName1 = findViewById(R.id.txt_name1);
        txtNguon = (TextView) findViewById(R.id.txt_nguon);
        Intent i=getIntent();
        String idCat = i.getStringExtra("id");


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thecatapi.com/v1/images/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);

        Call<Cat> call = api.getId(idCat);
        call.enqueue(new Callback<Cat>() {
            @Override
            public void onResponse(Call<Cat> call, Response<Cat> response) {
                Log.d("TAG", "onResponse: " + response.body());
                Cat cat = response.body();
                if (response.isSuccessful()){
                    for(int i =0 ; i < cat.getBreeds().size() ; i ++){
                        Log.d("TAG", "onResponse:"+response.body().toString());
                        Glide.with(DetailCatActivity.this).load(cat.getUrl()).into(imgCatt);
                        txtName1.setText(cat.getBreeds().get(i).name);
                        txtNguon.setText(cat.getBreeds().get(i).origin);


                    }

                }

            }

            @Override
            public void onFailure(Call<Cat> call, Throwable t) {
                System.out.println(t);
            }
        });

    }


}