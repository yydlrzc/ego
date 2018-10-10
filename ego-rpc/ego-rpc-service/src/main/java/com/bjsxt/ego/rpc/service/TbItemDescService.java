package com.bjsxt.ego.rpc.service;

import com.bjsxt.ego.pojo.TbItemDesc;

/**
 * @author ASUS
 */
public interface TbItemDescService {

    /**
     * 加载商品详情
     * @param id
     * @return
     */
    public TbItemDesc loadTbItemDesc(Long id);
}
