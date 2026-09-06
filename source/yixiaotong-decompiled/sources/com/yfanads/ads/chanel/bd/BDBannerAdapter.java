package com.yfanads.ads.chanel.bd;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XNativeView;
import com.byazt.dyf.tt;
import com.yfanads.ads.chanel.bd.utils.BDUtil;
import com.yfanads.android.core.banner.YFBannerSetting;
import com.yfanads.android.custom.BannerCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDBannerAdapter extends BannerCustomAdapter implements NativeResponse.AdInteractionListener, BaiduNativeManager.FeedAdListener {
    private View actionView;
    private NativeResponse nativeAds;

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void adActReward(int i) {
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void adActRewardSuccess() {
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onADStatusChanged() {
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onAdUnionClick() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onLpClosed() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onVideoDownloadFailed() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onVideoDownloadSuccess() {
    }

    public BDBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        BDUtil.initBDAccount(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.bd.BDBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                BDBannerAdapter bDBannerAdapter = BDBannerAdapter.this;
                bDBannerAdapter.startLoadAD(bDBannerAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(BDBannerAdapter.this.tag + " initBDAccount fail 9916");
                BDBannerAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
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
            YFLog.error(this.tag + " it's a template ad");
        }
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        YFLog.high(this.tag + " doShowAD ");
        if (isNative()) {
            showNativeADs(activity, viewGroup);
        } else {
            handleShowFailed(this.tag + " it's a template ad");
        }
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        if (this.nativeAds != null) {
            this.nativeAds = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.BAIDU.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        NativeResponse nativeResponse = this.nativeAds;
        return nativeResponse != null ? BDUtil.getReqId(nativeResponse.getAdDataForKey("request_id")) : "";
    }

    private void loadBannerAdByNative(Context context) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.sdkSupplier.getPotId());
        RequestParameters requestParametersBuild = new RequestParameters.Builder().build();
        InitBean initBean = getInitBean();
        if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
            YFLog.high(this.tag + " setAppSid:" + initBean.appId);
            baiduNativeManager.setAppSid(initBean.appId);
        }
        baiduNativeManager.loadFeedAd(requestParametersBuild, this);
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAds == null || viewGroup == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            YFLog.debug(this.tag + " start show");
            addView(activity, viewGroup);
        }
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$0$com-yfanads-ads-chanel-bd-BDBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1047x6508c06e(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        NativeResponse nativeResponse = this.nativeAds;
        if (nativeResponse != null) {
            nativeResponse.biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDBannerAdapter$$ExternalSyntheticLambda4
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z, String str, HashMap map) {
                    this.f$0.m1047x6508c06e(z, str, map);
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

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$1$com-yfanads-ads-chanel-bd-BDBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1046xd8616363(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        NativeResponse nativeResponse = this.nativeAds;
        if (nativeResponse == null || sdkSupplier == null) {
            return;
        }
        nativeResponse.biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDBannerAdapter$$ExternalSyntheticLambda5
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z, String str, HashMap map) {
                this.f$0.m1046xd8616363(z, str, map);
            }
        });
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return BDUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final ViewGroup viewGroup, AdBannerViewHolder adBannerViewHolder) {
        boolean z = this.nativeAds.getMaterialType() == NativeResponse.MaterialType.VIDEO;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDesc(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        this.feedBean.imageUrl = this.nativeAds.getImageUrl();
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (!TextUtils.isEmpty(this.nativeAds.getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImageUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!TextUtils.isEmpty(this.nativeAds.getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(this.nativeAds.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_bd_v3);
        if (!this.isSupportShake && bannerTemplateData.isOnlyAction()) {
            bannerTemplateData.setWholeClick();
            bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
            actionShakeToView(bannerTemplateData, adBannerViewHolder);
            if (this.actionView == null) {
                YFLog.error("shakeView is null, resetActivityStyle CLICK_V3.");
                if (bannerTemplateData.isOnlyAction()) {
                    bannerTemplateData.setWholeClick();
                }
                bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
            }
        }
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
        updateDownload(bannerTemplateData, adBannerViewHolder);
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(this.nativeAds.getIconUrl())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(this.nativeAds.getIconUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDBannerAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1043lambda$bindData$2$comyfanadsadschanelbdBDBannerAdapter(viewGroup, view);
            }
        });
        registerViewForInteraction(viewGroup, adBannerViewHolder, z, this.nativeAds, bannerTemplateData);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDBannerAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1044lambda$bindData$3$comyfanadsadschanelbdBDBannerAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, this.nativeAds);
    }

    /* JADX INFO: renamed from: lambda$bindData$2$com-yfanads-ads-chanel-bd-BDBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1043lambda$bindData$2$comyfanadsadschanelbdBDBannerAdapter(ViewGroup viewGroup, View view) {
        closeAds(viewGroup);
    }

    /* JADX INFO: renamed from: lambda$bindData$3$com-yfanads-ads-chanel-bd-BDBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1044lambda$bindData$3$comyfanadsadschanelbdBDBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void updateDownload(BannerTemplateData bannerTemplateData, AdBannerViewHolder adBannerViewHolder) {
        String actButtonString;
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
                return;
            }
            adBannerViewHolder.mDownload.setVisibility(0);
            if (adBannerViewHolder.mDownloadBar != null) {
                adBannerViewHolder.mDownloadBar.setVisibility(8);
            }
            TextView textView = adBannerViewHolder.mDownload;
            if (TextUtils.isEmpty(this.nativeAds.getActButtonString())) {
                actButtonString = getContext().getString(R.string.yf_default_download_text);
            } else {
                actButtonString = this.nativeAds.getActButtonString();
            }
            textView.setText(actButtonString);
            if (this.feedBean != null) {
                this.feedBean.actBtnString = this.nativeAds.getActButtonString();
                return;
            }
            return;
        }
        adBannerViewHolder.mDownload.setVisibility(8);
    }

    private View getShakeView(final BannerTemplateData bannerTemplateData, final AdBannerViewHolder adBannerViewHolder) {
        return this.nativeAds.renderShakeView(80, 80, new NativeResponse.AdShakeViewListener() { // from class: com.yfanads.ads.chanel.bd.BDBannerAdapter$$ExternalSyntheticLambda1
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
            public final void onDismiss() {
                this.f$0.m1045lambda$getShakeView$4$comyfanadsadschanelbdBDBannerAdapter(bannerTemplateData, adBannerViewHolder);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getShakeView$4$com-yfanads-ads-chanel-bd-BDBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1045lambda$getShakeView$4$comyfanadsadschanelbdBDBannerAdapter(BannerTemplateData bannerTemplateData, AdBannerViewHolder adBannerViewHolder) {
        this.actionView.setVisibility(8);
        bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        updateDownload(bannerTemplateData, adBannerViewHolder);
    }

    private void actionShakeToView(BannerTemplateData bannerTemplateData, AdBannerViewHolder adBannerViewHolder) {
        View shakeView = getShakeView(bannerTemplateData, adBannerViewHolder);
        this.actionView = shakeView;
        addToView(bannerTemplateData, shakeView, adBannerViewHolder);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        NativeResponse nativeResponse = this.nativeAds;
        return nativeResponse != null && nativeResponse.isAdAvailable(getContext());
    }

    private void addToView(BannerTemplateData bannerTemplateData, View view, AdBaseViewHolder adBaseViewHolder) {
        if (view == null) {
            return;
        }
        int iDip2px = ScreenUtil.dip2px(getContext(), 80.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDip2px, iDip2px);
        if (bannerTemplateData.isTemplateV3_W615() || bannerTemplateData.isTemplateV3_W626()) {
            layoutParams.addRule(15, R.id.show_area);
            layoutParams.addRule(18, R.id.show_area);
            layoutParams.addRule(19, R.id.show_area);
        } else {
            layoutParams.addRule(13);
        }
        view.setLayoutParams(layoutParams);
        adBaseViewHolder.viewGroup.addView(view);
    }

    private void registerViewForInteraction(ViewGroup viewGroup, AdBannerViewHolder adBannerViewHolder, boolean z, NativeResponse nativeResponse, BannerTemplateData bannerTemplateData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDBannerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
        }
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
                if (isDownloadType(nativeResponse) && !bannerTemplateData.isActionShowDialog()) {
                    arrayList2.add(adBannerViewHolder.mDownloadBar);
                    arrayList2.add(adBannerViewHolder.mDownload);
                } else {
                    arrayList.add(adBannerViewHolder.mDownloadBar);
                    arrayList.add(adBannerViewHolder.mDownload);
                }
            } else if (isDownloadType(nativeResponse) && !bannerTemplateData.isActionShowDialog()) {
                arrayList2.add(adBannerViewHolder.mDownload);
            } else {
                arrayList.add(adBannerViewHolder.mDownload);
            }
        }
        if (z) {
            bindMediaView(adBannerViewHolder, nativeResponse, arrayList, arrayList2, bannerTemplateData.isMute());
        } else {
            bindImageViews(viewGroup, nativeResponse, arrayList, arrayList2);
        }
    }

    private boolean isDownloadType(NativeResponse nativeResponse) {
        return nativeResponse.getAdActionType() == 2;
    }

    private void bindMediaView(AdBaseViewHolder adBaseViewHolder, NativeResponse nativeResponse, List<View> list, List<View> list2, boolean z) {
        nativeResponse.registerViewForInteraction(adBaseViewHolder.viewGroup, list, list2, this);
        final XNativeView xNativeView = new XNativeView(getContext());
        xNativeView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        xNativeView.setBackgroundColor(-16776961);
        xNativeView.setNativeItem(nativeResponse);
        xNativeView.setUseDownloadFrame(true);
        xNativeView.setVideoMute(z);
        xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: com.yfanads.ads.chanel.bd.BDBannerAdapter.2
            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onCompletion() {
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onError() {
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onPause() {
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onRenderingStart() {
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onResume() {
                xNativeView.render();
            }
        });
        if (xNativeView.getParent() == null) {
            adBaseViewHolder.mediaViewFrame.removeAllViews();
            adBaseViewHolder.mediaViewFrame.addView(xNativeView);
        }
        xNativeView.render();
    }

    private void bindImageViews(ViewGroup viewGroup, NativeResponse nativeResponse, List<View> list, List<View> list2) {
        nativeResponse.registerViewForInteraction(viewGroup, list, list2, this);
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, NativeResponse nativeResponse) {
        if (isDownloadAd(nativeResponse)) {
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(nativeResponse.getBrandName(), nativeResponse.getAppVersion(), nativeResponse.getPublisher(), nativeResponse.getAppFunctionLink(), nativeResponse.getAppPermissionLink(), nativeResponse.getAppPrivacyLink()));
            if (this.feedBean != null) {
                this.feedBean.updateAppInfo(nativeResponse.getBrandName(), nativeResponse.getAppVersion(), nativeResponse.getPublisher());
                return;
            }
            return;
        }
        adBannerViewHolder.complianceContent.setVisibility(8);
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public boolean isDownloadType() {
        NativeResponse nativeResponse = this.nativeAds;
        if (nativeResponse != null) {
            return isDownloadAd(nativeResponse);
        }
        return super.isDownloadType();
    }

    private boolean isDownloadAd(NativeResponse nativeResponse) {
        return (!isDownloadType(nativeResponse) || TextUtils.isEmpty(nativeResponse.getAppVersion()) || TextUtils.isEmpty(nativeResponse.getPublisher()) || TextUtils.isEmpty(nativeResponse.getAppPrivacyLink()) || TextUtils.isEmpty(nativeResponse.getAppPermissionLink())) ? false : true;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onAdClick() {
        YFLog.high(IAdInterListener.AdCommandType.AD_CLICK);
        handleClick();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onADExposed() {
        YFLog.high("onADExposed");
        handleExposure();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onADExposureFailed(int i) {
        YFLog.high("onADExposureFailed " + i);
        handleRenderFailed();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003d A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:4:0x001c, B:6:0x0022, B:9:0x002a, B:10:0x003d), top: B:16:0x001c }] */
    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNativeLoad(List<NativeResponse> list) {
        YFLog.high(this.tag + "onNativeAdLoad");
        if (list != null) {
            try {
                if (list.size() == 0 || list.get(0) == null) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } else {
                    NativeResponse nativeResponse = list.get(0);
                    this.nativeAds = nativeResponse;
                    setEcpmByStr(nativeResponse.getECPMLevel());
                    handleSucceed();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                YFLog.error(this.tag + " onNativeLoad error:" + th.getMessage());
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
            }
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
        }
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
        YFLog.error(this.tag + " onNativeFail msg:" + str + "_" + i);
        handleFailed(i, str);
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNoAd(int i, String str, NativeResponse nativeResponse) {
        YFLog.error(this.tag + " onNoAd msg:" + str + "_" + i);
        handleFailed(i, str);
    }
}
