package com.yfanads.ads.chanel.adx;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.yfanads.android.core.toppush.YFTopPushSetting;
import com.yfanads.android.custom.TopPushCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.custom.view.AdTopPushViewHolder;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.TopPushTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxTopPushAdapter extends TopPushCustomAdapter implements AdxNativeAd.AdInteractionListener {
    private ImageView endVideoImg;
    private boolean isAuto;
    private boolean isDownloadDialogShow;
    AbstractNativeAd nativeAds;
    private IPlayVideo playVideo;
    private View slideView;

    public AdxTopPushAdapter(YFTopPushSetting yFTopPushSetting) {
        super(yFTopPushSetting);
    }

    private void bindImageViews(Activity activity, AdBaseViewHolder adBaseViewHolder, final AdxNativeAd adxNativeAd, Map<View, Integer> map, TopPushTemplateData topPushTemplateData) {
        if (activity != null) {
            adxNativeAd.registerViewForInteraction(activity, a.TOP_PUSH, adBaseViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(this.isAuto, topPushTemplateData), this);
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1039xeae084f1(fragmentManager, adxNativeAd, view);
                }
            });
        }
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, final AbstractNativeAd abstractNativeAd, Map<View, Integer> map, TopPushTemplateData topPushTemplateData) {
        if (activity != null) {
            abstractNativeAd.registerViewForInteraction(activity, a.TOP_PUSH, adBaseViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(this.isAuto, topPushTemplateData), this);
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1040x141a1cb0(fragmentManager, abstractNativeAd, view);
                }
            });
        }
        IPlayVideo videoView2 = abstractNativeAd.getVideoView2(getContext(), new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ topPushTemplateData.isMute()).build());
        this.playVideo = videoView2;
        if (videoView2 == null) {
            com.yfanads.android.adx.utils.a.a("playVideo == null");
            return;
        }
        final View view = videoView2.getView();
        com.yfanads.android.adx.utils.a.a(this.tag + " bindMediaView videoView:" + view);
        abstractNativeAd.setVideoPlayListener(new AdxNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter.4
            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                AdxTopPushAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder);
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                AdxTopPushAdapter.this.updateWithVideoPlayStart(adBaseViewHolder, abstractNativeAd, view);
            }
        });
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
        AdxSDK.getLoadManager().loadNativeAd(new AdxScene.Builder(AdxSdkUtil.getAdId(this.sdkSupplier)).adNum(1).setEcpm(getEcpm()).setReqId(getRequestId()).adStyle(2).build(), new LoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter.2
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(AdxTopPushAdapter.this.tag + " onError " + i + str);
                AdxTopPushAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0048 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0048), top: B:16:0x001e }] */
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onNativeAdLoad(List<AdxNativeAd> list) {
                YFLog.high(AdxTopPushAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() == 0 || list.get(0) == null) {
                            AdxTopPushAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            AdxTopPushAdapter.this.nativeAds = (AbstractNativeAd) list.get(0);
                            AdxTopPushAdapter adxTopPushAdapter = AdxTopPushAdapter.this;
                            adxTopPushAdapter.setEcpm(adxTopPushAdapter.nativeAds.getECPM());
                            AdxTopPushAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        AdxTopPushAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    AdxTopPushAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    private void registerViewForInteraction(Activity activity, AdTopPushViewHolder adTopPushViewHolder, TopPushTemplateData topPushTemplateData, boolean z, AbstractNativeAd abstractNativeAd) {
        HashMap map = new HashMap();
        if (topPushTemplateData.isActionType(BaseTemplateData.InteractiveStyle.CLICK_SLIDE.getValue())) {
            map.put(adTopPushViewHolder.viewGroup, 6);
        } else {
            map.put(adTopPushViewHolder.viewGroup, 4);
        }
        View view = adTopPushViewHolder.adCloseDelay;
        if (view != null) {
            map.put(view, 4);
        }
        if (z) {
            bindMediaView(activity, adTopPushViewHolder, abstractNativeAd, map, topPushTemplateData);
        } else {
            bindImageViews(activity, adTopPushViewHolder, abstractNativeAd, map, topPushTemplateData);
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
                    this.nativeAds.getEndVideoBitmap(new AdxNativeAd.AdEndBitmap() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter$$ExternalSyntheticLambda3
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithVideoPlayStart(final AdBaseViewHolder adBaseViewHolder, final AbstractNativeAd abstractNativeAd, final View view) {
        adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1041xef77b41e(adBaseViewHolder, abstractNativeAd, view);
            }
        });
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void bindData(Activity activity, TopPushTemplateData topPushTemplateData, final AdBaseViewHolder adBaseViewHolder) {
        boolean zIsVideo = isVideo();
        this.isAuto = topPushTemplateData.isAutoClick();
        AdTopPushViewHolder adTopPushViewHolder = (AdTopPushViewHolder) adBaseViewHolder;
        YFLog.high("bindData  isVideo " + zIsVideo + " isSupportShake " + this.isSupportShake);
        AdxImage adxImage = !YFListUtils.isEmpty(this.nativeAds.getImageList()) ? this.nativeAds.getImageList().get(0) : null;
        if (zIsVideo) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (this.nativeAds.getVideoCoverImage() == null || TextUtils.isEmpty(this.nativeAds.getVideoCoverImage().getImageUrl())) {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            } else {
                ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adBaseViewHolder.imageBlur, 0);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (adxImage != null && adxImage.isValid() && !TextUtils.isEmpty(adxImage.getImageUrl())) {
                adBaseViewHolder.showImageArea.setVisibility(4);
                YFLog.debug(this.tag + " showNativeADs image size = " + adxImage.getWidth() + " , " + adxImage.getHeight());
                ViewUtils.loadBlurImage(adxImage.getImageUrl(), adBaseViewHolder.imageBlur, 0);
                ViewUtils.loadImage(adxImage.getImageUrl(), adBaseViewHolder.showImg, new ViewUtils.ViewImageCallback() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter$$ExternalSyntheticLambda1
                    @Override // com.yfanads.android.utils.ViewUtils.ViewImageCallback
                    public final void onResourceReady() {
                        adBaseViewHolder.showImageArea.setVisibility(0);
                    }
                });
            }
        }
        String adDescription = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getAdDescription() : this.nativeAds.getTitle();
        String title = TextUtils.isEmpty(this.nativeAds.getAdDescription()) ? this.nativeAds.getTitle() : this.nativeAds.getAdDescription();
        if (topPushTemplateData.isReplaceTitle()) {
            if (!TextUtils.isEmpty(topPushTemplateData.getReplaceTitle())) {
                adDescription = topPushTemplateData.getReplaceTitle();
            }
            if (!TextUtils.isEmpty(topPushTemplateData.getReplaceDesc())) {
                title = topPushTemplateData.getReplaceDesc();
            }
        }
        TextView textView = adTopPushViewHolder.titleDes;
        if (adDescription == null) {
            adDescription = "";
        }
        textView.setText(adDescription);
        String appIconUrl = this.nativeAds.getAppIconUrl();
        if (TextUtils.isEmpty(appIconUrl) && adxImage != null && adxImage.isValid() && !TextUtils.isEmpty(adxImage.getImageUrl())) {
            appIconUrl = adxImage.getImageUrl();
        }
        YFLog.debug(this.tag + " bindData icon " + appIconUrl);
        ViewUtils.loadCircleImage(appIconUrl, adTopPushViewHolder.adIcon, 8);
        topPushTemplateData.updAdLog(R.mipmap.yf_ad_logo_v3);
        adTopPushViewHolder.updateShowView(getContext(), topPushTemplateData);
        TextView textView2 = adBaseViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView2.setText(title);
        adBaseViewHolder.getCloseView(topPushTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1038lambda$bindData$1$comyfanadsadschaneladxAdxTopPushAdapter(view);
            }
        });
        registerViewForInteraction(activity, adTopPushViewHolder, topPushTemplateData, zIsVideo, this.nativeAds);
        complianceContent(adBaseViewHolder, this.nativeAds);
        startCountDown(adBaseViewHolder, topPushTemplateData);
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void closeAds() {
        super.closeAds();
        try {
            if (this.nativeAds != null) {
                if (isVideo()) {
                    this.nativeAds.reportAdInfo(18, null);
                }
                this.nativeAds.destroy(a.TOP_PUSH);
                this.nativeAds = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        AbstractNativeAd abstractNativeAd = this.nativeAds;
        if (abstractNativeAd != null) {
            abstractNativeAd.destroy(a.TOP_PUSH);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        AdxSdkUtil.initAD(this.tag, context, getInitBean(), isListPackage(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                AdxTopPushAdapter.this.handleFailed(str, str2);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                AdxTopPushAdapter.this.loadByNative();
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
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

    /* JADX INFO: renamed from: lambda$bindImageViews$3$com-yfanads-ads-chanel-adx-AdxTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1039xeae084f1(FragmentManager fragmentManager, final AdxNativeAd adxNativeAd, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new OnFeedClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter.5
            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onDismiss() {
            }

            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onTraceFeed() {
                adxNativeAd.traceData(((TopPushCustomAdapter) AdxTopPushAdapter.this).sdkSupplier != null ? ((TopPushCustomAdapter) AdxTopPushAdapter.this).sdkSupplier.getTemplateConf() : null, new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(((TopPushCustomAdapter) AdxTopPushAdapter.this).sdkSupplier), AdxTopPushAdapter.this.getRequestId()), false);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$2$com-yfanads-ads-chanel-adx-AdxTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1040x141a1cb0(FragmentManager fragmentManager, final AbstractNativeAd abstractNativeAd, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new OnFeedClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxTopPushAdapter.3
            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onDismiss() {
            }

            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onTraceFeed() {
                abstractNativeAd.traceData(((TopPushCustomAdapter) AdxTopPushAdapter.this).sdkSupplier != null ? ((TopPushCustomAdapter) AdxTopPushAdapter.this).sdkSupplier.getTemplateConf() : null, new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(((TopPushCustomAdapter) AdxTopPushAdapter.this).sdkSupplier), AdxTopPushAdapter.this.getRequestId()), false);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateWithVideoPlayStart$4$com-yfanads-ads-chanel-adx-AdxTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1041xef77b41e(AdBaseViewHolder adBaseViewHolder, AbstractNativeAd abstractNativeAd, View view) {
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int videoWidth = abstractNativeAd != null ? abstractNativeAd.getVideoWidth() : 0;
        int videoHeight = abstractNativeAd != null ? abstractNativeAd.getVideoHeight() : 0;
        if (adBaseViewHolder instanceof AdTopPushViewHolder) {
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

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onAdShakeSuccess(boolean z, boolean z2, boolean z3) {
        YFLog.high("onAdShakeSuccess " + z + "|" + z2);
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

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onDownloadTipsDismiss() {
        YFLog.high("onDownloadTipsDismiss");
        this.isDownloadDialogShow = false;
        reStartVideo();
        closeAdsDelay();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
    public void onDownloadTipsShow() {
        YFLog.high("onDownloadTipsShow");
        this.isDownloadDialogShow = true;
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

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-adx-AdxTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1038lambda$bindData$1$comyfanadsadschaneladxAdxTopPushAdapter(View view) {
        AbstractNativeAd abstractNativeAd = this.nativeAds;
        if (abstractNativeAd != null) {
            abstractNativeAd.unRegisterViewAction();
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
}
