package com.bjsxt.ego.manager.service.impl;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.domain.TreeResult;
import com.bjsxt.ego.manager.service.ManagerTbContentService;
import com.bjsxt.ego.pojo.TbContent;
import com.bjsxt.ego.pojo.TbContentCategory;
import com.bjsxt.ego.rpc.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerTbContentServiceImpl implements ManagerTbContentService {

    @Autowired
    private TbContentService tbContentServiceProxy;

    /**
     * 加载内容分类
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult<TbContent> loadTbContentService(Integer page, Integer rows, Long categoryId) {
        return tbContentServiceProxy.loadTbContentList(page,rows,categoryId);
    }

    @Override
    public List<TreeResult> loadTbContentCategoryService(Long pid) {

        List<TreeResult> treeResults = null;

        List<TbContentCategory> list = tbContentServiceProxy.loadTbContentCategoryList(pid);

        if (list != null && list.size() > 0) {
            treeResults = new ArrayList<>();
            for (TbContentCategory tbContentCategory : list) {
                TreeResult treeResult = new TreeResult();
                treeResult.setText(tbContentCategory.getName());
                treeResult.setState(tbContentCategory.getIsParent() ? "closed" : "open");
                treeResult.setId(tbContentCategory.getId());
                treeResults.add(treeResult);
            }
        }
        return treeResults;
    }

    @Override
    public EgoResult saveTbContent(TbContent tbContent) {
        return tbContentServiceProxy.saveTbContent(tbContent);
    }

    @Override
    public EgoResult updateTbContent(TbContent tbContent) {
        return tbContentServiceProxy.updateTbContent(tbContent);
    }

    @Override
    public EgoResult deleteTbContent(Long id) {
        return tbContentServiceProxy.deleteTbContent(id);
    }

    @Override
    public EgoResult saveTbContentCategory(TbContentCategory tbContentCategory) {
        return tbContentServiceProxy.saveTbContentCategory(tbContentCategory);
    }

    @Override
    public EgoResult updateTbContentCategory(TbContentCategory tbContentCategory) {
        return tbContentServiceProxy.updateTbContentCategory(tbContentCategory);
    }

    @Override
    public EgoResult deleteTbContentCategory(Long id) {
        return tbContentServiceProxy.deleteTbContentCategory(id);
    }
}
