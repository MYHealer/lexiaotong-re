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
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import com.yfanads.android.core.toppush.YFTopPushSetting;
import com.yfanads.android.custom.TopPushCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdTopPushViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.TopPushTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSTopPushAdapter extends TopPushCustomAdapter {
    KsNativeAd nativeAds;

    public KSTopPushAdapter(YFTopPushSetting yFTopPushSetting) {
        super(yFTopPushSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.KS.getValue();
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        if (isNative()) {
            showNativeADs(activity);
        } else {
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        KsNativeAd ksNativeAd;
        return (!isNative() || (ksNativeAd = this.nativeAds) == null) ? "" : KSUtil.getReqId(ksNativeAd.getMediaExtraInfo());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        KSUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ks.KSTopPushAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                KSTopPushAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                KSTopPushAdapter.this.handleFailed(str, str2);
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
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
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
        KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).setNativeAdExtraData(nativeAdExtraData).build(), new KsLoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.ks.KSTopPushAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(KSTopPushAdapter.this.tag + " onError " + i + str);
                KSTopPushAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0048 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0048), top: B:16:0x001e }] */
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(List<KsNativeAd> list) {
                YFLog.high(KSTopPushAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.isEmpty() || list.get(0) == null) {
                            KSTopPushAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            KSTopPushAdapter.this.nativeAds = list.get(0);
                            KSTopPushAdapter kSTopPushAdapter = KSTopPushAdapter.this;
                            kSTopPushAdapter.setEcpm(kSTopPushAdapter.nativeAds.getECPM());
                            KSTopPushAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        KSTopPushAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    KSTopPushAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    private void showNativeADs(Activity activity) {
        if (this.nativeAds == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getMaterialType());
            addView(activity);
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

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void bindData(Activity activity, TopPushTemplateData topPushTemplateData, AdBaseViewHolder adBaseViewHolder) {
        KsImage ksImage;
        boolean z = isVideo() || isLive();
        YFLog.high(this.tag + " bindData isVideo " + isVideo() + " , isLive " + isLive());
        this.feedBean = new FeedBean(this.nativeAds.getProductName(), this.nativeAds.getAdDescription(), z, topPushTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (this.nativeAds.getVideoCoverImage() != null) {
                ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adBaseViewHolder.imageBlur, 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (ksImage = this.nativeAds.getImageList().get(0)) != null && ksImage.isValid() && !TextUtils.isEmpty(ksImage.getImageUrl())) {
                this.feedBean.imageUrl = ksImage.getImageUrl();
                ViewUtils.loadBlurImage(ksImage.getImageUrl(), adBaseViewHolder.imageBlur, 0);
                ViewUtils.loadImage(ksImage.getImageUrl(), adBaseViewHolder.showImg);
            }
        }
        topPushTemplateData.updAdLog(R.mipmap.ad_log_ks_v4);
        String adDescription = TextUtils.isEmpty(this.nativeAds.getProductName()) ? this.nativeAds.getAdDescription() : this.nativeAds.getProductName();
        String productName = TextUtils.isEmpty(this.nativeAds.getAdDescription()) ? this.nativeAds.getProductName() : this.nativeAds.getAdDescription();
        if (topPushTemplateData.isReplaceTitle()) {
            if (!TextUtils.isEmpty(topPushTemplateData.getReplaceTitle())) {
                adDescription = topPushTemplateData.getReplaceTitle();
            }
            if (!TextUtils.isEmpty(topPushTemplateData.getReplaceDesc())) {
                productName = topPushTemplateData.getReplaceDesc();
            }
        }
        AdTopPushViewHolder adTopPushViewHolder = (AdTopPushViewHolder) adBaseViewHolder;
        ViewUtils.loadCircleImage(this.nativeAds.getAppIconUrl(), adTopPushViewHolder.adIcon, 8);
        TextView textView = adTopPushViewHolder.titleDes;
        if (adDescription == null) {
            adDescription = "";
        }
        textView.setText(adDescription);
        TextView textView2 = adTopPushViewHolder.adDes;
        if (productName == null) {
            productName = "";
        }
        textView2.setText(productName);
        adTopPushViewHolder.updateShowView(getContext(), topPushTemplateData);
        adTopPushViewHolder.getCloseView(topPushTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSTopPushAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1135lambda$bindData$0$comyfanadsadschanelksKSTopPushAdapter(view);
            }
        });
        registerViewForInteraction(activity, adTopPushViewHolder, topPushTemplateData, z, this.nativeAds);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adTopPushViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSTopPushAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1136lambda$bindData$1$comyfanadsadschanelksKSTopPushAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adTopPushViewHolder, this.nativeAds);
        startCountDown(adTopPushViewHolder, topPushTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ks-KSTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1135lambda$bindData$0$comyfanadsadschanelksKSTopPushAdapter(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ks-KSTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1136lambda$bindData$1$comyfanadsadschanelksKSTopPushAdapter(FragmentManager fragmentManager, View view) {
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

    private void registerViewForInteraction(Activity activity, AdTopPushViewHolder adTopPushViewHolder, BaseTemplateData baseTemplateData, boolean z, KsNativeAd ksNativeAd) {
        int i;
        HashMap map = new HashMap();
        boolean zIsActionType = baseTemplateData.isActionType(BaseTemplateData.InteractiveStyle.CLICK_SLIDE.getValue());
        int i2 = zIsActionType ? 1 : 3;
        int i3 = zIsActionType ? 2 : 4;
        YFLog.debug(this.tag + "registerViewForInteraction slideJump " + zIsActionType + ",convertType " + i2 + ",convertTypeWithDialog " + i3);
        if (baseTemplateData.isShowDownloadDialog()) {
            map.put(adTopPushViewHolder.viewGroup, Integer.valueOf(i3));
            i = i3;
        } else {
            map.put(adTopPushViewHolder.viewGroup, Integer.valueOf(i2));
            i = i2;
        }
        if (adTopPushViewHolder.adCloseDelay != null) {
            map.put(adTopPushViewHolder.adCloseDelay, Integer.valueOf(i));
        }
        if (z) {
            bindMediaView(activity, adTopPushViewHolder, ksNativeAd, map, baseTemplateData.isMute(), i);
        } else {
            bindImageViews(activity, adTopPushViewHolder, ksNativeAd, map);
        }
    }

    private boolean isDownloadType(KsNativeAd ksNativeAd) {
        return ksNativeAd.getInteractionType() == 1;
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, final KsNativeAd ksNativeAd, Map<View, Integer> map, boolean z, int i) {
        if (activity != null) {
            final View videoView = ksNativeAd.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(!z).build());
            if (videoView != null && videoView.getParent() == null) {
                adBaseViewHolder.mediaViewFrame.removeAllViews();
                adBaseViewHolder.mediaViewFrame.addView(videoView);
            }
            YFLog.debug("mediaViewFrame post: " + adBaseViewHolder.mediaViewFrame.getChildCount());
            map.put(videoView, Integer.valueOf(i));
            map.put(adBaseViewHolder.mediaViewFrame, Integer.valueOf(i));
            ksNativeAd.registerViewForInteraction(activity, adBaseViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSTopPushAdapter.3
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
                    KSTopPushAdapter.this.handleClick();
                    KSTopPushAdapter.this.closeAdsDelay();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    KSTopPushAdapter.this.handleExposure();
                }
            });
            ksNativeAd.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.ks.KSTopPushAdapter.4
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
                adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.ks.KSTopPushAdapter$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1137x3de721e0(adBaseViewHolder, ksNativeAd, videoView);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$2$com-yfanads-ads-chanel-ks-KSTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1137x3de721e0(AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd, View view) {
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int videoWidth = ksNativeAd.getVideoWidth();
        int videoHeight = ksNativeAd.getVideoHeight();
        if (adBaseViewHolder instanceof AdTopPushViewHolder) {
            updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, height, videoWidth, videoHeight);
        } else {
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, width, (int) (((double) width) / (((double) videoWidth) / ((double) videoHeight))));
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adBaseViewHolder.mediaViewFrame.removeAllViews();
        adBaseViewHolder.mediaViewFrame.addView(view);
    }

    private void bindImageViews(Activity activity, AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd, Map<View, Integer> map) {
        if (activity != null) {
            ksNativeAd.registerViewForInteraction(activity, adBaseViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSTopPushAdapter.5
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
                    KSTopPushAdapter.this.handleClick();
                    KSTopPushAdapter.this.closeAdsDelay();
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    KSTopPushAdapter.this.handleExposure();
                }
            });
        }
    }
}
