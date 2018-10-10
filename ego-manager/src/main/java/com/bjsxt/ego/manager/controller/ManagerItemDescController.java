package com.bjsxt.ego.manager.controller;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.ego.manager.service.ManagerItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManagerItemDescController {

    @Autowired
    private ManagerItemDescService managerItemDescService;

    @RequestMapping("/rest/item/query/item/desc/{id}")
    @ResponseBody
    public EgoResult itemDesc(@PathVariable Long id) {
        return managerItemDescService.loadItemDescService(id);
    }

}
