package com.nutmeg.wikipedia.api;

import com.nutmeg.wikipedia.rest.RestModule;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = RestModule.class)
public class ApiModule {

    @Provides
    public WikiClient provideWikiClient(Retrofit retrofit){
        return retrofit.create(WikiClient.class);
    }
}
