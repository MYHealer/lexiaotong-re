package com.yfanads.ads.chanel.oppo;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.heytap.msp.mobad.api.ad.BannerAd;
import com.heytap.msp.mobad.api.ad.NativeAdvanceAd;
import com.heytap.msp.mobad.api.listener.IBannerAdListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.yfanads.ads.chanel.oppo.utls.OppoUtil;
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
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class OppoBannerAdapter extends BannerCustomAdapter implements IBannerAdListener, INativeAdvanceLoadListener {
    private BannerAd mBannerAd;
    private INativeAdvanceData mINativeAdData;
    private NativeAdvanceAd mNativeAdvanceAd;
    private ViewGroup viewGroup;

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdFailed(String str) {
    }

    public OppoBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        OppoUtil.initOppo(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.oppo.OppoBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                OppoBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                OppoBannerAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (!isNative()) {
            return super.isReady();
        }
        INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
        return iNativeAdvanceData != null && iNativeAdvanceData.isAdValid();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        if (isNative()) {
            showNativeADs(activity, viewGroup);
        } else {
            this.viewGroup = viewGroup;
            showTemplateADs(viewGroup);
        }
    }

    private void showTemplateADs(ViewGroup viewGroup) {
        if (this.mBannerAd == null) {
            return;
        }
        if (isBidding()) {
            BannerAd bannerAd = this.mBannerAd;
            bannerAd.setBidECPM(bannerAd.getECPM());
        }
        View adView = this.mBannerAd.getAdView();
        if (adView == null || viewGroup == null) {
            return;
        }
        viewGroup.addView(adView);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        BannerAd bannerAd = this.mBannerAd;
        String shortString = "";
        if (bannerAd != null) {
            bannerAd.notifyRankWin(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0);
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
        if (iNativeAdvanceData != null) {
            iNativeAdvanceData.notifyRankWin(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        BannerAd bannerAd = this.mBannerAd;
        if (bannerAd != null && sdkSupplier != null) {
            bannerAd.notifyRankLoss(1, "other", (int) sdkSupplier.ecpm);
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
        if (iNativeAdvanceData == null || sdkSupplier == null) {
            return;
        }
        iNativeAdvanceData.notifyRankLoss(1, "other", (int) sdkSupplier.ecpm);
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return OppoUtil.getAdInfo(this.mINativeAdData, getRequestId());
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.mINativeAdData == null || viewGroup == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
            return;
        }
        if (isBidding()) {
            INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
            iNativeAdvanceData.setBidECPM(iNativeAdvanceData.getECPM());
        }
        YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId());
        addView(activity, viewGroup, new NativeAdvanceContainer(getContext()));
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        try {
            BannerAd bannerAd = this.mBannerAd;
            if (bannerAd != null) {
                bannerAd.destroyAd();
                this.mBannerAd = null;
            }
            NativeAdvanceAd nativeAdvanceAd = this.mNativeAdvanceAd;
            if (nativeAdvanceAd != null) {
                nativeAdvanceAd.destroyAd();
                this.mNativeAdvanceAd = null;
            }
            INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
            if (iNativeAdvanceData != null) {
                iNativeAdvanceData.release();
                this.mINativeAdData = null;
            }
            ViewGroup viewGroup = this.viewGroup;
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
        NativeAdvanceAd nativeAdvanceAd = new NativeAdvanceAd(context, this.sdkSupplier.getPotId(), this);
        this.mNativeAdvanceAd = nativeAdvanceAd;
        nativeAdvanceAd.loadAd();
    }

    private void loadInterstitialAd(Context context) {
        if (context instanceof Activity) {
            BannerAd bannerAd = new BannerAd((Activity) context, this.sdkSupplier.getPotId());
            this.mBannerAd = bannerAd;
            bannerAd.setAdListener(this);
            this.mBannerAd.loadAd();
            return;
        }
        YFLog.error("loadBanner context is not activity " + context);
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_OPPO_CONTEXT));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.OPPO.getValue();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, ViewGroup viewGroup, final AdBannerViewHolder adBannerViewHolder) {
        String clickBnText;
        if (this.mINativeAdData == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        adBannerViewHolder.adLogoIcon.setVisibility(0);
        bannerTemplateData.updAdLog(R.mipmap.ad_log_oppo_v3);
        boolean z = this.mINativeAdData.getCreativeType() == 13 || this.mINativeAdData.getCreativeType() == 16;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(this.mINativeAdData.getTitle(), this.mINativeAdData.getDesc(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (this.mINativeAdData.getIconFiles() != null) {
                ViewUtils.loadBlurImage(this.mINativeAdData.getIconFiles().get(0).getUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else if (this.mINativeAdData.getImgFiles() != null) {
            String url = this.mINativeAdData.getImgFiles().get(0).getUrl();
            this.feedBean.imageUrl = url;
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            ViewUtils.loadBlurImage(url, adBannerViewHolder.imageBlur, 20);
            ViewUtils.loadImage(url, adBannerViewHolder.showImg);
        }
        String desc = TextUtils.isEmpty(this.mINativeAdData.getTitle()) ? this.mINativeAdData.getDesc() : this.mINativeAdData.getTitle();
        String title = TextUtils.isEmpty(this.mINativeAdData.getDesc()) ? this.mINativeAdData.getTitle() : this.mINativeAdData.getDesc();
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
        if (bannerTemplateData.isShowAdIcon() && !YFListUtils.isEmpty(this.mINativeAdData.getIconFiles())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(this.mINativeAdData.getIconFiles().get(0).getUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
            } else {
                adBannerViewHolder.mDownload.setVisibility(0);
                TextView textView3 = adBannerViewHolder.mDownload;
                if (TextUtils.isEmpty(this.mINativeAdData.getClickBnText())) {
                    clickBnText = getContext().getString(R.string.yf_default_download_text);
                } else {
                    clickBnText = this.mINativeAdData.getClickBnText();
                }
                textView3.setText(clickBnText);
                if (this.feedBean != null) {
                    this.feedBean.actBtnString = this.mINativeAdData.getClickBnText();
                }
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.oppo.OppoBannerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1138lambda$bindData$0$comyfanadsadschaneloppoOppoBannerAdapter(adBannerViewHolder, view);
            }
        });
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.oppo.OppoBannerAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1139lambda$bindData$1$comyfanadsadschaneloppoOppoBannerAdapter(fragmentManager, view);
                }
            });
        }
        registerViewForInteraction(adBannerViewHolder, z, bannerTemplateData);
        complianceContent(adBannerViewHolder);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-oppo-OppoBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1138lambda$bindData$0$comyfanadsadschaneloppoOppoBannerAdapter(AdBannerViewHolder adBannerViewHolder, View view) {
        closeAds(adBannerViewHolder.nativeAdContainer);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-oppo-OppoBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1139lambda$bindData$1$comyfanadsadschaneloppoOppoBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!bannerTemplateData.isShowDownloadDialog()) {
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
        } else {
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
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                arrayList2.add(adBannerViewHolder.mDownloadBar);
            } else {
                arrayList2.add(adBannerViewHolder.mDownload);
            }
        }
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.oppo.OppoBannerAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(adBannerViewHolder, arrayList, arrayList2);
        } else {
            bindImageViews(adBannerViewHolder, arrayList, arrayList2);
        }
    }

    private void bindImageViews(AdBannerViewHolder adBannerViewHolder, List<View> list, List<View> list2) {
        INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
        if (iNativeAdvanceData == null) {
            return;
        }
        iNativeAdvanceData.setInteractListener(new INativeAdvanceInteractListener() { // from class: com.yfanads.ads.chanel.oppo.OppoBannerAdapter.2
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onClick() {
                OppoBannerAdapter.this.handleClick();
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onShow() {
                OppoBannerAdapter.this.handleExposure();
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onError(int i, String str) {
                OppoBannerAdapter.this.handleFailed(i, str);
            }
        });
        this.mINativeAdData.bindToView(getContext(), (NativeAdvanceContainer) adBannerViewHolder.nativeAdContainer, list, list2);
    }

    private void bindMediaView(AdBannerViewHolder adBannerViewHolder, List<View> list, List<View> list2) {
        INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
        if (iNativeAdvanceData == null) {
            return;
        }
        iNativeAdvanceData.setInteractListener(new INativeAdvanceInteractListener() { // from class: com.yfanads.ads.chanel.oppo.OppoBannerAdapter.3
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onClick() {
                OppoBannerAdapter.this.handleClick();
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onShow() {
                OppoBannerAdapter.this.handleExposure();
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onError(int i, String str) {
                OppoBannerAdapter.this.handleFailed(i, str);
            }
        });
        this.mINativeAdData.bindToView(getContext(), (NativeAdvanceContainer) adBannerViewHolder.nativeAdContainer, list, list2);
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            adBannerViewHolder.mediaViewFrame.removeAllViews();
            adBannerViewHolder.mediaViewFrame.addView(mediaView);
        }
        this.mINativeAdData.bindMediaView(getContext(), mediaView, new INativeAdvanceMediaListener() { // from class: com.yfanads.ads.chanel.oppo.OppoBannerAdapter.4
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayStart() {
                YFLog.debug(OppoBannerAdapter.this.tag + "onVideoPlayStart: ");
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayComplete() {
                YFLog.debug(OppoBannerAdapter.this.tag + "onVideoPlayComplete: ");
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayError(int i, String str) {
                YFLog.debug(OppoBannerAdapter.this.tag + "onVideoError: ");
                OppoBannerAdapter.this.handleFailed(i, str);
            }
        });
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder) {
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    @Override // com.heytap.msp.mobad.api.listener.IBannerAdListener
    public void onAdReady() {
        BannerAd bannerAd = this.mBannerAd;
        if (bannerAd != null) {
            setEcpm(bannerAd.getECPM());
        }
        handleSucceed();
    }

    @Override // com.heytap.msp.mobad.api.listener.IBannerAdListener
    public void onAdClose() {
        closeAds(this.viewGroup);
    }

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdShow() {
        YFLog.high(this.tag + "newVersionAd onAdShow");
        handleExposure();
    }

    @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
    public void onAdSuccess(List<INativeAdvanceData> list) {
        if (list != null && list.size() > 0) {
            INativeAdvanceData iNativeAdvanceData = list.get(0);
            this.mINativeAdData = iNativeAdvanceData;
            setEcpm(iNativeAdvanceData.getECPM());
            handleSucceed();
            return;
        }
        handleFailed(YFAdError.ERROR_DATA_NULL, "");
    }

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdFailed(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdClick() {
        YFLog.high(this.tag + "newVersionAd onAdVideoBarClick");
        handleClick();
    }
}
