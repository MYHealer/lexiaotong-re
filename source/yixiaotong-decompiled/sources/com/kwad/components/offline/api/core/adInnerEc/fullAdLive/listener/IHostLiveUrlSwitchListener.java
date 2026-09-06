package com.kwad.components.offline.api.core.adInnerEc.fullAdLive.listener;

import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.info.HostLiveUrlSwitchReason;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IHostLiveUrlSwitchListener {
    void onUrlSwitchFail(HostLiveUrlSwitchReason hostLiveUrlSwitchReason);

    void onUrlSwitchSuccess(HostLiveUrlSwitchReason hostLiveUrlSwitchReason);
}
