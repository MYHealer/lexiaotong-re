package com.hihonor.adsdk.interstitial.adapter.c;

import android.app.Activity;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.common.video.AdVideoSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends a {
    private static final String F = "InterstitialVideoTemplateOneAdapter";

    private Boolean[] A() {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        return new Boolean[]{bool, bool, bool2, bool2};
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
        int iA;
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
        this.h.setPlayerViewCornersByPortrait(12);
        this.h.setPartCornerRadius(A());
        if (!j.hnadsl() || j.hnadsj()) {
            if (j.hnadsf(HnAds.get().getContext())) {
                com.hihonor.adsdk.common.b.b.hnadsc(F, "setAdVideoLayoutSize device is pad", new Object[0]);
                iA = ((com.hihonor.adsdk.interstitial.e.a() * 80) / 100) - a();
                dCeil = Math.ceil(iA * fE);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(F, "setAdVideoLayoutSize device is phone", new Object[0]);
                iB = (com.hihonor.adsdk.interstitial.e.b() * 80) / 100;
                iA = (int) (iB / fE);
            }
            this.h.setVideoViewSize(adVideoSize, 1, iB);
            a(this.d, iB, iA);
            j();
        }
        com.hihonor.adsdk.common.b.b.hnadsc(F, "setAdVideoLayoutSize device is foldingScreenFull", new Object[0]);
        iA = ((com.hihonor.adsdk.interstitial.e.a() * 80) / 100) - a();
        dCeil = Math.ceil(iA * fE);
        iB = (int) dCeil;
        this.h.setVideoViewSize(adVideoSize, 1, iB);
        a(this.d, iB, iA);
        j();
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
