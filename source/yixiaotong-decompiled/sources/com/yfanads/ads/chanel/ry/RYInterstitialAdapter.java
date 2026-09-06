package com.yfanads.ads.chanel.ry;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.AdVideo;
import com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.api.interstitial.InterstitialAdLoadListener;
import com.hihonor.adsdk.base.api.interstitial.InterstitialExpressAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;
import com.hihonor.adsdk.interstitial.InterstitialAdLoad;
import com.hihonor.adsdk.picturetextad.PictureTextAdLoad;
import com.hihonor.adsdk.picturetextad.PictureTextAdRootView;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.ads.chanel.ry.utils.RYUtil;
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
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class RYInterstitialAdapter extends InterstitialCustomAdapter implements InterstitialAdLoadListener, PictureTextAdLoadListener {
    private InterstitialExpressAd interstitialAd;
    private AdVideo mAdVideo;
    private View mAdView;
    private PictureTextExpressAd nativeAd;

    public RYInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.RY.getValue();
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
        InterstitialExpressAd interstitialExpressAd = this.interstitialAd;
        if (interstitialExpressAd != null) {
            interstitialExpressAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.RYInterstitialAdapter.1
                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdImpression() {
                    RYInterstitialAdapter.this.handleExposure();
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdImpressionFailed(int i, String str) {
                    RYInterstitialAdapter.this.handleFailed(i, str);
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdClicked() {
                    RYInterstitialAdapter.this.handleClick();
                    RYInterstitialAdapter.this.closeAdsDelay();
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onAdClosed() {
                    RYInterstitialAdapter.this.handleClose();
                }

                @Override // com.hihonor.adsdk.base.callback.AdListener
                public void onMiniAppStarted() {
                    super.onMiniAppStarted();
                }
            });
            this.interstitialAd.show(activity);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YFLog.debug(this.tag + "startLoadAD adType = " + this.sdkSupplier.adType);
        RYUtil.initRY(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ry.RYInterstitialAdapter.2
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                RYInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                RYInterstitialAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            loadInterstitialAdByNative();
        } else {
            loadInterstitialAd();
        }
    }

    private void loadInterstitialAdByNative() {
        new PictureTextAdLoad.Builder().setPictureTextAdLoadListener(this).setAdSlot(new AdSlot.Builder().setSlotId(this.sdkSupplier.getPotId()).setRenderType(1).build()).build().loadAd();
    }

    private void loadInterstitialAd() {
        new InterstitialAdLoad.Builder().setInterstitialAdLoadListener(this).setAdSlot(new AdSlot.Builder().setSlotId(this.sdkSupplier.getPotId()).build()).build().loadAd();
    }

    private void showNativeADs(Activity activity) {
        if (this.nativeAd == null) {
            YFLog.error(this.tag + " nativeAd is null, return. ");
            handleShowFailed();
        } else {
            YFLog.debug(this.tag + "showNativeADs adId = " + this.sdkSupplier.getAdId());
            addView(activity, new PictureTextAdRootView(getContext()));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        InterstitialExpressAd interstitialExpressAd = this.interstitialAd;
        String shortString = "";
        if (interstitialExpressAd != null) {
            interstitialExpressAd.sendWinNotification(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0L);
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        PictureTextExpressAd pictureTextExpressAd = this.nativeAd;
        if (pictureTextExpressAd != null) {
            pictureTextExpressAd.sendWinNotification(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0L);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        InterstitialExpressAd interstitialExpressAd = this.interstitialAd;
        if (interstitialExpressAd != null && sdkSupplier != null) {
            interstitialExpressAd.sendLossNotification(sdkSupplier.ecpm, ErrorCode.AD_BID_FAILED, sdkSupplier.getAdnId());
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        PictureTextExpressAd pictureTextExpressAd = this.nativeAd;
        if (pictureTextExpressAd == null || sdkSupplier == null) {
            return;
        }
        pictureTextExpressAd.sendLossNotification(sdkSupplier.ecpm, ErrorCode.AD_BID_FAILED, sdkSupplier.getAdnId());
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return RYUtil.getAdInfo(this.nativeAd, getRequestId());
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        PictureTextExpressAd pictureTextExpressAd = this.nativeAd;
        if (pictureTextExpressAd == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        boolean zHasVideo = pictureTextExpressAd.hasVideo();
        boolean z = adBaseViewHolder instanceof AdInterV2ViewHolder;
        YFLog.high(this.tag + " bindData isVideo " + zHasVideo);
        this.feedBean = new FeedBean(this.nativeAd.getTitle(), this.nativeAd.getBrand(), zHasVideo, interTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        int i = 1;
        boolean z2 = false;
        if (zHasVideo) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (!TextUtils.isEmpty(this.nativeAd.getCoverUrl())) {
                ViewUtils.loadBlurImage(this.nativeAd.getCoverUrl(), adBaseViewHolder.imageBlur, z ? 20 : 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            YFLog.debug(this.tag + " showNativeADs image size = " + this.nativeAd.getImgWidth() + " , " + this.nativeAd.getImgHeight());
            if (this.nativeAd.getImages() != null && !this.nativeAd.getImages().isEmpty()) {
                String str = this.nativeAd.getImages().get(0);
                this.feedBean.imageUrl = str;
                if (!TextUtils.isEmpty(str)) {
                    ViewUtils.loadBlurImage(str, adBaseViewHolder.imageBlur, z ? 20 : 0);
                    if (z && ViewUtils.isHorizontal(this.nativeAd.getImgWidth(), this.nativeAd.getImgHeight())) {
                        setHBackground(adBaseViewHolder.showImageArea);
                        z2 = true;
                    }
                    ViewUtils.loadImage(str, adBaseViewHolder.showImg);
                }
            }
        }
        String title = this.nativeAd.getTitle();
        String title2 = this.nativeAd.getTitle();
        interTemplateData.updAdLog(R.mipmap.ad_log_ry_v3);
        if (z) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (z2) {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_SMALL);
            } else {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_BIG);
            }
            ViewUtils.loadCircleImage(this.nativeAd.getLogo(), adInterV2ViewHolder.adIcon, 20);
            adInterV2ViewHolder.adIconName.setText(title == null ? "" : title);
        } else {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            ViewUtils.loadCircleImage(this.nativeAd.getLogo(), adInterV3ViewHolder.adIcon, 20);
            adInterV3ViewHolder.adIconName.setText(title == null ? "" : title);
        }
        TextView textView = adBaseViewHolder.adDes;
        if (title == null) {
            title2 = "";
        }
        textView.setText(title2);
        adBaseViewHolder.updateShowView(getContext(), interTemplateData);
        if (z && !interTemplateData.isActionType(BaseTemplateData.InteractiveStyle.CLICK.getValue())) {
            adBaseViewHolder.setInteractionVisible(4);
        }
        adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ry.RYInterstitialAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1151xf7c56ef6(view);
            }
        });
        if (activity != null && activity.getResources() != null && activity.getResources().getConfiguration() != null) {
            i = activity.getResources().getConfiguration().orientation;
        }
        registerViewForInteraction(adBaseViewHolder, interTemplateData, zHasVideo, this.nativeAd, i);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ry.RYInterstitialAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1152xf74f08f7(fragmentManager, view);
                }
            });
        }
        complianceContent(adBaseViewHolder, z, this.nativeAd);
        startCountDown(adBaseViewHolder, interTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ry-RYInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1151xf7c56ef6(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ry-RYInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1152xf74f08f7(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder, boolean z, PictureTextExpressAd pictureTextExpressAd) {
        if (isDownloadAd(pictureTextExpressAd)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (z) {
                layoutParams.rightMargin = ScreenUtil.dip2px(getContext(), 10.0f);
                layoutParams.leftMargin = ScreenUtil.dip2px(getContext(), 10.0f);
                layoutParams.bottomMargin = ScreenUtil.dip2px(getContext(), 10.0f);
                layoutParams.addRule(12);
                adBaseViewHolder.comlianceArea.setLayoutParams(layoutParams);
            }
            complianceView(adBaseViewHolder, new DownloadAppInfo(pictureTextExpressAd.getBrand(), pictureTextExpressAd.getAppVersion(), pictureTextExpressAd.getDeveloperName(), pictureTextExpressAd.getIntroUrl(), pictureTextExpressAd.getPermissionsUrl(), pictureTextExpressAd.getPrivacyAgreementUrl()));
            if (this.feedBean != null) {
                this.feedBean.updateAppInfo(pictureTextExpressAd.getBrand(), pictureTextExpressAd.getAppVersion(), pictureTextExpressAd.getDeveloperName());
                return;
            }
            return;
        }
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void onAdapterConfigurationChanged(AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, int i) {
        super.onAdapterConfigurationChanged(adBaseViewHolder, interTemplateData, i);
        updateContentView(adBaseViewHolder, interTemplateData);
    }

    private void updateContentView(final AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData) {
        if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            final AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (this.nativeAd == null) {
                return;
            }
            adInterV3ViewHolder.showArea.post(new Runnable() { // from class: com.yfanads.ads.chanel.ry.RYInterstitialAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1153xe2b92ecc(adInterV3ViewHolder, adBaseViewHolder);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$updateContentView$2$com-yfanads-ads-chanel-ry-RYInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1153xe2b92ecc(AdInterV3ViewHolder adInterV3ViewHolder, AdBaseViewHolder adBaseViewHolder) {
        int videoWidth = this.nativeAd.getVideoWidth();
        int videoHeight = this.nativeAd.getVideoHeight();
        int width = adInterV3ViewHolder.showArea.getWidth();
        int height = adInterV3ViewHolder.showArea.getHeight();
        YFLog.debug("updateContentView w" + width + "|h" + height);
        updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, height, videoWidth, videoHeight);
    }

    private void registerViewForInteraction(AdBaseViewHolder adBaseViewHolder, BaseTemplateData baseTemplateData, boolean z, PictureTextExpressAd pictureTextExpressAd, int i) {
        List<View> arrayList = new ArrayList<>();
        if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            arrayList.add(adInterV2ViewHolder.dyClickView);
            if (baseTemplateData.isActionClickType()) {
                arrayList.add(adInterV2ViewHolder.animationClickView);
            }
            if (z) {
                bindMediaView((PictureTextAdRootView) adInterV2ViewHolder.nativeAdContainer, adInterV2ViewHolder, baseTemplateData, pictureTextExpressAd, arrayList, i);
                return;
            } else {
                bindImageViews((PictureTextAdRootView) adInterV2ViewHolder.nativeAdContainer, pictureTextExpressAd, arrayList);
                return;
            }
        }
        if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (baseTemplateData instanceof InterV3TemplateData) {
                if (((InterV3TemplateData) baseTemplateData).isWholeClick()) {
                    arrayList.add(adInterV3ViewHolder.viewGroup);
                } else if (baseTemplateData.isActionClickType()) {
                    arrayList.add(adInterV3ViewHolder.actionView);
                    arrayList.add(adInterV3ViewHolder.animationClickView);
                }
                arrayList.add(adInterV3ViewHolder.adCloseDelay);
            }
            if (z) {
                bindMediaView((PictureTextAdRootView) adInterV3ViewHolder.nativeAdContainer, adInterV3ViewHolder, baseTemplateData, pictureTextExpressAd, arrayList, i);
            } else {
                bindImageViews((PictureTextAdRootView) adInterV3ViewHolder.nativeAdContainer, pictureTextExpressAd, arrayList);
            }
        }
    }

    private void bindMediaView(PictureTextAdRootView pictureTextAdRootView, AdBaseViewHolder adBaseViewHolder, BaseTemplateData baseTemplateData, PictureTextExpressAd pictureTextExpressAd, List<View> list, int i) {
        this.mAdVideo = pictureTextExpressAd.getAdVideo();
        setNativeAdListener(pictureTextExpressAd);
        if (this.mAdVideo != null) {
            addVideoView(pictureTextAdRootView, list, adBaseViewHolder, baseTemplateData, pictureTextExpressAd, i);
        } else {
            pictureTextAdRootView.setAd(pictureTextExpressAd);
            pictureTextAdRootView.registerViewForInteraction(list);
        }
    }

    private void addVideoView(final PictureTextAdRootView pictureTextAdRootView, final List<View> list, final AdBaseViewHolder adBaseViewHolder, final BaseTemplateData baseTemplateData, final PictureTextExpressAd pictureTextExpressAd, int i) {
        try {
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.ry.RYInterstitialAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1150x59c7d911(pictureTextExpressAd, adBaseViewHolder, baseTemplateData, pictureTextAdRootView, list);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: lambda$addVideoView$3$com-yfanads-ads-chanel-ry-RYInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1150x59c7d911(PictureTextExpressAd pictureTextExpressAd, AdBaseViewHolder adBaseViewHolder, BaseTemplateData baseTemplateData, PictureTextAdRootView pictureTextAdRootView, List list) {
        int videoWidth = pictureTextExpressAd.getVideoWidth();
        int videoHeight = pictureTextExpressAd.getVideoHeight();
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        YFLog.debug("addVideoView vw" + videoWidth + "|vh" + videoHeight);
        boolean z = adBaseViewHolder instanceof AdInterV3ViewHolder;
        FrameLayout frameLayout = adBaseViewHolder.mediaViewFrame;
        if (!z) {
            width = baseTemplateData.popWidth;
        }
        updateMaterialArea(frameLayout, width, z ? height : baseTemplateData.popHeight, videoWidth, videoHeight);
        boolean zIsHorizontal = ViewUtils.isHorizontal(videoWidth, videoHeight);
        View videoView = this.mAdVideo.getVideoView(new AdVideoSize(zIsHorizontal ? -1 : -2, zIsHorizontal ? -2 : -1));
        this.mAdView = videoView;
        if (videoView.getParent() == null) {
            adBaseViewHolder.mediaViewFrame.removeAllViews();
            adBaseViewHolder.mediaViewFrame.addView(this.mAdView);
        }
        pictureTextAdRootView.setAd(pictureTextExpressAd);
        pictureTextAdRootView.registerViewForInteraction(list);
        setVideoAdListener(baseTemplateData.isMute());
        ((FrameLayout.LayoutParams) this.mAdView.getLayoutParams()).gravity = 17;
    }

    private void bindImageViews(PictureTextAdRootView pictureTextAdRootView, PictureTextExpressAd pictureTextExpressAd, List<View> list) {
        setNativeAdListener(pictureTextExpressAd);
        pictureTextAdRootView.setAd(pictureTextExpressAd);
        pictureTextAdRootView.registerViewForInteraction(list);
    }

    private void setVideoAdListener(final boolean z) {
        this.mAdVideo.setVideoListener(new OnVideoPlayListener() { // from class: com.yfanads.ads.chanel.ry.RYInterstitialAdapter.3
            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onProgressUpdate(long j, long j2, long j3) {
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoBuffering(boolean z2) {
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPrepare() {
                RYInterstitialAdapter.this.mAdVideo.setMuted(z);
                YFLog.debug(RYInterstitialAdapter.this.tag + "onVideoPrepare: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoStart() {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onVideoStart: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPause() {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onVideoPause: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoResume() {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onVideoResume: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoEnd() {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onVideoEnd: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoError(int i, String str) {
                RYInterstitialAdapter.this.handleFailed(i, str);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoMute(boolean z2) {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onVideoMute: " + z2);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoSizeChange(AdVideoSize adVideoSize) {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onVideoSizeChange: " + adVideoSize.getWidth() + "," + adVideoSize.getHeight());
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPrepared() {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onVideoPrepared: ");
            }
        });
    }

    private void setNativeAdListener(PictureTextExpressAd pictureTextExpressAd) {
        pictureTextExpressAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.RYInterstitialAdapter.4
            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClosed() {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onAdClosed: ");
                RYInterstitialAdapter.this.closeAds();
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdSkip(int i) {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onAdSkip: ");
                RYInterstitialAdapter.this.closeAds();
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClicked() {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onAdSkip: ");
                RYInterstitialAdapter.this.handleClick();
                if (RYInterstitialAdapter.this.isNative()) {
                    RYInterstitialAdapter.this.closeAdsDelay();
                }
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdImpression() {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onAdImpression: ");
                RYInterstitialAdapter.this.handleExposure();
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdImpressionFailed(int i, String str) {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onAdImpressionFailed: " + i + "," + str);
                RYInterstitialAdapter.this.handleFailed(i, str);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onMiniAppStarted() {
                YFLog.debug(RYInterstitialAdapter.this.tag + "onMiniAppStarted: ");
            }
        });
    }

    private boolean isDownloadAd(PictureTextExpressAd pictureTextExpressAd) {
        return pictureTextExpressAd.getPromotionPurpose() == 0;
    }

    @Override // com.hihonor.adsdk.base.api.interstitial.InterstitialAdLoadListener
    public void onAdLoaded(InterstitialExpressAd interstitialExpressAd) {
        this.interstitialAd = interstitialExpressAd;
        handleSucceed();
    }

    @Override // com.hihonor.adsdk.base.callback.BaseListener
    public void onFailed(String str, String str2) {
        handleFailed(str, str2);
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener
    public void onAdLoaded(List<PictureTextExpressAd> list) {
        YFLog.high(this.tag + " onNativeAdLoad");
        loadSuccess(list);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0029 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:3:0x0002, B:5:0x0008, B:8:0x0010, B:9:0x0029), top: B:15:0x0002 }] */
    private void loadSuccess(List<PictureTextExpressAd> list) {
        if (list != null) {
            try {
                if (list.isEmpty() || list.get(0) == null) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } else {
                    this.nativeAd = list.get(0);
                    setEcpm(list.get(0).getEcpm());
                    handleSucceed();
                }
            } catch (Throwable th) {
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, PPSLabelView.Code + th.getMessage());
            }
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            InterstitialExpressAd interstitialExpressAd = this.interstitialAd;
            if (interstitialExpressAd != null) {
                interstitialExpressAd.release();
                this.interstitialAd = null;
            }
            AdVideo adVideo = this.mAdVideo;
            if (adVideo != null) {
                adVideo.releasePlayer();
                this.mAdVideo = null;
            }
            PictureTextExpressAd pictureTextExpressAd = this.nativeAd;
            if (pictureTextExpressAd != null) {
                pictureTextExpressAd.release();
                this.nativeAd = null;
            }
            this.mAdView = null;
        } catch (Exception e) {
            YFLog.error(this.tag + str + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void closeAds(boolean z) {
        release("closeAds");
        super.closeAds(z);
    }
}
