package com.bjsxt.ego.manager.service.impl;

import com.bjsxt.domain.TreeResult;
import com.bjsxt.ego.manager.service.ManagerItemCatService;
import com.bjsxt.ego.pojo.TbItemCat;
import com.bjsxt.ego.rpc.service.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 */
@Service
public class ManagerItemCatServiceImpl implements ManagerItemCatService {

    @Autowired
    private TbItemCatService tbItemCatServiceProxy;

    @Override
    public List<TreeResult> loadItemCatService(Long pid) {
        List<TbItemCat> list = tbItemCatServiceProxy.loadTbItemCatList(pid);
        List<TreeResult> treeResults = null;
        if (list != null && list.size() > 0) {
            treeResults = new ArrayList<>();
            for (TbItemCat cat : list) {
                TreeResult result = new TreeResult();
                result.setId(cat.getId());
                result.setState(cat.getIsParent() ? "closed" : "open");
                result.setText(cat.getName());
                treeResults.add(result);
            }
        }
        return treeResults;
    }
}
