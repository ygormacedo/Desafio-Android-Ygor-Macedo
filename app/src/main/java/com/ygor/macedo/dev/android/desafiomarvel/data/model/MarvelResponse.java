package com.ygor.macedo.dev.android.desafiomarvel.data.model;

import com.google.gson.annotations.Expose;

public class MarvelResponse {

    @Expose
    private String attributionHTML;
    @Expose
    private String attributionText;
    @Expose
    private Long code;
    @Expose
    private String copyright;
    @Expose
    private MarvelData marvelData;
    @Expose
    private String etag;
    @Expose
    private String status;

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public MarvelData getMarvelData() {
        return marvelData;
    }

    public void setMarvelData(MarvelData marvelData) {
        this.marvelData = marvelData;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
