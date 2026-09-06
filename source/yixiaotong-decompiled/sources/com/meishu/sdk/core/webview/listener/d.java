package com.meishu.sdk.core.webview.listener;

import com.meishu.sdk.core.webview.jsbridge.bean.ClickTempParam;

/* JADX INFO: compiled from: OnJsEventListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface d extends a {
    boolean clickAppDownloadInfo(String str);

    void dismissAd();

    String getActivityState();

    String getDeviceInfo();

    boolean isAppBackground();

    boolean isSoundsOpen();

    void notifyRewarded();

    void onClosePage();

    void onWebClicked(ClickTempParam clickTempParam);

    void onWebReady(boolean z);

    boolean setShakeOrTurnState(boolean z);

    void setSoundsOpen(boolean z);

    void setVideoPlayState(boolean z);
}
