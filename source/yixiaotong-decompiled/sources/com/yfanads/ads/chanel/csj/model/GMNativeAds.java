package com.yfanads.ads.chanel.csj.model;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.yfanads.ads.chanel.csj.R;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GMNativeAds extends CsjNativeAds {
    public GMNativeAds(Context context, TTFeedAd tTFeedAd, YFNativeCall yFNativeCall, int i) {
        super(context, tTFeedAd, yFNativeCall, i);
    }

    @Override // com.yfanads.ads.chanel.csj.model.CsjNativeAds, com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        if (this.nativeAd == null || this.nativeAd.getMediationManager() == null || this.nativeAd.getMediationManager().getBestEcpm() == null) {
            return 0;
        }
        return (int) YFUtil.toDouble(this.nativeAd.getMediationManager().getBestEcpm().getEcpm(), 2.0d);
    }

    @Override // com.yfanads.ads.chanel.csj.model.CsjNativeAds
    public String getAdReqId() {
        return getMAdReqId();
    }

    @Override // com.yfanads.ads.chanel.csj.model.CsjNativeAds, com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        int mAdnId = CsjUtil.getMAdnId(this.nativeAd);
        if (mAdnId == 4) {
            return R.mipmap.ad_log_ks_v3;
        }
        if (mAdnId == 3) {
            return R.mipmap.ad_log_bd_v3;
        }
        if (mAdnId == 2) {
            return R.mipmap.ad_log_ylh_v3;
        }
        return R.mipmap.ad_log_csj_v3;
    }
}
