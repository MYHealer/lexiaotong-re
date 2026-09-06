package com.hihonor.adsdk.splash.c;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.BaseAdImpl;
import com.hihonor.adsdk.base.api.splash.SplashAdLoadListener;
import com.hihonor.adsdk.base.api.splash.SplashExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.g.j.d.j1.f;
import com.hihonor.adsdk.base.j.c;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.splash.SplashExpressAdImpl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends com.hihonor.adsdk.base.api.b<SplashAdLoadListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3584a = "SplashAdLoadImpl";

    private void a(final SplashExpressAd splashExpressAd) {
        a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.splash.c.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(splashExpressAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(SplashExpressAd splashExpressAd) {
        if (this.hnadsb != 0) {
            ((SplashAdLoadListener) this.hnadsb).onLoadSuccess(splashExpressAd);
            this.hnadsb = null;
        }
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected void hnadsa(int i, String str, BaseAdInfoResp baseAdInfoResp) {
        Video video;
        if (baseAdInfoResp == null || baseAdInfoResp.getList() == null || baseAdInfoResp.getList().size() < 1) {
            return;
        }
        BaseAdInfo baseAdInfoHnadsb = hnadsb(baseAdInfoResp);
        SplashExpressAd splashExpressAdImpl = new SplashExpressAdImpl(baseAdInfoHnadsb, baseAdInfoResp.isCachedData(), hnadsc());
        splashExpressAdImpl.setRenderType(this.hnadsa.getRenderType());
        a(splashExpressAdImpl);
        BaseAdImpl baseAdImpl = new BaseAdImpl(baseAdInfoHnadsb);
        if ((baseAdImpl.getSubType() == 12 || baseAdImpl.getSubType() == 11) && (video = baseAdImpl.getVideo()) != null) {
            hnadsc(video.getVideoUrl());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(baseAdImpl.getAdId());
        a(baseAdInfoResp, arrayList);
        hnadsn();
        AdSlot adSlot = this.hnadsa;
        hnadsa(baseAdInfoResp, adSlot != null ? adSlot.getDataType() : 0);
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected int hnadsb() {
        return 3;
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected boolean hnadsk() {
        com.hihonor.adsdk.common.b.b.hnadsc(f3584a, "isSupportPreCache: true", new Object[0]);
        return true;
    }

    @Override // com.hihonor.adsdk.base.api.b, com.hihonor.adsdk.base.api.IAdLoad
    public void loadAd() {
        super.loadAd();
    }

    private void a(BaseAdInfoResp baseAdInfoResp, List<String> list) {
        String strHnadsa = c.hnadsa(baseAdInfoResp);
        String strHnadsb = c.hnadsb(baseAdInfoResp);
        com.hihonor.adsdk.base.bean.b bVarHnadsb = hnadsb(strHnadsa);
        new f(bVarHnadsb, list, strHnadsa, com.hihonor.adsdk.base.g.j.g.b.hnadsa(bVarHnadsb, strHnadsb)).hnadse();
    }
}
