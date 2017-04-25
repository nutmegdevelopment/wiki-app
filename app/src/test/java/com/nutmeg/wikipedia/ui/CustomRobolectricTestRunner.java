package com.nutmeg.wikipedia.ui;

import android.app.Application;

import com.nutmeg.wikipedia.BuildConfig;
import com.nutmeg.wikipedia.WikiApplication;

import org.junit.runners.model.InitializationError;
import org.robolectric.DefaultTestLifecycle;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.TestLifecycle;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;

import java.lang.reflect.Method;

public class CustomRobolectricTestRunner extends RobolectricTestRunner {

    public CustomRobolectricTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);

        System.setProperty("android.package", BuildConfig.APPLICATION_ID);
        String folder = BuildConfig.FLAVOR + "/" + BuildConfig.BUILD_TYPE;
        System.setProperty("android.manifest",
                "build/intermediates/manifests/full/" + folder + "/AndroidManifest.xml"
        );
        System.setProperty("android.resources",
                "build/intermediates/res/merged/" + folder
        );
        System.setProperty("android.assets", "build/intermediates/assets/" + folder);
    }
    @Override
    protected Class<? extends TestLifecycle> getTestLifecycleClass() {
        return CustomTestLifecycle.class;
    }

    private class CustomTestLifecycle extends DefaultTestLifecycle {
        @Override
        public Application createApplication(final Method method,
                                             final AndroidManifest appManifest,
                                             final Config appConfig) {
            return new WikiApplication();
        }
    }
}
