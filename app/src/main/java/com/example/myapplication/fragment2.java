package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class fragment2 extends Fragment {
    private ArrayList<MLS> myList= new ArrayList<>();
    private ArrayList<MLS> filteredList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EditText search;
    private Button name, distance, date;
    private MLSAdapter adapter;
    private int name_ad = 0;
    private int distance_ad = 0;
    private int date_ad = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        search = view.findViewById(R.id.search_editText);

        MLS mls1 = new MLS("A", 3.3, "2018-08-30");
        MLS mls2 = new MLS("B", 12.8, "2021-04-13");
        MLS mls3 = new MLS("C", 1.4, "2016-07-04");
        MLS mls4 = new MLS("D", 3.4, "2009-05-25");
        MLS mls5 = new MLS("E", 23.5, "2016-07-05");

        myList.add(mls3);
        myList.add(mls1);
        myList.add(mls5);
        myList.add(mls2);
        myList.add(mls4);


        recyclerView = view.findViewById(R.id.recyclerView);
        name = view.findViewById(R.id.name);
        distance = view.findViewById(R.id.distance);
        date = view.findViewById(R.id.date);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MLSAdapter(myList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name_ad == 0) {
                    Collections.sort(myList, new Comparator<MLS>() {
                        @Override
                        public int compare(MLS o1, MLS o2) {
                            adapter = new MLSAdapter(myList);
                            recyclerView.setAdapter(adapter);
                            name_ad = 1;
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                } else if (name_ad == 1) {
                    Collections.sort(myList, new Comparator<MLS>() {
                        @Override
                        public int compare(MLS o1, MLS o2) {
                            adapter = new MLSAdapter(myList);
                            recyclerView.setAdapter(adapter);
                            name_ad = 0;
                            return o2.getName().compareTo(o1.getName());
                        }
                    });
                }
            }
        });
        distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (distance_ad == 0) {
                    Collections.sort(myList, new Comparator<MLS>() {
                        @Override
                        public int compare(MLS o1, MLS o2) {
                            adapter = new MLSAdapter(myList);
                            recyclerView.setAdapter(adapter);
                            distance_ad = 1;
                            return o1.getDistance() < o2.getDistance() ? -1 : o1.getDistance() > o2.getDistance() ? 1 : 0;
                        }
                    });
                } else if (distance_ad == 1) {
                    Collections.sort(myList, new Comparator<MLS>() {
                        @Override
                        public int compare(MLS o1, MLS o2) {
                            adapter = new MLSAdapter(myList);
                            recyclerView.setAdapter(adapter);
                            distance_ad = 0;
                            return o1.getDistance() > o2.getDistance() ? -1 : o1.getDistance() < o2.getDistance() ? 1 : 0;
                        }
                    });
                }

            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (date_ad == 0) {
                    Collections.sort(myList, new Comparator<MLS>() {
                        @Override
                        public int compare(MLS o1, MLS o2) {
                            adapter = new MLSAdapter(myList);
                            recyclerView.setAdapter(adapter);
                            date_ad = 1;
                            return o1.getDate().compareTo(o2.getDate());
                        }
                    });
                } else if (date_ad == 1) {
                    Collections.sort(myList, new Comparator<MLS>() {
                        @Override
                        public int compare(MLS o1, MLS o2) {
                            adapter = new MLSAdapter(myList);
                            recyclerView.setAdapter(adapter);
                            date_ad = 0;
                            return o2.getDate().compareTo(o1.getDate());
                        }
                    });
                }

            }
        });
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = search.getText().toString();
                searchFilter(searchText);
            }
        });

        return view;
    }
    public void searchFilter (String searchText) {
        filteredList.clear();

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(myList.get(i));
            }
        }
        adapter.filterList(filteredList);
    }
}