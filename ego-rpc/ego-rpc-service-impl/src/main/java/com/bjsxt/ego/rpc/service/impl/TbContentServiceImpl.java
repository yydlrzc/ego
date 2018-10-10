package com.bjsxt.ego.rpc.service.impl;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.ego.mapper.TbContentCategoryMapper;
import com.bjsxt.ego.mapper.TbContentMapper;
import com.bjsxt.ego.pojo.TbContent;
import com.bjsxt.ego.pojo.TbContentCategory;
import com.bjsxt.ego.pojo.TbContentCategoryExample;
import com.bjsxt.ego.pojo.TbContentExample;
import com.bjsxt.ego.rpc.service.TbContentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ASUS
 */
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    /**
     * 加载内容
     * @param page 当前页码
     * @param rows 每页显示的条数
     * @return 分页查询结果
     */
    @Override
    public PageResult<TbContent> loadTbContentList(Integer page,Integer rows,Long categoryId) {
        Page p = PageHelper.startPage(page, rows);
        TbContentExample example = new TbContentExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        List<TbContent> list = tbContentMapper.selectByExampleWithBLOBs(example);
        PageResult<TbContent> pageResult = new PageResult<>();
        pageResult.setTotal(p.getTotal());
        pageResult.setRows(list);
        return pageResult;
    }

    /**
     * 加载内容分类
     * @param pid 加载该id下的节点
     * @return id为pid的节点下的所有子节点的集合
     */
    @Override
    public List<TbContentCategory> loadTbContentCategoryList(Long pid) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        example.createCriteria().andParentIdEqualTo(pid);
        return tbContentCategoryMapper.selectByExample(example);
    }

    /**
     * 保存内容
     * @param tbContent 需要保存的参数对象
     * @return 返回保存状态
     */
    @CacheEvict(value = "contentServiceImpl",key = "89")
    @Override
    public EgoResult saveTbContent(TbContent tbContent) {
        try {
            Date date = new Date();
            tbContent.setCreated(date);
            tbContent.setUpdated(date);
            tbContentMapper.insert(tbContent);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 更新内容信息
     * @param tbContent 要更新的内容的对象
     * @return 操作结果
     */
    @CacheEvict(value = "contentServiceImpl",key = "89")
    @Override
    public EgoResult updateTbContent(TbContent tbContent) {
        try {
            Date date = new Date();
            tbContent.setUpdated(date);
            tbContentMapper.updateByPrimaryKeySelective(tbContent);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 删除内容信息
     * @param id 要删除的内容id
     * @return 操作结果
     */
    @CacheEvict(value = "contentServiceImpl",key = "89")
    @Override
    public EgoResult deleteTbContent(Long id) {
        try {
            tbContentMapper.deleteByPrimaryKey(id);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 保存内容分类
     * @param tbContentCategory 要保存的内容分类的对象
     * @return 操作结果
     */
    @Override
    public EgoResult saveTbContentCategory(TbContentCategory tbContentCategory) {
        try {
            Date date = new Date();
            tbContentCategory.setCreated(date);
            tbContentCategory.setUpdated(date);
            tbContentCategory.setIsParent(false);
            tbContentCategory.setSortOrder(1);
            tbContentCategory.setStatus(1);


            //查出他的父节点,并将父节点的isparent改为true
            TbContentCategory tbcc = tbContentCategoryMapper.selectByPrimaryKey(tbContentCategory.getParentId());
            TbContentExample example = new TbContentExample();
            example.createCriteria().andCategoryIdEqualTo(tbcc.getId());
            List<TbContent> list = tbContentMapper.selectByExample(example);
            System.out.println(list);
            if (list.size() > 0) {
                return null;
            }
            tbcc.setIsParent(true);
            updateTbContentCategory(tbcc);

            tbContentCategoryMapper.insert(tbContentCategory);
            EgoResult egoResult = new EgoResult();
            egoResult.setData(tbContentCategory);
            egoResult.setStatus(200);
            return egoResult;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 更新内容分类
     * @param tbContentCategory 要更新的分类对象信息
     * @return 操作结果
     */
    @Override
    public EgoResult updateTbContentCategory(TbContentCategory tbContentCategory) {
        try {
            tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 删除内容分类
     * @param id 要删除的分类id
     * @return 操作结果
     */
    @Override
    public EgoResult deleteTbContentCategory(Long id) {
        try {
            TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(id);

            TbContentCategoryExample example = new TbContentCategoryExample();
            example.createCriteria().andParentIdEqualTo(tbContentCategory.getParentId());
            List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
            if (list.size() == 1) {
                TbContentCategory tbContentCategory1 = tbContentCategoryMapper.selectByPrimaryKey(tbContentCategory.getParentId());
                tbContentCategory1.setIsParent(false);
                updateTbContentCategory(tbContentCategory1);
            }

            tbContentCategoryMapper.deleteByPrimaryKey(id);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 首页展示大广告
     * @param categoryId
     * @return
     */
    @Cacheable(cacheNames = "contentServiceImpl",key = "#categoryId")
    @Override
    public List<TbContent> selectBigAd(Long categoryId) {
        TbContentExample example = new TbContentExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        List<TbContent> list = tbContentMapper.selectByExample(example);
        return list;
    }
}