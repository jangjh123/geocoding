package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder>{
    private ArrayList<String> myList = new ArrayList<>();

    public CardViewAdapter(ArrayList<String> myList) {
        this.myList = myList;
    }

    @NonNull
    @NotNull
    @Override
    public CardViewAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.logistics_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CardViewAdapter.ViewHolder holder, int position) {
        holder.textView_log.setText(myList.get(position));

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_log;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView_log = itemView.findViewById(R.id.textView_log);
        }
    }
}
