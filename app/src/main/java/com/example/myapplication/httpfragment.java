package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class httpfragment extends Fragment {

    private String myUrl;
    private Handler handler = new Handler();
    private RecyclerView recyclerView;
    private ArrayList<Post> myList = new ArrayList<>();
    private RecycelerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_httpfragment, container, false);

        myUrl = "https://jsonplaceholder.typicode.com/posts";
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecycelerViewAdapter(myList, getContext());
        adapter.notifyDataSetChanged();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(myUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                    if (httpURLConnection != null) {
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);

                        int resCode = httpURLConnection.getResponseCode();
                        if (resCode == HttpURLConnection.HTTP_OK) {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                            String result = null;
                            while(true) {
                                result = reader.readLine();
                                if (result == null){
                                    Log.d("log", "null");
                                    break;
                                } else if (result != null) {
                                    Log.d("myLog", result);
                                }
                                reader.close();
                            }
                            httpURLConnection.disconnect();
                        } else {
                            Log.d("log", "error");
                        }
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        return view;
    }

}