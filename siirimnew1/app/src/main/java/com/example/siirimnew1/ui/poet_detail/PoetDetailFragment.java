package com.example.siirimnew1.ui.poet_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.siirimnew1.R;
import com.example.siirimnew1.data.model.Poem;
import com.example.siirimnew1.data.model.Poet;
import com.example.siirimnew1.data.repository.PoetRepository;
import com.example.siirimnew1.ui.poems.PoemsAdapter;
import java.util.ArrayList;

public class PoetDetailFragment extends Fragment implements PoemsAdapter.OnPoemClickListener {
    private PoetDetailViewModel viewModel;
    private ImageView poetImage;
    private TextView poetName;
    private TextView poetDates;
    private TextView poetBio;
    private RecyclerView poemsRecyclerView;
    private PoemsAdapter poemsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PoetRepository poetRepository = new PoetRepository();
        viewModel = new ViewModelProvider(this, new PoetDetailViewModelFactory(poetRepository))
                .get(PoetDetailViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_poet_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setupRecyclerView();
        observeViewModel();
        loadPoetDetail();
    }

    private void initViews(View view) {
        poetImage = view.findViewById(R.id.poet_image);
        poetName = view.findViewById(R.id.poet_name);
        poetDates = view.findViewById(R.id.poet_dates);
        poetBio = view.findViewById(R.id.poet_bio);
        poemsRecyclerView = view.findViewById(R.id.poems_recycler_view);
    }

    private void setupRecyclerView() {
        poemsAdapter = new PoemsAdapter(new ArrayList<>(), this);
        poemsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        poemsRecyclerView.setAdapter(poemsAdapter);
    }

    private void observeViewModel() {
        viewModel.getPoet().observe(getViewLifecycleOwner(), this::updatePoetInfo);
        viewModel.getPoems().observe(getViewLifecycleOwner(), poemsAdapter::updatePoems);
        viewModel.getError().observe(getViewLifecycleOwner(), error -> {
            if (error != null) {
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadPoetDetail() {
        if (getArguments() != null) {
            String poetId = getArguments().getString("poetId");
            if (poetId != null) {
                viewModel.loadPoetDetail(poetId);
            }
        }
    }

    private void updatePoetInfo(Poet poet) {
        if (poet != null) {
            Glide.with(this)
                .load(poet.getImageUrl())
                .placeholder(R.drawable.placeholder_poet)
                .error(R.drawable.placeholder_poet)
                .into(poetImage);

            poetName.setText(poet.getName());
            poetDates.setText(poet.getDates());
            poetBio.setText(poet.getBio());
        }
    }

    @Override
    public void onPoemClick(Poem poem) {
        Bundle args = new Bundle();
        args.putString("poemId", poem.getId());
        Navigation.findNavController(requireView())
                .navigate(R.id.action_poetDetailFragment_to_poemDetailFragment, args);
    }
} 