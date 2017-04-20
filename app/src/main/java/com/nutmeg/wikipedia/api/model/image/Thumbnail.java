package com.nutmeg.wikipedia.api.model.image;

public class Thumbnail {
    private String source;
    private int width;
    private int height;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Thumbnail{" +
                "source='" + source + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
