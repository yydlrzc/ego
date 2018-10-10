package com.bjsxt.ego.item.controller;

import com.bjsxt.ego.item.service.ItemContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemContentController {

    @Autowired
    private ItemContentService itemContentService;

    @RequestMapping("/content/bigad/list")
    @ResponseBody
    public String loadBigAd(Long categoryId,String callback) {
        String str = itemContentService.loadBigAd(categoryId);
        str = callback + "(" + str + ")";
        System.out.println(str);
        return str;
    }
}
