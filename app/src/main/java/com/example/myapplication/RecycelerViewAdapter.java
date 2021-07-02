package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecycelerViewAdapter extends RecyclerView.Adapter<RecycelerViewAdapter.ViewHolder> {
    private ArrayList<Post> myList = new ArrayList<>();
    private Context context;

    public RecycelerViewAdapter(ArrayList<Post> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public RecycelerViewAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecycelerViewAdapter.ViewHolder holder, int position) {
        holder.textView_id.setText(myList.get(position).getId());
        holder.textView_userId.setText(myList.get(position).getUserId());
        holder.textView_title.setText(myList.get(position).getTitle());
        holder.textView_body.setText(myList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_id, textView_userId, textView_title, textView_body;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView_id = itemView.findViewById(R.id.textView_id);
            textView_userId = itemView.findViewById(R.id.textView_userId);
            textView_title = itemView.findViewById(R.id.textView_title);
            textView_body = itemView.findViewById(R.id.textView_body);



        }
    }
}
