package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class fragment16 extends Fragment implements View.OnClickListener {

    private TextView button1, button2, button3, button4;
    private RecyclerView recyclerView;
    private ArrayList<String> myList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment16, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        myList = new ArrayList<>();
        myList.add(0, "1");
        myList.add(1, "2");
        myList.add(2, "3");
        myList.add(3, "4");
        myList.add(4, "5");
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        BaeminAdapter adapter = new BaeminAdapter(myList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                button1.setBackgroundResource(R.drawable.baemin_radius);
                button1.setTextColor(Color.parseColor("#ffffff"));
                button2.setBackground(null);
                button2.setTextColor(Color.parseColor("#28c1bc"));
                button3.setBackground(null);
                button3.setTextColor(Color.parseColor("#28c1bc"));
                button4.setBackground(null);
                button4.setTextColor(Color.parseColor("#28c1bc"));
                break;
            case R.id.button2:
                button1.setBackground(null);
                button1.setTextColor(Color.parseColor("#28c1bc"));
                button2.setBackgroundResource(R.drawable.baemin_radius);
                button2.setTextColor(Color.parseColor("#ffffff"));
                button3.setBackground(null);
                button3.setTextColor(Color.parseColor("#28c1bc"));
                button4.setBackground(null);
                button4.setTextColor(Color.parseColor("#28c1bc"));
                break;
            case R.id.button3:
                button1.setBackground(null);
                button1.setTextColor(Color.parseColor("#28c1bc"));
                button2.setBackground(null);
                button2.setTextColor(Color.parseColor("#28c1bc"));
                button3.setBackgroundResource(R.drawable.baemin_radius);
                button3.setTextColor(Color.parseColor("#ffffff"));
                button4.setBackground(null);
                button4.setTextColor(Color.parseColor("#28c1bc"));
                break;
            case R.id.button4:
                button1.setBackground(null);
                button1.setTextColor(Color.parseColor("#28c1bc"));
                button2.setBackground(null);
                button2.setTextColor(Color.parseColor("#28c1bc"));
                button3.setBackground(null);
                button3.setTextColor(Color.parseColor("#28c1bc"));
                button4.setBackgroundResource(R.drawable.baemin_radius);
                button4.setTextColor(Color.parseColor("#ffffff"));
                break;
        }
    }
}