package com.bjsxt.ego.item.service.impl;

import com.bjsxt.domain.CatNode;
import com.bjsxt.domain.CatResult;
import com.bjsxt.ego.item.service.ItemCatService;
import com.bjsxt.ego.pojo.TbItemCat;
import com.bjsxt.ego.rpc.service.TbItemCatService;
import com.bjsxt.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatService tbItemCatServiceProxy;

    @Override
    public String loadItemCatAllListService() {
        List<TbItemCat> list = tbItemCatServiceProxy.loadTbItemCatAllList();
        CatResult catResult = new CatResult();

        List<?> children = getChildren(0L, list);

        catResult.setData(children);

        String json = JsonUtils.objectToJson(catResult);

        return json;
    }

    private List<?> getChildren(Long parentId, List<TbItemCat> itemCats) {
        //盛放指定分类下的所有子分类信息
        List resultList = new ArrayList();

        for (TbItemCat itemCat : itemCats) {

            if (itemCat.getParentId().equals(parentId)) {
                if (itemCat.getIsParent()) {
                    //如果itemCat代表一级分类或者二级分类

                    CatNode catNode = new CatNode();

                    if (itemCat.getParentId().longValue() == 0) {
                        //如果是一级分类    "<a href='/products/1.html'>图书、音像、电子书刊</a>",
                        catNode.setName("<a href='/products/" + itemCat.getId() + ".html'>" + itemCat.getName() + "</a>");
                    } else {
                        //如果是二级分类    "电子书刊",
                        catNode.setName(itemCat.getName());
                    }
                    //"/products/2.html",
                    catNode.setUrl("/products/" + itemCat.getId());
                    catNode.setList(getChildren(itemCat.getId(), itemCats));
                    //将节点添加到list集合中
                    resultList.add(catNode);
                } else {
                    //如果itemCat表示三级分类   "/products/3.html|电子书",
                    resultList.add("/products/" + itemCat.getId() + "|" + itemCat.getName());
                }
            }
        }
        return resultList;
    }

}
