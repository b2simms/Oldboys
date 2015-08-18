package com.example.bsimmons.databasetesting;

import android.provider.BaseColumns;

/**
 * Created by bsimmons on 13/08/2015.
 */
public final class Tables {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public Tables() {}

    /* Inner class that defines the table contents */
    public static abstract class TableInstance implements BaseColumns {
        public static final String TABLE_NAME = "Team";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_CITY = "city";
    }
//    /* Inner class that defines the table contents */
//    public static abstract class Tournaments implements BaseColumns {
//        public static final String TABLE_NAME = "Tournaments";
//        public static final String TOURNEY_ID = "tourney_id";
//        public static final String TEAM1_ID = "team1_id";
//        public static final String TEAM2_ID = "team2_id";
//
//    }
}
