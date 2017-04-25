package com.nutmeg.wikipedia.ui;

import android.widget.ImageView;

import com.nutmeg.wikipedia.BuildConfig;
import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.core.api.model.image.ImageResult;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(CustomRobolectricTestRunner.class)
@Config(constants = BuildConfig.class,
        sdk = 21)
public class CategoryPresenterIntegrationTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldHaveDefaultMargin() throws Exception {
        ArrayList<ImageResult> imageResultArrayList = new ArrayList<>();
        for (int i = 0; i < imageResultArrayList.size(); i++) {
            System.out.println("The value of the Image result" + imageResultArrayList);
        }
        ImageView imageView = (ImageView) mainActivity.findViewById(R.id.category_image);
        System.out.printf("The value of the Image View is" + imageView);
    }

    @Test
    public void shouldHaveCorrectAppName() throws Exception {
        String expectedName = mainActivity.getResources().getString(R.string.app_name);
        assertThat(expectedName, equalTo("wiki-app"));
    }

}