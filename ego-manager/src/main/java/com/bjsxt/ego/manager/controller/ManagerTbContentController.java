package com.bjsxt.ego.manager.controller;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.domain.TreeResult;
import com.bjsxt.ego.manager.service.ManagerTbContentService;
import com.bjsxt.ego.pojo.TbContent;
import com.bjsxt.ego.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ManagerTbContentController {

    @Autowired
    private ManagerTbContentService managerTbContentService;

    @RequestMapping("/content/query/list")
    @ResponseBody
    public PageResult<TbContent> loadTbContentList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer rows, @RequestParam(defaultValue = "0") Long categoryId) {
        return managerTbContentService.loadTbContentService(page, rows, categoryId);
    }

    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<TreeResult> loadTbContentCategoryList(@RequestParam(defaultValue = "0") Long id) {
        return managerTbContentService.loadTbContentCategoryService(id);
    }

    @RequestMapping("/content/save")
    @ResponseBody
    public EgoResult saveTbContent(TbContent tbContent) {
        return managerTbContentService.saveTbContent(tbContent);
    }

    @RequestMapping("rest/content/edit")
    @ResponseBody
    public EgoResult updateTbContent(TbContent tbContent) {
        return managerTbContentService.updateTbContent(tbContent);
    }

    @RequestMapping("/content/delete")
    @ResponseBody
    public EgoResult deleteTbContent(Long ids) {
        return managerTbContentService.deleteTbContent(ids);
    }

    @RequestMapping("/content/category/create")
    @ResponseBody
    public EgoResult saveTbContentCategory(TbContentCategory tbContentCategory) {
        return managerTbContentService.saveTbContentCategory(tbContentCategory);
    }

    @RequestMapping("/content/category/update")
    @ResponseBody
    public EgoResult updateTbContentCategory(TbContentCategory tbContentCategory) {
        return managerTbContentService.updateTbContentCategory(tbContentCategory);
    }

    @RequestMapping("/content/category/delete/")
    @ResponseBody
    public EgoResult deleteTbContentCategory(Long id) {
        return managerTbContentService.deleteTbContentCategory(id);
    }
}
