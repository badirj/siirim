package com.example.siirimnew1.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siirimnew1.R;
import com.example.siirimnew1.data.model.Poet;
import com.example.siirimnew1.data.repository.PoetRepository;
import com.example.siirimnew1.ui.poets.PoetAdapter;
import java.util.ArrayList;

public class SearchFragment extends Fragment implements PoetAdapter.OnPoetClickListener {
    private SearchViewModel viewModel;
    private RecyclerView poetsRecyclerView;
    private SearchView searchView;
    private PoetAdapter poetAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PoetRepository poetRepository = new PoetRepository();
        viewModel = new ViewModelProvider(this, new SearchViewModelFactory(poetRepository))
                .get(SearchViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setupRecyclerView();
        setupSearchView();
        observeViewModel();
        loadPoets();
    }

    private void initViews(View view) {
        poetsRecyclerView = view.findViewById(R.id.poets_recycler_view);
        searchView = view.findViewById(R.id.search_view);
    }

    private void setupRecyclerView() {
        poetAdapter = new PoetAdapter(new ArrayList<>(), this);
        poetsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        poetsRecyclerView.setAdapter(poetAdapter);
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.searchPoets(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() >= 3) {
                    viewModel.searchPoets(newText);
                }
                return true;
            }
        });
    }

    private void observeViewModel() {
        viewModel.getPoets().observe(getViewLifecycleOwner(), poetAdapter::updatePoems);
        viewModel.getError().observe(getViewLifecycleOwner(), error -> {
            if (error != null) {
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadPoets() {
        viewModel.loadPoets();
    }

    @Override
    public void onPoetClick(Poet poet) {
        Bundle args = new Bundle();
        args.putString("poetId", poet.getId());
        Navigation.findNavController(requireView())
                .navigate(R.id.action_searchFragment_to_poetDetailFragment, args);
    }
} 