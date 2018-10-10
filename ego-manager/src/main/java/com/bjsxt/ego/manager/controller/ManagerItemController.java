package com.bjsxt.ego.manager.controller;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.domain.PictureResult;
import com.bjsxt.ego.manager.service.ManagerItemService;
import com.bjsxt.ego.pojo.TbItem;
import com.bjsxt.ego.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 消费者业务方法
 * @author ASUS
 */
@Controller
public class ManagerItemController {

    @Autowired
    private ManagerItemService managerItemService;

    /**
     * 加载商品列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public PageResult<TbItem> itemList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
        return managerItemService.loadItemManagerService(page, rows);
    }

    /**
     * 商品下架请求
     * @param ids
     * @return
     */
    @RequestMapping("/rest/item/instock")
    @ResponseBody
    public EgoResult itemInstock(Long[] ids) {
        EgoResult egoResult = null;
        for (Long id : ids) {
            egoResult = managerItemService.updateTbItemStatus(id, true);
        }
        return egoResult;
    }

    /**
     * 商品上架请求
     * @param ids
     * @return
     */
    @RequestMapping("/rest/item/reshelf")
    @ResponseBody
    public EgoResult itemReshelf(Long[] ids) {
        EgoResult egoResult = null;
        for (Long id : ids) {
            egoResult = managerItemService.updateTbItemStatus(id, false);
        }
        return egoResult;
    }

    /**
     * 删除商品信息请求
     * @param ids
     * @return
     */
    @RequestMapping("/rest/item/delete")
    @ResponseBody
    public EgoResult deleteTbItem(String ids) {
        return managerItemService.deleteTbItem(ids);
    }

    /**
     * 添加商品信息
     * @param tbItem
     * @param desc
     * @return
     */
    @RequestMapping("/item/save")
    @ResponseBody
    public EgoResult saveTbItem(TbItem tbItem, String desc, String itemParams) {
        return managerItemService.saveItemService(tbItem, desc, itemParams);
    }

    @RequestMapping("/pic/upload")
    @ResponseBody
    public PictureResult saveTbItemImage(MultipartFile uploadFile) {
        return managerItemService.saveItemImage(uploadFile);
    }

    @RequestMapping("/rest/item/update")
    @ResponseBody
    public EgoResult updateTbItem(TbItem tbItem, String desc) {
        return managerItemService.updateItemService(tbItem, desc);
    }

}
