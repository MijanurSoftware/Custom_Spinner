package com.example.customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<CustomItems> {
    public CustomArrayAdapter(@NonNull Context context, ArrayList<CustomItems> customList) {
        super(context, 0, customList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return customView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return customView(position, convertView, parent);
    }


    public View customView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner, parent, false);
        }

        CustomItems customItems = getItem(position);

        TextView itemText = convertView.findViewById(R.id.itemText);
        ImageView itemImage = convertView.findViewById(R.id.itemImage);

        if (customItems != null){
            itemText.setText(customItems.getSpinnerText());
            itemImage.setImageResource(customItems.getSpinnerImage());
        }

        return convertView;

    }



}
