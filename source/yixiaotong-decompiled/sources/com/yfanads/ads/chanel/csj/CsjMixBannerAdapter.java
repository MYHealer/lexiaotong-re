package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
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
import com.yfanads.ads.chanel.csj.model.CsjNativeAds;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
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
public class CsjMixBannerAdapter extends MixBannerCustomAdapter implements TTAdNative.NativeExpressAdListener, YFNativeCall {
    protected final List<TTNativeExpressAd> bannerAds;
    private String ecpm;
    protected List<TTFeedAd> nativeAds2;
    private final List<TTNativeExpressAd> nativeExpressAds;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 1;
    }

    public CsjMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
        this.nativeExpressAds = new ArrayList();
        this.bannerAds = new ArrayList();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                CsjMixBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjMixBannerAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadNativeAd(Context context) {
        CsjUtil.getADManger().createAdNative(context).loadFeedAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setSupportDeepLink(true).build(), new TTAdNative.FeedAdListener() { // from class: com.yfanads.ads.chanel.csj.CsjMixBannerAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                CsjMixBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                YFLog.high(CsjMixBannerAdapter.this.tag + "onNativeAdLoad");
                try {
                    if (!YFListUtils.isEmpty(list) && list.get(0) != null) {
                        CsjMixBannerAdapter.this.updData(list);
                        if (CsjMixBannerAdapter.this.isBidding()) {
                            CsjMixBannerAdapter.this.updPrice();
                            CsjMixBannerAdapter csjMixBannerAdapter = CsjMixBannerAdapter.this;
                            csjMixBannerAdapter.setEcpmByStr(csjMixBannerAdapter.ecpm);
                        }
                        CsjMixBannerAdapter.this.handleSucceed();
                        return;
                    }
                    CsjMixBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Exception e) {
                    YFLog.error(CsjMixBannerAdapter.this.tag + " onNativeExpressAdLoad " + e.getMessage());
                    CsjMixBannerAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updData(List<TTFeedAd> list) {
        if (!isDevelop()) {
            this.nativeAds2 = list;
            return;
        }
        this.developAds.clear();
        for (int i = 0; i < list.size(); i++) {
            this.developAds.add(new CsjNativeAds(getContext(), list.get(i), this, i));
        }
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadTemplateAd(Context context) {
        TTAdNative tTAdNativeCreateAdNative = CsjUtil.getADManger().createAdNative(context);
        int iMin = Math.min(this.setting.getAdsNumbers(), 3);
        int iPx2dip = ScreenUtil.px2dip(context, ScreenUtil.getScreenWidth(context));
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            iPx2dip = this.setting.getViewWidth();
        }
        tTAdNativeCreateAdNative.loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setSupportDeepLink(true).setAdCount(iMin).setExpressViewAcceptedSize(iPx2dip, 0.0f).build(), this);
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadBannerAd(Context context) {
        TTAdNative tTAdNativeCreateAdNative = CsjUtil.getADManger().createAdNative(context);
        int viewWidth = this.setting.getViewWidth();
        int viewHeight = this.setting.getViewHeight();
        try {
            BaseTemplateData baseTemplateData = new BaseTemplateData("");
            baseTemplateData.conf = this.sdkSupplier.getTemplateConf();
            Size bannerSize = baseTemplateData.getBannerSize();
            YFLog.debug(this.tag + " setting.getViewWidth():" + this.setting.getViewWidth() + " setting.getViewHeight():" + this.setting.getViewHeight());
            if (bannerSize.getWidth() != 0 && bannerSize.getHeight() != 0) {
                viewWidth = this.setting.getViewWidth();
                viewHeight = (this.setting.getViewWidth() * bannerSize.getHeight()) / bannerSize.getWidth();
                YFLog.debug(this.tag + " bannerSize.getWidth():" + bannerSize.getWidth() + " bannerSize.getHeight():" + bannerSize.getHeight());
            }
        } catch (Exception unused) {
        }
        YFLog.debug(this.tag + " width:" + viewWidth + " height:" + viewHeight);
        tTAdNativeCreateAdNative.loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setExpressViewAcceptedSize(viewWidth, viewHeight).setSupportDeepLink(true).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.yfanads.ads.chanel.csj.CsjMixBannerAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                CsjMixBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                CsjMixBannerAdapter csjMixBannerAdapter = CsjMixBannerAdapter.this;
                csjMixBannerAdapter.onExpressAdLoad(csjMixBannerAdapter.bannerAds, list);
            }
        });
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowTemplateAd(Activity activity) {
        doShowTemplateAd(activity, this.nativeExpressAds);
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowBannerAd(Activity activity) {
        doShowTemplateAd(activity, this.bannerAds);
    }

    protected void doShowTemplateAd(Activity activity, List<TTNativeExpressAd> list) {
        if (!YFListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                TTNativeExpressAd tTNativeExpressAd = list.get(i);
                if (isBidding()) {
                    tTNativeExpressAd.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
                }
                final YFExpView yFExpView = new YFExpView(tTNativeExpressAd.getExpressAdView(), getAdType(), i);
                arrayList.add(yFExpView);
                tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.yfanads.ads.chanel.csj.CsjMixBannerAdapter.4
                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int i2) {
                        YFLog.high("CsjMixBannerAdapter onAdClicked");
                        CsjMixBannerAdapter.this.handleClick(yFExpView);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(View view, int i2) {
                        YFLog.high("CsjMixBannerAdapter onAdShow");
                        CsjMixBannerAdapter.this.handleExposure(yFExpView);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str, int i2) {
                        YFLog.high("CsjMixBannerAdapter onRenderFail");
                        if (CsjMixBannerAdapter.this.setting == null || CsjMixBannerAdapter.this.sdkSupplier == null) {
                            return;
                        }
                        CsjMixBannerAdapter.this.setting.adapterRenderFailed(CsjMixBannerAdapter.this.sdkSupplier);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f, float f2) {
                        YFLog.high("CsjMixBannerAdapter onRenderSuccess");
                    }
                });
                if (activity != null) {
                    tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.yfanads.ads.chanel.csj.CsjMixBannerAdapter.5
                        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                        public void onShow() {
                            YFLog.high("CsjMixBannerAdapter onShow");
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                        public void onSelected(int i2, String str, boolean z) {
                            YFLog.high("CsjMixBannerAdapter onSelected");
                            CsjMixBannerAdapter.this.handleClose(yFExpView);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                        public void onCancel() {
                            YFLog.high("CsjMixBannerAdapter onCancel");
                        }
                    });
                }
                if (isBanner()) {
                    tTNativeExpressAd.setSlideIntervalTime(this.sdkSupplier.getRefreshInterval());
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

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isTemplate()) {
            return (YFListUtils.isEmpty(this.nativeExpressAds) || i >= this.nativeExpressAds.size() || this.nativeExpressAds.get(i) == null) ? "" : CsjUtil.getReqId(this.nativeExpressAds.get(i).getMediaExtraInfo());
        }
        if (isNative()) {
            return (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size() || this.nativeAds2.get(i) == null) ? "" : CsjUtil.getReqId(this.nativeAds2.get(i).getMediaExtraInfo());
        }
        if (isBanner()) {
            return (YFListUtils.isEmpty(this.bannerAds) || i >= this.bannerAds.size() || this.bannerAds.get(i) == null) ? "" : CsjUtil.getReqId(this.bannerAds.get(i).getMediaExtraInfo());
        }
        if (isDevelop() && !YFListUtils.isEmpty(this.developAds) && i < this.developAds.size()) {
            YFNativeAd yFNativeAd = this.developAds.get(i);
            if (yFNativeAd instanceof CsjNativeAds) {
                return ((CsjNativeAds) yFNativeAd).getAdReqId();
            }
        }
        return "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (this.setting == null || isDevelop()) {
            return super.isReady();
        }
        int readyIndex = this.setting.getReadyIndex();
        if (isNative()) {
            List<TTFeedAd> list = this.nativeAds2;
            return (list == null || list.get(readyIndex) == null || this.nativeAds2.get(readyIndex).getMediationManager() == null || !this.nativeAds2.get(readyIndex).getMediationManager().isReady()) ? false : true;
        }
        if (isBanner()) {
            return (this.bannerAds.get(readyIndex) == null || this.bannerAds.get(readyIndex).getMediationManager() == null || !this.bannerAds.get(readyIndex).getMediationManager().isReady()) ? false : true;
        }
        return (this.nativeExpressAds.get(readyIndex) == null || this.nativeExpressAds.get(readyIndex).getMediationManager() == null || !this.nativeExpressAds.get(readyIndex).getMediationManager().isReady()) ? false : true;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        if (!this.nativeExpressAds.isEmpty()) {
            for (TTNativeExpressAd tTNativeExpressAd : this.nativeExpressAds) {
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
                tTNativeExpressAd.destroy();
            }
            this.nativeExpressAds.clear();
        }
        List<TTFeedAd> list = this.nativeAds2;
        if (list != null && !list.isEmpty()) {
            for (TTFeedAd tTFeedAd : this.nativeAds2) {
                tTFeedAd.setAdInteractionListener(null);
                tTFeedAd.destroy();
            }
            this.nativeAds2.clear();
        }
        if (this.bannerAds.isEmpty()) {
            return;
        }
        for (TTNativeExpressAd tTNativeExpressAd2 : this.bannerAds) {
            tTNativeExpressAd2.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
            tTNativeExpressAd2.destroy();
        }
        this.bannerAds.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        YFLog.high(this.tag + " onError");
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        onExpressAdLoad(this.nativeExpressAds, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExpressAdLoad(List<TTNativeExpressAd> list, List<TTNativeExpressAd> list2) {
        try {
            YFLog.high(this.tag + "onExpressAdLoad");
            if (list2 != null && !list2.isEmpty()) {
                list.clear();
                list.addAll(list2);
                if (isBidding()) {
                    updPrice();
                    setEcpmByStr(this.ecpm);
                }
                handleSucceed();
                return;
            }
            handleFailed(YFAdError.ERROR_DATA_NULL, "ads empty");
        } catch (Exception e) {
            YFLog.error("onExpressAdLoad: " + e.getMessage());
            handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<TTFeedAd> list = this.nativeAds2;
        if (list != null) {
            return list.size();
        }
        return 0;
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
            ViewUtils.loadCircleImage(icon.getImageUrl(), adBannerViewHolder.adIcon, 20);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjMixBannerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1086lambda$bindData$0$comyfanadsadschanelcsjCsjMixBannerAdapter(i, view);
            }
        });
        registerViewForInteraction(adBannerViewHolder, z, adNative, bannerTemplateData, i);
        if (activity != null) {
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjMixBannerAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1087lambda$bindData$1$comyfanadsadschanelcsjCsjMixBannerAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-csj-CsjMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1086lambda$bindData$0$comyfanadsadschanelcsjCsjMixBannerAdapter(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-csj-CsjMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1087lambda$bindData$1$comyfanadsadschanelcsjCsjMixBannerAdapter(FragmentManager fragmentManager, View view) {
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
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjMixBannerAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(adBannerViewHolder, tTFeedAd, arrayList, arrayList2, arrayList3, i);
        } else {
            bindImageViews(adBannerViewHolder, tTFeedAd, arrayList, arrayList2, arrayList3, i);
        }
    }

    private boolean isDownloadType(TTFeedAd tTFeedAd) {
        return tTFeedAd.getInteractionType() == 4;
    }

    private void bindMediaView(final AdBaseViewHolder adBaseViewHolder, final TTFeedAd tTFeedAd, List<View> list, List<View> list2, List<View> list3, int i) {
        tTFeedAd.registerViewForInteraction(adBaseViewHolder.viewGroup, (List<View>) null, list, list2, list3, adBaseViewHolder.dislikeBtn, new CAdInteractionListener(this, i));
        final View adView = tTFeedAd.getAdView();
        adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjMixBannerAdapter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CsjMixBannerAdapter.lambda$bindMediaView$3(adBaseViewHolder, tTFeedAd, adView);
            }
        });
    }

    static /* synthetic */ void lambda$bindMediaView$3(AdBaseViewHolder adBaseViewHolder, TTFeedAd tTFeedAd, View view) {
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int adViewWidth = tTFeedAd.getAdViewWidth();
        int adViewHeight = tTFeedAd.getAdViewHeight();
        YFLog.high("height = " + height + " , videoWidth = " + adViewWidth + " , videoHeight = " + adViewHeight);
        if (adViewWidth > 0 && adViewHeight > 0 && !ViewUtils.isHorizontal(adViewWidth, adViewHeight)) {
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, (height * adViewWidth) / adViewHeight, adViewHeight);
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adBaseViewHolder.mediaViewFrame.removeAllViews();
        adBaseViewHolder.mediaViewFrame.addView(view);
    }

    private void bindImageViews(AdBannerViewHolder adBannerViewHolder, TTFeedAd tTFeedAd, List<View> list, List<View> list2, List<View> list3, int i) {
        tTFeedAd.registerViewForInteraction(adBannerViewHolder.viewGroup, (List<View>) null, list, list2, list3, adBannerViewHolder.dislikeBtn, new CAdInteractionListener(this, i));
    }

    private static class CAdInteractionListener implements TTNativeAd.AdInteractionListener {
        private final WeakReference<CsjMixBannerAdapter> adapter;
        private final int index;

        protected CAdInteractionListener(CsjMixBannerAdapter csjMixBannerAdapter, int i) {
            this.adapter = new WeakReference<>(csjMixBannerAdapter);
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
            } else if (isDevelop()) {
                if (this.developAds != null && !YFListUtils.isEmpty(this.developAds)) {
                    this.ecpm = this.developAds.get(0).getECPM() + "";
                }
            } else if (isBanner()) {
                if (this.bannerAds.get(0).getMediaExtraInfo() != null) {
                    Object obj3 = this.bannerAds.get(0).getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                    if (obj3 != null) {
                        obj = obj3;
                    }
                    this.ecpm = String.valueOf(obj);
                }
            } else if (this.nativeExpressAds.get(0).getMediaExtraInfo() != null) {
                Object obj4 = this.nativeExpressAds.get(0).getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                if (obj4 != null) {
                    obj = obj4;
                }
                this.ecpm = String.valueOf(obj);
            }
        } catch (Exception e) {
            YFLog.error("updPrice exception " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        String shortString = "";
        if (!YFListUtils.isEmpty(this.bannerAds)) {
            Iterator<TTNativeExpressAd> it = this.bannerAds.iterator();
            while (it.hasNext()) {
                it.next().win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.bannerAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (!YFListUtils.isEmpty(this.nativeExpressAds)) {
            Iterator<TTNativeExpressAd> it2 = this.nativeExpressAds.iterator();
            while (it2.hasNext()) {
                it2.next().win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeExpressAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            Iterator<TTFeedAd> it3 = this.nativeAds2.iterator();
            while (it3.hasNext()) {
                it3.next().win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof CsjNativeAds) {
                ((CsjNativeAds) yFNativeAd).win(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d));
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.developAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (!YFListUtils.isEmpty(this.bannerAds)) {
            Iterator<TTNativeExpressAd> it = this.bannerAds.iterator();
            while (it.hasNext()) {
                it.next().loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.bannerAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + ", win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (!YFListUtils.isEmpty(this.nativeExpressAds)) {
            Iterator<TTNativeExpressAd> it2 = this.nativeExpressAds.iterator();
            while (it2.hasNext()) {
                it2.next().loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeExpressAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + ", win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            Iterator<TTFeedAd> it3 = this.nativeAds2.iterator();
            while (it3.hasNext()) {
                it3.next().loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + ", win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof CsjNativeAds) {
                ((CsjNativeAds) yFNativeAd).loss(sdkSupplier.ecpm, "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
            }
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.developAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            return CsjUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
        }
        return super.getAdInfo();
    }
}
