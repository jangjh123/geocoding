package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;

public class fragment18 extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<String> myList = new ArrayList<>();
    private TextView example_one, example_two, example_three;
    private TextView ascend, descend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment18, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        ascend = view.findViewById(R.id.ascend);
        descend = view.findViewById(R.id.descend);
        example_one = view.findViewById(R.id.example_one);
        example_two = view.findViewById(R.id.example_two);
        example_three = view.findViewById(R.id.example_three);

        example_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(10);
            }
        });
        example_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(11);
            }
        });
        example_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(12);
            }
        });
        ascend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myList);
                BankRecyclerViewAdapter adapter2 = new BankRecyclerViewAdapter(myList);
                recyclerView.setAdapter(adapter2);
            }
        });
        descend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.reverse(myList);
                BankRecyclerViewAdapter adapter3 = new BankRecyclerViewAdapter(myList);
                recyclerView.setAdapter(adapter3);
            }
        });

        myList = new ArrayList<>();
        myList.add(0, "1");
        myList.add(1, "2");
        myList.add(2, "3");
        myList.add(3, "4");
        myList.add(4, "5");
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        BankRecyclerViewAdapter adapter = new BankRecyclerViewAdapter(myList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();




        return view;
    }
}