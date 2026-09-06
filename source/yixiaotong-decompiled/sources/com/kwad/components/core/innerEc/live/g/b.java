package com.kwad.components.core.innerEc.live.g;

import com.kwad.components.core.innerEc.f;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCActivityLiveInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class b extends a<PbSCActivityLiveInfo> {
    @Override // com.kwad.components.core.innerEc.live.g.a
    final /* synthetic */ PbSCActivityLiveInfo e(byte[] bArr) {
        return f(bArr);
    }

    private static PbSCActivityLiveInfo f(byte[] bArr) {
        return (PbSCActivityLiveInfo) f.ri().parseFrom(bArr, PbSCActivityLiveInfo.class);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.SCMessageListener
    public int getPayloadType() {
        return f.ri().getPbPayloadType().getScActivityLiveInfo();
    }
}
