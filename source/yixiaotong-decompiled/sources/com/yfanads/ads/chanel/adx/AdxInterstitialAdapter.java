package com.yfanads.ads.chanel.adx;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.huawei.openalliance.ad.constant.ai;
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
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.AbsCallback;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.thirdpart.lottie.LottieAnimationView;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.model.template.InterV3TemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFConfigUtils;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxInterstitialAdapter extends InterstitialCustomAdapter implements AdxNativeAd.AdInteractionListener {
    private ImageView endVideoImg;
    private boolean isAuto;
    private boolean isDownloadDialogShow;
    boolean isInterV2;
    private boolean isShakeAction;
    private boolean isShakeActionOne;
    AbstractNativeAd nativeAds;
    private IPlayVideo playVideo;
    private View slideView;
    private InterTemplateData templateData;

    public static class AdInteractionListener extends AbsCallback<AdxInterstitialAdapter> implements AdxNativeAd.AdInteractionListener {
        private final SoftReference<AdBaseViewHolder> viewHolder;

        public AdInteractionListener(AdxInterstitialAdapter adxInterstitialAdapter, AdBaseViewHolder adBaseViewHolder) {
            super(adxInterstitialAdapter);
            this.viewHolder = new SoftReference<>(adBaseViewHolder);
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (get() != null) {
                return get().handleDownloadDialog(onClickListener);
            }
            return false;
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdClickedSuccess(boolean z, boolean z2, boolean z3) {
            if (get() != null) {
                get().onAdClickedSuccess(z, z2, z3);
            }
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdHide() {
            if (get() != null) {
                get().onAdHide();
            }
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdShakeCancel() {
            if (get() != null) {
                get().onAdShakeCancel(this.viewHolder.get());
            }
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdShakeSuccess(boolean z, boolean z2, boolean z3) {
            if (get() != null) {
                get().onAdShakeSuccess(z, z2, this.viewHolder.get(), z3);
            }
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdShow() {
            if (get() != null) {
                get().onAdShow();
            }
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onDownloadTipsDismiss() {
            if (get() != null) {
                get().onDownloadTipsDismiss();
            }
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onDownloadTipsShow() {
            if (get() != null) {
                get().onDownloadTipsShow();
            }
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onExposure(boolean z) {
            if (get() != null) {
                get().onExposure(z);
            }
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onHandleClick(boolean z) {
            if (get() != null) {
                get().onHandleClick(z);
            }
        }
    }

    public AdxInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
        this.isInterV2 = false;
    }

    private int actionClickType(BaseTemplateData.InteractiveStyle interactiveStyle) {
        return (interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SHAKE || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_TWIST || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_V3) ? 4 : 0;
    }

    private int actionType(BaseTemplateData.InteractiveStyle interactiveStyle) {
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

    private void bindImageViews(Activity activity, AdBaseViewHolder adBaseViewHolder, final AdxNativeAd adxNativeAd, Map<View, Integer> map, InterTemplateData interTemplateData) {
        if (activity != null) {
            adxNativeAd.registerViewForInteraction(activity, a.INTERSTITIAL, adBaseViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(this.isAuto, interTemplateData), new AdInteractionListener(this, adBaseViewHolder));
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1018x9aa2b37(fragmentManager, adxNativeAd, view);
                }
            });
        }
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, final AbstractNativeAd abstractNativeAd, Map<View, Integer> map, InterTemplateData interTemplateData) {
        if (activity != null) {
            abstractNativeAd.registerViewForInteraction(activity, a.INTERSTITIAL, adBaseViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(this.isAuto, interTemplateData), new AdInteractionListener(this, adBaseViewHolder));
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1019xadc492d8(fragmentManager, abstractNativeAd, view);
                }
            });
        }
        IPlayVideo videoView2 = abstractNativeAd.getVideoView2(getContext(), new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ interTemplateData.isMute()).build());
        this.playVideo = videoView2;
        if (videoView2 == null) {
            com.yfanads.android.adx.utils.a.a("playVideo == null");
        } else {
            final View view = videoView2.getView();
            abstractNativeAd.setVideoPlayListener(new AdxNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter.4
                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
                public void onVideoPlayComplete() {
                    AdxInterstitialAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder);
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
                public void onVideoPlayError(int i, int i2) {
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
                public void onVideoPlayStart() {
                    AdxInterstitialAdapter.this.updateWithVideoPlayStart(adBaseViewHolder, abstractNativeAd, view);
                }
            });
        }
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder, AdxNativeAd adxNativeAd) {
        if (adxNativeAd.getInteractionType() == 1) {
            complianceView(adBaseViewHolder, new DownloadAppInfo(adxNativeAd.getAppName(), adxNativeAd.getAppVersion(), adxNativeAd.getCorporationName(), adxNativeAd.getIntroductionInfoUrl(), adxNativeAd.getPermissionInfoUrl(), adxNativeAd.getAppPrivacyUrl()));
        } else {
            adBaseViewHolder.complianceContent.setVisibility(8);
        }
    }

    private boolean isVideo() {
        return this.nativeAds.getMaterialType() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadByNative() {
        AdxSDK.getLoadManager().loadNativeAd(new AdxScene.Builder(AdxSdkUtil.getAdId(this.sdkSupplier)).adNum(1).setEcpm(getEcpm()).setReqId(getRequestId()).adStyle(3).build(), new LoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter.2
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(AdxInterstitialAdapter.this.tag + " onError " + i + str);
                AdxInterstitialAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0048 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0048), top: B:16:0x001e }] */
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onNativeAdLoad(List<AdxNativeAd> list) {
                YFLog.high(AdxInterstitialAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() == 0 || list.get(0) == null) {
                            AdxInterstitialAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            AdxInterstitialAdapter.this.nativeAds = (AbstractNativeAd) list.get(0);
                            AdxInterstitialAdapter adxInterstitialAdapter = AdxInterstitialAdapter.this;
                            adxInterstitialAdapter.setEcpm(adxInterstitialAdapter.nativeAds.getECPM());
                            AdxInterstitialAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        AdxInterstitialAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    AdxInterstitialAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    private boolean needUpdateAction() {
        return this.isShakeAction && this.isShakeActionOne;
    }

    private void registerViewForInteraction(Activity activity, AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, boolean z, AbstractNativeAd abstractNativeAd, BaseTemplateData.InteractiveStyle interactiveStyle, int i) {
        final HashMap map = new HashMap();
        if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            int iActionType = actionType(interactiveStyle);
            int iActionClickType = actionClickType(interactiveStyle);
            map.put(adInterV2ViewHolder.dyClickView, 4);
            map.put(adInterV2ViewHolder.barView, Integer.valueOf(iActionClickType));
            map.put(adInterV2ViewHolder.animationSlideView, Integer.valueOf(iActionType));
            map.put(adInterV2ViewHolder.animationClickView, 5);
            adInterV2ViewHolder.updateBarClickable(interTemplateData.isActionClickType());
            adBaseViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
        } else if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            int iActionType2 = actionType(interactiveStyle);
            int iActionClickType2 = actionClickType(interactiveStyle);
            if (interTemplateData instanceof InterV3TemplateData) {
                BaseTemplateData baseTemplateData = (InterV3TemplateData) interTemplateData;
                if (iActionClickType2 == 4) {
                    YFOptional.ofNullable(adInterV3ViewHolder.barView).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda1
                        @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
                        public final void accept(Object obj) {
                            map.put((LottieAnimationView) obj, 5);
                        }
                    });
                    YFOptional.ofNullable(adInterV3ViewHolder.actionView).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda2
                        @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
                        public final void accept(Object obj) {
                            map.put((LottieAnimationView) obj, 5);
                        }
                    });
                } else {
                    YFOptional.ofNullable(adInterV3ViewHolder.barView).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda3
                        @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
                        public final void accept(Object obj) {
                            map.put((LottieAnimationView) obj, 5);
                        }
                    });
                    adBaseViewHolder.updateBarClickable(false);
                }
                if (baseTemplateData.isWholeClick()) {
                    map.put(adInterV3ViewHolder.viewGroup, 4);
                    if (iActionType2 == 3 || iActionType2 == 6) {
                        map.put(updateSlideView(baseTemplateData, adInterV3ViewHolder), Integer.valueOf(iActionType2));
                    } else {
                        map.put(adInterV3ViewHolder.animationSlideView, Integer.valueOf(iActionType2));
                    }
                } else if (iActionType2 == 3 || iActionType2 == 6) {
                    map.put(updateSlideView(baseTemplateData, adInterV3ViewHolder), Integer.valueOf(iActionType2));
                } else {
                    map.put(adInterV3ViewHolder.animationSlideView, Integer.valueOf(iActionType2));
                }
                map.put(adInterV3ViewHolder.adCloseDelay, 4);
            }
        }
        if (z) {
            bindMediaView(activity, adBaseViewHolder, abstractNativeAd, map, interTemplateData);
        } else {
            bindImageViews(activity, adBaseViewHolder, abstractNativeAd, map, interTemplateData);
        }
    }

    private void updActionShake(AdBaseViewHolder adBaseViewHolder) {
        this.templateData.resetActivityStyle(this.isInterV2 ? BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue() : BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        updateShakeAction(this.templateData);
        YFOptional.ofNullable(adBaseViewHolder).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda7
            @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
            public final void accept(Object obj) {
                this.f$0.m1020x37f1b8b5((AdBaseViewHolder) obj);
            }
        });
        YFOptional.ofNullable(this.nativeAds).ifPresentRun(new AdxInterstitialAdapter$$ExternalSyntheticLambda8());
    }

    private void updateShakeAction(BaseTemplateData baseTemplateData) {
        this.isShakeActionOne = baseTemplateData.isActionOne();
        this.isShakeAction = baseTemplateData.isShake() || baseTemplateData.isTwist();
    }

    private View updateSlideView(BaseTemplateData baseTemplateData, AdInterV3ViewHolder adInterV3ViewHolder) {
        int i = (int) (((double) baseTemplateData.popWidth) * 0.7d);
        int i2 = (int) (((double) i) * 1.4d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        this.slideView = new View(getContext());
        layoutParams.addRule(14);
        layoutParams.addRule(8, R.id.animator_area);
        this.slideView.setLayoutParams(layoutParams);
        layoutParams.bottomMargin = i2 / 6;
        adInterV3ViewHolder.viewGroup.addView(this.slideView);
        if (YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "debug", false)) {
            this.slideView.setBackgroundColor(Color.parseColor("#22ff0000"));
        }
        return this.slideView;
    }

    private void updateVideoView(AdBaseViewHolder adBaseViewHolder) {
        if (this.nativeAds != null && isVideo() && (adBaseViewHolder instanceof AdInterV3ViewHolder)) {
            final AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            adInterV3ViewHolder.showArea.post(new Runnable() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1021x6bdd5bde(adInterV3ViewHolder);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithVideoPlayComplete(AdBaseViewHolder adBaseViewHolder) {
        try {
            int width = adBaseViewHolder.mediaViewFrame.getWidth();
            int height = adBaseViewHolder.mediaViewFrame.getHeight();
            YFLog.high("Interstitial onVideoPlayComplete width " + width + " , height = " + height);
            final ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            AbstractNativeAd abstractNativeAd = this.nativeAds;
            if (abstractNativeAd != null) {
                if (abstractNativeAd.getEndVideoCoverImage() == null || TextUtils.isEmpty(this.nativeAds.getEndVideoCoverImage().getImageUrl())) {
                    this.nativeAds.getEndVideoBitmap(new AdxNativeAd.AdEndBitmap() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda5
                        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdEndBitmap
                        public final void onGetData(Bitmap bitmap) {
                            imageView.setImageBitmap(bitmap);
                        }
                    }, width, height);
                } else {
                    ViewUtils.loadImage(this.nativeAds.getEndVideoCoverImage().getImageUrl(), imageView);
                }
                adBaseViewHolder.mediaViewFrame.addView(imageView);
                if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
                    this.endVideoImg = imageView;
                }
            }
        } catch (Exception unused) {
            YFLog.error(this.tag + " updateWithVideoPlayComplete error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithVideoPlayStart(final AdBaseViewHolder adBaseViewHolder, final AbstractNativeAd abstractNativeAd, final View view) {
        adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1022xcc02702a(adBaseViewHolder, abstractNativeAd, view);
            }
        });
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, final AdBaseViewHolder adBaseViewHolder) {
        AdxImage adxImage;
        try {
            final boolean zIsVideo = isVideo();
            this.templateData = interTemplateData;
            this.isAuto = interTemplateData.isAutoClick();
            updateShakeAction(interTemplateData);
            this.isInterV2 = adBaseViewHolder instanceof AdInterV2ViewHolder;
            if (!this.isSupportShake && interTemplateData.isAction()) {
                if (interTemplateData.isOnlyAction()) {
                    interTemplateData.setWholeClick();
                }
                interTemplateData.resetActivityStyle(this.isInterV2 ? BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue() : BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
            }
            YFLog.high("bindData  isVideo " + zIsVideo + " isSupportShake " + this.isSupportShake);
            boolean z = false;
            if (zIsVideo) {
                adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
                if (this.nativeAds.getVideoCoverImage() == null || TextUtils.isEmpty(this.nativeAds.getVideoCoverImage().getImageUrl())) {
                    ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
                } else {
                    ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adBaseViewHolder.imageBlur, this.isInterV2 ? 20 : 0);
                }
            } else {
                adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
                if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (adxImage = this.nativeAds.getImageList().get(0)) != null && adxImage.isValid() && !TextUtils.isEmpty(adxImage.getImageUrl())) {
                    adBaseViewHolder.showImageArea.setVisibility(4);
                    YFLog.debug(this.tag + " showNativeADs image size = " + adxImage.getWidth() + " , " + adxImage.getHeight());
                    ViewUtils.loadBlurImage(adxImage.getImageUrl(), adBaseViewHolder.imageBlur, this.isInterV2 ? 20 : 0);
                    if (this.isInterV2 && ViewUtils.isHorizontal(adxImage.getWidth(), adxImage.getHeight())) {
                        setHBackground(adBaseViewHolder.showImageArea);
                        z = true;
                    }
                    ViewUtils.loadImage(adxImage.getImageUrl(), adBaseViewHolder.showImg, new ViewUtils.ViewImageCallback() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda0
                        @Override // com.yfanads.android.utils.ViewUtils.ViewImageCallback
                        public final void onResourceReady() {
                            adBaseViewHolder.showImageArea.setVisibility(0);
                        }
                    });
                }
            }
            String adDescription = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getAdDescription() : this.nativeAds.getTitle();
            String title = TextUtils.isEmpty(this.nativeAds.getAdDescription()) ? this.nativeAds.getTitle() : this.nativeAds.getAdDescription();
            if (this.isInterV2) {
                AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
                if (z) {
                    ((AdInterV2ViewHolder) adBaseViewHolder).showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_SMALL);
                } else {
                    ((AdInterV2ViewHolder) adBaseViewHolder).showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_BIG);
                }
                ViewUtils.loadCircleImage(this.nativeAds.getAppIconUrl(), adInterV2ViewHolder.adIcon, 20);
                TextView textView = adInterV2ViewHolder.adIconName;
                if (adDescription == null) {
                    adDescription = "";
                }
                textView.setText(adDescription);
            } else {
                AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
                ViewUtils.loadCircleImage(this.nativeAds.getAppIconUrl(), adInterV3ViewHolder.adIcon, 20);
                TextView textView2 = adInterV3ViewHolder.adIconName;
                if (adDescription == null) {
                    adDescription = "";
                }
                textView2.setText(adDescription);
            }
            TextView textView3 = adBaseViewHolder.adDes;
            if (title == null) {
                title = "";
            }
            textView3.setText(title);
            interTemplateData.setAdx(true);
            interTemplateData.updAdLog(R.mipmap.yf_ad_logo);
            adBaseViewHolder.updateShowView(getContext(), interTemplateData);
            adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1017x54bb76c7(zIsVideo, view);
                }
            });
            registerViewForInteraction(activity, adBaseViewHolder, interTemplateData, zIsVideo, this.nativeAds, interTemplateData.getActiveStyle(), interTemplateData.popHeight);
            complianceContent(adBaseViewHolder, this.nativeAds);
            startCountDown(adBaseViewHolder, interTemplateData);
        } catch (Exception e) {
            YFLog.error(this.tag + " bindData error " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void closeAds(boolean z) {
        release();
        super.closeAds(z);
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        YFLog.debug(this.tag + " start destroy");
        AbstractNativeAd abstractNativeAd = this.nativeAds;
        if (abstractNativeAd != null) {
            abstractNativeAd.destroy(a.INTERSTITIAL);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        AdxSdkUtil.initAD(this.tag, context, getInitBean(), isListPackage(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                AdxInterstitialAdapter.this.handleFailed(str, str2);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                AdxInterstitialAdapter.this.loadByNative();
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        showNativeADs(activity);
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

    /* JADX INFO: renamed from: lambda$bindImageViews$8$com-yfanads-ads-chanel-adx-AdxInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1018x9aa2b37(FragmentManager fragmentManager, final AdxNativeAd adxNativeAd, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new OnFeedClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter.5
            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onDismiss() {
            }

            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onTraceFeed() {
                adxNativeAd.traceData(((InterstitialCustomAdapter) AdxInterstitialAdapter.this).sdkSupplier != null ? ((InterstitialCustomAdapter) AdxInterstitialAdapter.this).sdkSupplier.getTemplateConf() : null, new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(((InterstitialCustomAdapter) AdxInterstitialAdapter.this).sdkSupplier), AdxInterstitialAdapter.this.getRequestId()), false);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$7$com-yfanads-ads-chanel-adx-AdxInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1019xadc492d8(FragmentManager fragmentManager, final AbstractNativeAd abstractNativeAd, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new OnFeedClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxInterstitialAdapter.3
            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onDismiss() {
            }

            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onTraceFeed() {
                abstractNativeAd.traceData(((InterstitialCustomAdapter) AdxInterstitialAdapter.this).sdkSupplier != null ? ((InterstitialCustomAdapter) AdxInterstitialAdapter.this).sdkSupplier.getTemplateConf() : null, new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(((InterstitialCustomAdapter) AdxInterstitialAdapter.this).sdkSupplier), AdxInterstitialAdapter.this.getRequestId()), false);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updActionShake$10$com-yfanads-ads-chanel-adx-AdxInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1020x37f1b8b5(AdBaseViewHolder adBaseViewHolder) {
        adBaseViewHolder.updateInteraction(getContext(), this.templateData);
        adBaseViewHolder.updateBarClickable(true);
    }

    /* JADX INFO: renamed from: lambda$updateVideoView$2$com-yfanads-ads-chanel-adx-AdxInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1021x6bdd5bde(AdInterV3ViewHolder adInterV3ViewHolder) {
        int width = adInterV3ViewHolder.showArea.getWidth();
        int height = adInterV3ViewHolder.showArea.getHeight();
        AbstractNativeAd abstractNativeAd = this.nativeAds;
        int videoWidth = abstractNativeAd != null ? abstractNativeAd.getVideoWidth() : 0;
        AbstractNativeAd abstractNativeAd2 = this.nativeAds;
        updateMaterialArea(adInterV3ViewHolder.mediaViewFrame, width, height, videoWidth, abstractNativeAd2 != null ? abstractNativeAd2.getVideoHeight() : 0);
        ImageView imageView = this.endVideoImg;
        if (imageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
        }
    }

    /* JADX INFO: renamed from: lambda$updateWithVideoPlayStart$9$com-yfanads-ads-chanel-adx-AdxInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1022xcc02702a(AdBaseViewHolder adBaseViewHolder, AbstractNativeAd abstractNativeAd, View view) {
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int videoWidth = abstractNativeAd != null ? abstractNativeAd.getVideoWidth() : 0;
        int videoHeight = abstractNativeAd != null ? abstractNativeAd.getVideoHeight() : 0;
        if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, height, videoWidth, videoHeight);
        } else {
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, width, (int) (((double) width) / (((double) videoWidth) / ((double) videoHeight))));
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adBaseViewHolder.mediaViewFrame.removeAllViews();
        adBaseViewHolder.mediaViewFrame.addView(view);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdClickedSuccess(boolean z, boolean z2, boolean z3) {
        YFLog.high("onAdClickedSuccess " + z + "|" + z2);
        if (!z2 && !z3) {
            stopTwistOrShake();
        }
        if (this.isDownloadDialogShow) {
            return;
        }
        if (z2) {
            downLoadToast();
        }
        closeAdsDelay(z2 ? ai.af : 200);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdHide() {
        pauseVideo();
        stopTwistOrShake();
    }

    public void onAdShakeCancel(AdBaseViewHolder adBaseViewHolder) {
        if (needUpdateAction()) {
            updActionShake(adBaseViewHolder);
        }
    }

    public void onAdShakeSuccess(boolean z, boolean z2, AdBaseViewHolder adBaseViewHolder, boolean z3) {
        boolean zNeedUpdateAction = needUpdateAction();
        YFLog.high("onAdShakeSuccess " + z + "|" + z2 + "|" + zNeedUpdateAction);
        if (zNeedUpdateAction) {
            updActionShake(adBaseViewHolder);
        }
        if (zNeedUpdateAction || (!z2 && !z3)) {
            stopTwistOrShake();
        }
        if (this.isDownloadDialogShow) {
            return;
        }
        if (z2) {
            downLoadToast();
        }
        closeAdsDelay(z2 ? ai.af : 200);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdShow() {
        com.yfanads.android.adx.utils.a.a(" onAdShow ");
        if (this.isDownloadDialogShow) {
            pauseVideo();
        } else {
            reStartVideo();
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void onAdapterConfigurationChanged(AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, int i) {
        super.onAdapterConfigurationChanged(adBaseViewHolder, interTemplateData, i);
        updateSlideView(interTemplateData);
        updateVideoView(adBaseViewHolder);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onDownloadTipsDismiss() {
        YFLog.high("onDownloadTipsDismiss");
        if (this.isDownloadDialogShow) {
            this.isDownloadDialogShow = false;
            reStartVideo();
            reStartCountDown();
            closeAdsDelay();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onDownloadTipsShow() {
        YFLog.high("onDownloadTipsShow");
        this.isDownloadDialogShow = true;
        pauseVideo();
        pauseCountDown();
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
        YFLog.debug(this.tag + " onHandleClick");
        handleClick(z);
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

    private void release() {
        try {
            AbstractNativeAd abstractNativeAd = this.nativeAds;
            if (abstractNativeAd != null) {
                abstractNativeAd.destroy(a.INTERSTITIAL);
                this.nativeAds = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " release error." + e.getMessage());
        }
    }

    private void showNativeADs(Activity activity) {
        if (this.nativeAds == null) {
            YFLog.debug(this.tag + " nativeAds is null, return. ");
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_NATIVE));
            return;
        }
        if (isBidding()) {
            AbstractNativeAd abstractNativeAd = this.nativeAds;
            abstractNativeAd.setBidEcpm(abstractNativeAd.getECPM(), 0L);
        }
        YFLog.debug(this.tag + " adId=" + this.sdkSupplier.getAdId() + " showNativeADs=" + this.nativeAds.getMaterialType() + " showAd=" + addView(activity));
    }

    private void stopTwistOrShake() {
        AbstractNativeAd abstractNativeAd = this.nativeAds;
        if (abstractNativeAd != null) {
            abstractNativeAd.stopInteraction();
        }
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-adx-AdxInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1017x54bb76c7(boolean z, View view) {
        AbstractNativeAd abstractNativeAd = this.nativeAds;
        if (abstractNativeAd != null) {
            abstractNativeAd.unRegisterViewAction();
            if (z) {
                this.nativeAds.reportAdInfo(18, null);
            }
        }
        closeAds();
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

    private void updateSlideView(BaseTemplateData baseTemplateData) {
        View view = this.slideView;
        if (view == null) {
            return;
        }
        int i = (int) (((double) baseTemplateData.popWidth) * 0.7d);
        int i2 = (int) (((double) i) * 1.4d);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.bottomMargin = i2 / 6;
        this.slideView.setLayoutParams(layoutParams);
    }
}
