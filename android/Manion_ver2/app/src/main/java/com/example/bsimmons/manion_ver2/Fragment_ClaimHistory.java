package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fragment_ClaimHistory extends Fragment {

    View rootView;
    ExpandableListView lv;
    private List<Info_Row> listDataHeader;
    private HashMap<String,Info_Claims> listDataChild;
    private boolean isGroupExpanded = false;


    public Fragment_ClaimHistory() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepareListData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_claim_expandablelist, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expandableList);
        lv.setDivider(null);
        lv.setDividerHeight(0);

        lv.setAdapter(new Adapter_ClaimHistory(listDataHeader, listDataChild, getActivity()));
        lv.setGroupIndicator(null);

        lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                if (parent.isGroupExpanded(groupPosition)) {
                    parent.collapseGroup(groupPosition);
                } else {
                    parent.expandGroup(groupPosition);
                }
                return true;
            }
        });
        lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                parent.collapseGroup(groupPosition);
                return true;
            }
        });
    }



    public void  prepareListData() {

        listDataHeader = new ArrayList<Info_Row>();
        listDataChild = new HashMap<String, Info_Claims>();

        Info_Claims list0 = new Info_Claims();
        list0.setIsNull(true);

        listDataHeader.add(new Info_Row("4 Mar 2015", "Medical", true));
        listDataHeader.add(new Info_Row(new String[]{"0", "Medical", "Janelle Muir", "Blood Pressure", "54.29"}));
        listDataHeader.add(new Info_Row("15 Dec 2014", "Medical", true));
        listDataHeader.add(new Info_Row(new String[]{"1", "Medical", "Janelle Muir", "Blood Donation", "54.29"}));
        listDataHeader.add(new Info_Row("3 Nov 2014", "Medical", true));
        listDataHeader.add(new Info_Row(new String[]{"2","Medical","Janelle Muir","Eye Examination","212.99"}));
        listDataHeader.add(new Info_Row("16 Oct 2014", "Dental",true));
        listDataHeader.add(new Info_Row(new String[]{"3", "Dental", "John Muir", "78900", "31.00"}));
        listDataHeader.add(new Info_Row(new String[]{"4","Dental","John Muir","11278","18.00"}));
        listDataHeader.add(new Info_Row(new String[]{"5","Dental","John Muir","30021","110.00"}));
        listDataHeader.add(new Info_Row("22 Sep 2014", "Medical",true));
        listDataHeader.add(new Info_Row(new String[]{"6","Medical","Janelle Muir","Blood Pressure","66.28"}));
        listDataHeader.add(new Info_Row(new String[]{"7","Medical","John Muir","Blood Pressure","44.29"}));
        listDataHeader.add(new Info_Row(new String[]{"8","Medical","John Muir","Blood Pressure","44.29"}));
        listDataHeader.add(new Info_Row("12 Sep 2014", "Medical",true));
        listDataHeader.add(new Info_Row(new String[]{"9","Medical","Janelle Muir","Blood Pressure","66.28"}));
        listDataHeader.add(new Info_Row(new String[]{"10","Medical","John Muir","Blood Pressure","44.29"}));
        listDataHeader.add(new Info_Row(new String[]{"11","Medical","John Muir","Blood Pressure","44.29"}));
        listDataHeader.add(new Info_Row("1 Sep 2014", "Medical",true));
        listDataHeader.add(new Info_Row(new String[]{"12","Medical","Janelle Muir","Blood Pressure","23.28"}));
        listDataHeader.add(new Info_Row("10 Jun 2014", "Medical",true));
        listDataHeader.add(new Info_Row(new String[]{"13","Medical","John Muir","Broken Leg","166.28"}));



        Info_Claims list1 = new Info_Claims("Janelle Muir", "4 Mar 2015", "Blood Pressure Monitor", "54.29", "6 Mar 2015", "Drug Card");

        Info_Claims list2 = new Info_Claims("Janelle Muir", "15 Dec 2014", "Blood Pressure Monitor", "54.29", "6 Mar 2015", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list3 = new Info_Claims("Janelle Muir", "1 Mar 2015", "Eye Examination", "212.99", "3 Nov 2014", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list4 = new Info_Claims("John Muir", "1 Mar 2015", "Blood Pressure Monitor", "44.29", "16 Oct 2014", "Drug Card");
        Info_Claims list5 = new Info_Claims("John Muir", "1 Mar 2015", "Chipped Right Cuspid", "31.00", "16 Oct 2014", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list6 = new Info_Claims("John Muir", "1 Mar 2015", "Wisdom Teeth Removal", "18.00", "16 Oct 2014", "Drug Card");
        Info_Claims list7 = new Info_Claims("Janelle Muir", "1 Mar 2015", "Blood Pressure Monitor", "66.28", "22 Sep 2014", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list8 = new Info_Claims("John Muir", "1 Mar 2015", "Blood Pressure Monitor", "44.29", "22 Sep 2014", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list9 = new Info_Claims("John Muir", "1 Mar 2015", "Blood Pressure Monitor", "44.29", "22 Sep 2014", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list10 = new Info_Claims("Janelle Muir", "1 Mar 2015", "Blood Pressure Monitor", "66.28", "22 Sep 2014", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list11 = new Info_Claims("John Muir", "1 Mar 2015", "Blood Pressure Monitor", "44.29", "22 Sep 2014", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list12 = new Info_Claims("John Muir", "1 Mar 2015", "Blood Pressure Monitor", "44.29", "22 Sep 2014", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list13 = new Info_Claims("Jenelle Muir", "1 Mar 2015", "Blood Pressure Monitor", "44.29", "1 Sep 2014", "Cheque 97092 Issued 17 Oct 2014");
        Info_Claims list14 = new Info_Claims("John Muir", "1 Mar 2015", "Broken Leg", "166.29", "10 Jun 2014", "Cheque 97092 Issued 17 Oct 2014");

        listDataChild.put(listDataHeader.get(0).getDesc(), list0);
        listDataChild.put(listDataHeader.get(1).getList()[0], list1);
        listDataChild.put(listDataHeader.get(2).getDesc(), list0);
        listDataChild.put(listDataHeader.get(3).getList()[0], list2);
        listDataChild.put(listDataHeader.get(4).getDesc(), list0);
        listDataChild.put(listDataHeader.get(5).getList()[0], list3);
        listDataChild.put(listDataHeader.get(6).getDesc(), list0);
        listDataChild.put(listDataHeader.get(7).getList()[0], list4);
        listDataChild.put(listDataHeader.get(8).getList()[0], list5);
        listDataChild.put(listDataHeader.get(9).getList()[0], list6);
        listDataChild.put(listDataHeader.get(10).getDesc(), list0);
        listDataChild.put(listDataHeader.get(11).getList()[0], list7);
        listDataChild.put(listDataHeader.get(12).getList()[0], list8);
        listDataChild.put(listDataHeader.get(13).getList()[0], list9);
        listDataChild.put(listDataHeader.get(14).getDesc(), list0);
        listDataChild.put(listDataHeader.get(15).getList()[0], list10);
        listDataChild.put(listDataHeader.get(16).getList()[0], list11);
        listDataChild.put(listDataHeader.get(17).getList()[0], list12);
        listDataChild.put(listDataHeader.get(18).getDesc(), list0);
        listDataChild.put(listDataHeader.get(19).getList()[0], list13);
        listDataChild.put(listDataHeader.get(20).getDesc(), list0);
        listDataChild.put(listDataHeader.get(21).getList()[0], list14);


    }
}
