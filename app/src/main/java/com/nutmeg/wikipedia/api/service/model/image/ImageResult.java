package com.nutmeg.wikipedia.api.service.model.image;

public class ImageResult {
    private Integer pageid;
    private String title;
    private Thumbnail thumbnail;

    public Integer getPageId() {
        return pageid;
    }

    public void setPageId(Integer pageid) {
        this.pageid = pageid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "ImageResult{" +
                "pageid=" + pageid +
                ", title='" + title + '\'' +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
