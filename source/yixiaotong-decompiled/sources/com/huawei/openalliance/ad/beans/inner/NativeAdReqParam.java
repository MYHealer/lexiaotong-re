package com.huawei.openalliance.ad.beans.inner;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class NativeAdReqParam extends BaseAdReqParam {
    private List<String> cacheContentIds;
    private boolean enableDirectCacheVideo;
    private boolean enableDirectReturnVideoAd;
    private boolean enableVideoDownloadInMobileNetwork;
    private String extraInfo;
    private int linkedVideoMode = 0;

    public void Code(List<String> list) {
        this.cacheContentIds = list;
    }

    public void Code(boolean z) {
        this.enableVideoDownloadInMobileNetwork = z;
    }

    public void I(String str) {
        this.extraInfo = str;
    }

    public void I(boolean z) {
        this.enableDirectCacheVideo = z;
    }

    public void V(boolean z) {
        this.enableDirectReturnVideoAd = z;
    }
}
