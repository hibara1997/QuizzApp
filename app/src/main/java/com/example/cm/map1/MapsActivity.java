package com.example.cm.map1;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Emsi and move the camera
        LatLng emsi = new LatLng(33.583744, -7.642407);
        LatLng toto = new LatLng(33.5858, -7.642407);
        mMap.addMarker(new MarkerOptions()
                .position(emsi)
                .title("Hiba in Emsi")
                .snippet("Ok!!!!!")
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.hiba))
        );
        mMap.addMarker(new MarkerOptions()
                .position(toto)
                .title("Toto in position 2")
                .snippet("not Ok!!!!!")
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.toto))
        );
        Circle circle1 = mMap.addCircle(
                new CircleOptions()
                        .center(emsi)
                        .radius(100)
                        .fillColor(Color.GREEN)
                        .strokeColor(Color.GREEN)
        );
        Circle circle2 = mMap.addCircle(
                new CircleOptions()
                        .center(toto)
                        .radius(100)
                        .fillColor(Color.RED)
                        .strokeColor(Color.RED)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(emsi,16));
    }
}
