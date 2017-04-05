package com.nutmeg.wikipedia.api.service;

import com.nutmeg.wikipedia.api.service.model.image.ImageResult;
import com.nutmeg.wikipedia.api.service.model.page.PageResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WikiClient {

    @GET("/w/api.php")
    Observable<PageResult> getPage(@Query("action") String action,
                                   @Query("list") String list,
                                   @Query("cmtitle") String cmtitle,
                                   @Query("format") String format,
                                   @Query("continue") String continueString);

    @GET("/w/api.php")
    Observable<ImageResult> getImage(@Query("action") String action,
                                     @Query("pageids") Integer pageId,
                                     @Query("prop") String prop,
                                     @Query("format") String format,
                                     @Query("pithumbsize") Integer pictureSize,
                                     @Query("continue") String continueString);


}
