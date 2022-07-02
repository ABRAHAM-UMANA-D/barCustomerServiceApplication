package com.example.barcustomerservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.BarViewHolder> {
    private final LayoutInflater mInflater;
    private ArrayList<Mesa> listMesas = new ArrayList<>();

    public BarAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new BarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BarViewHolder holder, int position) {
        Mesa mesa = listMesas.get(position);
        holder.txt_numero.setText(" Mesa "+mesa.getNumero_mesa());
    }

    @Override
    public int getItemCount() {
        return listMesas.size();
    }

    public void setItems(ArrayList<Mesa> mesa) {
        listMesas.addAll(mesa);
    }

    public class BarViewHolder extends RecyclerView.ViewHolder {
        TextView txt_numero;

        public BarViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_numero=itemView.findViewById(R.id.text_numero);
        }
    }
}
