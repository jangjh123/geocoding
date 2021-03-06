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

    public static ViewPager pager;
    fragment1 fragment1;
    fragment2 fragment2;
    fragment3 fragment3;
    fragment4 fragment4;
    fragment5 fragment5;
    fragment6 fragment6;
    fragment7 fragment7;
    fragment8 fragment8;
    fragment9 fragment9;
    fragment10 fragment10;
    fragment11 fragment11;
    fragment12 fragment12;
    fragment13 fragment13;
    fragment14 fragment14;
    fragment15 fragment15;
    fragment16 fragment16;
    fragment17 fragment17;
    fragment18 fragment18;
    fragment19 fragment19;
    httpfragment httpfragment;
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
        adapter.addItem(fragment5);
        adapter.addItem(fragment7);
        adapter.addItem(fragment8);
        adapter.addItem(fragment9);
        adapter.addItem(fragment10);
        adapter.addItem(fragment11);
        adapter.addItem(fragment14);
        adapter.addItem(fragment15);
        adapter.addItem(fragment16);
        adapter.addItem(fragment17);
        adapter.addItem(fragment18);
        adapter.addItem(fragment19);

        adapter.notifyDataSetChanged();
        pager.setCurrentItem(11);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());

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
        fragment8 = new fragment8();
        fragment9 = new fragment9();
        fragment10 = new fragment10();
        fragment11 = new fragment11();
        fragment12 = new fragment12();
        fragment13 = new fragment13();
        fragment14 = new fragment14();
        fragment15 = new fragment15();
        fragment16 = new fragment16();
        fragment17 = new fragment17();
        fragment18 = new fragment18();
        fragment19 = new fragment19();

        httpfragment = new httpfragment();

        pager.setAdapter(adapter);
    }
    private void myGetIntent () {
        Intent intent = getIntent();
        if (intent != null) {
            String result = intent.getStringExtra("result");

            Bundle bundle = new Bundle();
            bundle.putString("result", result);

            fragment4.setArguments(bundle);

        }


    }
}