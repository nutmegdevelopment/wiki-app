package com.nutmeg.wikipedia.api.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.api.service.model.page.CategoryMember;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    // Store a member variable for the contacts
    private List<CategoryMember> categoryMembers;

    // Store the context for easy access

    public CategoryAdapter(List<CategoryMember> categoryMembers) {
        this.categoryMembers = categoryMembers;
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
        categoryViewHolder.setCategoryMember(categoryMember);
    }

    @Override
    public int getItemCount() {
        return categoryMembers.size();
    }
}
