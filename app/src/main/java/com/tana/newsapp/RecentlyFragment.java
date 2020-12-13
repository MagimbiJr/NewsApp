package com.tana.newsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tana.newsapp.model.RecentlyHeadlines;
import com.tana.newsapp.model.ResponseModal;
import com.tana.newsapp.services.NewsService;
import com.tana.newsapp.services.ServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecentlyFragment extends Fragment {
    private static final String API_KEY = "bc819b34e3c744f286872377f249fa7c";
    private static final String LOG = "RecentlyFragment";
    RecyclerView mRecentlyNewsList;
    RecentlyNewsAdapter mNewsAdapter;
    LinearLayoutManager mLayoutManager;
    List<RecentlyHeadlines> mHeadlines;

    public RecentlyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recently, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecentlyNewsList = view.findViewById(R.id.news_list);
        mLayoutManager = new LinearLayoutManager(getContext());

        mRecentlyNewsList.setLayoutManager(mLayoutManager);

        NewsService newsService = ServiceBuilder.getClient().create(NewsService.class);
        Call<ResponseModal> call = newsService.geHeadlines("techcrunch", API_KEY);
        call.enqueue(new Callback<ResponseModal>() {
            @Override
            public void onResponse(Call<ResponseModal> call, Response<ResponseModal> response) {
                if (response.body().getStatus().equals("ok")) {
                    mHeadlines = response.body().getArticles();

                    if (mHeadlines.size() > 0) {
                        mNewsAdapter = new RecentlyNewsAdapter(getContext(), mHeadlines);
                        mRecentlyNewsList.setAdapter(mNewsAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseModal> call, Throwable t) {
                Log.d(LOG, "Output: " + t.getMessage());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}