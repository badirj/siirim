package com.example.siirimnew1.ui.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.siirimnew1.data.model.Poet;
import com.example.siirimnew1.data.repository.PoetRepository;
import java.util.List;

public class SearchViewModel extends ViewModel {
    private final PoetRepository poetRepository;
    private final MutableLiveData<List<Poet>> poets = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    public SearchViewModel(PoetRepository poetRepository) {
        this.poetRepository = poetRepository;
    }

    public void loadPoets() {
        poetRepository.getPoets(new PoetRepository.RepositoryCallback<List<Poet>>() {
            @Override
            public void onSuccess(List<Poet> data) {
                poets.setValue(data);
            }

            @Override
            public void onError(String errorMessage) {
                error.setValue(errorMessage);
            }
        });
    }

    public void searchPoets(String query) {
        poetRepository.searchPoets(query, new PoetRepository.RepositoryCallback<List<Poet>>() {
            @Override
            public void onSuccess(List<Poet> data) {
                poets.setValue(data);
            }

            @Override
            public void onError(String errorMessage) {
                error.setValue(errorMessage);
            }
        });
    }

    public LiveData<List<Poet>> getPoets() {
        return poets;
    }

    public LiveData<String> getError() {
        return error;
    }
} 