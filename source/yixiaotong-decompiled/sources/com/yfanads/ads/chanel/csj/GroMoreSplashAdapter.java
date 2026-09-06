package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.SplashTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GroMoreSplashAdapter extends CsjSplashAdapter {
    public GroMoreSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
    }

    @Override // com.yfanads.ads.chanel.csj.CsjSplashAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        Log.d(this.tag, " start to doLoadAD -");
        CsjUtil.initGroMore(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                Log.d(GroMoreSplashAdapter.this.tag, " init success to doLoadAD");
                if (GroMoreSplashAdapter.this.splashTemplateData == null) {
                    GroMoreSplashAdapter.this.splashTemplateData = new SplashTemplateData("", GroMoreSplashAdapter.this.mSplashSetting == null || GroMoreSplashAdapter.this.isFullScreen());
                    if (GroMoreSplashAdapter.this.sdkSupplier != null) {
                        GroMoreSplashAdapter.this.splashTemplateData.setConf(GroMoreSplashAdapter.this.sdkSupplier.getTemplateConf());
                    }
                }
                GroMoreSplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                GroMoreSplashAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (context instanceof Activity) {
            super.startLoadAD(context);
        } else {
            YFLog.error(this.tag + " groMore context " + context);
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_CSJ_CONTEXT));
        }
    }

    @Override // com.yfanads.ads.chanel.csj.CsjSplashAdapter
    protected void updPrice() {
        super.updPrice();
        try {
            if (this.splashAd == null || this.splashAd.getMediationManager() == null || this.splashAd.getMediationManager().getBestEcpm() == null) {
                return;
            }
            this.ecpm = ((long) Double.parseDouble(this.splashAd.getMediationManager().getBestEcpm().getEcpm())) + "";
            YFLog.high(this.tag + "updPrice ep_" + this.ecpm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.ads.chanel.csj.CsjSplashAdapter, com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        return this.splashAd != null ? CsjUtil.getMReqId(this.splashAd.getMediationManager().getBestEcpm()) : "";
    }

    @Override // com.yfanads.ads.chanel.csj.CsjSplashAdapter, com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }
}
