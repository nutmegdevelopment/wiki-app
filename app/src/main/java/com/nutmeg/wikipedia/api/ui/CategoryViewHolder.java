package com.nutmeg.wikipedia.api.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.api.service.model.image.ImageResult;
import com.nutmeg.wikipedia.api.service.model.image.Thumbnail;
import com.nutmeg.wikipedia.api.service.model.page.CategoryMember;
import com.squareup.picasso.Picasso;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private Context context;
    private final TextView textView;
    private final ImageView categoryImageView;


    public CategoryViewHolder(Context context,
                              View itemView) {
        super(itemView);
        this.context = context;
        textView = (TextView) itemView.findViewById(R.id.item_name);
        categoryImageView = (ImageView) itemView.findViewById(R.id.category_image);
    }


    public void setCategoryMember(CategoryMember categoryMember,
                                  ImageResult imageResult) {
        textView.setText(categoryMember.getTitle());
        Thumbnail thumbnail = imageResult.getThumbnail();
        if(thumbnail != null) {
            Picasso.with(context)
                    .load(thumbnail.getSource())
                    .into(categoryImageView);
        }
    }

}
