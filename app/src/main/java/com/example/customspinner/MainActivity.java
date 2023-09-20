package com.example.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        // create spinnerItemlist

        ArrayList<CustomItems> customList = new ArrayList<>();

        customList.add(new CustomItems("English", R.drawable.baseline_cloud_download_24));
        customList.add(new CustomItems("Bangla", R.drawable.baseline_circle_notifications_24));
        customList.add(new CustomItems("Spanish", R.drawable.baseline_cloud_off_24));
        customList.add(new CustomItems("Hindi", R.drawable.baseline_check_24));


        //create Adapter for spinner
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(this, customList);

        if (spinner != null){
            spinner.setAdapter(customArrayAdapter);
            spinner.setOnItemSelectedListener(this);
        }






    }//-------------------------------------------------------------


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        CustomItems customItems = (CustomItems) adapterView.getSelectedItem();

        Toast.makeText(this, customItems.getSpinnerText(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}//-----------------------------------------------------------------