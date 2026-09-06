package com.yfanads.ads.chanel.ylh;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import com.yfanads.ads.chanel.ylh.hold.YlhSplashViewHolder;
import com.yfanads.ads.chanel.ylh.template.YlhSplashTemplateData;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.model.template.SplashTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhSplashAdapter extends SplashCustomAdapter implements SplashADListener, NativeADEventListener {
    private boolean isClicked;
    private NativeUnifiedADData nativeAds;
    private long remainTime;
    private SplashAD splashAd;
    private YlhSplashViewHolder splashViewHolder;
    String tips;

    public YlhSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
        this.remainTime = 5000L;
        this.isClicked = false;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.YLH.getValue();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void showSplashAD(Activity activity, ViewGroup viewGroup) {
        SplashAD splashAD = this.splashAd;
        if (splashAD != null) {
            splashAD.showAd(viewGroup);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isNative()) {
            NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
            return nativeUnifiedADData != null ? YlhUtil.getReqId(nativeUnifiedADData.getExtraInfo()) : "";
        }
        SplashAD splashAD = this.splashAd;
        return splashAD != null ? YlhUtil.getReqId(splashAD.getExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (isNative()) {
            NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
            return nativeUnifiedADData != null && nativeUnifiedADData.isValid();
        }
        SplashAD splashAD = this.splashAd;
        return splashAD != null && splashAD.isValid();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        SplashAD splashAD = this.splashAd;
        String shortString = "";
        if (splashAD != null) {
            splashAD.sendWinNotification(YlhUtil.getWindBiddingMap(splashAD.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
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
        if (this.splashAd != null && sdkSupplier != null) {
            this.splashAd.sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier())));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (this.nativeAds == null || sdkSupplier == null) {
            return;
        }
        this.nativeAds.sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier())));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhSplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhSplashAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void loadSplashAd(Context context) {
        SplashAD splashAD = new SplashAD(context, this.sdkSupplier.getPotId(), this, this.sdkSupplier.requestTimeout > 0 ? (int) this.sdkSupplier.requestTimeout : 3000);
        this.splashAd = splashAD;
        splashAD.fetchAdOnly();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void loadNativeSplashAd(Context context) {
        new NativeUnifiedAD(context, this.sdkSupplier.getPotId(), new NativeADUnifiedListener() { // from class: com.yfanads.ads.chanel.ylh.YlhSplashAdapter.2
            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YFLog.high(YlhSplashAdapter.this.tag + "onNoAD code:" + adError.getErrorCode() + " msg:" + adError.getErrorMsg());
                YlhSplashAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                YFLog.high(YlhSplashAdapter.this.tag + "onNativeAdLoad " + list);
                try {
                    if (YlhSplashAdapter.this.nativeAds != null) {
                        YlhSplashAdapter.this.nativeAds.destroy();
                    }
                    if (list != null && !list.isEmpty() && list.get(0) != null) {
                        YlhSplashAdapter.this.nativeAds = list.get(0);
                        YlhSplashAdapter ylhSplashAdapter = YlhSplashAdapter.this;
                        ylhSplashAdapter.setEcpm(ylhSplashAdapter.nativeAds.getECPM());
                        YFLog.high(YlhSplashAdapter.this.tag + "onNativeAdLoad ad isValid:" + YlhSplashAdapter.this.nativeAds.isValid());
                        YlhSplashAdapter.this.handleSucceed();
                        return;
                    }
                    YlhSplashAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Throwable th) {
                    th.printStackTrace();
                    YlhSplashAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }
        }).loadData(1);
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void showNativeSplashAd(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAds == null) {
            YFLog.error(this.tag + "doShowADByNative nativeAd == null");
            return;
        }
        String templateKey = this.sdkSupplier.getTemplateKey(TemplateRes.SPLASH_V2);
        int template = TemplateRes.getTemplate(templateKey);
        if (template == 0) {
            handleRenderFailed(0, " addView error has no id");
            return;
        }
        super.showNativeSplashAd(activity, viewGroup);
        YlhSplashTemplateData ylhSplashTemplateData = new YlhSplashTemplateData(templateKey, isFullScreen());
        ylhSplashTemplateData.setConf(this.sdkSupplier.getTemplateConf());
        View viewInflate = LayoutInflater.from(getContext()).inflate(template, (ViewGroup) null);
        this.splashViewHolder = new YlhSplashViewHolder(viewInflate, ylhSplashTemplateData);
        bindData(activity, ylhSplashTemplateData, this.nativeAds);
        addViewLister(viewInflate);
        handleApiExposure();
        doShowAD(viewGroup, this.splashViewHolder.nativeAdContainer);
    }

    private void bindData(Activity activity, YlhSplashTemplateData ylhSplashTemplateData, NativeUnifiedADData nativeUnifiedADData) {
        Context context = getContext();
        boolean zIsScreenLand = YFAdsPhone.getInstance().isScreenLand(activity);
        ylhSplashTemplateData.updAdLog(R.mipmap.ad_log_ylh_v3);
        boolean zIsVideo = isVideo();
        this.feedBean = new FeedBean(nativeUnifiedADData.getTitle(), nativeUnifiedADData.getDesc(), zIsVideo, ylhSplashTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        YFLog.high(this.tag + " bindData isVideo " + isVideo());
        updateDataView(ylhSplashTemplateData, nativeUnifiedADData, zIsVideo, zIsScreenLand);
        this.splashViewHolder.updateShowView(context, ylhSplashTemplateData, zIsScreenLand);
        complianceContent(this.splashViewHolder, nativeUnifiedADData);
        this.splashViewHolder.getCloseView(ylhSplashTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhSplashAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1173lambda$bindData$0$comyfanadsadschanelylhYlhSplashAdapter(view);
            }
        });
        registerViewForInteraction(zIsVideo, ylhSplashTemplateData, nativeUnifiedADData);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            this.splashViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhSplashAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1174lambda$bindData$1$comyfanadsadschanelylhYlhSplashAdapter(fragmentManager, view);
                }
            });
        }
        int autoCloseTime = ylhSplashTemplateData.getAutoCloseTime(5);
        String string = TextUtils.isEmpty(this.splashViewHolder.closeTips) ? getContext().getString(R.string.jump_tip) : this.splashViewHolder.closeTips;
        this.tips = string;
        this.splashViewHolder.setTevCountdown(String.format(string, Integer.valueOf(autoCloseTime)));
        startCloutDown(autoCloseTime, this.tips);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ylh-YlhSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1173lambda$bindData$0$comyfanadsadschanelylhYlhSplashAdapter(View view) {
        handleClose(true);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ylh-YlhSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1174lambda$bindData$1$comyfanadsadschanelylhYlhSplashAdapter(FragmentManager fragmentManager, View view) {
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
        this.splashViewHolder.complianceContent.setVisibility(8);
    }

    private void registerViewForInteraction(boolean z, YlhSplashTemplateData ylhSplashTemplateData, NativeUnifiedADData nativeUnifiedADData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (ylhSplashTemplateData.isWholeClick()) {
            if (ylhSplashTemplateData.isShowDownloadDialog()) {
                arrayList.add(this.splashViewHolder.viewGroup);
            } else {
                arrayList2.add(this.splashViewHolder.viewGroup);
            }
        }
        arrayList.add(this.splashViewHolder.adCloseDelay);
        if (ylhSplashTemplateData.isActionClickType()) {
            if (isDownloadAd(nativeUnifiedADData) && !ylhSplashTemplateData.isActionShowDialog()) {
                arrayList2.add(this.splashViewHolder.barView);
                arrayList2.add(this.splashViewHolder.actionView);
                arrayList2.add(this.splashViewHolder.animationSlideView);
                if (ylhSplashTemplateData.isBigStyle()) {
                    arrayList2.add(this.splashViewHolder.actionViewBig);
                }
            } else {
                arrayList.add(this.splashViewHolder.barView);
                arrayList.add(this.splashViewHolder.actionView);
                arrayList.add(this.splashViewHolder.animationSlideView);
                if (ylhSplashTemplateData.isBigStyle()) {
                    arrayList.add(this.splashViewHolder.actionViewBig);
                }
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
        layoutParams.gravity = 53;
        if (z) {
            bindMediaView(this.splashViewHolder.nativeAdContainer, ylhSplashTemplateData, this.splashViewHolder.mediaViewFrame, ylhSplashTemplateData.isMute(), nativeUnifiedADData, layoutParams, arrayList, arrayList2);
        } else {
            bindImageViews(this.splashViewHolder.nativeAdContainer, nativeUnifiedADData, layoutParams, arrayList, arrayList2);
        }
    }

    private void bindMediaView(NativeAdContainer nativeAdContainer, SplashTemplateData splashTemplateData, FrameLayout frameLayout, boolean z, NativeUnifiedADData nativeUnifiedADData, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        nativeUnifiedADData.bindAdToView(getContext(), nativeAdContainer, layoutParams, list, list2);
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            frameLayout.removeAllViews();
            frameLayout.addView(mediaView);
        }
        nativeUnifiedADData.setNativeAdEventListener(this);
        boolean z2 = !splashTemplateData.isWholeClick();
        YFLog.debug(this.tag + "enableUserControl: " + z2);
        nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayMuted(z).setAutoPlayPolicy(1).setNeedCoverImage(true).setEnableUserControl(z2).build(), new NativeADMediaListener() { // from class: com.yfanads.ads.chanel.ylh.YlhSplashAdapter.3
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoReady: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoStart: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoPause: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoResume: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoCompleted: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                if (adError != null) {
                    YFLog.debug(YlhSplashAdapter.this.tag + "onVideoError: " + adError.getErrorMsg() + "_" + adError.getErrorCode());
                }
                if (YlhSplashAdapter.this.isStartShow()) {
                    if (adError != null) {
                        YlhSplashAdapter.this.handleRenderFailed(adError.getErrorCode(), adError.getErrorMsg());
                        return;
                    } else {
                        YlhSplashAdapter.this.handleRenderFailed();
                        return;
                    }
                }
                if (adError != null) {
                    YlhSplashAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    YlhSplashAdapter.this.handleFailed(0, "onVideoError");
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoStop: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                YFLog.debug(YlhSplashAdapter.this.tag + "onVideoClicked: ");
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

    private boolean isVideo() {
        return this.nativeAds.getAdPatternType() == 2;
    }

    private void updateDataView(YlhSplashTemplateData ylhSplashTemplateData, NativeUnifiedADData nativeUnifiedADData, boolean z, boolean z2) {
        if (z) {
            this.splashViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (this.nativeAds.getImgUrl() != null) {
                ViewUtils.loadBlurImage(this.nativeAds.getImgUrl(), this.splashViewHolder.imageBlur, 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, this.splashViewHolder.imageBlur);
            }
        } else {
            this.splashViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (this.nativeAds.getImgUrl() != null) {
                this.feedBean.imageUrl = this.nativeAds.getImgUrl();
                ViewUtils.loadBlurImage(this.nativeAds.getImgUrl(), this.splashViewHolder.imageBlur, 1);
                ViewUtils.loadImage(this.nativeAds.getImgUrl(), this.splashViewHolder.showImg);
                if (ViewUtils.isHorizontal(this.nativeAds.getPictureWidth(), this.nativeAds.getPictureHeight())) {
                    setHBackground(this.splashViewHolder.showImageArea);
                }
            }
        }
        if (ylhSplashTemplateData.isShowTopArea(z2)) {
            ViewUtils.loadCircleImage(this.nativeAds.getIconUrl(), this.splashViewHolder.adIconSmall, 8);
            this.splashViewHolder.adIconNameSmall.setText(TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getDesc() : this.nativeAds.getTitle());
        }
        if (ylhSplashTemplateData.isTemplateV2()) {
            this.splashViewHolder.adDes.setText(TextUtils.isEmpty(this.nativeAds.getDesc()) ? this.nativeAds.getTitle() : this.nativeAds.getDesc());
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.splashAd != null) {
            this.splashAd = null;
        }
        NativeUnifiedADData nativeUnifiedADData = this.nativeAds;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
            this.nativeAds = null;
        }
        YlhSplashViewHolder ylhSplashViewHolder = this.splashViewHolder;
        if (ylhSplashViewHolder != null) {
            ylhSplashViewHolder.destroy();
        }
    }

    private void preLoad() {
        try {
            SplashAD splashAD = this.splashAd;
            if (splashAD != null) {
                splashAD.preLoad();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        YFLog.high(this.tag + "onADDismissed ");
        handleClose(this.remainTime >= 600 && !this.isClicked);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        int errorCode;
        String errorMsg;
        if (adError != null) {
            errorCode = adError.getErrorCode();
            errorMsg = adError.getErrorMsg();
        } else {
            errorCode = -1;
            errorMsg = "default onNoAD";
        }
        YFLog.high(this.tag + "onNoAD :(" + errorCode + "," + errorMsg + ")");
        if (isStartShow()) {
            handleRenderFailed(errorCode, errorMsg);
        } else {
            handleFailed(errorCode, errorMsg);
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
        YFLog.high(this.tag + "onADPresent ");
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        YFLog.high(this.tag + "onADExposed ");
        handleExposure();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        YFLog.high(this.tag + "onADClicked ");
        handleClick();
        this.isClicked = true;
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        YFLog.high(this.tag + " onADError error code :" + adError.getErrorCode() + "  error msg: " + adError.getErrorMsg());
        handleFailed(adError.getErrorCode(), adError.getErrorMsg());
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
        YFLog.high(this.tag + "onADStatusChanged :");
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
        YFLog.high(this.tag + "onADTick :" + j);
        this.remainTime = j;
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        YFLog.high(this.tag + "onADExposure ");
        handleExposure();
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        try {
            YFLog.high(this.tag + "onADLoaded ");
            SplashAD splashAD = this.splashAd;
            if (splashAD != null) {
                setEcpm(splashAD.getECPM());
            }
            handleSucceed();
            YFLog.high(this.tag + " ad will expired in :" + (j - SystemClock.elapsedRealtime()) + " ms");
        } catch (Throwable th) {
            th.printStackTrace();
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void countDownTimerOnTick(String str, int i) {
        super.countDownTimerOnTick(str, i);
        YlhSplashViewHolder ylhSplashViewHolder = this.splashViewHolder;
        if (ylhSplashViewHolder != null) {
            ylhSplashViewHolder.setTevCountdown(String.format(str, Integer.valueOf(i)));
        }
    }
}
