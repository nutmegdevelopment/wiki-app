package com.nutmeg.wikipedia.ui;

import com.nutmeg.wikipedia.api.ApiModule;
import com.nutmeg.wikipedia.api.WikiClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aburaihan on 20/04/2017.
 */

@Module(includes = ApiModule.class)
public class PresenterModule {
    @Provides
    CategoryPresenter providePresenter(WikiClient client, CategoryFragment fragment){
        return new CategoryPresenter(client);
    }
}
