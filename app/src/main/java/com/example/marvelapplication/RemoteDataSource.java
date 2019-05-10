package com.example.marvelapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RemoteDataSource {

    public static final String BASE_URL = "https://simplifiedcoding.net/demos/marvel/";

    public Retrofit createClient(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getMarvelHeroes(final Callback callback) {

        createClient().create(RemoteService.class)
                .getMarvelHeroes()
                .enqueue(new retrofit2.Callback<List<Marvel>>() {
                    @Override
                    public void onResponse(Call<List<Marvel>> call, Response<List<Marvel>> response) {
                        callback.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Marvel>> call, Throwable t) {
                        callback.onFailure(t.getMessage());
                    }
                });

    }

    interface RemoteService{
        @GET("")
        Call<List<Marvel>> getMarvelHeroes();
    }


    interface Callback{
        void onSuccess(List<Marvel> heroes);
        void onFailure(String error);
    }
}
