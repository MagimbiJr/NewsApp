package com.tana.newsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {
    RecyclerView mCategoryList;
    GridLayoutManager mLayoutManager;
    CategoryAdapter mAdapter;
    ArrayList<News> mNewsList;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNewsList = new ArrayList<>();
        mNewsList.add(new News("News & Politics", R.drawable.ic_drive_file));
        mNewsList.add(new News("Sport", R.drawable.ic_sports_handball));
        mNewsList.add(new News("Travel", R.drawable.ic_local_shipping));
        mNewsList.add(new News("Health", R.drawable.ic_medical_services));
        mNewsList.add(new News("Technology", R.drawable.ic_computer));
        mNewsList.add(new News("Business", R.drawable.ic_business_center));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCategoryList = view.findViewById(R.id.category_list);
        mLayoutManager = new GridLayoutManager(getContext(), 2);
        mAdapter = new CategoryAdapter(getContext(), mNewsList);

        mCategoryList.setLayoutManager(mLayoutManager);
        mCategoryList.setAdapter(mAdapter);
    }
}