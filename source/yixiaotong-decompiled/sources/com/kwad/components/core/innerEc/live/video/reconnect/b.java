package com.kwad.components.core.innerEc.live.video.reconnect;

import com.kwad.sdk.i;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends com.kwad.components.core.innerEc.b.a {
    public b(com.kwad.components.core.innerEc.live.base.b bVar, Map<String, String> map) {
        super(map);
        putBody("liveParam", bVar);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.Fl();
    }
}
