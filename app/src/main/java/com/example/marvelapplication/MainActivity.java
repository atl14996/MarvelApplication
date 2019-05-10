package com.example.marvelapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMarvelList = findViewById(R.id.rvMarvelHeroes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        final MarvelListAdapter adapter = new MarvelListAdapter(new ArrayList<Marvel>());
        rvMarvelList.setAdapter(adapter);
        rvMarvelList.setLayoutManager(layoutManager);


        RemoteDataSource remoteDataSource = new RemoteDataSource();
        remoteDataSource.getMarvelHeroes(new RemoteDataSource.Callback() {
            @Override
            public void onSuccess(List<Marvel> heroes) {
                adapter.updateList(heroes);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }


}
