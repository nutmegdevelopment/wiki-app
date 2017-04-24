package com.nutmeg.wikipedia.core.api.model.page;

import com.google.gson.annotations.SerializedName;

public class CategoryMember {

    private String title;

    @SerializedName("pageid")
    private Integer pageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    @Override
    public String toString() {
        return "CategoryMember{" +
                "title='" + title + '\'' +
                ", pageId='" + pageId + '\'' +
                '}';
    }


}

