package com.example.bsimmons.manion_ver2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
public class Fragment_Profile_DependantsANDBeneficiaries extends Fragment {

    private ArrayList<Info_Row> row = new ArrayList();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile_dependantsandbeneficiaries, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

//        // Get ListView object from xml
//        listView = (ListView) getView().findViewById(R.id.mainListView);
//        listView.setDivider(null);
//        listView.setDividerHeight(0);
//
//
//        // Define a new Adapter
//        // First parameter - Context
//        // Second parameter - Layout for the row
//        // Third parameter - ID of the TextView to which the data is written
//        // Fourth - the Array of data
//        row.add(new Info_Row("Name", "John Muir", true));
//        row.add(new Info_Row("Relationship", "Spouse", false));
//        row.add(new Info_Row("Name", "Janelle Muir", true));
//        row.add(new Info_Row("Relationship", "Child", false));
//        row.add(new Info_Row("Name", "Myril Muir", true));
//        row.add(new Info_Row("Relationship", "Mother", false));
//
//        Adapter_ListView adapter = new Adapter_ListView(getActivity(), row);
//
//        // Assign adapter to ListView
//        listView.setAdapter(adapter);

    }
}
