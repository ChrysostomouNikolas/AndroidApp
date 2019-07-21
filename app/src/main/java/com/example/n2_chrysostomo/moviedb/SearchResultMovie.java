package com.example.n2_chrysostomo.moviedb;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class SearchResultMovie{
    public int id;
    public String posterPath;
    public String originalTitle;
    public String overview;

    public SearchResultMovie(JsonObject jsonObject){
        this.id = jsonObject.get("id").getAsInt();
        this.posterPath = jsonObject.get("poster_path").toString().equals("null") ? "N/A": jsonObject.get("poster_path").getAsString() ;
        this.originalTitle = jsonObject.has("original_title") ? jsonObject.get("original_title").getAsString() : "N/A";
        this.overview = jsonObject.get("overview").toString().equals("null") ? "N/A": jsonObject.get("overview").getAsString() ;
    }
}
/*this is the class we will be using to search the database...
//we create strings that we will be using from the json file
however we will only be using a few and these are the key parts..
the id that represents that movie
the original title for the movies name
the poster path top print the picture  of the movie and
finally the overview with the quick summary
        */