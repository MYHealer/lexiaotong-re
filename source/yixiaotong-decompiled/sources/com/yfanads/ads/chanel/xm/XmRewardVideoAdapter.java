package com.yfanads.ads.chanel.xm;

import android.app.Activity;
import android.content.Context;
import com.cdo.oaps.ad.OapsKey;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.RewardVideoAd;
import com.yfanads.ads.chanel.xm.utils.XmUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class XmRewardVideoAdapter extends RewardCustomAdapter implements RewardVideoAd.RewardVideoLoadListener, RewardVideoAd.RewardVideoInteractionListener {
    private RewardVideoAd rewardVideoAd;

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onVideoPause() {
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onVideoStart() {
    }

    public XmRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        XmUtil.initXm(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.xm.XmRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                XmRewardVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                XmRewardVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.rewardSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        this.rewardVideoAd = new RewardVideoAd();
        ADParams.Builder builder = new ADParams.Builder();
        builder.setUpId(this.sdkSupplier.getPotId());
        this.rewardVideoAd.setMute(this.sdkSupplier.isMute());
        this.rewardVideoAd.loadAd(builder.build(), this);
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(final Activity activity) {
        try {
            if (this.rewardVideoAd == null) {
                return;
            }
            if (isBidding()) {
                this.rewardVideoAd.setPrice(getPrice());
            }
            if (activity == null || activity.isFinishing()) {
                return;
            }
            Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.ads.chanel.xm.XmRewardVideoAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1164lambda$doShowAD$0$comyfanadsadschanelxmXmRewardVideoAdapter(activity);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            handleShowFailed();
        }
    }

    /* JADX INFO: renamed from: lambda$doShowAD$0$com-yfanads-ads-chanel-xm-XmRewardVideoAdapter, reason: not valid java name */
    /* synthetic */ void m1164lambda$doShowAD$0$comyfanadsadschanelxmXmRewardVideoAdapter(Activity activity) {
        this.rewardVideoAd.showAd(activity, this);
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.destroy();
            this.rewardVideoAd = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.XM.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.win(XmUtil.getWinParams(this.sdkSupplier, sdkSupplier));
            String shortString = "";
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.loss(XmUtil.getLossParams(sdkSupplier));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    private long getPrice() {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd == null || (mediaExtraInfo = rewardVideoAd.getMediaExtraInfo()) == null || mediaExtraInfo.isEmpty() || (obj = mediaExtraInfo.get(OapsKey.KEY_PRICE)) == null) {
            return 0L;
        }
        return ((Long) obj).longValue();
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoLoadListener
    public void onAdRequestSuccess() {
        if (this.rewardVideoAd != null) {
            setEcpm(getPrice());
        }
        handleSucceed();
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoLoadListener
    public void onAdLoadSuccess() {
        YFLog.high(this.tag + " onAdLoadSuccess");
        setVideoCached(true);
        handleCached();
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoLoadListener
    public void onAdLoadFailed(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onAdPresent() {
        handleExposure();
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onAdClick() {
        handleClick();
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onAdDismissed() {
        YFLog.debug(" onAdDismissed ");
        handleClose();
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onAdFailed(String str) {
        YFLog.error(this.tag + " onAdFailed, msg:" + str);
        if (isStartShow()) {
            handleRenderFailed();
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onVideoSkip() {
        YFLog.high(this.tag + "onSkippedVideo");
        handleClose(true);
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onVideoComplete() {
        YFLog.high(this.tag + "onVideoComplete");
        handleVideoComplete();
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onPicAdEnd() {
        YFLog.high(this.tag + "onPicAdEnd");
        handleVideoComplete();
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onReward() {
        try {
            YFLog.high(this.tag + " onRewardVerify");
            reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
            YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
            yFRewardServerCallBackInf.rewardInf = new YFRewardServerCallBackInf.RewardInf(YFRewardServerCallBackInf.Type.XM);
            if (this.rewardSetting != null) {
                yFRewardServerCallBackInf.rewardInf.setAppExtra(this.rewardSetting.getAppExtra());
            }
            handleReward(yFRewardServerCallBackInf);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
