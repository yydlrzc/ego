package com.bjsxt.ego.item.controller;

import com.bjsxt.ego.item.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ASUS
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/itemCat", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public String itemCat(String callback) {
        String str = itemCatService.loadItemCatAllListService();

        return callback + "(" + str + ")";
    }

}
