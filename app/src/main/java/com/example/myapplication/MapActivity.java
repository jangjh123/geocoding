package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.gms.maps.MapFragment;

public class MapActivity extends AppCompatActivity {

    private Button button;
    private MapsFragment mapsFragment;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);


        initView();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, mapsFragment).commit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
    private void initView () {
        button = findViewById(R.id.button);
        mapsFragment = new MapsFragment();
        frame = findViewById(R.id.frame);
    }
}