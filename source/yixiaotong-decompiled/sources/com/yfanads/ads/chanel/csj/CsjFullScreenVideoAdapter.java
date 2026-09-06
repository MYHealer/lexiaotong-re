package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.cdo.oaps.ad.OapsKey;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.custom.FullScreenCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjFullScreenVideoAdapter extends FullScreenCustomAdapter implements TTAdNative.FullScreenVideoAdListener, TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    protected String ecpm;
    protected TTFullScreenVideoAd ttFullScreenVideoAd;

    public CsjFullScreenVideoAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjFullScreenVideoAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                CsjFullScreenVideoAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjFullScreenVideoAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.mFullSetting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            CsjUtil.getADManger().createAdNative(context).loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setExpressViewAcceptedSize(500.0f, 500.0f).setSupportDeepLink(true).setOrientation(context.getResources().getConfiguration().orientation == 1 ? 1 : 2).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setVolume(0.7f).setBidNotify(true).build()).build(), this);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.ttFullScreenVideoAd;
        return (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getMediaExtraInfo() == null || !this.ttFullScreenVideoAd.getMediationManager().isReady()) ? false : true;
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter
    public void doShowAD(Activity activity) {
        if (activity != null && this.ttFullScreenVideoAd != null) {
            if (isBidding()) {
                this.ttFullScreenVideoAd.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
            }
            this.ttFullScreenVideoAd.setFullScreenVideoAdInteractionListener(this);
            this.ttFullScreenVideoAd.showFullScreenVideoAd(activity);
            return;
        }
        handleShowFailed();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.ttFullScreenVideoAd;
        return tTFullScreenVideoAd != null ? CsjUtil.getReqId(tTFullScreenVideoAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.custom.FullScreenCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        try {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.ttFullScreenVideoAd;
            if (tTFullScreenVideoAd != null && tTFullScreenVideoAd.getMediationManager() != null) {
                this.ttFullScreenVideoAd.getMediationManager().destroy();
            }
            this.ttFullScreenVideoAd = null;
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onError(int i, String str) {
        YFLog.high(this.tag + "onError ");
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        try {
            YFLog.high(this.tag + "onFullScreenVideoAdLoad ");
            this.ttFullScreenVideoAd = tTFullScreenVideoAd;
            if (isBidding()) {
                updPrice();
                setEcpmByStr(this.ecpm);
            }
            handleSucceed();
        } catch (Throwable th) {
            th.printStackTrace();
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
        YFLog.high(this.tag + "onFullScreenVideoCached ");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        String string = "";
        if (tTFullScreenVideoAd != null) {
            try {
                string = tTFullScreenVideoAd.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        YFLog.high(this.tag + "onFullScreenVideoCached( " + string + ")");
        handleCached();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        TTFullScreenVideoAd tTFullScreenVideoAd;
        if (isGromoreAdn() && isBidding() && (tTFullScreenVideoAd = this.ttFullScreenVideoAd) != null && tTFullScreenVideoAd.getMediationManager() != null) {
            MediationAdEcpmInfo showEcpm = this.ttFullScreenVideoAd.getMediationManager().getShowEcpm();
            if (showEcpm != null) {
                String mShowEcpm = CsjUtil.getMShowEcpm(showEcpm);
                this.ecpm = mShowEcpm;
                if (!TextUtils.isEmpty(mShowEcpm)) {
                    setEcpmByStr(this.ecpm);
                }
            }
            YFLog.high(this.tag + "onFullScreenVideo onAdShow ep_" + this.ecpm);
        } else {
            YFLog.high(this.tag + "onFullScreenVideo onAdShow");
        }
        handleExposure();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        YFLog.high(this.tag + "onFullScreenVideo onAdVideoBarClick");
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        YFLog.high(this.tag + "onFullScreenVideo onAdClose");
        handleClose();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        YFLog.high(this.tag + "onFullScreenVideo onVideoComplete");
        handleVideoComplete();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        YFLog.high(this.tag + "onFullScreenVideo onSkippedVideo");
        handleClose(true);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    protected void updPrice() {
        try {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.ttFullScreenVideoAd;
            if (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getMediaExtraInfo() == null) {
                return;
            }
            Object obj = this.ttFullScreenVideoAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
            if (obj == null) {
                obj = "1";
            }
            this.ecpm = String.valueOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.ttFullScreenVideoAd;
        if (tTFullScreenVideoAd != null) {
            tTFullScreenVideoAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
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
        TTFullScreenVideoAd tTFullScreenVideoAd = this.ttFullScreenVideoAd;
        if (tTFullScreenVideoAd == null || sdkSupplier == null) {
            return;
        }
        tTFullScreenVideoAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    private boolean isGromoreAdn() {
        return getAdnId() == YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }
}
