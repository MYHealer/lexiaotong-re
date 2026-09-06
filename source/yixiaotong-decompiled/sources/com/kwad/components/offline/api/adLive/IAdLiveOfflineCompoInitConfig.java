package com.kwad.components.offline.api.adLive;

import com.kwad.components.offline.api.IOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHttpRequestListenerDelegate;
import com.kwad.components.offline.api.core.soloader.ISoLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IAdLiveOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    AdLiveHttpRequestListenerDelegate getAdLiveHttpRequestListenerDelegate();

    ISoLoader soLoader();

    boolean usePhoneStateDisable();
}
