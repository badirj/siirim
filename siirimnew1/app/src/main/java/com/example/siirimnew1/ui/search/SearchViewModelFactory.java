package com.example.siirimnew1.ui.search;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.siirimnew1.data.repository.PoetRepository;
import androidx.annotation.NonNull;

public class SearchViewModelFactory implements ViewModelProvider.Factory {
    private final PoetRepository poetRepository;

    public SearchViewModelFactory(PoetRepository poetRepository) {
        this.poetRepository = poetRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            return (T) new SearchViewModel(poetRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
} 