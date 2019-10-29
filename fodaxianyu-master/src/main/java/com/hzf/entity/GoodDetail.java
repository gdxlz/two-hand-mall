package com.hzf.entity;

import java.util.List;
//商品详情：商品，图片列表，用户名和用户ID
public class GoodDetail {
    private Good good;
    private List<Pictures> picturesList;
    private String userName;
    private int uid;

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public List<Pictures> getPicturesList() {
        return picturesList;
    }

    public void setPicturesList(List<Pictures> picturesList) {
        this.picturesList = picturesList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "GoodDetail{" +
                "good=" + good +
                ", picturesList=" + picturesList +
                ", userName='" + userName + '\'' +
                ", uid=" + uid +
                '}';
    }
}
