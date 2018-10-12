package com.bjsxt.ego.rpc.service.impl;

import com.bjsxt.domain.PageResult;
import com.bjsxt.domain.EgoResult;
import com.bjsxt.ego.mapper.TbItemDescMapper;
import com.bjsxt.ego.mapper.TbItemMapper;
import com.bjsxt.ego.mapper.TbItemParamItemMapper;
import com.bjsxt.ego.pojo.*;
import com.bjsxt.ego.pojo.TbItemExample.Criteria;
import com.bjsxt.ego.rpc.service.TbItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 */
@SuppressWarnings("ALL")
@Service
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;

    @SuppressWarnings("AlibabaRemoveCommentedCode")
    @Override
    public PageResult<TbItem> loadTbItemList(Integer page, Integer rows) {
        PageResult<TbItem> result = new PageResult<>();

        Page pe = PageHelper.startPage(page, rows);

        TbItemExample example = new TbItemExample();

        List<TbItem> list = tbItemMapper.selectByExample(example);

        result.setRows(list);
        result.setTotal(pe.getTotal());
        return result;
    }

    @Override
    public EgoResult updateTbItemStatus(TbItem tbItem) {
        try {
            tbItemMapper.updateByPrimaryKeySelective(tbItem);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public EgoResult deleteTbItem(List<Long> ids) {
        TbItemExample example = new TbItemExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        try {
            tbItemMapper.deleteByExample(example);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public EgoResult saveTbItem(TbItem tbItem, TbItemDesc tbItemDesc, TbItemParamItem tbItemParamItem) {
        try {
            tbItemMapper.insert(tbItem);
            tbItemDescMapper.insert(tbItemDesc);
            tbItemParamItemMapper.insert(tbItemParamItem);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public EgoResult updateTbItem(TbItem tbItem, TbItemDesc tbItemDesc) {
        try {
            tbItemMapper.updateByPrimaryKeySelective(tbItem);
            tbItemDescMapper.updateByPrimaryKeySelective(tbItemDesc);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    @Cacheable(value = "item_basc_info",key = "#itemId",sync = true)
    public TbItem loadTbItem(Long itemId) {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public TbItemParamItem loadTbItemParam(Long itemId) {
        TbItemParamItemExample example = new TbItemParamItemExample();
        example.createCriteria().andItemIdEqualTo(itemId);
        List<TbItemParamItem> tbItemParamItems = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
        if (tbItemParamItems != null && tbItemParamItems.size() == 1) {
            return tbItemParamItems.get(0);
        }
        return null;
    }

    @Override
    public TbItemDesc loadTbItemDesc(Long itemId) {
        return tbItemDescMapper.selectByPrimaryKey(itemId);
    }
}
