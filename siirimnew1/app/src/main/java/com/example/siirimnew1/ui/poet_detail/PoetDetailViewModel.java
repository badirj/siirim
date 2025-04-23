package com.example.siirimnew1.ui.poet_detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.siirimnew1.data.model.Poem;
import com.example.siirimnew1.data.model.Poet;
import com.example.siirimnew1.data.repository.PoetRepository;
import java.util.List;

public class PoetDetailViewModel extends ViewModel {
    private final PoetRepository poetRepository;
    private final MutableLiveData<Poet> poet = new MutableLiveData<>();
    private final MutableLiveData<List<Poem>> poems = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    public PoetDetailViewModel(PoetRepository poetRepository) {
        this.poetRepository = poetRepository;
    }

    public void loadPoetDetail(String poetId) {
        poetRepository.getPoetById(poetId, new PoetRepository.RepositoryCallback<Poet>() {
            @Override
            public void onSuccess(Poet data) {
                poet.setValue(data);
                loadPoems(poetId);
            }

            @Override
            public void onError(String errorMessage) {
                error.setValue(errorMessage);
            }
        });
    }

    private void loadPoems(String poetId) {
        poetRepository.getPoemsByPoetId(poetId, new PoetRepository.RepositoryCallback<List<Poem>>() {
            @Override
            public void onSuccess(List<Poem> data) {
                poems.setValue(data);
            }

            @Override
            public void onError(String errorMessage) {
                error.setValue(errorMessage);
            }
        });
    }

    public LiveData<Poet> getPoet() {
        return poet;
    }

    public LiveData<List<Poem>> getPoems() {
        return poems;
    }

    public LiveData<String> getError() {
        return error;
    }
} 