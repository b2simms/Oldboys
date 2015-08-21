package com.example.bsimmons.databasetesting;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RestApiCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_api_call);
    }

    @Override
    public void onStart(){
        super.onStart();

        String url = "http://bsimms2.byethost5.com/index.php/schedule";

        //String s = getRESTAPICALL(url);

        String s2 = getJSONResponse(url);


        TextView displayText = (TextView) findViewById(R.id.display_info);
        displayText.setText(s2);

        Button exit = (Button) findViewById(R.id.button_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                Log.i("Exiting rest call", "Calling MainActivity class");
                startActivity(i);
            }
        });
    }

    private String getRESTAPICALL(String url) {


// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        Log.i("Rest Call Success", response.substring(0, 100));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                Log.e("Rest error","Something went wrong!");
                error.printStackTrace();

            }
        });

        // Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);


        return "String done.";
    }

    public String getJSONResponse(String url) {

        Response.Listener<JSONObject> rl = new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                // the response is already constructed as a JSONObject!
                try {
                    response = response.getJSONObject("args");
                    //JSONArray arr = response.getJSONArray("games");
                    String site = response.getString("game_id"),
                            network = response.getString("date");
                    Log.i("JSON Response", "Site: "+site+" Network: "+network);
                } catch (JSONException e) {
                    Log.i("JSON Response", "ERROR in JSON Request");
                }
            }
        };

        Response.ErrorListener re = new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        };


        //JsonObjectRequest jsonRequest = new JsonObjectRequest(url, null,rl,re);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(url,null,rl,re);

        Volley.newRequestQueue(this).add(jsonRequest);

        return "JSON done.";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rest_api_call, menu);
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
