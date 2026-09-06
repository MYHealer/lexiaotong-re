package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.cdo.oaps.ad.OapsKey;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
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
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjBannerAdapter extends BannerCustomAdapter implements TTNativeAd.AdInteractionListener, TTFeedAd.VideoAdListener {
    protected TTNativeExpressAd ad;
    protected String ecpm;
    public TTFeedAd nativeAds;

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdComplete(TTFeedAd tTFeedAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdPaused(TTFeedAd tTFeedAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoError(int i, int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoLoad(TTFeedAd tTFeedAd) {
    }

    public CsjBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nativeExpressAdLoad(List<TTNativeExpressAd> list) {
        try {
            YFLog.high(this.tag + "onNativeExpressAdLoad");
            if (list != null && list.size() != 0) {
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                this.ad = tTNativeExpressAd;
                if (tTNativeExpressAd == null) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "广告数据为空");
                    return;
                }
                if (isBidding()) {
                    updPrice();
                    setEcpmByStr(this.ecpm);
                }
                handleSucceed();
                return;
            }
            handleFailed(YFAdError.ERROR_DATA_NULL, "广告列表数据为空");
        } catch (Throwable th) {
            YFLog.error(this.tag + " onNativeExpressAdLoad " + th.getMessage());
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    private void bindAdListener(Activity activity, final ViewGroup viewGroup, TTNativeExpressAd tTNativeExpressAd) {
        try {
            tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter.1
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i) {
                    CsjBannerAdapter.this.handleClick();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i) {
                    CsjBannerAdapter.this.handleExposure();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i) {
                    YFLog.error(CsjBannerAdapter.this.tag + " bindAdListener onRenderFail msg: " + str + "_" + i);
                    CsjBannerAdapter.this.handleRenderFailed();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f, float f2) {
                    YFLog.high(CsjBannerAdapter.this.tag + "ExpressView onRenderSuccess ");
                    CsjBannerAdapter.this.onRenderAddView(view, viewGroup);
                }
            });
            if (activity != null) {
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        CsjBannerAdapter.this.closeAds(viewGroup);
                    }
                });
            }
        } catch (Throwable th) {
            YFLog.error(this.tag + " bindAdListener " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRenderAddView(View view, ViewGroup viewGroup) {
        TTNativeExpressAd tTNativeExpressAd;
        if (view == null && (tTNativeExpressAd = this.ad) != null) {
            view = tTNativeExpressAd.getExpressAdView();
        }
        if (viewGroup == null || view == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(view);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        try {
            super.doDestroy();
            TTNativeExpressAd tTNativeExpressAd = this.ad;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
                this.ad = null;
            }
            TTFeedAd tTFeedAd = this.nativeAds;
            if (tTFeedAd != null) {
                tTFeedAd.destroy();
                this.nativeAds = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter.3
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                CsjBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjBannerAdapter.this.handleFailed(str, str2);
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

    private void loadBannerAd(Context context) {
        CsjUtil.getADManger().createAdNative(context).loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setExpressViewAcceptedSize(this.setting.getViewWidth(), this.setting.getViewHeight()).setSupportDeepLink(true).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter.4
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                CsjBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                CsjBannerAdapter.this.nativeExpressAdLoad(list);
            }
        });
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        if (isNative()) {
            showNativeADs(activity, viewGroup);
            return;
        }
        bindAdListener(activity, viewGroup, this.ad);
        if (this.ad != null) {
            if (isBidding()) {
                this.ad.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
            }
            YFLog.high(this.tag + " load banner setSlideIntervalTime " + this.sdkSupplier.getRefreshInterval());
            this.ad.setSlideIntervalTime(this.sdkSupplier.getRefreshInterval());
            this.ad.render();
            return;
        }
        handleShowFailed();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isNative()) {
            TTFeedAd tTFeedAd = this.nativeAds;
            return tTFeedAd != null ? CsjUtil.getReqId(tTFeedAd.getMediaExtraInfo()) : "";
        }
        TTNativeExpressAd tTNativeExpressAd = this.ad;
        return tTNativeExpressAd != null ? CsjUtil.getReqId(tTNativeExpressAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (isNative()) {
            TTFeedAd tTFeedAd = this.nativeAds;
            return (tTFeedAd == null || tTFeedAd.getMediationManager() == null || !this.nativeAds.getMediationManager().isReady()) ? false : true;
        }
        TTNativeExpressAd tTNativeExpressAd = this.ad;
        return (tTNativeExpressAd == null || tTNativeExpressAd.getMediaExtraInfo() == null || !this.ad.getMediationManager().isReady()) ? false : true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    private void loadBannerAdByNative(Context context) {
        CsjUtil.getADManger().createAdNative(context).loadFeedAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setSupportDeepLink(true).build(), new TTAdNative.FeedAdListener() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter.5
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                CsjBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                YFLog.high(CsjBannerAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() != 0 && list.get(0) != null) {
                            CsjBannerAdapter.this.nativeAds = list.get(0);
                            if (CsjBannerAdapter.this.isBidding()) {
                                CsjBannerAdapter.this.updPrice();
                                CsjBannerAdapter csjBannerAdapter = CsjBannerAdapter.this;
                                csjBannerAdapter.setEcpmByStr(csjBannerAdapter.ecpm);
                            }
                            CsjBannerAdapter.this.handleSucceed();
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        CsjBannerAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                        return;
                    }
                }
                CsjBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
            }
        });
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAds == null || viewGroup == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
            return;
        }
        if (isBidding()) {
            this.nativeAds.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
        }
        YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getMediaExtraInfo());
        addView(activity, viewGroup);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final ViewGroup viewGroup, AdBannerViewHolder adBannerViewHolder) {
        TTImage tTImage;
        String buttonText;
        boolean z = this.nativeAds.getImageMode() == 5 || this.nativeAds.getImageMode() == 15;
        if (!this.isSupportShake && bannerTemplateData.isAction()) {
            if (bannerTemplateData.isOnlyAction()) {
                bannerTemplateData.setWholeClick();
            }
            bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDescription(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (this.nativeAds.getVideoCoverImage() != null) {
                ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (tTImage = this.nativeAds.getImageList().get(0)) != null && !TextUtils.isEmpty(tTImage.getImageUrl())) {
                this.feedBean.imageUrl = tTImage.getImageUrl();
                ViewUtils.loadBlurImage(tTImage.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(tTImage.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_csj_v3);
        String description = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getDescription() : this.nativeAds.getTitle();
        String title = TextUtils.isEmpty(this.nativeAds.getDescription()) ? this.nativeAds.getTitle() : this.nativeAds.getDescription();
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
                if (TextUtils.isEmpty(this.nativeAds.getButtonText())) {
                    buttonText = getContext().getString(R.string.yf_default_download_text);
                } else {
                    buttonText = this.nativeAds.getButtonText();
                }
                textView3.setText(buttonText);
                if (this.feedBean != null) {
                    this.feedBean.actBtnString = this.nativeAds.getButtonText();
                }
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        TTImage icon = this.nativeAds.getIcon();
        if (bannerTemplateData.isShowAdIcon() && icon != null) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(icon.getImageUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1078lambda$bindData$0$comyfanadsadschanelcsjCsjBannerAdapter(viewGroup, view);
            }
        });
        registerViewForInteraction(viewGroup, adBannerViewHolder, z, this.nativeAds, bannerTemplateData);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1079lambda$bindData$1$comyfanadsadschanelcsjCsjBannerAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, this.nativeAds);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-csj-CsjBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1078lambda$bindData$0$comyfanadsadschanelcsjCsjBannerAdapter(ViewGroup viewGroup, View view) {
        closeAds(viewGroup);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-csj-CsjBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1079lambda$bindData$1$comyfanadsadschanelcsjCsjBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(ViewGroup viewGroup, AdBannerViewHolder adBannerViewHolder, boolean z, TTFeedAd tTFeedAd, BannerTemplateData bannerTemplateData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
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
                    arrayList3.add(adBannerViewHolder.viewGroup);
                }
                arrayList3.add(adBannerViewHolder.adCloseDelay);
            } else {
                arrayList3.add(adBannerViewHolder.dyClickView);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                arrayList3.add(adBannerViewHolder.adDes);
                arrayList3.add(adBannerViewHolder.titleDes);
            }
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                if (isDownloadType(tTFeedAd) && !bannerTemplateData.isActionShowDialog()) {
                    arrayList3.add(adBannerViewHolder.mDownloadBar);
                } else {
                    arrayList2.add(adBannerViewHolder.mDownloadBar);
                }
            } else if (isDownloadType(tTFeedAd) && !bannerTemplateData.isActionShowDialog()) {
                arrayList3.add(adBannerViewHolder.mDownload);
            } else {
                arrayList2.add(adBannerViewHolder.mDownload);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new View(getContext()));
        }
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(adBannerViewHolder, tTFeedAd, bannerTemplateData, arrayList, arrayList2, arrayList3);
        } else {
            bindImageViews(viewGroup, adBannerViewHolder, bannerTemplateData, tTFeedAd, arrayList, arrayList2, arrayList3);
        }
    }

    private boolean isDownloadType(TTFeedAd tTFeedAd) {
        return tTFeedAd.getInteractionType() == 4;
    }

    private void bindMediaView(final AdBaseViewHolder adBaseViewHolder, final TTFeedAd tTFeedAd, final BannerTemplateData bannerTemplateData, List<View> list, List<View> list2, List<View> list3) {
        tTFeedAd.setVideoAdListener(this);
        tTFeedAd.registerViewForInteraction(adBaseViewHolder.viewGroup, (List<View>) null, list, list2, list3, adBaseViewHolder.dislikeBtn, this);
        final View adView = tTFeedAd.getAdView();
        adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1081x5c358cca(adBaseViewHolder, tTFeedAd, bannerTemplateData, adView);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$3$com-yfanads-ads-chanel-csj-CsjBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1081x5c358cca(AdBaseViewHolder adBaseViewHolder, TTFeedAd tTFeedAd, BannerTemplateData bannerTemplateData, View view) {
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int adViewWidth = tTFeedAd.getAdViewWidth();
        int adViewHeight = tTFeedAd.getAdViewHeight();
        YFLog.info(this.tag + " w" + width + "|h" + height + "|vw" + adViewWidth + "|vh" + adViewHeight);
        if (bannerTemplateData.isTemplateV3()) {
            updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, height, adViewWidth, adViewHeight);
        } else if (adViewWidth > 0 && adViewHeight > 0 && !ViewUtils.isHorizontal(adViewWidth, adViewHeight)) {
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, (adViewWidth * height) / adViewHeight, height);
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adBaseViewHolder.mediaViewFrame.removeAllViews();
        adBaseViewHolder.mediaViewFrame.addView(view);
    }

    private void bindImageViews(ViewGroup viewGroup, final AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, final TTFeedAd tTFeedAd, List<View> list, List<View> list2, List<View> list3) {
        tTFeedAd.registerViewForInteraction(adBannerViewHolder.viewGroup, (List<View>) null, list, list2, list3, adBannerViewHolder.dislikeBtn, this);
        if (bannerTemplateData.isTemplateV3()) {
            adBannerViewHolder.showImg.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjBannerAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1080x18d09869(tTFeedAd, adBannerViewHolder);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$bindImageViews$4$com-yfanads-ads-chanel-csj-CsjBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1080x18d09869(TTFeedAd tTFeedAd, AdBannerViewHolder adBannerViewHolder) {
        int adViewWidth = tTFeedAd.getAdViewWidth();
        int adViewHeight = tTFeedAd.getAdViewHeight();
        int width = adBannerViewHolder.showImg.getWidth();
        int height = adBannerViewHolder.showImg.getHeight();
        YFLog.info(this.tag + " w" + width + "|h" + height + "|vw" + adViewWidth + "|vh" + adViewHeight);
        updateMaterialArea(adBannerViewHolder.showImg, width, height, adViewWidth, adViewHeight);
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, TTFeedAd tTFeedAd) {
        if (isDownloadAd(tTFeedAd)) {
            ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
            if (complianceInfo == null) {
                YFLog.error(this.tag + " has no complianceInfo, return.");
                adBannerViewHolder.complianceContent.setVisibility(8);
                return;
            } else {
                complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(complianceInfo.getAppName(), complianceInfo.getAppVersion(), complianceInfo.getDeveloperName(), complianceInfo.getFunctionDescUrl(), complianceInfo.getPermissionUrl(), complianceInfo.getPrivacyUrl()));
                if (this.feedBean != null) {
                    this.feedBean.updateAppInfo(complianceInfo.getAppName(), complianceInfo.getAppVersion(), complianceInfo.getDeveloperName());
                    return;
                }
                return;
            }
        }
        adBannerViewHolder.complianceContent.setVisibility(8);
    }

    private boolean isDownloadAd(TTFeedAd tTFeedAd) {
        return isDownloadType(tTFeedAd);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public boolean isDownloadType() {
        TTFeedAd tTFeedAd = this.nativeAds;
        if (tTFeedAd != null) {
            return isDownloadAd(tTFeedAd);
        }
        return super.isDownloadType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        MediationAdEcpmInfo showEcpm;
        TTFeedAd tTFeedAd;
        if (isBidding()) {
            if (isGromoreAdn() && isNative() && (tTFeedAd = this.nativeAds) != null && tTFeedAd.getMediationManager() != null) {
                MediationAdEcpmInfo showEcpm2 = this.nativeAds.getMediationManager().getShowEcpm();
                if (showEcpm2 != null) {
                    String mShowEcpm = CsjUtil.getMShowEcpm(showEcpm2);
                    this.ecpm = mShowEcpm;
                    if (!TextUtils.isEmpty(mShowEcpm)) {
                        setEcpmByStr(this.ecpm);
                    }
                }
            } else {
                TTNativeExpressAd tTNativeExpressAd = this.ad;
                if (tTNativeExpressAd != null && tTNativeExpressAd.getMediationManager() != null && (showEcpm = this.ad.getMediationManager().getShowEcpm()) != null) {
                    String mShowEcpm2 = CsjUtil.getMShowEcpm(showEcpm);
                    this.ecpm = mShowEcpm2;
                    if (!TextUtils.isEmpty(mShowEcpm2)) {
                        setEcpmByStr(this.ecpm);
                    }
                }
            }
            YFLog.high(this.tag + "newVersionAd onAdShow ep_" + this.ecpm);
        } else {
            YFLog.high(this.tag + "newVersionAd onAdShow");
        }
        handleExposure();
    }

    protected void updPrice() {
        try {
            Object obj = "1";
            if (isNative()) {
                TTFeedAd tTFeedAd = this.nativeAds;
                if (tTFeedAd != null && tTFeedAd.getMediaExtraInfo() != null) {
                    Object obj2 = this.nativeAds.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                    if (obj2 != null) {
                        obj = obj2;
                    }
                    this.ecpm = String.valueOf(obj);
                }
            } else {
                TTNativeExpressAd tTNativeExpressAd = this.ad;
                if (tTNativeExpressAd != null && tTNativeExpressAd.getMediaExtraInfo() != null) {
                    Object obj3 = this.ad.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                    if (obj3 != null) {
                        obj = obj3;
                    }
                    this.ecpm = String.valueOf(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        TTNativeExpressAd tTNativeExpressAd = this.ad;
        String shortString = "";
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        TTFeedAd tTFeedAd = this.nativeAds;
        if (tTFeedAd != null) {
            tTFeedAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        TTNativeExpressAd tTNativeExpressAd = this.ad;
        if (tTNativeExpressAd != null && sdkSupplier != null) {
            tTNativeExpressAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        TTFeedAd tTFeedAd = this.nativeAds;
        if (tTFeedAd == null || sdkSupplier == null) {
            return;
        }
        tTFeedAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return CsjUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    private boolean isGromoreAdn() {
        return getAdnId() == YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }
}
