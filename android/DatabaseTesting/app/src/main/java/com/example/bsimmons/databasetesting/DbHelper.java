package com.example.bsimmons.databasetesting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by bsimmons on 13/08/2015.
 */

public class DbHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Tables.Team.TABLE_NAME + " (" +
                    Tables.Team._ID + " INTEGER PRIMARY KEY," +
                    Tables.Team.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    Tables.Team.COLUMN_NAME_CITY + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Tables.Team.TABLE_NAME;
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FifaDatabase.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public void deleteTable(SQLiteDatabase db){
        db.execSQL(SQL_DELETE_ENTRIES);
    }

    //TABLE : Team
    //insert new row
    public void insertTeam (Team t) {
        db = getWritableDatabase();

        Log.d("insertTeam","inserting team...");

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Tables.Team.COLUMN_NAME_NAME, t.getName());
        values.put(Tables.Team.COLUMN_NAME_CITY, t.getCity());
        long newRowId;
        newRowId = db.insert(
                Tables.Team.TABLE_NAME,
                null,
                values
        );

        Log.e("insertTeam", t.getName() + " : " + t.getCity());
    }

    //querying database for Team
    public Team getTeam() {
        db = getWritableDatabase();

        Log.d("getTeam","getting team...");

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                Tables.Team._ID,
                Tables.Team.COLUMN_NAME_NAME,
                Tables.Team.COLUMN_NAME_CITY,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                Tables.Team.COLUMN_NAME_NAME + " DESC";

        String selection = null;
        String[] selectionArgs = null;

        Cursor c = db.query(
                Tables.Team.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        c.moveToFirst();
        String name = c.getString(c.getColumnIndex(Tables.Team.COLUMN_NAME_NAME));
        String city = c.getString(c.getColumnIndex(Tables.Team.COLUMN_NAME_CITY));
        Log.d("getTeam", name + " : " + city);
        return new Team(name, city);
    }

    //update database at team _ID
    public void updateTeam(Team t) {
        db = getWritableDatabase();

        Log.d("updateTeam","updating team...");

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Tables.Team.COLUMN_NAME_NAME, t.getName());
        values.put(Tables.Team.COLUMN_NAME_CITY, t.getCity());

        long newRowId;
        newRowId = db.update(
                Tables.Team.TABLE_NAME,
                values,
                null,
                null);

        Log.d("updateTeam", t.getName() + " : " + t.getCity());
    }

    //checks if table columns exists
    public boolean isTeamColumnExisting(String tableName, String columnName) {
        db = getWritableDatabase();

        Log.d("isTeamColumnExisting","isTeamColumnExisting...");

        try{
            //Cursor cursor = db.rawQuery("select * from " + tableName, null);
            Cursor cursor = db.query(false, tableName,new String[]{Tables.Team.COLUMN_NAME_NAME},null,null,null,null,null,null,null);
            cursor.moveToFirst();
            Log.d("isTeamColumnExisting", cursor.getString(cursor.getColumnIndex(columnName)));
            for(int i = 0; i < cursor.getCount();i++){
                Log.d("isTeamColumnExisting","Row = " + cursor.getPosition());
            }

            return true;
        } catch (Exception e){
            return false;
        }
    }
}
