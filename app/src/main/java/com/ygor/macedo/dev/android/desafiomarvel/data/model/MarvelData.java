package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MarvelData {

    @Expose
    private Long count;
    @Expose
    private Long limit;
    @Expose
    private Long offset;
    @Expose
    private List<MarvelResults> marvelResults;
    @Expose
    private Long total;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public List<MarvelResults> getMarvelResults() {
        return marvelResults;
    }

    public void setMarvelResults(List<MarvelResults> marvelResults) {
        this.marvelResults = marvelResults;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }


}
