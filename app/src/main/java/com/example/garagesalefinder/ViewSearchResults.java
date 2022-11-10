package com.example.garagesalefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.garagesalefinder.PostStuff.Post;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ViewSearchResults extends AppCompatActivity {

    ListView list;
    ListViewAdapter adapter;//not sure what's up with this error
    ArrayList<Post> results = new ArrayList<Post>();
    Button returnBtn;
    Button searchBtn;
    Button viewPostBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_results);
        returnBtn = findViewById(R.id.btnReturn);
        searchBtn = findViewById(R.id.btnSearchAgain);


        results = (ArrayList<Post>) getIntent().getSerializableExtra("results");//this line won't work because the ArrayList passed through intent isn't type String
        list = (ListView) findViewById(R.id.listview);//locates ListView in xml file
        adapter = new ListViewAdapter(this, results);//not sure what's up with this error
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ViewSearchResults.this, "List item was clicked at " + i, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), ViewPost.class));
                finish();
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), Menu.class));
                finish();
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), SearchByLocation.class));
                finish();
            }
        });


    }



}