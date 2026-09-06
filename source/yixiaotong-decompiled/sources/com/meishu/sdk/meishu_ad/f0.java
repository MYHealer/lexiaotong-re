package com.meishu.sdk.meishu_ad;

import com.meishu.sdk.core.loader.IAdLoadListener;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f0 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v.c f5013a;

    public f0(v.c cVar) {
        this.f5013a = cVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        v.c cVar = this.f5013a;
        com.meishu.sdk.meishu_ad.nativ.a aVar = cVar.c;
        if (aVar != null) {
            if (cVar.d != 1) {
                aVar.onADLoaded(cVar.e);
            }
            com.meishu.sdk.meishu_ad.nativ.a aVar2 = this.f5013a.c;
            if (aVar2 instanceof com.meishu.sdk.platform.ms.reward.a) {
                com.meishu.sdk.platform.ms.reward.a aVar3 = (com.meishu.sdk.platform.ms.reward.a) aVar2;
                aVar3.getClass();
                Boolean bool = Boolean.TRUE;
                if (bool.equals(null) || bool.equals(aVar3.e)) {
                    return;
                }
                com.meishu.sdk.platform.ms.reward.a aVar4 = (com.meishu.sdk.platform.ms.reward.a) this.f5013a.c;
                aVar4.getClass();
                try {
                    IAdLoadListener iAdLoadListener = aVar4.f5232a;
                    if (iAdLoadListener instanceof com.meishu.sdk.core.ad.reward.a) {
                        ((com.meishu.sdk.core.ad.reward.a) iAdLoadListener).onVideoCached(aVar4.f);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
