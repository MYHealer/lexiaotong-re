package com.yfanads.ads.chanel.ylh;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
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
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhBannerAdapter extends BannerCustomAdapter implements UnifiedBannerADListener {
    private UnifiedBannerView bv;
    private NativeUnifiedADData nativeAds;

    public YlhBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.YLH.getValue();
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onNoAD(AdError adError) {
        int errorCode;
        String errorMsg;
        if (adError != null) {
            try {
                errorCode = adError.getErrorCode();
                errorMsg = adError.getErrorMsg();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            errorCode = -1;
            errorMsg = "default onNoAD";
        }
        YFLog.error(" onError: code = " + errorCode + " msg = " + errorMsg);
        handleFailed(YFAdError.parseErr(errorCode, errorMsg));
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADReceive() {
        try {
            YFLog.high(this.tag + "onADReceive");
            UnifiedBannerView unifiedBannerView = this.bv;
            if (unifiedBannerView != null) {
                setEcpm(unifiedBannerView.getECPM());
            }
            handleSucceed();
        } catch (Throwable th) {
            th.printStackTrace();
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (isNative()) {
            NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
            return nativeUnifiedADData != null && nativeUnifiedADData.isValid();
        }
        UnifiedBannerView unifiedBannerView = this.bv;
        return unifiedBannerView != null && unifiedBannerView.isValid();
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADExposure() {
        YFLog.high(this.tag + "onADExposure");
        handleExposure();
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADClosed() {
        YFLog.high(this.tag + "onADClosed");
        handleClose();
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADClicked() {
        YFLog.high(this.tag + "onADClicked");
        handleClick();
    }

    @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
    public void onADLeftApplication() {
        YFLog.high(this.tag + "onADLeftApplication");
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhBannerAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            loadBannerAdByNative(context);
        } else {
            loadBannerAd(context);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isNative()) {
            NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
            return nativeUnifiedADData != null ? YlhUtil.getReqId(nativeUnifiedADData.getExtraInfo()) : "";
        }
        UnifiedBannerView unifiedBannerView = this.bv;
        return unifiedBannerView != null ? YlhUtil.getReqId(unifiedBannerView.getExtraInfo()) : "";
    }

    private void loadBannerAd(Context context) {
        if (context instanceof Activity) {
            this.bv = new UnifiedBannerView((Activity) context, this.sdkSupplier.getPotId(), this);
            YFLog.high(this.tag + " load banner setRefresh " + this.sdkSupplier.getRefreshInterval());
            this.bv.setRefresh(this.sdkSupplier.getRefreshInterval() / 1000);
            this.bv.loadAD();
            return;
        }
        YFLog.error("loadBannerAd context is not activity " + context);
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_YLH_CONTEXT));
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

    private void showTemplateADs(ViewGroup viewGroup) {
        if (this.bv == null || viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(this.bv, new RelativeLayout.LayoutParams(-1, -2));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        UnifiedBannerView unifiedBannerView = this.bv;
        String shortString = "";
        if (unifiedBannerView != null) {
            unifiedBannerView.sendWinNotification(YlhUtil.getWindBiddingMap(unifiedBannerView.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.sendWinNotification(YlhUtil.getWindBiddingMap(nativeUnifiedADData.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.bv != null && sdkSupplier != null) {
            this.bv.sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier())));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (this.nativeAds == null || sdkSupplier == null) {
            return;
        }
        this.nativeAds.sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier())));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return YlhUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, ViewGroup viewGroup, final AdBannerViewHolder adBannerViewHolder) {
        String buttonText;
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        boolean z = nativeUnifiedADData.getAdPatternType() == 2;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDesc(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (!TextUtils.isEmpty(this.nativeAds.getImgUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImgUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            this.feedBean.imageUrl = this.nativeAds.getImgUrl();
            ViewUtils.loadBlurImage(this.nativeAds.getImgUrl(), adBannerViewHolder.imageBlur, 20);
            ViewUtils.loadImage(this.nativeAds.getImgUrl(), adBannerViewHolder.showImg);
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_ylh_v3);
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        String desc = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getDesc() : this.nativeAds.getTitle();
        String title = TextUtils.isEmpty(this.nativeAds.getDesc()) ? this.nativeAds.getTitle() : this.nativeAds.getDesc();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (desc == null) {
                desc = "";
            }
            textView.setText(desc);
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
                if (TextUtils.isEmpty(this.nativeAds.getButtonText())) {
                    buttonText = getContext().getString(R.string.yf_default_download_text);
                } else {
                    buttonText = this.nativeAds.getButtonText();
                }
                textView3.setText(buttonText);
                this.feedBean.actBtnString = this.nativeAds.getButtonText();
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(this.nativeAds.getIconUrl())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(this.nativeAds.getIconUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhBannerAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1165lambda$bindData$0$comyfanadsadschanelylhYlhBannerAdapter(adBannerViewHolder, view);
            }
        });
        if (activity != null) {
            if (this.feedBean != null) {
                this.feedBean.contextName = activity.getLocalClassName();
            }
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhBannerAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1166lambda$bindData$1$comyfanadsadschanelylhYlhBannerAdapter(fragmentManager, view);
                }
            });
        }
        registerViewForInteraction(adBannerViewHolder, z, this.nativeAds, bannerTemplateData);
        complianceContent(adBannerViewHolder, bannerTemplateData, this.nativeAds);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ylh-YlhBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1165lambda$bindData$0$comyfanadsadschanelylhYlhBannerAdapter(AdBannerViewHolder adBannerViewHolder, View view) {
        closeAds(adBannerViewHolder.nativeAdContainer);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ylh-YlhBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1166lambda$bindData$1$comyfanadsadschanelylhYlhBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, NativeUnifiedADData nativeUnifiedADData) {
        if (isDownloadAd(nativeUnifiedADData)) {
            NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
            if (appMiitInfo == null) {
                adBannerViewHolder.complianceContent.setVisibility(8);
                return;
            }
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(appMiitInfo.getAppName(), appMiitInfo.getVersionName(), appMiitInfo.getAuthorName(), appMiitInfo.getDescriptionUrl(), appMiitInfo.getPermissionsUrl(), appMiitInfo.getPrivacyAgreement()));
            if (this.feedBean != null) {
                this.feedBean.updateAppInfo(appMiitInfo.getAppName(), appMiitInfo.getVersionName(), appMiitInfo.getAuthorName());
                return;
            }
            return;
        }
        adBannerViewHolder.complianceContent.setVisibility(8);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        UnifiedBannerView unifiedBannerView = this.bv;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
            this.bv = null;
        }
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
            this.nativeAds = null;
        }
    }

    private void loadBannerAdByNative(Context context) {
        new NativeUnifiedAD(context, this.sdkSupplier.getPotId(), new NativeADUnifiedListener() { // from class: com.yfanads.ads.chanel.ylh.YlhBannerAdapter.2
            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YlhBannerAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                YFLog.high(YlhBannerAdapter.this.tag + "onNativeAdLoad");
                try {
                    if (YlhBannerAdapter.this.nativeAds != null) {
                        YlhBannerAdapter.this.nativeAds.destroy();
                    }
                    if (list != null && list.size() != 0 && list.get(0) != null) {
                        YlhBannerAdapter.this.nativeAds = list.get(0);
                        YlhBannerAdapter ylhBannerAdapter = YlhBannerAdapter.this;
                        ylhBannerAdapter.setEcpm(ylhBannerAdapter.nativeAds.getECPM());
                        YlhBannerAdapter.this.handleSucceed();
                        return;
                    }
                    YlhBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Throwable th) {
                    YFLog.error("onADLoaded = " + th.getMessage());
                    YlhBannerAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }
        }).loadData(1);
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAds == null || viewGroup == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getAdPatternType());
            addView(activity, viewGroup, new NativeAdContainer(getContext()));
        }
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public boolean isDownloadType() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData != null) {
            return isDownloadAd(nativeUnifiedADData);
        }
        return super.isDownloadType();
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, NativeUnifiedADData nativeUnifiedADData, BannerTemplateData bannerTemplateData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (bannerTemplateData.isShowDownloadDialog()) {
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
        } else {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    arrayList2.add(adBannerViewHolder.viewGroup);
                }
                arrayList2.add(adBannerViewHolder.adCloseDelay);
            } else {
                arrayList2.add(adBannerViewHolder.dyClickView);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                arrayList2.add(adBannerViewHolder.adDes);
                arrayList2.add(adBannerViewHolder.titleDes);
            }
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                if (isDownloadAd(nativeUnifiedADData) && !bannerTemplateData.isActionShowDialog()) {
                    arrayList2.add(adBannerViewHolder.mDownloadBar);
                } else {
                    arrayList.add(adBannerViewHolder.mDownloadBar);
                }
            } else if (isDownloadAd(nativeUnifiedADData) && !bannerTemplateData.isActionShowDialog()) {
                arrayList2.add(adBannerViewHolder.mDownload);
            } else {
                arrayList.add(adBannerViewHolder.mDownload);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
        layoutParams.gravity = 53;
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhBannerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(adBannerViewHolder, bannerTemplateData, nativeUnifiedADData, layoutParams, arrayList, arrayList2, bannerTemplateData.isMute());
        } else {
            bindImageViews(adBannerViewHolder, nativeUnifiedADData, arrayList, arrayList2, layoutParams);
        }
    }

    private void bindMediaView(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, NativeUnifiedADData nativeUnifiedADData, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2, boolean z) {
        nativeUnifiedADData.bindAdToView(getContext(), (NativeAdContainer) adBannerViewHolder.nativeAdContainer, layoutParams, list, list2);
        VideoOption videoOptionBuild = new VideoOption.Builder().setAutoPlayMuted(z).setAutoPlayPolicy(1).setNeedCoverImage(true).setEnableUserControl(bannerTemplateData.isTemplateV3() && !bannerTemplateData.isWholeClick()).build();
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            adBannerViewHolder.mediaViewFrame.removeAllViews();
            adBannerViewHolder.mediaViewFrame.addView(mediaView);
        }
        nativeUnifiedADData.bindMediaView(mediaView, videoOptionBuild, new NativeADMediaListener() { // from class: com.yfanads.ads.chanel.ylh.YlhBannerAdapter.3
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoReady: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoStart: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoPause: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoResume: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoCompleted: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoError: ");
                YlhBannerAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoStop: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                YFLog.debug(YlhBannerAdapter.this.tag + "onVideoClicked: ");
            }
        });
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.yfanads.ads.chanel.ylh.YlhBannerAdapter.4
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                YFLog.high(YlhBannerAdapter.this.tag + " native media onADExposure");
                YlhBannerAdapter.this.handleExposure();
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                YFLog.high(YlhBannerAdapter.this.tag + " native media onADClicked");
                YlhBannerAdapter.this.handleClick();
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                YlhBannerAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }
        });
    }

    private void bindImageViews(AdBannerViewHolder adBannerViewHolder, NativeUnifiedADData nativeUnifiedADData, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams) {
        nativeUnifiedADData.bindAdToView(getContext(), (NativeAdContainer) adBannerViewHolder.nativeAdContainer, layoutParams, list, list2);
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.yfanads.ads.chanel.ylh.YlhBannerAdapter.5
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                YFLog.high(YlhBannerAdapter.this.tag + " native image onADExposure");
                YlhBannerAdapter.this.handleExposure();
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                YFLog.high(YlhBannerAdapter.this.tag + " native image onADClicked");
                YlhBannerAdapter.this.handleClick();
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                YlhBannerAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }
        });
    }

    private boolean isDownloadAd(NativeUnifiedADData nativeUnifiedADData) {
        return nativeUnifiedADData.isAppAd();
    }
}
