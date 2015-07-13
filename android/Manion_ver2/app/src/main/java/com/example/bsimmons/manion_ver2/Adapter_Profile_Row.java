package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class Adapter_Profile_Row extends ArrayAdapter<String> {
    private final Context context;
    private ArrayList<Row> info;

    public Adapter_Profile_Row(Context context, ArrayList<Row> info, String[] values) {
        super(context, R.layout.adapter_profile_row, values);
        this.context = context;
        this.info = info;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_profile_testtablelayout, parent, false);
        TextView desc = (TextView) rowView.findViewById(R.id.left_text);
        TextView infoText = (TextView) rowView.findViewById(R.id.right_text);
        desc.setText(info.get(position).getDesc() + ":");
        infoText.setText(info.get(position).getInfo());

        View v = rowView.findViewById(R.id.adapter_profile);
        if(position%2!=0){
            v.setBackgroundColor(0xe0f2f1);
        }

        return rowView;
    }

}
