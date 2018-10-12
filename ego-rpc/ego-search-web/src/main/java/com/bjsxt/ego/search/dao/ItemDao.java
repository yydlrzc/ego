package com.bjsxt.ego.search.dao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;

public interface ItemDao {

    public QueryResponse loadItemBySolr(SolrQuery params);
}
