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


public class MainActivity extends ActionBarActivity {

    SQLiteDatabase db;
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart(){
        super.onStart();

        final DbHelper mDbHelper = new DbHelper(getApplicationContext());

        //used to check if column exists in table
        if(!mDbHelper.isTeamColumnExisting(Tables.Team.TABLE_NAME, Tables.Team.COLUMN_NAME_NAME)) {
            mDbHelper.onUpgrade(db,1,2);
            team = new Team("New","New");
            mDbHelper.insertTeam(team);
       }
        team = mDbHelper.getTeam();

        EditText name = (EditText) findViewById(R.id.name);
        EditText city = (EditText) findViewById(R.id.city);
        name.setText(team.getName());
        city.setText(team.getCity());

        Button displayTeam = (Button) findViewById(R.id.display_team_button);

        displayTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name);
                EditText city = (EditText) findViewById(R.id.city);
                String setName = name.getText().toString();
                String setCity = city.getText().toString();
                Team setTeam = new Team(setName, setCity);

                mDbHelper.updateTeam(setTeam);

                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);

            }
        });
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
