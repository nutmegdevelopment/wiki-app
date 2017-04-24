package com.nutmeg.wikipedia.ui;

import android.content.Context;

import com.nutmeg.wikipedia.core.api.ApiModule;
import com.nutmeg.wikipedia.core.api.WikiClient;
import com.nutmeg.wikipedia.injection.scopes.FragmentScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class CategoryModule {

    private final Context context;

    public CategoryModule(Context context) {
        this.context = context;
    }

    @Provides
    @FragmentScope
    CategoryPresenter providePresenter(WikiClient client){
        return new CategoryPresenter(client, context);
    }
}
