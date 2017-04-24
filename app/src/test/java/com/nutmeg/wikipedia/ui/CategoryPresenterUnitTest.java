package com.nutmeg.wikipedia.ui;

import android.content.Context;

import com.google.gson.Gson;
import com.nutmeg.wikipedia.R;
import com.nutmeg.wikipedia.core.api.WikiClient;
import com.nutmeg.wikipedia.core.api.model.page.CategoryMember;
import com.nutmeg.wikipedia.core.api.model.page.PageResult;
import com.nutmeg.wikipedia.core.deserialiser.GsonModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;

import static io.reactivex.Observable.just;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryPresenterUnitTest {

    private WikiClient mockWikiClient;
    private Context mockContext;

    private CategoryPresenter target;

    @Before
    public void setUp() throws Exception {
        mockWikiClient = mock(WikiClient.class);
        mockContext = mock(Context.class);

        target = new CategoryPresenter(mockWikiClient, mockContext);
    }

    @Test
    public void testGetCategoryMemberObservable() throws Exception {
        String category = "category";
        String apiAction = "api_action";
        String apiPageList = "apiPageList";
        String apiFormat = "apiFormat";
        Observable mockObservable = mock(Observable.class);

        when(mockContext.getString(eq(R.string.api_action))).thenReturn(apiAction);
        when(mockContext.getString(eq(R.string.api_page_list))).thenReturn(apiPageList);
        when(mockContext.getString(eq(R.string.api_format))).thenReturn(apiFormat);

        when(mockWikiClient.getPage(
                eq(apiAction),
                eq(apiPageList),
                eq(category),
                eq(apiFormat),
                eq(null)
        )).thenReturn(mockObservable);

        target.getCategoryMemberObservable(category);

        verify(mockWikiClient).getPage(
                eq(apiAction),
                eq(apiPageList),
                eq(category),
                eq(apiFormat),
                eq(null)
        );
    }

    @Test
    public void getThumbnailUrl() throws Exception {

    }

    @Test
    public void getImageObservable() throws Exception {

    }

    @Test
    public void loadImageResults() throws Exception {

    }

    @Test
    public void setContext() throws Exception {

    }

    private PageResult convertObject(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, PageResult.class);

    }

}