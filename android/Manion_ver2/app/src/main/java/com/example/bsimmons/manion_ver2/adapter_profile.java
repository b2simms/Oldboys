package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class adapter_profile extends ArrayAdapter<String> {
    private final Context context;
    private ArrayList<String> info;

    public adapter_profile(Context context, ArrayList<String> info, String[] values) {
        super(context, R.layout.adapter_profile, values);
        this.context = context;
        this.info = info;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_profile, parent, false);
        TextView menu = (TextView) rowView.findViewById(R.id.profile_menu_text);

        //change background color on even positions

        /*View v = rowView.findViewById(R.id.adapter_profile);
        if(position%2!=0){
            v.setBackgroundResource(R.drawable.row_onclick_color);
        }else {
            v.setBackgroundResource(R.drawable.row_onclick_color);
        }*/

        menu.setText(info.get(position));

        return rowView;
    }


}
