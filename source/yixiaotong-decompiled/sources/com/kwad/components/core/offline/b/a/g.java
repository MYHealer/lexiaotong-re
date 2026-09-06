package com.kwad.components.core.offline.b.a;

import com.kwad.components.offline.api.core.adInnerEc.IFullLive;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.IHostLivePlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class g implements IFullLive {
    @Override // com.kwad.components.offline.api.core.adInnerEc.IFullLive
    public final IHostLivePlayer getAdLivePlayModule(String str) {
        return com.kwad.components.core.innerEc.f.a(com.kwad.sdk.core.c.b.LW().getApplication(), str);
    }
}
