package com.yfanads.ads.chanel.in;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ubixnow.adtype.interstital.api.UMNInterstitalAd;
import com.ubixnow.adtype.interstital.api.UMNInterstitalListener;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.bean.UMNAdInfo;
import com.yfanads.ads.chanel.in.utils.INUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class INInterstitialAdapter extends InterstitialCustomAdapter implements UMNInterstitalListener {
    private UMNInterstitalAd interstitialAd;

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
    }

    public INInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.IN.getValue();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            UMNInterstitalAd uMNInterstitalAd = this.interstitialAd;
            if (uMNInterstitalAd != null) {
                uMNInterstitalAd.destroy();
                this.interstitialAd = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + str + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void closeAds(boolean z) {
        release("closeAds");
        super.closeAds(z);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        INUtil.initIN(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.in.INInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                INInterstitialAdapter iNInterstitialAdapter = INInterstitialAdapter.this;
                iNInterstitialAdapter.startLoadAD(iNInterstitialAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(INInterstitialAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                INInterstitialAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        } else {
            loadInterstitialAd(context);
        }
    }

    private void loadInterstitialAd(Context context) {
        int screenWidthDp = (int) ScreenUtil.getScreenWidthDp(context);
        UMNInterstitalAd uMNInterstitalAd = new UMNInterstitalAd(context, new UMNInterstitalParams.Builder().setSlotId(getPotID()).setInterstitalHeight((screenWidthDp * 3) / 2).setInterstitalWidth(screenWidthDp).closeAfterClick(isClickClose()).build(), this);
        this.interstitialAd = uMNInterstitalAd;
        uMNInterstitalAd.loadAd();
    }

    public boolean isClickClose() {
        TemplateConf templateConf = this.sdkSupplier.getTemplateConf();
        return templateConf == null || templateConf.jc == 1;
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        showTemplateADs(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        UMNInterstitalAd uMNInterstitalAd = this.interstitialAd;
        return uMNInterstitalAd != null ? uMNInterstitalAd.getRequestId() : "";
    }

    private void showTemplateADs(Activity activity) {
        if (this.interstitialAd != null) {
            if (activity != null && !activity.isFinishing()) {
                this.interstitialAd.show(activity);
                return;
            } else {
                handleShowFailed(this.tag + " activity is null");
                return;
            }
        }
        handleShowFailed(this.tag + " interstitialAd is null");
    }

    @Override // com.ubixnow.adtype.interstital.api.UMNInterstitalListener
    public void onAdClicked() {
        YFLog.debug(IAdInterListener.AdCommandType.AD_CLICK);
        handleClick();
    }

    @Override // com.ubixnow.adtype.interstital.api.UMNInterstitalListener
    public void onAdDismiss() {
        YFLog.debug("onAdDismiss");
        handleClose();
    }

    @Override // com.ubixnow.adtype.interstital.api.UMNInterstitalListener
    public void onAdExposure() {
        YFLog.debug("onAdShow");
        handleExposure();
    }

    @Override // com.ubixnow.adtype.interstital.api.UMNInterstitalListener
    public void onAdLoadSuccess(UMNAdInfo uMNAdInfo) {
        UMNInterstitalAd uMNInterstitalAd;
        YFLog.debug("onLoadAdSuccess");
        if (uMNAdInfo != null && (uMNInterstitalAd = this.interstitialAd) != null && uMNInterstitalAd.getEcpmInfo() != null) {
            String ecpm = this.interstitialAd.getEcpmInfo().getEcpm();
            if (!TextUtils.isEmpty(ecpm)) {
                setEcpmByStr(ecpm);
            }
        }
        handleSucceed();
    }

    @Override // com.ubixnow.adtype.interstital.api.UMNInterstitalListener
    public void onError(UMNError uMNError) {
        try {
            YFLog.debug("onLoadAdFail " + uMNError.code + "|" + uMNError.msg);
            handleFailed(YFAdError.parseErr(uMNError.code, uMNError.msg));
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.ubixnow.adtype.interstital.api.UMNInterstitalListener
    public void showError(UMNError uMNError) {
        try {
            YFLog.debug("showError " + uMNError.code + "|" + uMNError.msg);
            handleShowFailed();
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }
}
