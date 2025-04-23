package com.example.siirimnew1.ui.poets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.siirimnew1.R;
import com.example.siirimnew1.data.model.Poet;
import java.util.ArrayList;
import java.util.List;

public class PoetAdapter extends RecyclerView.Adapter<PoetAdapter.PoetViewHolder> {
    private List<Poet> poets;
    private final OnPoetClickListener listener;

    public interface OnPoetClickListener {
        void onPoetClick(Poet poet);
    }

    public PoetAdapter(List<Poet> poets, OnPoetClickListener listener) {
        this.poets = poets;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PoetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_poet, parent, false);
        return new PoetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PoetViewHolder holder, int position) {
        Poet poet = poets.get(position);
        holder.bind(poet);
    }

    @Override
    public int getItemCount() {
        return poets.size();
    }

    public void updatePoets(List<Poet> newPoets) {
        this.poets = newPoets;
        notifyDataSetChanged();
    }

    class PoetViewHolder extends RecyclerView.ViewHolder {
        private final ImageView poetImage;
        private final TextView poetName;
        private final TextView poetDates;

        PoetViewHolder(@NonNull View itemView) {
            super(itemView);
            poetImage = itemView.findViewById(R.id.poet_image);
            poetName = itemView.findViewById(R.id.poet_name);
            poetDates = itemView.findViewById(R.id.poet_dates);
        }

        void bind(Poet poet) {
            Glide.with(itemView.getContext())
                .load(poet.getImageUrl())
                .placeholder(R.drawable.placeholder_poet)
                .error(R.drawable.placeholder_poet)
                .into(poetImage);

            poetName.setText(poet.getName());
            poetDates.setText(poet.getDates());

            itemView.setOnClickListener(v -> listener.onPoetClick(poet));
        }
    }
} 