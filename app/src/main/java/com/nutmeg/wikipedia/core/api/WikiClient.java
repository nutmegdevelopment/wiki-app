package com.nutmeg.wikipedia.core.api;

import com.nutmeg.wikipedia.core.api.model.image.ImageResult;
import com.nutmeg.wikipedia.core.api.model.page.PageResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WikiClient {

    @GET("/w/api.php")
    public Observable<PageResult> getPage(@Query("action") String action,
                                          @Query("list") String list,
                                          @Query("cmtitle") String cmtitle,
                                          @Query("format") String format,
                                          @Query("continue") String continueString);

    @GET("/w/api.php")
    public Observable<ImageResult> getImage(@Query("action") String action,
                                            @Query("pageids") Integer pageId,
                                            @Query("prop") String prop,
                                            @Query("format") String format,
                                            @Query("pithumbsize") Integer pictureSize,
                                            @Query("continue") String continueString);


}
