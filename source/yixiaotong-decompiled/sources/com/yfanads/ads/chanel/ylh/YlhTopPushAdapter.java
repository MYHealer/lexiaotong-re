package com.yfanads.ads.chanel.ylh;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.qq.e.ads.cfg.VideoOption;
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
import com.yfanads.android.core.toppush.YFTopPushSetting;
import com.yfanads.android.custom.TopPushCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdTopPushViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.TopPushTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhTopPushAdapter extends TopPushCustomAdapter implements NativeADEventListener {
    private NativeUnifiedADData nativeAds;

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
    }

    public YlhTopPushAdapter(YFTopPushSetting yFTopPushSetting) {
        super(yFTopPushSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.YLH.getValue();
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
            this.nativeAds = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhTopPushAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhTopPushAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhTopPushAdapter.this.handleFailed(str, str2);
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
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_YLH_CONTEXT));
        }
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        if (isNative()) {
            showNativeADs(activity);
        } else {
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        NativeUnifiedADData nativeUnifiedADData;
        return (!isNative() || (nativeUnifiedADData = this.nativeAds) == null) ? "" : YlhUtil.getReqId(nativeUnifiedADData.getExtraInfo());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.sendWinNotification(YlhUtil.getWindBiddingMap(nativeUnifiedADData.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            String shortString = "";
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
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

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        NativeUnifiedADData nativeUnifiedADData;
        return isNative() && (nativeUnifiedADData = this.nativeAds) != null && nativeUnifiedADData.isValid();
    }

    private void loadInterstitialAdByNative(Context context) {
        new NativeUnifiedAD(context, this.sdkSupplier.getPotId(), new NativeADUnifiedListener() { // from class: com.yfanads.ads.chanel.ylh.YlhTopPushAdapter.2
            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YFLog.high(YlhTopPushAdapter.this.tag + "onNoAD code:" + adError.getErrorCode() + " msg:" + adError.getErrorMsg());
                YlhTopPushAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                YFLog.high(YlhTopPushAdapter.this.tag + "onNativeAdLoad " + list);
                try {
                    if (YlhTopPushAdapter.this.nativeAds != null) {
                        YlhTopPushAdapter.this.nativeAds.destroy();
                    }
                    if (list != null && list.size() != 0 && list.get(0) != null) {
                        YlhTopPushAdapter.this.nativeAds = list.get(0);
                        YlhTopPushAdapter ylhTopPushAdapter = YlhTopPushAdapter.this;
                        ylhTopPushAdapter.setEcpm(ylhTopPushAdapter.nativeAds.getECPM());
                        YFLog.high(YlhTopPushAdapter.this.tag + "onNativeAdLoad ad isValid:" + YlhTopPushAdapter.this.nativeAds.isValid());
                        YlhTopPushAdapter.this.handleSucceed();
                        return;
                    }
                    YlhTopPushAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Throwable th) {
                    th.printStackTrace();
                    YlhTopPushAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
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

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void bindData(Activity activity, TopPushTemplateData topPushTemplateData, AdBaseViewHolder adBaseViewHolder) {
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        boolean z = nativeUnifiedADData.getAdPatternType() == 2;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDesc(), z, topPushTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (!TextUtils.isEmpty(this.nativeAds.getImgUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImgUrl(), adBaseViewHolder.imageBlur, 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            YFLog.debug(this.tag + " showNativeADs image size = " + this.nativeAds.getPictureWidth() + " , " + this.nativeAds.getPictureHeight());
            if (!TextUtils.isEmpty(this.nativeAds.getImgUrl())) {
                this.feedBean.imageUrl = this.nativeAds.getImgUrl();
                ViewUtils.loadBlurImage(this.nativeAds.getImgUrl(), adBaseViewHolder.imageBlur, 0);
                ViewUtils.loadImage(this.nativeAds.getImgUrl(), adBaseViewHolder.showImg);
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
        ViewUtils.loadCircleImage(this.nativeAds.getIconUrl(), adTopPushViewHolder.adIcon, 8);
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
        topPushTemplateData.updAdLog(R.mipmap.ad_log_ylh_v4);
        adTopPushViewHolder.updateShowView(getContext(), topPushTemplateData);
        adTopPushViewHolder.getCloseView(topPushTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhTopPushAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1175lambda$bindData$0$comyfanadsadschanelylhYlhTopPushAdapter(view);
            }
        });
        registerViewForInteraction(adTopPushViewHolder, topPushTemplateData, z, this.nativeAds);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adTopPushViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhTopPushAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1176lambda$bindData$1$comyfanadsadschanelylhYlhTopPushAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adTopPushViewHolder, this.nativeAds);
        startCountDown(adTopPushViewHolder, topPushTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ylh-YlhTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1175lambda$bindData$0$comyfanadsadschanelylhYlhTopPushAdapter(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ylh-YlhTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1176lambda$bindData$1$comyfanadsadschanelylhYlhTopPushAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder, NativeUnifiedADData nativeUnifiedADData) {
        if (isDownloadAd(nativeUnifiedADData)) {
            NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
            if (appMiitInfo == null) {
                adBaseViewHolder.complianceContent.setVisibility(8);
                return;
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

    private void registerViewForInteraction(AdTopPushViewHolder adTopPushViewHolder, TopPushTemplateData topPushTemplateData, boolean z, NativeUnifiedADData nativeUnifiedADData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(adTopPushViewHolder.viewGroup);
        if (adTopPushViewHolder.adCloseDelay != null) {
            arrayList.add(adTopPushViewHolder.adCloseDelay);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
        layoutParams.gravity = 53;
        if (z) {
            bindMediaView((NativeAdContainer) adTopPushViewHolder.nativeAdContainer, topPushTemplateData, adTopPushViewHolder.mediaViewFrame, topPushTemplateData.isMute(), nativeUnifiedADData, layoutParams, arrayList, arrayList2);
        } else {
            bindImageViews((NativeAdContainer) adTopPushViewHolder.nativeAdContainer, nativeUnifiedADData, layoutParams, arrayList, arrayList2);
        }
    }

    private void bindMediaView(NativeAdContainer nativeAdContainer, TopPushTemplateData topPushTemplateData, FrameLayout frameLayout, boolean z, NativeUnifiedADData nativeUnifiedADData, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        nativeUnifiedADData.bindAdToView(getContext(), nativeAdContainer, layoutParams, list, list2);
        MediaView mediaView = new MediaView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        mediaView.setLayoutParams(layoutParams2);
        if (mediaView.getParent() == null) {
            frameLayout.removeAllViews();
            frameLayout.addView(mediaView);
        }
        nativeUnifiedADData.setNativeAdEventListener(this);
        nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayMuted(z).setAutoPlayPolicy(1).setNeedCoverImage(true).setEnableUserControl(false).build(), new NativeADMediaListener() { // from class: com.yfanads.ads.chanel.ylh.YlhTopPushAdapter.3
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoReady: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoStart: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoPause: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoResume: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoCompleted: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                if (adError != null) {
                    YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoError: " + adError.getErrorMsg() + "_" + adError.getErrorCode());
                }
                if (YlhTopPushAdapter.this.isStartShow()) {
                    if (adError != null) {
                        YlhTopPushAdapter.this.handleRenderFailed(adError.getErrorCode(), adError.getErrorMsg());
                        return;
                    } else {
                        YlhTopPushAdapter.this.handleRenderFailed();
                        return;
                    }
                }
                if (adError != null) {
                    YlhTopPushAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    YlhTopPushAdapter.this.handleFailed(0, "onVideoError");
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoStop: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                YFLog.debug(YlhTopPushAdapter.this.tag + "onVideoClicked: ");
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
        handleExposure();
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        handleClick();
        closeAdsDelay();
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        YFLog.high(this.tag + " onADError error code :" + adError.getErrorCode() + "  error msg: " + adError.getErrorMsg());
        handleFailed(adError.getErrorCode(), adError.getErrorMsg());
    }
}
