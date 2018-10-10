package com.bjsxt.ego.rpc.service;

import com.bjsxt.ego.pojo.TbItemCat;

import java.util.List;

/**
 * @author ASUS
 */
public interface TbItemCatService {

    /**
     * 加载商品类目
     * @param pid
     * @return
     */
    public List<TbItemCat> loadTbItemCatList(Long pid);

    /**
     * 主页加载所有商品类目
     * @return
     */
    public List<TbItemCat> loadTbItemCatAllList();

}
