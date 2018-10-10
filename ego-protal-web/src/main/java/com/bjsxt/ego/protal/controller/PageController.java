package com.bjsxt.ego.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        System.out.println(page);
        return "/WEB-INF/jsp/" + page + ".jsp";
    }
}
