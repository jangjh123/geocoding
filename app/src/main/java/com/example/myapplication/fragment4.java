package com.example.myapplication;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;


public class fragment4 extends Fragment {

    private TextView textView2, search_start;
    private TextView gogogo;
    private List<Address> list = null;
    private double lat, lng;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Handler handler = new Handler();

    private String mParam1;
    private String mParam2;

    public fragment4() {

    }


    public static fragment4 newInstance(String param1, String param2) {
        fragment4 fragment = new fragment4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);

        search_start = view.findViewById(R.id.search_start);
        textView2 = view.findViewById(R.id.textView2);
        gogogo = view.findViewById(R.id.gogogo);

        search_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity(), MapActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            lat = bundle.getDouble("Lat");
            lng = bundle.getDouble("Lng");
            textView2.setText(lat + lng + "");

        } else {
            Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
        }

        gogogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Geocoder geocoder = new Geocoder(getActivity());

                try {
                    list = geocoder.getFromLocation(lat, lng, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                } if (list != null) {
                    if (list.size() == 0) {
                        Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
                    } else {
                        textView2.setText(list.get(0).getAddressLine(0));
                    }
                }
            }
        });
        return view;
    }
}