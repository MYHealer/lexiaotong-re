package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
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
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.qq.e.ads.cfg.VideoOption;
import com.yfanads.ads.chanel.csj.model.GMNativeAds;
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
public class GroMoreMixBannerAdapter extends MixBannerCustomAdapter implements TTAdNative.FeedAdListener, YFNativeCall {
    private TTNativeExpressAd bannerAd;
    private int bannerHeight;
    protected BannerTemplateData bannerTemplateData;
    private int bannerWidth;
    private String ecpm;
    protected List<TTFeedAd> nativeAds2;

    public GroMoreMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initGroMore(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                if (GroMoreMixBannerAdapter.this.bannerTemplateData == null && GroMoreMixBannerAdapter.this.setting != null && GroMoreMixBannerAdapter.this.sdkSupplier != null) {
                    GroMoreMixBannerAdapter.this.bannerTemplateData = new BannerTemplateData(context, "", GroMoreMixBannerAdapter.this.setting.getViewWidth(), GroMoreMixBannerAdapter.this.setting.getViewHeight());
                    GroMoreMixBannerAdapter.this.bannerTemplateData.setConf(GroMoreMixBannerAdapter.this.sdkSupplier.getTemplateConf());
                }
                GroMoreMixBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                GroMoreMixBannerAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
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
                this.bannerWidth = viewWidth;
                this.bannerHeight = viewHeight;
                YFLog.debug(this.tag + " bannerSize.getWidth():" + bannerSize.getWidth() + " bannerSize.getHeight():" + bannerSize.getHeight());
            }
        } catch (Exception unused) {
        }
        YFLog.debug(this.tag + " width:" + viewWidth + " height:" + viewHeight);
        tTAdNativeCreateAdNative.loadBannerExpressAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setExpressViewAcceptedSize(viewWidth, viewHeight).setSupportDeepLink(true).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setVolume(0.7f).setBidNotify(true).build()).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                GroMoreMixBannerAdapter.this.handleFailed(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                GroMoreMixBannerAdapter.this.nativeExpressAdLoad(list);
            }
        });
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadTemplateAd(Context context) {
        loadNativeAd(context);
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadNativeAd(Context context) {
        TTAdNative tTAdNativeCreateAdNative = CsjUtil.getADManger().createAdNative(context);
        BannerTemplateData bannerTemplateData = this.bannerTemplateData;
        boolean z = bannerTemplateData == null || !bannerTemplateData.isWholeClick();
        int screenWidth = ScreenUtil.getScreenWidth(context);
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            screenWidth = ScreenUtil.dip2px(context, this.setting.getViewWidth());
        }
        MediationAdSlot.Builder extraObject = new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setVolume(0.7f).setBidNotify(true).setExtraObject(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS, new FrameLayout.LayoutParams(0, 0)).setExtraObject(MediationConstant.KEY_GDT_VIDEO_OPTION, new VideoOption.Builder().setAutoPlayMuted(this.sdkSupplier.isMute()).setEnableUserControl(z).setAutoPlayPolicy(1).build());
        if (this.sdkSupplier.isShakeAction() || this.sdkSupplier.isTwistAction()) {
            extraObject.setExtraObject(MediationConstant.GM_EXTRA_KEY_KS_ENABLE_ROTATE, true);
        }
        tTAdNativeCreateAdNative.loadFeedAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setImageAcceptedSize(screenWidth, 0).setMediationAdSlot(extraObject.build()).build(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nativeExpressAdLoad(List<TTNativeExpressAd> list) {
        try {
            YFLog.high(this.tag + "onNativeExpressAdLoad");
            if (list != null && !list.isEmpty()) {
                TTNativeExpressAd tTNativeExpressAd = list.get(0);
                this.bannerAd = tTNativeExpressAd;
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

    /* JADX WARN: Code duplicated, block: B:10:0x0034 A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #0 {all -> 0x003a, blocks: (B:4:0x001c, B:6:0x0022, B:9:0x002a, B:10:0x0034), top: B:16:0x001c }] */
    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        YFLog.high(this.tag + "onNativeAdLoad");
        if (list != null) {
            try {
                if (list.isEmpty() || list.get(0) == null) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } else {
                    updData(list);
                    updPrice();
                    handleSucceed();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
            }
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
        }
    }

    private void updData(List<TTFeedAd> list) {
        if (!isDevelop()) {
            this.nativeAds2 = list;
            return;
        }
        this.developAds.clear();
        for (int i = 0; i < list.size(); i++) {
            this.developAds.add(new GMNativeAds(getContext(), list.get(i), this, i));
        }
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowBannerAd(Activity activity) {
        if (this.bannerAd != null) {
            final ArrayList arrayList = new ArrayList();
            if (isBidding()) {
                this.bannerAd.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
            }
            if (activity != null) {
                this.bannerAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter.3
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        if (!YFListUtils.isEmpty(arrayList)) {
                            GroMoreMixBannerAdapter.this.handleClose((ExpView) arrayList.get(0));
                        } else {
                            GroMoreMixBannerAdapter.this.handleClose();
                        }
                    }
                });
            }
            View expressAdView = this.bannerAd.getExpressAdView();
            ViewGroup.LayoutParams layoutParams = expressAdView.getLayoutParams();
            int i = this.bannerWidth;
            if (i != 0 && this.bannerHeight != 0) {
                if (layoutParams != null) {
                    layoutParams.width = ScreenUtil.dip2px(activity, i);
                    layoutParams.height = ScreenUtil.dip2px(activity, this.bannerHeight);
                } else {
                    layoutParams = new ViewGroup.LayoutParams(ScreenUtil.dip2px(activity, this.bannerWidth), ScreenUtil.dip2px(activity, this.bannerHeight));
                    expressAdView.setLayoutParams(layoutParams);
                }
            }
            YFLog.debug(this.tag + " doShowBannerAd sdkName:" + this.bannerAd.getMediationManager().getBestEcpm().getSdkName() + " banner width-:" + layoutParams.width + " height-:" + layoutParams.height);
            final YFExpView yFExpView = new YFExpView(expressAdView, getAdType(), 0);
            arrayList.add(yFExpView);
            this.bannerAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter.4
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i2) {
                    GroMoreMixBannerAdapter.this.handleClick(yFExpView);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i2) {
                    if (GroMoreMixBannerAdapter.this.isBidding() && GroMoreMixBannerAdapter.this.bannerAd != null && GroMoreMixBannerAdapter.this.bannerAd.getMediationManager() != null) {
                        MediationAdEcpmInfo showEcpm = GroMoreMixBannerAdapter.this.bannerAd.getMediationManager().getShowEcpm();
                        if (showEcpm != null) {
                            GroMoreMixBannerAdapter.this.ecpm = CsjUtil.getMShowEcpm(showEcpm);
                            if (!TextUtils.isEmpty(GroMoreMixBannerAdapter.this.ecpm)) {
                                GroMoreMixBannerAdapter groMoreMixBannerAdapter = GroMoreMixBannerAdapter.this;
                                groMoreMixBannerAdapter.setEcpmByStr(groMoreMixBannerAdapter.ecpm);
                            }
                        }
                        YFLog.high(GroMoreMixBannerAdapter.this.tag + "newVersionAd onAdShow tt onAdShow ep_" + GroMoreMixBannerAdapter.this.ecpm);
                    } else {
                        YFLog.high(GroMoreMixBannerAdapter.this.tag + "newVersionAd onAdShow tt");
                    }
                    GroMoreMixBannerAdapter.this.handleExposure(yFExpView);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i2) {
                    YFLog.error(GroMoreMixBannerAdapter.this.tag + "onRenderFail code " + i2 + " ,  msg" + str);
                    GroMoreMixBannerAdapter.this.setting.adapterRenderFailed(GroMoreMixBannerAdapter.this.sdkSupplier);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f, float f2) {
                    YFLog.debug(GroMoreMixBannerAdapter.this.tag + "onRenderSuccess view " + view);
                }
            });
            if (isBanner()) {
                this.bannerAd.setSlideIntervalTime(this.sdkSupplier.getRefreshInterval());
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

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowTemplateAd(Activity activity) {
        if (YFListUtils.isEmpty(this.nativeAds2)) {
            return;
        }
        int size = getSize();
        if (size > 0) {
            this.viewList.clear();
            for (int i = 0; i < size; i++) {
                this.viewList.add(getView(activity, i, null));
            }
            if (this.setting != null) {
                this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
                return;
            }
            return;
        }
        if (this.setting != null) {
            this.setting.adapterRenderFailed(this.sdkSupplier);
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

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowNativeAd(Activity activity) {
        super.doShowNativeAd(activity);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public ExpView getView(Activity activity, final int i, ViewGroup viewGroup) {
        final TTFeedAd adNative = getAdNative(i);
        MediationNativeManager mediationManager = adNative.getMediationManager();
        YFLog.debug(this.tag + "getView mediationManager.isExpress():" + mediationManager.isExpress());
        if (mediationManager.isExpress()) {
            final FrameLayout frameLayout = new FrameLayout(getContext());
            final YFExpView yFExpView = new YFExpView(frameLayout, getAdType(), i);
            adNative.setExpressRenderListener(new MediationExpressRenderListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter.5
                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onRenderFail(View view, String str, int i2) {
                    YFLog.error(GroMoreMixBannerAdapter.this.tag + " onRenderFail msg: " + str + "_" + i2);
                    GroMoreMixBannerAdapter.this.handleRenderFailed(yFExpView);
                }

                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onAdClick() {
                    GroMoreMixBannerAdapter.this.handleClick(yFExpView);
                }

                @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                public void onAdShow() {
                    GroMoreMixBannerAdapter.this.handleExposure(yFExpView);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
                public void onRenderSuccess(View view, float f, float f2, boolean z) {
                    View adView = adNative.getAdView();
                    YFLog.debug(GroMoreMixBannerAdapter.this.tag + " onRenderSuccess view: " + view + " adView:" + adView);
                    if (adView == null || adView.getParent() != null) {
                        return;
                    }
                    frameLayout.removeAllViews();
                    frameLayout.addView(adView);
                }
            });
            adNative.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter.6
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i2, String str, boolean z) {
                    GroMoreMixBannerAdapter.this.closeAds(i);
                }
            });
            adNative.render();
            return yFExpView;
        }
        return super.getView(activity, i, viewGroup);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        TTImage tTImage;
        String buttonText;
        String imageUrl;
        TTFeedAd adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        if (isBidding()) {
            adNative.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
        }
        int mAdnId = CsjUtil.getMAdnId(adNative);
        if (mAdnId == 4) {
            bannerTemplateData.updAdLog(R.mipmap.ad_log_ks_v3);
        } else if (mAdnId == 3) {
            bannerTemplateData.updAdLog(R.mipmap.ad_log_bd_v3);
        } else if (mAdnId == 2) {
            bannerTemplateData.updAdLog(R.mipmap.ad_log_ylh_v3);
        } else {
            bannerTemplateData.updAdLog(R.mipmap.ad_log_csj_v3);
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
            if (adNative.getVideoCoverImage() != null && !TextUtils.isEmpty(adNative.getVideoCoverImage().getImageUrl())) {
                imageUrl = adNative.getVideoCoverImage().getImageUrl();
            } else {
                imageUrl = !YFListUtils.isEmpty(adNative.getImageList()) ? adNative.getImageList().get(0).getImageUrl() : "";
            }
            if (!TextUtils.isEmpty(imageUrl)) {
                ViewUtils.loadBlurImage(imageUrl, adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!YFListUtils.isEmpty(adNative.getImageList()) && (tTImage = adNative.getImageList().get(0)) != null && !TextUtils.isEmpty(tTImage.getImageUrl())) {
                this.feedBean.imageUrl = tTImage.getImageUrl();
                YFLog.debug(this.tag + "bindData imageUrl " + tTImage.getImageUrl());
                ViewUtils.loadBlurImage(tTImage.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(tTImage.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        String description = TextUtils.isEmpty(adNative.getTitle()) ? adNative.getDescription() : adNative.getTitle();
        String title = TextUtils.isEmpty(adNative.getDescription()) ? adNative.getTitle() : adNative.getDescription();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (description == null) {
                description = "";
            }
            textView.setText(description);
        }
        adBannerViewHolder.adDes.setText(title != null ? title : "");
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
            } else {
                adBannerViewHolder.mDownload.setVisibility(0);
                TextView textView2 = adBannerViewHolder.mDownload;
                if (TextUtils.isEmpty(adNative.getButtonText())) {
                    buttonText = getContext().getString(R.string.yf_default_download_text);
                } else {
                    buttonText = adNative.getButtonText();
                }
                textView2.setText(buttonText);
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
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1101x62a29dcd(i, view);
            }
        });
        registerViewForInteraction(adBannerViewHolder, z, adNative, bannerTemplateData, i);
        if (activity != null) {
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1102x907b382c(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-csj-GroMoreMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1101x62a29dcd(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-csj-GroMoreMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1102x907b382c(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, TTFeedAd tTFeedAd, BannerTemplateData bannerTemplateData, int i) {
        int i2 = 0;
        try {
            if (adBannerViewHolder.viewGroup != null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < adBannerViewHolder.viewGroup.getChildCount(); i3++) {
                    arrayList.add(adBannerViewHolder.viewGroup.getChildAt(i3));
                }
                adBannerViewHolder.viewGroup.removeAllViews();
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    relativeLayout.addView((View) arrayList.get(i4));
                }
                frameLayout.addView(relativeLayout);
                adBannerViewHolder.viewGroup.addView(frameLayout);
            }
        } catch (Exception e) {
            e.printStackTrace();
            YFLog.error(this.tag + " registerViewForInteraction " + e.getLocalizedMessage());
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (bannerTemplateData.isShowDownloadDialog()) {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    if (adBannerViewHolder.mDownloadBar != null) {
                        arrayList2.add(adBannerViewHolder.mDownloadBar);
                    }
                    if (adBannerViewHolder.mDownload != null) {
                        arrayList2.add(adBannerViewHolder.mDownload);
                    }
                    arrayList2.add(adBannerViewHolder.viewGroup);
                    if (adBannerViewHolder.viewGroup.getChildCount() > 0 && adBannerViewHolder.viewGroup.getChildAt(0) != null) {
                        View childAt = adBannerViewHolder.viewGroup.getChildAt(0);
                        arrayList2.add(childAt);
                        if (childAt instanceof ViewGroup) {
                            while (true) {
                                ViewGroup viewGroup = (ViewGroup) childAt;
                                if (i2 >= viewGroup.getChildCount()) {
                                    break;
                                }
                                arrayList2.add(viewGroup.getChildAt(i2));
                                i2++;
                            }
                        }
                    }
                    arrayList2.add(adBannerViewHolder.showArea);
                    arrayList2.add(adBannerViewHolder.showArea);
                    if (adBannerViewHolder.adIcon != null) {
                        arrayList2.add(adBannerViewHolder.adIcon);
                    }
                    i2 = 1;
                }
                arrayList2.add(adBannerViewHolder.adCloseDelay);
            } else {
                arrayList2.add(adBannerViewHolder.dyClickView);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                arrayList2.add(adBannerViewHolder.adDes);
                arrayList2.add(adBannerViewHolder.titleDes);
            }
            if (bannerTemplateData.isCtaClick() && !bannerTemplateData.isActionShowDialog()) {
                if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                    if (tTFeedAd.getInteractionType() == 4) {
                        arrayList4.add(adBannerViewHolder.mDownloadBar);
                    } else {
                        arrayList3.add(adBannerViewHolder.mDownloadBar);
                    }
                } else if (tTFeedAd.getInteractionType() == 4) {
                    arrayList4.add(adBannerViewHolder.mDownload);
                } else {
                    arrayList3.add(adBannerViewHolder.mDownload);
                }
            } else if (bannerTemplateData.isCtaClick()) {
                arrayList2.add(adBannerViewHolder.mDownloadBar);
                arrayList2.add(adBannerViewHolder.mDownload);
            }
        } else {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    arrayList4.add(adBannerViewHolder.viewGroup);
                    arrayList4.add(adBannerViewHolder.showArea);
                    if (adBannerViewHolder.adIcon != null) {
                        arrayList4.add(adBannerViewHolder.adIcon);
                    }
                    if (adBannerViewHolder.viewGroup.getChildCount() > 0 && adBannerViewHolder.viewGroup.getChildAt(0) != null) {
                        View childAt2 = adBannerViewHolder.viewGroup.getChildAt(0);
                        arrayList4.add(childAt2);
                        if (childAt2 instanceof ViewGroup) {
                            int i5 = 0;
                            while (true) {
                                ViewGroup viewGroup2 = (ViewGroup) childAt2;
                                if (i5 >= viewGroup2.getChildCount()) {
                                    break;
                                }
                                arrayList4.add(viewGroup2.getChildAt(i5));
                                i5++;
                            }
                        }
                    }
                }
                arrayList4.add(adBannerViewHolder.adCloseDelay);
            } else {
                arrayList4.add(adBannerViewHolder.dyClickView);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                arrayList4.add(adBannerViewHolder.adDes);
                arrayList4.add(adBannerViewHolder.titleDes);
            }
        }
        int i6 = i2;
        if (arrayList2.isEmpty()) {
            arrayList2.add(new View(getContext()));
        }
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(i6, adBannerViewHolder, tTFeedAd, bannerTemplateData, arrayList2, arrayList3, arrayList4, i);
        } else {
            bindImageViews(adBannerViewHolder, bannerTemplateData, tTFeedAd, arrayList2, arrayList3, arrayList4, i);
        }
    }

    private void bindMediaView(int i, final AdBaseViewHolder adBaseViewHolder, final TTFeedAd tTFeedAd, final BannerTemplateData bannerTemplateData, List<View> list, List<View> list2, List<View> list3, int i2) {
        ViewGroup viewGroup = adBaseViewHolder.viewGroup;
        if (adBaseViewHolder.viewGroup.getChildCount() > 0) {
            viewGroup = (ViewGroup) adBaseViewHolder.viewGroup.getChildAt(0);
        }
        ViewGroup viewGroup2 = viewGroup;
        final View adView = tTFeedAd.getAdView();
        if (isGromoreAdn() && CsjUtil.getMAdnId(tTFeedAd) == 2) {
            m1104xa13334bf(adBaseViewHolder, tTFeedAd, bannerTemplateData, adView);
        } else {
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1104xa13334bf(adBaseViewHolder, tTFeedAd, bannerTemplateData, adView);
                }
            });
        }
        if (i == 1) {
            list.add(adView);
        }
        tTFeedAd.registerViewForInteraction(viewGroup2, (List<View>) null, list, list2, list3, adBaseViewHolder.dislikeBtn, new CAdInteractionListener(this, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addMediaView, reason: merged with bridge method [inline-methods] */
    public void m1104xa13334bf(AdBaseViewHolder adBaseViewHolder, TTFeedAd tTFeedAd, BannerTemplateData bannerTemplateData, View view) {
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
        ViewGroup viewGroup = adBannerViewHolder.viewGroup;
        if (adBannerViewHolder.viewGroup.getChildCount() > 0) {
            viewGroup = (ViewGroup) adBannerViewHolder.viewGroup.getChildAt(0);
        }
        tTFeedAd.registerViewForInteraction(viewGroup, (List<View>) null, list, list2, list3, adBannerViewHolder.dislikeBtn, new CAdInteractionListener(this, i));
        if (bannerTemplateData.isTemplateV3()) {
            adBannerViewHolder.showImg.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.GroMoreMixBannerAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1103xc200a840(tTFeedAd, adBannerViewHolder);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$bindImageViews$4$com-yfanads-ads-chanel-csj-GroMoreMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1103xc200a840(TTFeedAd tTFeedAd, AdBannerViewHolder adBannerViewHolder) {
        int adViewWidth = tTFeedAd.getAdViewWidth();
        int adViewHeight = tTFeedAd.getAdViewHeight();
        int width = adBannerViewHolder.showImg.getWidth();
        int height = adBannerViewHolder.showImg.getHeight();
        YFLog.info(this.tag + " w" + width + "|h" + height + "|vw" + adViewWidth + "|vh" + adViewHeight);
        updateMaterialArea(adBannerViewHolder.showImg, width, height, adViewWidth, adViewHeight);
    }

    private boolean isGromoreAdn() {
        return getAdnId() == YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }

    private static class CAdInteractionListener implements TTNativeAd.AdInteractionListener {
        private final WeakReference<GroMoreMixBannerAdapter> adapter;
        private final int index;

        protected CAdInteractionListener(GroMoreMixBannerAdapter groMoreMixBannerAdapter, int i) {
            this.adapter = new WeakReference<>(groMoreMixBannerAdapter);
            this.index = i;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            YFLog.debug(this.adapter.get().tag + " onAdClicked");
            if (this.adapter.get() != null) {
                this.adapter.get().handleClick(this.index, false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            YFLog.debug(this.adapter.get().tag + " onAdCreativeClick");
            if (this.adapter.get() != null) {
                this.adapter.get().handleClick(this.index, false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            GroMoreMixBannerAdapter groMoreMixBannerAdapter = this.adapter.get();
            if (groMoreMixBannerAdapter != null) {
                YFLog.debug(groMoreMixBannerAdapter.tag + " onAdShow");
                if (groMoreMixBannerAdapter.isBidding() && tTNativeAd != null && tTNativeAd.getMediationManager() != null) {
                    MediationAdEcpmInfo showEcpm = tTNativeAd.getMediationManager().getShowEcpm();
                    if (showEcpm != null) {
                        groMoreMixBannerAdapter.ecpm = CsjUtil.getMShowEcpm(showEcpm);
                        if (!TextUtils.isEmpty(groMoreMixBannerAdapter.ecpm)) {
                            groMoreMixBannerAdapter.setEcpmByStr(groMoreMixBannerAdapter.ecpm);
                        }
                    }
                    YFLog.high(groMoreMixBannerAdapter.tag + "native onAdShow ep_" + groMoreMixBannerAdapter.ecpm);
                } else {
                    YFLog.high(groMoreMixBannerAdapter.tag + "native onAdShow tt");
                }
                groMoreMixBannerAdapter.handleExposure(this.index);
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
        return tTFeedAd.getInteractionType() == 4;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    private void updPrice() {
        try {
            List<TTFeedAd> list = this.nativeAds2;
            if (list != null && !list.isEmpty()) {
                String str = ((long) Double.parseDouble(this.nativeAds2.get(0).getMediationManager().getBestEcpm().getEcpm())) + "";
                this.ecpm = str;
                setEcpmByStr(str);
                YFLog.high(this.tag + "onNativeAdLoad ep_");
                return;
            }
            TTNativeExpressAd tTNativeExpressAd = this.bannerAd;
            if (tTNativeExpressAd != null) {
                String str2 = ((long) Double.parseDouble(tTNativeExpressAd.getMediationManager().getBestEcpm().getEcpm())) + "";
                this.ecpm = str2;
                setEcpmByStr(str2);
                YFLog.high(this.tag + "onNativeAdLoad ep_");
                return;
            }
            if (isDevelop()) {
                if (!YFListUtils.isEmpty(this.developAds)) {
                    this.ecpm = this.developAds.get(0).getECPM() + "";
                }
                setEcpmByStr(this.ecpm);
                YFLog.high(this.tag + "onNativeAdLoad develop ep_");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        try {
            if (!YFListUtils.isEmpty(this.nativeAds2)) {
                Iterator<TTFeedAd> it = this.nativeAds2.iterator();
                while (it.hasNext()) {
                    it.next().win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
                }
                String shortString = "";
                StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds2.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
                if (UrlConst.isTestEnv() && sdkSupplier != null) {
                    shortString = sdkSupplier.toShortString();
                }
                YFLog.high(sbAppend.append(shortString).toString());
            }
            TTNativeExpressAd tTNativeExpressAd = this.bannerAd;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            }
            if (YFListUtils.isEmpty(this.developAds)) {
                return;
            }
            for (YFNativeAd yFNativeAd : this.developAds) {
                if (yFNativeAd instanceof GMNativeAds) {
                    ((GMNativeAds) yFNativeAd).win(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (isBidding()) {
            try {
                if (!YFListUtils.isEmpty(this.nativeAds2)) {
                    Iterator<TTFeedAd> it = this.nativeAds2.iterator();
                    while (it.hasNext()) {
                        it.next().loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
                    }
                    YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
                }
                TTNativeExpressAd tTNativeExpressAd = this.bannerAd;
                if (tTNativeExpressAd != null) {
                    tTNativeExpressAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
                }
                if (YFListUtils.isEmpty(this.developAds)) {
                    return;
                }
                for (YFNativeAd yFNativeAd : this.developAds) {
                    if (yFNativeAd instanceof GMNativeAds) {
                        ((GMNativeAds) yFNativeAd).loss(sdkSupplier.ecpm, "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            return CsjUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
        }
        return super.getAdInfo();
    }

    protected TTFeedAd getAdNative(int i) {
        if (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size()) {
            YFLog.error("bindData error " + i);
            return null;
        }
        return this.nativeAds2.get(i);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        handleFailed(i, str);
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
        if (!isBanner()) {
            return super.isReady();
        }
        TTNativeExpressAd tTNativeExpressAd = this.bannerAd;
        return (tTNativeExpressAd == null || tTNativeExpressAd.getMediationManager() == null || !this.bannerAd.getMediationManager().isReady()) ? false : true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        try {
            if (isBanner()) {
                TTNativeExpressAd tTNativeExpressAd = this.bannerAd;
                if (tTNativeExpressAd != null) {
                    return CsjUtil.getMReqId(tTNativeExpressAd.getMediationManager().getBestEcpm());
                }
            } else {
                if (!isDevelop()) {
                    return (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size() || this.nativeAds2.get(i) == null) ? "" : CsjUtil.getMReqId(this.nativeAds2.get(i).getMediationManager().getBestEcpm());
                }
                if (!YFListUtils.isEmpty(this.developAds) && i < this.developAds.size() && (this.developAds.get(i) instanceof GMNativeAds)) {
                    return ((GMNativeAds) this.developAds.get(0)).getAdReqId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        List<TTFeedAd> list = this.nativeAds2;
        if (list != null && !list.isEmpty()) {
            Iterator<TTFeedAd> it = this.nativeAds2.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.nativeAds2.clear();
        }
        TTNativeExpressAd tTNativeExpressAd = this.bannerAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }
}
