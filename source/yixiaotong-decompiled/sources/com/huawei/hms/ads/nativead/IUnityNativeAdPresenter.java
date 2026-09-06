package com.huawei.hms.ads.nativead;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface IUnityNativeAdPresenter {
    int getMinEffectiveShowRatio();

    long getMinEffectiveShowTime();

    boolean onUnityAdClick();

    void onUnityAdClose(List<String> list);

    void onUnityAdPhyShow(long j, int i);

    void onUnityAdShow(Long l, Integer num, Integer num2);

    void onUnityAdShowStart();

    void onUnityGoWhyShowThis();

    void updateContent();
}
