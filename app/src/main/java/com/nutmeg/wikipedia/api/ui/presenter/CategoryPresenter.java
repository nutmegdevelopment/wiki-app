package com.nutmeg.wikipedia.api.ui.presenter;

import android.content.Context;
import android.util.Log;

import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.api.service.WikiClient;
import com.nutmeg.wikipedia.api.service.WikiService;
import com.nutmeg.wikipedia.api.service.model.image.ImageResult;
import com.nutmeg.wikipedia.api.service.model.image.Thumbnail;
import com.nutmeg.wikipedia.api.service.model.page.CategoryMember;
import com.nutmeg.wikipedia.api.service.model.page.PageList;
import com.nutmeg.wikipedia.api.service.model.page.PageResult;
import com.nutmeg.wikipedia.api.ui.CategoryFragment;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class CategoryPresenter {

    private final WikiClient client;
    private final CategoryFragment fragment;
    private Context context;

    public CategoryPresenter(CategoryFragment fragment) {
        this.fragment = fragment;
        client = WikiService.getClient().create(WikiClient.class);
    }

    public Observable<CategoryMember> getCategoryMemberObservable(String category) {
        return getPageResultObservable(category)
                .map(PageResult::getPageList)
                .map(PageList::getCategorymembers)
                .flatMap(Observable::fromIterable);
    }

    public Observable<String> getThumbnailUrl(int pageId) {
        return getImageObservable(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(ImageResult::getThumbnail)
                .map(Thumbnail::getSource);
    }

    private Observable<PageResult> getPageResultObservable(String category) {
        return client.getPage(
                context.getString(R.string.api_action),
                context.getString(R.string.api_page_list),
                category,
                context.getString(R.string.api_format),
                null
        );
    }

    public Observable<ImageResult> getImageObservable(int pageId) {
        return client.getImage(
                context.getString(R.string.api_action),
                pageId,
                context.getString(R.string.api_image_prop),
                context.getString(R.string.api_format),
                context.getResources().getInteger(R.integer.thumbnail_size),
                null
        );
    }

    public void loadImageResults(String category,
                                 CategoryFragment.Listener resultListener) {
        getCategoryMemberObservable(category)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        members -> onMembersAvailable(members, resultListener),
                        error -> Log.e(TAG, "An error occurred", error)
                );
    }

    private void onMembersAvailable(List<CategoryMember> categoryMembers,
                                    CategoryFragment.Listener resultListener) {
        Observable.fromIterable(categoryMembers)
                .map(CategoryMember::getPageId)
                .flatMap(this::getImageObservable)
                .doOnNext(imageResult -> {
                    Log.d(TAG, imageResult + "");
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        imageResults -> {
                            Log.d(TAG, imageResults.toString());
                            resultListener.onResultsAvailable(categoryMembers, imageResults);
                        },
                        error -> Log.e(TAG, "An error occurred", error)
                );
    }

    public void setContext(Context context) {
        this.context = context;
    }
}