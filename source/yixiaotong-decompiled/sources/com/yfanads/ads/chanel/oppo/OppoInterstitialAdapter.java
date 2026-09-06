package com.yfanads.ads.chanel.oppo;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.heytap.msp.mobad.api.ad.InterstitialAd;
import com.heytap.msp.mobad.api.ad.NativeAdvanceAd;
import com.heytap.msp.mobad.api.listener.IInterstitialAdListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.yfanads.ads.chanel.oppo.utls.OppoUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.model.template.InterV3TemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class OppoInterstitialAdapter extends InterstitialCustomAdapter implements IInterstitialAdListener, INativeAdvanceLoadListener {
    private INativeAdvanceData mINativeAdData;
    private InterstitialAd mInterstitialAd;
    private NativeAdvanceAd mNativeAdvanceAd;

    public OppoInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        OppoUtil.initOppo(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.oppo.OppoInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                OppoInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                OppoInterstitialAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        if (isNative()) {
            showNativeADs(activity);
        } else {
            showTemplateADs();
        }
    }

    private void showNativeADs(Activity activity) {
        INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
        if (iNativeAdvanceData == null || !iNativeAdvanceData.isAdValid()) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
            return;
        }
        if (isBidding()) {
            INativeAdvanceData iNativeAdvanceData2 = this.mINativeAdData;
            iNativeAdvanceData2.setBidECPM(iNativeAdvanceData2.getECPM());
        }
        addView(activity, new NativeAdvanceContainer(getContext()));
    }

    private void showTemplateADs() {
        if (this.mInterstitialAd == null) {
            return;
        }
        if (isBidding()) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            interstitialAd.setBidECPM(interstitialAd.getECPM());
        }
        this.mInterstitialAd.showAd();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        String shortString = "";
        if (interstitialAd != null) {
            interstitialAd.notifyRankWin(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0);
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
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null && sdkSupplier != null) {
            interstitialAd.notifyRankLoss(1, "other", (int) sdkSupplier.ecpm);
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

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null) {
                interstitialAd.destroyAd();
                this.mInterstitialAd = null;
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
            InterstitialAd interstitialAd = new InterstitialAd((Activity) context, this.sdkSupplier.getPotId());
            this.mInterstitialAd = interstitialAd;
            interstitialAd.setAdListener(this);
            this.mInterstitialAd.loadAd();
            return;
        }
        YFLog.error("loadInterstitialAd context is not activity " + context);
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_OPPO_CONTEXT));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (!isNative()) {
            return super.isReady();
        }
        INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
        return iNativeAdvanceData != null && iNativeAdvanceData.isAdValid();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.OPPO.getValue();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, final AdBaseViewHolder adBaseViewHolder) {
        INativeAdvanceData iNativeAdvanceData = this.mINativeAdData;
        if (iNativeAdvanceData == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        boolean z = true;
        boolean z2 = iNativeAdvanceData.getCreativeType() == 13 || this.mINativeAdData.getCreativeType() == 16;
        boolean z3 = adBaseViewHolder instanceof AdInterV2ViewHolder;
        YFLog.high(this.tag + " bindData isVideo " + z2);
        this.feedBean = new FeedBean(this.mINativeAdData.getTitle(), this.mINativeAdData.getDesc(), z2, this.interModeTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z2) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (this.mINativeAdData.getIconFiles() != null && this.mINativeAdData.getIconFiles().get(0).getUrl() != null) {
                ViewUtils.loadBlurImage(this.mINativeAdData.getIconFiles().get(0).getUrl(), adBaseViewHolder.imageBlur, z3 ? 20 : 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            adBaseViewHolder.showImageArea.setVisibility(4);
            if (!YFListUtils.isEmpty(this.mINativeAdData.getImgFiles())) {
                String url = this.mINativeAdData.getImgFiles().get(0).getUrl();
                this.feedBean.imageUrl = url;
                if (!TextUtils.isEmpty(url)) {
                    ViewUtils.loadBlurImage(url, adBaseViewHolder.imageBlur, z3 ? 20 : 0);
                    if (this.mINativeAdData.getCreativeType() == 15) {
                        z = false;
                    } else if (z3) {
                        setHBackground(adBaseViewHolder.showImageArea);
                    }
                    ViewUtils.loadImage(url, adBaseViewHolder.showImg, new ViewUtils.ViewImageCallback() { // from class: com.yfanads.ads.chanel.oppo.OppoInterstitialAdapter$$ExternalSyntheticLambda1
                        @Override // com.yfanads.android.utils.ViewUtils.ViewImageCallback
                        public final void onResourceReady() {
                            adBaseViewHolder.showImageArea.setVisibility(0);
                        }
                    });
                    this.feedBean.imageUrl = url;
                } else {
                    this.feedBean.imageUrl = "Failed to obtain image information";
                }
            }
        }
        interTemplateData.updAdLog(R.mipmap.ad_log_oppo_v3);
        String desc = TextUtils.isEmpty(this.mINativeAdData.getTitle()) ? this.mINativeAdData.getDesc() : this.mINativeAdData.getTitle();
        String title = TextUtils.isEmpty(this.mINativeAdData.getDesc()) ? this.mINativeAdData.getTitle() : this.mINativeAdData.getDesc();
        if (z3) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (z) {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_SMALL);
            } else {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_BIG);
            }
            if (this.mINativeAdData.getIconFiles() != null) {
                ViewUtils.loadCircleImage(this.mINativeAdData.getIconFiles().get(0).getUrl(), adInterV2ViewHolder.adIcon, 20);
            }
            TextView textView = adInterV2ViewHolder.adIconName;
            if (desc == null) {
                desc = "";
            }
            textView.setText(desc);
        } else {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (this.mINativeAdData.getIconFiles() != null) {
                ViewUtils.loadCircleImage(this.mINativeAdData.getIconFiles().get(0).getUrl(), adInterV3ViewHolder.adIcon, 20);
            }
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
        adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.oppo.OppoInterstitialAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1140xda692a37(view);
            }
        });
        registerViewForInteraction(adBaseViewHolder, interTemplateData, z2, this.mINativeAdData);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.oppo.OppoInterstitialAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1141x67a3dbb8(fragmentManager, view);
                }
            });
        }
        complianceContent(adBaseViewHolder);
        startCountDown(adBaseViewHolder, interTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-oppo-OppoInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1140xda692a37(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$2$com-yfanads-ads-chanel-oppo-OppoInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1141x67a3dbb8(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder) {
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    private void registerViewForInteraction(AdBaseViewHolder adBaseViewHolder, BaseTemplateData baseTemplateData, boolean z, INativeAdvanceData iNativeAdvanceData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (!baseTemplateData.isShowDownloadDialog()) {
                arrayList2.add(adInterV2ViewHolder.dyClickView);
            } else {
                arrayList.add(adInterV2ViewHolder.dyClickView);
            }
            if (baseTemplateData.isActionClickType()) {
                arrayList2.add(adInterV2ViewHolder.animationClickView);
            }
            adBaseViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.oppo.OppoInterstitialAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            if (z) {
                bindMediaView((NativeAdvanceContainer) adInterV2ViewHolder.nativeAdContainer, adInterV2ViewHolder.mediaViewFrame, iNativeAdvanceData, arrayList, arrayList2);
                return;
            } else {
                bindImageViews((NativeAdvanceContainer) adInterV2ViewHolder.nativeAdContainer, iNativeAdvanceData, arrayList, arrayList2);
                return;
            }
        }
        if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (baseTemplateData instanceof InterV3TemplateData) {
                if (((InterV3TemplateData) baseTemplateData).isWholeClick()) {
                    if (baseTemplateData.isShowDownloadDialog()) {
                        arrayList.add(adInterV3ViewHolder.viewGroup);
                    } else {
                        arrayList2.add(adInterV3ViewHolder.viewGroup);
                    }
                }
                arrayList.add(adInterV3ViewHolder.adCloseDelay);
                if (baseTemplateData.isActionClickType()) {
                    arrayList.add(adInterV3ViewHolder.actionView);
                    arrayList.add(adInterV3ViewHolder.animationClickView);
                }
            }
            if (z) {
                bindMediaView((NativeAdvanceContainer) adInterV3ViewHolder.nativeAdContainer, adInterV3ViewHolder.mediaViewFrame, iNativeAdvanceData, arrayList, arrayList2);
            } else {
                bindImageViews((NativeAdvanceContainer) adInterV3ViewHolder.nativeAdContainer, iNativeAdvanceData, arrayList, arrayList2);
            }
        }
    }

    private void bindMediaView(NativeAdvanceContainer nativeAdvanceContainer, FrameLayout frameLayout, INativeAdvanceData iNativeAdvanceData, List<View> list, List<View> list2) {
        if (getContext() != null) {
            iNativeAdvanceData.setInteractListener(new INativeAdvanceInteractListener() { // from class: com.yfanads.ads.chanel.oppo.OppoInterstitialAdapter.2
                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
                public void onClick() {
                    OppoInterstitialAdapter.this.handleClick();
                    OppoInterstitialAdapter.this.closeAdsDelay();
                }

                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
                public void onShow() {
                    OppoInterstitialAdapter.this.handleExposure();
                }

                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
                public void onError(int i, String str) {
                    OppoInterstitialAdapter.this.handleFailed(i, str);
                }
            });
            iNativeAdvanceData.bindToView(getContext(), nativeAdvanceContainer, list, list2);
            MediaView mediaView = new MediaView(getContext());
            mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (mediaView.getParent() == null) {
                frameLayout.removeAllViews();
                frameLayout.addView(mediaView);
            }
            iNativeAdvanceData.bindMediaView(getContext(), mediaView, new INativeAdvanceMediaListener() { // from class: com.yfanads.ads.chanel.oppo.OppoInterstitialAdapter.3
                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
                public void onVideoPlayStart() {
                    YFLog.debug(OppoInterstitialAdapter.this.tag + "onVideoPlayStart: ");
                }

                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
                public void onVideoPlayComplete() {
                    YFLog.debug(OppoInterstitialAdapter.this.tag + "onVideoPlayComplete: ");
                }

                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
                public void onVideoPlayError(int i, String str) {
                    YFLog.debug(OppoInterstitialAdapter.this.tag + "onVideoError: ");
                    OppoInterstitialAdapter.this.handleFailed(i, str);
                }
            });
        }
    }

    private void bindImageViews(NativeAdvanceContainer nativeAdvanceContainer, INativeAdvanceData iNativeAdvanceData, List<View> list, List<View> list2) {
        if (getContext() != null) {
            iNativeAdvanceData.setInteractListener(new INativeAdvanceInteractListener() { // from class: com.yfanads.ads.chanel.oppo.OppoInterstitialAdapter.4
                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
                public void onClick() {
                    OppoInterstitialAdapter.this.handleClick();
                    OppoInterstitialAdapter.this.closeAdsDelay();
                }

                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
                public void onShow() {
                    OppoInterstitialAdapter.this.handleExposure();
                }

                @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
                public void onError(int i, String str) {
                    OppoInterstitialAdapter.this.handleFailed(i, str);
                }
            });
            iNativeAdvanceData.bindToView(getContext(), nativeAdvanceContainer, list, list2);
        }
    }

    @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
    public void onAdReady() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            setEcpm(interstitialAd.getECPM());
        }
        handleSucceed();
    }

    @Override // com.heytap.msp.mobad.api.listener.IInterstitialAdListener
    public void onAdClose() {
        closeAds();
    }

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdShow() {
        YFLog.high(this.tag + "newVersionAd onAdShow");
        handleExposure();
    }

    @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
    public void onAdFailed(String str) {
        handleFailed(YFAdError.parseErr(str));
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
        closeAdsDelay();
    }
}
