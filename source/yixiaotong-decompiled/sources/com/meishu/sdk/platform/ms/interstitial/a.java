package com.meishu.sdk.platform.ms.interstitial;

import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.meishu_ad.interstitial.c;
import com.meishu.sdk.platform.ms.d;

/* JADX INFO: compiled from: MeishuAdListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements com.meishu.sdk.meishu_ad.interstitial.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.core.ad.interstitial.b f5178a;
    public b b;

    public a(b bVar, com.meishu.sdk.core.ad.interstitial.b bVar2) {
        this.b = bVar;
        this.f5178a = bVar2;
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onADLoaded(c cVar) {
        c cVar2 = cVar;
        com.meishu.sdk.core.ad.interstitial.b bVar = this.f5178a;
        if (bVar != null) {
            MeishuInterstitialAdAdapter meishuInterstitialAdAdapter = new MeishuInterstitialAdAdapter(cVar2, bVar);
            meishuInterstitialAdAdapter.setAdView(cVar2.getAdView());
            this.f5178a.onAdReady(meishuInterstitialAdAdapter);
        }
    }

    @Override // com.meishu.sdk.meishu_ad.m0
    public void onAdRenderFail(String str, int i) {
        if (((com.meishu.sdk.meishu_ad.interstitial.b) this.b.f5177a).getErrorUrl() != null) {
            z.a(((com.meishu.sdk.meishu_ad.interstitial.b) this.b.f5177a).getErrorUrl()[0], Integer.valueOf(i), str);
        }
        com.meishu.sdk.core.ad.interstitial.b bVar = this.f5178a;
        if (bVar != null) {
            bVar.onAdPlatformError(new d(str, Integer.valueOf(i)));
            this.f5178a.onAdRenderFail(str, i);
        }
    }
}
