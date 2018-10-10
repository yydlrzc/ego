package com.bjsxt.ego.manager.service;

import com.bjsxt.domain.TreeResult;

import java.util.List;

/**
 * @author ASUS
 */
public interface ManagerItemCatService {

    /**
     * 加载商品类目
     * @param pid
     * @return
     */
    public List<TreeResult> loadItemCatService(Long pid);
}
