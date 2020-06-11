package com.pq.eshbase.condition;

import com.pq.eshbase.query.es.EsClient;
import org.elasticsearch.action.search.*;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

public class EsScrollCondition<T> {

    private String scrollId;

    private EsCondition esCondition;

    private int size;

}
