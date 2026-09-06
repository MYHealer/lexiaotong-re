package com.hihonor.adsdk.interstitial.adapter.c;

import android.app.Activity;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.video.AdVideoSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends a {
    private static final String F = "InterstitialVideoTemplateTwoAdapter";

    private Boolean[] A() {
        if (u.hnadsk()) {
            Boolean bool = Boolean.FALSE;
            Boolean bool2 = Boolean.TRUE;
            return new Boolean[]{bool, bool2, bool2, bool};
        }
        Boolean bool3 = Boolean.TRUE;
        Boolean bool4 = Boolean.FALSE;
        return new Boolean[]{bool3, bool4, bool4, bool3};
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    public void a(long j, long j2, long j3) {
        super.a(j, j2, j3);
        b(j, j2, j3);
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    protected void i() {
        super.i();
        u();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    public void k() {
        super.k();
        q();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    protected void n() {
        int iB;
        double dCeil;
        if (this.b == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "initVideoLayout mContext is null", new Object[0]);
            return;
        }
        if (this.h == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "initVideoLayout adPlayerView is null", new Object[0]);
            return;
        }
        AdVideoSize adVideoSize = new AdVideoSize(this.i.getVideoWidth(), this.i.getVideoHeight());
        float fE = com.hihonor.adsdk.interstitial.e.e(this.f3528a);
        this.h.setPlayerViewCornersByLand(12);
        this.h.setPartCornerRadius(A());
        if (j.hnadsl() && !j.hnadsj()) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "setAdVideoLayoutSize device is foldingScreenFull", new Object[0]);
            iB = (((com.hihonor.adsdk.interstitial.e.b() * 90) / 100) * 75) / 100;
            dCeil = Math.ceil(iB / fE);
        } else if (j.hnadsf(HnAds.get().getContext())) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "setAdVideoLayoutSize device is pad", new Object[0]);
            iB = (((com.hihonor.adsdk.interstitial.e.b() * 90) / 100) * 70) / 100;
            dCeil = Math.ceil(iB / fE);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "setAdVideoLayoutSize device is phone", new Object[0]);
            iB = (((com.hihonor.adsdk.interstitial.e.b() * 85) / 100) * 75) / 100;
            dCeil = Math.ceil(iB / fE);
        }
        int i = (int) dCeil;
        this.h.setVideoViewSize(adVideoSize, 2, i);
        a(this.d, iB, i);
        j();
        c();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    public void s() {
        super.s();
        t();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    protected void x() {
        w();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    protected void y() {
        z();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a, com.hihonor.adsdk.interstitial.adapter.a
    public void a(BaseAd baseAd, Activity activity) {
        super.a(baseAd, activity);
        m();
    }
}
