package com.kwad.components.ad.a;

import com.kwad.sdk.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.core.request.a {
    public a(com.kwad.components.core.request.model.a aVar) {
        super(aVar);
        putBody("requestTime", System.currentTimeMillis());
    }

    @Override // com.kwad.components.core.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.EO();
    }
}
