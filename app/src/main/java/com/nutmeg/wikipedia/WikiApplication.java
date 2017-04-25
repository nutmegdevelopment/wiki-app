package com.nutmeg.wikipedia;

import android.app.Application;

import com.nutmeg.wikipedia.core.CoreComponent;
import com.nutmeg.wikipedia.core.DaggerCoreComponent;
import com.nutmeg.wikipedia.injection.ApplicationComponent;
import com.nutmeg.wikipedia.injection.DaggerApplicationComponent;

/**
 * Created by aburaihan on 20/04/2017.
 */

public class WikiApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        CoreComponent coreComponent = DaggerCoreComponent.builder()
//                .apiModule(new ApiModule())
//                .gsonModule(new GsonModule())
//                .restModule(new RestModule())
                .build();

        applicationComponent = DaggerApplicationComponent.builder()
                .coreComponent(coreComponent)
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
