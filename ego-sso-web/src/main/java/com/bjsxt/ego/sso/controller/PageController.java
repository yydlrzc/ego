package com.bjsxt.ego.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/sso/{url}")
    public String loadView(@PathVariable String url, Model model, String redirectUrl) {
        model.addAttribute("redirect", redirectUrl);
        return url;
    }

    @RequestMapping("/reg/{url}")
    public String loadView(@PathVariable String url) {
        return url;
    }
}
