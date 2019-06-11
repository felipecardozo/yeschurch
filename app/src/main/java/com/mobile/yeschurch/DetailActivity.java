package com.mobile.yeschurch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private Button picturesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        picturesButton = findViewById(R.id.button_church_photos);
        picturesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(PictureActivity.class);
            }
        });

        Intent intent = getIntent();
        String title = intent.getStringExtra("churchName");
        if( title!=null ){
            setTitle(title);
        }

        Church church = createChurch();
        EditText nameChurch = (EditText)findViewById(R.id.text_church_name);
        nameChurch.setText(church.getName());

        EditText webChurch = (EditText)findViewById(R.id.text_church_url);
        webChurch.setText(church.getWebPage());

        EditText assistanceChurch = (EditText)findViewById(R.id.text_church_assistants);
        assistanceChurch.setText(church.getAssistance() + "");

        EditText scheduleChurch = (EditText)findViewById(R.id.text_church_schedule);
        scheduleChurch.setText(church.getSchedule().toString());

        ImageView kidsChurch = (ImageView)findViewById(R.id.text_church_kids_yes);
        //ImageView kidsChurchNo = (ImageView)findViewById(R.id.text_church_kids_no);
        /*if( church.isKids()==false ){
            Log.i("DETAILS", church.isKids()+"");
            kidsChurchNo.setVisibility(ImageView.INVISIBLE);
        }*/


        ImageView hasParkingChurch = findViewById(R.id.text_church_hasParking_yes);
        //hasParkingChurch.setText(Boolean.toString(church.isParking()));

        ImageView hasParkingOutsideChurch = findViewById(R.id.text_church_hasParkingOutside_yes);
        //hasParkingOutsideChurch.setText(Boolean.toString(church.isParkingOutside()));

        ImageView hasAccessibilityChurch = findViewById(R.id.text_church_hasAccessibility_yes);
        //hasAccessibilityChurch.setText(Boolean.toString(church.isAccessibility()));

        EditText idiomsChurch = (EditText)findViewById(R.id.text_church_idioms);
        idiomsChurch.setText(church.getIdioms().toString());

        ImageView hasSignLanguageChurch = findViewById(R.id.text_church_hasSignLanguage_yes);
        //hasSignLanguageChurch.setText(Boolean.toString(church.isSignLanguage()));

        ImageView hasBathroomsChurch = findViewById(R.id.text_church_hasBathrooms_yes);
        //hasBathroomsChurch.setText(Boolean.toString(church.isBathrooms()));
    }

    private Church createChurch() {
        Church church = new Church();
        church.setName("El lugar de su presencia");
        church.setWebPage("www.supresencia.com");
        church.setAssistance(500000);

        List <String> schedules = new ArrayList<>();
        schedules.add("Miercoles 7pm");
        schedules.add("Martes y Jueves 6am-7am");

        church.setSchedule(schedules);
        church.setKids(true);
        church.setParking(true);
        church.setParkingOutside(false);
        church.setAccessibility(true);

        List <String> idioms = new ArrayList<>();
        idioms.add("Ingles");
        idioms.add("Español");
        church.setIdioms(idioms);

        church.setSignLanguage(true);
        church.setBathrooms(true);


        return church;
    }

    private void nextActivity(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
