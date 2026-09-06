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
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XNativeView;
import com.byazt.dyf.tt;
import com.yfanads.ads.chanel.bd.utils.BDUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.model.template.InterV3TemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDInterstitialAdapter extends InterstitialCustomAdapter implements ExpressInterstitialListener {
    private View actionView;
    private ExpressInterstitialAd mInterAd;
    private NativeResponse nativeAds;

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public boolean isSupportAutoClick() {
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onLpClosed() {
    }

    public BDInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        BDUtil.initBDAccount(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                BDInterstitialAdapter bDInterstitialAdapter = BDInterstitialAdapter.this;
                bDInterstitialAdapter.startLoadAD(bDInterstitialAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(BDInterstitialAdapter.this.tag + " fail msg:" + str + "_" + str2);
                BDInterstitialAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
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
            loadInterstitialAd(context);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isNative()) {
            NativeResponse nativeResponse = this.nativeAds;
            return nativeResponse != null ? BDUtil.getReqId(nativeResponse.getAdDataForKey("request_id")) : "";
        }
        ExpressInterstitialAd expressInterstitialAd = this.mInterAd;
        return expressInterstitialAd != null ? BDUtil.getReqId(expressInterstitialAd.getAdDataForKey("request_id")) : "";
    }

    private void loadInterstitialAd(Context context) {
        this.mInterAd = new ExpressInterstitialAd(context, this.sdkSupplier.getPotId());
        InitBean initBean = getInitBean();
        if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
            YFLog.high(this.tag + " setAppSid:" + initBean.appId);
            this.mInterAd.setAppSid(initBean.appId);
        }
        this.mInterAd.setLoadListener(this);
        this.mInterAd.load();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.high(this.tag + " doShowAD--");
        super.doShowAD(activity);
        if (isNative()) {
            showNativeADs(activity);
            return;
        }
        ExpressInterstitialAd expressInterstitialAd = this.mInterAd;
        if (expressInterstitialAd == null) {
            handleShowFailed();
        } else {
            expressInterstitialAd.show();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (isNative()) {
            NativeResponse nativeResponse = this.nativeAds;
            return nativeResponse != null && nativeResponse.isAdAvailable(getContext());
        }
        ExpressInterstitialAd expressInterstitialAd = this.mInterAd;
        return expressInterstitialAd != null && expressInterstitialAd.isReady();
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$0$com-yfanads-ads-chanel-bd-BDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1056x59107c2e(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        ExpressInterstitialAd expressInterstitialAd = this.mInterAd;
        String shortString = "";
        if (expressInterstitialAd != null) {
            expressInterstitialAd.biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter$$ExternalSyntheticLambda0
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z, String str, HashMap map) {
                    this.f$0.m1056x59107c2e(z, str, map);
                }
            });
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        NativeResponse nativeResponse = this.nativeAds;
        if (nativeResponse != null) {
            nativeResponse.biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter$$ExternalSyntheticLambda1
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z, String str, HashMap map) {
                    this.f$0.m1057x589a162f(z, str, map);
                }
            });
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$1$com-yfanads-ads-chanel-bd-BDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1057x589a162f(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$2$com-yfanads-ads-chanel-bd-BDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1054x3bc7ed64(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        ExpressInterstitialAd expressInterstitialAd = this.mInterAd;
        if (expressInterstitialAd != null && sdkSupplier != null) {
            expressInterstitialAd.biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter$$ExternalSyntheticLambda4
                @Override // com.baidu.mobads.sdk.api.BiddingListener
                public final void onBiddingResult(boolean z, String str, HashMap map) {
                    this.f$0.m1054x3bc7ed64(z, str, map);
                }
            });
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        NativeResponse nativeResponse = this.nativeAds;
        if (nativeResponse == null || sdkSupplier == null) {
            return;
        }
        nativeResponse.biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter$$ExternalSyntheticLambda5
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z, String str, HashMap map) {
                this.f$0.m1055x3b518765(z, str, map);
            }
        });
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$3$com-yfanads-ads-chanel-bd-BDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1055x3b518765(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return BDUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            ExpressInterstitialAd expressInterstitialAd = this.mInterAd;
            if (expressInterstitialAd != null) {
                expressInterstitialAd.destroy();
            }
            if (this.nativeAds != null) {
                this.nativeAds = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + str + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void closeAds(boolean z) {
        release("closeAds");
        super.closeAds(z);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.BAIDU.getValue();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onADLoaded() {
        YFLog.high(this.tag + "onAdReady");
        ExpressInterstitialAd expressInterstitialAd = this.mInterAd;
        if (expressInterstitialAd != null) {
            setEcpmByStr(expressInterstitialAd.getECPMLevel());
        }
        handleSucceed();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdClick() {
        YFLog.high(this.tag + IAdInterListener.AdCommandType.AD_CLICK);
        handleClick();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdClose() {
        YFLog.high(this.tag + "onAdDismissed");
        closeAds();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdFailed(int i, String str) {
        YFLog.warn(this.tag + "onAdFailed reason：" + str);
        handleFailed(i, str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onNoAd(int i, String str) {
        YFLog.warn(this.tag + "onNoAd reason：" + str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onADExposed() {
        YFLog.high(this.tag + "onAdPresent");
        handleExposure();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onADExposureFailed() {
        YFLog.high(this.tag + "onADExposureFailed");
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdCacheSuccess() {
        YFLog.high(this.tag + "onAdCacheSuccess");
    }

    @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
    public void onAdCacheFailed() {
        YFLog.high(this.tag + "onAdCacheFailed");
    }

    private void loadInterstitialAdByNative(Context context) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.sdkSupplier.getPotId());
        RequestParameters requestParametersBuild = new RequestParameters.Builder().build();
        InitBean initBean = getInitBean();
        if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
            YFLog.high(this.tag + " setAppSid:" + initBean.appId);
            baiduNativeManager.setAppSid(initBean.appId);
        }
        baiduNativeManager.loadFeedAd(requestParametersBuild, new BaiduNativeManager.FeedAdListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter.2
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            /* JADX WARN: Code duplicated, block: B:10:0x004a A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x004a), top: B:16:0x001e }] */
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                YFLog.high(BDInterstitialAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() != 0 && list.get(0) != null) {
                            BDInterstitialAdapter.this.nativeAds = list.get(0);
                            BDInterstitialAdapter bDInterstitialAdapter = BDInterstitialAdapter.this;
                            bDInterstitialAdapter.setEcpmByStr(bDInterstitialAdapter.nativeAds.getECPMLevel());
                            BDInterstitialAdapter.this.handleSucceed();
                        } else {
                            BDInterstitialAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        YFLog.error(BDInterstitialAdapter.this.tag + " onNativeLoad error:" + th.getMessage());
                        BDInterstitialAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    BDInterstitialAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
                YFLog.error(BDInterstitialAdapter.this.tag + " onNativeFail msg:" + str + "_" + i);
                BDInterstitialAdapter.this.handleFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i, String str, NativeResponse nativeResponse) {
                YFLog.error(BDInterstitialAdapter.this.tag + " onNoAd msg:" + str + "_" + i);
                BDInterstitialAdapter.this.handleFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
                YFLog.debug(BDInterstitialAdapter.this.tag + " onVideoDownloadSuccess:");
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
                YFLog.error(BDInterstitialAdapter.this.tag + " onVideoDownloadFailed:");
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

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        int value;
        int value2;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = this.nativeAds.getMaterialType() == NativeResponse.MaterialType.VIDEO;
        boolean z4 = adBaseViewHolder instanceof AdInterV2ViewHolder;
        YFLog.high(this.tag + " bindData isVideo " + z3);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDesc(), z3, interTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        this.feedBean.imageUrl = this.nativeAds.getImageUrl();
        if (z3) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (!TextUtils.isEmpty(this.nativeAds.getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImageUrl(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (!TextUtils.isEmpty(this.nativeAds.getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImageUrl(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
                if (z4 && ViewUtils.isHorizontal(this.nativeAds.getMainPicWidth(), this.nativeAds.getMainPicHeight())) {
                    setHBackground(adBaseViewHolder.showImageArea);
                } else {
                    z = false;
                }
                ViewUtils.loadImage(this.nativeAds.getImageUrl(), adBaseViewHolder.showImg);
                z2 = z;
            }
        }
        interTemplateData.updAdLog(R.mipmap.ad_log_bd_v3);
        String desc = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getDesc() : this.nativeAds.getTitle();
        String title = TextUtils.isEmpty(this.nativeAds.getDesc()) ? this.nativeAds.getTitle() : this.nativeAds.getDesc();
        if (z4) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (z2) {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_SMALL);
            } else {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_BIG);
            }
            ViewUtils.loadCircleImage(this.nativeAds.getIconUrl(), adInterV2ViewHolder.adIcon, 20);
            TextView textView = adInterV2ViewHolder.adIconName;
            if (desc == null) {
                desc = "";
            }
            textView.setText(desc);
        } else {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            ViewUtils.loadCircleImage(this.nativeAds.getIconUrl(), adInterV3ViewHolder.adIcon, 20);
            TextView textView2 = adInterV3ViewHolder.adIconName;
            if (desc == null) {
                desc = "";
            }
            textView2.setText(desc);
        }
        TextView textView3 = adBaseViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView3.setText(title);
        if (!this.isSupportShake && interTemplateData.isOnlyAction()) {
            interTemplateData.setWholeClick();
            if (z4) {
                value2 = BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue();
            } else {
                value2 = BaseTemplateData.InteractiveStyle.CLICK_V3.getValue();
            }
            interTemplateData.resetActivityStyle(value2);
        }
        if (interTemplateData.isActionType(BaseTemplateData.InteractiveStyle.SHAKE.getValue(), BaseTemplateData.InteractiveStyle.CLICK_SHAKE.getValue())) {
            actionAddShakeView(z4, interTemplateData, adBaseViewHolder);
            if (this.actionView == null) {
                YFLog.error("shakeView is null, resetActivityStyle CLICK_V3.");
                if (interTemplateData.isOnlyAction()) {
                    interTemplateData.setWholeClick();
                }
                if (z4) {
                    value = BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue();
                } else {
                    value = BaseTemplateData.InteractiveStyle.CLICK_V3.getValue();
                }
                interTemplateData.resetActivityStyle(value);
            }
        } else if (!z4 && interTemplateData.isActionType(BaseTemplateData.InteractiveStyle.SLIDE.getValue(), BaseTemplateData.InteractiveStyle.CLICK_SLIDE.getValue())) {
            actionAddSlideView(interTemplateData, adBaseViewHolder);
            if (this.actionView == null) {
                YFLog.error("shakeView is null, resetActivityStyle CLICK_V3.");
                if (interTemplateData.isOnlyAction()) {
                    interTemplateData.setWholeClick();
                }
                interTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
            }
        }
        adBaseViewHolder.updateShowView(getContext(), interTemplateData);
        adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1050x55eb68da(view);
            }
        });
        registerViewForInteraction(adBaseViewHolder, interTemplateData, z3, this.nativeAds);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1051x557502db(fragmentManager, view);
                }
            });
        }
        complianceContent(adBaseViewHolder, this.nativeAds);
        startCountDown(adBaseViewHolder, interTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$4$com-yfanads-ads-chanel-bd-BDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1050x55eb68da(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$5$com-yfanads-ads-chanel-bd-BDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1051x557502db(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(AdBaseViewHolder adBaseViewHolder, BaseTemplateData baseTemplateData, boolean z, NativeResponse nativeResponse) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (baseTemplateData.isShowDownloadDialog()) {
                arrayList.add(adInterV2ViewHolder.dyClickView);
            } else {
                arrayList2.add(adInterV2ViewHolder.dyClickView);
            }
            if (baseTemplateData.isActionClickType()) {
                if (isDownloadType(nativeResponse) && !baseTemplateData.isActionShowDialog()) {
                    arrayList2.add(adInterV2ViewHolder.animationClickView);
                } else {
                    arrayList.add(adInterV2ViewHolder.animationClickView);
                }
            }
            adBaseViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
        } else if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (baseTemplateData instanceof InterV3TemplateData) {
                if (((InterV3TemplateData) baseTemplateData).isWholeClick()) {
                    ViewGroup viewGroup = adInterV3ViewHolder.viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    ArrayList arrayList3 = baseTemplateData.isShowDownloadDialog() ? arrayList : arrayList2;
                    try {
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            arrayList3.add(viewGroup.getChildAt(i));
                        }
                        arrayList3.add(viewGroup);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                arrayList.add(adInterV3ViewHolder.adCloseDelay);
                if (baseTemplateData.isActionClickType()) {
                    if (isDownloadType(nativeResponse) && !baseTemplateData.isActionShowDialog()) {
                        arrayList2.add(adInterV3ViewHolder.actionView);
                        arrayList2.add(adInterV3ViewHolder.animationClickView);
                    } else {
                        arrayList.add(adInterV3ViewHolder.actionView);
                        arrayList.add(adInterV3ViewHolder.animationClickView);
                    }
                } else if (baseTemplateData.isOnlyAction()) {
                    if (isDownloadType(nativeResponse) && !baseTemplateData.isActionShowDialog()) {
                        arrayList2.add(adInterV3ViewHolder.animationClickView);
                    } else {
                        arrayList.add(adInterV3ViewHolder.animationClickView);
                    }
                }
            }
        }
        YFLog.high(this.tag + " bindData registerViewForInteraction " + arrayList.size() + " , " + arrayList2.size());
        if (z) {
            bindMediaView(adBaseViewHolder, nativeResponse, arrayList, arrayList2, baseTemplateData.isMute());
        } else {
            bindImageViews(adBaseViewHolder, arrayList, arrayList2);
        }
    }

    private boolean isDownloadType(NativeResponse nativeResponse) {
        return nativeResponse.getAdActionType() == 2;
    }

    private View getShakeView(final boolean z, final InterTemplateData interTemplateData, final AdBaseViewHolder adBaseViewHolder) {
        int iDip2px = ScreenUtil.dip2px(getContext(), 80.0f);
        return this.nativeAds.renderShakeView(iDip2px, iDip2px, new NativeResponse.AdShakeViewListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter$$ExternalSyntheticLambda6
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
            public final void onDismiss() {
                this.f$0.m1052x8646cb6b(interTemplateData, z, adBaseViewHolder);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getShakeView$7$com-yfanads-ads-chanel-bd-BDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1052x8646cb6b(InterTemplateData interTemplateData, boolean z, AdBaseViewHolder adBaseViewHolder) {
        this.actionView.setVisibility(8);
        if (interTemplateData.isClickClose()) {
            return;
        }
        interTemplateData.resetActivityStyle(z ? BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue() : BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        adBaseViewHolder.updateShowView(getContext(), interTemplateData);
    }

    private View getSlideView(final InterTemplateData interTemplateData, final AdBaseViewHolder adBaseViewHolder) {
        return this.nativeAds.renderSlideView(120, 120, 20, new NativeResponse.AdShakeViewListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter$$ExternalSyntheticLambda2
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
            public final void onDismiss() {
                this.f$0.m1053xdda8c5d7(interTemplateData, adBaseViewHolder);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getSlideView$8$com-yfanads-ads-chanel-bd-BDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1053xdda8c5d7(InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        try {
            View view = this.actionView;
            if (view != null) {
                view.setVisibility(8);
                if (this.actionView.getParent() != null) {
                    ((RelativeLayout) this.actionView.getParent()).setVisibility(8);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (interTemplateData.isClickClose()) {
            return;
        }
        interTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        adBaseViewHolder.updateShowView(getContext(), interTemplateData);
    }

    private void actionAddShakeView(boolean z, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        View shakeView = getShakeView(z, interTemplateData, adBaseViewHolder);
        this.actionView = shakeView;
        addToView(shakeView, adBaseViewHolder);
    }

    private void actionAddSlideView(InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        View slideView = getSlideView(interTemplateData, adBaseViewHolder);
        this.actionView = slideView;
        addToSlideView(interTemplateData, slideView, adBaseViewHolder);
    }

    private void addToView(View view, AdBaseViewHolder adBaseViewHolder) {
        if (view == null) {
            return;
        }
        int iDip2px = ScreenUtil.dip2px(getContext(), 80.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDip2px, iDip2px);
        layoutParams.addRule(13, R.id.show_area);
        view.setLayoutParams(layoutParams);
        adBaseViewHolder.viewGroup.addView(view);
    }

    private void addToSlideView(InterTemplateData interTemplateData, View view, AdBaseViewHolder adBaseViewHolder) {
        if (view == null) {
            return;
        }
        int i = (int) (((double) interTemplateData.popWidth) * 0.7d);
        int i2 = (int) (((double) i) * 1.4d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        layoutParams.addRule(14);
        layoutParams.addRule(8, R.id.animator_area);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(view);
        layoutParams.bottomMargin = i2 / 6;
        adBaseViewHolder.viewGroup.addView(relativeLayout);
    }

    private void bindMediaView(AdBaseViewHolder adBaseViewHolder, NativeResponse nativeResponse, List<View> list, List<View> list2, boolean z) {
        nativeResponse.registerViewForInteraction(adBaseViewHolder.viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter.3
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BDInterstitialAdapter.this.handleClick();
                BDInterstitialAdapter.this.closeAdsDelay();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onADExposed: ");
                BDInterstitialAdapter.this.handleExposure();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
                YFLog.error(BDInterstitialAdapter.this.tag + " onADExposureFailed: " + i);
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onADStatusChanged: ");
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onAdUnionClick: ");
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
                YFLog.high(BDInterstitialAdapter.this.tag + " adActRewardSuccess: ");
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i) {
                YFLog.high(BDInterstitialAdapter.this.tag + " adActReward: ");
            }
        });
        final XNativeView xNativeView = getxNativeView(nativeResponse, z);
        nativeResponse.setAdPrivacyListener(new NativeResponse.AdDownloadWindowListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter.4
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
        xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter.5
            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onRenderingStart() {
                YFLog.debug("Renderint start " + xNativeView.getWidth() + ", " + xNativeView.getHeight());
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onPause() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onPause: ");
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onResume() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onResume: ");
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onCompletion() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onCompletion: ");
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onError() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onError: ");
            }
        });
        return xNativeView;
    }

    private void bindImageViews(AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2) {
        this.nativeAds.registerViewForInteraction(adBaseViewHolder.viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.yfanads.ads.chanel.bd.BDInterstitialAdapter.6
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onAdClick ");
                BDInterstitialAdapter.this.handleClick();
                BDInterstitialAdapter.this.closeAdsDelay();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onADExposed ");
                BDInterstitialAdapter.this.handleExposure();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
                YFLog.error(BDInterstitialAdapter.this.tag + " onADExposureFailed: " + i);
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onADStatusChanged ");
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
                YFLog.high(BDInterstitialAdapter.this.tag + " onAdUnionClick ");
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
