package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportFragment extends Fragment {

    String api = "d25e964aa06f42fd8346d33465ef16f7";

    ArrayList<ModelClass> modelClassArrayList;

    Adapter adapter;
    
    String country = "in";
    
    private RecyclerView recyclerviewofsport;
    
    private  String category="sports";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sportfragment,null);



        recyclerviewofsport=v.findViewById(R.id.rvsport);

        modelClassArrayList =new ArrayList<>();

        recyclerviewofsport.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter(getContext(),modelClassArrayList);

        recyclerviewofsport.setAdapter(adapter);

        findNews();

        return v;

    }

    private  void  findNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {

                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {



            }
        });

    }



}
