package com.bjsxt.ego.rpc.service.impl;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.ego.mapper.TbItemParamItemMapper;
import com.bjsxt.ego.mapper.TbItemParamMapper;
import com.bjsxt.ego.pojo.TbItemParam;
import com.bjsxt.ego.pojo.TbItemParamExample;
import com.bjsxt.ego.pojo.TbItemParamItemExample;
import com.bjsxt.ego.pojo.TbItemParamItemExample.Criteria;
import com.bjsxt.ego.pojo.TbItemParamItem;
import com.bjsxt.ego.rpc.service.TbItemParamService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbItemParamServiceImpl implements TbItemParamService {

    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;

    /**
     * 加载商品类目列表
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult<TbItemParam> loadItemParamList(Integer page, Integer rows) {
        PageResult pageResult = new PageResult();

        Page p = PageHelper.startPage(page, rows);

        TbItemParamExample example = new TbItemParamExample();

        List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);

        pageResult.setRows(list);
        pageResult.setTotal(p.getTotal());

        return pageResult;
    }

    /**
     * 查询该商品类目是否已有
     * @param id
     * @return
     */
    @Override
    public EgoResult selectTbItemParam(Long id) {
        EgoResult egoResult = null;
        try {
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andItemCatIdEqualTo(id);
            List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
            egoResult = new EgoResult();
            egoResult.setData(list.get(0));
            egoResult.setStatus(200);
            return egoResult;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 保存商品类目信息
     * @param tbItemParam
     * @return
     */
    @Override
    public EgoResult saveTbItemParam(TbItemParam tbItemParam) {
        try {
            tbItemParamMapper.insert(tbItemParam);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 删除商品类目信息
     * @param ids
     * @return
     */
    @Override
    public EgoResult deleteTbItemParam(Long ids) {
        try {
            tbItemParamMapper.deleteByPrimaryKey(ids);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 查询商品参数信息
     * @param id
     * @return
     */
    @Override
    public EgoResult selectTbItemParamItem(Long id) {
        EgoResult egoResult = null;
        try {
            TbItemParamItemExample example = new TbItemParamItemExample();
            Criteria c = example.createCriteria();
            c.andItemIdEqualTo(id);

            List<TbItemParamItem> tbItemParamItems = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
            egoResult = new EgoResult();
            egoResult.setStatus(200);
            egoResult.setData(tbItemParamItems.get(0));
            return egoResult;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
