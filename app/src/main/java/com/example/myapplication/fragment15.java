package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fragment15 extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<String> myList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment15, container, false);
        myList = new ArrayList<>();
        myList.add(0, "1");
        myList.add(1, "2");
        myList.add(2, "3");
        myList.add(3, "4");
        myList.add(4, "5");
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        CardViewAdapter adapter = new CardViewAdapter(myList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();




        return view;
    }
}