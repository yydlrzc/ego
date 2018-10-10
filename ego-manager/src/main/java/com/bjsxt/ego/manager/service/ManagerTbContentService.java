package com.bjsxt.ego.manager.service;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.domain.TreeResult;
import com.bjsxt.ego.pojo.TbContent;
import com.bjsxt.ego.pojo.TbContentCategory;

import java.util.List;

/**
 * @author ASUS
 */
public interface ManagerTbContentService {

    /**
     * 加载内容
     * @param page
     * @param rows
     * @return
     */
    public PageResult<TbContent> loadTbContentService(Integer page, Integer rows, Long categoryId);

    /**
     * 加载内容分类
     * @return
     */
    public List<TreeResult> loadTbContentCategoryService(Long pid);

    /**
     * 加载商品内容
     * @param tbContent
     * @return
     */
    public EgoResult saveTbContent(TbContent tbContent);

    /**
     * 更新内容信息
     * @param tbContent
     * @return
     */
    public EgoResult updateTbContent(TbContent tbContent);

    /**
     * 删除内容信息
     * @param id
     * @return
     */
    public EgoResult deleteTbContent(Long id);

    /**
     * 添加内容信息
     * @param tbContentCategory
     * @return
     */
    public EgoResult saveTbContentCategory(TbContentCategory tbContentCategory);

    /**
     * 更新内容信息
     * @param tbContentCategory
     * @return
     */
    public EgoResult updateTbContentCategory(TbContentCategory tbContentCategory);

    /**
     * 删除内容信息
     * @param id
     * @return
     */
    public EgoResult deleteTbContentCategory(Long id);
}
