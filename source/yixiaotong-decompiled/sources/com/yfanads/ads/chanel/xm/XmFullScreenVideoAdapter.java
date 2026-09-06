package com.yfanads.ads.chanel.xm;

import android.app.Activity;
import android.content.Context;
import com.cdo.oaps.ad.OapsKey;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.InterstitialAd;
import com.yfanads.ads.chanel.xm.utils.XmUtil;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.custom.FullScreenCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class XmFullScreenVideoAdapter extends FullScreenCustomAdapter implements InterstitialAd.InterstitialAdLoadListener, InterstitialAd.InterstitialAdInteractionListener {
    private InterstitialAd interstitialAd;

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdLoadListener
    public void onAdRequestSuccess() {
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoPause() {
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoResume() {
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoStart() {
    }

    public XmFullScreenVideoAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        XmUtil.initXm(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.xm.XmFullScreenVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                XmFullScreenVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                XmFullScreenVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mFullSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        this.interstitialAd = new InterstitialAd();
        ADParams.Builder builder = new ADParams.Builder();
        builder.setUpId(this.sdkSupplier.getPotId());
        this.interstitialAd.setMute(this.sdkSupplier.isMute());
        this.interstitialAd.loadAd(builder.build(), this);
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            if (this.interstitialAd == null) {
                return;
            }
            if (isBidding()) {
                this.interstitialAd.setPrice(getPrice());
            }
            if (activity == null || activity.isFinishing()) {
                return;
            }
            this.interstitialAd.show(activity, this);
        } catch (Exception e) {
            e.printStackTrace();
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.interstitialAd = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.XM.getValue();
    }

    private long getPrice() {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null || (mediaExtraInfo = interstitialAd.getMediaExtraInfo()) == null || mediaExtraInfo.isEmpty() || (obj = mediaExtraInfo.get(OapsKey.KEY_PRICE)) == null) {
            return 0L;
        }
        return ((Long) obj).longValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.win(XmUtil.getWinParams(this.sdkSupplier, sdkSupplier));
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
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.loss(XmUtil.getLossParams(sdkSupplier));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdLoadListener
    public void onAdLoadSuccess() {
        if (this.interstitialAd != null) {
            setEcpm(getPrice());
        }
        handleSucceed();
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdLoadListener
    public void onAdLoadFailed(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdClick() {
        handleClick();
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdShow() {
        handleExposure();
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdClosed() {
        YFLog.debug(" onAdDismissed ");
        handleClose();
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onRenderFail(int i, String str) {
        if (isStartShow()) {
            YFLog.error(this.tag + " onRenderFail, msg:" + str + "_" + i);
            handleRenderFailed(i, str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoEnd() {
        handleVideoComplete();
    }
}
