package com.huawei.hms.framework.network.grs;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface IQueryUrlsCallBack {
    void onCallBackFail(int i);

    void onCallBackSuccess(Map<String, String> map);
}
