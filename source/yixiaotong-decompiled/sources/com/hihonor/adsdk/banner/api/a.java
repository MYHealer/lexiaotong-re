package com.hihonor.adsdk.banner.api;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.BaseAdImpl;
import com.hihonor.adsdk.base.api.banner.BannerAdLoadListener;
import com.hihonor.adsdk.base.api.banner.BannerExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.common.f.a0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class a extends com.hihonor.adsdk.base.api.b<BannerAdLoadListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3498a = "BannerAdLoadImpl";

    a() {
    }

    private void a(final BannerExpressAd bannerExpressAd) {
        a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.banner.api.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(bannerExpressAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BannerExpressAd bannerExpressAd) {
        if (this.hnadsb != 0) {
            ((BannerAdLoadListener) this.hnadsb).onLoadSuccess(bannerExpressAd);
            this.hnadsb = null;
        }
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected void hnadsa(int i, String str, BaseAdInfoResp baseAdInfoResp) {
        BannerExpressAd bannerExpressAdImpl;
        com.hihonor.adsdk.common.b.b.hnadsa(f3498a, (Object) ("onAdLoaded#errorCode=" + i));
        if (baseAdInfoResp == null || baseAdInfoResp.getList() == null || baseAdInfoResp.getList().size() < 1) {
            return;
        }
        BaseAdInfo baseAdInfoHnadsb = hnadsb(baseAdInfoResp);
        ArrayList arrayList = new ArrayList();
        if (a()) {
            com.hihonor.adsdk.common.b.b.hnadsc(f3498a, "轮播请求", new Object[0]);
            bannerExpressAdImpl = c.a().a(this.hnadsa.getSlotId());
            if (bannerExpressAdImpl == null) {
                com.hihonor.adsdk.common.b.b.hnadse(f3498a, "bannerExpressAd == null", new Object[0]);
                return;
            } else {
                bannerExpressAdImpl.setBaseAdInfo(baseAdInfoHnadsb);
                if (baseAdInfoHnadsb.getIsCarousel() != 1) {
                    c.a().b(this.hnadsa.getSlotId(), bannerExpressAdImpl);
                }
            }
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(f3498a, "首次请求", new Object[0]);
            bannerExpressAdImpl = new BannerExpressAdImpl(baseAdInfoHnadsb);
            bannerExpressAdImpl.setRenderType(this.hnadsa.getRenderType());
            bannerExpressAdImpl.setWidth(this.hnadsa.getWidth());
            bannerExpressAdImpl.setHeight(this.hnadsa.getHeight());
            arrayList.add(new BaseAdImpl(baseAdInfoHnadsb).getAdId());
            if (baseAdInfoHnadsb.getIsCarousel() == 1) {
                com.hihonor.adsdk.common.b.b.hnadsc(f3498a, "需要轮播，记录对应的信息", new Object[0]);
                c.a().a(this.hnadsa.getSlotId(), this.hnadsa);
                c.a().a(this.hnadsa.getSlotId(), bannerExpressAdImpl);
            }
        }
        a(bannerExpressAdImpl);
        hnadsn();
        a(baseAdInfoResp, arrayList);
        AdSlot adSlot = this.hnadsa;
        hnadsa(baseAdInfoResp, adSlot != null ? adSlot.getDataType() : 0);
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected int hnadsb() {
        return 1;
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected boolean hnadsk() {
        com.hihonor.adsdk.common.b.b.hnadsc(f3498a, "isSupportPreCache: false", new Object[0]);
        return false;
    }

    private void a(BaseAdInfoResp baseAdInfoResp, List<String> list) {
        String strHnadsa = com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp);
        String strHnadsb = com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp);
        com.hihonor.adsdk.base.bean.b bVarHnadsb = hnadsb(strHnadsa);
        new com.hihonor.adsdk.base.g.j.d.j1.f(bVarHnadsb, list, strHnadsa, com.hihonor.adsdk.base.g.j.g.b.hnadsa(bVarHnadsb, strHnadsb)).hnadse();
    }

    private boolean a() {
        AdSlot adSlot = this.hnadsa;
        return adSlot != null && com.hihonor.adsdk.base.b.hnadsa(adSlot) == 1;
    }

    @Override // com.hihonor.adsdk.base.api.b
    protected void hnadsa(String str, String str2, boolean z) {
        super.hnadsa(str, str2, z);
        com.hihonor.adsdk.common.b.b.hnadsc(f3498a, "onFail", new Object[0]);
        if (a()) {
            BannerExpressAd bannerExpressAdA = c.a().a(this.hnadsa.getSlotId());
            if (bannerExpressAdA == null) {
                com.hihonor.adsdk.common.b.b.hnadse(f3498a, "bannerExpressAd == null", new Object[0]);
                return;
            }
            BannerView bannerView = (BannerView) bannerExpressAdA.getExpressAdView();
            if (bannerView == null) {
                com.hihonor.adsdk.common.b.b.hnadse(f3498a, "bannerView is null", new Object[0]);
            } else {
                bannerView.c();
            }
        }
    }
}
