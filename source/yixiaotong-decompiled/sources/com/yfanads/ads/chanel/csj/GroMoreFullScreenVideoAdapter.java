package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.content.Context;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GroMoreFullScreenVideoAdapter extends CsjFullScreenVideoAdapter {
    public GroMoreFullScreenVideoAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
    }

    @Override // com.yfanads.ads.chanel.csj.CsjFullScreenVideoAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initGroMore(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreFullScreenVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                GroMoreFullScreenVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                GroMoreFullScreenVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.ads.chanel.csj.CsjFullScreenVideoAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (context instanceof Activity) {
            super.startLoadAD(context);
        } else {
            YFLog.error(this.tag + " groMore context " + context);
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_CSJ_CONTEXT));
        }
    }

    @Override // com.yfanads.ads.chanel.csj.CsjFullScreenVideoAdapter
    protected void updPrice() {
        super.updPrice();
        try {
            if (this.ttFullScreenVideoAd == null || this.ttFullScreenVideoAd.getMediationManager() == null || this.ttFullScreenVideoAd.getMediationManager().getBestEcpm() == null) {
                return;
            }
            this.ecpm = ((long) Double.parseDouble(this.ttFullScreenVideoAd.getMediationManager().getBestEcpm().getEcpm())) + "";
            YFLog.high(this.tag + "updPrice ep_" + this.ecpm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.ads.chanel.csj.CsjFullScreenVideoAdapter, com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        return this.ttFullScreenVideoAd != null ? CsjUtil.getMReqId(this.ttFullScreenVideoAd.getMediationManager().getBestEcpm()) : "";
    }

    @Override // com.yfanads.ads.chanel.csj.CsjFullScreenVideoAdapter, com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }
}
