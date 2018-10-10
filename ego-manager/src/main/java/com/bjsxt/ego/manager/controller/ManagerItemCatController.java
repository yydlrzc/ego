package com.bjsxt.ego.manager.controller;

import com.bjsxt.domain.TreeResult;
import com.bjsxt.ego.manager.service.ManagerItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ASUS
 */
@Controller
public class ManagerItemCatController {

    @Autowired
    private ManagerItemCatService managerItemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<TreeResult> itemCatList(@RequestParam(defaultValue = "0") Long id) {
        return managerItemCatService.loadItemCatService(id);
    }
}
