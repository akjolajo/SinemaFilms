package com.example.sinemafilms.data.remote;

import com.example.sinemafilms.data.Films;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {
    @GET("/films")
    Call<List<Films>> getFilms();
    @GET("/films/{id}")
    Call<Films> grtfilmbyId(
      @Path("id")
      String id
    );
}
