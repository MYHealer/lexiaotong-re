package com.yfanads.ads.chanel.hw;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.AppDownloadButton;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.InterstitialAd;
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
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class HwInterstitialAdapter extends InterstitialCustomAdapter implements NativeAd.NativeAdLoadedListener {
    private final AdListener adListener;
    private InterstitialAd interstitialAd;
    private NativeAd nativeAd;
    private NativeAdLoader nativeAdLoader;

    public HwInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
        this.adListener = new AdListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter.4
            @Override // com.huawei.hms.ads.AdListener
            public void onAdLeave() {
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLoaded() {
                if (HwInterstitialAdapter.this.isBidding()) {
                    HwInterstitialAdapter.this.setEcpm();
                }
                HwInterstitialAdapter.this.handleSucceed();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int i) {
                HwInterstitialAdapter.this.handleFailed(YFAdError.parseErr(i));
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClosed() {
                HwInterstitialAdapter.this.closeAds();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() {
                HwInterstitialAdapter.this.handleClick();
                HwInterstitialAdapter.this.closeAdsDelay();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdOpened() {
                YFLog.high(HwInterstitialAdapter.this.tag + " onAdOpened");
                if (HwInterstitialAdapter.this.isStartShow()) {
                    HwInterstitialAdapter.this.handleExposure();
                }
            }
        };
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        HwUtil.initHw(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                HwInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                HwInterstitialAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
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

    private void showNativeADs(Activity activity) {
        if (this.nativeAd == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            addView(activity, new NativeView(getContext()));
        }
    }

    private void showTemplateADs(Activity activity) {
        try {
            InterstitialAd interstitialAd = this.interstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.interstitialAd.show(activity);
            } else {
                YFLog.debug("Ad did not load");
            }
        } catch (Exception e) {
            e.printStackTrace();
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            if (this.interstitialAd != null) {
                this.interstitialAd = null;
            }
            if (this.nativeAdLoader != null) {
                this.nativeAdLoader = null;
            }
            NativeAd nativeAd = this.nativeAd;
            if (nativeAd != null) {
                nativeAd.destroy();
                this.nativeAd = null;
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
        builder.setNativeAdLoadedListener(this).setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter.2
            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int i) {
                HwInterstitialAdapter.this.handleFailed(YFAdError.parseErr(i));
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() {
                HwInterstitialAdapter.this.handleClick();
                HwInterstitialAdapter.this.closeAdsDelay();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdImpression() {
                YFLog.high(HwInterstitialAdapter.this.tag + " onAdImpression");
                HwInterstitialAdapter.this.handleExposure();
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
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.interstitialAd = interstitialAd;
        interstitialAd.setAdId(this.sdkSupplier.getPotId());
        this.interstitialAd.setAdListener(this.adListener);
        AdParam.Builder builder = new AdParam.Builder();
        if (isBidding()) {
            BiddingParam.Builder builder2 = new BiddingParam.Builder();
            builder2.setBidFloor(Float.valueOf(getEcpm()));
            builder2.setBidFloorCur(Constant.KEY_CURRENCYTYPE_CNY);
            builder.addBiddingParamMap(this.sdkSupplier.getPotId(), builder2.build());
        }
        this.interstitialAd.loadAd(builder.build());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.HW.getValue();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        boolean z = true;
        boolean z2 = false;
        boolean z3 = nativeAd.getCreativeType() == 6 || this.nativeAd.getCreativeType() == 9 || this.nativeAd.getCreativeType() == 12 || this.nativeAd.getCreativeType() == 106;
        boolean z4 = adBaseViewHolder instanceof AdInterV2ViewHolder;
        YFLog.high(this.tag + " bindData isVideo " + z3);
        this.feedBean = new FeedBean(this.nativeAd.getTitle(), this.nativeAd.getDescription(), z3, interTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z3) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (this.nativeAd.getImages().get(0).getUri() != null) {
                ViewUtils.loadBlurImage(this.nativeAd.getImages().get(0).getUri().toString(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (this.nativeAd.getImages() != null) {
                Image image = this.nativeAd.getImages().get(0);
                if (image.getUri() != null) {
                    String string = image.getUri().toString();
                    this.feedBean.imageUrl = string;
                    ViewUtils.loadBlurImage(string, adBaseViewHolder.imageBlur, z4 ? 20 : 0);
                    if (z4 && ViewUtils.isHorizontal(image.getWidth(), image.getHeight())) {
                        setHBackground(adBaseViewHolder.showImageArea);
                    } else {
                        z = false;
                    }
                    ViewUtils.loadImage(string, adBaseViewHolder.showImg);
                    z2 = z;
                }
            }
        }
        interTemplateData.updAdLog(R.mipmap.ad_log_hw_v3);
        String description = TextUtils.isEmpty(this.nativeAd.getTitle()) ? this.nativeAd.getDescription() : this.nativeAd.getTitle();
        String title = TextUtils.isEmpty(this.nativeAd.getDescription()) ? this.nativeAd.getTitle() : this.nativeAd.getDescription();
        if (z4) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (z2) {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_SMALL);
            } else {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_BIG);
            }
            if (this.nativeAd.getIcon() != null) {
                ViewUtils.loadCircleImage(this.nativeAd.getIcon().getUri().toString(), adInterV2ViewHolder.adIcon, 20);
            }
            TextView textView = adInterV2ViewHolder.adIconName;
            if (description == null) {
                description = "";
            }
            textView.setText(description);
        } else {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (this.nativeAd.getIcon() != null) {
                ViewUtils.loadCircleImage(this.nativeAd.getIcon().getUri().toString(), adInterV3ViewHolder.adIcon, 20);
            }
            TextView textView2 = adInterV3ViewHolder.adIconName;
            if (description == null) {
                description = "";
            }
            textView2.setText(description);
        }
        TextView textView3 = adBaseViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView3.setText(title);
        adBaseViewHolder.updateShowView(getContext(), interTemplateData);
        adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1107x32502fd6(view);
            }
        });
        registerViewForInteraction(adBaseViewHolder, interTemplateData, z3, this.nativeAd);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1108x31d9c9d7(fragmentManager, view);
                }
            });
        }
        complianceContent(adBaseViewHolder);
        startCountDown(adBaseViewHolder, interTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-hw-HwInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1107x32502fd6(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-hw-HwInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1108x31d9c9d7(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder) {
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    private void registerViewForInteraction(AdBaseViewHolder adBaseViewHolder, BaseTemplateData baseTemplateData, boolean z, NativeAd nativeAd) {
        new FrameLayout.LayoutParams(1, 1).gravity = 53;
        if (z) {
            bindMediaView(adBaseViewHolder, baseTemplateData, nativeAd);
        } else {
            bindImageViews(adBaseViewHolder, baseTemplateData, nativeAd);
        }
    }

    private void bindImageViews(AdBaseViewHolder adBaseViewHolder, BaseTemplateData baseTemplateData, NativeAd nativeAd) {
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            adBaseViewHolder.mediaViewFrame.removeAllViews();
            adBaseViewHolder.mediaViewFrame.addView(mediaView);
            if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
                AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
                NativeView nativeView = (NativeView) adInterV2ViewHolder.nativeAdContainer;
                nativeView.setMediaView(mediaView);
                nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
                nativeView.setNativeAd(nativeAd);
                setDownloadClick(adInterV2ViewHolder.animationClickView, nativeView, adInterV2ViewHolder.dyClickView, baseTemplateData, nativeAd);
                return;
            }
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            NativeView nativeView2 = (NativeView) adInterV3ViewHolder.nativeAdContainer;
            nativeView2.setMediaView(mediaView);
            nativeView2.getMediaView().setMediaContent(nativeAd.getMediaContent());
            nativeView2.setNativeAd(nativeAd);
            setDownloadClick(adInterV3ViewHolder.animationClickView, nativeView2, adInterV3ViewHolder.animationClickView, baseTemplateData, nativeAd);
        }
    }

    private void bindMediaView(AdBaseViewHolder adBaseViewHolder, BaseTemplateData baseTemplateData, NativeAd nativeAd) {
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            adBaseViewHolder.mediaViewFrame.removeAllViews();
            adBaseViewHolder.mediaViewFrame.addView(mediaView);
            if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
                AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
                NativeView nativeView = (NativeView) adInterV2ViewHolder.nativeAdContainer;
                nativeView.setMediaView(mediaView);
                nativeView.getMediaView().setMediaContent(nativeAd.getMediaContent());
                nativeView.setNativeAd(nativeAd);
                setDownloadClick(adInterV2ViewHolder.animationClickView, nativeView, adInterV2ViewHolder.dyClickView, baseTemplateData, nativeAd);
            } else {
                AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
                NativeView nativeView2 = (NativeView) adInterV3ViewHolder.nativeAdContainer;
                nativeView2.setMediaView(mediaView);
                nativeView2.getMediaView().setMediaContent(nativeAd.getMediaContent());
                nativeView2.setNativeAd(nativeAd);
                setDownloadClick(adInterV3ViewHolder.animationClickView, nativeView2, adInterV3ViewHolder.animationClickView, baseTemplateData, nativeAd);
            }
        }
        VideoOperator videoOperator = nativeAd.getVideoOperator();
        videoOperator.hasVideo();
        videoOperator.setVideoLifecycleListener(new VideoOperator.VideoLifecycleListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter.3
            @Override // com.huawei.hms.ads.VideoOperator.VideoLifecycleListener
            public void onVideoEnd() {
                super.onVideoEnd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEcpm() {
        try {
            InterstitialAd interstitialAd = this.interstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                BiddingInfo biddingInfo = this.interstitialAd.getBiddingInfo();
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

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        InterstitialAd interstitialAd = this.interstitialAd;
        String shortString = "";
        if (interstitialAd != null) {
            interstitialAd.sendBiddingSuccess(HwUtil.getWinBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter.5
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwInterstitialAdapter.this.tag + " sendBiddingSucResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwInterstitialAdapter.this.tag + " sendBiddingSucResult reportFailed " + str + " code=" + i);
                }
            });
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.sendBiddingSuccess(HwUtil.getWinBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter.6
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwInterstitialAdapter.this.tag + " sendBiddingSucResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwInterstitialAdapter.this.tag + " sendBiddingSucResult reportFailed " + str + " code=" + i);
                }
            });
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.sendBiddingFailed(HwUtil.getLossBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter.7
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwInterstitialAdapter.this.tag + " sendBiddingLossResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwInterstitialAdapter.this.tag + " sendBiddingLossResult reportFailed " + str + " code=" + i);
                }
            });
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.sendBiddingFailed(HwUtil.getLossBiddingInfo(sdkSupplier), new ReportUrlListener() { // from class: com.yfanads.ads.chanel.hw.HwInterstitialAdapter.8
                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportSuccess() {
                    YFLog.high(HwInterstitialAdapter.this.tag + " sendBiddingLossResult reportSuccess");
                }

                @Override // com.huawei.hms.ads.ReportUrlListener
                public void reportFailed(String str, int i) {
                    YFLog.high(HwInterstitialAdapter.this.tag + " sendBiddingLossResult reportFailed " + str + " code=" + i);
                }
            });
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return HwUtil.getAdInfo(this.nativeAd, getRequestId());
    }

    private boolean isExistClick(BaseTemplateData baseTemplateData) {
        return baseTemplateData.isActionType(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue(), BaseTemplateData.InteractiveStyle.CLICK.getValue(), BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue());
    }

    private void setDownloadClick(View view, NativeView nativeView, View view2, BaseTemplateData baseTemplateData, NativeAd nativeAd) {
        if (isExistClick(baseTemplateData) && HwUtil.isExistDownload(nativeAd)) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_app_download, (ViewGroup) null);
            AppDownloadButton appDownloadButton = (AppDownloadButton) viewInflate.findViewById(R.id.appDownloadButton);
            if (nativeView.register(appDownloadButton)) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13, -1);
                RelativeLayout relativeLayout = (RelativeLayout) view.getParent();
                viewInflate.setLayoutParams(layoutParams);
                relativeLayout.addView(viewInflate);
                appDownloadButton.setAppDownloadButtonStyle(new MyAppDownloadStyle(getContext()));
                appDownloadButton.refreshAppStatus();
            }
        }
        if (baseTemplateData.isShowDownloadDialog()) {
            return;
        }
        View viewInflate2 = LayoutInflater.from(getContext()).inflate(R.layout.item_app_download, (ViewGroup) null);
        AppDownloadButton appDownloadButton2 = (AppDownloadButton) viewInflate2.findViewById(R.id.appDownloadButton);
        if (nativeView.register(appDownloadButton2)) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(13, -1);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.getParent();
            viewInflate2.setLayoutParams(layoutParams2);
            relativeLayout2.addView(viewInflate2);
            appDownloadButton2.setAppDownloadButtonStyle(new MyAppDownloadStyle(getContext()));
            appDownloadButton2.refreshAppStatus();
        }
    }
}
