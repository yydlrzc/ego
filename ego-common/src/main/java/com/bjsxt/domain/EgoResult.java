package com.bjsxt.domain;

import java.io.Serializable;

/**
 * 封装返回结果的类
 * @author ASUS
 */
public class EgoResult implements Serializable {

    private Integer status = 200;
    private Object data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static EgoResult ok() {
        return new EgoResult();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
