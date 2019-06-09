package com.mobile.yeschurch;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ChurchFilterService churchFilterService;
    private List<Church> currentList;
    private String[] churchTypes;
    private ChurchType churchSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        churchFilterService = new ChurchFilterService();
        currentList = Constants.christianChurches;

        churchTypes = getResources().getStringArray(R.array.churchtype);
        Spinner spinnerChurchType = findViewById(R.id.spinner_churchtype);
        spinnerChurchType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                churchSelected = ChurchType.getSeleted(churchTypes[position]);
                Log.i("SPINNER", "> " + churchTypes[position]+" > "+churchSelected.name());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(true);
        //mMap.addMarker(new MarkerOptions().position(bogota).title("Find..."));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Constants.bogota));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Constants.bogota, Constants.PREFERED_ZOOM));
        putMarkers( currentList );
    }

    private void putMarkers(List<Church> churches){
        mMap.clear();
        //https://github.com/codepath/android_guides/wiki/Fragment-Navigation-Drawer
        for( Church church : churches ){
            mMap.addMarker(new MarkerOptions().position(church.getLatLng()).title(church.getName()));
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox_accesability:
                currentList = churchFilterService.applyAccesability(currentList, checked, churchSelected);
                putMarkers(currentList);
                break;
            case R.id.checkbox_bathroom:
                currentList = churchFilterService.applyBathroom(currentList, checked, churchSelected);
                putMarkers(currentList);
                break;
            case R.id.checkbox_kids:
                currentList = churchFilterService.applyKids(currentList, checked, churchSelected);
                putMarkers(currentList);
                break;
            case R.id.checkbox_parking:
                currentList = churchFilterService.applyParking(currentList, checked, churchSelected);
                putMarkers(currentList);
                break;
            case R.id.checkbox_signlang:
                currentList = churchFilterService.applySignLanguage(currentList, checked, churchSelected);
                putMarkers(currentList);
                break;
        }
    }
}
