package com.yfanads.ads.chanel.xm;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.cdo.oaps.ad.OapsKey;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.BannerAd;
import com.yfanads.ads.chanel.xm.utils.XmUtil;
import com.yfanads.android.core.banner.YFBannerSetting;
import com.yfanads.android.custom.BannerCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class XmBannerAdapter extends BannerCustomAdapter implements BannerAd.BannerLoadListener, BannerAd.BannerInteractionListener {
    private BannerAd bannerAd;
    private ViewGroup viewGroup;

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, ViewGroup viewGroup, AdBannerViewHolder adBannerViewHolder) {
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
    public void onRenderSuccess() {
    }

    public XmBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        XmUtil.initXm(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.xm.XmBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                XmBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.high(XmBannerAdapter.this.tag + " onError: code = " + str + " msg = " + str2);
                XmBannerAdapter.this.handleFailed(str + "", str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        this.viewGroup = viewGroup;
        showTemplateADs(activity, viewGroup);
    }

    private void showTemplateADs(Activity activity, ViewGroup viewGroup) {
        try {
            if (this.bannerAd == null) {
                return;
            }
            if (isBidding()) {
                this.bannerAd.setPrice(getPrice());
            }
            if (activity == null || activity.isFinishing() || viewGroup == null) {
                return;
            }
            this.bannerAd.showAd(activity, viewGroup, this);
        } catch (Exception e) {
            e.printStackTrace();
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        try {
            BannerAd bannerAd = this.bannerAd;
            if (bannerAd != null) {
                bannerAd.destroy();
                this.bannerAd = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.XM.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            loadInterstitialAd();
        }
    }

    private long getPrice() {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        BannerAd bannerAd = this.bannerAd;
        if (bannerAd == null || (mediaExtraInfo = bannerAd.getMediaExtraInfo()) == null || mediaExtraInfo.isEmpty() || (obj = mediaExtraInfo.get(OapsKey.KEY_PRICE)) == null) {
            return 0L;
        }
        return ((Long) obj).longValue();
    }

    private void loadInterstitialAd() {
        this.bannerAd = new BannerAd();
        ADParams.Builder builder = new ADParams.Builder();
        builder.setUpId(this.sdkSupplier.getPotId());
        this.bannerAd.setMute(this.sdkSupplier.isMute());
        this.bannerAd.loadAd(builder.build(), new BannerAd.BannerLoadListener() { // from class: com.yfanads.ads.chanel.xm.XmBannerAdapter.2
            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerLoadListener
            public void onBannerAdLoadSuccess() {
                if (XmBannerAdapter.this.bannerAd != null) {
                    XmBannerAdapter xmBannerAdapter = XmBannerAdapter.this;
                    xmBannerAdapter.setEcpm(xmBannerAdapter.getBannerPrice());
                }
                XmBannerAdapter.this.handleSucceed();
            }

            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerLoadListener
            public void onAdLoadFailed(int i, String str) {
                YFLog.high(XmBannerAdapter.this.tag + " onError: code = " + i + " msg = " + str);
                XmBannerAdapter.this.handleFailed(i + "", str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getBannerPrice() {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        BannerAd bannerAd = this.bannerAd;
        if (bannerAd == null || (mediaExtraInfo = bannerAd.getMediaExtraInfo()) == null || mediaExtraInfo.isEmpty() || (obj = mediaExtraInfo.get(OapsKey.KEY_PRICE)) == null) {
            return 0L;
        }
        return ((Long) obj).longValue();
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerLoadListener
    public void onBannerAdLoadSuccess() {
        if (this.bannerAd != null) {
            setEcpm(getPrice());
        }
        handleSucceed();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        BannerAd bannerAd = this.bannerAd;
        if (bannerAd != null) {
            bannerAd.win(XmUtil.getWinParams(this.sdkSupplier, sdkSupplier));
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
        BannerAd bannerAd = this.bannerAd;
        if (bannerAd != null) {
            bannerAd.loss(XmUtil.getLossParams(sdkSupplier));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerLoadListener
    public void onAdLoadFailed(int i, String str) {
        YFLog.high(this.tag + " onError: code = " + i + " msg = " + str);
        handleFailed(i + "", str);
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
    public void onAdClick() {
        YFLog.high(this.tag + "newVersionAd onAdVideoBarClick");
        handleClick();
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
    public void onAdShow() {
        YFLog.high(this.tag + "newVersionAd onAdShow");
        handleExposure();
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
    public void onAdDismiss() {
        closeAds(this.viewGroup);
    }

    @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
    public void onRenderFail(int i, String str) {
        YFLog.high(this.tag + " onError: code = " + i + " msg = " + str);
        if (isStartShow()) {
            handleRenderFailed(i, str);
        }
    }
}
