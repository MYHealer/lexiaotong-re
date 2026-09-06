package com.hihonor.adsdk.interstitial.g;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.common.f.k;
import com.hihonor.adsdk.interstitial.R;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends a {
    private static final String o = "InterstitialTextAreaTemplateOne";

    @Override // com.hihonor.adsdk.interstitial.g.a
    public void a(Context context, BaseAd baseAd, boolean z, View view) {
        super.a(context, baseAd, z, view);
        view.setBackground(k.hnadsa(context, R.drawable.honor_ads_radius_bg_bottom));
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public void a(FrameLayout frameLayout, View view) {
        int iB;
        double dCeil;
        super.a(frameLayout, view);
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize mBaseAd is null", new Object[0]);
            return;
        }
        float fD = com.hihonor.adsdk.interstitial.e.d(this.b);
        if (j.hnadsl() && !j.hnadsj()) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is foldingScreenFull", new Object[0]);
            dCeil = Math.ceil((((com.hihonor.adsdk.interstitial.e.a() * 80) / 100) - frameLayout.getHeight()) * fD);
        } else {
            if (j.hnadsf(HnAds.get().getContext())) {
                com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is pad", new Object[0]);
                dCeil = Math.ceil((((com.hihonor.adsdk.interstitial.e.a() * 80) / 100) - frameLayout.getHeight()) * fD);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is phone", new Object[0]);
                iB = (com.hihonor.adsdk.interstitial.e.b() * 80) / 100;
            }
            b(frameLayout, iB);
        }
        iB = (int) dCeil;
        b(frameLayout, iB);
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public int a(BaseAd baseAd) {
        if (com.hihonor.adsdk.interstitial.e.f(baseAd)) {
            return R.layout.honor_ads_interstitial_template_one_picture_text_download;
        }
        return R.layout.honor_ads_interstitial_template_one_picture_text_non_download;
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public FrameLayout.LayoutParams a() {
        return super.a();
    }
}
