package com.yfanads.ads.chanel.bd;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XNativeView;
import com.byazt.dyf.tt;
import com.yfanads.ads.chanel.bd.utils.BDUtil;
import com.yfanads.android.core.toppush.YFTopPushSetting;
import com.yfanads.android.custom.TopPushCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdTopPushViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.TopPushTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDTopPushAdapter extends TopPushCustomAdapter {
    private NativeResponse nativeAds;

    public BDTopPushAdapter(YFTopPushSetting yFTopPushSetting) {
        super(yFTopPushSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        BDUtil.initBDAccount(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                BDTopPushAdapter bDTopPushAdapter = BDTopPushAdapter.this;
                bDTopPushAdapter.startLoadAD(bDTopPushAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(BDTopPushAdapter.this.tag + " fail msg:" + str + "_" + str2);
                BDTopPushAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            loadInterstitialAdByNative(context);
        } else {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        NativeResponse nativeResponse;
        return (!isNative() || (nativeResponse = this.nativeAds) == null) ? "" : BDUtil.getReqId(nativeResponse.getAdDataForKey("request_id"));
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.high(this.tag + " doShowAD--");
        super.doShowAD(activity);
        if (isNative()) {
            showNativeADs(activity);
        } else {
            handleRenderFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        NativeResponse nativeResponse;
        return isNative() && (nativeResponse = this.nativeAds) != null && nativeResponse.isAdAvailable(getContext());
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$0$com-yfanads-ads-chanel-bd-BDTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1076x3a60f9b5(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        NativeResponse nativeResponse = this.nativeAds;
        if (nativeResponse != null) {
            nativeResponse.biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter$$ExternalSyntheticLambda0
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z, String str, HashMap map) {
                    this.f$0.m1076x3a60f9b5(z, str, map);
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

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$1$com-yfanads-ads-chanel-bd-BDTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1075x321cb560(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        NativeResponse nativeResponse = this.nativeAds;
        if (nativeResponse == null || sdkSupplier == null) {
            return;
        }
        nativeResponse.biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter$$ExternalSyntheticLambda1
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z, String str, HashMap map) {
                this.f$0.m1075x321cb560(z, str, map);
            }
        });
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return BDUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
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

    private void loadInterstitialAdByNative(Context context) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.sdkSupplier.getPotId());
        RequestParameters requestParametersBuild = new RequestParameters.Builder().build();
        InitBean initBean = getInitBean();
        if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
            YFLog.high(this.tag + " setAppSid:" + initBean.appId);
            baiduNativeManager.setAppSid(initBean.appId);
        }
        baiduNativeManager.loadFeedAd(requestParametersBuild, new BaiduNativeManager.FeedAdListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter.2
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }

            /* JADX WARN: Code duplicated, block: B:10:0x004a A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x004a), top: B:16:0x001e }] */
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                YFLog.high(BDTopPushAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() != 0 && list.get(0) != null) {
                            BDTopPushAdapter.this.nativeAds = list.get(0);
                            BDTopPushAdapter bDTopPushAdapter = BDTopPushAdapter.this;
                            bDTopPushAdapter.setEcpmByStr(bDTopPushAdapter.nativeAds.getECPMLevel());
                            BDTopPushAdapter.this.handleSucceed();
                        } else {
                            BDTopPushAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        YFLog.error(BDTopPushAdapter.this.tag + " onNativeLoad error:" + th.getMessage());
                        BDTopPushAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    BDTopPushAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
                YFLog.error(BDTopPushAdapter.this.tag + " onNativeFail msg:" + str + "_" + i);
                BDTopPushAdapter.this.handleFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i, String str, NativeResponse nativeResponse) {
                YFLog.error(BDTopPushAdapter.this.tag + " onNoAd msg:" + str + "_" + i);
                BDTopPushAdapter.this.handleFailed(i, str);
            }
        });
    }

    private void showNativeADs(Activity activity) {
        if (this.nativeAds == null) {
            handleShowFailed(this.tag + " nativeAds is null, return.");
        } else {
            YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getMaterialType());
            addView(activity);
        }
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void bindData(Activity activity, TopPushTemplateData topPushTemplateData, AdBaseViewHolder adBaseViewHolder) {
        boolean z = this.nativeAds.getMaterialType() == NativeResponse.MaterialType.VIDEO;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDesc(), z, topPushTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        this.feedBean.imageUrl = this.nativeAds.getImageUrl();
        if (z) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (!TextUtils.isEmpty(this.nativeAds.getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImageUrl(), adBaseViewHolder.imageBlur, 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (!TextUtils.isEmpty(this.nativeAds.getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImageUrl(), adBaseViewHolder.imageBlur, 0);
                ViewUtils.loadImage(this.nativeAds.getImageUrl(), adBaseViewHolder.showImg);
            }
        }
        String desc = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getDesc() : this.nativeAds.getTitle();
        String title = TextUtils.isEmpty(this.nativeAds.getDesc()) ? this.nativeAds.getTitle() : this.nativeAds.getDesc();
        if (topPushTemplateData.isReplaceTitle()) {
            if (!TextUtils.isEmpty(topPushTemplateData.getReplaceTitle())) {
                desc = topPushTemplateData.getReplaceTitle();
            }
            if (!TextUtils.isEmpty(topPushTemplateData.getReplaceDesc())) {
                title = topPushTemplateData.getReplaceDesc();
            }
        }
        AdTopPushViewHolder adTopPushViewHolder = (AdTopPushViewHolder) adBaseViewHolder;
        String iconUrl = this.nativeAds.getIconUrl();
        String imageUrl = this.nativeAds.getImageUrl();
        if (TextUtils.isEmpty(iconUrl) && imageUrl != null && !TextUtils.isEmpty(imageUrl)) {
            iconUrl = imageUrl;
        }
        ViewUtils.loadCircleImage(iconUrl, adTopPushViewHolder.adIcon, 8);
        TextView textView = adTopPushViewHolder.titleDes;
        if (desc == null) {
            desc = "";
        }
        textView.setText(desc);
        TextView textView2 = adTopPushViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView2.setText(title);
        topPushTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        topPushTemplateData.updAdLog(R.mipmap.ad_log_bd_v4);
        adTopPushViewHolder.updateShowView(getContext(), topPushTemplateData);
        adTopPushViewHolder.getCloseView(topPushTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1073lambda$bindData$2$comyfanadsadschanelbdBDTopPushAdapter(view);
            }
        });
        registerViewForInteraction(adTopPushViewHolder, topPushTemplateData, z, this.nativeAds);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adTopPushViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1074lambda$bindData$3$comyfanadsadschanelbdBDTopPushAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adTopPushViewHolder, this.nativeAds);
        startCountDown(adTopPushViewHolder, topPushTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$2$com-yfanads-ads-chanel-bd-BDTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1073lambda$bindData$2$comyfanadsadschanelbdBDTopPushAdapter(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$3$com-yfanads-ads-chanel-bd-BDTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1074lambda$bindData$3$comyfanadsadschanelbdBDTopPushAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(AdTopPushViewHolder adTopPushViewHolder, BaseTemplateData baseTemplateData, boolean z, NativeResponse nativeResponse) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(adTopPushViewHolder.viewGroup);
        if (adTopPushViewHolder.adCloseDelay != null) {
            arrayList.add(adTopPushViewHolder.adCloseDelay);
        }
        if (z) {
            bindMediaView(adTopPushViewHolder, nativeResponse, arrayList, arrayList2, baseTemplateData.isMute());
        } else {
            bindImageViews(adTopPushViewHolder, arrayList, arrayList2);
        }
    }

    private boolean isDownloadType(NativeResponse nativeResponse) {
        return nativeResponse.getAdActionType() == 2;
    }

    private void bindMediaView(AdBaseViewHolder adBaseViewHolder, NativeResponse nativeResponse, List<View> list, List<View> list2, boolean z) {
        nativeResponse.registerViewForInteraction(adBaseViewHolder.viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter.3
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BDTopPushAdapter.this.handleClick();
                BDTopPushAdapter.this.closeAdsDelay();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                YFLog.high(BDTopPushAdapter.this.tag + " onADExposed: ");
                BDTopPushAdapter.this.handleExposure();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
                YFLog.error(BDTopPushAdapter.this.tag + " onADExposureFailed: " + i);
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
                YFLog.high(BDTopPushAdapter.this.tag + " onADStatusChanged: ");
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
                YFLog.high(BDTopPushAdapter.this.tag + " onAdUnionClick: ");
            }
        });
        final XNativeView xNativeView = getxNativeView(nativeResponse, z);
        nativeResponse.setAdPrivacyListener(new NativeResponse.AdDownloadWindowListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter.4
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADFunctionClick() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADPermissionClose() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADPermissionShow() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADPrivacyClick() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
            public void adDownloadWindowShow() {
                xNativeView.pause();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
            public void adDownloadWindowClose() {
                xNativeView.resume();
            }
        });
        if (xNativeView.getParent() == null) {
            adBaseViewHolder.mediaViewFrame.removeAllViews();
            adBaseViewHolder.mediaViewFrame.addView(xNativeView);
        }
        xNativeView.render();
    }

    private XNativeView getxNativeView(NativeResponse nativeResponse, boolean z) {
        final XNativeView xNativeView = new XNativeView(getContext());
        xNativeView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        xNativeView.setNativeItem(nativeResponse);
        xNativeView.setUseDownloadFrame(true);
        xNativeView.setVideoMute(z);
        xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter.5
            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onRenderingStart() {
                YFLog.debug("Renderint start " + xNativeView.getWidth() + ", " + xNativeView.getHeight());
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onPause() {
                YFLog.high(BDTopPushAdapter.this.tag + " onPause: ");
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onResume() {
                YFLog.high(BDTopPushAdapter.this.tag + " onResume: ");
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onCompletion() {
                YFLog.high(BDTopPushAdapter.this.tag + " onCompletion: ");
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onError() {
                YFLog.high(BDTopPushAdapter.this.tag + " onError: ");
            }
        });
        return xNativeView;
    }

    private void bindImageViews(AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2) {
        this.nativeAds.registerViewForInteraction(adBaseViewHolder.viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.yfanads.ads.chanel.bd.BDTopPushAdapter.6
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

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BDTopPushAdapter.this.handleClick();
                BDTopPushAdapter.this.closeAdsDelay();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                BDTopPushAdapter.this.handleExposure();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
                YFLog.error(BDTopPushAdapter.this.tag + " onADExposureFailed: " + i);
            }
        });
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder, NativeResponse nativeResponse) {
        if (isDownloadAd(nativeResponse)) {
            complianceView(adBaseViewHolder, new DownloadAppInfo(nativeResponse.getBrandName(), nativeResponse.getAppVersion(), nativeResponse.getPublisher(), nativeResponse.getAppFunctionLink(), nativeResponse.getAppPermissionLink(), nativeResponse.getAppPrivacyLink()));
            if (this.feedBean != null) {
                this.feedBean.updateAppInfo(nativeResponse.getBrandName(), nativeResponse.getAppVersion(), nativeResponse.getPublisher());
                return;
            }
            return;
        }
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    private boolean isDownloadAd(NativeResponse nativeResponse) {
        return (!isDownloadType(nativeResponse) || TextUtils.isEmpty(nativeResponse.getAppVersion()) || TextUtils.isEmpty(nativeResponse.getPublisher()) || TextUtils.isEmpty(nativeResponse.getAppPrivacyLink()) || TextUtils.isEmpty(nativeResponse.getAppPermissionLink())) ? false : true;
    }
}
