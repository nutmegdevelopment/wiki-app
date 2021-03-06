package com.nutmeg.wikipedia.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.WikiApplication;
import com.nutmeg.wikipedia.core.api.model.image.ImageResult;
import com.nutmeg.wikipedia.core.api.model.page.CategoryMember;
import com.nutmeg.wikipedia.injection.ApplicationComponent;

import java.util.List;

import javax.inject.Inject;

public class CategoryFragment extends Fragment {

    private final static String CATEGORY_KEY = "CATEGORY_KEY";

    @Inject
    CategoryPresenter presenter;

    private String category;

    public static CategoryFragment newInstance(String category) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_KEY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = savedInstanceState == null ? getArguments() : savedInstanceState;
        category = bundle.getString(CATEGORY_KEY);

        CategoryAdapter adapter = new CategoryAdapter();

        presenter.loadImageResults(category, adapter);
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //save the category
        outState.putString(CATEGORY_KEY, category);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        inject(context);
        category = context.getString(R.string.api_fruit_page_cmtitle);
    }

    private void inject(Context context) {
        ApplicationComponent applicationComponent = WikiApplication.getApplicationComponent();

        CategoryComponent categoryComponent = DaggerCategoryComponent
                .builder()
                .applicationComponent(applicationComponent)
                .categoryModule(new CategoryModule(context))
                .build();

        categoryComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, parent, false);

    }

    public interface Listener {
        void onResultsAvailable(List<CategoryMember> categoryMembers, List<ImageResult> resultList);
    }
}
