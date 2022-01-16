package com.example.sinemafilms;

import android.app.Application;

import com.example.sinemafilms.data.remote.FilmApi;
import com.example.sinemafilms.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.prowaaitFilmApi();
    }
}
