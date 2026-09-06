package com.huawei.hms.ads.data;

import com.huawei.openalliance.ad.annotations.c;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SearchInfo {

    @c(Code = "chnl")
    private String channel;

    @c(Code = "kws")
    private List<Keyword> keywords;

    @c(Code = "qry")
    private String query;

    public SearchInfo() {
    }

    public SearchInfo(String str, List<Keyword> list, String str2) {
        this.query = str;
        this.keywords = list;
        this.channel = str2;
    }

    public String getChannel() {
        return this.channel;
    }

    public List<Keyword> getKeywords() {
        return this.keywords;
    }

    public String getQuery() {
        return this.query;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setKeywords(List<Keyword> list) {
        this.keywords = list;
    }

    public void setQuery(String str) {
        this.query = str;
    }
}
