package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MLSAdapter extends RecyclerView.Adapter<MLSAdapter.ViewHolder> {

    private ArrayList<MLS> myList = new ArrayList<>();

    public MLSAdapter(ArrayList<MLS> myList) {
        this.myList = myList;
    }

    @NonNull
    @NotNull
    @Override
    public MLSAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mls_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MLSAdapter.ViewHolder holder, int position) {
        holder.textView_name.setText(myList.get(position).getName());
        holder.textView_distance.setText(myList.get(position).getDistance() + "km");
        holder.textView_sign.setText(myList.get(position).getDate());
    }

    public void filterList(ArrayList<MLS> filteredList) {
        myList = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_name, textView_distance, textView_sign;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            textView_name = itemView.findViewById(R.id.textView_shop_name);
            textView_distance = itemView.findViewById(R.id.textView_distance);
            textView_sign = itemView.findViewById(R.id.textView_sign_time);

        }
    }
}
