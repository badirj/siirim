package com.example.siirimnew1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.siirimnew1.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // RecyclerView ve diğer UI bileşenlerini burada ayarlayacağız
        setupRecyclerView();
        setupObservers();

        return root;
    }

    private void setupRecyclerView() {
        // RecyclerView ayarları burada yapılacak
    }

    private void setupObservers() {
        // ViewModel'dan gelen verileri gözlemleyeceğiz
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
} 