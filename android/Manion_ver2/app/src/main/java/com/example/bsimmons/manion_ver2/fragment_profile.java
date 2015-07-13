package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 09/07/2015.
 */

import android.app.ProgressDialog;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class fragment_profile extends Fragment {

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Get ListView object from xml
        listView = (ListView) getView().findViewById(R.id.listView);


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Fourth - the Array of data

        ArrayList<String> profile_menu = new ArrayList<String>();
        profile_menu.add("General Information");
        profile_menu.add("Contact Information");
        profile_menu.add("Employer");
        profile_menu.add("Dependents");
        profile_menu.add("Life Insurance Beneficiaries");

        // Defined Array values to show in ListView
        String[] values = new String[profile_menu.size()];

        for (int i = 0; i < profile_menu.size() - 1; i++) {
            values[i] = profile_menu.get(i);
        }

        adapter_profile adapter = new adapter_profile(getActivity(), profile_menu, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // Spinner on item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                try {

                    Fragment next_transition = new Fragment_Profile_GeneralInfo();

                    switch(position) {
                        case 0: //already loaded
                            break;
                        case 1:
                            next_transition = new Fragment_Profile_ContactInfo();
                            break;
                        case 2:
                            next_transition = new Fragment_Profile_Employer();
                            break;
                        case 3:
                            next_transition = new Fragment_Profile_Dependants();
                            break;
                        case 4:
                            next_transition = new Fragment_Profile_LifeInsur();
                            break;
                        default:
                            break;
                    }

                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    fm.beginTransaction()
                            .replace(R.id.container, next_transition)
                            .commit();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

        });

    }

}