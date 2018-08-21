package com.example.kvande73.reflect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //FAB on main screen
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
            //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //            .setAction("Action", null).show();
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link CalendarActivity}
                Intent FabIntent = new Intent(MainActivity.this, FabActivity.class);

                // Start the new activity
                startActivity(FabIntent);
            }

        });

        //CALENDARMODULE on main screen
        TextView calendar = findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
            //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //            .setAction("Action", null).show();
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link CalendarActivity}
                Intent CalendarIntent = new Intent(MainActivity.this, CalendarActivity.class);

                // Start the new activity
                startActivity(CalendarIntent);
            }

        });

        //CALENDARSWITCH
        Switch onOffSwitch = (Switch) findViewById(R.id.switch_calendar);
        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String ip = getString(R.string.ip_address_mirror);
                String module = "module_3_calendar";
                if (isChecked){

                    String path = getString(R.string.endpoint_show);
                    String URL = ip + path + module;

                    RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);

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
                else {
                    String path = getString(R.string.endpoint_hide);
                    String URL = ip + path + module;

                    RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);

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
            }

        });

        //COMPLIMENTSMODULE on main screen
        TextView compliments = findViewById(R.id.compliments);
        compliments.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
            //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //            .setAction("Action", null).show();
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link CalendarActivity}
                Intent ComplimentsIntent = new Intent(MainActivity.this, ComplimentsActivity.class);

                // Start the new activity
                startActivity(ComplimentsIntent);
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
            Intent i = new Intent(this,SettingsActivity.class);
            this.startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
