package com.example.bsimmons.databasetesting;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart(){
        super.onStart();

        DbHelper mDbHelper = new DbHelper(getApplicationContext());
        // Gets the data repository in write mode
        db = mDbHelper.getWritableDatabase();

        //used to
        if(!isTableColumnExisting(db,Tables.TableInstance.TABLE_NAME, Tables.TableInstance.COLUMN_NAME_NAME)) {
            mDbHelper.onUpgrade(db,1,2);
            // Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(Tables.TableInstance.COLUMN_NAME_NAME, "D");
            values.put(Tables.TableInstance.COLUMN_NAME_CITY, "D");
            long newRowId;
            newRowId = db.insert(
                    Tables.TableInstance.TABLE_NAME,
                    null,
                    values
            );

            Log.e("Debug","Create table");
       }

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                Tables.TableInstance._ID,
                Tables.TableInstance.COLUMN_NAME_NAME,
                Tables.TableInstance.COLUMN_NAME_CITY,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                Tables.TableInstance.COLUMN_NAME_NAME + " DESC";

        String selection = null;
        String[] selectionArgs = null;

        Cursor c = db.query(
                Tables.TableInstance.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        c.moveToFirst();
        Log.d("Debug MAIN1", c.getString(c.getColumnIndex("name")));

        EditText name = (EditText) findViewById(R.id.name);
        EditText city = (EditText) findViewById(R.id.city);
        name.setText(c.getString(c.getColumnIndex("name")));
        city.setText(c.getString(c.getColumnIndex("city")));


        Button displayTeam = (Button) findViewById(R.id.display_team_button);

        displayTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveToDb();

                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);

            }
        });
    }

    public void saveToDb() {
        EditText name = (EditText) findViewById(R.id.name);
        EditText city = (EditText) findViewById(R.id.city);

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Tables.TableInstance.COLUMN_NAME_NAME, name.getText().toString());
        values.put(Tables.TableInstance.COLUMN_NAME_CITY, city.getText().toString());

        long newRowId;
        newRowId = db.update(
                Tables.TableInstance.TABLE_NAME,
                values,
                null,
                null);
    }

    public boolean isTableColumnExisting(SQLiteDatabase db, String tableName, String columnName) {

        try{
            Log.d("Debug", "Query fails here?");
            //Cursor cursor = db.rawQuery("select * from " + tableName, null);
            Cursor cursor = db.query(false, tableName,new String[]{Tables.TableInstance.COLUMN_NAME_NAME},null,null,null,null,null,null,null);
            cursor.moveToFirst();
            Log.d("Database: ", cursor.getString(cursor.getColumnIndex(columnName)));
            for(int i = 0; i < cursor.getCount();i++){
                Log.d("Debug","Row = " + cursor.getPosition());
            }

            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
