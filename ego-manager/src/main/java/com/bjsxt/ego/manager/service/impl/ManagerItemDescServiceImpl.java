package com.bjsxt.ego.manager.service.impl;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.ego.manager.service.ManagerItemDescService;
import com.bjsxt.ego.pojo.TbItemDesc;
import com.bjsxt.ego.rpc.service.TbItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerItemDescServiceImpl implements ManagerItemDescService {

    @Autowired
    private TbItemDescService tbItemDescServiceProxy;

    @Override
    public EgoResult loadItemDescService(Long id) {
        EgoResult egoResult = null;
        try {
            egoResult = new EgoResult();
            TbItemDesc itemDesc = tbItemDescServiceProxy.loadTbItemDesc(id);
            egoResult.setData(itemDesc);
            egoResult.setStatus(200);
            return egoResult;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
