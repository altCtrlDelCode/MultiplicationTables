package com.darkheavenapps.udemy101_timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class LayoutResourceTable extends ArrayAdapter<String> {
    private Context mContext;
    private int mResource;
    public LayoutResourceTable(@NonNull Context context, int resource, ArrayList<String> object) {
        super(context, resource, object);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String tables = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tablesText = convertView.findViewById(R.id.layoutResourceTextView);
        tablesText.setText(tables);

        return convertView;
    }
}
