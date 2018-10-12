package com.bjsxt.ego.item.service.impl;

import com.bjsxt.ego.item.service.ItemItemService;
import com.bjsxt.ego.pojo.TbItem;
import com.bjsxt.ego.pojo.TbItemDesc;
import com.bjsxt.ego.pojo.TbItemParamItem;
import com.bjsxt.ego.rpc.service.TbItemService;
import com.bjsxt.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemItemServiceImpl implements ItemItemService {

    @Autowired
    private TbItemService tbItemServiceProxy;

    @Override
    public TbItem loadItemService(Long itemId) {
        return tbItemServiceProxy.loadTbItem(itemId);
    }

    @Override
    public String loadItemParamItemService(Long id) {
        TbItemParamItem tbItemParamItem = tbItemServiceProxy.loadTbItemParam(id);
        String paramData = tbItemParamItem.getParamData();
        List<Map> listMap = JsonUtils.jsonToList(paramData, Map.class);
        StringBuffer sb = new StringBuffer();
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
        sb.append("<tbody>\n");
        for (Map m1 : listMap) {
            sb.append("<tr>\n");
            sb.append("<th class=\"tdTitle\" colspan=\"2\">" + m1.get("group") + "</th>\n");
            sb.append("</tr>\n");
            List<Map> list2 = (List<Map>) m1.get("params");
            for (Map m2 : list2) {
                sb.append("<tr>\n");
                sb.append("<td class=\"tdTitle\">" + m2.get("k") + "</td>\n");
                sb.append("<td>" + m2.get("v") + "</td>\n");
                sb.append("</tr>\n");
            }
        }
        sb.append("</tbody>\n");
        sb.append("</table>");
        // 返回html片段
        return sb.toString();
    }

    @Override
    public String loadItemDescService(Long itemId) {
        TbItemDesc tbItemDesc = tbItemServiceProxy.loadTbItemDesc(itemId);
        return tbItemDesc.getItemDesc();
    }
}
