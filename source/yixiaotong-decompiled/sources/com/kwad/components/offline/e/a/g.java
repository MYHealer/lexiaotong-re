package com.kwad.components.offline.e.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class g implements IOfflineTKCallHandler {
    private final q ayv;

    public g(q qVar) {
        this.ayv = qVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        q qVar = this.ayv;
        if (qVar != null) {
            qVar.callJS(str);
        }
    }
}
