package com.kwad.components.offline.e.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f implements IOfflineCompoTKBridgeHandler {
    private final com.kwad.sdk.core.webview.c.g ayu;

    f(com.kwad.sdk.core.webview.c.g gVar) {
        this.ayu = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.c.g gVar = this.ayu;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }
}
