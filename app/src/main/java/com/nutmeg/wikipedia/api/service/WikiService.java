package com.nutmeg.wikipedia.api.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nutmeg.wikipedia.api.service.deserialiser.ImageResultDeserialiser;
import com.nutmeg.wikipedia.api.service.model.image.ImageResult;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WikiService {

    public static final String BASE_URL = "https://en.wikipedia.org/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(ImageResult.class, new ImageResultDeserialiser())
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
