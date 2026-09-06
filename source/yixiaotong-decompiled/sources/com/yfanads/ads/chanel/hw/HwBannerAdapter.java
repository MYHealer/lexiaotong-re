package com.yfanads.ads.chanel.hw;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.banner.BannerView;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.NativeAdLoader;
import com.huawei.hms.ads.nativead.NativeView;
import com.unionpay.tsmservice.data.Constant;
import com.yfanads.ads.chanel.hw.utls.HwUtil;
import com.yfanads.ads.chanel.hw.view.MyAppDownloadStyle;
import com.yfanads.android.core.banner.YFBannerSetting;
import com.yfanads.android.custom.BannerCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class HwBannerAdapter extends BannerCustomAdapter implements NativeAd.NativeAdLoadedListener {
    private ViewGroup adContainer;
    private BannerView bannerView;
    private NativeAd nativeAd;
    private NativeAdLoader nativeAdLoader;

    public HwBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        HwUtil.initHw(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.hw.HwBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                HwBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                HwBannerAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        if (isNative()) {
            showNativeADs(activity, viewGroup);
        } else {
            this.adContainer = viewGroup;
            showTemplateADs(viewGroup);
        }
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAd == null || viewGroup == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            addView(activity, viewGroup, new NativeView(getContext()));
        }
    }

    private void showTemplateADs(ViewGroup viewGroup) {
        viewGroup.addView(this.bannerView);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        try {
            BannerView bannerView = this.bannerView;
            if (bannerView != null) {
                bannerView.destroy();
                this.bannerView = null;
            }
            NativeAd nativeAd = this.nativeAd;
            if (nativeAd != null) {
                nativeAd.destroy();
                this.nativeAd = null;
            }
            ViewGroup viewGroup = this.adContainer;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            loadInterstitialAdByNative(context);
        } else {
            loadInterstitialAd(context);
        }
    }

    private void loadInterstitialAdByNative(Context context) {
        NativeAdLoader.Builder builder = new NativeAdLoader.Builder(context, this.sdkSupplier.getPotId());
        builder.setNativeAdLoadedListener(this).setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.hw.HwBannerAdapter.2
            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int i) {
                HwBannerAdapter.this.handleFailed(YFAdError.parseErr(i));
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() {
                HwBannerAdapter.this.handleClick();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdImpression() {
                YFLog.high(HwBannerAdapter.this.tag + " onAdImpression");
                HwBannerAdapter.this.handleExposure();
            }
        });
        builder.setNativeAdOptions(new NativeAdConfiguration.Builder().setVideoConfiguration(new VideoConfiguration.Builder().setStartMuted(this.sdkSupplier.isMute()).build()).build());
        this.nativeAdLoader = builder.build();
        AdParam.Builder builder2 = new AdParam.Builder();
        if (isBidding()) {
            BiddingParam.Builder builder3 = new BiddingParam.Builder();
            builder3.setBidFloor(Float.valueOf(getEcpm()));
            builder3.setBidFloorCur(Constant.KEY_CURRENCYTYPE_CNY);
            builder2.addBiddingParamMap(this.sdkSupplier.getPotId(), builder3.build());
        }
        this.nativeAdLoader.loadAd(builder2.build());
    }

    private void loadInterstitialAd(Context context) {
        BannerView bannerView = new BannerView(context);
        this.bannerView = bannerView;
        bannerView.setAdId(this.sdkSupplier.getPotId());
        this.bannerView.setBannerAdSize(new BannerAdSize(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 57));
        YFLog.high(this.tag + " load banner setBannerRefresh " + this.sdkSupplier.getRefreshInterval());
        this.bannerView.setBannerRefresh(this.sdkSupplier.getRefreshInterval() / 1000);
        this.bannerView.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.hw.HwBannerAdapter.3
            @Override // com.huawei.hms.ads.AdListener
            public void onAdLeave() {
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLoaded() {
                if (HwBannerAdapter.this.isBidding()) {
                    HwBannerAdapter.this.setEcpm();
                }
                HwBannerAdapter.this.handleSucceed();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int i) {
                HwBannerAdapter.this.handleFailed(YFAdError.parseErr(i));
                YFLog.debug("onAdFailed===>" + i);
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() {
                HwBannerAdapter.this.handleClick();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClosed() {
                HwBannerAdapter hwBannerAdapter = HwBannerAdapter.this;
                hwBannerAdapter.closeAds(hwBannerAdapter.adContainer);
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdOpened() {
                YFLog.high(HwBannerAdapter.this.tag + " onAdOpened");
                if (HwBannerAdapter.this.isStartShow()) {
                    HwBannerAdapter.this.handleExposure();
                }
            }
        });
        AdParam.Builder builder = new AdParam.Builder();
        if (isBidding()) {
            BiddingParam.Builder builder2 = new BiddingParam.Builder();
            builder2.setBidFloor(Float.valueOf(getEcpm()));
            builder2.setBidFloorCur(Constant.KEY_CURRENCYTYPE_CNY);
            builder.addBiddingParamMap(this.sdkSupplier.getPotId(), builder2.build());
        }
        this.bannerView.loadAd(builder.build());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.HW.getValue();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, ViewGroup viewGroup, final AdBannerViewHolder adBannerViewHolder) {
        String callToAction;
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd == null) {
            return;
        }
        boolean z = nativeAd.getCreativeType() == 6 || this.nativeAd.getCreativeType() == 9 || this.nativeAd.getCreativeType() == 12 || this.nativeAd.getCreativeType() == 106;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(this.nativeAd.getTitle(), this.nativeAd.getDescription(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (this.nativeAd.getImages() != null && this.nativeAd.getImages().get(0).getUri() != null) {
                ViewUtils.loadBlurImage(this.nativeAd.getImages().get(0).getUri().toString(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else if (this.nativeAd.getImages() != null && this.nativeAd.getImages().get(0).getUri() != null) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            String string = this.nativeAd.getImages().get(0).getUri().toString();
            this.feedBean.imageUrl = string;
            ViewUtils.loadBlurImage(string, adBannerViewHolder.imageBlur, 20);
            ViewUtils.loadImage(string, adBannerViewHolder.showImg);
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_hw_v3);
        String description = TextUtils.isEmpty(this.nativeAd.getTitle()) ? this.nativeAd.getDescription() : this.nativeAd.getTitle();
        String title = TextUtils.isEmpty(this.nativeAd.getDescription()) ? this.nativeAd.getTitle() : this.nativeAd.getDescription();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (description == null) {
                description = "";
            }
            textView.setText(description);
        }
        TextView textView2 = adBannerViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView2.setText(title);
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
            } else {
                adBannerViewHolder.mDownload.setVisibility(0);
                TextView textView3 = adBannerViewHolder.mDownload;
                if (TextUtils.isEmpty(this.nativeAd.getCallToAction())) {
                    callToAction = getContext().getString(R.string.yf_default_download_text);
                } else {
                    callToAction = this.nativeAd.getCallToAction();
                }
                textView3.setText(callToAction);
                if (this.feedBean != null) {
                    this.feedBean.actBtnString = this.nativeAd.getCallToAction();
                }
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.hw.HwBannerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1105lambda$bindData$0$comyfanadsadschanelhwHwBannerAdapter(adBannerViewHolder, view);
            }
        });
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(this.nativeAd.getDspLogo())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(this.nativeAd.getDspLogo(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        registerViewForInteraction(adBannerViewHolder, z, bannerTemplateData, this.nativeAd);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.hw.HwBannerAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1106lambda$bindData$1$comyfanadsadschanelhwHwBannerAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-hw-HwBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1105lambda$bindData$0$comyfanadsadschanelhwHwBannerAdapter(AdBannerViewHolder adBannerViewHolder, View view) {
        closeAds(adBannerViewHolder.nativeAdContainer);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-hw-HwBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1106lambda$bindData$1$comyfanadsadschanelhwHwBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder) {
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData, NativeAd nativeAd) {
        if (z) {
            bindMediaView(adBannerViewHolder, bannerTemplateData, nativeAd);
        } else {
            bindImageViews(adBannerViewHolder, bannerTemplateData, nativeAd);
        }
    }

    private void bindImageViews(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, NativeAd nativeAd) {
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            adBannerViewHolder.mediaViewFrame.removeAllViews();
            adBannerViewHolder.mediaViewFrame.addView(mediaView);
            NativeView nativeView = (NativeView) adBannerViewHolder.nativeAdContainer;
            nativeView.setMediaView(mediaView);
            nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
            nativeView.setNativeAd(nativeAd);
            setDownloadClick(adBannerViewHolder, bannerTemplateData, nativeAd);
        }
    }

    private void bindMediaView(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, NativeAd nativeAd) {
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            adBannerViewHolder.mediaViewFrame.removeAllViews();
            adBannerViewHolder.mediaViewFrame.addView(mediaView);
            NativeView nativeView = (NativeView) adBannerViewHolder.nativeAdContainer;
            nativeView.setMediaView(mediaView);
            nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
            nativeView.setNativeAd(nativeAd);
            setDownloadClick(adBannerViewHolder, bannerTemplateData, nativeAd);
        }
        VideoOperator videoOperator = nativeAd.getVideoOperator();
        videoOperator.hasVideo();
        videoOperator.setVideoLifecycleListener(new VideoOperator.VideoLifecycleListener() { // from class: com.yfanads.ads.chanel.hw.HwBannerAdapter.4
            @Override // com.huawei.hms.ads.VideoOperator.VideoLifecycleListener
            public void onVideoEnd() {
                super.onVideoEnd();
            }
        });
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener
    public void onNativeAdLoaded(NativeAd nativeAd) {
        if (nativeAd != null) {
            this.nativeAd = nativeAd;
            if (isBidding()) {
                setEcpmByNative();
            }
            handleSucceed();
        }
    }

    private void setDownloadClick(AdBannerViewHolder adBannerViewHolder, BaseTemplateData baseTemplateData, NativeAd nativeAd) {
        if (HwUtil.isExistDownload(nativeAd)) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_app_download, (ViewGroup) null);
            AppDownloadButton appDownloadButton = (AppDownloadButton) viewInflate.findViewById(R.id.appDownloadButton);
            if (((NativeView) adBannerViewHolder.nativeAdContainer).register(appDownloadButton)) {
                ViewParent parent = adBannerViewHolder.mDownload.getParent();
                if (parent instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(getContext(), 50.0f), -1);
                    layoutParams.addRule(11, -1);
                    viewInflate.setLayoutParams(layoutParams);
                    ((RelativeLayout) parent).addView(viewInflate);
                } else if (parent instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ScreenUtil.dip2px(getContext(), 50.0f), -1);
                    layoutParams2.gravity = 5;
                    viewInflate.setLayoutParams(layoutParams2);
                    ((LinearLayout) parent).addView(viewInflate);
                }
                appDownloadButton.setAppDownloadButtonStyle(new MyAppDownloadStyle(getContext()));
                appDownloadButton.refreshAppStatus();
            }
        }
        if (baseTemplateData.isShowDownloadDialog()) {
            return;
        }
        View viewInflate2 = LayoutInflater.from(getContext()).inflate(R.layout.item_app_download, (ViewGroup) null);
        AppDownloadButton appDownloadButton2 = (AppDownloadButton) viewInflate2.findViewById(R.id.appDownloadButton);
        if (((NativeView) adBannerViewHolder.nativeAdContainer).register(appDownloadButton2)) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(13, -1);
            RelativeLayout relativeLayout = (RelativeLayout) adBannerViewHolder.dyClickView.getParent();
            viewInflate2.setLayoutParams(layoutParams3);
            relativeLayout.addView(viewInflate2);
            appDownloadButton2.setAppDownloadButtonStyle(new MyAppDownloadStyle(getContext()));
            appDownloadButton2.refreshAppStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEcpm() {
        try {
            BannerView bannerView = this.bannerView;
            if (bannerView != null) {
                BiddingInfo biddingInfo = bannerView.getBiddingInfo();
                if (biddingInfo != null && biddingInfo.getPrice() != null) {
                    setEcpmByStr(HwUtil.price2penny(biddingInfo.getPrice()));
                } else {
                    setEcpmByStr("0");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setEcpmByNative() {
        BiddingInfo biddingInfo;
        try {
            NativeAd nativeAd = this.nativeAd;
            if (nativeAd == null || (biddingInfo = nativeAd.getBiddingInfo()) == null || biddingInfo.getPrice() == null) {
                return;
            }
            setEcpmByStr(String.valueOf(biddingInfo.getPrice()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.sendBiddingSuccess(HwUtil.getWinBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwBannerAdapter.5
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwBannerAdapter.this.tag + " sendBiddingSucResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwBannerAdapter.this.tag + " sendBiddingSucResult reportFailed " + str + " code=" + i);
                }
            });
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
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.sendBiddingFailed(HwUtil.getLossBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwBannerAdapter.6
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwBannerAdapter.this.tag + " sendBiddingLossResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwBannerAdapter.this.tag + " sendBiddingLossResult reportFailed " + str + " code=" + i);
                }
            });
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return HwUtil.getAdInfo(this.nativeAd, getRequestId());
    }
}
