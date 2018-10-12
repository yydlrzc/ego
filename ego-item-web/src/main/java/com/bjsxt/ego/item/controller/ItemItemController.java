package com.bjsxt.ego.item.controller;

import com.bjsxt.ego.item.service.ItemItemService;
import com.bjsxt.ego.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemItemController {

    @Autowired
    private ItemItemService itemItemService;

    @RequestMapping("/item/{itemId}")
    public String itemInfo(@PathVariable Long itemId, Model model) {
        TbItem tbItem = itemItemService.loadItemService(itemId);
        model.addAttribute("item", tbItem);
        return "/WEB-INF/jsp/item.jsp";
    }

    @RequestMapping(value = "/item/param/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    @ResponseBody
    public String itemParam(@PathVariable Long itemId) {
        return itemItemService.loadItemParamItemService(itemId);
    }

    @RequestMapping(value = "/item/desc/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    @ResponseBody
    public String itemDesc(@PathVariable Long itemId) {
        return itemItemService.loadItemDescService(itemId);
    }


}
