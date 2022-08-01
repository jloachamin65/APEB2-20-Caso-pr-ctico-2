package com.org.arquitectura.util;

import java.util.Collection;
import java.util.Map;

public class FilterParam {

    private Integer itemPerPage;
    private Integer firstResult;
    private Collection<FieldFilter> lstFilter;
    private Map<String, String> filterByFields;
    private Map<String, String> orderBy;

    public FilterParam() {
    }

    public FilterParam(Integer itemPerPage, Integer firstResult) {
        this.itemPerPage = itemPerPage;
        this.firstResult = firstResult;
    }

    public Integer getItemPerPage() {
        return itemPerPage;
    }

    public void setItemPerPage(Integer itemPerPage) {
        this.itemPerPage = itemPerPage;
    }

    public Integer getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(Integer firstResult) {
        this.firstResult = firstResult;
    }

    public Collection<FieldFilter> getLstFilter() {
        return lstFilter;
    }

    public void setLstFilter(Collection<FieldFilter> lstFilter) {
        this.lstFilter = lstFilter;
    }

    public Map<String, String> getFilterByFields() {
        return filterByFields;
    }

    public void setFilterByFields(Map<String, String> filterByFields) {
        this.filterByFields = filterByFields;
    }

    public Map<String, String> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Map<String, String> orderBy) {
        this.orderBy = orderBy;
    }
}
