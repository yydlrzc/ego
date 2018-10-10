package com.bjsxt.ego.manager.service;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;

public interface ManagerItemParamServcie {

    /**
     * 加载商品类目信息
     * @return
     */
    public PageResult loadItemParam(Integer page, Integer rows);

    /**
     * 加载所选类目信息用于判断
     * @param id
     * @return
     */
    public EgoResult selectTbItemParam(Long id);

    /**
     * 保存商品类目信息
     * @param id
     * @param paramData
     * @return
     */
    public EgoResult saveTbItemParam(Long id, String paramData);

    /**
     * 删除商品信息
     * @param ids
     * @return
     */
    public EgoResult deleteTbItemParam(Long ids);

    /**
     * 查询商品参数信息
     * @param id
     * @return
     */
    public EgoResult selectTbItemParamItem(Long id);
}
