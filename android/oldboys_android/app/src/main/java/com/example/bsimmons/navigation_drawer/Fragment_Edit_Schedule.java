package com.example.bsimmons.navigation_drawer;

/**
 * Created by bsimmons on 18/06/2015.
 * Fragment_Edit_Schedule
 */

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Fragment_Edit_Schedule extends Fragment {

    private String[] passedValues;
    private TextView team_home;
    private TextView team_away;
    private TextView location;
    private TextView date;
    private TextView score_home;
    private TextView score_away;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        passedValues = new String[10];
        passedValues[0] = bundle.getString("game_id");
        passedValues[1] = bundle.getString("team1");
        passedValues[2] = bundle.getString("team2");
        passedValues[3] = bundle.getString("day");
        passedValues[4] = bundle.getString("time");
        passedValues[5] = bundle.getString("location");
        passedValues[6] = bundle.getString("date");
        passedValues[7] = bundle.getString("team1_score");
        passedValues[8] = bundle.getString("team2_score");
        passedValues[9] = bundle.getString("updated");

        return inflater.inflate(R.layout.fragment_edit_schedule, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        team_home = (TextView) getView().findViewById(R.id.edit_team_home);
        team_home.setText(passedValues[1]);
        team_away = (TextView) getView().findViewById(R.id.edit_team_away);
        team_away.setText(passedValues[2]);
        location = (TextView) getView().findViewById(R.id.edit_location);
        location.setText(passedValues[5]);
        date = (TextView) getView().findViewById(R.id.edit_date);
        date.setText(passedValues[6]);
        score_home = (TextView) getView().findViewById(R.id.edit_score_home);
        score_home.setText(passedValues[7]);
        score_away = (TextView) getView().findViewById(R.id.edit_score_away);
        score_away.setText(passedValues[8]);

        Button newMessage = (Button) getView().findViewById(R.id.btnUpdate);
        //Listening to button event
        newMessage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                try {
                    passedValues[1] = team_home.getText().toString();
                    passedValues[2] = team_away.getText().toString();
                    passedValues[5] = location.getText().toString();
                    passedValues[6] = date.getText().toString();
                    passedValues[7] = score_home.getText().toString();
                    passedValues[8] = score_away.getText().toString();

                    if(isConnected()) {
                        new UpdateScheduleAsyncTask().execute("http://bsimms2.byethost5.com/index.php/schedule/" + passedValues[0]);
                    } else {
                        Toast.makeText(getActivity(), "No Network Connection", Toast.LENGTH_LONG).show();
                    }

                    FragmentManager fm = getActivity().getSupportFragmentManager();

                    fm.beginTransaction()
                            .replace(R.id.container, new Fragment_Schedule(), "Schedule")
                            .commit();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }

    private String POST(String url, String[] list_data){
        InputStream inputStream;
        String result = "";
        try {

            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);

            String json;

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("game_id", list_data[0]);
            jsonObject.accumulate("team1", list_data[1]);
            jsonObject.accumulate("team2", list_data[2]);
            jsonObject.accumulate("date", list_data[6]);
            jsonObject.accumulate("location", list_data[5]);
            jsonObject.accumulate("team1_score", list_data[7]);
            jsonObject.accumulate("team2_score", list_data[8]);

            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            System.out.println("JSON String: " + json);

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);

            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 11. return result
        return result;
    }

    private class UpdateScheduleAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return POST(urls[0],passedValues);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            //nothing...
        }
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    private boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        return (networkInfo != null && networkInfo.isConnected());
    }
}