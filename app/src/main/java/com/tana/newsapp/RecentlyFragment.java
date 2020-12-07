package com.tana.newsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecentlyFragment extends Fragment {
    RecyclerView mRecentlyNewsList;
    LinearLayoutManager mLayoutManager;
    RecentlyNewsAdapter mNewsAdapter;
    ArrayList<News> mNewsList;

    public RecentlyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNewsList = new ArrayList<>();
        mNewsList.add(new News("Gauteng Premier David Makhura reshuffles his executive, Parks Tau returns as MEC",
                "02 Des 2020", R.drawable.david_makhura));
        mNewsList.add(new News("Court dismisses bid by SABC union to halt retrenchment process",
                "02 Des 2020", R.drawable.sabc));
        mNewsList.add(new News("A 22:00 curfew for SA's Covid-19 hotspots and new booze restrictions, NCCC recommends",
                "02 Des 2020", R.drawable.ramaphosa));
        mNewsList.add(new News("Former JSE CEO calls for boycotting of corrupt companies",
                "02 Des 2020", R.drawable.jce_ceo));
        mNewsList.add(new News("United Airlines won't do seasonal direct flights to Cape Town this year",
                "02 Des 2020", R.drawable.united_airlines));
        mNewsList.add(new News("Huawei Pay launches in SA – here’s how it compares to Samsung’s mobile payment system",
                "02 Des 2020", R.drawable.huawei));
        mNewsList.add(new News("Kane says Premier League players should keep taking the knee in racism fight",
                "02 Des 2020", R.drawable.kane));
        mNewsList.add(new News("Messi rested for Barca trip to Hungary", "02 Des 2020", R.drawable.messi));
        mNewsList.add(new News("Wayne Rooney awaiting decision on managerial future", "01 Des 2020", R.drawable.rooney));
        mNewsList.add(new News("Tuchel aware of threat from Rashford and Cavani", "01 Des 2020", R.drawable.rashford));
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
        mNewsAdapter = new RecentlyNewsAdapter(getContext(), mNewsList);

        mRecentlyNewsList.setLayoutManager(mLayoutManager);
        mRecentlyNewsList.setAdapter(mNewsAdapter);
    }
}