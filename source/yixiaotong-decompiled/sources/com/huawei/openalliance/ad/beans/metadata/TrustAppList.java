package com.huawei.openalliance.ad.beans.metadata;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class TrustAppList {
    Map<String, List<String>> trustAppList;

    public Map<String, List<String>> Code() {
        return this.trustAppList;
    }

    public void Code(Map<String, List<String>> map) {
        this.trustAppList = map;
    }
}
