package com.example.n2_chrysostomo.moviedb;


import com.google.gson.JsonObject;



public class SearchResultActor{
    public int id;
    public String actorName;  //variables to store values strings for name and biography and int for the number of id
    public String actorBiography;


    public SearchResultActor(JsonObject jsonObject){
        this.id = jsonObject.get("id").getAsInt();
        this.actorName = jsonObject.get("name").toString().equals("null") ? "N/A": jsonObject.get("name").getAsString() ;
        this.actorBiography = jsonObject.has("biography") ? jsonObject.get("biography").getAsString() : "N/A";

    }
}
/*this is the class we will be using to search the database...
//we create strings that we will be using from the json file
however we will only be using a few and these are the key parts..
the id that represents that actor and its unique to him
the  name of the actor  and
finally the biography with the quick summary of the actors life
        */