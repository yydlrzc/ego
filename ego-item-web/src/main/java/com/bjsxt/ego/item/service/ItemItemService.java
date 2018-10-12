package com.bjsxt.ego.item.service;

import com.bjsxt.ego.pojo.TbItem;
import com.bjsxt.ego.pojo.TbItemParamItem;

public interface ItemItemService {

    /**
     * 加载某个id的商品信息
     * @param itemId
     * @return
     */
    public TbItem loadItemService(Long itemId);

    /**
     * 加载某个id的商品规格参数
     * @param itemId
     * @return
     */
    public String loadItemParamItemService(Long id);

    /**
     * 加载商品的描述
     * @param itemId
     * @return
     */
    public String loadItemDescService(Long itemId);
}
