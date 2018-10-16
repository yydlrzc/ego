package com.bjsxt.ego.search.service;


import com.bjsxt.ego.search.pojo.SearchResult;

public interface ItemService {

    public SearchResult loadItemService(String q, Integer page);
}
