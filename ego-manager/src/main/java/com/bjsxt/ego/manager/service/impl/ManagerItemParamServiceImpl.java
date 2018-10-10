package com.bjsxt.ego.manager.service.impl;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.ego.manager.service.ManagerItemParamServcie;
import com.bjsxt.ego.pojo.TbItemParam;
import com.bjsxt.ego.rpc.service.TbItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ASUS
 */
@Service
public class ManagerItemParamServiceImpl implements ManagerItemParamServcie {

    @Autowired
    private TbItemParamService tbItemParamServiceProxy;

    @Override
    public PageResult<TbItemParam> loadItemParam(Integer page,Integer rows) {

        return tbItemParamServiceProxy.loadItemParamList(page,rows);
    }

    @Override
    public EgoResult selectTbItemParam(Long id) {
        return tbItemParamServiceProxy.selectTbItemParam(id);
    }

    @Override
    public EgoResult saveTbItemParam(Long id,String paramData) {

        Date date = new Date();

        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setParamData(paramData);
        tbItemParam.setItemCatId(id);
        tbItemParam.setCreated(date);
        tbItemParam.setUpdated(date);
        return tbItemParamServiceProxy.saveTbItemParam(tbItemParam);
    }

    @Override
    public EgoResult deleteTbItemParam(Long ids) {
        return tbItemParamServiceProxy.deleteTbItemParam(ids);
    }

    @Override
    public EgoResult selectTbItemParamItem(Long id) {
        return tbItemParamServiceProxy.selectTbItemParamItem(id);
    }
}
