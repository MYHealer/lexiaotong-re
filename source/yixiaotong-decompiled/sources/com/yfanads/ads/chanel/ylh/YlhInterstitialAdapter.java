package com.yfanads.ads.chanel.ylh;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
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
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhInterstitialAdapter extends InterstitialCustomAdapter implements UnifiedInterstitialADListener, NativeADEventListener {
    private UnifiedInterstitialAD interstitialAd;
    private NativeUnifiedADData nativeAds;

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public boolean isSupportAutoClick() {
        return true;
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
    }

    public YlhInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.YLH.getValue();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.interstitialAd;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.destroy();
                this.interstitialAd = null;
            }
            NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.destroy();
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
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhInterstitialAdapter.this.handleFailed(str, str2);
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

    private void loadInterstitialAd(Context context) {
        if (context instanceof Activity) {
            this.interstitialAd = new UnifiedInterstitialAD((Activity) context, this.sdkSupplier.getPotId(), this);
            this.interstitialAd.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(this.sdkSupplier.isMute()).setAutoPlayPolicy(1).build());
            this.interstitialAd.loadAD();
            return;
        }
        YFLog.error("loadInterstitialAd context is not activity " + context);
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_YLH_CONTEXT));
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        if (isNative()) {
            showNativeADs(activity);
        } else {
            showTemplateADs(activity);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isNative()) {
            NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
            return nativeUnifiedADData != null ? YlhUtil.getReqId(nativeUnifiedADData.getExtraInfo()) : "";
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.interstitialAd;
        return unifiedInterstitialAD != null ? YlhUtil.getReqId(unifiedInterstitialAD.getExtraInfo()) : "";
    }

    private void showTemplateADs(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.interstitialAd;
        if (unifiedInterstitialAD == null) {
            handleShowFailed(this.tag + " interstitialAd is null");
        } else if (activity != null) {
            unifiedInterstitialAD.show(activity);
        } else {
            unifiedInterstitialAD.show();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.interstitialAd;
        String shortString = "";
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.sendWinNotification(YlhUtil.getWindBiddingMap(unifiedInterstitialAD.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.sendWinNotification(YlhUtil.getWindBiddingMap(nativeUnifiedADData.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (this.interstitialAd != null && sdkSupplier != null) {
            this.interstitialAd.sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier())));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (this.nativeAds == null || sdkSupplier == null) {
            return;
        }
        this.nativeAds.sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier())));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return YlhUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADReceive() {
        YFLog.high(this.tag + "onADReceive");
        UnifiedInterstitialAD unifiedInterstitialAD = this.interstitialAd;
        if (unifiedInterstitialAD != null) {
            setEcpm(unifiedInterstitialAD.getECPM());
        }
        handleSucceed();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onVideoCached() {
        YFLog.high(this.tag + "onVideoCached");
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        int errorCode;
        String errorMsg;
        if (adError != null) {
            try {
                errorCode = adError.getErrorCode();
                errorMsg = adError.getErrorMsg();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            errorCode = -1;
            errorMsg = "default onNoAD ";
        }
        YFLog.debug(this.tag + "onNoAD code = " + errorCode + " msg = " + errorMsg);
        handleFailed(YFAdError.parseErr(errorCode, errorMsg));
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADOpened() {
        YFLog.high(this.tag + "onADOpened");
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADExposure() {
        YFLog.high(this.tag + "onADExposure");
        handleExposure();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADLeftApplication() {
        YFLog.high(this.tag + "onADLeftApplication");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (isNative()) {
            NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
            return nativeUnifiedADData != null && nativeUnifiedADData.isValid();
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.interstitialAd;
        return unifiedInterstitialAD != null && unifiedInterstitialAD.isValid();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClosed() {
        YFLog.high(this.tag + "onADClosed");
        handleClose();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
        YFLog.high(this.tag + "onRenderSuccess");
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
        YFLog.error(this.tag + "onRenderFail hashCode " + hashCode());
        handleRenderFailed();
    }

    private void loadInterstitialAdByNative(Context context) {
        new NativeUnifiedAD(context, this.sdkSupplier.getPotId(), new NativeADUnifiedListener() { // from class: com.yfanads.ads.chanel.ylh.YlhInterstitialAdapter.2
            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YFLog.high(YlhInterstitialAdapter.this.tag + "onNoAD code:" + adError.getErrorCode() + " msg:" + adError.getErrorMsg());
                YlhInterstitialAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                YFLog.high(YlhInterstitialAdapter.this.tag + "onNativeAdLoad " + list);
                try {
                    if (YlhInterstitialAdapter.this.nativeAds != null) {
                        YlhInterstitialAdapter.this.nativeAds.destroy();
                    }
                    if (list != null && list.size() != 0 && list.get(0) != null) {
                        YlhInterstitialAdapter.this.nativeAds = list.get(0);
                        YlhInterstitialAdapter ylhInterstitialAdapter = YlhInterstitialAdapter.this;
                        ylhInterstitialAdapter.setEcpm(ylhInterstitialAdapter.nativeAds.getECPM());
                        YFLog.high(YlhInterstitialAdapter.this.tag + "onNativeAdLoad ad isValid:" + YlhInterstitialAdapter.this.nativeAds.isValid());
                        YlhInterstitialAdapter.this.handleSucceed();
                        return;
                    }
                    YlhInterstitialAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Throwable th) {
                    th.printStackTrace();
                    YlhInterstitialAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }
        }).loadData(1);
    }

    private void showNativeADs(Activity activity) {
        if (this.nativeAds == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            YFLog.high(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getAdPatternType() + " isValid:" + this.nativeAds.isValid());
            addView(activity, new NativeAdContainer(getContext()));
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        boolean z = true;
        boolean z2 = false;
        boolean z3 = nativeUnifiedADData.getAdPatternType() == 2;
        boolean z4 = adBaseViewHolder instanceof AdInterV2ViewHolder;
        YFLog.high(this.tag + " bindData isVideo " + z3);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDesc(), z3, interTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z3) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (!TextUtils.isEmpty(this.nativeAds.getImgUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImgUrl(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            YFLog.debug(this.tag + " showNativeADs image size = " + this.nativeAds.getPictureWidth() + " , " + this.nativeAds.getPictureHeight());
            if (!TextUtils.isEmpty(this.nativeAds.getImgUrl())) {
                this.feedBean.imageUrl = this.nativeAds.getImgUrl();
                ViewUtils.loadBlurImage(this.nativeAds.getImgUrl(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
                if (z4 && ViewUtils.isHorizontal(this.nativeAds.getPictureWidth(), this.nativeAds.getPictureHeight())) {
                    setHBackground(adBaseViewHolder.showImageArea);
                } else {
                    z = false;
                }
                ViewUtils.loadImage(this.nativeAds.getImgUrl(), adBaseViewHolder.showImg);
                z2 = z;
            }
        }
        interTemplateData.updAdLog(R.mipmap.ad_log_ylh_v3);
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
        adBaseViewHolder.updateShowView(getContext(), interTemplateData);
        if (z4) {
            if (!interTemplateData.isActionType(BaseTemplateData.InteractiveStyle.CLICK.getValue())) {
                adBaseViewHolder.setInteractionVisible(4);
            }
        } else if (interTemplateData.isActionType(BaseTemplateData.InteractiveStyle.SLIDE.getValue(), BaseTemplateData.InteractiveStyle.CLICK_SLIDE.getValue())) {
            adBaseViewHolder.setInteractionVisible(4);
        }
        adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhInterstitialAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1167x262d6306(view);
            }
        });
        registerViewForInteraction(adBaseViewHolder, interTemplateData, z3, this.nativeAds);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhInterstitialAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1168x69b880c7(fragmentManager, view);
                }
            });
        }
        complianceContent(adBaseViewHolder, z4, this.nativeAds);
        startCountDown(adBaseViewHolder, interTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ylh-YlhInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1167x262d6306(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ylh-YlhInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1168x69b880c7(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder, boolean z, NativeUnifiedADData nativeUnifiedADData) {
        if (isDownloadAd(nativeUnifiedADData)) {
            NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
            if (appMiitInfo == null) {
                adBaseViewHolder.complianceContent.setVisibility(8);
                return;
            }
            if (z) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.rightMargin = ScreenUtil.dip2px(getContext(), 10.0f);
                layoutParams.leftMargin = ScreenUtil.dip2px(getContext(), 10.0f);
                layoutParams.bottomMargin = ScreenUtil.dip2px(getContext(), 10.0f);
                layoutParams.addRule(12);
                adBaseViewHolder.comlianceArea.setLayoutParams(layoutParams);
            }
            complianceView(adBaseViewHolder, new DownloadAppInfo(appMiitInfo.getAppName(), appMiitInfo.getVersionName(), appMiitInfo.getAuthorName(), appMiitInfo.getDescriptionUrl(), appMiitInfo.getPermissionsUrl(), appMiitInfo.getPrivacyAgreement()));
            if (this.feedBean != null) {
                this.feedBean.updateAppInfo(appMiitInfo.getAppName(), appMiitInfo.getVersionName(), appMiitInfo.getAuthorName());
                return;
            }
            return;
        }
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    private void registerViewForInteraction(AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, boolean z, NativeUnifiedADData nativeUnifiedADData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (interTemplateData.isShowDownloadDialog()) {
                arrayList.add(adInterV2ViewHolder.dyClickView);
            } else {
                arrayList2.add(adInterV2ViewHolder.dyClickView);
            }
            if (interTemplateData.isActionClickType()) {
                if (isDownloadAd(nativeUnifiedADData) && !interTemplateData.isActionShowDialog()) {
                    arrayList2.add(adInterV2ViewHolder.animationClickView);
                } else {
                    arrayList.add(adInterV2ViewHolder.animationClickView);
                }
            }
            adBaseViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhInterstitialAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
            layoutParams.gravity = 53;
            if (z) {
                bindMediaView((NativeAdContainer) adInterV2ViewHolder.nativeAdContainer, false, interTemplateData, adInterV2ViewHolder.mediaViewFrame, interTemplateData.isMute(), nativeUnifiedADData, layoutParams, arrayList, arrayList2);
                return;
            } else {
                bindImageViews((NativeAdContainer) adInterV2ViewHolder.nativeAdContainer, nativeUnifiedADData, layoutParams, arrayList, arrayList2);
                return;
            }
        }
        if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (interTemplateData instanceof InterV3TemplateData) {
                InterV3TemplateData interV3TemplateData = (InterV3TemplateData) interTemplateData;
                if (interV3TemplateData.isWholeClick()) {
                    if (interV3TemplateData.isShowDownloadDialog()) {
                        arrayList.add(adInterV3ViewHolder.viewGroup);
                    } else {
                        arrayList2.add(adInterV3ViewHolder.viewGroup);
                    }
                }
                arrayList.add(adInterV3ViewHolder.adCloseDelay);
                if (interV3TemplateData.isActionClickType()) {
                    if (isDownloadAd(nativeUnifiedADData) && !interTemplateData.isActionShowDialog()) {
                        arrayList2.add(adInterV3ViewHolder.actionView);
                        arrayList2.add(adInterV3ViewHolder.animationClickView);
                    } else {
                        arrayList.add(adInterV3ViewHolder.actionView);
                        arrayList.add(adInterV3ViewHolder.animationClickView);
                    }
                }
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(1, 1);
            layoutParams2.gravity = 53;
            if (z) {
                bindMediaView((NativeAdContainer) adInterV3ViewHolder.nativeAdContainer, true, interTemplateData, adInterV3ViewHolder.mediaViewFrame, interTemplateData.isMute(), nativeUnifiedADData, layoutParams2, arrayList, arrayList2);
            } else {
                bindImageViews((NativeAdContainer) adInterV3ViewHolder.nativeAdContainer, nativeUnifiedADData, layoutParams2, arrayList, arrayList2);
            }
        }
    }

    private void bindMediaView(NativeAdContainer nativeAdContainer, boolean z, InterTemplateData interTemplateData, FrameLayout frameLayout, boolean z2, NativeUnifiedADData nativeUnifiedADData, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        nativeUnifiedADData.bindAdToView(getContext(), nativeAdContainer, layoutParams, list, list2);
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            frameLayout.removeAllViews();
            frameLayout.addView(mediaView);
        }
        nativeUnifiedADData.setNativeAdEventListener(this);
        nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayMuted(z2).setAutoPlayPolicy(1).setNeedCoverImage(true).setEnableUserControl((!z || interTemplateData.isWholeClick() || interTemplateData.isActionType(BaseTemplateData.InteractiveStyle.SLIDE.getValue(), BaseTemplateData.InteractiveStyle.CLICK_SLIDE.getValue()) || interTemplateData.isActionType(BaseTemplateData.InteractiveStyle.TWIST.getValue(), BaseTemplateData.InteractiveStyle.CLICK_TWIST.getValue())) ? false : true).build(), new NativeADMediaListener() { // from class: com.yfanads.ads.chanel.ylh.YlhInterstitialAdapter.3
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoReady: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoStart: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoPause: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoResume: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoCompleted: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                if (adError != null) {
                    YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoError: " + adError.getErrorMsg() + "_" + adError.getErrorCode());
                }
                if (YlhInterstitialAdapter.this.isStartShow()) {
                    if (adError != null) {
                        YlhInterstitialAdapter.this.handleRenderFailed(adError.getErrorCode(), adError.getErrorMsg());
                        return;
                    } else {
                        YlhInterstitialAdapter.this.handleRenderFailed();
                        return;
                    }
                }
                if (adError != null) {
                    YlhInterstitialAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    YlhInterstitialAdapter.this.handleFailed(0, "onVideoError");
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoStop: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                YFLog.debug(YlhInterstitialAdapter.this.tag + "onVideoClicked: ");
            }
        });
    }

    private void bindImageViews(NativeAdContainer nativeAdContainer, NativeUnifiedADData nativeUnifiedADData, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        nativeUnifiedADData.bindAdToView(getContext(), nativeAdContainer, layoutParams, list, list2);
        nativeUnifiedADData.setNativeAdEventListener(this);
    }

    private boolean isDownloadAd(NativeUnifiedADData nativeUnifiedADData) {
        return nativeUnifiedADData.isAppAd();
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        YFLog.high(this.tag + "onADExposed");
        handleExposure();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClicked() {
        UnifiedInterstitialAD unifiedInterstitialAD;
        YFLog.high(this.tag + "onADClicked");
        handleClick();
        if (isNative()) {
            closeAdsDelay();
        } else {
            if (this.interModeTemplateData == null || !this.interModeTemplateData.isClickClose() || (unifiedInterstitialAD = this.interstitialAd) == null) {
                return;
            }
            unifiedInterstitialAD.close();
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    /* JADX INFO: renamed from: closeSelf */
    public void m1224x50f81756(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.interstitialAd;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        YFLog.high(this.tag + " onADError error code :" + adError.getErrorCode() + "  error msg: " + adError.getErrorMsg());
        handleFailed(adError.getErrorCode(), adError.getErrorMsg());
    }
}
