package com.example.kvande73.reflect;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class SettingsActivity extends AppCompatActivity {


    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        seekbar.setMax(100);
        seekbar.setProgress(60);

        // perform seek bar change listener event used for getting the progress value
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(0);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SettingsActivity.this, "Clarity is set to: " + progressChangedValue,
                        Toast.LENGTH_SHORT).show();

                String ip = getString(R.string.ip_address_mirror);
                String path = getString(R.string.endpoint_clarity);
                String URL = ip + path + progressChangedValue;

                RequestQueue requestQueue=Volley.newRequestQueue(SettingsActivity.this);

                JsonObjectRequest objectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        URL,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.e("Rest Response", response.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("Rest Response", error.toString());

                            }
                        }
                    );
                requestQueue.add(objectRequest);

            }
        });




    }



    //public String getConfig(String elem_config) {
    //    int pathID = getResources().getIdentifier(elem_config, "String","com.example.kvande73.reflect");
    //    String path = getResources().getString(pathID);
    //    Log.e("config: ", path);
     //   return path;
   // }



}


