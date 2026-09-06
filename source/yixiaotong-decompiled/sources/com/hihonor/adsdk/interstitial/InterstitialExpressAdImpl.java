package com.hihonor.adsdk.interstitial;

import android.app.Activity;
import com.hihonor.adsdk.base.api.BaseExpressAdImpl;
import com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.widget.base.BaseAdView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InterstitialExpressAdImpl extends BaseExpressAdImpl implements InterstitialExpressAd {
    public InterstitialExpressAdImpl(BaseAdView baseAdView, BaseAdInfo baseAdInfo) {
        super(baseAdView, baseAdInfo);
    }

    private void a(String str) {
        new com.hihonor.adsdk.base.g.j.d.i1.a(str, com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd)).hnadsa("type", "3").hnadsa(com.hihonor.adsdk.base.g.j.e.a.R0, "0").hnadse();
    }

    @Override // com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd
    public void show(Activity activity) {
        BaseAdInfo baseAdInfo = this.hnadsd;
        a(baseAdInfo == null ? "" : baseAdInfo.getAdUnitId());
        InterstitialActivity.a(getAdListener());
        InterstitialActivity.a(activity, this);
    }
}
