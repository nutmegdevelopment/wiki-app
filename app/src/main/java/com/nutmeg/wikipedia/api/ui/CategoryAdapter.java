package com.nutmeg.wikipedia.api.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.api.service.model.image.ImageResult;
import com.nutmeg.wikipedia.api.service.model.page.CategoryMember;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>
        implements CategoryFragment.Listener {

    private final List<CategoryMember> categoryMembers;
    private final List<ImageResult> imageResults;

    public CategoryAdapter() {
        categoryMembers = new ArrayList<>();
        imageResults = new ArrayList<>();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //Inflate the Custom Layout
        View itemView = inflater.inflate(R.layout.item_category, parent, false);

        //Return a new holder instance
        return new CategoryViewHolder(context, itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder categoryViewHolder, int position) {
        CategoryMember categoryMember = categoryMembers.get(position);
        ImageResult imageResult = imageResults.get(position);
        categoryViewHolder.setCategoryMember(categoryMember, imageResult);
    }

    @Override
    public int getItemCount() {
        return categoryMembers.size();
    }

    @Override
    public void onResultsAvailable(List<CategoryMember> categoryMembers,
                                   List<ImageResult> resultList) {
        imageResults.clear();
        imageResults.addAll(resultList);
        this.categoryMembers.clear();
        this.categoryMembers.addAll(categoryMembers);
        notifyDataSetChanged();
    }
}





