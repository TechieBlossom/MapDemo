package com.techieblossom.mapdemo.mapdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapLandingActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int mapType = 0;
    public static final String MAP_TYPE = "MAP_TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_landing);
        mapType = getIntent().getIntExtra(MAP_TYPE, 0);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        stylizeMap(mapType);

        LatLng mumbai = new LatLng(19.0974241, 72.8445004);
        mMap.addMarker(new MarkerOptions().position(mumbai).title("Marker in Mumbai"));
        CameraPosition cameraPosition = new CameraPosition.Builder().
                target(mumbai).
                tilt(0).
                zoom(14).
                bearing(0).
                build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void stylizeMap(int mapType) {
        int mapStyle = R.raw.zero_map_style;
        switch (mapType) {
            case 0:
                //Aubergine with No Roads
                mapStyle = R.raw.zero_map_style;
                break;
            case 1:
                // Less Roads, water as light grey
                mapStyle = R.raw.one_map_style;
                break;
            case 2:
                // All Roads, All Labels, All Landmarks, Retro theme
                mapStyle = R.raw.two_map_style;
                break;
            case 3:
                // Standard map with Point of Interest
                mapStyle = R.raw.three_map_style;
                break;
            default:
                break;
        }

        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, mapStyle));
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setBuildingsEnabled(true);
    }
}