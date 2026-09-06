package com.meishu.sdk.platform.oppo.banner;

import android.app.Activity;
import android.view.ViewGroup;
import com.byazt.bv.BaseConstants;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.banner.IBannerAd;
import com.meishu.sdk.core.loader.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPOBannerAd extends a implements IBannerAd {
    public OPPOBannerAd(d dVar) {
        super(dVar, BaseConstants.ROM_OPPO_UPPER_CONSTANT);
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void setCloseButtonVisible(boolean z) {
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void setWidthAndHeight(int i, int i2) {
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        viewGroup.addView(this.adView);
    }

    @Override // com.meishu.sdk.core.ad.banner.IBannerAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        viewGroup.addView(this.adView);
    }
}
