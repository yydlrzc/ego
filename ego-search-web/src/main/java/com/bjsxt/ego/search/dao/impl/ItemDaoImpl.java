package com.bjsxt.ego.search.dao.impl;

import com.bjsxt.ego.search.dao.ItemDao;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private HttpSolrServer server;
    @Override
    public QueryResponse loadItemBySolr(SolrQuery params) {
        // TODO Auto-generated method stub
        try {
            return server.query(params);
        } catch (SolrServerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}

