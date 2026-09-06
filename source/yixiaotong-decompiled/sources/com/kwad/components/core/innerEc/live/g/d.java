package com.kwad.components.core.innerEc.live.g;

import com.kwad.components.core.innerEc.f;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbKwaishopResourceLivePendantInfo;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCKwaishopResourceLivePendantSignalData;
import com.kwad.sdk.utils.br;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class d extends a<PbSCKwaishopResourceLivePendantSignalData> {
    protected final com.kwad.components.core.innerEc.live.b.a.b Ub;

    protected abstract void a(com.kwad.components.core.innerEc.live.f.a aVar);

    @Override // com.kwad.components.core.innerEc.live.g.a
    final /* synthetic */ PbSCKwaishopResourceLivePendantSignalData e(byte[] bArr) {
        return h(bArr);
    }

    public d(com.kwad.components.core.innerEc.live.b.a.b bVar) {
        this.Ub = bVar;
    }

    private boolean aO(String str) {
        return br.isEquals(com.kwad.components.core.innerEc.live.i.e.aM(this.Ub.mAdTemplate), str);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.SCMessageListener
    public int getPayloadType() {
        try {
            return f.ri().getPbPayloadType().getScKwaishopResourceLivePendantSignalData();
        } catch (Exception unused) {
            return 960;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.innerEc.live.g.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void g(PbSCKwaishopResourceLivePendantSignalData pbSCKwaishopResourceLivePendantSignalData) {
        List<PbKwaishopResourceLivePendantInfo> pendantInfo;
        com.kwad.sdk.core.d.c.d("SCLiveShopStateMessage", "SC_LIVE_SHOP_STATE onMessageReceived");
        if (aO(pbSCKwaishopResourceLivePendantSignalData.getLiveStreamId()) && (pendantInfo = pbSCKwaishopResourceLivePendantSignalData.getPendantInfo()) != null) {
            com.kwad.components.core.innerEc.live.f.a aVar = new com.kwad.components.core.innerEc.live.f.a();
            aVar.liveStreamId = pbSCKwaishopResourceLivePendantSignalData.getLiveStreamId();
            aVar.Xt = String.valueOf(pbSCKwaishopResourceLivePendantSignalData.getSellerId());
            ArrayList arrayList = new ArrayList();
            for (PbKwaishopResourceLivePendantInfo pbKwaishopResourceLivePendantInfo : pendantInfo) {
                if (pbKwaishopResourceLivePendantInfo != null) {
                    com.kwad.components.core.innerEc.live.f.b bVar = new com.kwad.components.core.innerEc.live.f.b();
                    bVar.Xv = pbKwaishopResourceLivePendantInfo.getAreaCode();
                    bVar.Xw = pbKwaishopResourceLivePendantInfo.getPendantResourceId();
                    bVar.Xx = pbKwaishopResourceLivePendantInfo.getPendantCode();
                    bVar.action = pbKwaishopResourceLivePendantInfo.getAction();
                    bVar.Xy = pbKwaishopResourceLivePendantInfo.getEventData();
                    bVar.Xz = pbKwaishopResourceLivePendantInfo.getThroughInfo();
                    bVar.XA = pbKwaishopResourceLivePendantInfo.isNeedServerProcess();
                    bVar.XB = pbKwaishopResourceLivePendantInfo.isNeedBusinessHandle();
                    bVar.XC = pbKwaishopResourceLivePendantInfo.getCallbackApi();
                    bVar.XD = pbKwaishopResourceLivePendantInfo.isNeedRandomCall();
                    bVar.XE = pbKwaishopResourceLivePendantInfo.getRandomRangeMillis();
                    bVar.XF = pbKwaishopResourceLivePendantInfo.isNeedSignalFallback();
                    bVar.XG = pbKwaishopResourceLivePendantInfo.getCallbackPath();
                    arrayList.add(bVar);
                }
            }
            aVar.Xu = arrayList;
            if (arrayList.isEmpty()) {
                return;
            }
            a(aVar);
        }
    }

    private static PbSCKwaishopResourceLivePendantSignalData h(byte[] bArr) {
        return (PbSCKwaishopResourceLivePendantSignalData) f.ri().parseFrom(bArr, PbSCKwaishopResourceLivePendantSignalData.class);
    }
}
