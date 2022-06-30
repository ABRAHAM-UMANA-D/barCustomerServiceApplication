package com.example.barcustomerservice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BarAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Source> sourceList;

    public BarAdapter(List<Source> sourceList) {
        this.sourceList = sourceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view, sourceList);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.getTitle().setText(sourceList.get(i).getTitle());
        viewHolder.getImage().setImageResource(sourceList.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return sourceList.size();
    }
}
