package com.yfanads.ads.chanel.ylh;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.custom.FullScreenCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhFullScreenVideoAdapter extends FullScreenCustomAdapter implements UnifiedInterstitialADListener {
    private UnifiedInterstitialAD iad;
    private long videoDuration;
    private long videoStartTime;

    public YlhFullScreenVideoAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.YLH.getValue();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADReceive() {
        try {
            YFLog.high(this.tag + "onADReceive");
            UnifiedInterstitialAD unifiedInterstitialAD = this.iad;
            if (unifiedInterstitialAD != null) {
                setEcpm(unifiedInterstitialAD.getECPM());
            }
            handleSucceed();
        } catch (Throwable th) {
            th.printStackTrace();
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onVideoCached() {
        YFLog.high(this.tag + "onVideoCached");
        handleCached();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.iad;
        return unifiedInterstitialAD != null && unifiedInterstitialAD.isValid();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        int errorCode;
        String errorMsg;
        if (adError != null) {
            try {
                errorCode = adError.getErrorCode();
                errorMsg = adError.getErrorMsg();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            errorCode = -1;
            errorMsg = "default onNoAD";
        }
        YFLog.high(this.tag + " onNoAD");
        handleFailed(errorCode, errorMsg);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADOpened() {
        YFLog.high(this.tag + "onADOpened");
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADExposure() {
        YFLog.high(this.tag + "onADExposure");
        handleExposure();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClicked() {
        YFLog.high(this.tag + "onADClicked");
        handleClick();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADLeftApplication() {
        YFLog.high(this.tag + "onADLeftApplication");
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClosed() {
        YFLog.high(this.tag + "onADClosed");
        if (this.mFullSetting != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.videoStartTime;
            YFLog.high(this.tag + "costTime ==   " + jCurrentTimeMillis + " videoDuration == " + this.videoDuration);
            handleClose(jCurrentTimeMillis < this.videoDuration);
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
        YFLog.high(this.tag + "onRenderSuccess");
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
        YFLog.high(this.tag + "onRenderFail");
        handleRenderFailed();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhFullScreenVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhFullScreenVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhFullScreenVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        loadTemplate(context);
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.iad;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.iad = null;
        }
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter
    public void doShowAD(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.iad;
        if (unifiedInterstitialAD != null && activity != null) {
            unifiedInterstitialAD.showFullScreenAD(activity);
        } else {
            handleShowFailed(this.tag + " activity is null");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.iad;
        return unifiedInterstitialAD != null ? YlhUtil.getReqId(unifiedInterstitialAD.getExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.iad;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.sendWinNotification(YlhUtil.getWindBiddingMap(unifiedInterstitialAD.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
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
        if (this.iad == null || sdkSupplier == null) {
            return;
        }
        this.iad.sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier())));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    private void loadTemplate(Context context) {
        if (!(context instanceof Activity)) {
            YFLog.error("loadFullScreen context is not activity " + context);
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_YLH_CONTEXT));
            return;
        }
        UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.sdkSupplier.getPotId(), this);
        this.iad = unifiedInterstitialAD;
        unifiedInterstitialAD.setMediaListener(new UnifiedInterstitialMediaListener() { // from class: com.yfanads.ads.chanel.ylh.YlhFullScreenVideoAdapter.2
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
                YFLog.high(YlhFullScreenVideoAdapter.this.tag + " onVideoInit");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
                YFLog.high(YlhFullScreenVideoAdapter.this.tag + " onVideoLoading");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long j) {
                YFLog.high(YlhFullScreenVideoAdapter.this.tag + " onVideoReady, videoDuration = " + j);
                try {
                    YlhFullScreenVideoAdapter.this.videoStartTime = System.currentTimeMillis();
                    YlhFullScreenVideoAdapter.this.videoDuration = j;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
                YFLog.high(YlhFullScreenVideoAdapter.this.tag + " onVideoStart");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
                YFLog.high(YlhFullScreenVideoAdapter.this.tag + " onVideoPause");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoComplete() {
                YFLog.high(YlhFullScreenVideoAdapter.this.tag + " onVideoComplete");
                YlhFullScreenVideoAdapter.this.handleVideoComplete();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoError(AdError adError) {
                if (adError != null) {
                    YFLog.error(YlhFullScreenVideoAdapter.this.tag + " onVideoError msg:" + adError.getErrorMsg() + "_" + adError.getErrorCode());
                }
                if (YlhFullScreenVideoAdapter.this.isStartShow()) {
                    if (adError != null) {
                        YlhFullScreenVideoAdapter.this.handleRenderFailed(adError.getErrorCode(), adError.getErrorMsg());
                        return;
                    } else {
                        YlhFullScreenVideoAdapter.this.handleRenderFailed();
                        return;
                    }
                }
                if (adError != null) {
                    YlhFullScreenVideoAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    YlhFullScreenVideoAdapter.this.handleFailed(0, "onVideoError");
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
                YFLog.high(YlhFullScreenVideoAdapter.this.tag + "onVideoPageOpen ");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
                YFLog.high(YlhFullScreenVideoAdapter.this.tag + " onVideoPageClose");
            }
        });
        VideoOption videoOptionBuild = new VideoOption.Builder().setAutoPlayMuted(this.sdkSupplier.isMute()).setAutoPlayPolicy(1).build();
        this.iad.setMinVideoDuration(0);
        this.iad.setMaxVideoDuration(60);
        this.iad.setVideoOption(videoOptionBuild);
        this.iad.loadFullScreenAD();
    }
}
