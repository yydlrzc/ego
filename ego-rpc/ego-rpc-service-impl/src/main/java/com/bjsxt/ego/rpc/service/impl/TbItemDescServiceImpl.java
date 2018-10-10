package com.bjsxt.ego.rpc.service.impl;

import com.bjsxt.ego.mapper.TbItemDescMapper;
import com.bjsxt.ego.pojo.TbItemDesc;
import com.bjsxt.ego.rpc.service.TbItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbItemDescServiceImpl implements TbItemDescService {

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TbItemDesc loadTbItemDesc(Long id) {
        return tbItemDescMapper.selectByPrimaryKey(id);
    }
}
