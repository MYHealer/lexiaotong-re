package com.kwad.components.offline.api.core.webview;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IBridgeHandler {
    String getKey();

    void handleJsCall(String str);

    void onDestroy();
}
