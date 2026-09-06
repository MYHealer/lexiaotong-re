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
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.ads.chanel.ry.utils.RYUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.custom.MixBannerCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class RYMixBannerAdapter extends MixBannerCustomAdapter implements PictureTextAdLoadListener {
    private BannerExpressAd mBannerExpressAd;
    private List<PictureTextExpressAd> nativeAds;
    private List<PictureTextExpressAd> nativeAds2;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 13;
    }

    public RYMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.RY.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        RYUtil.initRY(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ry.RYMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                RYMixBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                RYMixBannerAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadNativeAd(Context context) {
        loadAdByNative();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadTemplateAd(Context context) {
        loadTemplate();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadBannerAd(Context context) {
        loadBannerAd();
    }

    private void loadBannerAd() {
        new BannerAdLoad.Builder().setBannerAdLoadListener(new BannerAdLoadListener() { // from class: com.yfanads.ads.chanel.ry.RYMixBannerAdapter.2
            @Override // com.hihonor.adsdk.base.api.banner.BannerAdLoadListener
            public void onLoadSuccess(BannerExpressAd bannerExpressAd) {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onLoadSuccess");
                RYMixBannerAdapter.this.mBannerExpressAd = bannerExpressAd;
                RYMixBannerAdapter.this.handleSucceed();
            }

            @Override // com.hihonor.adsdk.base.callback.BaseListener
            public void onFailed(String str, String str2) {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onFailed: " + str + "," + str2);
                RYMixBannerAdapter.this.handleFailed(str, str2);
            }
        }).setAdSlot(new AdSlot.Builder().setSlotId(this.sdkSupplier.getPotId()).setWidth(ScreenUtil.dip2px(getContext(), this.setting.getViewWidth())).setHeight(this.setting.getViewHeight() != 0 ? ScreenUtil.dip2px(getContext(), this.setting.getViewHeight()) : 720).build()).build().loadAd();
    }

    private void loadTemplate() {
        int iPx2dip = ScreenUtil.px2dip(getContext(), ScreenUtil.getScreenWidth(getContext()));
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            iPx2dip = this.setting.getViewWidth();
        }
        new PictureTextAdLoad.Builder().setAdSlot(new AdSlot.Builder().setSlotId(this.sdkSupplier.getPotId()).setWidth(iPx2dip).build()).setPictureTextAdLoadListener(this).build().loadAd();
    }

    private void loadAdByNative() {
        new PictureTextAdLoad.Builder().setPictureTextAdLoadListener(this).setAdSlot(new AdSlot.Builder().setSlotId(this.sdkSupplier.getPotId()).setRenderType(1).build()).build().loadAd();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowTemplateAd(Activity activity) {
        doShowTemplateAd();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowBannerAd(Activity activity) {
        doShowBannerAd();
    }

    private void doShowBannerAd() {
        try {
            if (this.mBannerExpressAd != null) {
                YFLog.high(this.tag + " load banner setBannerRefresh " + this.sdkSupplier.getRefreshInterval());
                this.mBannerExpressAd.setIntervalTime(this.sdkSupplier.getRefreshInterval() / 1000);
                if (this.setting != null) {
                    this.viewList.clear();
                    this.viewList.add(new YFExpView(this.mBannerExpressAd.getExpressAdView(), getAdType()));
                    this.mBannerExpressAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.RYMixBannerAdapter.3
                        @Override // com.hihonor.adsdk.base.callback.AdListener
                        public void onAdImpression() {
                            YFLog.debug(RYMixBannerAdapter.this.tag + "onAdImpression: ");
                            RYMixBannerAdapter.this.handleExposure(0);
                        }

                        @Override // com.hihonor.adsdk.base.callback.AdListener
                        public void onAdClicked() {
                            YFLog.debug(RYMixBannerAdapter.this.tag + "onAdClicked: ");
                            RYMixBannerAdapter.this.handleClick(0, false);
                        }

                        @Override // com.hihonor.adsdk.base.callback.AdListener
                        public void onAdClosed() {
                            RYMixBannerAdapter.this.closeAds(0);
                            YFLog.high(RYMixBannerAdapter.this.tag + " onAdClosed");
                        }

                        @Override // com.hihonor.adsdk.base.callback.AdListener
                        public void onMiniAppStarted() {
                            YFLog.debug(RYMixBannerAdapter.this.tag + "onMiniAppStarted: ");
                            super.onMiniAppStarted();
                        }
                    });
                    this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
                }
            } else if (this.setting != null) {
                this.setting.adapterRenderFailed(this.sdkSupplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doShowTemplateAd() {
        List<PictureTextExpressAd> list = this.nativeAds;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (PictureTextExpressAd pictureTextExpressAd : this.nativeAds) {
                final YFExpView yFExpView = new YFExpView(pictureTextExpressAd.getExpressAdView(), getAdType());
                arrayList.add(yFExpView);
                pictureTextExpressAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.RYMixBannerAdapter.4
                    @Override // com.hihonor.adsdk.base.callback.AdListener
                    public void onAdClosed() {
                        YFLog.debug(RYMixBannerAdapter.this.tag + "onAdClosed: ");
                        RYMixBannerAdapter.this.handleClose(yFExpView);
                    }

                    @Override // com.hihonor.adsdk.base.callback.AdListener
                    public void onAdSkip(int i) {
                        YFLog.debug(RYMixBannerAdapter.this.tag + "onAdSkip: ");
                        RYMixBannerAdapter.this.handleClose(yFExpView);
                    }

                    @Override // com.hihonor.adsdk.base.callback.AdListener
                    public void onAdClicked() {
                        YFLog.debug(RYMixBannerAdapter.this.tag + "onAdClicked: ");
                        RYMixBannerAdapter.this.handleClick(yFExpView);
                    }

                    @Override // com.hihonor.adsdk.base.callback.AdListener
                    public void onAdImpression() {
                        YFLog.debug(RYMixBannerAdapter.this.tag + "onAdImpression: ");
                        RYMixBannerAdapter.this.handleExposure(yFExpView);
                    }

                    @Override // com.hihonor.adsdk.base.callback.AdListener
                    public void onAdImpressionFailed(int i, String str) {
                        YFLog.debug(RYMixBannerAdapter.this.tag + "onAdImpressionFailed: ");
                        RYMixBannerAdapter.this.handleRenderFailed(yFExpView);
                    }

                    @Override // com.hihonor.adsdk.base.callback.AdListener
                    public void onMiniAppStarted() {
                        YFLog.debug(RYMixBannerAdapter.this.tag + "onMiniAppStarted: ");
                        super.onMiniAppStarted();
                    }
                });
            }
            if (this.setting != null) {
                this.setting.adapterRenderSuccess(this.sdkSupplier, arrayList);
                return;
            }
            return;
        }
        if (this.setting != null) {
            this.setting.adapterRenderFailed(this.sdkSupplier);
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        List<PictureTextExpressAd> list = this.nativeAds;
        if (list != null && !list.isEmpty()) {
            releaseAds(this.nativeAds);
            this.nativeAds.clear();
        }
        this.nativeAds = null;
        List<PictureTextExpressAd> list2 = this.nativeAds2;
        if (list2 != null && !list2.isEmpty()) {
            releaseAds(this.nativeAds2);
            this.nativeAds2.clear();
        }
        this.nativeAds2 = null;
        BannerExpressAd bannerExpressAd = this.mBannerExpressAd;
        if (bannerExpressAd != null) {
            bannerExpressAd.release();
            this.mBannerExpressAd = null;
        }
    }

    private void releaseAds(List<PictureTextExpressAd> list) {
        for (PictureTextExpressAd pictureTextExpressAd : list) {
            if (pictureTextExpressAd != null) {
                if (pictureTextExpressAd.getAdVideo() != null) {
                    pictureTextExpressAd.getAdVideo().releasePlayer();
                }
                pictureTextExpressAd.release();
            }
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public ViewGroup getNativeAdContainer() {
        return new PictureTextAdRootView(getContext());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<PictureTextExpressAd> list = this.nativeAds2;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        String buttonText;
        PictureTextExpressAd adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        boolean zHasVideo = adNative.hasVideo();
        YFLog.high(this.tag + " bindData isVideo " + zHasVideo);
        this.feedBean = new FeedBean(adNative.getTitle(), adNative.getBrand(), zHasVideo, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (zHasVideo) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (!TextUtils.isEmpty(adNative.getCoverUrl())) {
                ViewUtils.loadBlurImage(adNative.getCoverUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (adNative.getImages() != null && !adNative.getImages().isEmpty()) {
                String str = adNative.getImages().get(0);
                this.feedBean.imageUrl = str;
                ViewUtils.loadBlurImage(str, adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(str, adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_ry_v3);
        String brand = TextUtils.isEmpty(adNative.getTitle()) ? adNative.getBrand() : adNative.getTitle();
        String brand2 = TextUtils.isEmpty(adNative.getTitle()) ? adNative.getBrand() : adNative.getTitle();
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
                if (TextUtils.isEmpty(adNative.getButtonText())) {
                    buttonText = getContext().getString(R.string.yf_default_download_text);
                } else {
                    buttonText = adNative.getButtonText();
                }
                textView3.setText(buttonText);
                if (this.feedBean != null) {
                    this.feedBean.actBtnString = adNative.getButtonText();
                }
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(adNative.getLogo())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(adNative.getLogo(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ry.RYMixBannerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1155lambda$bindData$0$comyfanadsadschanelryRYMixBannerAdapter(i, view);
            }
        });
        registerViewForInteraction(adBannerViewHolder, zHasVideo, adNative, bannerTemplateData, i);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ry.RYMixBannerAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1156lambda$bindData$1$comyfanadsadschanelryRYMixBannerAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ry-RYMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1155lambda$bindData$0$comyfanadsadschanelryRYMixBannerAdapter(int i, View view) {
        YFLog.debug(this.tag + "closeAds");
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ry-RYMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1156lambda$bindData$1$comyfanadsadschanelryRYMixBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        String shortString = "";
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            Iterator<PictureTextExpressAd> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().sendWinNotification(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0L);
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (YFListUtils.isEmpty(this.nativeAds2)) {
            return;
        }
        Iterator<PictureTextExpressAd> it2 = this.nativeAds2.iterator();
        while (it2.hasNext()) {
            it2.next().sendWinNotification(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0L);
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds2.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" ,loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            return RYUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
        }
        return super.getAdInfo();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        String shortString = "";
        if (!YFListUtils.isEmpty(this.nativeAds) && sdkSupplier != null) {
            Iterator<PictureTextExpressAd> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().sendLossNotification(sdkSupplier.ecpm, ErrorCode.AD_BID_FAILED, sdkSupplier.getAdnId());
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier2 == null) ? "" : sdkSupplier2.toShortString()));
        }
        if (YFListUtils.isEmpty(this.nativeAds2) || sdkSupplier == null) {
            return;
        }
        Iterator<PictureTextExpressAd> it2 = this.nativeAds2.iterator();
        while (it2.hasNext()) {
            it2.next().sendLossNotification(sdkSupplier.ecpm, ErrorCode.AD_BID_FAILED, sdkSupplier.getAdnId());
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingLossResult size=").append(this.nativeAds2.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
        if (UrlConst.isTestEnv() && sdkSupplier2 != null) {
            shortString = sdkSupplier2.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextAdLoadListener
    public void onAdLoaded(List<PictureTextExpressAd> list) {
        loadSuccess(list);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x007c A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #0 {all -> 0x007a, blocks: (B:4:0x0006, B:6:0x000c, B:9:0x0014, B:11:0x001a, B:12:0x0045, B:14:0x004b, B:15:0x0076, B:18:0x007c), top: B:23:0x0006 }] */
    private void loadSuccess(List<PictureTextExpressAd> list) {
        if (list != null) {
            try {
                if (list.isEmpty() || list.get(0) == null) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } else if (isNative()) {
                    YFLog.high(this.tag + " onNativeAdLoad");
                    this.nativeAds2 = list;
                    setEcpm(list.get(0).getEcpm());
                    handleSucceed();
                } else if (isTemplate()) {
                    YFLog.high(this.tag + " onTemplateAdLoad");
                    this.nativeAds = list;
                    setEcpm(list.get(0).getEcpm());
                    handleSucceed();
                } else {
                    handleFailed(YFAdError.ERROR_DATA_NULL, PPSLabelView.Code);
                }
            } catch (Throwable th) {
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, PPSLabelView.Code + th.getMessage());
            }
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
        }
    }

    @Override // com.hihonor.adsdk.base.callback.BaseListener
    public void onFailed(String str, String str2) {
        handleFailed(str, str2);
    }

    private PictureTextExpressAd getAdNative(int i) {
        if (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size()) {
            YFLog.error("bindData error " + i);
            return null;
        }
        return this.nativeAds2.get(i);
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

    private boolean isDownloadAd(PictureTextExpressAd pictureTextExpressAd) {
        return pictureTextExpressAd.getPromotionPurpose() == 0;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public boolean isDownloadType(int i) {
        List<PictureTextExpressAd> list = this.nativeAds2;
        if (list != null && list.get(i) != null) {
            return isDownloadAd(this.nativeAds2.get(i));
        }
        return super.isDownloadType(i);
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, PictureTextExpressAd pictureTextExpressAd, BannerTemplateData bannerTemplateData, int i) {
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
            bindMediaView(adBannerViewHolder, pictureTextExpressAd, arrayList, this.sdkSupplier.isMuted(), i);
        } else {
            bindImageViews(adBannerViewHolder, pictureTextExpressAd, arrayList, i);
        }
    }

    private void bindMediaView(AdBannerViewHolder adBannerViewHolder, PictureTextExpressAd pictureTextExpressAd, List<View> list, boolean z, int i) {
        PictureTextAdRootView pictureTextAdRootView = (PictureTextAdRootView) adBannerViewHolder.nativeAdContainer;
        AdVideo adVideo = pictureTextExpressAd.getAdVideo();
        if (adVideo != null) {
            addVideoView(adBannerViewHolder, pictureTextExpressAd, adVideo, z);
        }
        setNativeAdListener(pictureTextExpressAd, i);
        pictureTextAdRootView.setAd(pictureTextExpressAd);
        pictureTextAdRootView.registerViewForInteraction(list);
    }

    private void addVideoView(final AdBannerViewHolder adBannerViewHolder, final PictureTextExpressAd pictureTextExpressAd, final AdVideo adVideo, final boolean z) {
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
        adBannerViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.ry.RYMixBannerAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1154x9dcdd01a(videoWidth, videoHeight, adBannerViewHolder, pictureTextExpressAd, adVideo, z);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$addVideoView$2$com-yfanads-ads-chanel-ry-RYMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1154x9dcdd01a(int i, int i2, AdBannerViewHolder adBannerViewHolder, PictureTextExpressAd pictureTextExpressAd, AdVideo adVideo, boolean z) {
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
            setVideoAdListener(adVideo, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setVideoAdListener(final AdVideo adVideo, final boolean z) {
        adVideo.setVideoListener(new OnVideoPlayListener() { // from class: com.yfanads.ads.chanel.ry.RYMixBannerAdapter.5
            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onProgressUpdate(long j, long j2, long j3) {
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPrepare() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoPrepare: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoStart() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoStart: ");
                adVideo.setMuted(z);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPause() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoPause: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoBuffering(boolean z2) {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoBuffering: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoResume() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoResume: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoEnd() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoEnd: ");
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoError(int i, String str) {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoError: " + i + "," + str);
                RYMixBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoMute(boolean z2) {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoMute: " + z2);
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoSizeChange(AdVideoSize adVideoSize) {
                if (adVideoSize != null) {
                    YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoSizeChange: " + adVideoSize.getWidth() + "," + adVideoSize.getHeight());
                }
            }

            @Override // com.hihonor.adsdk.common.video.OnVideoPlayListener
            public void onVideoPrepared() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onVideoPrepared: ");
            }
        });
    }

    private void setNativeAdListener(PictureTextExpressAd pictureTextExpressAd, final int i) {
        pictureTextExpressAd.setAdListener(new AdListener() { // from class: com.yfanads.ads.chanel.ry.RYMixBannerAdapter.6
            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClosed() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onAdClosed: ");
                RYMixBannerAdapter.this.closeAds(i);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdSkip(int i2) {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onAdSkip: ");
                RYMixBannerAdapter.this.closeAds(i);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdClicked() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onAdSkip: ");
                RYMixBannerAdapter.this.handleClick(i, false);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdImpression() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onAdImpression: ");
                RYMixBannerAdapter.this.handleExposure(i);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onAdImpressionFailed(int i2, String str) {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onAdImpressionFailed: " + i2 + "," + str);
                RYMixBannerAdapter.this.handleFailed(i2, str);
            }

            @Override // com.hihonor.adsdk.base.callback.AdListener
            public void onMiniAppStarted() {
                YFLog.debug(RYMixBannerAdapter.this.tag + "onMiniAppStarted: ");
            }
        });
    }

    private void bindImageViews(AdBannerViewHolder adBannerViewHolder, PictureTextExpressAd pictureTextExpressAd, List<View> list, int i) {
        setNativeAdListener(pictureTextExpressAd, i);
        PictureTextAdRootView pictureTextAdRootView = (PictureTextAdRootView) adBannerViewHolder.nativeAdContainer;
        pictureTextAdRootView.setAd(pictureTextExpressAd);
        pictureTextAdRootView.registerViewForInteraction(list);
    }
}
