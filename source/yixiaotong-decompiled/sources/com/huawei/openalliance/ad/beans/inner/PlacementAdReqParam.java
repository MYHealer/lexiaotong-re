package com.huawei.openalliance.ad.beans.inner;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PlacementAdReqParam extends BaseAdReqParam {
    private boolean autoCache;
    private String extraInfo;

    public void Code(boolean z) {
        this.autoCache = z;
    }

    public void I(String str) {
        this.extraInfo = str;
    }
}
