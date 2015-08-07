package com.example.bsimmons.manion_ver2;

import android.provider.BaseColumns;

/**
 * Created by bsimmons on 28/07/2015.
 **/

 public final class FeedReaderContract {
 // To prevent someone from accidentally instantiating the contract class,
 // give it an empty constructor.
 public FeedReaderContract() {}

 /* Inner class that defines the table contents */
public static abstract class FeedEntry implements BaseColumns {
    public static final String TABLE_NAME = "table2";
    public static final String COLUMN_NAME_ADDRESS_STREET = "street";
    public static final String COLUMN_NAME_ADDRESS_CITY = "city";
    public static final String COLUMN_NAME_ADDRESS_PROVINCE = "province";
    public static final String COLUMN_NAME_ADDRESS_POSTAL = "postal";
    public static final String COLUMN_NAME_PHONE = "phone";
    public static final String COLUMN_NAME_EMAIL= "email";
}
}