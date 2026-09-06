package com.yfanads.ads.chanel.ks;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class KSNativeExpressAdapter extends NativeExpressCustomAdapter implements KsLoadManager.FeedAdListener {
    private List<KsFeedAd> nativeAds;
    private List<KsNativeAd> nativeAds2;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 4;
    }

    public KSNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.KS.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        KSUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ks.KSNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                KSNativeExpressAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                KSNativeExpressAdapter.this.handleFailed(str, str2);
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
        KSUtil.checkAppID(context, this.sdkSupplier.getAdnAppId(), this.tag);
        if (isTemplate()) {
            loadTemplate();
        } else if (isNative()) {
            loadBannerAdByNative();
        }
    }

    private void loadTemplate() {
        KsAdSDK.getLoadManager().loadConfigFeedAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).width(ScreenUtil.dip2px(getContext(), this.setting.getViewWidth())).adNum(this.setting.getAdsNumbers()).build(), this);
    }

    private void loadBannerAdByNative() {
        NativeAdExtraData nativeAdExtraData = new NativeAdExtraData();
        if (this.isSupportShake) {
            YFLog.debug(this.tag + "isShakeAction true");
            nativeAdExtraData.setEnableShake(this.sdkSupplier.isShakeAction());
            nativeAdExtraData.setEnableRotate(this.sdkSupplier.isTwistAction());
        } else {
            YFLog.debug(this.tag + "isShakeAction false");
            nativeAdExtraData.setEnableShake(false);
            nativeAdExtraData.setEnableRotate(false);
        }
        nativeAdExtraData.setShowLiveStatus(1);
        nativeAdExtraData.setShowLiveStyle(0);
        KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(KSUtil.getAdId(this.sdkSupplier)).setNativeAdExtraData(nativeAdExtraData).build(), new KsLoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.ks.KSNativeExpressAdapter.2
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(KSNativeExpressAdapter.this.tag + " onError " + i + str);
                KSNativeExpressAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x004b A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x004b), top: B:16:0x001e }] */
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(List<KsNativeAd> list) {
                YFLog.high(KSNativeExpressAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() != 0 && list.get(0) != null) {
                            KSNativeExpressAdapter.this.nativeAds2 = list;
                            KSNativeExpressAdapter kSNativeExpressAdapter = KSNativeExpressAdapter.this;
                            kSNativeExpressAdapter.setEcpm(((KsNativeAd) kSNativeExpressAdapter.nativeAds2.get(0)).getECPM());
                            KSNativeExpressAdapter.this.handleSucceed();
                        } else {
                            KSNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        KSNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    KSNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        try {
            if (isTemplate()) {
                return (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size() || this.nativeAds.get(i) == null) ? "" : KSUtil.getReqId(this.nativeAds.get(i).getMediaExtraInfo());
            }
            return (!isNative() || YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size() || this.nativeAds2.get(i) == null) ? "" : KSUtil.getReqId(this.nativeAds2.get(i).getMediaExtraInfo());
        } catch (Exception e) {
            YFLog.error("getRequestId " + e.getMessage());
        }
        return "";
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        List<KsFeedAd> list = this.nativeAds;
        if (list != null && !list.isEmpty()) {
            this.nativeAds.clear();
        }
        List<KsNativeAd> list2 = this.nativeAds2;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        this.nativeAds2.clear();
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            if (isTemplate()) {
                doShowTemplateAd(activity);
            } else if (isNative()) {
                doShowNativeAd(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<KsNativeAd> list = this.nativeAds2;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private void doShowTemplateAd(Context context) {
        List<KsFeedAd> list = this.nativeAds;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.nativeAds.size(); i++) {
                KsFeedAd ksFeedAd = this.nativeAds.get(i);
                YFExpView yFExpView = new YFExpView(ksFeedAd.getFeedView(context), getAdType(), i);
                arrayList.add(yFExpView);
                ksFeedAd.setAdInteractionListener(new KSExpViewListener(yFExpView, this));
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

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        String shortString = "";
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            for (KsFeedAd ksFeedAd : this.nativeAds) {
                ksFeedAd.setBidEcpm(ksFeedAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (YFListUtils.isEmpty(this.nativeAds2)) {
            return;
        }
        for (KsNativeAd ksNativeAd : this.nativeAds2) {
            ksNativeAd.setBidEcpm(ksNativeAd.getECPM(), sdkSupplier != null ? sdkSupplier.ecpm : 0L);
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds2.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (!YFListUtils.isEmpty(this.nativeAds) && sdkSupplier != null) {
            AdExposureFailedReason adExposureFailedReason = KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier());
            Iterator<KsFeedAd> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().reportAdExposureFailed(2, adExposureFailedReason);
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (YFListUtils.isEmpty(this.nativeAds2) || sdkSupplier == null) {
            return;
        }
        AdExposureFailedReason adExposureFailedReason2 = KSUtil.getAdExposureFailedReason(sdkSupplier, getSDKSupplier());
        Iterator<KsNativeAd> it2 = this.nativeAds2.iterator();
        while (it2.hasNext()) {
            it2.next().reportAdExposureFailed(2, adExposureFailedReason2);
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            return KSUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
        }
        return super.getAdInfo();
    }

    private static class KSExpViewListener extends NativeExpressCustomAdapter.ExpViewListener<KSNativeExpressAdapter> implements KsFeedAd.AdInteractionListener {
        private final ExpView expView;

        public KSExpViewListener(ExpView expView, KSNativeExpressAdapter kSNativeExpressAdapter) {
            super(kSNativeExpressAdapter);
            this.expView = expView;
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
            YFLog.debug("KSNativeExpressAdapter onAdRenderFailed");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
            YFLog.debug("KSNativeExpressAdapter onAdShow");
            if (getAdapter() != null) {
                getAdapter().handleExposure(this.expView);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
            YFLog.debug("KSNativeExpressAdapter onDislikeClicked");
            if (getAdapter() != null) {
                getAdapter().handleClose(this.expView);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
            YFLog.debug("KSNativeExpressAdapter onDownloadTipsDialogShow");
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
            YFLog.debug("KSNativeExpressAdapter onDownloadTipsDialogDismiss");
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        KsImage ksImage;
        String actionDescription;
        KsNativeAd adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        boolean z = isVideo(adNative) || isLive(adNative);
        if (!this.isSupportShake && bannerTemplateData.isAction()) {
            if (bannerTemplateData.isOnlyAction()) {
                bannerTemplateData.setWholeClick();
            }
            bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        YFLog.high(this.tag + " bindData isVideo " + isVideo(adNative) + " , materialType " + adNative.getMaterialType());
        this.feedBean = new FeedBean(adNative.getProductName(), adNative.getAdDescription(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (adNative.getVideoCoverImage() != null) {
                ViewUtils.loadBlurImage(adNative.getVideoCoverImage().getImageUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!YFListUtils.isEmpty(adNative.getImageList()) && (ksImage = adNative.getImageList().get(0)) != null && ksImage.isValid() && !TextUtils.isEmpty(ksImage.getImageUrl())) {
                this.feedBean.imageUrl = ksImage.getImageUrl();
                ViewUtils.loadBlurImage(ksImage.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(ksImage.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_ks_v3);
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        String adDescription = TextUtils.isEmpty(adNative.getProductName()) ? adNative.getAdDescription() : adNative.getProductName();
        String productName = TextUtils.isEmpty(adNative.getAdDescription()) ? adNative.getProductName() : adNative.getAdDescription();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (adDescription == null) {
                adDescription = "";
            }
            textView.setText(adDescription);
        }
        TextView textView2 = adBannerViewHolder.adDes;
        if (productName == null) {
            productName = "";
        }
        textView2.setText(productName);
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
            } else {
                adBannerViewHolder.mDownload.setVisibility(0);
                TextView textView3 = adBannerViewHolder.mDownload;
                if (TextUtils.isEmpty(adNative.getActionDescription())) {
                    actionDescription = getContext().getString(R.string.yf_default_download_text);
                } else {
                    actionDescription = adNative.getActionDescription();
                }
                textView3.setText(actionDescription);
                if (this.feedBean != null) {
                    this.feedBean.actBtnString = adNative.getActionDescription();
                }
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(adNative.getAppIconUrl())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(adNative.getAppIconUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSNativeExpressAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1132x6c89003(i, view);
            }
        });
        registerViewForInteraction(activity, adBannerViewHolder, z, bannerTemplateData, adNative, i);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSNativeExpressAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1133xf8723622(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ks-KSNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1132x6c89003(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ks-KSNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1133xf8723622(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private boolean isVideo(KsNativeAd ksNativeAd) {
        return ksNativeAd.getMaterialType() == 1;
    }

    private boolean isLive(KsNativeAd ksNativeAd) {
        return ksNativeAd.getMaterialType() == 8;
    }

    private KsNativeAd getAdNative(int i) {
        if (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size()) {
            YFLog.error("bindData error " + i);
            return null;
        }
        return this.nativeAds2.get(i);
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, KsNativeAd ksNativeAd) {
        if (isDownloadAd(ksNativeAd)) {
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(ksNativeAd.getAppName(), ksNativeAd.getAppVersion(), ksNativeAd.getCorporationName(), ksNativeAd.getIntroductionInfoUrl(), ksNativeAd.getPermissionInfoUrl(), ksNativeAd.getAppPrivacyUrl()));
            this.feedBean.updateAppInfo(ksNativeAd.getAppName(), ksNativeAd.getAppVersion(), ksNativeAd.getCorporationName());
        } else {
            adBannerViewHolder.complianceContent.setVisibility(8);
        }
    }

    private boolean isDownloadType(KsNativeAd ksNativeAd) {
        return ksNativeAd.getInteractionType() == 1;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public boolean isDownloadType(int i) {
        List<KsNativeAd> list = this.nativeAds2;
        if (list != null && list.get(i) != null) {
            return isDownloadAd(this.nativeAds2.get(i));
        }
        return super.isDownloadType(i);
    }

    private boolean isDownloadAd(KsNativeAd ksNativeAd) {
        return ksNativeAd.getInteractionType() == 1;
    }

    private void registerViewForInteraction(Activity activity, AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData, KsNativeAd ksNativeAd, int i) {
        int i2;
        HashMap map = new HashMap();
        int i3 = 2;
        int i4 = 1;
        if (bannerTemplateData.isShowDownloadDialog()) {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    map.put(adBannerViewHolder.viewGroup, 2);
                } else {
                    i3 = -1;
                }
                map.put(adBannerViewHolder.adCloseDelay, 2);
            } else {
                map.put(adBannerViewHolder.dyClickView, 2);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                map.put(adBannerViewHolder.adDes, 2);
                map.put(adBannerViewHolder.titleDes, 2);
            }
            i2 = i3;
        } else {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    map.put(adBannerViewHolder.viewGroup, 1);
                } else {
                    i4 = -1;
                }
                map.put(adBannerViewHolder.adCloseDelay, 1);
            } else {
                map.put(adBannerViewHolder.dyClickView, 1);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                map.put(adBannerViewHolder.adDes, 1);
                map.put(adBannerViewHolder.titleDes, 1);
            }
            i2 = i4;
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                if (!isDownloadType(ksNativeAd) || bannerTemplateData.isActionShowDialog()) {
                    map.put(adBannerViewHolder.mDownloadBar, 2);
                } else {
                    map.put(adBannerViewHolder.mDownloadBar, 1);
                }
            } else if (!isDownloadType(ksNativeAd) || bannerTemplateData.isActionShowDialog()) {
                map.put(adBannerViewHolder.mDownload, 2);
            } else {
                map.put(adBannerViewHolder.mDownload, 1);
            }
        }
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ks.KSNativeExpressAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(activity, adBannerViewHolder, ksNativeAd, bannerTemplateData, map, i, i2);
        } else {
            bindImageViews(activity, adBannerViewHolder, ksNativeAd, map, i);
        }
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, final KsNativeAd ksNativeAd, final BannerTemplateData bannerTemplateData, Map<View, Integer> map, final int i, int i2) {
        if (activity != null) {
            View videoView = ksNativeAd.getVideoView(getContext(), new KsAdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ bannerTemplateData.isMute()).build());
            if (videoView != null && videoView.getParent() == null) {
                adBaseViewHolder.mediaViewFrame.removeAllViews();
                adBaseViewHolder.mediaViewFrame.addView(videoView);
            }
            if (i2 != -1) {
                map.put(videoView, Integer.valueOf(i2));
            }
            ksNativeAd.registerViewForInteraction(activity, adBaseViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSNativeExpressAdapter.3
                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return false;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogShow() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                    KSNativeExpressAdapter.this.handleClick(i, false);
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    KSNativeExpressAdapter.this.handleExposure(i);
                }
            });
        }
        if (isLive(ksNativeAd)) {
            YFLog.high("it's a live, do not update mediaViewFrame");
        } else {
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.ks.KSNativeExpressAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1134xe2163b75(adBaseViewHolder, ksNativeAd, bannerTemplateData);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$3$com-yfanads-ads-chanel-ks-KSNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1134xe2163b75(AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd, BannerTemplateData bannerTemplateData) {
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int videoWidth = ksNativeAd.getVideoWidth();
        int videoHeight = ksNativeAd.getVideoHeight();
        YFLog.info(this.tag + " w" + width + "|h" + height + "|vw" + videoWidth + "|vh" + videoHeight);
        if (bannerTemplateData.isTemplateV3()) {
            updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, height, videoWidth, videoHeight);
        } else {
            if (videoWidth <= 0 || videoHeight <= 0 || ViewUtils.isHorizontal(videoWidth, videoHeight)) {
                return;
            }
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, (videoWidth * height) / videoHeight, height);
        }
    }

    private void bindImageViews(Activity activity, AdBannerViewHolder adBannerViewHolder, KsNativeAd ksNativeAd, Map<View, Integer> map, final int i) {
        if (activity != null) {
            ksNativeAd.registerViewForInteraction(activity, adBannerViewHolder.viewGroup, map, new KsNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ks.KSNativeExpressAdapter.4
                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return false;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogShow() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                    KSNativeExpressAdapter.this.handleClick(i, false);
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    KSNativeExpressAdapter.this.handleExposure(i);
                }
            });
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
    public void onError(int i, String str) {
        YFLog.high(this.tag + " onError ，" + i + str);
        handleFailed(i, str);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003c A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:4:0x001a, B:6:0x0020, B:9:0x0028, B:10:0x003c), top: B:16:0x001a }] */
    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
    public void onFeedAdLoad(List<KsFeedAd> list) {
        YFLog.high(this.tag + " onFeedAdLoad");
        if (list != null) {
            try {
                if (list.size() == 0 || list.get(0) == null) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } else {
                    this.nativeAds = list;
                    setEcpm(list.get(0).getECPM());
                    handleSucceed();
                }
            } catch (Throwable th) {
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, PPSLabelView.Code + th.getMessage());
            }
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
        }
    }
}
