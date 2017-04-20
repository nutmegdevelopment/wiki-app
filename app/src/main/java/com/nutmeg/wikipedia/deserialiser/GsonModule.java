package com.nutmeg.wikipedia.deserialiser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nutmeg.wikipedia.api.model.image.ImageResult;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aburaihan on 19/04/2017.
 */

@Module
public class GsonModule {
    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapter(ImageResult.class, new ImageResultDeserialiser())
                .create();
    }
}
