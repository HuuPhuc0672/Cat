package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Mode.Cat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CatHodler>{
    private MainActivity context;
    ArrayList<Cat> list=new ArrayList<>();

    public  Adapter(ArrayList<Cat>list,MainActivity context){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public CatHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new CatHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHodler holder, int position) {
        Cat cat=list.get(position);


        Glide.with(context).load(cat.getUrl()).centerCrop().into(holder.imgCat);
        holder.txtNamcat.setText(""+cat.getId());
        String id= cat.getId();

        holder.carViewCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DetailCatActivity.class);
                intent.putExtra("id",id);
                context.startActivity(intent);

            }
        });

    }
    private void onClickCat(Cat cat) {
    }

    @Override
    public int getItemCount() {
        if (list!=null){return list.size();
        }return 0;
    }

    public class CatHodler extends RecyclerView.ViewHolder{
        private CardView carViewCat;
        private ImageView imgCat;
        private TextView txtNamcat;



        public CatHodler(@NonNull View itemView) {
            super(itemView);
            carViewCat = itemView.findViewById(R.id.carView_cat);
            imgCat = itemView.findViewById(R.id.img_cat);
            txtNamcat = itemView.findViewById(R.id.txt_name_cat);


        }
    }
}
