package com.nutmeg.wikipedia.api.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.api.service.WikiClient;
import com.nutmeg.wikipedia.api.service.WikiService;
import com.nutmeg.wikipedia.api.service.model.image.ImageResult;
import com.nutmeg.wikipedia.api.service.model.image.Thumbnail;
import com.nutmeg.wikipedia.api.service.model.page.CategoryMember;
import com.nutmeg.wikipedia.api.service.model.page.PageList;
import com.nutmeg.wikipedia.api.service.model.page.PageResult;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private final WikiClient client = WikiService.getClient().create(WikiClient.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();

        getCategoryMemberObservable()
                .subscribe(
                        categoryMember -> Log.d(TAG, categoryMember.toString()),
                        error -> Log.e(TAG, "An error occurred", error)
                );

        int pageId = 10843;

        getImageObservable(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> Log.d(TAG, result.toString())
                );
    }

    private void initViewPager() {
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    private Observable<CategoryMember> getCategoryMemberObservable() {
        return getPageResultObservable()
                .map(PageResult::getPageList)
                .map(PageList::getCategorymembers)
                .flatMap(Observable::fromIterable);
    }

    private Observable<String> getThumbnailUrl(int pageId) {
        return getImageObservable(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(ImageResult::getThumbnail)
                .map(Thumbnail::getSource);
    }

    private Observable<PageResult> getPageResultObservable() {
        return client.getPage(
                getString(R.string.api_action),
                getString(R.string.api_page_list),
                getString(R.string.api_fruit_page_cmtitle),
                getString(R.string.api_format),
                null
        );
    }

    private Observable<ImageResult> getImageObservable(int pageId) {
        return client.getImage(
                getString(R.string.api_action),
                pageId,
                getString(R.string.api_image_prop),
                getString(R.string.api_format),
                getResources().getInteger(R.integer.thumbnail_size),
                null
        );
    }

}



