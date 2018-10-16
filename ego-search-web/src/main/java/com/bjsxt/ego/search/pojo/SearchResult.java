package com.bjsxt.ego.search.pojo;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable {

    private List<Item> list;

    private Long totalPages;

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
}
