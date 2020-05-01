 package com.sudha.drivetomsu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

 public class MainActivity extends AppCompatActivity implements  OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

     public void driveMe(View view) {
         Intent intent = new Intent(MainActivity.this, DriveMe.class);
         startActivity(intent);
         //40.8623, -74.1978

        // Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
          //       Uri.parse("http://maps.google.com/maps?daddr=40.8623,-74.1978"));
         //startActivity(intent);

     }

     @Override
     public void onMapReady(GoogleMap googleMap) {

         //MSU lat lang = 40.8623° N, 74.1978° W
         LatLng sydney = new LatLng(40.8623, -74.1978);
         googleMap.addMarker(new MarkerOptions().position(sydney)
                 .title("Marker in MSU"));
         googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16));

     }
 }
