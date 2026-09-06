package com.kwad.components.core.innerEc.live.config.net;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class h extends com.kwad.components.core.innerEc.b.a {
    public h(com.kwad.components.core.innerEc.live.base.b bVar, Map<String, String> map) {
        super(map);
        putBody("liveParam", bVar);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.i.Fj();
    }
}
