package com.example.siirimnew1.api;

import com.example.siirimnew1.model.Poem;
import com.example.siirimnew1.model.Poet;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import java.util.List;

public interface ApiService {
    @GET("poems")
    Call<List<Poem>> getPoems();

    @GET("poems/{id}")
    Call<Poem> getPoem(@Path("id") int id);

    @POST("poems")
    Call<Poem> createPoem(@Body Poem poem);

    @POST("poems/{id}/like")
    Call<Void> likePoem(@Path("id") int id);

    @POST("poems/{id}/comment")
    Call<Void> commentOnPoem(@Path("id") int id, @Body String comment);

    @GET("poets")
    Call<List<Poet>> getPoets();

    @GET("poets/{id}")
    Call<Poet> getPoet(@Path("id") int id);

    @GET("poets/search")
    Call<List<Poet>> searchPoets(@Query("query") String query);
} 