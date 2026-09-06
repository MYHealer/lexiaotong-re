package com.huawei.openalliance.ad.beans.inner;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BaseAdReqParam {
    private long adLoadStartTime;
    private String cachedDslEngineVersion;
    private String cachedStylePkgVersion;

    public long Code() {
        return this.adLoadStartTime;
    }

    public void Code(long j) {
        this.adLoadStartTime = j;
    }

    public void Code(String str) {
        this.cachedStylePkgVersion = str;
    }

    public String I() {
        return this.cachedDslEngineVersion;
    }

    public String V() {
        return this.cachedStylePkgVersion;
    }

    public void V(String str) {
        this.cachedDslEngineVersion = str;
    }
}
