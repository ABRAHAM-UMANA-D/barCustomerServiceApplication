package com.example.barcustomerservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.BarViewHolder> {
    private final LayoutInflater mInflater;

    public BarAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public BarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BarViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BarViewHolder extends RecyclerView.ViewHolder {

        public BarViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
