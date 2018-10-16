package com.bjsxt.ego.search.service.impl;

import com.bjsxt.ego.search.dao.ItemDao;
import com.bjsxt.ego.search.pojo.Item;
import com.bjsxt.ego.search.pojo.SearchResult;
import com.bjsxt.ego.search.service.ItemService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public SearchResult loadItemService(String q, Integer page) {

        //创建solrquery对象
        SolrQuery solrQuery = new SolrQuery();

        //设置默认查询字段
        solrQuery.set("df", "item_keywords");

        //设置查询条件
        solrQuery.setQuery(q);

        //设置分页参数
        Integer rows = 20;
        solrQuery.setRows(rows);
        Integer start = (page - 1) * rows;
        solrQuery.setStart(start);

        //设置高亮显示
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("product_name");
        solrQuery.setHighlightSimplePre("<font color='red'>");
        solrQuery.setHighlightSimplePost("</font>");

        QueryResponse response = itemDao.loadItemBySolr(solrQuery);

        SolrDocumentList results = response.getResults();

        long conts = results.getNumFound();

        //计算最大页数
        Long totalPage = ((conts % rows) == 0) ? (conts / rows) : (conts / rows) + 1;

        DocumentObjectBinder binder = new DocumentObjectBinder();

        List<Item> beans = binder.getBeans(Item.class, results);

        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

        for (Item item : beans) {
            String id = item.getId();

            Map<String, List<String>> stringListMap = highlighting.get(id);

            List<String> list = stringListMap.get("product_name");

            if (list != null && list.size() > 0) {
                item.setTitle(list.get(0));
            }
        }

        SearchResult searchResult = new SearchResult();

        searchResult.setList(beans);
        searchResult.setTotalPages(totalPage);
        return searchResult;
    }
}
