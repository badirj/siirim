package com.example.siirimnew1.ui.poet_detail;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.siirimnew1.data.repository.PoetRepository;
import androidx.annotation.NonNull;

public class PoetDetailViewModelFactory implements ViewModelProvider.Factory {
    private final PoetRepository poetRepository;

    public PoetDetailViewModelFactory(PoetRepository poetRepository) {
        this.poetRepository = poetRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PoetDetailViewModel.class)) {
            return (T) new PoetDetailViewModel(poetRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
} 