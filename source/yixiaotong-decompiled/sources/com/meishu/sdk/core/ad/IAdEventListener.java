package com.meishu.sdk.core.ad;

import com.meishu.sdk.core.utils.AdErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IAdEventListener<T> {
    void onAdError(AdErrorInfo adErrorInfo);

    void onAdReady(T t);
}
