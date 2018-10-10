package com.bjsxt.ego.rpc.service;

import com.bjsxt.domain.PageResult;
import com.bjsxt.domain.EgoResult;
import com.bjsxt.ego.pojo.TbItem;
import com.bjsxt.ego.pojo.TbItemDesc;
import com.bjsxt.ego.pojo.TbItemParam;
import com.bjsxt.ego.pojo.TbItemParamItem;

import java.util.List;


/**
 * 生产者提供的服务接口
 * @author ASUS
 */
public interface TbItemService {

    /**
     * 加载物品信息
     * @param page
     * @param rows
     * @return
     */
    public PageResult<TbItem> loadTbItemList(Integer page, Integer rows);

    /**
     * 更新物品状态
     * @param tbItem
     * @return
     */
    public EgoResult updateTbItemStatus(TbItem tbItem);

    /**
     * 删除商品信息
     * @param ids
     * @return
     */
    public EgoResult deleteTbItem(List<Long> ids);


    /**
     * 添加商品信息和商品详情
     * @param tbItem
     * @param tbItemDesc
     * @param tbItemParamItem
     * @return
     */
    public EgoResult saveTbItem(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem tbItemParamItem);

    /**
     * 更新商品信息
     * @param tbItem
     * @param tbItemDesc
     * @return
     */
    public EgoResult updateTbItem(TbItem tbItem, TbItemDesc tbItemDesc);
}
