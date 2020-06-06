package com.pq.eshbase.condition;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class EsCondition {
    // 排序
    // 范围查询
    // 具体值匹配
    private SearchSourceBuilder searchSourceBuilder;
    private BoolQueryBuilder boolQueryBuilder;

    private EsCondition(SearchSourceBuilder searchSourceBuilder, BoolQueryBuilder boolQueryBuilder) {
        this.searchSourceBuilder = searchSourceBuilder;
        this.boolQueryBuilder = boolQueryBuilder;
    }

    public SearchSourceBuilder getSearchSourceBuilder() {
        return searchSourceBuilder.query(boolQueryBuilder).from(0).size(10000).timeout(new TimeValue(3000, TimeUnit.MILLISECONDS));
    }

    public static EsCondition getInstance() {
        return new EsCondition(SearchSourceBuilder.searchSource(), QueryBuilders.boolQuery());
    }

    /**
     * 排序
     * @param key
     * @param sortOrder
     * @return
     */
    public EsCondition sort(String key, SortOrder sortOrder) {
        if(StringUtils.isBlank(key) || sortOrder == null) {
            throw new IllegalArgumentException("EsCondition sort(key, sortOrder) argument wrong");
        }
        searchSourceBuilder.sort(key, sortOrder);
        return this;
    }

    /**
     * 匹配查询
     * @param key
     * @param value
     * @return
     */
    public EsCondition mustMatch(String key, String value) {
        checkParam(key, value);
        boolQueryBuilder.must(QueryBuilders.termsQuery(key, value));
        return this;
    }
    /**
     * 匹配查询
     * @param key
     * @param collection
     * @return
     */
    public EsCondition mustMatch(String key, Collection<?> collection) {
        if(StringUtils.isAnyBlank(key) || CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException("EsCondition argument wrong");
        }
        boolQueryBuilder.must(QueryBuilders.termsQuery(key, collection));
        return this;
    }
    /**
     * 匹配查询
     * @param key
     * @param value
     * @return
     */
    public EsCondition mustNotMatch(String key, String value) {
        checkParam(key, value);
        boolQueryBuilder.mustNot(QueryBuilders.termsQuery(key, value));
        return this;
    }
    /**
     * 匹配查询
     * @param key
     * @param collection
     * @return
     */
    public EsCondition mustNotMatch(String key, Collection<?> collection) {
        if(StringUtils.isAnyBlank(key) || CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException("EsCondition argument wrong");
        }
        boolQueryBuilder.mustNot(QueryBuilders.termsQuery(key, collection));
        return this;
    }
    /**
     * 匹配查询
     * @param key
     * @param value
     * @return
     */
    public EsCondition mustPrefix(String key, String value) {
        checkParam(key, value);
        boolQueryBuilder.must(QueryBuilders.prefixQuery(key, value));
        return this;
    }
    /**
     * 匹配查询
     * @param key
     * @param value
     * @return
     */
    public EsCondition mustNotPrefix(String key, String value) {
        checkParam(key, value);
        boolQueryBuilder.mustNot(QueryBuilders.prefixQuery(key, value));
        return this;
    }
    /**
     * 匹配查询
     * @param key
     * @param value
     * @return
     */
    public EsCondition mustRegex(String key, String value) {
        checkParam(key, value);
        boolQueryBuilder.must(QueryBuilders.regexpQuery(key, value));
        return this;
    }
    /**
     * 匹配查询
     * @param key
     * @param value
     * @return
     */
    public EsCondition mustNotRegex(String key, String value) {
        checkParam(key, value);
        boolQueryBuilder.mustNot(QueryBuilders.regexpQuery(key, value));
        return this;
    }

    private void checkParam(String... params) {
        if(StringUtils.isAnyBlank(params)) {
            throw new IllegalArgumentException("EsCondition argument wrong");
        }
    }

    /**
     * 范围查询
     * @param key
     * @param lowValue
     * @param lowIncloude
     * @param upValue
     * @param upIncloude
     * @return
     */
    public EsCondition fromTo(String key, String lowValue, boolean lowIncloude, String upValue, boolean upIncloude) {
        checkParam(key, lowValue, upValue);
        boolQueryBuilder.filter(new RangeQueryBuilder(key).from(lowValue).includeLower(lowIncloude).to(upValue).includeUpper(upIncloude));
        return this;
    }
}
