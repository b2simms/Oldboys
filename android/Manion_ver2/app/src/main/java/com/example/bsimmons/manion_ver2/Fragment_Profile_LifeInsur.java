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

public class Fragment_Profile_LifeInsur extends Fragment {

    private ArrayList<Row> row = new ArrayList<Row>();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile_generalinfo, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Get ListView object from xml
        listView = (ListView) getView().findViewById(R.id.generalInfoList);


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Fourth - the Array of data
        row.add(new Row("Cert Number","12312443254234"));
        row.add(new Row("First Name","CAROLYN"));
        row.add(new Row("Middle Name", "-"));
        row.add(new Row("Last Name","BENJAMINS"));
        row.add(new Row("Birth Date","11 Mar 1959"));
        row.add(new Row("Gender","Female"));
        row.add(new Row("Marital Status","Married or Equivalent"));
        row.add(new Row("Member Status","Active"));
        row.add(new Row("Effective","16 Aug 2009"));
        row.add(new Row("Coverage Status","Active In Benefit"));

        String[] values = new String[row.size()];
        for (int i = 0; i < row.size() - 1; i++) {
            values[i] = row.get(i).getDesc();
        }

        Adapter_Profile_Row adapter = new Adapter_Profile_Row(getActivity(), row, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

    }

}
