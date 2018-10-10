package com.bjsxt.ego.item.service;

import com.bjsxt.domain.AdResult;

import java.util.List;

public interface ItemContentService {

    /**
     * 加载首页大广告
     * @param categoryId
     * @return
     */
    public String loadBigAd(Long categoryId);
}
