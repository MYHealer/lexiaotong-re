package com.yfanads.ads.chanel.csj;

import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.yfanads.ads.chanel.csj.model.CsjNativeAds;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GroMoreNativeAdapter extends CsjNativeAdapter {
    public GroMoreNativeAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
    }

    @Override // com.yfanads.ads.chanel.csj.CsjNativeAdapter, com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }

    @Override // com.yfanads.ads.chanel.csj.CsjNativeAdapter
    protected void updPrice(TTFeedAd tTFeedAd) {
        try {
            this.ecpm = ((long) Double.parseDouble(tTFeedAd.getMediationManager().getBestEcpm().getEcpm())) + "";
            YFLog.high(this.tag + "updPrice ep_" + this.ecpm);
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.yfanads.ads.chanel.csj.CsjNativeAdapter, com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size()) {
            return "";
        }
        YFNativeAd yFNativeAd = this.nativeAds.get(i);
        return yFNativeAd instanceof CsjNativeAds ? ((CsjNativeAds) yFNativeAd).getMAdReqId() : "";
    }
}
