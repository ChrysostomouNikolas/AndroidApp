package com.example.n2_chrysostomo.moviedb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class SearchResultsMovieAdapter extends RecyclerView.Adapter<SearchResultsMovieAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView movieTitle;
        public TextView movieSearchOverview;////
        public Button invisButton;


        public ViewHolder(View itemView){
            super(itemView);

            movieTitle = itemView.findViewById(R.id.movieTitle);
            invisButton = itemView.findViewById(R.id.invisButton);////THISss
            movieSearchOverview = itemView.findViewById(R.id.movieSearchOverview);
        }
    }

    List<SearchResultMovie> searchResults;
    private Context context;
    private Gson gson;


    public SearchResultsMovieAdapter(List<SearchResultMovie> searchResultMovieArg){ searchResults = searchResultMovieArg;}

    @Override
    public SearchResultsMovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View searchResultMovieView = inflater.inflate(R.layout.recycler_element, parent, false);

        ViewHolder viewHolder = new ViewHolder(searchResultMovieView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SearchResultsMovieAdapter.ViewHolder viewHolder, int position){
        final SearchResultMovie searchResultMovie = searchResults.get(position);

        TextView movieTitle = viewHolder.movieTitle;
        TextView movieOverview = viewHolder.movieSearchOverview;///
        Button  button = viewHolder.invisButton;

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO: Navigate to graph.
            }
        });

        movieTitle.setText(searchResultMovie.originalTitle);
        movieOverview.setText(searchResultMovie.overview);///


    }

    @Override
    public int getItemCount(){
        return searchResults.size();
    }
}
