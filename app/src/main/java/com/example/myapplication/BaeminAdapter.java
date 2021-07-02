package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BaeminAdapter extends RecyclerView.Adapter<BaeminAdapter.ViewHolder> {
    private ArrayList<String> myList = new ArrayList<>();

    public BaeminAdapter(ArrayList<String> myList) {
        this.myList = myList;
    }

    @NonNull
    @NotNull
    @Override
    public BaeminAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.baemin_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BaeminAdapter.ViewHolder holder, int position) {
        holder.textView_baemin.setText(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_baemin;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView_baemin = itemView.findViewById(R.id.textView_baemin);
        }
    }
}
