package com.kwad.components.offline.api.obiwan;

import com.kwad.components.offline.api.IOfflineCompo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IObiwanOfflineCompo extends IOfflineCompo<IObiwanOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.core.log.ObiwanOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.obiwan";

    IObiwanLogcat getLog();

    void updateConfigs();
}
