package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_Profile_ContactANDEmployer extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_contactandemployer, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getActivity().getBaseContext());
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

//        mDbHelper.onUpgrade(db,1,2);
//        if(isTableExisting(db,"table2")) {
//            // Create a new map of values, where column names are the keys
//            ContentValues values = new ContentValues();
//            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_STREET, "D");
//            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_CITY, "D");
//            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_PROVINCE, "D");
//            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_POSTAL, "D");
//            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PHONE, "D");
//            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, "D");
//            long newRowId;
//            newRowId = db.insert(
//                    FeedReaderContract.FeedEntry.TABLE_NAME,
//                    null,
//                    values
//            );
//
//            Log.e("Debug","Create table");
//        }

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
            FeedReaderContract.FeedEntry._ID,
            FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_STREET,
            FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_CITY,
            FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_PROVINCE,
            FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_POSTAL,
            FeedReaderContract.FeedEntry.COLUMN_NAME_PHONE,
            FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
            FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_STREET + " DESC";

        String selection = null;
        String[] selectionArgs = null;

        Cursor c = db.query(
            FeedReaderContract.FeedEntry.TABLE_NAME,  // The table to query
            projection,                               // The columns to return
            selection,                                // The columns for the WHERE clause
            selectionArgs,                            // The values for the WHERE clause
            null,                                     // don't group the rows
            null,                                     // don't filter by row groups
            sortOrder                                 // The sort order
        );

        c.moveToFirst();
        Log.d("Debug MAIN1", c.getString(c.getColumnIndex("street")) + " : "
                        + c.getString(c.getColumnIndex("city")) + " : "
                        + c.getString(c.getColumnIndex("province")) + " : "
                        + c.getString(c.getColumnIndex("postal")) + " : "
                        + c.getString(c.getColumnIndex("phone")) + " : "
                        + c.getString(c.getColumnIndex("email"))
        );

        TextView st = (TextView) getView().findViewById(R.id.edit_address_st);
        TextView city = (TextView) getView().findViewById(R.id.edit_address_city);
        TextView province = (TextView) getView().findViewById(R.id.edit_address_province);
        TextView postal = (TextView) getView().findViewById(R.id.edit_address_postal);
        TextView phone = (TextView) getView().findViewById(R.id.edit_phone_num);
        TextView email = (TextView) getView().findViewById(R.id.edit_email);
        st.setText(c.getString(c.getColumnIndex("street")));
        city.setText(c.getString(c.getColumnIndex("city")));
        province.setText(c.getString(c.getColumnIndex("province")));
        postal.setText(c.getString(c.getColumnIndex("postal")));
        phone.setText(c.getString(c.getColumnIndex("phone")));
        email.setText(c.getString(c.getColumnIndex("email")));


        Button edit = (Button) getView().findViewById(R.id.edit_save);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment editTransition = new Fragment_Profile_EditContactInfo();

                FragmentManager fm = getActivity().getSupportFragmentManager();
                String tag = "Fragment_Profile_EditContactInfo";
                fm.beginTransaction()
                        .replace(R.id.container, editTransition, tag)
                        .addToBackStack(tag)
                        .commit();
            }
        });
        Button cancel = (Button) getView().findViewById(R.id.edit_save);


    }
    public boolean isTableExisting(SQLiteDatabase db, String tableName) {

        Cursor cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

}

