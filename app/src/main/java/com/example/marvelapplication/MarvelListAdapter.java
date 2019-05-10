package com.example.marvelapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MarvelListAdapter extends RecyclerView.Adapter<MarvelListAdapter.ViewHolder> {

    List<Marvel> marvelList;

    public MarvelListAdapter(List<Marvel> marvelList){
        this.marvelList = marvelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.marvel_item_view, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Marvel marvel = marvelList.get(i);
        Glide.with(viewHolder.itemView.getContext()).load(marvel.getImageurl()).into(viewHolder.ivMarvel);
    }

    @Override
    public int getItemCount() {
        return marvelList.size();
    }


    public void updateList(List<Marvel> marvelList){
        this.marvelList.clear();
        this.marvelList.addAll(marvelList);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView ivMarvel;
         TextView tvMarvelName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMarvel = itemView.findViewById(R.id.ivMarvel);
            tvMarvelName = itemView.findViewById(R.id.tvMarvelName);
        }

        @Override
        public void onClick(View v) {

            Context context = itemView.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("marvel", marvelList.get(getAdapterPosition()));
            context.startActivity(intent);

        }
    }
}
