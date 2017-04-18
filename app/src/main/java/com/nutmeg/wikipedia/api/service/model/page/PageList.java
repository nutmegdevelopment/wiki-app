package com.nutmeg.wikipedia.api.service.model.page;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PageList {

    @SerializedName("categorymembers")
    private List<CategoryMember> categorymembers;

    public List<CategoryMember> getCategorymembers() {
        return categorymembers;
    }

    public void setCategorymembers(List<CategoryMember> categorymembers) {
        this.categorymembers = categorymembers;
    }

    @Override
    public String toString() {
        return "PageList{" +
                "categorymembers=" + categorymembers +
                '}';
    }
}