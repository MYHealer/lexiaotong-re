package com.hihonor.adsdk.interstitial.g;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.common.f.k;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.interstitial.R;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends a {
    private static final String o = "InterstitialTextAreaTemplateThree";

    @Override // com.hihonor.adsdk.interstitial.g.a
    public void a(Context context, BaseAd baseAd, boolean z, View view) {
        super.a(context, baseAd, z, view);
        if (u.hnadsk()) {
            view.setBackground(k.hnadsa(context, R.drawable.honor_ads_radius_bg_left));
        } else {
            view.setBackground(k.hnadsa(context, R.drawable.honor_ads_radius_bg_right));
        }
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public void a(FrameLayout frameLayout, View view) {
        int iB;
        int i;
        super.a(frameLayout, view);
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize mBaseAd is null", new Object[0]);
            return;
        }
        float fD = com.hihonor.adsdk.interstitial.e.d(this.b);
        if (j.hnadsl() && !j.hnadsj()) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is foldingScreenFull", new Object[0]);
            iB = (((com.hihonor.adsdk.interstitial.e.b() * 70) / 100) * 50) / 100;
        } else if (j.hnadsf(HnAds.get().getContext())) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is pad", new Object[0]);
            iB = (((com.hihonor.adsdk.interstitial.e.b() * 60) / 100) * 50) / 100;
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is phone", new Object[0]);
            if (com.hihonor.adsdk.interstitial.e.h(this.b)) {
                int iA = (com.hihonor.adsdk.interstitial.e.a() * 80) / 100;
                iB = (int) (iA * fD);
                i = iA;
            } else {
                iB = (((com.hihonor.adsdk.interstitial.e.b() * 90) / 100) * 50) / 100;
            }
            a(frameLayout, i);
            b(frameLayout, iB);
        }
        i = (int) (iB / fD);
        a(frameLayout, i);
        b(frameLayout, iB);
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public int a(BaseAd baseAd) {
        if (com.hihonor.adsdk.interstitial.e.f(baseAd)) {
            return R.layout.honor_ads_interstitial_template_two_or_three_picture_text_download;
        }
        return R.layout.honor_ads_interstitial_template_two_or_three_picture_text_non_download;
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public FrameLayout.LayoutParams a() {
        return new FrameLayout.LayoutParams(-1, -1);
    }
}
