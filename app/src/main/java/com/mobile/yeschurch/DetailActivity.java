package com.mobile.yeschurch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

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
        kidsChurch.setText(church.getHasKids().toString());

        EditText hasParkingChurch = (EditText)findViewById(R.id.text_church_hasParking);
        hasParkingChurch.setText(church.getHasParking().toString());

        EditText hasParkingOutsideChurch = (EditText)findViewById(R.id.text_church_hasParkingOutside);
        hasParkingOutsideChurch.setText(church.getHasParkingOutside().toString());

        EditText hasAccessibilityChurch = (EditText)findViewById(R.id.text_church_hasAccessibility);
        hasAccessibilityChurch.setText(church.getHasAccessibility().toString());

        EditText idiomsChurch = (EditText)findViewById(R.id.text_church_idioms);
        idiomsChurch.setText(church.getIdioms().toString());

        EditText hasSignLanguageChurch = (EditText)findViewById(R.id.text_church_hasSignLanguage);
        hasSignLanguageChurch.setText(church.getHasSignLanguage().toString());

        EditText hasBathroomsChurch = (EditText)findViewById(R.id.text_church_hasBathrooms);
        hasBathroomsChurch.setText(church.getHasBathrooms().toString());
    }

    private Church createChurch() {
        Church church = new Church();
        church.setName("El lugar de su presencia");
        church.setWebPage("www.supresencia.com");
        church.setAssistance(500000);

        return church;
    }

}