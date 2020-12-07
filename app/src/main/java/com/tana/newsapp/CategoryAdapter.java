package com.tana.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final Context mContext;
    private final ArrayList<News> mNewsList;

    public CategoryAdapter(Context context, ArrayList<News> newsList) {
        mContext = context;
        mNewsList = newsList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.news_category_items, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        News newsCat = mNewsList.get(position);
        holder.mCatImage.setImageResource(newsCat.getCatImg());
        holder.mCatTitle.setText(newsCat.getCatTitle());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView mCatImage;
        public TextView mCatTitle;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mCatImage = (ImageView) itemView.findViewById(R.id.cat_image);
            mCatTitle = (TextView) itemView.findViewById(R.id.cat_title);
        }
    }
}
