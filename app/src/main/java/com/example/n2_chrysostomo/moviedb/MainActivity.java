package com.example.n2_chrysostomo.moviedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init text boxes
        final EditText actorSearch = findViewById(R.id.actorSearch);
        final EditText movieSearch = findViewById(R.id.movieSearch);
        //Init search buttons
        final Button actorButton = findViewById(R.id.actorButton);
        final Button movieButton = findViewById(R.id.movieButton);

        //Click listeners
        actorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent aintent = new Intent(MainActivity.this, SearchResultsActivity2.class);
                String url2 = "https://api.themoviedb.org/3/search/person?api_key=44b8df79dd132eb5297b5c3a1c8a5e77&language=en-us&page=1&query=" + actorSearch.getText();
                aintent.putExtra("url", url2);
                startActivity(aintent);

            }
        });

        movieButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
                String url = "https://api.themoviedb.org/3/search/movie?api_key=44b8df79dd132eb5297b5c3a1c8a5e77&language=en-us&page=1&query=" + movieSearch.getText();
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }
}
