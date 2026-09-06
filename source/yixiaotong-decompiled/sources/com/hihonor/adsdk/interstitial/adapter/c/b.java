package com.hihonor.adsdk.interstitial.adapter.c;

import android.app.Activity;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.common.video.AdVideoSize;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends a {
    private static final String F = "InterstitialVideoTemplateFourAdapter";

    private Boolean[] A() {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        return new Boolean[]{bool, bool, bool2, bool2};
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a, com.hihonor.adsdk.interstitial.adapter.a
    public void a(BaseAd baseAd, Activity activity) {
        super.a(baseAd, activity);
        l();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    public void k() {
        super.k();
        r();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    protected void n() {
        int iB;
        int iA;
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "initVideoLayout mContext is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.h)) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "initVideoLayout adPlayerView is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.i)) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "initVideoLayout mVideo is null", new Object[0]);
            return;
        }
        AdVideoSize adVideoSize = new AdVideoSize(this.i.getVideoWidth(), this.i.getVideoHeight());
        float fE = com.hihonor.adsdk.interstitial.e.e(this.f3528a);
        this.h.setPlayerViewCornersByPortrait(12);
        this.h.setPartCornerRadius(A());
        if (j.hnadsl() && !j.hnadsj()) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "setAdVideoLayoutSize device is foldingScreenFull", new Object[0]);
            iB = (com.hihonor.adsdk.interstitial.e.b() * 70) / 100;
            iA = (int) (iB / fE);
            this.h.setVideoViewSize(adVideoSize, 1, iB);
        } else if (j.hnadsf(HnAds.get().getContext())) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "setAdVideoLayoutSize device is pad", new Object[0]);
            iB = (com.hihonor.adsdk.interstitial.e.b() * 60) / 100;
            iA = (int) (iB / fE);
            this.h.setVideoViewSize(adVideoSize, 1, iB);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "setAdVideoLayoutSize device is phone", new Object[0]);
            if (com.hihonor.adsdk.interstitial.e.h(this.f3528a)) {
                iA = ((com.hihonor.adsdk.interstitial.e.a() * 4) / 5) - a();
                iB = (int) (iA * fE);
                this.h.setVideoViewSize(adVideoSize, 2, iA);
            } else {
                iB = (com.hihonor.adsdk.interstitial.e.b() * 9) / 10;
                iA = (int) (iB / fE);
                this.h.setVideoViewSize(adVideoSize, 1, iB);
            }
        }
        a(this.d, iB, iA);
        j();
        c();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    protected void x() {
        v();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.c.a
    public void a(long j, long j2, long j3) {
        super.a(j, j2, j3);
        c(j, j2, j3);
    }
}
