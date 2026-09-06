package com.meishu.sdk.core.ad.paster;

import com.meishu.sdk.core.loader.IAdLoadListener;

/* JADX INFO: compiled from: PasterAdListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface b extends IAdLoadListener<PasterAd> {
    void onVideoComplete();

    void onVideoError();

    void onVideoLoaded();
}
