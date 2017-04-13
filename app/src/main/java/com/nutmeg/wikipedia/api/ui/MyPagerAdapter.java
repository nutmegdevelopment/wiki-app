package com.nutmeg.wikipedia.api.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.Pair;

import com.nutmeg.wikipedia.R;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final List<Provider<Pair<CategoryFragment, String>>> providerList;

    public MyPagerAdapter(FragmentManager fragmentManager,
                          Context context) {
        super(fragmentManager);
        providerList = new ArrayList<>();
        providerList.add(new Provider<Pair<CategoryFragment, String>>() {
            @Override
            public Pair<CategoryFragment, String> provide() {
                CategoryFragment fragment = CategoryFragment.newInstance(context.getString(R.string.api_fruit_page_cmtitle));
                String title = "Fruits";
                return new Pair<>(fragment, title);
            }
        });

        providerList.add(new Provider<Pair<CategoryFragment, String>>() {
            @Override
            public Pair<CategoryFragment, String> provide() {
                return new Pair<>(CategoryFragment.newInstance(context.getString(R.string.api_vegetable_cmtitle)), "Vegetables");
            }
        });
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return providerList.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return providerList.get(position).provide().first;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return providerList.get(position).provide().second;
    }

    private interface Provider<T> {
        T provide();
    }
}

