package com.hihonor.adsdk.interstitial.f;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.BaseAdImpl;
import com.hihonor.adsdk.base.api.interstitial.InterstitialAdLoadListener;
import com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.g.j.d.j1.f;
import com.hihonor.adsdk.base.j.c;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.interstitial.InterstitialExpressAdImpl;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class a extends com.hihonor.adsdk.base.api.b<InterstitialAdLoadListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3535a = "InterstitialAdLoadImpl";

    private void a(final InterstitialExpressAd interstitialExpressAd) {
        a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.interstitial.f.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(interstitialExpressAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(InterstitialExpressAd interstitialExpressAd) {
        if (this.hnadsb != 0) {
            ((InterstitialAdLoadListener) this.hnadsb).onAdLoaded(interstitialExpressAd);
            this.hnadsb = null;
        }
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected void hnadsa(int i, String str, BaseAdInfoResp baseAdInfoResp) {
        Video video;
        BaseAdInfo baseAdInfoHnadsb = hnadsb(baseAdInfoResp);
        a(new InterstitialExpressAdImpl(null, baseAdInfoHnadsb));
        BaseAdImpl baseAdImpl = new BaseAdImpl(baseAdInfoHnadsb);
        if (baseAdImpl.getSubType() == 14 && (video = baseAdImpl.getVideo()) != null) {
            hnadsc(video.getVideoUrl());
        }
        hnadsn();
        a(baseAdInfoResp, baseAdInfoHnadsb.getAdId());
        AdSlot adSlot = this.hnadsa;
        hnadsa(baseAdInfoResp, adSlot != null ? adSlot.getDataType() : 0);
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected int hnadsb() {
        return 5;
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected boolean hnadsk() {
        com.hihonor.adsdk.common.b.b.hnadsc(f3535a, "isSupportPreCache: false", new Object[0]);
        return false;
    }

    private void a(BaseAdInfoResp baseAdInfoResp, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        String strHnadsa = c.hnadsa(baseAdInfoResp);
        String strHnadsb = c.hnadsb(baseAdInfoResp);
        com.hihonor.adsdk.base.bean.b bVarHnadsb = hnadsb(strHnadsa);
        new f(bVarHnadsb, arrayList, strHnadsa, com.hihonor.adsdk.base.g.j.g.b.hnadsa(bVarHnadsb, strHnadsb)).hnadse();
    }
}
