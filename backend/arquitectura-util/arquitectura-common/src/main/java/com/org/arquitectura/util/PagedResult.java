package com.org.arquitectura.util;

import java.util.Collection;

public class PagedResult<T> {

    private Collection<T> items;
    private Long totalCount;

    public PagedResult() {
    }

    public PagedResult(Collection<T> items) {
        this.items = items;
    }

    public PagedResult(Long totalCount) {
        this.totalCount = totalCount;
    }

    public PagedResult(Collection<T> items, Long totalCount) {
        this.items = items;
        this.totalCount = totalCount;
    }

    public Collection<T> getItems() {
        return items;
    }

    public void setItems(Collection<T> items) {
        this.items = items;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
