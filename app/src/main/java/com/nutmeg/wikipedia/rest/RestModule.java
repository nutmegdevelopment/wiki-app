package com.nutmeg.wikipedia.rest;

import com.google.gson.Gson;
import com.nutmeg.wikipedia.deserialiser.GsonModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aburaihan on 19/04/2017.
 */

@Module(includes = GsonModule.class)
public class RestModule {
    private static final String BASE_URL = "https://en.wikipedia.org/";

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
