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

public class SearchResultsActivity extends AppCompatActivity {

    Intent intent;

    List<SearchResultMovie> searchResultMovies = new ArrayList<>();
    SearchResultsMovieAdapter adapter;
    RecyclerView recyclerView;

    JsonParser parser = new JsonParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ApiWrapper.getInstance(this);

        recyclerView = findViewById(R.id.recyclerMovie);

        intent = getIntent();
        String url = intent.getStringExtra("url");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        makeRequest(url);


    }

    void makeRequest(String url){
        ApiWrapper.getInstance().makeQuery(url, new RequestListener<String>() {
            @Override
            public void getResult(String result) {
                JsonObject jsonObject = (JsonObject) parser.parse(result);
                makeSearchResults(jsonObject);
            }
        });
    }

    void makeSearchResults(JsonObject results){
        for(JsonElement element : results.get("results").getAsJsonArray()){
            searchResultMovies.add(new SearchResultMovie(element.getAsJsonObject()));
        }
        adapter = new SearchResultsMovieAdapter(searchResultMovies);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
