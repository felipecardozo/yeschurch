package com.mobile.yeschurch;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
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

        //mMap.addMarker(new MarkerOptions().position(bogota).title("Find..."));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Constants.bogota));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Constants.bogota, Constants.PREFERED_ZOOM));
        putMarkers();
    }

    private void putMarkers(){
        //add menu left side
        //https://github.com/codepath/android_guides/wiki/Fragment-Navigation-Drawer
        for( Church church : Constants.christianChurchs ){
            mMap.addMarker(new MarkerOptions().position(church.getLatLng()).title(church.getName()));
        }
    }
}
