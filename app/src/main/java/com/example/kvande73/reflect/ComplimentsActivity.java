package com.example.kvande73.reflect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.widget.EditText;
import android.view.View;

import org.json.JSONObject;

public class ComplimentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compliments);


        Switch onOffSwitch = (Switch) findViewById(R.id.switch_compliments);
        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    String URL = "http://192.168.86.30:8080/remote?action=SHOW&module=module_4_compliments";

                    RequestQueue requestQueue= Volley.newRequestQueue(com.example.kvande73.reflect.ComplimentsActivity.this);

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
                    String URL = "http://192.168.86.30:8080/remote?action=HIDE&module=module_4_compliments";

                    RequestQueue requestQueue= Volley.newRequestQueue(com.example.kvande73.reflect.ComplimentsActivity.this);

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

    }

    public String getCompliment() {
        EditText name = (EditText) findViewById(R.id.add_compliments);
        String plain_name = name.getText().toString();
        return plain_name;
    }

    public void submit(View view) {
        String URL = "http://192.168.86.30:8080/get?data=config";

        RequestQueue requestQueue= Volley.newRequestQueue(com.example.kvande73.reflect.ComplimentsActivity.this);

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

