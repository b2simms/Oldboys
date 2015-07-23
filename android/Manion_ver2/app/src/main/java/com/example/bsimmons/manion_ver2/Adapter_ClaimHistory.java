package com.example.bsimmons.manion_ver2;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bsimmons on 15/07/2015.
 */

public class Adapter_ClaimHistory extends BaseExpandableListAdapter {

    private final LayoutInflater inf;
    private List<Info_Row> listDataHeader;
    private HashMap<String,Info_Claims> listDataChild;

    public Adapter_ClaimHistory(List<Info_Row> listDataHeader, HashMap<String, Info_Claims> listDataChild, FragmentActivity v) {
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
        inf = LayoutInflater.from(v);
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
       return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataChild.get(listDataHeader.get(groupPosition));
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listDataChild.get(listDataHeader.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }



    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = inf.inflate(R.layout.adapter_claim_child, parent, false);
            holder = new ViewHolder();

            holder.claimant = (TextView) convertView.findViewById(R.id.claim_name);
            holder.date = (TextView) convertView.findViewById(R.id.claim_date);
            holder.code= (TextView) convertView.findViewById(R.id.claim_code);
            holder.paid = (TextView) convertView.findViewById(R.id.claim_paid);
            holder.received = (TextView) convertView.findViewById(R.id.claim_received);
            holder.payInfo = (TextView) convertView.findViewById(R.id.claim_payInfo);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String s = listDataHeader.get(groupPosition).getList()[0];

        holder.claimant.setText(listDataChild.get(s).getClaimant());
        holder.date.setText(listDataChild.get(s).getDate());
        holder.code.setText(listDataChild.get(s).getCode());
        holder.paid.setText(listDataChild.get(s).getPaid());
        holder.received.setText(listDataChild.get(s).getReceived());
        holder.payInfo.setText(listDataChild.get(s).getPayInfo());

        return convertView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if(listDataHeader.get(groupPosition).getHeader()){
            ViewHolder_Header holder;
            if (convertView == null || !(convertView.getTag() instanceof ViewHolder_Header)) {
                convertView = inf.inflate(R.layout.adapter_claim_header, parent, false);

                holder = new ViewHolder_Header();
                holder.header_text = (TextView) convertView.findViewById(R.id.header_text);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder_Header) convertView.getTag();
            }

            holder.header_text.setText(listDataHeader.get(groupPosition).getDesc());


            return convertView;

        } else {
            ViewHolder_Group holder;
            if (convertView == null || !(convertView.getTag() instanceof ViewHolder_Group)) {
                convertView = inf.inflate(R.layout.adapter_claim_parent, parent, false);

                holder = new ViewHolder_Group();
                holder.col1_text = (TextView) convertView.findViewById(R.id.col1_text);
                holder.col2_text = (TextView) convertView.findViewById(R.id.col2_text);
                holder.col3_text = (TextView) convertView.findViewById(R.id.col3_text);
                holder.col4_text = (TextView) convertView.findViewById(R.id.col4_text);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder_Group) convertView.getTag();
            }

            TableLayout t    = (TableLayout) convertView.findViewById(R.id.adapter_table_claim);

            if(isExpanded) {
                t.setBackgroundResource(R.drawable.row_onclick_claim_group);
            }
            else  {
                t.setBackgroundColor(convertView.getResources().getColor(R.color.White));
            }

            holder.col1_text.setText(listDataHeader.get(groupPosition).getList()[1]);
            holder.col2_text.setText(listDataHeader.get(groupPosition).getList()[2]);
            holder.col3_text.setText(listDataHeader.get(groupPosition).getList()[3]);
            holder.col4_text.setText(listDataHeader.get(groupPosition).getList()[4]);


            return convertView;
        }


    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    private class ViewHolder {
        TextView claimant;
        TextView date;
        TextView code;
        TextView paid;
        TextView received;
        TextView payInfo;
    }
    private class ViewHolder_Header {
        TextView header_text;
    }

    private class ViewHolder_Group {
        TextView col1_text;
        TextView col2_text;
        TextView col3_text;
        TextView col4_text;
    }
}