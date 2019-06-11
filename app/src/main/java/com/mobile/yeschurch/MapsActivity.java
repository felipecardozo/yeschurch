package com.mobile.yeschurch;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobile.yeschurch.login.StandardLoginActivity;
import com.mobile.yeschurch.profile.ProfileActivity;
import com.mobile.yeschurch.signout.SignOutActivity;

import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;

    private ChurchFilterService churchFilterService;
    private List<Church> currentList;
    private String[] churchTypes;
    private ChurchType churchSelected;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private String email;

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

        setTitle("Mapa de Iglesias");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        email = firebaseUser.getEmail();
        if( email == null && email.isEmpty()){
            startActivity(new Intent(this, StandardLoginActivity.class));
        }

        churchTypes = getResources().getStringArray(R.array.churchtype);
        Spinner spinnerChurchType = findViewById(R.id.spinner_churchtype);
        spinnerChurchType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                churchSelected = ChurchType.getSeleted(churchTypes[position]);
                Log.i("SPINNER", "> " + churchTypes[position]+" > "+churchSelected.name());
                currentList = changeChurchByType(churchSelected);
                putMarkers(currentList);
                cleanFilters();
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
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Constants.bogota));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Constants.bogota, Constants.PREFERED_ZOOM));
        mMap.setOnInfoWindowClickListener(this);
        putMarkers( currentList );
    }

    private void putMarkers(List<Church> churches){
        mMap.clear();
        //https://github.com/codepath/android_guides/wiki/Fragment-Navigation-Drawer
        for( Church church : churches ){
            mMap.addMarker(new MarkerOptions()
                    .position(church.getLatLng())
                    .title(church.getName())
                    .snippet("Tap para mas informacion"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("FIREBASE", item.getTitle().toString());
        if( item.getTitle().toString().equalsIgnoreCase("Cerrar Sesion") ){
            startActivity(new Intent(this, SignOutActivity.class));
        }
        else if(item.getTitle().toString().equalsIgnoreCase("Perfil")){
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
        }
        super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Log.i("FIREBASE", marker.getTitle());
        startActivity(new Intent(this, DetailActivity.class));
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

    private List<Church> changeChurchByType(ChurchType type){
        if( type.equals(ChurchType.Catholic) ){
            return Constants.catholicChurches;
        }
        else if( type.equals(ChurchType.Bauptist) ){
            return Constants.bauptistChurches;
        }
        else if( type.equals(ChurchType.Others) ){
            return Constants.otherChurches;
        }
        return Constants.christianChurches;
    }

    private void cleanFilters() {
        CheckBox cbKids = findViewById(R.id.checkbox_kids);
        CheckBox cbParking = findViewById(R.id.checkbox_parking);
        CheckBox cbBath = findViewById(R.id.checkbox_bathroom);
        CheckBox cbAccess = findViewById(R.id.checkbox_accesability);
        CheckBox cbSign = findViewById(R.id.checkbox_signlang);

        if(cbKids.isChecked())
            cbKids.toggle();
        if(cbParking.isChecked())
            cbParking.toggle();
        if(cbBath.isChecked())
            cbBath.toggle();
        if(cbAccess.isChecked())
            cbAccess.toggle();
        if(cbSign.isChecked())
            cbSign.toggle();

    }

}
