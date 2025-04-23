package com.example.siirimnew1.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.siirimnew1.model.Poem;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<List<Poem>> poems = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    public LiveData<List<Poem>> getPoems() {
        return poems;
    }

    public LiveData<String> getError() {
        return error;
    }

    public void loadPoems() {
        // API'den şiirleri yükleme işlemi burada yapılacak
    }

    public void addPoem(Poem poem) {
        // Yeni şiir ekleme işlemi burada yapılacak
    }
} 