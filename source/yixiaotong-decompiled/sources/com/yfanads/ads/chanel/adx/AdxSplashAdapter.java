package com.yfanads.ads.chanel.adx;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.dyf.tt;
import com.yfanads.ads.chanel.adx.holder.AdxSplashViewHolder;
import com.yfanads.ads.chanel.adx.template.AdxSplashTemplateData;
import com.yfanads.ads.chanel.adx.utils.AdxSdkUtil;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.impl.AbstractNativeAd;
import com.yfanads.android.adx.core.model.AdxImage;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.player.yfplayer.IPlayVideo;
import com.yfanads.android.adx.service.a;
import com.yfanads.android.adx.service.c;
import com.yfanads.android.adx.utils.b;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.custom.view.AdSplashViewHolder;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxSplashAdapter extends SplashCustomAdapter implements AdxNativeAd.AdInteractionListener, AdxNativeAd.AdInteractionListener2 {
    private static final String TAG = "AdxSplashAdapter";
    private AdxSplashTemplateData adxSplashTemplateData;
    private AdxSplashViewHolder adxSplashViewHolder;
    private CountDownTimer countDownTimer;
    private int currentCountDownTime;
    private boolean isAuto;
    private boolean isDownloadDialogShow;
    private boolean isScreenLand;
    private boolean isShakeAction;
    private boolean isShakeActionOne;
    private boolean isVideo;
    AbstractNativeAd nativeAds;
    private IPlayVideo playVideo;

    public AdxSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
        this.currentCountDownTime = 5;
        this.isScreenLand = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adapterClose(AdxSplashViewHolder adxSplashViewHolder, boolean z) {
        if (b.a()) {
            AbstractNativeAd abstractNativeAd = this.nativeAds;
            if (abstractNativeAd != null) {
                abstractNativeAd.destroy(a.SPLASH);
                if (this.isVideo) {
                    this.nativeAds.reportAdInfo(18, null);
                }
            }
            if (adxSplashViewHolder != null) {
                adxSplashViewHolder.destroy();
            }
            cancelCountDown();
            handleClose(z);
        }
    }

    private void bindImageViews(Activity activity, final AdxSplashViewHolder adxSplashViewHolder, final AdxNativeAd adxNativeAd, Map<View, Integer> map, AdxSplashTemplateData adxSplashTemplateData) {
        if (activity != null) {
            a aVar = a.SPLASH;
            adxNativeAd.registerViewForInteraction(activity, aVar, adxSplashViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(this.isAuto, adxSplashTemplateData), this);
            adxNativeAd.setAdsListener(aVar, this);
        }
        if (adxSplashTemplateData.isTemplateV2()) {
            adxSplashViewHolder.showImg.post(new Runnable() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1033x1537ec98(adxNativeAd, adxSplashViewHolder);
                }
            });
        }
    }

    private void bindMediaView(Activity activity, final AdxSplashViewHolder adxSplashViewHolder, final AbstractNativeAd abstractNativeAd, Map<View, Integer> map, final AdxSplashTemplateData adxSplashTemplateData) {
        if (activity != null) {
            a aVar = a.SPLASH;
            abstractNativeAd.registerViewForInteraction(activity, aVar, adxSplashViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(adxSplashTemplateData.isAutoClick(), adxSplashTemplateData), this);
            abstractNativeAd.setAdsListener(aVar, this);
        }
        IPlayVideo videoView2 = abstractNativeAd.getVideoView2(getContext(), new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ adxSplashTemplateData.isMute()).build());
        this.playVideo = videoView2;
        if (videoView2 == null) {
            YFLog.high("AdxSplashAdapterplayVideo is null");
        } else {
            final View view = videoView2.getView();
            abstractNativeAd.setVideoPlayListener(new AdxNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter.5
                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
                public void onVideoPlayComplete() {
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
                public void onVideoPlayError(int i, int i2) {
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
                public void onVideoPlayStart() {
                    AdxSplashAdapter.this.updateWithVideoPlayStart(adxSplashViewHolder, adxSplashTemplateData, abstractNativeAd, view);
                }
            });
        }
    }

    private int getActionType(BaseTemplateData.InteractiveStyle interactiveStyle) {
        if (interactiveStyle == BaseTemplateData.InteractiveStyle.SHAKE || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SHAKE) {
            return 1;
        }
        if (interactiveStyle == BaseTemplateData.InteractiveStyle.TWIST || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_TWIST) {
            return 2;
        }
        if (interactiveStyle == BaseTemplateData.InteractiveStyle.SLIDE) {
            return 3;
        }
        return interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE ? 6 : 0;
    }

    private boolean needUpdateAction() {
        return this.isShakeAction && this.isShakeActionOne;
    }

    private void registerViewForInteraction(Activity activity, AdxSplashViewHolder adxSplashViewHolder, AbstractNativeAd abstractNativeAd, AdxSplashTemplateData adxSplashTemplateData, boolean z) {
        HashMap map = new HashMap();
        BaseTemplateData.InteractiveStyle activeStyle = adxSplashTemplateData.getActiveStyle();
        int actionType = getActionType(activeStyle);
        adxSplashViewHolder.getActionClickType(activeStyle);
        if (adxSplashTemplateData.isTemplateV1()) {
            map.put(adxSplashViewHolder.animationSlideView, Integer.valueOf(actionType));
            map.put(adxSplashViewHolder.barView, 5);
            map.put(adxSplashViewHolder.dyClickView, 4);
            adxSplashViewHolder.updateBarClickable(adxSplashTemplateData.isActionClickType());
            adxSplashViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.yfanads.android.adx.utils.a.a("AdxSplashAdapter onClickView ");
                }
            });
        } else {
            if (!adxSplashTemplateData.isBigStyle()) {
                map.put(adxSplashViewHolder.animationSlideView, Integer.valueOf(actionType));
                if (adxSplashTemplateData.isActionClickType()) {
                    map.put(adxSplashViewHolder.barView, 5);
                    map.put(adxSplashViewHolder.actionView, 5);
                } else {
                    map.put(adxSplashViewHolder.barView, 5);
                    map.put(adxSplashViewHolder.actionView, 5);
                    adxSplashViewHolder.updateBarClickable(false);
                }
            } else if (actionType == 3 || actionType == 6) {
                map.put(adxSplashViewHolder.actionViewBig, Integer.valueOf(actionType));
            } else {
                map.put(adxSplashViewHolder.actionViewIcon, Integer.valueOf(actionType));
                if (adxSplashTemplateData.isActionClickType()) {
                    map.put(adxSplashViewHolder.actionViewBigArea, 5);
                } else {
                    map.put(adxSplashViewHolder.actionViewBigArea, 5);
                    adxSplashViewHolder.updateBarClickable(false);
                }
            }
            if (adxSplashTemplateData.isWholeClick()) {
                map.put(adxSplashViewHolder.viewGroup, 4);
            }
            map.put(adxSplashViewHolder.adCloseDelay, 4);
        }
        if (z) {
            bindMediaView(activity, adxSplashViewHolder, abstractNativeAd, map, adxSplashTemplateData);
        } else {
            bindImageViews(activity, adxSplashViewHolder, abstractNativeAd, map, adxSplashTemplateData);
        }
        startCountDown(this.currentCountDownTime, adxSplashViewHolder);
    }

    private void showImageUI(final AdxSplashViewHolder adxSplashViewHolder, AdxImage adxImage) {
        adxSplashViewHolder.showImageArea.setVisibility(4);
        ViewUtils.loadBlurImage(adxImage.getImageUrl(), adxSplashViewHolder.imageBlur, 20);
        ViewUtils.loadImage(adxImage.getImageUrl(), adxSplashViewHolder.showImg, new ViewUtils.ViewImageCallback() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter$$ExternalSyntheticLambda0
            @Override // com.yfanads.android.utils.ViewUtils.ViewImageCallback
            public final void onResourceReady() {
                adxSplashViewHolder.showImageArea.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAds() {
        startCountDown(this.currentCountDownTime, this.adxSplashViewHolder);
        reStartVideo();
    }

    private void updActionShake() {
        this.adxSplashTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        updateShakeAction(this.adxSplashTemplateData);
        AdxSplashViewHolder adxSplashViewHolder = this.adxSplashViewHolder;
        if (adxSplashViewHolder != null) {
            adxSplashViewHolder.updateInteraction(getContext(), this.adxSplashTemplateData);
            this.adxSplashViewHolder.updateBarClickable(true);
        }
        YFOptional.ofNullable(this.nativeAds).ifPresentRun(new AdxInterstitialAdapter$$ExternalSyntheticLambda8());
    }

    private void updateShakeAction(BaseTemplateData baseTemplateData) {
        this.isShakeActionOne = baseTemplateData.isActionOne();
        this.isShakeAction = baseTemplateData.isShake() || baseTemplateData.isTwist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithVideoPlayStart(final AdxSplashViewHolder adxSplashViewHolder, final AdxSplashTemplateData adxSplashTemplateData, final AbstractNativeAd abstractNativeAd, final View view) {
        if (adxSplashViewHolder != null) {
            adxSplashViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1034xfc97a3cb(adxSplashViewHolder, abstractNativeAd, adxSplashTemplateData, view);
                }
            });
        }
    }

    public void bindData(Activity activity, AdxSplashTemplateData adxSplashTemplateData, final AdxSplashViewHolder adxSplashViewHolder) {
        AdxImage adxImage;
        adxSplashTemplateData.setAdx(true);
        adxSplashTemplateData.updAdLog(R.mipmap.yf_ad_logo);
        this.isVideo = this.nativeAds.getMaterialType() == 1;
        updateShakeAction(adxSplashTemplateData);
        this.currentCountDownTime = adxSplashTemplateData.getAutoCloseTime(5);
        if (!this.isSupportShake && adxSplashTemplateData.isAction()) {
            if (adxSplashTemplateData.isOnlyAction()) {
                adxSplashTemplateData.setBtnClick();
            }
            if (adxSplashTemplateData.isTemplateV1()) {
                adxSplashTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue());
            } else {
                adxSplashTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
            }
        }
        Context context = getContext();
        this.isScreenLand = YFAdsPhone.getInstance().isScreenLand(activity);
        if (this.isVideo) {
            adxSplashViewHolder.showStyleView(AdSplashViewHolder.Style.TYPE_VIDEO);
            if (this.nativeAds.getVideoCoverImage() == null || TextUtils.isEmpty(this.nativeAds.getVideoCoverImage().getImageUrl())) {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adxSplashViewHolder.imageBlur);
            } else {
                ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adxSplashViewHolder.imageBlur, 0);
            }
            com.yfanads.android.adx.utils.a.a("AdxSplashAdapter bindData isVideo ");
        } else if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (adxImage = this.nativeAds.getImageList().get(0)) != null) {
            if (adxImage.isValid()) {
                if (adxSplashTemplateData.isTemplateV1() && ViewUtils.isHorizontal(adxImage.getWidth(), adxImage.getHeight())) {
                    setHBackground(adxSplashViewHolder.showImageArea);
                }
                showImageUI(adxSplashViewHolder, adxImage);
            } else if (!TextUtils.isEmpty(adxImage.getImageUrl())) {
                showImageUI(adxSplashViewHolder, adxImage);
            }
        }
        adxSplashViewHolder.updateShowView(activity, adxSplashTemplateData, this.isScreenLand);
        if (adxSplashTemplateData.isShowTopArea(this.isScreenLand)) {
            ViewUtils.loadCircleImage(this.nativeAds.getAppIconUrl(), adxSplashViewHolder.adIconSmall, 8);
            adxSplashViewHolder.adIconNameSmall.setText(TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getAdDescription() : this.nativeAds.getTitle());
        }
        adxSplashViewHolder.complianceContent(context, this.nativeAds, adxSplashTemplateData.isBigStyle());
        adxSplashViewHolder.getCloseView(adxSplashTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1031lambda$bindData$0$comyfanadsadschaneladxAdxSplashAdapter(adxSplashViewHolder, view);
            }
        });
        if (adxSplashTemplateData.isTemplateV2()) {
            ((AdSplashViewHolder) adxSplashViewHolder).adDes.setText(TextUtils.isEmpty(this.nativeAds.getAdDescription()) ? this.nativeAds.getTitle() : this.nativeAds.getAdDescription());
        }
        registerViewForInteraction(activity, adxSplashViewHolder, this.nativeAds, adxSplashTemplateData, this.isVideo);
        if (activity != null) {
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adxSplashViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1032lambda$bindData$1$comyfanadsadschaneladxAdxSplashAdapter(fragmentManager, view);
                }
            });
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        stopVideo();
        AdxSplashViewHolder adxSplashViewHolder = this.adxSplashViewHolder;
        if (adxSplashViewHolder != null) {
            adxSplashViewHolder.destroy();
            this.adxSplashViewHolder = null;
        }
        AbstractNativeAd abstractNativeAd = this.nativeAds;
        if (abstractNativeAd != null) {
            abstractNativeAd.destroy(a.SPLASH);
        }
        cancelCountDown();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        AdxSdkUtil.initAD(this.tag, context, getInitBean(), isListPackage(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                AdxSplashAdapter.this.handleFailed(str, str2);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                AdxSplashAdapter.this.startLoadAD(context);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return AdxSdkUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.ADX.getValue();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public boolean isNative() {
        return true;
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-adx-AdxSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1031lambda$bindData$0$comyfanadsadschaneladxAdxSplashAdapter(AdxSplashViewHolder adxSplashViewHolder, View view) {
        adapterClose(adxSplashViewHolder, true);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-adx-AdxSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1032lambda$bindData$1$comyfanadsadschaneladxAdxSplashAdapter(FragmentManager fragmentManager, View view) {
        cancelCountDown();
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new OnFeedClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter.4
            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onDismiss() {
                com.yfanads.android.adx.utils.a.a("AdxSplashAdapter onDismiss ");
                AdxSplashAdapter.this.startAds();
            }

            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onTraceFeed() {
                FeedCom feedCom = new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(((SplashCustomAdapter) AdxSplashAdapter.this).sdkSupplier), AdxSplashAdapter.this.getRequestId());
                AdxSplashAdapter adxSplashAdapter = AdxSplashAdapter.this;
                adxSplashAdapter.nativeAds.traceData(((SplashCustomAdapter) adxSplashAdapter).sdkSupplier != null ? ((SplashCustomAdapter) AdxSplashAdapter.this).sdkSupplier.getTemplateConf() : null, feedCom, AdxSplashAdapter.this.isFullScreen());
            }
        });
    }

    /* JADX INFO: renamed from: lambda$bindImageViews$4$com-yfanads-ads-chanel-adx-AdxSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1033x1537ec98(AdxNativeAd adxNativeAd, AdxSplashViewHolder adxSplashViewHolder) {
        int videoWidth = adxNativeAd.getVideoWidth();
        int videoHeight = adxNativeAd.getVideoHeight();
        int width = adxSplashViewHolder.showImg.getWidth();
        int height = adxSplashViewHolder.showImg.getHeight();
        YFLog.info(this.tag + " w" + width + "|h" + height + "|vw" + videoWidth + "|vh" + videoHeight);
        updateMaterialArea(adxSplashViewHolder.showImg, width, height, videoWidth, videoHeight);
    }

    /* JADX INFO: renamed from: lambda$updateWithVideoPlayStart$5$com-yfanads-ads-chanel-adx-AdxSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1034xfc97a3cb(AdxSplashViewHolder adxSplashViewHolder, AbstractNativeAd abstractNativeAd, AdxSplashTemplateData adxSplashTemplateData, View view) {
        int i;
        int videoHeight;
        int width = adxSplashViewHolder.mediaViewFrame.getWidth();
        int height = adxSplashViewHolder.mediaViewFrame.getHeight();
        if (abstractNativeAd != null) {
            int videoWidth = abstractNativeAd.getVideoWidth();
            videoHeight = abstractNativeAd.getVideoHeight();
            i = videoWidth;
        } else {
            i = 0;
            videoHeight = 0;
        }
        YFLog.high(this.tag + " w" + width + "|h" + height + "|vw" + i + "|vh" + videoHeight);
        if (!adxSplashTemplateData.isTemplateV1()) {
            updateMaterialArea(adxSplashViewHolder.mediaViewFrame, width, height, i, videoHeight);
        } else if (i > 0 && videoHeight > 0) {
            ViewUtils.setViewSize(adxSplashViewHolder.mediaViewFrame, width, (int) (((double) width) / (((double) i) / ((double) videoHeight))));
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adxSplashViewHolder.mediaViewFrame.removeAllViews();
        new FrameLayout.LayoutParams(-2, -2).gravity = 17;
        adxSplashViewHolder.mediaViewFrame.addView(view);
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void loadNativeSplashAd(Context context) {
        AdxSDK.getLoadManager().loadNativeAd(new AdxScene.Builder(AdxSdkUtil.getAdId(this.sdkSupplier)).setEcpm(getEcpm()).setReqId(getRequestId()).adStyle(1).build(), new LoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter.2
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(AdxSplashAdapter.this.tag + " onError code:" + i + " msg:" + str);
                AdxSplashAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0048 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0048), top: B:16:0x001e }] */
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onNativeAdLoad(List<AdxNativeAd> list) {
                YFLog.high(AdxSplashAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() == 0 || list.get(0) == null) {
                            AdxSplashAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            AdxSplashAdapter.this.nativeAds = (AbstractNativeAd) list.get(0);
                            AdxSplashAdapter adxSplashAdapter = AdxSplashAdapter.this;
                            adxSplashAdapter.setEcpm(adxSplashAdapter.nativeAds.getECPM());
                            AdxSplashAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        AdxSplashAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    AdxSplashAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdClickedSuccess(boolean z, boolean z2, boolean z3) {
        YFLog.debug("AdxSplashAdapter onAdClickedSuccess: " + z2);
        if (!z2 && !z3) {
            stopTwistOrShake();
        }
        if (this.isDownloadDialogShow) {
            return;
        }
        if (z2) {
            downLoadToast();
        } else {
            if (z3) {
                return;
            }
            cancelCountDown();
            pauseVideo();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener2
    public void onAdClose(AdxNativeAd adxNativeAd) {
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdHide() {
        com.yfanads.android.adx.utils.a.a("AdxSplashAdapter onAdHide");
        cancelCountDown();
        pauseVideo();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdShakeCancel() {
        if (needUpdateAction()) {
            updActionShake();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdShakeSuccess(boolean z, boolean z2, boolean z3) {
        boolean zNeedUpdateAction = needUpdateAction();
        YFLog.debug("AdxSplashAdapter onAdShakeSuccess = " + zNeedUpdateAction);
        if (zNeedUpdateAction) {
            updActionShake();
        }
        if (zNeedUpdateAction || (!z2 && !z3)) {
            stopTwistOrShake();
        }
        if (this.isDownloadDialogShow) {
            return;
        }
        if (z2) {
            downLoadToast();
        } else {
            if (z3) {
                return;
            }
            cancelCountDown();
            pauseVideo();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdShow() {
        YFLog.high("AdxSplashAdapter onAdShow " + this.isDownloadDialogShow + " | " + this.currentCountDownTime);
        if (this.isDownloadDialogShow) {
            pauseVideo();
        } else {
            startAds();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onDownloadTipsDismiss() {
        com.yfanads.android.adx.utils.a.a("AdxSplashAdapter onDownloadTipsDismiss");
        this.isDownloadDialogShow = false;
        startAds();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onDownloadTipsShow() {
        com.yfanads.android.adx.utils.a.a("AdxSplashAdapter onDownloadTipsShow");
        this.isDownloadDialogShow = true;
        cancelCountDown();
        pauseVideo();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onExposure(boolean z) {
        if (z) {
            handleExposure();
        } else {
            handleFailed(YFAdError.ERROR_ADX_EXPOSURE, "exposure url empty");
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onHandleClick(boolean z) {
        YFLog.debug("AdxSplashAdapter onAdClicked");
        handleClick(z);
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void showNativeSplashAd(Activity activity, ViewGroup viewGroup) {
        YFLog.debug("doShowAD");
        super.showNativeSplashAd(activity, viewGroup);
        if (this.nativeAds == null) {
            YFLog.debug(this.tag + " nativeAds is null, return. ");
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_SHOW));
            return;
        }
        String templateKey = this.sdkSupplier.getTemplateKey(TemplateRes.SPLASH_V1);
        int template = TemplateRes.getTemplate(templateKey);
        if (template == 0) {
            handleRenderFailed(0, " addView error has no id");
            return;
        }
        AdxSplashTemplateData adxSplashTemplateData = new AdxSplashTemplateData(templateKey, isFullScreen());
        this.adxSplashTemplateData = adxSplashTemplateData;
        adxSplashTemplateData.setConf(this.sdkSupplier.getTemplateConf());
        View viewInflate = LayoutInflater.from(getContext()).inflate(template, (ViewGroup) null, false);
        this.isAuto = this.adxSplashTemplateData.isAutoClick();
        this.adxSplashViewHolder = new AdxSplashViewHolder(viewInflate, this.adxSplashTemplateData);
        if (isBidding()) {
            AbstractNativeAd abstractNativeAd = this.nativeAds;
            abstractNativeAd.setBidEcpm(abstractNativeAd.getECPM(), 0L);
        }
        bindData(activity, this.adxSplashTemplateData, this.adxSplashViewHolder);
        addViewLister(viewInflate);
        doShowAD(viewGroup, viewInflate);
    }

    public void startCountDown(long j, final AdxSplashViewHolder adxSplashViewHolder) {
        cancelCountDown();
        if (adxSplashViewHolder == null) {
            return;
        }
        if (j <= 0) {
            adapterClose(adxSplashViewHolder, false);
            return;
        }
        final String string = TextUtils.isEmpty(adxSplashViewHolder.closeTips) ? getContext().getString(R.string.jump_tip) : adxSplashViewHolder.closeTips;
        adxSplashViewHolder.setTevCountdown(String.format(string, Long.valueOf(j)));
        CountDownTimer countDownTimer = new CountDownTimer(j * 1000, 1000L) { // from class: com.yfanads.ads.chanel.adx.AdxSplashAdapter.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (AdxSplashAdapter.this.currentCountDownTime != 0) {
                    AdxSplashAdapter.this.cancelCountDown();
                    AdxSplashAdapter.this.adapterClose(adxSplashViewHolder, false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                AdxSplashAdapter.this.currentCountDownTime = (int) (j2 / 1000);
                adxSplashViewHolder.setTevCountdown(String.format(string, Integer.valueOf(AdxSplashAdapter.this.currentCountDownTime)));
                if (AdxSplashAdapter.this.currentCountDownTime == 0) {
                    AdxSplashAdapter.this.cancelCountDown();
                    AdxSplashAdapter.this.adapterClose(adxSplashViewHolder, false);
                }
            }
        };
        this.countDownTimer = countDownTimer;
        countDownTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelCountDown() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.countDownTimer = null;
        }
    }

    private void pauseVideo() {
        IPlayVideo iPlayVideo = this.playVideo;
        if (iPlayVideo != null) {
            iPlayVideo.pause();
        }
    }

    private void reStartVideo() {
        IPlayVideo iPlayVideo = this.playVideo;
        if (iPlayVideo != null) {
            iPlayVideo.reStart();
        }
    }

    private void stopTwistOrShake() {
        AbstractNativeAd abstractNativeAd = this.nativeAds;
        if (abstractNativeAd != null) {
            abstractNativeAd.stopInteraction();
        }
    }

    private void stopVideo() {
        IPlayVideo iPlayVideo = this.playVideo;
        if (iPlayVideo != null) {
            iPlayVideo.stop();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        AbstractNativeAd abstractNativeAd = this.nativeAds;
        if (abstractNativeAd != null) {
            abstractNativeAd.reportAdInfo(19, null);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=");
            SdkSupplier sdkSupplier2 = this.sdkSupplier;
            String shortString = "";
            StringBuilder sbAppend2 = sbAppend.append(sdkSupplier2 != null ? sdkSupplier2.toShortString() : "").append(" loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend2.append(shortString).toString());
        }
    }
}
