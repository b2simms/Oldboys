package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment_Profile_ContactInfo extends Fragment {

    private ArrayList<Row> row = new ArrayList<Row>();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile_contactinfo, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Get ListView object from xml
        listView = (ListView) getView().findViewById(R.id.contactInfoList);


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Fourth - the Array of data
        row.add(new Row("E-Mail","kelly.scribner@gmail.com"));
        row.add(new Row("Phone","(506)675-2525"));
        row.add(new Row("Address", "45 HUNTINGTON LANE ST. CATHARINES, ON L2S 3R5"));
        row.add(new Row("Banking","69042-837-0126074449 837 Hepcoe Credit Union Limited" +
                "This bank account information will be used for the following payments: Dental/Medical Claims"));

        String[] values = new String[row.size()];
        for (int i = 0; i < row.size() - 1; i++) {
            values[i] = row.get(i).getDesc();
        }

        Adapter_Profile_Row adapter = new Adapter_Profile_Row(getActivity(), row, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

    }



}
