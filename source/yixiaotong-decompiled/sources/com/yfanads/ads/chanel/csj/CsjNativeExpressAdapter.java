package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
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
import com.cdo.oaps.ad.OapsKey;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
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
import com.yfanads.android.utils.YFUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjNativeExpressAdapter extends NativeExpressCustomAdapter implements TTAdNative.NativeExpressAdListener {
    private String ecpm;
    protected List<TTNativeExpressAd> nativeAds;
    protected List<TTFeedAd> nativeAds2;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 1;
    }

    public CsjNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                CsjNativeExpressAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjNativeExpressAdapter.this.handleFailed(str, str2);
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
        if (isTemplate()) {
            loadTemplate(context);
        } else if (isNative()) {
            loadAdByNative(context);
        } else {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    protected void loadAdByNative(Context context) {
        CsjUtil.getADManger().createAdNative(context).loadFeedAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setSupportDeepLink(true).build(), new TTAdNative.FeedAdListener() { // from class: com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                CsjNativeExpressAdapter.this.handleFailed(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                YFLog.high(CsjNativeExpressAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (!list.isEmpty() && list.get(0) != null) {
                            CsjNativeExpressAdapter.this.nativeAds2 = list;
                            if (CsjNativeExpressAdapter.this.isBidding()) {
                                CsjNativeExpressAdapter.this.updPrice();
                                CsjNativeExpressAdapter csjNativeExpressAdapter = CsjNativeExpressAdapter.this;
                                csjNativeExpressAdapter.setEcpmByStr(csjNativeExpressAdapter.ecpm);
                            }
                            CsjNativeExpressAdapter.this.handleSucceed();
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        CsjNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                        return;
                    }
                }
                CsjNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
            }
        });
    }

    private void loadTemplate(Context context) {
        TTAdNative tTAdNativeCreateAdNative = CsjUtil.getADManger().createAdNative(context);
        int iMin = Math.min(this.setting.getAdsNumbers(), 3);
        int iPx2dip = ScreenUtil.px2dip(context, ScreenUtil.getScreenWidth(context));
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            iPx2dip = this.setting.getViewWidth();
        }
        tTAdNativeCreateAdNative.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setSupportDeepLink(true).setAdCount(iMin).setExpressViewAcceptedSize(iPx2dip, 0.0f).build(), this);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (this.setting == null) {
            return super.isReady();
        }
        int readyIndex = this.setting.getReadyIndex();
        if (isNative()) {
            List<TTFeedAd> list = this.nativeAds2;
            return (list == null || list.get(readyIndex) == null || this.nativeAds2.get(readyIndex).getMediationManager() == null || !this.nativeAds2.get(readyIndex).getMediationManager().isReady()) ? false : true;
        }
        List<TTNativeExpressAd> list2 = this.nativeAds;
        return (list2 == null || list2.get(readyIndex) == null || this.nativeAds.get(readyIndex).getMediationManager() == null || !this.nativeAds.get(readyIndex).getMediationManager().isReady()) ? false : true;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        List<TTNativeExpressAd> list = this.nativeAds;
        if (list != null && !list.isEmpty()) {
            Iterator<TTNativeExpressAd> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.nativeAds.clear();
        }
        List<TTFeedAd> list2 = this.nativeAds2;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Iterator<TTFeedAd> it2 = this.nativeAds2.iterator();
        while (it2.hasNext()) {
            it2.next().destroy();
        }
        this.nativeAds2.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        YFLog.high(this.tag + " onError");
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        try {
            YFLog.high(this.tag + "onNativeExpressAdLoad");
            if (list != null && !list.isEmpty()) {
                this.nativeAds = list;
                if (isBidding()) {
                    updPrice();
                    setEcpmByStr(this.ecpm);
                }
                handleSucceed();
                return;
            }
            handleFailed(YFAdError.ERROR_DATA_NULL, "ads empty");
        } catch (Throwable th) {
            th.printStackTrace();
            handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            if (isTemplate()) {
                doShowTemplateAd(activity);
            } else if (isNative()) {
                doShowNativeAd(activity);
            } else {
                handleShowFailed(this.tag + " it's error model");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isTemplate()) {
            return (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size() || this.nativeAds.get(i) == null) ? "" : CsjUtil.getReqId(this.nativeAds.get(i).getMediaExtraInfo());
        }
        return (!isNative() || YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size() || this.nativeAds2.get(i) == null) ? "" : CsjUtil.getReqId(this.nativeAds2.get(i).getMediaExtraInfo());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<TTFeedAd> list = this.nativeAds2;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private void doShowTemplateAd(Activity activity) {
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.nativeAds.size(); i++) {
                TTNativeExpressAd tTNativeExpressAd = this.nativeAds.get(i);
                if (isBidding()) {
                    tTNativeExpressAd.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
                }
                YFExpView yFExpView = new YFExpView(tTNativeExpressAd.getExpressAdView(), getAdType(), i);
                arrayList.add(yFExpView);
                CsjExpViewListener csjExpViewListener = new CsjExpViewListener(yFExpView, this);
                tTNativeExpressAd.setExpressInteractionListener(csjExpViewListener);
                if (activity != null) {
                    tTNativeExpressAd.setDislikeCallback(activity, csjExpViewListener);
                }
                tTNativeExpressAd.render();
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

    protected static final class CsjExpViewListener extends NativeExpressCustomAdapter.ExpViewListener<CsjNativeExpressAdapter> implements TTNativeExpressAd.ExpressAdInteractionListener, TTAdDislike.DislikeInteractionCallback {
        private final ExpView expView;

        public CsjExpViewListener(YFExpView yFExpView, CsjNativeExpressAdapter csjNativeExpressAdapter) {
            super(csjNativeExpressAdapter);
            this.expView = yFExpView;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
            YFLog.debug("CsjNativeExpressAdapter onShow");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i, String str, boolean z) {
            YFLog.debug("CsjNativeExpressAdapter onSelected " + i + "  " + str + "  " + z);
            if (getAdapter() != null) {
                getAdapter().handleClose(this.expView);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
            YFLog.debug("CsjNativeExpressAdapter onCancel");
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i) {
            YFLog.debug("CsjNativeExpressAdapter onAdClicked");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i) {
            YFLog.debug("CsjNativeExpressAdapter onAdShow");
            if (getAdapter() != null) {
                getAdapter().handleExposure(this.expView);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i) {
            YFLog.error("CsjNativeExpressAdapter onRenderFail code " + i + " ,  msg" + str);
            if (getAdapter() == null || getAdapter().setting == null) {
                return;
            }
            getAdapter().setting.adapterRenderFailed(getAdapter().sdkSupplier);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f, float f2) {
            YFLog.debug("CsjNativeExpressAdapter onRenderSuccess");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        TTImage tTImage;
        String buttonText;
        TTFeedAd adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        if (isBidding()) {
            adNative.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
        }
        boolean z = adNative.getImageMode() == 5 || adNative.getImageMode() == 15;
        if (!this.isSupportShake && bannerTemplateData.isAction()) {
            if (bannerTemplateData.isOnlyAction()) {
                bannerTemplateData.setWholeClick();
            }
            bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(adNative.getTitle(), adNative.getDescription(), z, bannerTemplateData);
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
            if (!YFListUtils.isEmpty(adNative.getImageList()) && (tTImage = adNative.getImageList().get(0)) != null && !TextUtils.isEmpty(tTImage.getImageUrl())) {
                this.feedBean.imageUrl = tTImage.getImageUrl();
                ViewUtils.loadBlurImage(tTImage.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(tTImage.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_csj_v3);
        String description = TextUtils.isEmpty(adNative.getTitle()) ? adNative.getDescription() : adNative.getTitle();
        String title = TextUtils.isEmpty(adNative.getDescription()) ? adNative.getTitle() : adNative.getDescription();
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
        TTImage icon = adNative.getIcon();
        if (bannerTemplateData.isShowAdIcon() && icon != null) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(icon.getImageUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1088xb2e9b69d(i, view);
            }
        });
        registerViewForInteraction(adBannerViewHolder, z, adNative, bannerTemplateData, i);
        if (activity != null) {
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1089xe0c250fc(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-csj-CsjNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1088xb2e9b69d(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-csj-CsjNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1089xe0c250fc(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, TTFeedAd tTFeedAd, BannerTemplateData bannerTemplateData, int i) {
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
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(adBannerViewHolder, tTFeedAd, bannerTemplateData, arrayList, arrayList2, arrayList3, i);
        } else {
            bindImageViews(adBannerViewHolder, bannerTemplateData, tTFeedAd, arrayList, arrayList2, arrayList3, i);
        }
    }

    private boolean isDownloadType(TTFeedAd tTFeedAd) {
        return tTFeedAd.getInteractionType() == 4;
    }

    private void bindMediaView(final AdBaseViewHolder adBaseViewHolder, final TTFeedAd tTFeedAd, final BannerTemplateData bannerTemplateData, List<View> list, List<View> list2, List<View> list3, int i) {
        tTFeedAd.registerViewForInteraction(adBaseViewHolder.viewGroup, (List<View>) null, list, list2, list3, adBaseViewHolder.dislikeBtn, new CAdInteractionListener(this, i));
        final View adView = tTFeedAd.getAdView();
        adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1091xf17a4d8f(adBaseViewHolder, tTFeedAd, bannerTemplateData, adView);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$3$com-yfanads-ads-chanel-csj-CsjNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1091xf17a4d8f(AdBaseViewHolder adBaseViewHolder, TTFeedAd tTFeedAd, BannerTemplateData bannerTemplateData, View view) {
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

    private void bindImageViews(final AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, final TTFeedAd tTFeedAd, List<View> list, List<View> list2, List<View> list3, int i) {
        tTFeedAd.registerViewForInteraction(adBannerViewHolder.viewGroup, (List<View>) null, list, list2, list3, adBannerViewHolder.dislikeBtn, new CAdInteractionListener(this, i));
        if (bannerTemplateData.isTemplateV3()) {
            adBannerViewHolder.showImg.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1090x1247c110(tTFeedAd, adBannerViewHolder);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$bindImageViews$4$com-yfanads-ads-chanel-csj-CsjNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1090x1247c110(TTFeedAd tTFeedAd, AdBannerViewHolder adBannerViewHolder) {
        int adViewWidth = tTFeedAd.getAdViewWidth();
        int adViewHeight = tTFeedAd.getAdViewHeight();
        int width = adBannerViewHolder.showImg.getWidth();
        int height = adBannerViewHolder.showImg.getHeight();
        YFLog.info(this.tag + " w" + width + "|h" + height + "|vw" + adViewWidth + "|vh" + adViewHeight);
        updateMaterialArea(adBannerViewHolder.showImg, width, height, adViewWidth, adViewHeight);
    }

    private static class CAdInteractionListener implements TTNativeAd.AdInteractionListener {
        private final WeakReference<CsjNativeExpressAdapter> adapter;
        private final int index;

        protected CAdInteractionListener(CsjNativeExpressAdapter csjNativeExpressAdapter, int i) {
            this.adapter = new WeakReference<>(csjNativeExpressAdapter);
            this.index = i;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            if (this.adapter.get() != null) {
                this.adapter.get().handleClick(this.index, false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            if (this.adapter.get() != null) {
                this.adapter.get().handleClick(this.index, false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            if (this.adapter.get() != null) {
                this.adapter.get().handleExposure(this.index);
            }
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public boolean isDownloadType(int i) {
        List<TTFeedAd> list = this.nativeAds2;
        if (list != null && list.get(i) != null) {
            return isDownloadAd(this.nativeAds2.get(i));
        }
        return super.isDownloadType(i);
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

    protected TTFeedAd getAdNative(int i) {
        if (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size()) {
            YFLog.error("bindData error " + i);
            return null;
        }
        return this.nativeAds2.get(i);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updPrice() {
        try {
            Object obj = "0";
            if (isNative()) {
                List<TTFeedAd> list = this.nativeAds2;
                if (list != null && list.get(0).getMediaExtraInfo() != null) {
                    Object obj2 = this.nativeAds2.get(0).getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                    if (obj2 != null) {
                        obj = obj2;
                    }
                    this.ecpm = String.valueOf(obj);
                }
            } else if (this.nativeAds.get(0).getMediaExtraInfo() != null) {
                Object obj3 = this.nativeAds.get(0).getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                if (obj3 != null) {
                    obj = obj3;
                }
                this.ecpm = String.valueOf(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        String shortString = "";
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            Iterator<TTNativeExpressAd> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (YFListUtils.isEmpty(this.nativeAds2)) {
            return;
        }
        Iterator<TTFeedAd> it2 = this.nativeAds2.iterator();
        while (it2.hasNext()) {
            it2.next().win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds2.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (isBidding()) {
            if (!YFListUtils.isEmpty(this.nativeAds)) {
                Iterator<TTNativeExpressAd> it = this.nativeAds.iterator();
                while (it.hasNext()) {
                    it.next().loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
                }
                YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
            }
            if (YFListUtils.isEmpty(this.nativeAds2)) {
                return;
            }
            Iterator<TTFeedAd> it2 = this.nativeAds2.iterator();
            while (it2.hasNext()) {
                it2.next().loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            return CsjUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
        }
        return super.getAdInfo();
    }
}
