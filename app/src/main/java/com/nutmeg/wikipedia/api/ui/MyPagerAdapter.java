package com.nutmeg.wikipedia.api.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final List<Provider<CategoryFragment>> providerList;

    public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
        providerList = new ArrayList<>();
        providerList.add(() -> CategoryFragment.newInstance(0, "Fruits"));
        providerList.add(() -> CategoryFragment.newInstance(1, "Vegetables"));
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return providerList.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return providerList.get(position).provide();
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) this.getItem(position).getArguments().get("someTitle");
    }

    private interface Provider<T> {
        T provide();
    }
}

