package com.example.marvelapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ivMarvel = findViewById(R.id.ivMarvel);
        Marvel marvel = getIntent().getParcelableExtra("marvel");
        Glide.with(this).load(marvel.getImageurl()).into(ivMarvel);

    }
}
