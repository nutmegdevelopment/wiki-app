package com.nutmeg.wikipedia.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by aburaihan on 19/04/2017.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor) {
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient.Builder httpClientBuilder = okHttpClient.newBuilder();
        httpClientBuilder.addInterceptor(interceptor);
        return okHttpClient;
    }

}
