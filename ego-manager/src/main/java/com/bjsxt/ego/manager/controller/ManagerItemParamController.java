package com.bjsxt.ego.manager.controller;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.ego.manager.service.ManagerItemParamServcie;
import com.bjsxt.ego.pojo.TbItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ASUS
 */
@Controller
public class ManagerItemParamController {

    @Autowired
    private ManagerItemParamServcie managerItemParamServcie;


    /**
     * 加载商品类目列表
     * @return
     */
    @RequestMapping("/item/param/list")
    @ResponseBody
    public PageResult<TbItemParam> itemParamList(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "30") Integer rows) {
        return managerItemParamServcie.loadItemParam(page,rows);
    }

    /**
     * 查询指定id的商品类目信息
     * @param id
     * @return
     */
    @RequestMapping("/item/param/query/itemcatid/{id}")
    @ResponseBody
    public EgoResult selectTbItemParam(@PathVariable Long id) {
        return managerItemParamServcie.selectTbItemParam(id);
    }

    /**
     * 保存商品信息
     * @param id
     * @param paramData
     * @return
     */
    @RequestMapping("/item/param/save/{id}")
    @ResponseBody
    public EgoResult saveItemParam(@PathVariable Long id, String paramData) {
        return managerItemParamServcie.saveTbItemParam(id, paramData);
    }

    /**
     * 删除商品信息
     * @param ids
     * @return
     */
    @RequestMapping("/item/param/delete")
    @ResponseBody
    public EgoResult deleteItemParam(Long ids) {
        return managerItemParamServcie.deleteTbItemParam(ids);
    }

    @RequestMapping("/rest/item/param/item/query/{id}")
    @ResponseBody
    public EgoResult selectItemParam(@PathVariable Long id) {
        return managerItemParamServcie.selectTbItemParamItem(id);
    }
}
