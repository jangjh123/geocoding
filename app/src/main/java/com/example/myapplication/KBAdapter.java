package com.example.myapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class KBAdapter extends RecyclerView.Adapter<KBAdapter.ViewHolder>{
    private ArrayList<String> myList = new ArrayList<>();
    private Context context;

    public KBAdapter(ArrayList<String> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public KBAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull KBAdapter.ViewHolder holder, int position) {
        holder.textView.setText(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_card);
        }
    }
}
