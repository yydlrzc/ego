package com.bjsxt.ego.rpc.service;

import com.bjsxt.domain.AdResult;
import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.ego.pojo.TbContent;
import com.bjsxt.ego.pojo.TbContentCategory;

import java.util.List;

/**
 * @author ASUS
 */
public interface TbContentService {

    /**
     * 加载内容
     *
     * @return
     */
    public PageResult loadTbContentList(Integer page, Integer rows, Long categoryId);

    /**
     * 加载内容分类
     * @return
     */
    public List<TbContentCategory> loadTbContentCategoryList(Long pid);

    /**
     * 保存内容
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
     * 保存内容分类
     * @param tbContentCategory
     * @return
     */
    public EgoResult saveTbContentCategory(TbContentCategory tbContentCategory);

    /**
     * 更新内容分类
     * @param tbContentCategory
     * @return
     */
    public EgoResult updateTbContentCategory(TbContentCategory tbContentCategory);

    /**
     * 删除内容分类
     * @param id
     * @return
     */
    public EgoResult deleteTbContentCategory(Long id);

    /**
     * 加载首页大广告
     * @param categoryId
     * @return
     */
    public List<TbContent> selectBigAd(Long categoryId);
}
