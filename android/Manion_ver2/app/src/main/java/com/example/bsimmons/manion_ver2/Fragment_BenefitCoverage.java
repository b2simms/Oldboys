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
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import java.util.ArrayList;

public class Fragment_BenefitCoverage extends Fragment {

    private ArrayList<Info_Benefits> ben = new ArrayList();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_benefitcoverage_listview, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Get ListView object from xml
        listView = (ListView) getView().findViewById(R.id.benefitCoverageListView);
        listView.setDivider(null);
        listView.setDividerHeight(0);

        View rHeader = View.inflate(getActivity(),R.layout.adapter_benefit_header,null);
        View rHeader2 = View.inflate(getActivity(),R.layout.adapter_benefit_header2,null);
        View rFooter = View.inflate(getActivity(),R.layout.adapter_benefit_footer,null);
        listView.addHeaderView(rHeader);
        listView.addHeaderView(rHeader2);
        listView.addFooterView(rFooter);

        ben.clear();

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Fourth - the Array of data
        ben.add(new Info_Benefits("AD&D","La Capitale Financial Group","2305","16 Aug 2009","$38,000.00"));
        ben.add(new Info_Benefits("Dental","Self Funded - Generic","00929948","16 Aug 2009","Family"));
        ben.add(new Info_Benefits("Life","La Capitale Financial Group","2305","16 Aug 2009","$26,000.00"));
        ben.add(new Info_Benefits("LTD Taxible","Self Funded - Generic","00929948","16 Aug 2009","Family"));
        ben.add(new Info_Benefits("Medical","Self Funded - Generic","00162067","16 Aug 2009","Family"));
        ben.add(new Info_Benefits("Out of Country","AIG Insurance Company of Canada","SRG 903494","16 Aug 2009","Family"));

        Adapter_Benefit adapter = new Adapter_Benefit(getActivity(), ben);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

    }

}
