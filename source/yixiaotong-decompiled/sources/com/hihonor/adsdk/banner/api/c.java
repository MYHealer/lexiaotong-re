package com.hihonor.adsdk.banner.api;

import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.api.banner.BannerAdLoadListener;
import com.hihonor.adsdk.base.api.banner.BannerExpressAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String c = "BannerRefresh";
    private static volatile c d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, AdSlot> f3500a = new HashMap();
    private final Map<String, BannerExpressAd> b = new HashMap();

    class a implements BannerAdLoadListener {
        a() {
        }

        @Override // com.hihonor.adsdk.base.callback.BaseListener
        public void onFailed(String str, String str2) {
            com.hihonor.adsdk.common.b.b.hnadsc(c.c, "轮播失败", new Object[0]);
        }

        @Override // com.hihonor.adsdk.base.api.banner.BannerAdLoadListener
        public void onLoadSuccess(BannerExpressAd bannerExpressAd) {
            com.hihonor.adsdk.common.b.b.hnadsc(c.c, "轮播成功", new Object[0]);
            bannerExpressAd.refresh();
        }
    }

    public AdSlot b(String str) {
        return this.f3500a.get(str);
    }

    public void c(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(c, "startRefresh:" + str, new Object[0]);
        AdSlot adSlotB = b(str);
        if (adSlotB == null) {
            com.hihonor.adsdk.common.b.b.hnadse(c, "startRefresh AdSlot is null", new Object[0]);
        } else {
            new InnerBannerAdLoad.Builder().setBannerAdLoadListener(new a()).setAdSlot(adSlotB).build().loadAd();
        }
    }

    public static c a() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    public void b(String str, BannerExpressAd bannerExpressAd) {
        com.hihonor.adsdk.common.b.b.hnadsc(c, "release", new Object[0]);
        BannerExpressAd bannerExpressAd2 = this.b.get(str);
        if (bannerExpressAd == null || !bannerExpressAd.equals(bannerExpressAd2)) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(c, "find expressAd", new Object[0]);
        this.f3500a.remove(str);
        this.b.remove(str);
    }

    public void a(String str, AdSlot adSlot) {
        this.f3500a.put(str, adSlot);
    }

    public void a(String str, BannerExpressAd bannerExpressAd) {
        this.b.put(str, bannerExpressAd);
    }

    public BannerExpressAd a(String str) {
        return this.b.get(str);
    }
}
