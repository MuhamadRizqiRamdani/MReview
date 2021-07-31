package com.example.mreview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mreview.R;
import com.example.mreview.model.Result;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context context;
    private List<Result> resultList;

    public MovieAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_film, parent, false);

        MovieAdapter.MyViewHolder viewHolder = new MovieAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(resultList.get(position).getTitle());
        holder.tvDescription.setText(resultList.get(position).getOverview());
        holder.tvReleaseDate.setText(resultList.get(position).getReleaseDate());
        Glide.with(context).load("https://image.tmdb.org/t/p/w185" + resultList.get(position).
                getPosterPath()).into(holder.imgPoster);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvDescription, tvReleaseDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.imgFilm);
            tvTitle = itemView.findViewById(R.id.tvJudul);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);

        }
    }
}

