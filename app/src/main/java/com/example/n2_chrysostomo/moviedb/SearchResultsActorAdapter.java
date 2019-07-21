package com.example.n2_chrysostomo.moviedb;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;       //adding libraries
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class SearchResultsActorAdapter extends RecyclerView.Adapter<SearchResultsActorAdapter.ViewHolder2>{



    public class ViewHolder2 extends RecyclerView.ViewHolder{
        public TextView actorTitle;
        public TextView actorSearchOverview;
        public Button invisButton2;


        public ViewHolder2(View itemView){
            super(itemView);

            actorTitle = itemView.findViewById(R.id.actorTitle);
            invisButton2 = itemView.findViewById(R.id.invisButton2);//combine the variables with the xml file
            actorSearchOverview = itemView.findViewById(R.id.actorSearchOverview);
        }
    }//end of classViewHolder

    List<SearchResultActor> searchResults2;
    private Context context2;

    public SearchResultsActorAdapter(List<SearchResultActor> searchResultActorArg) {
        searchResults2=searchResultActorArg;
    }

    public  SearchResultsActorAdapter.ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        context2=parent.getContext();
        LayoutInflater inflater2= LayoutInflater.from(context2);
        View searchResultActorView=inflater2.inflate(R.layout.recycler_element, parent, false);
        ViewHolder2 viewHolder2 = new ViewHolder2(searchResultActorView);
        return viewHolder2;
    }

    @Override
    public void onBindViewHolder(SearchResultsActorAdapter.ViewHolder2 viewHolder2, int position2) {
        final SearchResultActor searchresultActor=searchResults2.get(position2);

        TextView actorTitle= viewHolder2.actorTitle;
        TextView actorBiography=viewHolder2.actorSearchOverview;
        Button actorbutton=viewHolder2.invisButton2;

        actorbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //NavigateGraph

            }
        });
        actorTitle.setText(searchresultActor.actorName);
        actorBiography.setText(searchresultActor.actorBiography);///THIS



    }

    @Override
    public int getItemCount() {
        return searchResults2.size();
    }
}
