package com.example.n2_chrysostomo.moviedb;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ApiWrapper {

    public RequestQueue requestQueue;
    private static ApiWrapper instance = null;

    private ApiWrapper(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());//
    }

    //make an instance of the APIWrapper so we can access it from any activity. We need to
    //init it once per activity.
    public static synchronized ApiWrapper getInstance(Context context){
        if(instance == null){
            instance = new ApiWrapper(context);
        }
        return instance;
    }

    public static synchronized ApiWrapper getInstance(){
        if(instance == null){
            throw new IllegalStateException("Api Wrapper is not initilaised");
        }
        return instance;
    }

    public void makeQuery(String url, final RequestListener<String> listener){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listener.getResult(response.toString());
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
