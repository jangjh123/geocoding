package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    fragment1 fragment1;
    fragment2 fragment2;
    fragment3 fragment3;
    fragment4 fragment4;
    fragment5 fragment5;
    fragment6 fragment6;
    fragment7 fragment7;
    MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        myGetIntent();

        adapter.addItem(fragment1);
        adapter.addItem(fragment2);
        adapter.addItem(fragment3);
        adapter.addItem(fragment4);
        adapter.addItem(fragment5);
        adapter.addItem(fragment6);
        adapter.addItem(fragment7);
        adapter.notifyDataSetChanged();
        pager.setCurrentItem(3);

    }
    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment> myList = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment fragment) {
            myList.add(fragment);
        }

        @NonNull
        @org.jetbrains.annotations.NotNull
        @Override
        public Fragment getItem(int position) {
            return myList.get(position);
        }

        @Override
        public int getCount() {
            return myList.size();
        }
    }
    private void initView () {
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager = findViewById(R.id.pager);

        fragment1 = new fragment1();
        fragment2 = new fragment2();
        fragment3 = new fragment3();
        fragment4 = new fragment4();
        fragment5 = new fragment5();
        fragment6 = new fragment6();
        fragment7 = new fragment7();

        pager.setAdapter(adapter);
    }
    private void myGetIntent () {
        Intent intent = getIntent();
        if (intent != null) {
            Double lat = intent.getDoubleExtra("Lat", 0);
            Double lng = intent.getDoubleExtra("Lng", 0);

            Bundle bundle = new Bundle();
            bundle.putDouble("Lat", lat);
            bundle.putDouble("Lng", lng);
            fragment4.setArguments(bundle);

        }


    }
}