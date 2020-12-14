package com.tana.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tana.newsapp.model.RecentlyHeadlines;

import java.util.ArrayList;
import java.util.List;

public class RecentlyNewsAdapter extends RecyclerView.Adapter<RecentlyNewsAdapter.RecentlyNewsViewHolder> {
    private final Context mContext;
    private final List<RecentlyHeadlines> mHeadlines;

    public RecentlyNewsAdapter(Context context, List<RecentlyHeadlines> newsList) {
        mContext = context;
        mHeadlines = newsList;
    }

    @NonNull
    @Override
    public RecentlyNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(mContext).inflate(R.layout.news_items, parent, false);
        return new RecentlyNewsViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyNewsViewHolder holder, int position) {
        RecentlyHeadlines newsList = mHeadlines.get(position);
        Glide.with(mContext).load(newsList.getUrlToImage())
                .into(holder.mNewsImage);
        holder.mNewsHeader.setText(newsList.getTitle());
        holder.mDescription.setText(newsList.getDescription());
        holder.mAuthor.setText(newsList.getAuthor());
        holder.mNewsDate.setText(newsList.getPublishedAt());
        holder.mAdapterParent.setTag(newsList);
        holder.mWebUrl = newsList.getUrl();
    }

    @Override
    public int getItemCount() {
        return (mHeadlines == null) ? 0 : mHeadlines.size();
    }

    public static class RecentlyNewsViewHolder extends RecyclerView.ViewHolder {


        public final ImageView mNewsImage;
        public final TextView mNewsHeader, mDescription, mAuthor, mNewsDate;
        ConstraintLayout mAdapterParent;
        public String mWebUrl;

        public RecentlyNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mNewsImage = (ImageView) itemView.findViewById(R.id.news_image);
            mNewsHeader = (TextView) itemView.findViewById(R.id.header);
            mDescription = (TextView) itemView.findViewById(R.id.description);
            mAuthor = (TextView) itemView.findViewById(R.id.author);
            mNewsDate = (TextView) itemView.findViewById(R.id.date);
            mAdapterParent = itemView.findViewById(R.id.adapter_parent);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent webIntent = new Intent(itemView.getContext(), WebActivity.class);
                    webIntent.putExtra("url", mWebUrl);
                    itemView.getContext().startActivity(webIntent);
                }
            });
        }
    }
}