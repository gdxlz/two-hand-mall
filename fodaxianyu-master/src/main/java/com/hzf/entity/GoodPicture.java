package com.hzf.entity;

import java.util.List;

public class GoodPicture extends Good {
//    图片id
    Integer pictureId;
//    图片对应的商品的id
    Integer pictureGoodId;
    String pictureUrl;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getPictureGoodId() {
        return pictureGoodId;
    }

    public void setPictureGoodId(Integer pictureGoodId) {
        this.pictureGoodId = pictureGoodId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        //        先打印父类的属性，在打印子类的属性
        return super.toString()+"       GoodPicture{" +
                "pictureId=" + pictureId +
                ", pictureGoodId=" + pictureGoodId +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
