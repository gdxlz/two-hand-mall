package com.hzf.entity;

public class Pictures {
    private Integer pictureId;

    private Integer goodId;

    private String pictureUrl;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "pictureId=" + pictureId +
                ", goodId=" + goodId +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}