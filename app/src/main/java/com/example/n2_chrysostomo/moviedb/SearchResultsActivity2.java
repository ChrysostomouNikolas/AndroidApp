package com.example.n2_chrysostomo.moviedb;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity2 extends AppCompatActivity {

    Intent aintent;

    List<SearchResultActor> searchResultActor = new ArrayList<>();
    SearchResultsActorAdapter adapter2;
    RecyclerView recyclerView2;

    JsonParser parser2 = new JsonParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results2);
        ApiWrapper.getInstance(this);

        recyclerView2 = findViewById(R.id.recyclerActor);

        aintent = getIntent();
        String url2 = aintent.getStringExtra("url");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager);

        makeRequest(url2);


    }

    void makeRequest(String url2){
        ApiWrapper.getInstance().makeQuery(url2, new RequestListener<String>() {
            @Override
            public void getResult(String result) {
                JsonObject jsonObject = (JsonObject) parser2.parse(result);
                makeSearchResults(jsonObject);
            }
        });
    }

    void makeSearchResults(JsonObject results){
        for(JsonElement element : results.get("results").getAsJsonArray()){
            searchResultActor.add(new SearchResultActor(element.getAsJsonObject()));
        }
        adapter2 = new SearchResultsActorAdapter(searchResultActor);
        recyclerView2.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
    }
}

