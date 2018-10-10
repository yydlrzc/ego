package com.bjsxt.ego.item.service.impl;

import com.bjsxt.domain.AdResult;
import com.bjsxt.ego.item.service.ItemContentService;
import com.bjsxt.ego.pojo.TbContent;
import com.bjsxt.ego.rpc.service.TbContentService;
import com.bjsxt.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemContenServiceImpl implements ItemContentService {

    @Autowired
    private TbContentService tbContentServiceProxy;
    @Override
    public String loadBigAd(Long categoryId) {

        List<TbContent> list = tbContentServiceProxy.selectBigAd(categoryId);

        List<AdResult> adResults = new ArrayList<>();
        for (TbContent tbContent : list) {
            AdResult adResult = new AdResult();
            adResult.setAlt(tbContent.getTitle());
            adResult.setHref(tbContent.getUrl());
            adResult.setSrc(tbContent.getPic());
            adResult.setSrcb(tbContent.getPic2());
            adResults.add(adResult);
        }

        String s = JsonUtils.objectToJson(adResults);
        return s;
    }
}
