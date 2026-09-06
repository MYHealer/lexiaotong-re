package com.kwad.components.offline.api.obiwan;

import com.kwad.components.offline.api.IOfflineCompoInitConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IObiwanOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    String getLogDirPath();

    String getLogObiwanData();

    long getLogObiwanStorageQuota();

    boolean isLogObiwanEnableNow();

    boolean isLogObiwanRecordAll();
}
