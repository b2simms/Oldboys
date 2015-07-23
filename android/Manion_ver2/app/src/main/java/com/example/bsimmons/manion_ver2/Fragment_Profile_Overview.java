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

public class Fragment_Profile_Overview extends Fragment {

    private ArrayList<Info_Row> row = new ArrayList<Info_Row>();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_benefit_listview, container, false);
        return inflater.inflate(R.layout.fragment_profile_overview, container, false);
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
//        row.add(new Info_Row("Cert Number","12312443254234"));
//        row.add(new Info_Row("First Name","Carolyn"));
//        row.add(new Info_Row("Middle Name", "-"));
//        row.add(new Info_Row("Last Name","Muir"));
//        row.add(new Info_Row("Birth Date","11 Mar 1959"));
//        row.add(new Info_Row("Gender","Female"));
//        row.add(new Info_Row("Marital Status","Married or Equivalent"));
//        row.add(new Info_Row("Member Status","Active"));
//        row.add(new Info_Row("Effective","16 Aug 2009"));
//        row.add(new Info_Row("Coverage Status","Active In Benefit"));
//
//        Adapter_ListView adapter = new Adapter_ListView(getActivity(), row);
//
//        // Assign adapter to ListView
//        listView.setAdapter(adapter);
//
      }
//
//    @Override
//    public void onStop(){
//        super.onDestroyView();
//        Log.d("Debug", "GeneralInfo onStop()");
//
//    }
////    @Override
////    public void onDetach(){
////        super.onDetach();
////        Log.d("Debug", "GeneralInfo onStop()");
////    }



}