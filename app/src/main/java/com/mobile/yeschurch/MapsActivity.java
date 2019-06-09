package com.mobile.yeschurch;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.MarkerOptions;

import java.nio.charset.CharacterCodingException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ChurchService churchService;
    private List<Church> currentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        churchService = new ChurchService();
        currentList = Constants.christianChurches;

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
        //add menu left side
        //https://github.com/codepath/android_guides/wiki/Fragment-Navigation-Drawer
        for( Church church : churches ){
            mMap.addMarker(new MarkerOptions().position(church.getLatLng()).title(church.getName()));
        }
    }

    private void cleanMarkers(){
        mMap.clear();
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox_accesability:
                if (checked){
                    cleanMarkers();
                }
                else{
                    cleanMarkers();
                }
                break;
            case R.id.checkbox_bathroom:
                if (checked){

                }
                else{

                }
                break;
            case R.id.checkbox_kids:
                if (checked){
                    currentList = churchService.applyKids(Constants.christianChurches, true);
                    cleanMarkers();
                    putMarkers(currentList);
                }
                else{
                    currentList = churchService.applyKids(Constants.christianChurches, false);
                    cleanMarkers();
                    putMarkers(currentList);
                }
                break;
            case R.id.checkbox_parking:
                if (checked){

                }
                else{

                }
                break;
            case R.id.checkbox_signlang:
                if (checked){

                }
                else{

                }
                break;
        }
    }
}
