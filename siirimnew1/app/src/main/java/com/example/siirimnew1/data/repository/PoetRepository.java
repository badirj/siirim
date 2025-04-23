package com.example.siirimnew1.data.repository;

import com.example.siirimnew1.data.api.ApiClient;
import com.example.siirimnew1.data.model.Poem;
import com.example.siirimnew1.data.model.Poet;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PoetRepository {
    private final ApiClient apiClient;

    public PoetRepository() {
        this.apiClient = ApiClient.getInstance();
    }

    public void getPoets(final RepositoryCallback<List<Poet>> callback) {
        apiClient.getApiService().getPoets().enqueue(new Callback<List<Poet>>() {
            @Override
            public void onResponse(Call<List<Poet>> call, Response<List<Poet>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Şairler yüklenirken hata oluştu");
                }
            }

            @Override
            public void onFailure(Call<List<Poet>> call, Throwable t) {
                callback.onError("Şairler yüklenirken hata oluştu: " + t.getMessage());
            }
        });
    }

    public void searchPoets(String query, final RepositoryCallback<List<Poet>> callback) {
        apiClient.getApiService().searchPoets(query).enqueue(new Callback<List<Poet>>() {
            @Override
            public void onResponse(Call<List<Poet>> call, Response<List<Poet>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Şairler aranırken hata oluştu");
                }
            }

            @Override
            public void onFailure(Call<List<Poet>> call, Throwable t) {
                callback.onError("Şairler aranırken hata oluştu: " + t.getMessage());
            }
        });
    }

    public void getPoetById(String poetId, final RepositoryCallback<Poet> callback) {
        apiClient.getApiService().getPoetById(poetId).enqueue(new Callback<Poet>() {
            @Override
            public void onResponse(Call<Poet> call, Response<Poet> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Şair bilgileri yüklenirken hata oluştu");
                }
            }

            @Override
            public void onFailure(Call<Poet> call, Throwable t) {
                callback.onError("Şair bilgileri yüklenirken hata oluştu: " + t.getMessage());
            }
        });
    }

    public void getPoemsByPoetId(String poetId, final RepositoryCallback<List<Poem>> callback) {
        apiClient.getApiService().getPoemsByPoetId(poetId).enqueue(new Callback<List<Poem>>() {
            @Override
            public void onResponse(Call<List<Poem>> call, Response<List<Poem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Şiirler yüklenirken hata oluştu");
                }
            }

            @Override
            public void onFailure(Call<List<Poem>> call, Throwable t) {
                callback.onError("Şiirler yüklenirken hata oluştu: " + t.getMessage());
            }
        });
    }

    public interface RepositoryCallback<T> {
        void onSuccess(T data);
        void onError(String error);
    }
} 