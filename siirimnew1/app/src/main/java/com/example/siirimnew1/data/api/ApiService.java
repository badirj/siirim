package com.example.siirimnew1.data.api;

import com.example.siirimnew1.data.model.Poem;
import com.example.siirimnew1.data.model.Poet;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("poets")
    Call<List<Poet>> getPoets();

    @GET("poets/{id}")
    Call<Poet> getPoetById(@Path("id") String id);

    @GET("poets/{id}/poems")
    Call<List<Poem>> getPoemsByPoetId(@Path("id") String id);

    @GET("poems/{id}")
    Call<Poem> getPoemById(@Path("id") String id);
} 