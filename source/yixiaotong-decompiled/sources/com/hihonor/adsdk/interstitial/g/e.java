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
public class e extends a {
    private static final String o = "InterstitialTextAreaTemplateTwo";

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
        float fB;
        float fB2;
        super.a(frameLayout, view);
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize mBaseAd is null", new Object[0]);
            return;
        }
        float fD = com.hihonor.adsdk.interstitial.e.d(this.b);
        if (j.hnadsl() && !j.hnadsj()) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is foldingScreenFull", new Object[0]);
            iB = (((com.hihonor.adsdk.interstitial.e.b() * 90) / 100) * 25) / 100;
            fB = com.hihonor.adsdk.interstitial.e.b() * 90.0f;
        } else {
            if (j.hnadsf(HnAds.get().getContext())) {
                com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is pad", new Object[0]);
                iB = (((com.hihonor.adsdk.interstitial.e.b() * 90) / 100) * 30) / 100;
                fB2 = ((com.hihonor.adsdk.interstitial.e.b() * 90.0f) / 100.0f) * 70.0f;
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is phone", new Object[0]);
                iB = (((com.hihonor.adsdk.interstitial.e.b() * 85) / 100) * 25) / 100;
                fB = com.hihonor.adsdk.interstitial.e.b() * 85.0f;
            }
            b(frameLayout, iB);
            a(frameLayout, (int) ((fB2 / 100.0f) / fD));
        }
        fB2 = (fB / 100.0f) * 75.0f;
        b(frameLayout, iB);
        a(frameLayout, (int) ((fB2 / 100.0f) / fD));
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
