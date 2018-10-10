package com.bjsxt.ego.rpc.service.impl;

import com.bjsxt.ego.mapper.TbItemCatMapper;
import com.bjsxt.ego.pojo.TbItemCat;
import com.bjsxt.ego.pojo.TbItemCatExample;
import com.bjsxt.ego.rpc.service.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 */

@Service
public class TbItemCatServiceImpl implements TbItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> loadTbItemCatList(Long pid) {

        TbItemCatExample example = new TbItemCatExample();

        example.createCriteria().andParentIdEqualTo(pid);

        return tbItemCatMapper.selectByExample(example);
    }

    @Cacheable(cacheNames="indexCatCache",key="666")
    @Override
    public List<TbItemCat> loadTbItemCatAllList() {
        TbItemCatExample example = new TbItemCatExample();
        return tbItemCatMapper.selectByExample(example);
    }
}
