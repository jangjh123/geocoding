package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class MapsFragment extends Fragment {
    private List<Address> list = null;
    private double myLatitude;
    private double myLongitude;
    private Handler handler = new Handler();
    public static Marker marker;
    private String result;
    private MarkerOptions markerOptions = new MarkerOptions();

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap map) {


            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            long minTime = 2000;
            int minDistance = 0;
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            myLatitude = location.getLatitude();
            myLongitude = location.getLongitude();
            LatLng myLocation = new LatLng(myLatitude, myLongitude);
            map.addMarker(markerOptions.position(myLocation));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 16));
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, locationListener);

            map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(@NonNull @NotNull LatLng latLng) {
                        marker = map.addMarker(markerOptions.position(latLng));
                        double myLat = latLng.latitude;
                        double myLng = latLng.longitude;
                    Geocoder geocoder = new Geocoder(getActivity());
                    try {
                        list = geocoder.getFromLocation(myLat, myLng, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (list != null) {
                        if (list.size() == 0) {
                            Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
                        } else {
                            result = list.get(0).getAddressLine(0);
                        }
                    }
                        Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                        intent.putExtra("result", result);
                        getActivity().startActivity(intent);
                }
            });

        }
    };

    final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            myLatitude = location.getLatitude();
            myLongitude = location.getLongitude();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);

        }
    }
}