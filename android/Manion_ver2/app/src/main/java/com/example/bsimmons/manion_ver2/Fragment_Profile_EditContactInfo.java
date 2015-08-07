package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class Fragment_Profile_EditContactInfo extends Fragment {

    FeedReaderDbHelper mDbHelper;
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile_editcontactinfo, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        mDbHelper = new FeedReaderDbHelper(getActivity().getBaseContext());
        db = mDbHelper.getWritableDatabase();

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
        Log.d("Debug EDIT", c.getString(c.getColumnIndex("street")) + " : "
                        + c.getString(c.getColumnIndex("city")) + " : "
                        + c.getString(c.getColumnIndex("province")) + " : "
                        + c.getString(c.getColumnIndex("postal")) + " : "
                        + c.getString(c.getColumnIndex("phone")) + " : "
                        + c.getString(c.getColumnIndex("email"))
        );

        EditText st = (EditText) getView().findViewById(R.id.edit_address_st);
        EditText city = (EditText) getView().findViewById(R.id.edit_address_city);
        EditText province = (EditText) getView().findViewById(R.id.edit_address_province);
        EditText postal = (EditText) getView().findViewById(R.id.edit_address_postal);
        EditText phone = (EditText) getView().findViewById(R.id.edit_phone_num);
        EditText email = (EditText) getView().findViewById(R.id.edit_email);

        st.setText(c.getString(c.getColumnIndex("street")));
        city.setText(c.getString(c.getColumnIndex("city")));
        province.setText(c.getString(c.getColumnIndex("province")));
        postal.setText(c.getString(c.getColumnIndex("postal")));
        phone.setText(c.getString(c.getColumnIndex("phone")));
        email.setText(c.getString(c.getColumnIndex("email")));


        Button save = (Button) getView().findViewById(R.id.edit_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText st = (EditText) getView().findViewById(R.id.edit_address_st);
                EditText city = (EditText) getView().findViewById(R.id.edit_address_city);
                EditText province = (EditText) getView().findViewById(R.id.edit_address_province);
                EditText postal = (EditText) getView().findViewById(R.id.edit_address_postal);
                EditText phone = (EditText) getView().findViewById(R.id.edit_phone_num);
                EditText email = (EditText) getView().findViewById(R.id.edit_email);

                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_STREET, st.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_CITY, city.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_PROVINCE,province.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ADDRESS_POSTAL, postal.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PHONE, phone.getText().toString());
                values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, email.getText().toString());

                long newRowId;
                newRowId = db.update(
                        FeedReaderContract.FeedEntry.TABLE_NAME,
                        values,
                        null,
                        null);

                FragmentManager fm = getActivity().getSupportFragmentManager();
                String tag = "Fragment_Profile_EditContactInfo";
                Fragment backTransition = new Fragment_Profile_ContactANDEmployer();

                fm.beginTransaction()
                        .replace(R.id.container, backTransition, tag)
                        .addToBackStack(tag)
                        .commit();
            }
        });

        Button cancel = (Button) getView().findViewById(R.id.edit_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment backTransition = new Fragment_Profile_ContactANDEmployer();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                String tag = "Fragment_Profile_EditContactInfo";
                fm.beginTransaction()
                        .replace(R.id.container, backTransition, tag)
                        .addToBackStack(tag)
                        .commit();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        //hides soft keyboard
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


}