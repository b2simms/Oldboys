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


public class Adapter_Benefit extends ArrayAdapter<Info_Benefits> {
    private final Context context;
    private ArrayList<Info_Benefits> info;

    public Adapter_Benefit(Context context, ArrayList<Info_Benefits> info) {
        super(context, R.layout.fragment_benefit_listview, info);
        this.context = context;
        this.info = info;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_benefit_coverage, parent, false);

        TextView name = (TextView) rowView.findViewById(R.id.benefit_name);
        TextView carrier = (TextView) rowView.findViewById(R.id.benefit_carrier);
        TextView policyNum  = (TextView) rowView.findViewById(R.id.claim_date);
        TextView date = (TextView) rowView.findViewById(R.id.claim_code);
        TextView coverage = (TextView) rowView.findViewById(R.id.benefit_coverage);

        name.setText(info.get(position).getName());
        carrier.setText(info.get(position).getCarrier());
        policyNum.setText(info.get(position).getPolicyNum());
        date.setText(info.get(position).getDate());
        coverage.setText(info.get(position).getCoverage());

        return rowView;

    }

}