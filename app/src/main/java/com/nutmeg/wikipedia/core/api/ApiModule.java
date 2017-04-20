package com.nutmeg.wikipedia.core.api;

import com.nutmeg.wikipedia.core.rest.RestModule;
import com.nutmeg.wikipedia.injection.scopes.FragmentScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = RestModule.class)
public class ApiModule {

    @Provides
    @Singleton
    public WikiClient provideWikiClient(Retrofit retrofit){
        return retrofit.create(WikiClient.class);
    }
}
