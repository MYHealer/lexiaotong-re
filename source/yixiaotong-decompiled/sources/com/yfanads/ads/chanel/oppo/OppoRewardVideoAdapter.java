package com.yfanads.ads.chanel.oppo;

import android.app.Activity;
import android.content.Context;
import com.google.android.exoplayer2.C;
import com.heytap.msp.mobad.api.ad.RewardVideoAd;
import com.heytap.msp.mobad.api.listener.IRewardVideoAdListener;
import com.heytap.msp.mobad.api.params.RewardVideoAdParams;
import com.yfanads.ads.chanel.oppo.utls.OppoUtil;
import com.yfanads.android.core.reward.YFRewardServerCallBackInf;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.custom.RewardCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class OppoRewardVideoAdapter extends RewardCustomAdapter implements IRewardVideoAdListener {
    private static final int FETCH_TIME_OUT = 3000;
    private RewardVideoAd mRewardVideoAd;

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onLandingPageClose() {
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onLandingPageOpen() {
    }

    public OppoRewardVideoAdapter(YFRewardVideoSetting yFRewardVideoSetting) {
        super(yFRewardVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        OppoUtil.initOppo(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.oppo.OppoRewardVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                OppoRewardVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                OppoRewardVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.rewardSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            loadVideo(context);
        }
    }

    private void loadVideo(Context context) {
        this.mRewardVideoAd = new RewardVideoAd(context, this.sdkSupplier.network.param.potId, this);
        this.mRewardVideoAd.loadAd(new RewardVideoAdParams.Builder().setFetchTimeout(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS).build());
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter
    public void doShowAD(Activity activity) {
        if (this.mRewardVideoAd == null) {
            return;
        }
        if (isBidding()) {
            RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
            rewardVideoAd.setBidECPM(rewardVideoAd.getECPM());
        }
        playVideo();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.notifyRankWin(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0);
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
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd == null || sdkSupplier == null) {
            return;
        }
        rewardVideoAd.notifyRankLoss(1, "other", (int) sdkSupplier.ecpm);
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    private void playVideo() {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd != null && rewardVideoAd.isReady()) {
            this.mRewardVideoAd.showAd();
        }
        handleExposure();
    }

    @Override // com.yfanads.android.custom.RewardCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        destroyVideo();
    }

    private void destroyVideo() {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.destroyAd();
            this.mRewardVideoAd = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.OPPO.getValue();
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onAdSuccess() {
        YFLog.high(this.tag + " onAdSuccess");
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd != null) {
            setEcpm(rewardVideoAd.getECPM());
        }
        handleSucceed();
        setVideoCached(true);
        handleCached();
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onAdFailed(String str) {
        handleFailed(YFAdError.ERROR_DATA_NULL, str);
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onAdFailed(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onAdClick(long j) {
        handleClick();
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onVideoPlayStart() {
        YFLog.high(this.tag + "onVideoPlayStart");
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onVideoPlayComplete() {
        YFLog.high(this.tag + "onVideoComplete");
        handleVideoComplete();
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onVideoPlayError(String str) {
        YFLog.high(this.tag + "onVideoError " + str);
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardVideoAdListener
    public void onVideoPlayClose(long j) {
        YFLog.high(this.tag + " a OppoRewardVideoAdapter onVideoPlayClose");
        handleClose();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        return rewardVideoAd != null && rewardVideoAd.isReady();
    }

    @Override // com.heytap.msp.mobad.api.listener.IRewardListener
    public void onReward(Object... objArr) {
        try {
            YFLog.high(this.tag + " onReward");
            reportSdk(YFAdsConst.ReportETypeValue.SDK_REWARD.getValue());
            YFRewardServerCallBackInf yFRewardServerCallBackInf = new YFRewardServerCallBackInf();
            yFRewardServerCallBackInf.rewardInf = new YFRewardServerCallBackInf.RewardInf(YFRewardServerCallBackInf.Type.OPPO);
            if (this.rewardSetting != null) {
                yFRewardServerCallBackInf.rewardInf.setAppExtra(this.rewardSetting.getAppExtra());
            }
            handleReward(yFRewardServerCallBackInf);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
