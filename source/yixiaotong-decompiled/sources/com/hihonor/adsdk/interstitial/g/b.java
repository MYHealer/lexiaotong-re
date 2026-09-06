package com.hihonor.adsdk.interstitial.g;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.common.f.k;
import com.hihonor.adsdk.interstitial.R;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends a {
    private static final String o = "InterstitialTextAreaTemplateFour";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(View view) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "laterSetAdTextAreaSize textAreaView is null", new Object[0]);
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ad_six_elements_layout);
        TextView textView = (TextView) view.findViewById(R.id.ad_company_name);
        if (Objects.isNull(linearLayout) || Objects.isNull(textView)) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "laterSetAdTextAreaSize adSixElementsLayout is null or adCompanyName is null", new Object[0]);
        } else {
            textView.setMaxWidth(linearLayout.getWidth() / 2);
        }
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public void a(Context context, BaseAd baseAd, boolean z, View view) {
        super.a(context, baseAd, z, view);
        view.setBackground(k.hnadsa(context, R.drawable.honor_ads_radius_bg_bottom));
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public void a(FrameLayout frameLayout, final View view) {
        int iB;
        super.a(frameLayout, view);
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize mBaseAd is null", new Object[0]);
            return;
        }
        float fD = com.hihonor.adsdk.interstitial.e.d(this.b);
        if (j.hnadsl() && !j.hnadsj()) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is foldingScreenFull", new Object[0]);
            iB = (com.hihonor.adsdk.interstitial.e.b() * 70) / 100;
        } else if (j.hnadsf(HnAds.get().getContext())) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is pad", new Object[0]);
            iB = (com.hihonor.adsdk.interstitial.e.b() * 60) / 100;
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize device is phone", new Object[0]);
            if (com.hihonor.adsdk.interstitial.e.h(this.b)) {
                com.hihonor.adsdk.common.b.b.hnadsc(o, "setAdTextAreaSize screen is land", new Object[0]);
                iB = (int) ((((com.hihonor.adsdk.interstitial.e.a() * 4) / 5) - frameLayout.getHeight()) * fD);
            } else {
                iB = (com.hihonor.adsdk.interstitial.e.b() * 9) / 10;
            }
        }
        b(frameLayout, iB);
        frameLayout.post(new Runnable() { // from class: com.hihonor.adsdk.interstitial.g.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                b.k(view);
            }
        });
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public int a(BaseAd baseAd) {
        if (com.hihonor.adsdk.interstitial.e.f(baseAd)) {
            return R.layout.honor_ads_interstitial_template_four_picture_text_download;
        }
        return R.layout.honor_ads_interstitial_template_four_picture_text_non_download;
    }

    @Override // com.hihonor.adsdk.interstitial.g.a
    public FrameLayout.LayoutParams a() {
        return super.a();
    }
}
