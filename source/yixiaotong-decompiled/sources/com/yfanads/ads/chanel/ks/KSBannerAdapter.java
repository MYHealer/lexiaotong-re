package com.yfanads.ads.chanel.ks;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import com.yfanads.android.core.banner.YFBannerSetting;
import com.yfanads.android.custom.BannerCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSBannerAdapter extends BannerCustomAdapter {
    KsBannerAd bannerAd;
    private boolean hasExposure;
    private final KsBannerAd.BannerAdInteractionListener mBannerAdInteractionListener;
    KsNativeAd nativeAds;

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        this.nativeAds = null;
        this.bannerAd = null;
    }

    public KSBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
        this.hasExposure = false;
        this.mBannerAdInteractionListener = new KsBannerAd.BannerAdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter.3
            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdClicked() {
                YFLog.debug("banner onAdClicked");
                KSBannerAdapter.this.handleClick();
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdShow() {
                YFLog.debug("banner onAdShow hasExposure:" + KSBannerAdapter.this.hasExposure);
                if (KSBannerAdapter.this.hasExposure) {
                    return;
                }
                YFLog.debug("banner real onAdShow");
                KSBannerAdapter.this.hasExposure = true;
                KSBannerAdapter.this.handleExposure();
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdClose() {
                YFLog.debug("banner onAdClose");
                KSBannerAdapter.this.handleClose();
            }

            @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
            public void onAdShowError(int i, String str) {
                YFLog.debug("banner onAdShowError " + i + PPSLabelView.Code + str);
                KSBannerAdapter.this.handleRenderFailed(i, str);
            }
        };
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.KS.getValue();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        if (isNative()) {
            showNativeADs(activity, viewGroup);
        } else if (isBanner()) {
            showBannerAd(activity, viewGroup);
        } else {
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        KsBannerAd ksBannerAd;
        if (!isNative()) {
            return (!isBanner() || (ksBannerAd = this.bannerAd) == null) ? "" : KSUtil.getReqId(ksBannerAd.getMediaExtraInfo());
        }
        KsNativeAd ksNativeAd = this.nativeAds;
        return ksNativeAd != null ? KSUtil.getReqId(ksNativeAd.getMediaExtraInfo()) : "";
    }

    private void showBannerAd(Activity activity, ViewGroup viewGroup) {
        View view = this.bannerAd.getView(activity, this.mBannerAdInteractionListener, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
        if (view == null || viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        int iDip2px = ScreenUtil.dip2px(getContext(), this.setting.getViewWidth());
        if (iDip2px == 0) {
            iDip2px = ScreenUtil.getScreenWidthC(getContext());
        }
        viewGroup.addView(view, new RelativeLayout.LayoutParams(iDip2px, -2));
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        KSUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                KSBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                KSBannerAdapter.this.handleFailed(str, str2);
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
            loadBannerAdByNative();
        } else if (isBanner()) {
            loadBannerAd();
        } else {
            YFLog.error(this.tag + " it's a template ad");
        }
    }

    private void loadBannerAd() {
        KsAdSDK.getLoadManager().loadBannerAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).build(), new KsLoadManager.BannerAdListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
            public void onError(int i, String str) {
                YFLog.high(KSBannerAdapter.this.tag + " loadBannerAd onError " + i + str);
                KSBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
            public void onBannerAdLoad(KsBannerAd ksBannerAd) {
                KSBannerAdapter.this.bannerAd = ksBannerAd;
                int ecpm = ksBannerAd.getECPM();
                KSBannerAdapter.this.setEcpm(ecpm);
                YFLog.high(KSBannerAdapter.this.tag + " loadBannerAd load ep_" + ecpm);
                KSBannerAdapter.this.handleSucceed();
            }
        });
    }

    private void loadBannerAdByNative() {
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
        KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).setNativeAdExtraData(nativeAdExtraData).build(), new KsLoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter.4
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(KSBannerAdapter.this.tag + " loadBannerAdByNative onError " + i + str);
                KSBannerAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0048 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0048), top: B:16:0x001e }] */
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(List<KsNativeAd> list) {
                YFLog.high(KSBannerAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() == 0 || list.get(0) == null) {
                            KSBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            KSBannerAdapter.this.nativeAds = list.get(0);
                            KSBannerAdapter kSBannerAdapter = KSBannerAdapter.this;
                            kSBannerAdapter.setEcpm(kSBannerAdapter.nativeAds.getECPM());
                            KSBannerAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        KSBannerAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    KSBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAds == null || viewGroup == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getMaterialType());
            addView(activity, viewGroup);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        KsNativeAd ksNativeAd = this.nativeAds;
        if (ksNativeAd != null) {
            ksNativeAd.setBidEcpm(ksNativeAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
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
        if (this.nativeAds == null || sdkSupplier == null) {
            return;
        }
        this.nativeAds.reportAdExposureFailed(2, KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return KSUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final ViewGroup viewGroup, AdBannerViewHolder adBannerViewHolder) {
        KsImage ksImage;
        String actionDescription;
        boolean z = isVideo() || isLive();
        if (!this.isSupportShake && bannerTemplateData.isAction()) {
            if (bannerTemplateData.isOnlyAction()) {
                bannerTemplateData.setWholeClick();
            }
            bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        this.feedBean = new FeedBean(this.nativeAds.getProductName(), this.nativeAds.getAdDescription(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        YFLog.high(this.tag + " bindData isVideo " + isVideo() + " , isLive " + isLive());
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (this.nativeAds.getVideoCoverImage() != null) {
                ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (ksImage = this.nativeAds.getImageList().get(0)) != null && ksImage.isValid() && !TextUtils.isEmpty(ksImage.getImageUrl())) {
                this.feedBean.imageUrl = ksImage.getImageUrl();
                ViewUtils.loadBlurImage(ksImage.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(ksImage.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_ks_v3);
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        String adDescription = TextUtils.isEmpty(this.nativeAds.getProductName()) ? this.nativeAds.getAdDescription() : this.nativeAds.getProductName();
        String productName = TextUtils.isEmpty(this.nativeAds.getAdDescription()) ? this.nativeAds.getProductName() : this.nativeAds.getAdDescription();
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
                if (TextUtils.isEmpty(this.nativeAds.getActionDescription())) {
                    actionDescription = getContext().getString(R.string.yf_default_download_text);
                } else {
                    actionDescription = this.nativeAds.getActionDescription();
                }
                textView3.setText(actionDescription);
                if (this.feedBean != null) {
                    this.feedBean.actBtnString = this.nativeAds.getActionDescription();
                }
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(this.nativeAds.getAppIconUrl())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(this.nativeAds.getAppIconUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1122lambda$bindData$0$comyfanadsadschanelksKSBannerAdapter(viewGroup, view);
            }
        });
        registerViewForInteraction(activity, adBannerViewHolder, z, bannerTemplateData, this.nativeAds);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1123lambda$bindData$1$comyfanadsadschanelksKSBannerAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, this.nativeAds);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ks-KSBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1122lambda$bindData$0$comyfanadsadschanelksKSBannerAdapter(ViewGroup viewGroup, View view) {
        closeAds(viewGroup);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ks-KSBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1123lambda$bindData$1$comyfanadsadschanelksKSBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private boolean isVideo() {
        return this.nativeAds.getMaterialType() == 1;
    }

    private boolean isLive() {
        return this.nativeAds.getMaterialType() == 8;
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public boolean isDownloadType() {
        KsNativeAd ksNativeAd = this.nativeAds;
        if (ksNativeAd != null) {
            return isDownloadAd(ksNativeAd);
        }
        return super.isDownloadType();
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, KsNativeAd ksNativeAd) {
        if (isDownloadAd(ksNativeAd)) {
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(ksNativeAd.getAppName(), ksNativeAd.getAppVersion(), ksNativeAd.getCorporationName(), ksNativeAd.getIntroductionInfoUrl(), ksNativeAd.getPermissionInfoUrl(), ksNativeAd.getAppPrivacyUrl()));
            this.feedBean.updateAppInfo(ksNativeAd.getAppName(), ksNativeAd.getAppVersion(), ksNativeAd.getCorporationName());
        } else {
            adBannerViewHolder.complianceContent.setVisibility(8);
        }
    }

    private boolean isDownloadAd(KsNativeAd ksNativeAd) {
        return ksNativeAd.getInteractionType() == 1;
    }

    private void registerViewForInteraction(Activity activity, AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData, KsNativeAd ksNativeAd) {
        int i;
        HashMap map = new HashMap();
        int i2 = 2;
        int i3 = 1;
        if (bannerTemplateData.isShowDownloadDialog()) {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    map.put(adBannerViewHolder.viewGroup, 2);
                } else {
                    i2 = -1;
                }
                map.put(adBannerViewHolder.adCloseDelay, 2);
            } else {
                map.put(adBannerViewHolder.dyClickView, 2);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                map.put(adBannerViewHolder.adDes, 2);
                map.put(adBannerViewHolder.titleDes, 2);
            }
            i = i2;
        } else {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    map.put(adBannerViewHolder.viewGroup, 1);
                } else {
                    i3 = -1;
                }
                map.put(adBannerViewHolder.adCloseDelay, 1);
            } else {
                map.put(adBannerViewHolder.dyClickView, 1);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                map.put(adBannerViewHolder.adDes, 1);
                map.put(adBannerViewHolder.titleDes, 1);
            }
            i = i3;
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                if (!isDownloadAd(ksNativeAd) || bannerTemplateData.isActionShowDialog()) {
                    map.put(adBannerViewHolder.mDownloadBar, 2);
                } else {
                    map.put(adBannerViewHolder.mDownloadBar, 1);
                }
            } else if (!isDownloadAd(ksNativeAd) || bannerTemplateData.isActionShowDialog()) {
                map.put(adBannerViewHolder.mDownload, 2);
            } else {
                map.put(adBannerViewHolder.mDownload, 1);
            }
        }
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(activity, adBannerViewHolder, ksNativeAd, bannerTemplateData, map, i);
        } else {
            bindImageViews(activity, adBannerViewHolder, ksNativeAd, map);
        }
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, final KsNativeAd ksNativeAd, final BannerTemplateData bannerTemplateData, Map<View, Integer> map, int i) {
        if (activity != null) {
            View videoView = ksNativeAd.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ bannerTemplateData.isMute()).build());
            if (videoView != null && videoView.getParent() == null) {
                adBaseViewHolder.mediaViewFrame.removeAllViews();
                adBaseViewHolder.mediaViewFrame.addView(videoView);
            }
            if (i != -1) {
                map.put(videoView, Integer.valueOf(i));
            }
            ksNativeAd.registerViewForInteraction(activity, adBaseViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter.5
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
                    KSBannerAdapter.this.handleClick();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    YFLog.high(KSBannerAdapter.this.tag + " native media onAdShow");
                    KSBannerAdapter.this.handleExposure();
                }
            });
        }
        ksNativeAd.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter.6
            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayReady() {
                YFLog.high(KSBannerAdapter.this.tag + " onVideoPlayReady");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                YFLog.high(KSBannerAdapter.this.tag + " onVideoPlayStart");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                YFLog.high(KSBannerAdapter.this.tag + " onVideoPlayComplete");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayError(int i2, int i3) {
                YFLog.error(KSBannerAdapter.this.tag + " onVideoPlayError,code = " + i2 + ",extra = " + i3);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                YFLog.high(KSBannerAdapter.this.tag + " onVideoPlayPause");
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                YFLog.high(KSBannerAdapter.this.tag + " onVideoPlayResume");
            }
        });
        if (isLive()) {
            YFLog.high("it's a live, do not update mediaViewFrame");
        } else {
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1124lambda$bindMediaView$3$comyfanadsadschanelksKSBannerAdapter(adBaseViewHolder, ksNativeAd, bannerTemplateData);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$3$com-yfanads-ads-chanel-ks-KSBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1124lambda$bindMediaView$3$comyfanadsadschanelksKSBannerAdapter(AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd, BannerTemplateData bannerTemplateData) {
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

    private void bindImageViews(Activity activity, AdBannerViewHolder adBannerViewHolder, KsNativeAd ksNativeAd, Map<View, Integer> map) {
        if (activity != null) {
            ksNativeAd.registerViewForInteraction(activity, adBannerViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSBannerAdapter.7
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
                    KSBannerAdapter.this.handleClick();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    YFLog.high(KSBannerAdapter.this.tag + " native image onAdShow");
                    KSBannerAdapter.this.handleExposure();
                }
            });
        }
    }
}
