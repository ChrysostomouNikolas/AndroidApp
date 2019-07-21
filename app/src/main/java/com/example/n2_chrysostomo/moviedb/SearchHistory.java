package com.example.n2_chrysostomo.moviedb;


  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.support.v7.widget.RecyclerView;
  import android.support.v7.widget.LinearLayoutManager;
  import android.view.View;
  import android.widget.Button;        /// adding our libraries




  public class SearchHistory extends AppCompatActivity {
      RecyclerView shRecyclerView;                    // the sh stands for the searchHistory
      SearchResultsMovieAdapter shadapter;           // We create a new adapter that will go through the movies

      protected void onCreate(Bundle savedInstanceState) {

          super.onCreate(savedInstanceState);
          setContentView(R.layout.search_history);
          ApiWrapper.getInstance(this);


          final Button bclearHistory =findViewById(R.id.clearHistory);
          shRecyclerView=findViewById(R.id.recyclerHistory);


          LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
          linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
          shRecyclerView.setLayoutManager(linearLayoutManager);
          /*shadapter = new SearchResultsMovieAdapter(Serializers.ObjectListToCompany(DatabaseWrapper.getInstance().get(new DatabaseQuery(DatabaseManager.TableManagerCompany.TABLE_NAME))));
          shRecyclerView.setAdapter(shadapter);
          shadapter.notifyDataSetChanged();
          */


          bclearHistory.setOnClickListener(new View.OnClickListener(){
              public void onClick(View view){
                  //need a database table to delete the user with delete method
                  //use the del() to delete the sesarch history

              }//end of on CLick

          });//end of click listener
      }//end of on create


}//end of class
