package com.huawei.hms.ads.consent.bean.network;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ConfirmResultReq {
    private List<ApiStatisticsReq> caches = new ArrayList();

    public List<ApiStatisticsReq> getCaches() {
        return this.caches;
    }

    public void setCaches(List<ApiStatisticsReq> list) {
        this.caches = list;
    }
}
