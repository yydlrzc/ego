package com.bjsxt.ego.search.pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

public class Item implements Serializable {

    @Field(value = "id")
    private String id;
    @Field(value = "product_name")
    private String title;
    @Field(value = "sell_point")
    private String sell_point;
    @Field(value = "product_price")
    private Double price;
    @Field(value = "picture")
    private String image;
    @Field(value = "catalog_name")
    private String catalog_name;
    @Field(value = "catalog")
    private Integer catalog;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSell_point() {
        return sell_point;
    }

    public void setSell_point(String sell_point) {
        this.sell_point = sell_point;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    public Integer getCatalog() {
        return catalog;
    }

    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }

    public String[] getImages() {
        return image.split(",");
    }
}
