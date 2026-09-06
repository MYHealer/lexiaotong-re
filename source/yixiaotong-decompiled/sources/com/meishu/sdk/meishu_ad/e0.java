package com.meishu.sdk.meishu_ad;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e0 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.interstitial.a f5011a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.interstitial.c b;

    public e0(v vVar, com.meishu.sdk.meishu_ad.interstitial.a aVar, com.meishu.sdk.meishu_ad.interstitial.c cVar) {
        this.f5011a = aVar;
        this.b = cVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        ((com.meishu.sdk.platform.ms.interstitial.a) this.f5011a).onADLoaded(this.b);
    }
}
