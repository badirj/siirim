package com.example.siirimnew1.ui.poems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.siirimnew1.R;
import com.example.siirimnew1.data.model.Poem;
import java.util.ArrayList;
import java.util.List;

public class PoemAdapter extends RecyclerView.Adapter<PoemAdapter.PoemViewHolder> {
    private List<Poem> poems;
    private final OnPoemClickListener listener;

    public interface OnPoemClickListener {
        void onPoemClick(Poem poem);
    }

    public PoemAdapter(List<Poem> poems, OnPoemClickListener listener) {
        this.poems = poems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PoemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_poem, parent, false);
        return new PoemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PoemViewHolder holder, int position) {
        Poem poem = poems.get(position);
        holder.bind(poem);
    }

    @Override
    public int getItemCount() {
        return poems.size();
    }

    public void updatePoems(List<Poem> newPoems) {
        this.poems = newPoems;
        notifyDataSetChanged();
    }

    class PoemViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;

        PoemViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.poem_title);
        }

        void bind(Poem poem) {
            titleTextView.setText(poem.getTitle());
            itemView.setOnClickListener(v -> listener.onPoemClick(poem));
        }
    }
} 