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
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.NativeAdLoader;
import com.huawei.hms.ads.nativead.NativeView;
import com.unionpay.tsmservice.data.Constant;
import com.yfanads.ads.chanel.hw.utls.HwUtil;
import com.yfanads.ads.chanel.hw.view.MyAppDownloadStyle;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
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
public class HwNativeExpressAdapter extends NativeExpressCustomAdapter implements NativeAd.NativeAdLoadedListener {
    private NativeAd nativeAd;
    private NativeAdLoader nativeAdLoader;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 6;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        return this.nativeAd != null ? 1 : 0;
    }

    public HwNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        HwUtil.initHw(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.hw.HwNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                HwNativeExpressAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                HwNativeExpressAdapter.this.handleFailed(str, str2);
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
        if (isNative()) {
            NativeAdLoader.Builder builder = new NativeAdLoader.Builder(context, this.sdkSupplier.getPotId());
            builder.setNativeAdLoadedListener(this).setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.hw.HwNativeExpressAdapter.2
                @Override // com.huawei.hms.ads.AdListener
                public void onAdFailed(int i) {
                    YFLog.warn("onAdFailed " + i);
                    HwNativeExpressAdapter.this.handleFailed(YFAdError.parseErr(i));
                }

                @Override // com.huawei.hms.ads.AdListener
                public void onAdClicked() {
                    HwNativeExpressAdapter.this.handleClick();
                }

                @Override // com.huawei.hms.ads.AdListener
                public void onAdImpression() {
                    YFLog.high(HwNativeExpressAdapter.this.tag + " onAdImpression");
                    HwNativeExpressAdapter.this.handleExposure();
                }
            });
            builder.setNativeAdOptions(new NativeAdConfiguration.Builder().setVideoConfiguration(new VideoConfiguration.Builder().setStartMuted(this.sdkSupplier.isMuted()).build()).build());
            AdParam.Builder builder2 = new AdParam.Builder();
            if (isBidding()) {
                BiddingParam.Builder builder3 = new BiddingParam.Builder();
                builder3.setBidFloor(Float.valueOf(getEcpm()));
                builder3.setBidFloorCur(Constant.KEY_CURRENCYTYPE_CNY);
                builder2.addBiddingParamMap(this.sdkSupplier.getPotId(), builder3.build());
            }
            NativeAdLoader nativeAdLoaderBuild = builder.build();
            this.nativeAdLoader = nativeAdLoaderBuild;
            nativeAdLoaderBuild.loadAd(builder2.build());
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            if (isNative()) {
                doShowNativeAd(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public ViewGroup getNativeAdContainer() {
        return new NativeView(getContext());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        try {
            NativeAd nativeAd = this.nativeAd;
            if (nativeAd != null) {
                nativeAd.destroy();
                this.nativeAd = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        String callToAction;
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd == null) {
            YFLog.error("bindData error " + i);
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
            String string = this.nativeAd.getImages().get(0).getUri().toString();
            this.feedBean.imageUrl = string;
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
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
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(this.nativeAd.getDspLogo())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(this.nativeAd.getDspLogo(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.hw.HwNativeExpressAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1111x9c2f3ac3(i, view);
            }
        });
        registerViewForInteraction(adBannerViewHolder, bannerTemplateData, this.nativeAd, z, i);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.hw.HwNativeExpressAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1112x8dd8e0e2(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-hw-HwNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1111x9c2f3ac3(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-hw-HwNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1112x8dd8e0e2(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, NativeAd nativeAd, boolean z, int i) {
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
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 16;
        mediaView.setLayoutParams(layoutParams);
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
        videoOperator.setVideoLifecycleListener(new VideoOperator.VideoLifecycleListener() { // from class: com.yfanads.ads.chanel.hw.HwNativeExpressAdapter.3
            @Override // com.huawei.hms.ads.VideoOperator.VideoLifecycleListener
            public void onVideoEnd() {
                super.onVideoEnd();
            }
        });
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder) {
        adBannerViewHolder.complianceContent.setVisibility(8);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.HW.getValue();
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

    private void setEcpmByNative() {
        try {
            NativeAd nativeAd = this.nativeAd;
            if (nativeAd != null) {
                BiddingInfo biddingInfo = nativeAd.getBiddingInfo();
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

    private void setDownloadClick(AdBannerViewHolder adBannerViewHolder, BaseTemplateData baseTemplateData, NativeAd nativeAd) {
        if (HwUtil.isExistDownload(nativeAd)) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.item_app_download, (ViewGroup) null);
            AppDownloadButton appDownloadButton = (AppDownloadButton) relativeLayout.findViewById(R.id.appDownloadButton);
            if (((NativeView) adBannerViewHolder.nativeAdContainer).register(appDownloadButton)) {
                ViewParent parent = adBannerViewHolder.mDownload.getParent();
                if (parent instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(getContext(), 50.0f), -1);
                    layoutParams.addRule(11, -1);
                    relativeLayout.setLayoutParams(layoutParams);
                    ((RelativeLayout) parent).addView(relativeLayout);
                } else if (parent instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ScreenUtil.dip2px(getContext(), 50.0f), -1);
                    layoutParams2.gravity = 5;
                    relativeLayout.setLayoutParams(layoutParams2);
                    ((LinearLayout) parent).addView(relativeLayout);
                }
                appDownloadButton.setAppDownloadButtonStyle(new MyAppDownloadStyle(getContext()));
                appDownloadButton.refreshAppStatus();
            }
        }
        if (baseTemplateData.isShowDownloadDialog()) {
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_app_download, (ViewGroup) null);
        AppDownloadButton appDownloadButton2 = (AppDownloadButton) viewInflate.findViewById(R.id.appDownloadButton);
        if (((NativeView) adBannerViewHolder.nativeAdContainer).register(appDownloadButton2)) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(13, -1);
            RelativeLayout relativeLayout2 = (RelativeLayout) adBannerViewHolder.dyClickView.getParent();
            viewInflate.setLayoutParams(layoutParams3);
            relativeLayout2.addView(viewInflate);
            appDownloadButton2.setAppDownloadButtonStyle(new MyAppDownloadStyle(getContext()));
            appDownloadButton2.refreshAppStatus();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.sendBiddingSuccess(HwUtil.getWinBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwNativeExpressAdapter.4
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwNativeExpressAdapter.this.tag + " sendBiddingSucResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwNativeExpressAdapter.this.tag + " sendBiddingSucResult reportFailed " + str + " code=" + i);
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
            nativeAd.sendBiddingFailed(HwUtil.getLossBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwNativeExpressAdapter.5
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwNativeExpressAdapter.this.tag + " sendBiddingLossResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwNativeExpressAdapter.this.tag + " sendBiddingLossResult reportFailed " + str + " code=" + i);
                }
            });
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return HwUtil.getAdInfo(this.nativeAd, getRequestId());
    }
}
