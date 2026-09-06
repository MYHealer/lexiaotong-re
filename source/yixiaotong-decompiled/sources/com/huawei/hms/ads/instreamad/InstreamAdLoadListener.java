package com.huawei.hms.ads.instreamad;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface InstreamAdLoadListener {
    void onAdFailed(int i);

    void onAdLoaded(List<InstreamAd> list);
}
