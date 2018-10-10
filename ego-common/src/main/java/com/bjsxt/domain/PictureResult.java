package com.bjsxt.domain;

import java.io.Serializable;

public class PictureResult implements Serializable {

    private String url;
    private Integer error;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}
