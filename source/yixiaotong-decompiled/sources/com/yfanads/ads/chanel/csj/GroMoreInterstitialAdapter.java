package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.content.Context;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GroMoreInterstitialAdapter extends CsjInterstitialAdapter {
    public GroMoreInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.ads.chanel.csj.CsjInterstitialAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initGroMore(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                if (GroMoreInterstitialAdapter.this.interTemplateData == null) {
                    GroMoreInterstitialAdapter.this.interTemplateData = new InterTemplateData(context, "", GroMoreInterstitialAdapter.this.sdkSupplier.getTemplateConf());
                }
                GroMoreInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                GroMoreInterstitialAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.ads.chanel.csj.CsjInterstitialAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (context instanceof Activity) {
            super.startLoadAD(context);
        } else {
            YFLog.error(this.tag + " groMore context " + context);
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_CSJ_CONTEXT));
        }
    }

    @Override // com.yfanads.ads.chanel.csj.CsjInterstitialAdapter, com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }

    @Override // com.yfanads.ads.chanel.csj.CsjInterstitialAdapter
    protected void updPrice() {
        try {
            if (isNative()) {
                if (this.nativeAds != null && this.nativeAds.getMediationManager() != null && this.nativeAds.getMediationManager().getBestEcpm() != null) {
                    this.ecpm = ((long) Double.parseDouble(this.nativeAds.getMediationManager().getBestEcpm().getEcpm())) + "";
                    YFLog.high(this.tag + "updPrice ep_" + this.ecpm);
                }
            } else if (this.newVersionAd != null && this.newVersionAd.getMediationManager() != null && this.newVersionAd.getMediationManager().getBestEcpm() != null) {
                this.ecpm = ((long) Double.parseDouble(this.newVersionAd.getMediationManager().getBestEcpm().getEcpm())) + "";
                YFLog.high(this.tag + "updPrice ep_" + this.ecpm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.ads.chanel.csj.CsjInterstitialAdapter, com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isNative()) {
            return this.nativeAds != null ? CsjUtil.getMReqId(this.nativeAds.getMediationManager().getBestEcpm()) : "";
        }
        return this.newVersionAd != null ? CsjUtil.getMReqId(this.newVersionAd.getMediationManager().getBestEcpm()) : "";
    }
}
