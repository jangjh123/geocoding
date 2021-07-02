package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BankRecyclerViewAdapter extends RecyclerView.Adapter<BankRecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> myList = new ArrayList<>();

    public BankRecyclerViewAdapter(ArrayList<String> myList) {
        this.myList = myList;
    }

    @NonNull
    @NotNull
    @Override
    public BankRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BankRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView_bank.setText(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_bank;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView_bank = itemView.findViewById(R.id.textView_bank);
        }
    }
}
