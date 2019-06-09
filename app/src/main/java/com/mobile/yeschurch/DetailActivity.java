package com.mobile.yeschurch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        picturesButton = findViewById(R.id.button_church_photos);
        picturesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity(PictureActivity.class);
            }
        });

        Church church = createChurch();
        EditText nameChurch = (EditText)findViewById(R.id.text_church_name);
        nameChurch.setText(church.getName());

        EditText webChurch = (EditText)findViewById(R.id.text_church_url);
        webChurch.setText(church.getWebPage());

        EditText assistanceChurch = (EditText)findViewById(R.id.text_church_assistants);
        assistanceChurch.setText(church.getAssistance() + "");

        EditText scheduleChurch = (EditText)findViewById(R.id.text_church_schedule);
        scheduleChurch.setText(church.getSchedule().toString());

        EditText kidsChurch = (EditText)findViewById(R.id.text_church_kids);
        kidsChurch.setText( Boolean.toString(church.isKids()));

        EditText hasParkingChurch = (EditText)findViewById(R.id.text_church_hasParking);
        hasParkingChurch.setText(Boolean.toString(church.isParking()));

        EditText hasParkingOutsideChurch = (EditText)findViewById(R.id.text_church_hasParkingOutside);
        hasParkingOutsideChurch.setText(Boolean.toString(church.isParkingOutside()));

        EditText hasAccessibilityChurch = (EditText)findViewById(R.id.text_church_hasAccessibility);
        hasAccessibilityChurch.setText(Boolean.toString(church.isAccessibility()));

        EditText idiomsChurch = (EditText)findViewById(R.id.text_church_idioms);
        idiomsChurch.setText(church.getIdioms().toString());

        EditText hasSignLanguageChurch = (EditText)findViewById(R.id.text_church_hasSignLanguage);
        hasSignLanguageChurch.setText(Boolean.toString(church.isSignLanguage()));

        EditText hasBathroomsChurch = (EditText)findViewById(R.id.text_church_hasBathrooms);
        hasBathroomsChurch.setText(Boolean.toString(church.isBathrooms()));
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
