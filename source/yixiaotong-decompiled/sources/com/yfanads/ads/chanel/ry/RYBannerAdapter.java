package com.yfanads.ads.chanel.ry;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.hihonor.adsdk.banner.api.BannerAdLoad;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.AdVideo;
import com.hihonor.adsdk.base.api.banner.BannerAdLoadListener;
import com.hihonor.adsdk.base.api.banner.BannerExpressAd;
import com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;
import com.hihonor.adsdk.picturetextad.PictureTextAdLoad;
import com.hihonor.adsdk.picturetextad.PictureTextAdRootView;
import com.yfanads.ads.chanel.ry.utils.RYUtil;
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
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class RYBannerAdapter extends BannerCustomAdapter implements BannerAdLoadListener, PictureTextAdLoadListener {
    private AdVideo mAdVideo;
    private BannerExpressAd mBannerExpressAd;
    private PictureTextExpressAd mNativeAd;

    public RYBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.RY.getValue();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        RYUtil.initRY(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ry.RYBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                RYBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                RYBannerAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
        YFLog.debug(this.tag + "startLoadAD adType = " + this.sdkSupplier.adType);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            loadBannerAdByNative();
        } else {
            loadBannerAd();
        }
    }

    private void loadBannerAd() {
        new BannerAdLoad.Builder().setBannerAdLoadListener(this).setAdSlot(new AdSlot.Builder().setSlotId(this.sdkSupplier.getPotId()).setWidth(ScreenUtil.dip2px(getContext(), this.setting.getViewWidth())).setHeight(this.setting.getViewHeight() != 0 ? ScreenUtil.dip2px(getContext(), this.setting.getViewHeight()) : 720).build()).build().loadAd();
    }

    private void showTemplateADs(final ViewGroup viewGroup) {
        BannerExpressAd bannerExpressAd;
        if (viewGroup == null || (bannerExpressAd = this.mBannerExpressAd) == null) {
            return;
        }
        bannerExpressAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.RYBannerAdapter.2
            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdImpression() {
                YFLog.debug(RYBannerAdapter.this.tag + "onAdImpression: ");
                RYBannerAdapter.this.handleExposure();
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClicked() {
                YFLog.debug(RYBannerAdapter.this.tag + "onAdClicked: ");
                RYBannerAdapter.this.handleClick();
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClosed() {
                RYBannerAdapter.this.closeAds(viewGroup);
                YFLog.high(RYBannerAdapter.this.tag + " onAdClosed");
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onMiniAppStarted() {
                YFLog.debug(RYBannerAdapter.this.tag + "onMiniAppStarted: ");
                super.onMiniAppStarted();
            }
        });
        viewGroup.removeAllViews();
        YFLog.high(this.tag + " load banner setBannerRefresh " + this.sdkSupplier.getRefreshInterval());
        this.mBannerExpressAd.setIntervalTime(this.sdkSupplier.getRefreshInterval() / 1000);
        viewGroup.addView(this.mBannerExpressAd.getExpressAdView());
    }

    private void loadBannerAdByNative() {
        new PictureTextAdLoad.Builder().setPictureTextAdLoadListener(this).setAdSlot(new AdSlot.Builder().setSlotId(this.sdkSupplier.getPotId()).setRenderType(1).build()).build().loadAd();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        if (isNative()) {
            showNativeADs(activity, viewGroup);
        } else {
            showTemplateADs(viewGroup);
        }
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.mNativeAd == null) {
            YFLog.error(this.tag + " mNativeAd is null, return. ");
            handleShowFailed();
        } else {
            YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId());
            addView(activity, viewGroup, new PictureTextAdRootView(getContext()));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        BannerExpressAd bannerExpressAd = this.mBannerExpressAd;
        if (bannerExpressAd != null) {
            bannerExpressAd.sendWinNotification(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0L);
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
        BannerExpressAd bannerExpressAd = this.mBannerExpressAd;
        if (bannerExpressAd == null || sdkSupplier == null) {
            return;
        }
        bannerExpressAd.sendLossNotification(sdkSupplier.ecpm, ErrorCode.AD_BID_FAILED, sdkSupplier.getAdnId());
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        BannerExpressAd bannerExpressAd = this.mBannerExpressAd;
        if (bannerExpressAd != null) {
            bannerExpressAd.release();
        }
        AdVideo adVideo = this.mAdVideo;
        if (adVideo != null) {
            adVideo.releasePlayer();
            this.mAdVideo = null;
        }
        PictureTextExpressAd pictureTextExpressAd = this.mNativeAd;
        if (pictureTextExpressAd != null) {
            pictureTextExpressAd.release();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return RYUtil.getAdInfo(this.mNativeAd, getRequestId());
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, ViewGroup viewGroup, final AdBannerViewHolder adBannerViewHolder) {
        String buttonText;
        PictureTextExpressAd pictureTextExpressAd = this.mNativeAd;
        if (pictureTextExpressAd == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        boolean zHasVideo = pictureTextExpressAd.hasVideo();
        YFLog.high(this.tag + " bindData isVideo " + zHasVideo);
        this.feedBean = new FeedBean(this.mNativeAd.getTitle(), this.mNativeAd.getBrand(), zHasVideo, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (zHasVideo) {
            this.mAdVideo = this.mNativeAd.getAdVideo();
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (!TextUtils.isEmpty(this.mNativeAd.getCoverUrl())) {
                ViewUtils.loadBlurImage(this.mNativeAd.getCoverUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (this.mNativeAd.getImages() != null && !this.mNativeAd.getImages().isEmpty()) {
                this.feedBean.imageUrl = this.mNativeAd.getImages().get(0);
                ViewUtils.loadBlurImage(this.mNativeAd.getImages().get(0), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(this.mNativeAd.getImages().get(0), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_ry_v3);
        String brand = TextUtils.isEmpty(this.mNativeAd.getTitle()) ? this.mNativeAd.getBrand() : this.mNativeAd.getTitle();
        String brand2 = TextUtils.isEmpty(this.mNativeAd.getTitle()) ? this.mNativeAd.getBrand() : this.mNativeAd.getTitle();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (brand == null) {
                brand = "";
            }
            textView.setText(brand);
        }
        TextView textView2 = adBannerViewHolder.adDes;
        if (brand2 == null) {
            brand2 = "";
        }
        textView2.setText(brand2);
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
            } else {
                adBannerViewHolder.mDownload.setVisibility(0);
                TextView textView3 = adBannerViewHolder.mDownload;
                if (TextUtils.isEmpty(this.mNativeAd.getButtonText())) {
                    buttonText = getContext().getString(R.string.yf_default_download_text);
                } else {
                    buttonText = this.mNativeAd.getButtonText();
                }
                textView3.setText(buttonText);
                if (this.feedBean != null) {
                    this.feedBean.actBtnString = this.mNativeAd.getButtonText();
                }
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(this.mNativeAd.getLogo())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(this.mNativeAd.getLogo(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ry.RYBannerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1148lambda$bindData$0$comyfanadsadschanelryRYBannerAdapter(adBannerViewHolder, view);
            }
        });
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ry.RYBannerAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1149lambda$bindData$1$comyfanadsadschanelryRYBannerAdapter(fragmentManager, view);
                }
            });
        }
        registerViewForInteraction(adBannerViewHolder, zHasVideo, this.mNativeAd, bannerTemplateData);
        complianceContent(adBannerViewHolder, bannerTemplateData, this.mNativeAd);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ry-RYBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1148lambda$bindData$0$comyfanadsadschanelryRYBannerAdapter(AdBannerViewHolder adBannerViewHolder, View view) {
        closeAds(adBannerViewHolder.nativeAdContainer);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ry-RYBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1149lambda$bindData$1$comyfanadsadschanelryRYBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, PictureTextExpressAd pictureTextExpressAd) {
        if (isDownloadAd(pictureTextExpressAd)) {
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(pictureTextExpressAd.getBrand(), pictureTextExpressAd.getAppVersion(), pictureTextExpressAd.getDeveloperName(), pictureTextExpressAd.getIntroUrl(), pictureTextExpressAd.getPermissionsUrl(), pictureTextExpressAd.getPrivacyAgreementUrl()));
            if (this.feedBean != null) {
                this.feedBean.updateAppInfo(pictureTextExpressAd.getBrand(), pictureTextExpressAd.getAppVersion(), pictureTextExpressAd.getDeveloperName());
                return;
            }
            return;
        }
        adBannerViewHolder.complianceContent.setVisibility(8);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public boolean isDownloadType() {
        PictureTextExpressAd pictureTextExpressAd = this.mNativeAd;
        if (pictureTextExpressAd != null) {
            return isDownloadAd(pictureTextExpressAd);
        }
        return super.isDownloadType();
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, PictureTextExpressAd pictureTextExpressAd, BannerTemplateData bannerTemplateData) {
        ArrayList arrayList = new ArrayList();
        if (bannerTemplateData.isTemplateV3()) {
            if (bannerTemplateData.isWholeClick()) {
                arrayList.add(adBannerViewHolder.viewGroup);
            }
            arrayList.add(adBannerViewHolder.adCloseDelay);
        } else {
            arrayList.add(adBannerViewHolder.dyClickView);
        }
        if (bannerTemplateData.isTitleDesClick()) {
            arrayList.add(adBannerViewHolder.adDes);
            arrayList.add(adBannerViewHolder.titleDes);
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                arrayList.add(adBannerViewHolder.mDownloadBar);
            } else {
                arrayList.add(adBannerViewHolder.mDownload);
            }
        }
        if (z) {
            bindMediaView(adBannerViewHolder, pictureTextExpressAd, arrayList, this.sdkSupplier.isMuted());
        } else {
            bindImageViews(adBannerViewHolder, pictureTextExpressAd, arrayList);
        }
    }

    private void bindMediaView(AdBannerViewHolder adBannerViewHolder, PictureTextExpressAd pictureTextExpressAd, List<View> list, boolean z) {
        PictureTextAdRootView pictureTextAdRootView = (PictureTextAdRootView) adBannerViewHolder.nativeAdContainer;
        if (this.mAdVideo != null) {
            addVideoView(adBannerViewHolder, pictureTextExpressAd, z);
            list.add(adBannerViewHolder.mediaViewFrame);
        }
        setNativeAdListener(pictureTextExpressAd);
        pictureTextAdRootView.setAd(pictureTextExpressAd);
        pictureTextAdRootView.registerViewForInteraction(list);
    }

    private void addVideoView(final AdBannerViewHolder adBannerViewHolder, final PictureTextExpressAd pictureTextExpressAd, final boolean z) {
        final int videoWidth = pictureTextExpressAd.getVideoWidth();
        final int videoHeight = pictureTextExpressAd.getVideoHeight();
        ViewGroup.LayoutParams layoutParams = adBannerViewHolder.mediaViewFrame.getLayoutParams();
        if (!ViewUtils.isHorizontal(videoWidth, videoHeight)) {
            layoutParams.height = -1;
            layoutParams.width = -2;
        } else {
            layoutParams.height = -2;
            layoutParams.width = -1;
        }
        adBannerViewHolder.mediaViewFrame.setLayoutParams(layoutParams);
        adBannerViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.ry.RYBannerAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1147lambda$addVideoView$2$comyfanadsadschanelryRYBannerAdapter(videoWidth, videoHeight, adBannerViewHolder, pictureTextExpressAd, z);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$addVideoView$2$com-yfanads-ads-chanel-ry-RYBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1147lambda$addVideoView$2$comyfanadsadschanelryRYBannerAdapter(int i, int i2, AdBannerViewHolder adBannerViewHolder, PictureTextExpressAd pictureTextExpressAd, boolean z) {
        int height;
        int i3;
        try {
            if (!ViewUtils.isHorizontal(i, i2)) {
                height = adBannerViewHolder.mediaViewFrame.getHeight();
                i3 = (i * height) / i2;
            } else {
                int width = adBannerViewHolder.mediaViewFrame.getWidth();
                height = (i2 * width) / i;
                i3 = width;
            }
            View videoView = pictureTextExpressAd.getAdVideo().getVideoView(new AdVideoSize(i3, height));
            ViewParent parent = videoView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(videoView);
            }
            if (videoView.getParent() == null) {
                adBannerViewHolder.mediaViewFrame.removeAllViews();
                adBannerViewHolder.mediaViewFrame.addView(videoView);
            }
            ((FrameLayout.LayoutParams) videoView.getLayoutParams()).gravity = 17;
            setVideoAdListener(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setVideoAdListener(final boolean z) {
        this.mAdVideo.setVideoListener(new OnVideoPlayListener() { // from class: com.yfanads.ads.chanel.ry.RYBannerAdapter.3
            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onProgressUpdate(long j, long j2, long j3) {
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPrepare() {
                RYBannerAdapter.this.mAdVideo.setMuted(z);
                YFLog.debug(RYBannerAdapter.this.tag + "onVideoPrepare isMuted: " + z);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoStart() {
                YFLog.debug(RYBannerAdapter.this.tag + "onVideoStart: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPause() {
                YFLog.debug(RYBannerAdapter.this.tag + "onVideoPause: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoBuffering(boolean z2) {
                YFLog.debug(RYBannerAdapter.this.tag + "onVideoBuffering: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoResume() {
                YFLog.debug(RYBannerAdapter.this.tag + "onVideoResume: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoEnd() {
                YFLog.debug(RYBannerAdapter.this.tag + "onVideoEnd: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoError(int i, String str) {
                RYBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoMute(boolean z2) {
                YFLog.debug(RYBannerAdapter.this.tag + "onVideoMute: " + z2);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoSizeChange(AdVideoSize adVideoSize) {
                YFLog.debug(RYBannerAdapter.this.tag + "onVideoSizeChange: " + adVideoSize.getWidth() + "," + adVideoSize.getHeight());
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPrepared() {
                YFLog.debug(RYBannerAdapter.this.tag + "onVideoPrepared: ");
            }
        });
    }

    private void setNativeAdListener(PictureTextExpressAd pictureTextExpressAd) {
        pictureTextExpressAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.RYBannerAdapter.4
            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClosed() {
                YFLog.debug(RYBannerAdapter.this.tag + "onAdClosed: ");
                RYBannerAdapter.this.handleClose();
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdSkip(int i) {
                YFLog.debug(RYBannerAdapter.this.tag + "onAdSkip: ");
                RYBannerAdapter.this.handleClose();
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClicked() {
                YFLog.debug(RYBannerAdapter.this.tag + "onAdSkip: ");
                RYBannerAdapter.this.handleClick();
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdImpression() {
                YFLog.debug(RYBannerAdapter.this.tag + "onAdImpression: ");
                RYBannerAdapter.this.handleExposure();
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdImpressionFailed(int i, String str) {
                YFLog.debug(RYBannerAdapter.this.tag + "onAdImpressionFailed: " + i + "," + str);
                RYBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onMiniAppStarted() {
                YFLog.debug(RYBannerAdapter.this.tag + "onMiniAppStarted: ");
            }
        });
    }

    private void bindImageViews(AdBannerViewHolder adBannerViewHolder, PictureTextExpressAd pictureTextExpressAd, List<View> list) {
        setNativeAdListener(pictureTextExpressAd);
        PictureTextAdRootView pictureTextAdRootView = (PictureTextAdRootView) adBannerViewHolder.nativeAdContainer;
        pictureTextAdRootView.setAd(pictureTextExpressAd);
        pictureTextAdRootView.registerViewForInteraction(list);
    }

    @Override // com.hihonor.adsdk.base.api.banner.BannerAdLoadListener
    public void onLoadSuccess(BannerExpressAd bannerExpressAd) {
        this.mBannerExpressAd = bannerExpressAd;
        handleSucceed();
    }

    @Override // com.hihonor.adsdk.base.callback.BaseListener
    public void onFailed(String str, String str2) {
        YFLog.debug(this.tag + "onFailed: " + str + "," + str2);
        handleFailed(str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0036 A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x001c, B:6:0x0022, B:9:0x002a, B:10:0x0036), top: B:16:0x001c }] */
    @Override // com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener
    public void onAdLoaded(List<PictureTextExpressAd> list) {
        YFLog.high(this.tag + "onNativeAdLoad");
        if (list != null) {
            try {
                if (list.isEmpty() || list.get(0) == null) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } else {
                    this.mNativeAd = list.get(0);
                    handleSucceed();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
            }
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
        }
    }

    private boolean isDownloadAd(PictureTextExpressAd pictureTextExpressAd) {
        return pictureTextExpressAd.getPromotionPurpose() == 0;
    }
}
