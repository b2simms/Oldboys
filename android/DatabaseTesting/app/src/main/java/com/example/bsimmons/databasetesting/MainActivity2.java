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


public class MainActivity2 extends ActionBarActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DbHelper mDbHelper = new DbHelper(getApplicationContext());
        // Gets the data repository in write mode
        db = mDbHelper.getWritableDatabase();

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

        TextView name = (TextView) findViewById(R.id.name_team);
        TextView city = (TextView) findViewById(R.id.city_team);
        name.setText(c.getString(c.getColumnIndex("name")));
        city.setText(c.getString(c.getColumnIndex("city")));

        Button editTeam = (Button) findViewById(R.id.edit_team_button);
        editTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
