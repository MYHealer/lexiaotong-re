package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    public static b MD() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null && hVar.FP()) {
            return new d();
        }
        return new a();
    }
}
