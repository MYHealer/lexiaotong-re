package com.yfanads.ads.chanel.ks;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.kwad.sdk.api.model.SplashAdExtraData;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.model.template.InterV3TemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSInterstitialAdapter extends InterstitialCustomAdapter implements KsInterstitialAd.AdInteractionListener {
    KsInterstitialAd interstitialAd;
    KsNativeAd nativeAds;

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public boolean isSupportAutoClick() {
        return true;
    }

    public KSInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.KS.getValue();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        if (isNative()) {
            showNativeADs(activity);
        } else {
            showTemplateADs(activity);
        }
    }

    private void showTemplateADs(Activity activity) {
        KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().videoSoundEnable(!this.sdkSupplier.isMute()).showLandscape(false).build();
        if (activity != null) {
            this.interstitialAd.showInterstitialAd(activity, ksVideoPlayConfigBuild);
        } else {
            handleShowFailed(this.tag + " activity is null");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isNative()) {
            KsNativeAd ksNativeAd = this.nativeAds;
            return ksNativeAd != null ? KSUtil.getReqId(ksNativeAd.getMediaExtraInfo()) : "";
        }
        KsInterstitialAd ksInterstitialAd = this.interstitialAd;
        return ksInterstitialAd != null ? KSUtil.getReqId(ksInterstitialAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        KSUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                KSInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                KSInterstitialAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        KSUtil.checkAppID(context, this.sdkSupplier.getAdnAppId(), this.tag);
        if (isNative()) {
            loadInterstitialAdByNative();
        } else {
            loadInterstitialAd();
        }
    }

    private void loadInterstitialAdByNative() {
        NativeAdExtraData nativeAdExtraData = new NativeAdExtraData();
        nativeAdExtraData.setShowLiveStatus(1);
        nativeAdExtraData.setShowLiveStyle(0);
        if (this.isSupportShake) {
            YFLog.debug(this.tag + "isShakeAction true");
            nativeAdExtraData.setEnableShake(this.sdkSupplier.isShakeAction());
            nativeAdExtraData.setEnableRotate(this.sdkSupplier.isTwistAction());
        } else {
            YFLog.debug(this.tag + "isShakeAction false");
            nativeAdExtraData.setEnableShake(false);
            nativeAdExtraData.setEnableRotate(false);
        }
        KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).setNativeAdExtraData(nativeAdExtraData).build(), new KsLoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(KSInterstitialAdapter.this.tag + " onError " + i + str);
                KSInterstitialAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0048 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0048), top: B:16:0x001e }] */
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(List<KsNativeAd> list) {
                YFLog.high(KSInterstitialAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() == 0 || list.get(0) == null) {
                            KSInterstitialAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            KSInterstitialAdapter.this.nativeAds = list.get(0);
                            KSInterstitialAdapter kSInterstitialAdapter = KSInterstitialAdapter.this;
                            kSInterstitialAdapter.setEcpm(kSInterstitialAdapter.nativeAds.getECPM());
                            KSInterstitialAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        KSInterstitialAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    KSInterstitialAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    private void loadInterstitialAd() {
        SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
        splashAdExtraData.setDisableShakeStatus(false);
        splashAdExtraData.setDisableSlideStatus(false);
        KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).width(this.setting.getViewWidth()).height(this.setting.getViewHeight()).setSplashExtraData(splashAdExtraData).build(), new KsLoadManager.InterstitialAdListener() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter.3
            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onError(int i, String str) {
                YFLog.high(KSInterstitialAdapter.this.tag + " onError " + i + str);
                KSInterstitialAdapter.this.handleFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onRequestResult(int i) {
                YFLog.high(KSInterstitialAdapter.this.tag + "onRequestResult，广告填充数量：" + i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onInterstitialAdLoad(List<KsInterstitialAd> list) {
                YFLog.high(KSInterstitialAdapter.this.tag + "onInterstitialAdLoad");
                if (list != null) {
                    try {
                        if (list.size() != 0 && list.get(0) != null) {
                            KSInterstitialAdapter.this.interstitialAd = list.get(0);
                            KSInterstitialAdapter kSInterstitialAdapter = KSInterstitialAdapter.this;
                            kSInterstitialAdapter.setEcpm(kSInterstitialAdapter.interstitialAd.getECPM());
                            if (KSInterstitialAdapter.this.interstitialAd != null) {
                                KSInterstitialAdapter.this.interstitialAd.setAdInteractionListener(KSInterstitialAdapter.this);
                            }
                            KSInterstitialAdapter.this.handleSucceed();
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        KSInterstitialAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                        return;
                    }
                }
                KSInterstitialAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
            }
        });
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClicked() {
        YFLog.high(this.tag + " onAdClicked");
        handleClick();
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdShow() {
        YFLog.high(this.tag + " onAdShow");
        handleExposure();
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onAdClosed() {
        YFLog.high(this.tag + " onAdClosed");
        closeAds();
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onPageDismiss() {
        YFLog.high(this.tag + " onPageDismiss");
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayError(int i, int i2) {
        YFLog.error(this.tag + " onVideoPlayError,code = " + i + ",extra = " + i2);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayEnd() {
        YFLog.high(this.tag + " onVideoPlayEnd");
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onVideoPlayStart() {
        YFLog.high(this.tag + " onVideoPlayStart");
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
    public void onSkippedAd() {
        YFLog.high(this.tag + " onSkippedAd");
    }

    private void showNativeADs(Activity activity) {
        if (this.nativeAds == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getMaterialType());
            addView(activity);
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            if (this.nativeAds != null) {
                this.nativeAds = null;
            }
            if (this.interstitialAd != null) {
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
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        KsNativeAd ksNativeAd = this.nativeAds;
        String shortString = "";
        if (ksNativeAd != null) {
            ksNativeAd.setBidEcpm(ksNativeAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        KsInterstitialAd ksInterstitialAd = this.interstitialAd;
        if (ksInterstitialAd != null) {
            ksInterstitialAd.setBidEcpm(ksInterstitialAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.nativeAds != null && sdkSupplier != null) {
            this.nativeAds.reportAdExposureFailed(2, KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier()));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (this.interstitialAd == null || sdkSupplier == null) {
            return;
        }
        this.interstitialAd.reportAdExposureFailed(2, KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return KSUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        KsImage ksImage;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = isVideo() || isLive();
        boolean z4 = adBaseViewHolder instanceof AdInterV2ViewHolder;
        if (!this.isSupportShake && interTemplateData.isAction()) {
            if (interTemplateData.isOnlyAction()) {
                interTemplateData.setWholeClick();
            }
            if (z4) {
                interTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue());
            } else {
                interTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
            }
        }
        YFLog.high(this.tag + " bindData isVideo " + isVideo() + " , isLive " + isLive());
        this.feedBean = new FeedBean(this.nativeAds.getProductName(), this.nativeAds.getAdDescription(), z3, interTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z3) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (this.nativeAds.getVideoCoverImage() != null) {
                ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (ksImage = this.nativeAds.getImageList().get(0)) != null && ksImage.isValid() && !TextUtils.isEmpty(ksImage.getImageUrl())) {
                this.feedBean.imageUrl = ksImage.getImageUrl();
                ViewUtils.loadBlurImage(ksImage.getImageUrl(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
                if (z4 && ViewUtils.isHorizontal(ksImage.getWidth(), ksImage.getHeight())) {
                    setHBackground(adBaseViewHolder.showImageArea);
                } else {
                    z = false;
                }
                ViewUtils.loadImage(ksImage.getImageUrl(), adBaseViewHolder.showImg);
                z2 = z;
            }
        }
        interTemplateData.updAdLog(R.mipmap.ad_log_ks_v3);
        String adDescription = TextUtils.isEmpty(this.nativeAds.getProductName()) ? this.nativeAds.getAdDescription() : this.nativeAds.getProductName();
        String productName = TextUtils.isEmpty(this.nativeAds.getAdDescription()) ? this.nativeAds.getProductName() : this.nativeAds.getAdDescription();
        if (z4) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (z2) {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_SMALL);
            } else {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_BIG);
            }
            ViewUtils.loadCircleImage(this.nativeAds.getAppIconUrl(), adInterV2ViewHolder.adIcon, 20);
            TextView textView = adInterV2ViewHolder.adIconName;
            if (adDescription == null) {
                adDescription = "";
            }
            textView.setText(adDescription);
        } else {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            ViewUtils.loadCircleImage(this.nativeAds.getAppIconUrl(), adInterV3ViewHolder.adIcon, 20);
            TextView textView2 = adInterV3ViewHolder.adIconName;
            if (adDescription == null) {
                adDescription = "";
            }
            textView2.setText(adDescription);
        }
        TextView textView3 = adBaseViewHolder.adDes;
        if (productName == null) {
            productName = "";
        }
        textView3.setText(productName);
        adBaseViewHolder.updateShowView(getContext(), interTemplateData);
        adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1125x90973296(view);
            }
        });
        registerViewForInteraction(activity, adBaseViewHolder, interTemplateData, z3, this.nativeAds);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1126x9020cc97(fragmentManager, view);
                }
            });
        }
        complianceContent(adBaseViewHolder, this.nativeAds);
        startCountDown(adBaseViewHolder, interTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ks-KSInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1125x90973296(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ks-KSInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1126x9020cc97(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private boolean isVideo() {
        return this.nativeAds.getMaterialType() == 1;
    }

    private boolean isLive() {
        return this.nativeAds.getMaterialType() == 8;
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd) {
        if (isDownloadType(ksNativeAd)) {
            complianceView(adBaseViewHolder, new DownloadAppInfo(ksNativeAd.getAppName(), ksNativeAd.getAppVersion(), ksNativeAd.getCorporationName(), ksNativeAd.getIntroductionInfoUrl(), ksNativeAd.getPermissionInfoUrl(), ksNativeAd.getAppPrivacyUrl()));
            this.feedBean.updateAppInfo(ksNativeAd.getAppName(), ksNativeAd.getAppVersion(), ksNativeAd.getCorporationName());
        } else {
            adBaseViewHolder.complianceContent.setVisibility(8);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b2  */
    private void registerViewForInteraction(Activity activity, AdBaseViewHolder adBaseViewHolder, BaseTemplateData baseTemplateData, boolean z, KsNativeAd ksNativeAd) {
        int i;
        HashMap map = new HashMap();
        int i2 = 1;
        if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (baseTemplateData.isShowDownloadDialog()) {
                map.put(adInterV2ViewHolder.dyClickView, 2);
                i2 = 2;
            } else {
                map.put(adInterV2ViewHolder.dyClickView, 1);
            }
            if (baseTemplateData.isActionClickType()) {
                if (!isDownloadType(ksNativeAd) || baseTemplateData.isActionShowDialog()) {
                    map.put(adInterV2ViewHolder.animationClickView, 2);
                } else {
                    map.put(adInterV2ViewHolder.animationClickView, 1);
                }
            }
            adBaseViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
        } else {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (baseTemplateData instanceof InterV3TemplateData) {
                if (!((InterV3TemplateData) baseTemplateData).isWholeClick()) {
                    i2 = -1;
                } else if (baseTemplateData.isShowDownloadDialog()) {
                    map.put(adInterV3ViewHolder.viewGroup, 2);
                    i2 = 2;
                } else {
                    map.put(adInterV3ViewHolder.viewGroup, 1);
                }
                map.put(adInterV3ViewHolder.adCloseDelay, 2);
                if (baseTemplateData.isActionClickType()) {
                    if (!isDownloadType(ksNativeAd) || baseTemplateData.isActionShowDialog()) {
                        map.put(adInterV3ViewHolder.animationClickView, 2);
                        map.put(adInterV3ViewHolder.actionView, 2);
                    } else {
                        map.put(adInterV3ViewHolder.animationClickView, 1);
                        map.put(adInterV3ViewHolder.actionView, 1);
                    }
                }
            } else {
                i = -1;
            }
            if (z) {
                bindMediaView(activity, adBaseViewHolder, ksNativeAd, map, baseTemplateData.isMute(), i);
            } else {
                bindImageViews(activity, adBaseViewHolder, ksNativeAd, map);
            }
        }
        i = i2;
        if (z) {
            bindMediaView(activity, adBaseViewHolder, ksNativeAd, map, baseTemplateData.isMute(), i);
        } else {
            bindImageViews(activity, adBaseViewHolder, ksNativeAd, map);
        }
    }

    private boolean isDownloadType(KsNativeAd ksNativeAd) {
        return ksNativeAd.getInteractionType() == 1;
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, final KsNativeAd ksNativeAd, Map<View, Integer> map, boolean z, int i) {
        if (activity != null) {
            View videoView = ksNativeAd.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(!z).build());
            if (videoView != null && videoView.getParent() == null) {
                adBaseViewHolder.mediaViewFrame.removeAllViews();
                adBaseViewHolder.mediaViewFrame.addView(videoView);
            }
            YFLog.debug("mediaViewFrame post: " + adBaseViewHolder.mediaViewFrame.getChildCount());
            if (i != -1) {
                map.put(videoView, Integer.valueOf(i));
            }
            ksNativeAd.registerViewForInteraction(activity, adBaseViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter.4
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
                    KSInterstitialAdapter.this.handleClick();
                    KSInterstitialAdapter.this.closeAdsDelay();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    KSInterstitialAdapter.this.handleExposure();
                }
            });
            ksNativeAd.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter.5
                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayComplete() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayError(int i2, int i3) {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayPause() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayReady() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayResume() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayStart() {
                }
            });
            if (isLive()) {
                YFLog.high("it's a live, do not update mediaViewFrame");
            } else {
                adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1127x240d50e4(adBaseViewHolder, ksNativeAd);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$3$com-yfanads-ads-chanel-ks-KSInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1127x240d50e4(AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd) {
        boolean z = adBaseViewHolder instanceof AdInterV3ViewHolder;
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int videoWidth = ksNativeAd.getVideoWidth();
        int videoHeight = ksNativeAd.getVideoHeight();
        if (z) {
            updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, height, videoWidth, videoHeight);
        } else {
            if (videoWidth <= 0 || videoHeight <= 0) {
                return;
            }
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, width, (videoHeight * width) / videoWidth);
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void onAdapterConfigurationChanged(AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, int i) {
        super.onAdapterConfigurationChanged(adBaseViewHolder, interTemplateData, i);
        updateVideoView(adBaseViewHolder);
    }

    private void updateVideoView(AdBaseViewHolder adBaseViewHolder) {
        if (this.nativeAds != null && isVideo() && (adBaseViewHolder instanceof AdInterV3ViewHolder)) {
            final AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            adInterV3ViewHolder.showArea.post(new Runnable() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1128xbaea3f70(adInterV3ViewHolder);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$updateVideoView$4$com-yfanads-ads-chanel-ks-KSInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1128xbaea3f70(AdInterV3ViewHolder adInterV3ViewHolder) {
        int width = adInterV3ViewHolder.showArea.getWidth();
        int height = adInterV3ViewHolder.showArea.getHeight();
        KsNativeAd ksNativeAd = this.nativeAds;
        int videoWidth = ksNativeAd != null ? ksNativeAd.getVideoWidth() : 0;
        KsNativeAd ksNativeAd2 = this.nativeAds;
        updateMaterialArea(adInterV3ViewHolder.mediaViewFrame, width, height, videoWidth, ksNativeAd2 != null ? ksNativeAd2.getVideoHeight() : 0);
    }

    private void bindImageViews(Activity activity, AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd, Map<View, Integer> map) {
        if (activity != null) {
            ksNativeAd.registerViewForInteraction(activity, adBaseViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSInterstitialAdapter.6
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
                    KSInterstitialAdapter.this.handleClick();
                    KSInterstitialAdapter.this.closeAdsDelay();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    KSInterstitialAdapter.this.handleExposure();
                }
            });
        }
    }
}
