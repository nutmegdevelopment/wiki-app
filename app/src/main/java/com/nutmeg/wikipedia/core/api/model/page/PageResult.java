package com.nutmeg.wikipedia.core.api.model.page;


import com.google.gson.annotations.SerializedName;

public class PageResult {

    @SerializedName("query")
    private PageList pageList;

    public void setPageList(PageList pageList) {
        this.pageList = pageList;
    }

    public PageList getPageList() {
        return pageList;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageList=" + pageList +
                '}';
    }

}
