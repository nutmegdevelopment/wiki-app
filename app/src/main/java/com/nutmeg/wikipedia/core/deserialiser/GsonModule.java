package com.nutmeg.wikipedia.core.deserialiser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nutmeg.wikipedia.core.api.model.image.ImageResult;
import com.nutmeg.wikipedia.injection.scopes.FragmentScope;

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
    public ImageResultDeserialiser provideImageResultDeserialiser() {
        return new ImageResultDeserialiser();
    }

    @Provides
    @Singleton
    public Gson provideGson(ImageResultDeserialiser imageResultDeserialiser) {
        return new GsonBuilder()
                .registerTypeAdapter(ImageResult.class, imageResultDeserialiser)
                .create();
    }
}
