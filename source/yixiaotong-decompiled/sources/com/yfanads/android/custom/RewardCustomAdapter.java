package com.yfanads.android.custom;

import android.app.Activity;
import android.view.ViewGroup;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.core.e;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.upload.b;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class RewardCustomAdapter extends BaseChanelAdapter {
    private boolean isVideoCacheFailed;
    private boolean isVideoCached;
    public YFRewardVideoSetting rewardSetting;

    public static class RewardJson {
        public String adID;
        public String adnAdID;
        public String adnAppID;
        public String adnID;
        public String appID;
        public String devID;
        public String extra;

        public RewardJson(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.adID = str;
            this.appID = str2;
            this.adnAdID = str3;
            this.adnAppID = str4;
            this.adnID = str5;
            this.devID = str6;
            this.extra = str7;
        }
    }

    public RewardCustomAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
        this.rewardSetting = yFRewardVideoSetting;
    }

    private void handleSkipClose() {
        try {
            if (this.hasClose) {
                YFLog.high(this.tag + "handleSkipClose already, return.");
                return;
            }
            this.hasClose = true;
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() - this.exposureStartTime);
            YFLog.high(this.tag + " handleSkipClose " + iCurrentTimeMillis);
            boolean z = b.e;
            b.a.f9685a.a(this.sdkSupplier, YFAdsConst.ReportETypeValue.CLOSE.getValue(), iCurrentTimeMillis);
            if (this.rewardSetting != null) {
                YFUtil.switchMainThread("handleSkipClose", new BaseEnsureListener() { // from class: com.yfanads.android.custom.RewardCustomAdapter$$ExternalSyntheticLambda0
                    @Override // com.yfanads.android.callback.BaseEnsureListener
                    public final void ensure() {
                        this.f$0.m1226xab5615d8();
                    }
                });
            }
        } catch (Throwable th) {
            YFLog.error(this.tag + th.getMessage());
        }
    }

    private void notificationApp() {
        if (this.hasCallBack || this.hasCallBackCacheFail) {
            e.a(new StringBuilder(), this.tag, "notificationApp has callback, return.");
            return;
        }
        try {
            YFRewardVideoSetting yFRewardVideoSetting = this.rewardSetting;
            if (yFRewardVideoSetting != null) {
                yFRewardVideoSetting.adapterVideoCached(this.sdkSupplier);
                this.hasCallBack = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void notificationCacheFail() {
        if (this.hasCallBackCacheFail || this.hasCallBack) {
            e.a(new StringBuilder(), this.tag, "notificationCacheFail has callback, return.");
            return;
        }
        try {
            YFRewardVideoSetting yFRewardVideoSetting = this.rewardSetting;
            if (yFRewardVideoSetting != null) {
                yFRewardVideoSetting.adapterVideoCacheFailed(this.sdkSupplier);
                this.hasCallBackCacheFail = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void didSuccess() {
        super.didSuccess();
        YFLog.high(this.tag + "didSuccess isVideoCached " + this.isVideoCached + " isVideoCacheFailed " + this.isVideoCacheFailed);
        if (this.isVideoCached) {
            notificationApp();
        } else if (this.isVideoCacheFailed) {
            notificationCacheFail();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.rewardSetting != null) {
            this.rewardSetting = null;
        }
    }

    public void doShowAD(Activity activity) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        doShowAD(activity);
    }

    public void handleCacheFail() {
        YFLog.high(this.tag + "handleCacheFail didSuccess " + isDidSuccess());
        if (isDidSuccess()) {
            notificationCacheFail();
        }
    }

    public void handleCached() {
        YFLog.high(this.tag + "handleCached didSuccess " + isDidSuccess());
        if (isDidSuccess()) {
            notificationApp();
        }
    }

    public void handleClose(boolean z) {
        if (z) {
            handleSkipClose();
        } else {
            handleClose();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    public boolean isVideoCached() {
        return this.isVideoCached;
    }

    /* JADX INFO: renamed from: lambda$handleSkipClose$0$com-yfanads-android-custom-RewardCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1226xab5615d8() {
        this.rewardSetting.adapterVideoSkipped(this.sdkSupplier);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFRewardVideoSetting) {
            this.rewardSetting = (YFRewardVideoSetting) baseAdapterEvent;
        }
    }

    public void setVideoCacheFailed(boolean z) {
        this.isVideoCacheFailed = z;
    }

    public void setVideoCached(boolean z) {
        this.isVideoCached = z;
    }

    public int getOrientation() {
        YFRewardVideoSetting yFRewardVideoSetting = this.rewardSetting;
        if (yFRewardVideoSetting != null) {
            return yFRewardVideoSetting.getOrientation();
        }
        return 1;
    }

    public String getUserId() {
        Map<String, Object> appExtra;
        YFRewardVideoSetting yFRewardVideoSetting = this.rewardSetting;
        return (yFRewardVideoSetting == null || (appExtra = yFRewardVideoSetting.getAppExtra()) == null) ? "" : (String) appExtra.get(YFAdsConst.USER_KEY);
    }

    public void handleReward(YFRewardServerCallBackInf yFRewardServerCallBackInf) {
        YFRewardVideoSetting yFRewardVideoSetting = this.rewardSetting;
        if (yFRewardVideoSetting != null) {
            yFRewardVideoSetting.postRewardServerInf(yFRewardServerCallBackInf, this.sdkSupplier);
        }
    }

    public void handleVideoComplete() {
        try {
            YFRewardVideoSetting yFRewardVideoSetting = this.rewardSetting;
            if (yFRewardVideoSetting != null) {
                yFRewardVideoSetting.adapterVideoComplete(this.sdkSupplier);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getJsonStr() {
        String json;
        try {
            YFRewardVideoSetting yFRewardVideoSetting = this.rewardSetting;
            if (yFRewardVideoSetting != null) {
                json = new GsonBuilder().create().toJson(yFRewardVideoSetting.getAppExtra());
            } else {
                json = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return new GsonBuilder().create().toJson(new RewardJson(this.sdkSupplier.getAdId(), YFAdsManager.getInstance().getYFAdsConfig().getAppId(), this.sdkSupplier.getAdnAdId(), this.sdkSupplier.getAdnAppId(), this.sdkSupplier.getAdnId(), YFAdsPhone.getInstance().getDeviceId(), json));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
