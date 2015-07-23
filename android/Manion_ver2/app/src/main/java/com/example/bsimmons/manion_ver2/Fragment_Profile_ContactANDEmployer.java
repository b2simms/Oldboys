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

public class Fragment_Profile_ContactANDEmployer extends Fragment {

    private ArrayList<Info_Row> row = new ArrayList<Info_Row>();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_contactandemployer, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

//        // Get ListView object from xml
//        listView = (ListView) getView().findViewById(R.id.mainListView);
//        listView.setDivider(null);
//        listView.setDividerHeight(0);
//
//        // Define a new Adapter
//        // First parameter - Context
//        // Second parameter - Layout for the row
//        // Third parameter - ID of the TextView to which the data is written
//        // Fourth - the Array of data
//        row.add(new Info_Row("E-Mail","kelly.scribner@gmail.com"));
//        row.add(new Info_Row("Phone","(506)675-2525"));
//        row.add(new Info_Row("Address", "45 Huntington Ln St. Catherines, ON L2S 3R5"));
//        row.add(new Info_Row("Banking","69042-837-0126074449 837 Hepcoe Credit Union Limited" +
//                "This bank account information will be used for the following payments: Dental/Medical Claims"));
//
//        Adapter_ListView adapter = new Adapter_ListView(getActivity(), row);
//
//        // Assign adapter to ListView
//        listView.setAdapter(adapter);

    }
}
