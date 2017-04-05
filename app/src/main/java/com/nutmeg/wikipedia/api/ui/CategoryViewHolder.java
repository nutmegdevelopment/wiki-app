package com.nutmeg.wikipedia.api.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.api.service.model.page.CategoryMember;
import com.squareup.picasso.Picasso;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = CategoryViewHolder.class.getSimpleName();

    private Context context;
    private final TextView textView;
    private final ImageView categoryImageView;

    public CategoryViewHolder(Context context,
                              View itemView) {
        super(itemView);
        this.context = context;
        textView = (TextView) itemView.findViewById(R.id.item_name);
        categoryImageView = (ImageView) itemView.findViewById(R.id.category_image);

        /*Map<String, String> image = new HashMap<>();
        //?action=query&pageids=10843&prop=pageimages&format=json&pithumbsize=100
        image.put("action", "query");
        image.put("pageids", "10843");
        image.put("prop", "pageimages");
        image.put("format", "json");
        image.put("pithumbsize", "100");

        WikiClient imageClient = WikiService.getClient().create(WikiClient.class);

        Observable<ImageResult> observable1 = imageClient.getImage(
                context.getString(R.string.api_action),
                context.getString(R.integer.thumbnail_size),
                context.getString(R.string.api_image_prop),
                context.getString(R.string.api_format),
                context.getString(R.string.api_image_pithumbsize),
                null
        );

        observable1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> response.getThumbnail())
                 .map(s -> s.getSource())
               .subscribe(
                       Thumbnail  -> Log.d(TAG, Thumbnail.toString()),
                       error -> Log.e(TAG, "An error occurred", error)

                );*/
    }




    public void setCategoryMember(CategoryMember categoryMember) {
        textView.setText(categoryMember.getTitle());

        Picasso.with(context)
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Culinary_fruits_front_view.jpg/100px-Culinary_fruits_front_view.jpg")
                .into(categoryImageView);
    }
}
