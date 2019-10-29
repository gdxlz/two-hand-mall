package com.hzf.entity;

public class Good {
    private Integer goodId;

    private String goodName;

    private Integer userId;

    private Float price;

    private String description;

    private String catelog;

    private Integer status;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCatelog() {
        return catelog;
    }

    public void setCatelog(String catelog) {
        this.catelog = catelog == null ? null : catelog.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", userId=" + userId +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", catelog='" + catelog + '\'' +
                ", status=" + status +
                '}';
    }
}