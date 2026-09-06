package com.kwad.components.offline.api.tk.jsbridge;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IOfflineCompoBridgeHandler {
    String getKey();

    void handleJsCall(String str, IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction);

    void onDestroy();
}
