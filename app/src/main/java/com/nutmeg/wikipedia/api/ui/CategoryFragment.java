package com.nutmeg.wikipedia.api.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.api.service.model.page.CategoryMember;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    //store some instance variables
    private String title;
    private int page;
    private List<CategoryMember> categoryMembers;
    private String category;

    public static CategoryFragment newInstance(int page, String title) {
        CategoryFragment fragmentOne = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentOne.setArguments(args);
        return fragmentOne;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle", null);
        categoryMembers = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CategoryAdapter adapter = new CategoryAdapter(categoryMembers);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
    }
}
