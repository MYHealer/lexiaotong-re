package com.yfanads.ads.chanel.ks;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.yfanads.ads.chanel.ks.model.KSNativeAds;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.MixBannerCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSMixBannerAdapter extends MixBannerCustomAdapter implements KsLoadManager.FeedAdListener, YFNativeCall {
    private KsBannerAd bannerAd;
    private ExpView expView;
    private final KsBannerAd.BannerAdInteractionListener mBannerAdInteractionListener;
    private List<KsFeedAd> nativeAds;
    private List<KsNativeAd> nativeAds2;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 4;
    }

    public KSMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
        this.mBannerAdInteractionListener = new KsBannerAd.BannerAdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter.5
            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdClicked() {
                YFLog.debug("banner onAdClicked");
                if (KSMixBannerAdapter.this.expView != null) {
                    KSMixBannerAdapter kSMixBannerAdapter = KSMixBannerAdapter.this;
                    kSMixBannerAdapter.handleClick(kSMixBannerAdapter.expView);
                }
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdShow() {
                YFLog.debug("banner onAdShow");
                if (KSMixBannerAdapter.this.expView != null) {
                    KSMixBannerAdapter kSMixBannerAdapter = KSMixBannerAdapter.this;
                    kSMixBannerAdapter.handleExposure(kSMixBannerAdapter.expView);
                }
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdClose() {
                YFLog.debug("banner onAdClose");
                if (KSMixBannerAdapter.this.expView != null) {
                    KSMixBannerAdapter kSMixBannerAdapter = KSMixBannerAdapter.this;
                    kSMixBannerAdapter.handleClose(kSMixBannerAdapter.expView);
                }
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdShowError(int i, String str) {
                YFLog.debug("banner onAdShowError " + i + PPSLabelView.Code + str);
                KSMixBannerAdapter.this.handleRenderFailed(i, str);
            }
        };
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.KS.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        KSUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                KSMixBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                KSMixBannerAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    private void loadTemplate() {
        KsAdSDK.getLoadManager().loadConfigFeedAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).width(ScreenUtil.dip2px(getContext(), this.setting.getViewWidth())).adNum(this.setting.getAdsNumbers()).build(), this);
    }

    private void loadAdByNative() {
        NativeAdExtraData nativeAdExtraData = new NativeAdExtraData();
        if (this.isSupportShake) {
            YFLog.debug(this.tag + "isShakeAction true");
            nativeAdExtraData.setEnableShake(this.sdkSupplier.isShakeAction());
            nativeAdExtraData.setEnableRotate(this.sdkSupplier.isTwistAction());
        } else {
            YFLog.debug(this.tag + "isShakeAction false");
            nativeAdExtraData.setEnableShake(false);
            nativeAdExtraData.setEnableRotate(false);
        }
        nativeAdExtraData.setShowLiveStatus(1);
        nativeAdExtraData.setShowLiveStyle(0);
        KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).setNativeAdExtraData(nativeAdExtraData).build(), new KsLoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(KSMixBannerAdapter.this.tag + " onError " + i + str);
                KSMixBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(List<KsNativeAd> list) {
                YFLog.high(KSMixBannerAdapter.this.tag + "onNativeAdLoad");
                try {
                    if (!YFListUtils.isEmpty(list) && list.get(0) != null) {
                        KSMixBannerAdapter.this.updData(list);
                        KSMixBannerAdapter.this.updPrice();
                        KSMixBannerAdapter.this.handleSucceed();
                    } else {
                        KSMixBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                    }
                } catch (Throwable th) {
                    YFLog.error(KSMixBannerAdapter.this.tag + " onNativeAdLoad " + th.getMessage());
                    KSMixBannerAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updData(List<KsNativeAd> list) {
        if (!isDevelop()) {
            this.nativeAds2 = list;
            return;
        }
        this.developAds.clear();
        for (int i = 0; i < list.size(); i++) {
            this.developAds.add(new KSNativeAds(list.get(i), this, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updPrice() {
        if (isNative()) {
            List<KsNativeAd> list = this.nativeAds2;
            if (list == null || list.get(0) == null) {
                return;
            }
            setEcpm(this.nativeAds2.get(0).getECPM());
            return;
        }
        if (!isDevelop() || YFListUtils.isEmpty(this.developAds) || this.developAds.get(0) == null) {
            return;
        }
        setEcpm(this.developAds.get(0).getECPM());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        List<KsFeedAd> list = this.nativeAds;
        if (list != null && !list.isEmpty()) {
            this.nativeAds.clear();
        }
        List<KsNativeAd> list2 = this.nativeAds2;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        this.nativeAds2.clear();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter, com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            if (isTemplate()) {
                doShowTemplateAd(activity);
            } else if (isNative() || isDevelop()) {
                doShowNativeAd(activity);
            } else if (isBanner()) {
                doShowBannerAd(activity);
            }
        } catch (Exception e) {
            YFLog.error("doShowAD " + e.getMessage());
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        try {
            if (isTemplate()) {
                return (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size() || this.nativeAds.get(i) == null) ? "" : KSUtil.getReqId(this.nativeAds.get(i).getMediaExtraInfo());
            }
            if (isNative()) {
                return (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size() || this.nativeAds2.get(i) == null) ? "" : KSUtil.getReqId(this.nativeAds2.get(i).getMediaExtraInfo());
            }
            if (isBanner()) {
                KsBannerAd ksBannerAd = this.bannerAd;
                return ksBannerAd != null ? KSUtil.getReqId(ksBannerAd.getMediaExtraInfo()) : "";
            }
            if (isDevelop() && !YFListUtils.isEmpty(this.developAds) && i < this.developAds.size()) {
                YFNativeAd yFNativeAd = this.developAds.get(i);
                return yFNativeAd instanceof KSNativeAds ? ((KSNativeAds) yFNativeAd).getAdReqId() : "";
            }
        } catch (Exception e) {
            YFLog.error("getRequestId " + e.getMessage());
        }
        return "";
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadNativeAd(Context context) {
        loadAdByNative();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadTemplateAd(Context context) {
        loadTemplate();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadBannerAd(Context context) {
        KsAdSDK.getLoadManager().loadBannerAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).build(), new KsLoadManager.BannerAdListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter.3
            @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
            public void onError(int i, String str) {
                YFLog.high(KSMixBannerAdapter.this.tag + " loadBannerAd onError " + i + str);
                KSMixBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
            public void onBannerAdLoad(KsBannerAd ksBannerAd) {
                KSMixBannerAdapter.this.bannerAd = ksBannerAd;
                int ecpm = ksBannerAd.getECPM();
                KSMixBannerAdapter.this.setEcpm(ecpm);
                YFLog.high(KSMixBannerAdapter.this.tag + " loadBannerAd load ep_" + ecpm);
                KSMixBannerAdapter.this.handleSucceed();
            }
        });
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowTemplateAd(Activity activity) {
        List<KsFeedAd> list = this.nativeAds;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.nativeAds.size(); i++) {
                KsFeedAd ksFeedAd = this.nativeAds.get(i);
                final YFExpView yFExpView = new YFExpView(ksFeedAd.getFeedView(activity), getAdType(), i);
                arrayList.add(yFExpView);
                ksFeedAd.setAdInteractionListener(new KsFeedAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter.4
                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onAdClicked() {
                        YFLog.debug(KSMixBannerAdapter.this.tag + "onAdClicked");
                        KSMixBannerAdapter.this.handleClick(yFExpView);
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onAdShow() {
                        YFLog.debug(KSMixBannerAdapter.this.tag + "onAdShow");
                        KSMixBannerAdapter.this.handleExposure(yFExpView);
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onDislikeClicked() {
                        YFLog.debug(KSMixBannerAdapter.this.tag + "onDislikeClicked");
                        KSMixBannerAdapter.this.handleClose(yFExpView);
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                        YFLog.debug(KSMixBannerAdapter.this.tag + "onDownloadTipsDialogShow");
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                        YFLog.debug(KSMixBannerAdapter.this.tag + "onDownloadTipsDialogDismiss");
                    }
                });
            }
            if (this.setting != null) {
                this.setting.adapterRenderSuccess(this.sdkSupplier, arrayList);
                return;
            }
            return;
        }
        if (this.setting != null) {
            this.setting.adapterRenderFailed(this.sdkSupplier);
        }
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowBannerAd(Activity activity) {
        View view = this.bannerAd.getView(activity, this.mBannerAdInteractionListener, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
        FrameLayout frameLayout = new FrameLayout(activity);
        int iDip2px = ScreenUtil.dip2px(getContext(), this.setting.getViewWidth());
        if (iDip2px == 0) {
            iDip2px = ScreenUtil.getScreenWidthC(getContext());
        }
        YFLog.high(this.tag + " doShowBannerAd view:" + view + ",width:" + iDip2px);
        frameLayout.addView(view, new ViewGroup.LayoutParams(iDip2px, -2));
        this.expView = new YFExpView(frameLayout, getAdType(), 0);
        this.viewList.add(this.expView);
        if (this.setting != null) {
            this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<KsNativeAd> list = this.nativeAds2;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        String shortString = "";
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            for (KsFeedAd ksFeedAd : this.nativeAds) {
                ksFeedAd.setBidEcpm(ksFeedAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            for (KsNativeAd ksNativeAd : this.nativeAds2) {
                ksNativeAd.setBidEcpm(ksNativeAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        KsBannerAd ksBannerAd = this.bannerAd;
        if (ksBannerAd != null) {
            ksBannerAd.setBidEcpm(ksBannerAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
            YFLog.high(this.tag + " sendBiddingSucResult  current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof KSNativeAds) {
                ((KSNativeAds) yFNativeAd).setBidEcpm(yFNativeAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.developAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (!YFListUtils.isEmpty(this.nativeAds) && sdkSupplier != null) {
            AdExposureFailedReason adExposureFailedReason = KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier());
            Iterator<KsFeedAd> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().reportAdExposureFailed(2, adExposureFailedReason);
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (!YFListUtils.isEmpty(this.nativeAds2) && sdkSupplier != null) {
            AdExposureFailedReason adExposureFailedReason2 = KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier());
            Iterator<KsNativeAd> it2 = this.nativeAds2.iterator();
            while (it2.hasNext()) {
                it2.next().reportAdExposureFailed(2, adExposureFailedReason2);
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (this.bannerAd != null && sdkSupplier != null) {
            this.bannerAd.reportAdExposureFailed(2, KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier()));
            YFLog.high(this.tag + " sendBiddingLossResult  current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (YFListUtils.isEmpty(this.developAds) || sdkSupplier == null) {
            return;
        }
        AdExposureFailedReason adExposureFailedReason3 = KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier());
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof KSNativeAds) {
                ((KSNativeAds) yFNativeAd).reportAdExposureFailed(2, adExposureFailedReason3);
            }
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.developAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            return KSUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
        }
        return super.getAdInfo();
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        KsImage ksImage;
        String actionDescription;
        KsNativeAd adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        if (!this.isSupportShake && bannerTemplateData.isAction()) {
            if (bannerTemplateData.isOnlyAction()) {
                bannerTemplateData.setWholeClick();
            }
            bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        boolean z = isVideo(adNative) || isLive(adNative);
        YFLog.high(this.tag + " bindData isVideo " + isVideo(adNative) + " , materialType " + adNative.getMaterialType());
        this.feedBean = new FeedBean(adNative.getProductName(), adNative.getAdDescription(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (adNative.getVideoCoverImage() != null) {
                ViewUtils.loadBlurImage(adNative.getVideoCoverImage().getImageUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!YFListUtils.isEmpty(adNative.getImageList()) && (ksImage = adNative.getImageList().get(0)) != null && ksImage.isValid() && !TextUtils.isEmpty(ksImage.getImageUrl())) {
                this.feedBean.imageUrl = ksImage.getImageUrl();
                ViewUtils.loadBlurImage(ksImage.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(ksImage.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_ks_v3);
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        String adDescription = TextUtils.isEmpty(adNative.getProductName()) ? adNative.getAdDescription() : adNative.getProductName();
        String productName = TextUtils.isEmpty(adNative.getAdDescription()) ? adNative.getProductName() : adNative.getAdDescription();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (adDescription == null) {
                adDescription = "";
            }
            textView.setText(adDescription);
        }
        TextView textView2 = adBannerViewHolder.adDes;
        if (productName == null) {
            productName = "";
        }
        textView2.setText(productName);
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
            } else {
                adBannerViewHolder.mDownload.setVisibility(0);
                TextView textView3 = adBannerViewHolder.mDownload;
                if (TextUtils.isEmpty(adNative.getActionDescription())) {
                    actionDescription = getContext().getString(R.string.yf_default_download_text);
                } else {
                    actionDescription = adNative.getActionDescription();
                }
                textView3.setText(actionDescription);
                if (this.feedBean != null) {
                    this.feedBean.actBtnString = adNative.getActionDescription();
                }
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(adNative.getAppIconUrl())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(adNative.getAppIconUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1129lambda$bindData$0$comyfanadsadschanelksKSMixBannerAdapter(i, view);
            }
        });
        registerViewForInteraction(activity, adBannerViewHolder, z, bannerTemplateData, adNative, i);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1130lambda$bindData$1$comyfanadsadschanelksKSMixBannerAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ks-KSMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1129lambda$bindData$0$comyfanadsadschanelksKSMixBannerAdapter(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ks-KSMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1130lambda$bindData$1$comyfanadsadschanelksKSMixBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private KsNativeAd getAdNative(int i) {
        if (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size()) {
            YFLog.error("bindData error " + i);
            return null;
        }
        return this.nativeAds2.get(i);
    }

    private boolean isVideo(KsNativeAd ksNativeAd) {
        return ksNativeAd.getMaterialType() == 1;
    }

    private boolean isLive(KsNativeAd ksNativeAd) {
        return ksNativeAd.getMaterialType() == 8;
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, KsNativeAd ksNativeAd) {
        if (isDownloadAd(ksNativeAd)) {
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(ksNativeAd.getAppName(), ksNativeAd.getAppVersion(), ksNativeAd.getCorporationName(), ksNativeAd.getIntroductionInfoUrl(), ksNativeAd.getPermissionInfoUrl(), ksNativeAd.getAppPrivacyUrl()));
            this.feedBean.updateAppInfo(ksNativeAd.getAppName(), ksNativeAd.getAppVersion(), ksNativeAd.getCorporationName());
        } else {
            adBannerViewHolder.complianceContent.setVisibility(8);
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public boolean isDownloadType(int i) {
        List<KsNativeAd> list = this.nativeAds2;
        if (list != null && list.get(i) != null) {
            return isDownloadAd(this.nativeAds2.get(i));
        }
        return super.isDownloadType(i);
    }

    private boolean isDownloadAd(KsNativeAd ksNativeAd) {
        return ksNativeAd.getInteractionType() == 1;
    }

    private void registerViewForInteraction(Activity activity, AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData, KsNativeAd ksNativeAd, int i) {
        HashMap map = new HashMap();
        int i2 = bannerTemplateData.isSlideJump() ? 1 : 3;
        int i3 = bannerTemplateData.isSlideJump() ? 2 : 4;
        YFLog.debug(this.tag + "registerViewForInteraction slideJump " + bannerTemplateData.isSlideJump() + ",convertType " + i2 + ",convertTypeWithDialog " + i3);
        int i4 = -1;
        if (!bannerTemplateData.isShowDownloadDialog()) {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    map.put(adBannerViewHolder.viewGroup, Integer.valueOf(i2));
                    i4 = i2;
                }
                map.put(adBannerViewHolder.adCloseDelay, Integer.valueOf(i2));
            } else {
                map.put(adBannerViewHolder.dyClickView, Integer.valueOf(i2));
                i4 = i2;
            }
            if (bannerTemplateData.isTitleDesClick()) {
                map.put(adBannerViewHolder.adDes, Integer.valueOf(i2));
                map.put(adBannerViewHolder.titleDes, Integer.valueOf(i2));
            }
        } else {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    map.put(adBannerViewHolder.viewGroup, Integer.valueOf(i3));
                    i4 = i3;
                }
                map.put(adBannerViewHolder.adCloseDelay, Integer.valueOf(i3));
            } else {
                map.put(adBannerViewHolder.dyClickView, Integer.valueOf(i3));
                i4 = i3;
            }
            if (bannerTemplateData.isTitleDesClick()) {
                map.put(adBannerViewHolder.adDes, Integer.valueOf(i3));
                map.put(adBannerViewHolder.titleDes, Integer.valueOf(i3));
            }
        }
        int i5 = i4;
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                if (isDownloadType(ksNativeAd) && !bannerTemplateData.isActionShowDialog()) {
                    map.put(adBannerViewHolder.mDownloadBar, Integer.valueOf(i2));
                } else {
                    map.put(adBannerViewHolder.mDownloadBar, Integer.valueOf(i3));
                }
            } else if (isDownloadType(ksNativeAd) && !bannerTemplateData.isActionShowDialog()) {
                map.put(adBannerViewHolder.mDownload, Integer.valueOf(i2));
            } else {
                map.put(adBannerViewHolder.mDownload, Integer.valueOf(i3));
            }
        }
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(activity, adBannerViewHolder, ksNativeAd, bannerTemplateData, map, i, i5);
        } else {
            bindImageViews(activity, adBannerViewHolder, ksNativeAd, map, i);
        }
    }

    private boolean isDownloadType(KsNativeAd ksNativeAd) {
        return ksNativeAd.getInteractionType() == 1;
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, final KsNativeAd ksNativeAd, final BannerTemplateData bannerTemplateData, Map<View, Integer> map, final int i, int i2) {
        if (activity != null) {
            View videoView = ksNativeAd.getVideoView(getContext(), new KsAdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ bannerTemplateData.isMute()).build());
            if (videoView != null && videoView.getParent() == null) {
                adBaseViewHolder.mediaViewFrame.removeAllViews();
                adBaseViewHolder.mediaViewFrame.addView(videoView);
            }
            if (i2 != -1) {
                map.put(videoView, Integer.valueOf(i2));
            }
            ksNativeAd.registerViewForInteraction(activity, adBaseViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter.6
                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return false;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogShow() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                    KSMixBannerAdapter.this.handleClick(i, false);
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    KSMixBannerAdapter.this.handleExposure(i);
                }
            });
        }
        if (isLive(ksNativeAd)) {
            YFLog.high("it's a live, do not update mediaViewFrame");
        } else {
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1131xe4c82ec6(adBaseViewHolder, ksNativeAd, bannerTemplateData);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$3$com-yfanads-ads-chanel-ks-KSMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1131xe4c82ec6(AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd, BannerTemplateData bannerTemplateData) {
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int videoWidth = ksNativeAd.getVideoWidth();
        int videoHeight = ksNativeAd.getVideoHeight();
        YFLog.info(this.tag + " w" + width + "|h" + height + "|vw" + videoWidth + "|vh" + videoHeight);
        if (bannerTemplateData.isTemplateV3()) {
            updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, height, videoWidth, videoHeight);
        } else {
            if (videoWidth <= 0 || videoHeight <= 0 || ViewUtils.isHorizontal(videoWidth, videoHeight)) {
                return;
            }
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, (videoWidth * height) / videoHeight, height);
        }
    }

    private void bindImageViews(Activity activity, AdBannerViewHolder adBannerViewHolder, KsNativeAd ksNativeAd, Map<View, Integer> map, final int i) {
        if (activity != null) {
            ksNativeAd.registerViewForInteraction(activity, adBannerViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSMixBannerAdapter.7
                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return false;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogShow() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                    KSMixBannerAdapter.this.handleClick(i, false);
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    KSMixBannerAdapter.this.handleExposure(i);
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
    public void onError(int i, String str) {
        YFLog.high(this.tag + " onError ，" + i + str);
        handleFailed(i, str);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003c A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x001a, B:6:0x0020, B:9:0x0028, B:10:0x003c), top: B:16:0x001a }] */
    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
    public void onFeedAdLoad(List<KsFeedAd> list) {
        YFLog.high(this.tag + " onFeedAdLoad");
        if (list != null) {
            try {
                if (list.isEmpty() || list.get(0) == null) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } else {
                    this.nativeAds = list;
                    setEcpm(list.get(0).getECPM());
                    handleSucceed();
                }
            } catch (Throwable th) {
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, PPSLabelView.Code + th.getMessage());
            }
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
        }
    }
}
