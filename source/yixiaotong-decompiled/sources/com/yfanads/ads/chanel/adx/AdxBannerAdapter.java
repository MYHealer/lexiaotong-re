package com.yfanads.ads.chanel.adx;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.yfanads.ads.chanel.adx.utils.AdxSdkUtil;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.model.AdxImage;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.service.a;
import com.yfanads.android.adx.service.c;
import com.yfanads.android.core.banner.YFBannerSetting;
import com.yfanads.android.custom.BannerCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxBannerAdapter extends BannerCustomAdapter {
    private boolean isAuto;
    private boolean isShakeAction;
    private boolean isShakeActionOne;
    AdxNativeAd nativeAds;

    public static abstract class AdListener implements AdxNativeAd.AdInteractionListener {
        private AdListener() {
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdHide() {
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdShow() {
        }
    }

    public AdxBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
    }

    private void bindImageViews(Activity activity, final AdBannerViewHolder adBannerViewHolder, final AdxNativeAd adxNativeAd, final BannerTemplateData bannerTemplateData, Map<View, Integer> map) {
        if (activity != null) {
            adxNativeAd.registerViewForInteraction(activity, a.BANNER, adBannerViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(this.isAuto, bannerTemplateData), new AdListener() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onAdShakeCancel() {
                    super.onAdShakeCancel();
                    if (AdxBannerAdapter.this.needUpdateAction()) {
                        bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
                        AdxBannerAdapter.this.updateShakeAction(bannerTemplateData);
                        adBannerViewHolder.updateShowView(AdxBannerAdapter.this.getContext(), bannerTemplateData);
                        AdxBannerAdapter.this.updateDownload(bannerTemplateData, adBannerViewHolder);
                    }
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onAdShakeSuccess(boolean z, boolean z2, boolean z3) {
                    super.onAdShakeSuccess(z, z2, z3);
                    if (AdxBannerAdapter.this.needUpdateAction()) {
                        bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
                        AdxBannerAdapter.this.updateShakeAction(bannerTemplateData);
                        adBannerViewHolder.updateShowView(AdxBannerAdapter.this.getContext(), bannerTemplateData);
                        AdxBannerAdapter.this.updateDownload(bannerTemplateData, adBannerViewHolder);
                    }
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onExposure(boolean z) {
                    if (z) {
                        AdxBannerAdapter.this.handleExposure();
                    } else {
                        AdxBannerAdapter.this.handleFailed(YFAdError.ERROR_ADX_EXPOSURE, "exposure url empty");
                    }
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onHandleClick(boolean z) {
                    YFLog.debug(AdxBannerAdapter.this.tag + " onHandleClick");
                    AdxBannerAdapter.this.handleClick(z);
                }
            });
        }
        if (bannerTemplateData.isTemplateV3()) {
            adBannerViewHolder.showImg.post(new Runnable() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1014x4fada033(adxNativeAd, adBannerViewHolder);
                }
            });
        }
    }

    private void bindMediaView(Activity activity, final AdBannerViewHolder adBannerViewHolder, final AdxNativeAd adxNativeAd, final BannerTemplateData bannerTemplateData, Map<View, Integer> map) {
        if (activity != null) {
            adxNativeAd.registerViewForInteraction(activity, a.BANNER, adBannerViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(this.isAuto, bannerTemplateData), new AdListener() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onAdShakeSuccess(boolean z, boolean z2, boolean z3) {
                    super.onAdShakeSuccess(z, z2, z3);
                    if (AdxBannerAdapter.this.needUpdateAction()) {
                        bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
                        AdxBannerAdapter.this.updateShakeAction(bannerTemplateData);
                        adBannerViewHolder.updateShowView(AdxBannerAdapter.this.getContext(), bannerTemplateData);
                        AdxBannerAdapter.this.updateDownload(bannerTemplateData, adBannerViewHolder);
                    }
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onExposure(boolean z) {
                    if (z) {
                        AdxBannerAdapter.this.handleExposure();
                    } else {
                        AdxBannerAdapter.this.handleFailed(YFAdError.ERROR_ADX_EXPOSURE, "exposure url empty");
                    }
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onHandleClick(boolean z) {
                    YFLog.high(" onHandleClick");
                    AdxBannerAdapter.this.handleClick(z);
                }
            });
        }
        final View videoView = adxNativeAd.getVideoView(getContext(), new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ bannerTemplateData.isMute()).build());
        adxNativeAd.setVideoPlayListener(new AdxNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter.5
            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                AdxBannerAdapter.this.updateWithVideoPlayComplete(adBannerViewHolder);
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                AdxBannerAdapter.this.updateWithVideoPlayStart(adBannerViewHolder, bannerTemplateData, adxNativeAd, videoView);
            }
        });
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, AdxNativeAd adxNativeAd) {
        if (adxNativeAd.getInteractionType() == 1) {
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(adxNativeAd.getAppName(), adxNativeAd.getAppVersion(), adxNativeAd.getCorporationName(), adxNativeAd.getIntroductionInfoUrl(), adxNativeAd.getPermissionInfoUrl(), adxNativeAd.getAppPrivacyUrl()));
        } else {
            adBannerViewHolder.complianceContent.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadByNative() {
        AdxSDK.getLoadManager().loadNativeAd(new AdxScene.Builder(AdxSdkUtil.getAdId(this.sdkSupplier)).setEcpm(getEcpm()).setReqId(getRequestId()).adStyle(4).build(), new LoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter.2
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(AdxBannerAdapter.this.tag + " onError " + i + str);
                AdxBannerAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0048 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0048), top: B:16:0x001e }] */
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onNativeAdLoad(List<AdxNativeAd> list) {
                YFLog.high(AdxBannerAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() == 0 || list.get(0) == null) {
                            AdxBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            AdxBannerAdapter.this.nativeAds = list.get(0);
                            AdxBannerAdapter adxBannerAdapter = AdxBannerAdapter.this;
                            adxBannerAdapter.setEcpm(adxBannerAdapter.nativeAds.getECPM());
                            AdxBannerAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        AdxBannerAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    AdxBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needUpdateAction() {
        return this.isShakeAction && this.isShakeActionOne;
    }

    private void registerViewForInteraction(Activity activity, AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData, AdxNativeAd adxNativeAd) {
        HashMap map = new HashMap();
        if (bannerTemplateData.isTemplateV3()) {
            if (bannerTemplateData.isWholeClick()) {
                map.put(adBannerViewHolder.viewGroup, 4);
            }
            map.put(adBannerViewHolder.adCloseDelay, 4);
            if (bannerTemplateData.isShake()) {
                map.put(adBannerViewHolder.showArea, 1);
            }
        } else {
            View view = adBannerViewHolder.dyClickView;
            if (view != null) {
                map.put(view, 4);
            }
        }
        if (bannerTemplateData.isTitleDesClick()) {
            TextView textView = adBannerViewHolder.adDes;
            if (textView != null) {
                map.put(textView, 4);
            }
            TextView textView2 = adBannerViewHolder.titleDes;
            if (textView2 != null) {
                map.put(textView2, 4);
            }
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                TextView textView3 = adBannerViewHolder.mDownload;
                if (textView3 != null) {
                    map.put(textView3, 5);
                }
                map.put(adBannerViewHolder.mDownloadBar, 5);
            } else {
                TextView textView4 = adBannerViewHolder.mDownload;
                if (textView4 != null) {
                    map.put(textView4, 5);
                }
            }
        }
        if (!z) {
            bindImageViews(activity, adBannerViewHolder, adxNativeAd, bannerTemplateData, map);
        } else {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(activity, adBannerViewHolder, adxNativeAd, bannerTemplateData, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownload(BannerTemplateData bannerTemplateData, AdBannerViewHolder adBannerViewHolder) {
        if (!bannerTemplateData.showDownloadBtn()) {
            adBannerViewHolder.mDownload.setVisibility(8);
            return;
        }
        if (!bannerTemplateData.isTemplateV3()) {
            adBannerViewHolder.mDownload.setVisibility(0);
            adBannerViewHolder.mDownload.setText(TextUtils.isEmpty(this.nativeAds.getActionDescription()) ? getContext().getString(R.string.yf_default_download_text) : this.nativeAds.getActionDescription());
        } else if (bannerTemplateData.isShake()) {
            adBannerViewHolder.mDownload.setVisibility(8);
            adBannerViewHolder.mDownloadBar.setVisibility(0);
        } else {
            adBannerViewHolder.mDownload.setVisibility(0);
            adBannerViewHolder.mDownloadBar.setVisibility(8);
            adBannerViewHolder.mDownload.setText(TextUtils.isEmpty(this.nativeAds.getActionDescription()) ? getContext().getString(R.string.yf_default_download_text) : this.nativeAds.getActionDescription());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShakeAction(BannerTemplateData bannerTemplateData) {
        this.isShakeActionOne = bannerTemplateData.isActionOne();
        this.isShakeAction = bannerTemplateData.isShake() || bannerTemplateData.isTwist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithVideoPlayComplete(AdBaseViewHolder adBaseViewHolder) {
        try {
            int width = adBaseViewHolder.mediaViewFrame.getWidth();
            int height = adBaseViewHolder.mediaViewFrame.getHeight();
            YFLog.high("Banner onVideoPlayComplete width " + width + " , height = " + height);
            final ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            AdxNativeAd adxNativeAd = this.nativeAds;
            if (adxNativeAd == null) {
                imageView.setBackgroundResource(R.mipmap.yf_ad_no_bg);
            } else if (adxNativeAd.getEndVideoCoverImage() == null || TextUtils.isEmpty(this.nativeAds.getEndVideoCoverImage().getImageUrl())) {
                this.nativeAds.getEndVideoBitmap(new AdxNativeAd.AdEndBitmap() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter$$ExternalSyntheticLambda0
                    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdEndBitmap
                    public final void onGetData(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                }, width, height);
            } else {
                ViewUtils.loadImage(this.nativeAds.getEndVideoCoverImage().getImageUrl(), imageView);
            }
            adBaseViewHolder.mediaViewFrame.addView(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithVideoPlayStart(final AdBaseViewHolder adBaseViewHolder, final BannerTemplateData bannerTemplateData, final AdxNativeAd adxNativeAd, final View view) {
        adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1015x1cbd264(adBaseViewHolder, adxNativeAd, bannerTemplateData, view);
            }
        });
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final ViewGroup viewGroup, AdBannerViewHolder adBannerViewHolder) {
        AdxImage adxImage;
        final boolean z = this.nativeAds.getMaterialType() == 1;
        if (!this.isSupportShake && bannerTemplateData.isAction()) {
            if (bannerTemplateData.isOnlyAction()) {
                bannerTemplateData.setWholeClick();
            }
            bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        this.isAuto = bannerTemplateData.isAutoClick();
        updateShakeAction(bannerTemplateData);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (this.nativeAds.getVideoCoverImage() == null || this.nativeAds.getVideoCoverImage().getImageUrl() == null) {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            } else {
                ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adBannerViewHolder.imageBlur, 20);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (adxImage = this.nativeAds.getImageList().get(0)) != null && adxImage.isValid() && !TextUtils.isEmpty(adxImage.getImageUrl())) {
                ViewUtils.loadBlurImage(adxImage.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(adxImage.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.setAdx(true);
        bannerTemplateData.updAdLog(R.mipmap.yf_ad_logo);
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        String adDescription = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getAdDescription() : this.nativeAds.getTitle();
        String title = TextUtils.isEmpty(this.nativeAds.getAdDescription()) ? this.nativeAds.getTitle() : this.nativeAds.getAdDescription();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (adDescription == null) {
                adDescription = "";
            }
            textView.setText(adDescription);
        }
        TextView textView2 = adBannerViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView2.setText(title);
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(this.nativeAds.getAppIconUrl())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(this.nativeAds.getAppIconUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        updateDownload(bannerTemplateData, adBannerViewHolder);
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1012lambda$bindData$0$comyfanadsadschaneladxAdxBannerAdapter(z, viewGroup, view);
            }
        });
        registerViewForInteraction(activity, adBannerViewHolder, z, bannerTemplateData, this.nativeAds);
        final FragmentManager fragmentManager = activity.getFragmentManager();
        adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1013lambda$bindData$1$comyfanadsadschaneladxAdxBannerAdapter(fragmentManager, view);
            }
        });
        complianceContent(adBannerViewHolder, bannerTemplateData, this.nativeAds);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        AdxSdkUtil.initAD(this.tag, context, getInitBean(), isListPackage(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                AdxBannerAdapter.this.handleFailed(str, str2);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                AdxBannerAdapter.this.loadByNative();
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        showNativeADs(activity, viewGroup);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return AdxSdkUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.ADX.getValue();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-adx-AdxBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1013lambda$bindData$1$comyfanadsadschaneladxAdxBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new OnFeedClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxBannerAdapter.3
            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onDismiss() {
            }

            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onTraceFeed() {
                if (AdxBannerAdapter.this.nativeAds != null) {
                    FeedCom feedCom = new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(((BannerCustomAdapter) AdxBannerAdapter.this).sdkSupplier), AdxBannerAdapter.this.getRequestId());
                    AdxBannerAdapter adxBannerAdapter = AdxBannerAdapter.this;
                    adxBannerAdapter.nativeAds.traceData(((BannerCustomAdapter) adxBannerAdapter).sdkSupplier != null ? ((BannerCustomAdapter) AdxBannerAdapter.this).sdkSupplier.getTemplateConf() : null, feedCom, false);
                }
            }
        });
    }

    /* JADX INFO: renamed from: lambda$bindImageViews$4$com-yfanads-ads-chanel-adx-AdxBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1014x4fada033(AdxNativeAd adxNativeAd, AdBannerViewHolder adBannerViewHolder) {
        int videoWidth = adxNativeAd.getVideoWidth();
        int videoHeight = adxNativeAd.getVideoHeight();
        updateMaterialArea(adBannerViewHolder.showImg, adBannerViewHolder.showImg.getWidth(), adBannerViewHolder.showImg.getHeight(), videoWidth, videoHeight);
    }

    /* JADX INFO: renamed from: lambda$updateWithVideoPlayStart$3$com-yfanads-ads-chanel-adx-AdxBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1015x1cbd264(AdBaseViewHolder adBaseViewHolder, AdxNativeAd adxNativeAd, BannerTemplateData bannerTemplateData, View view) {
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int videoWidth = adxNativeAd.getVideoWidth();
        int videoHeight = adxNativeAd.getVideoHeight();
        if (bannerTemplateData.isTemplateV3()) {
            updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, height, videoWidth, videoHeight);
        } else if (videoWidth > 0 && videoHeight > 0) {
            FrameLayout frameLayout = adBaseViewHolder.mediaViewFrame;
            ViewUtils.setViewSize(frameLayout, (int) ((((double) videoWidth) / ((double) videoHeight)) * ((double) height)), height);
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adBaseViewHolder.mediaViewFrame.removeAllViews();
        adBaseViewHolder.mediaViewFrame.addView(view);
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAds == null) {
            YFLog.debug(this.tag + " nativeAds is null, return. ");
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_SHOW));
            return;
        }
        if (isBidding()) {
            AdxNativeAd adxNativeAd = this.nativeAds;
            adxNativeAd.setBidEcpm(adxNativeAd.getECPM(), 0L);
        }
        YFLog.debug(this.tag + " adId=" + this.sdkSupplier.getAdId() + " showNativeADs=" + this.nativeAds.getMaterialType() + " showAd=" + addView(activity, viewGroup));
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        AdxNativeAd adxNativeAd = this.nativeAds;
        if (adxNativeAd != null) {
            adxNativeAd.destroy(a.BANNER);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        AdxNativeAd adxNativeAd = this.nativeAds;
        if (adxNativeAd != null) {
            adxNativeAd.reportAdInfo(19, null);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=");
            SdkSupplier sdkSupplier2 = this.sdkSupplier;
            String shortString = "";
            StringBuilder sbAppend2 = sbAppend.append(sdkSupplier2 != null ? sdkSupplier2.toShortString() : "").append(" loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend2.append(shortString).toString());
        }
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-adx-AdxBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1012lambda$bindData$0$comyfanadsadschaneladxAdxBannerAdapter(boolean z, ViewGroup viewGroup, View view) {
        AdxNativeAd adxNativeAd = this.nativeAds;
        if (adxNativeAd != null) {
            if (z) {
                adxNativeAd.reportAdInfo(18, null);
            }
            this.nativeAds.unRegisterViewAction();
        }
        closeAds(viewGroup);
    }
}
