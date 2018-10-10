package com.bjsxt.ego.rpc.service;


import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.ego.pojo.TbItemParam;

import java.util.List;

/**
 * @author ASUS
 */
public interface TbItemParamService {

    /**
     * 加载商品类目列表
     * @return
     */
    public PageResult<TbItemParam> loadItemParamList(Integer page,Integer rows);

    /**
     * 查询该商品是否已有
     * @param id
     * @return
     */
    public EgoResult selectTbItemParam(Long id);

    /**
     * 保存商品类目信息
     * @param tbItemParam
     * @return
     */
    public EgoResult saveTbItemParam(TbItemParam tbItemParam);

    /**
     * 删除商品类目信息
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
