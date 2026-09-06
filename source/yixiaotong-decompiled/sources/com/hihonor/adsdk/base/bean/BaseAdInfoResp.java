package com.hihonor.adsdk.base.bean;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BaseAdInfoResp {
    private String adUnitId;
    private boolean isCachedData;
    private List<BaseAdInfo> list;
    private String requestId;
    private long responseTimeMillis;

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public List<BaseAdInfo> getList() {
        return this.list;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getResponseTimeMillis() {
        return this.responseTimeMillis;
    }

    public boolean isCachedData() {
        return this.isCachedData;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setCachedData(boolean z) {
        this.isCachedData = z;
    }

    public void setList(List<BaseAdInfo> list) {
        this.list = list;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setResponseTimeMillis(long j) {
        this.responseTimeMillis = j;
    }
}
