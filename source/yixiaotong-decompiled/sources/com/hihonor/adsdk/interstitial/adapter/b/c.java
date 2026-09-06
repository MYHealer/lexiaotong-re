package com.hihonor.adsdk.interstitial.adapter.b;

import android.app.Activity;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.j.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends a {
    private static final String j = "InterstitialImageTemplateOneAdapter";

    @Override // com.hihonor.adsdk.interstitial.adapter.b.a, com.hihonor.adsdk.interstitial.adapter.a
    public void a(BaseAd baseAd, Activity activity) {
        super.a(baseAd, activity);
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.b.a
    protected Boolean[] j() {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        return new Boolean[]{bool, bool, bool2, bool2};
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.b.a
    protected void m() {
        super.m();
        k();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.b.a
    protected void n() {
        int i;
        int i2;
        int iA;
        int iA2;
        if (this.b == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(j, "setViewLoadImage mContext is null", new Object[0]);
            return;
        }
        BaseAd baseAd = this.f3528a;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(j, "setViewLoadImage mBaseAd is null", new Object[0]);
            return;
        }
        float fC = com.hihonor.adsdk.interstitial.e.c(baseAd);
        if (!j.hnadsl() || j.hnadsj()) {
            if (j.hnadsf(HnAds.get().getContext())) {
                com.hihonor.adsdk.common.b.b.hnadsc(j, "setViewLoadImage device is pad", new Object[0]);
                iA = (com.hihonor.adsdk.interstitial.e.a() * 80) / 100;
                iA2 = a();
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(j, "setViewLoadImage device is phone", new Object[0]);
                int iB = (com.hihonor.adsdk.interstitial.e.b() * 80) / 100;
                i = (int) (iB / fC);
                i2 = iB;
            }
            a(this.d, i2, i);
            a(this.h, i2, i);
            a(this.b, this.f3528a.getImages(), 0, this.h, this.f3528a.getTrackUrl());
        }
        com.hihonor.adsdk.common.b.b.hnadsc(j, "setViewLoadImage device is foldingScreenFull", new Object[0]);
        iA = (com.hihonor.adsdk.interstitial.e.a() * 80) / 100;
        iA2 = a();
        i = iA - iA2;
        i2 = (int) (i * fC);
        a(this.d, i2, i);
        a(this.h, i2, i);
        a(this.b, this.f3528a.getImages(), 0, this.h, this.f3528a.getTrackUrl());
    }
}
