package com.tana.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecentlyNewsAdapter extends RecyclerView.Adapter<RecentlyNewsAdapter.RecentlyNewsViewHolder> {
    private final Context mContext;
    private final ArrayList<News> mNewsList;

    public RecentlyNewsAdapter(Context context, ArrayList<News> newsList) {
        mContext = context;
        mNewsList = newsList;
    }

    @NonNull
    @Override
    public RecentlyNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(mContext).inflate(R.layout.news_items, parent, false);
        return new RecentlyNewsViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyNewsViewHolder holder, int position) {
        News newsList = mNewsList.get(position);
        holder.mNewsImage.setImageResource(newsList.getNewsImg());
        holder.mNewsHeader.setText(newsList.getNewsHeader());
        holder.mNewsDate.setText(newsList.getDate());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public static class RecentlyNewsViewHolder extends RecyclerView.ViewHolder {

        public final ImageView mNewsImage;
        public final TextView mNewsHeader;
        public final TextView mNewsDate;

        public RecentlyNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mNewsImage = (ImageView) itemView.findViewById(R.id.news_image);
            mNewsHeader = (TextView) itemView.findViewById(R.id.header);
            mNewsDate = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
