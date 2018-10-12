package com.bjsxt.ego.search.controller;

import com.bjsxt.ego.search.pojo.SearchResult;
import com.bjsxt.ego.search.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{url}")
    public String loadView(@PathVariable String url, @RequestParam(defaultValue = "1") Integer page, String q, Model model) {
        try {
            q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        SearchResult searchResult = itemService.loadItemService(q, page);

        model.addAttribute("itemList", searchResult.getList());
        model.addAttribute("totalPages", searchResult.getTotalPages());
        model.addAttribute("query", q);
        model.addAttribute("page", page);

        return "/WEB-INF/jsp/" + url + ".jsp";
    }
}
