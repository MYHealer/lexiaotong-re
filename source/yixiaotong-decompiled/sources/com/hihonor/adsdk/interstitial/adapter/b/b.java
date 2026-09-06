package com.hihonor.adsdk.interstitial.adapter.b;

import android.app.Activity;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.j.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends a {
    private static final String j = "InterstitialImageTemplateFourAdapter";

    @Override // com.hihonor.adsdk.interstitial.adapter.b.a, com.hihonor.adsdk.interstitial.adapter.a
    public void a(BaseAd baseAd, Activity activity) {
        super.a(baseAd, activity);
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.b.a
    protected Boolean[] j() {
        com.hihonor.adsdk.common.b.b.hnadsc(j, "getPartCornerRadius", new Object[0]);
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        return new Boolean[]{bool, bool, bool2, bool2};
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.b.a
    protected void m() {
        super.m();
        l();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.b.a
    protected void n() {
        int iB;
        int i;
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
        if (j.hnadsl() && !j.hnadsj()) {
            com.hihonor.adsdk.common.b.b.hnadsc(j, "setViewLoadImage device is foldingScreenFull", new Object[0]);
            iB = (com.hihonor.adsdk.interstitial.e.b() * 70) / 100;
        } else {
            if (!j.hnadsf(HnAds.get().getContext())) {
                com.hihonor.adsdk.common.b.b.hnadsc(j, "setViewLoadImage device is phone", new Object[0]);
                if (com.hihonor.adsdk.interstitial.e.h(this.f3528a)) {
                    int iA = ((com.hihonor.adsdk.interstitial.e.a() * 4) / 5) - a();
                    iB = (int) (iA * fC);
                    i = iA;
                } else {
                    iB = (com.hihonor.adsdk.interstitial.e.b() * 9) / 10;
                }
                a(this.h, iB, i);
                a(this.b, this.f3528a.getImages(), 0, this.h, this.f3528a.getTrackUrl());
                c();
            }
            com.hihonor.adsdk.common.b.b.hnadsc(j, "setViewLoadImage device is pad", new Object[0]);
            iB = (com.hihonor.adsdk.interstitial.e.b() * 60) / 100;
        }
        i = (int) (iB / fC);
        a(this.h, iB, i);
        a(this.b, this.f3528a.getImages(), 0, this.h, this.f3528a.getTrackUrl());
        c();
    }
}
