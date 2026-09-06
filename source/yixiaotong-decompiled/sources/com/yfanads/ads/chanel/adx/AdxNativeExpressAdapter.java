package com.yfanads.ads.chanel.adx;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.yfanads.ads.chanel.adx.model.AdxNativeAds;
import com.yfanads.ads.chanel.adx.utils.AdxSdkUtil;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.model.AdxImage;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.service.a;
import com.yfanads.android.adx.service.c;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.thirdpart.lottie.LottieAnimationView;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxNativeExpressAdapter extends NativeExpressCustomAdapter implements YFNativeCall {
    private boolean isAuto;
    private boolean isShakeAction;
    private boolean isShakeActionOne;
    List<AdxNativeAd> nativeAds2;

    public static class AdxExpViewListener extends NativeExpressCustomAdapter.ExpViewListener<AdxNativeExpressAdapter> implements AdxNativeAd.AdInteractionListener {
        private final AdClickListener clickListener;
        private final int index;
        private boolean isDownloadDialogShow;
        private final ViewGroup viewGroup;

        public interface AdClickListener {
            void handleClick();
        }

        public AdxExpViewListener(int i, ViewGroup viewGroup, AdxNativeExpressAdapter adxNativeExpressAdapter, AdClickListener adClickListener) {
            super(adxNativeExpressAdapter);
            this.isDownloadDialogShow = false;
            this.index = i;
            this.viewGroup = viewGroup;
            this.clickListener = adClickListener;
        }

        private void updActionShake() {
            AdClickListener adClickListener;
            if (getAdapter() == null || !getAdapter().needUpdateAction() || (adClickListener = this.clickListener) == null) {
                return;
            }
            adClickListener.handleClick();
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdClickedSuccess(boolean z, boolean z2, boolean z3) {
            YFLog.high("onAdClickedSuccess " + z + "|" + z2);
            if (!z2 || this.isDownloadDialogShow) {
                return;
            }
            getAdapter().downLoadToast();
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdHide() {
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdShakeCancel() {
            updActionShake();
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdShakeSuccess(boolean z, boolean z2, boolean z3) {
            YFLog.high("onAdShakeSuccess " + z + "|" + z2);
            updActionShake();
            if (!z2 || this.isDownloadDialogShow) {
                return;
            }
            getAdapter().downLoadToast();
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdShow() {
            YFLog.high("onAdShow ~" + this.index);
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onDownloadTipsDismiss() {
            this.isDownloadDialogShow = false;
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onDownloadTipsShow() {
            this.isDownloadDialogShow = true;
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onExposure(boolean z) {
            if (z) {
                getAdapter().handleExposure();
            } else {
                getAdapter().handleFailed(YFAdError.ERROR_ADX_EXPOSURE, "exposure url empty");
            }
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onHandleClick(boolean z) {
            YFLog.debug("onHandleClick ~" + this.index);
            getAdapter().handleClick(this.index, z);
        }
    }

    public AdxNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    private void bindImageViews(Activity activity, final AdBannerViewHolder adBannerViewHolder, final AdxNativeAd adxNativeAd, final BannerTemplateData bannerTemplateData, Map<View, Integer> map, int i) {
        if (activity != null) {
            adxNativeAd.registerViewForInteraction(activity, a.NATIVE_EXPRESS, adBannerViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(this.isAuto, bannerTemplateData), new AdxExpViewListener(i, adBannerViewHolder.showArea, this, new AdxExpViewListener.AdClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter$$ExternalSyntheticLambda1
                @Override // com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter.AdxExpViewListener.AdClickListener
                public final void handleClick() {
                    this.f$0.m1025x268adc65(bannerTemplateData, adBannerViewHolder, adxNativeAd);
                }
            }));
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1026x546376c4(fragmentManager, adxNativeAd, view);
                }
            });
        }
        if (bannerTemplateData.isTemplateV3()) {
            adBannerViewHolder.showImg.post(new Runnable() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1027x823c1123(adxNativeAd, adBannerViewHolder);
                }
            });
        }
    }

    private void bindMediaView(Activity activity, final AdBannerViewHolder adBannerViewHolder, final AdxNativeAd adxNativeAd, final BannerTemplateData bannerTemplateData, Map<View, Integer> map, final int i) {
        if (activity != null) {
            adxNativeAd.registerViewForInteraction(activity, a.NATIVE_EXPRESS, adBannerViewHolder.viewGroup, map, new AdxNativeAd.InteractionConf(this.isAuto, bannerTemplateData), new AdxExpViewListener(i, adBannerViewHolder.showArea, this, new AdxExpViewListener.AdClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter$$ExternalSyntheticLambda7
                @Override // com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter.AdxExpViewListener.AdClickListener
                public final void handleClick() {
                    this.f$0.m1028xaa0c3426(bannerTemplateData, adBannerViewHolder, adxNativeAd);
                }
            }));
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1029xd7e4ce85(fragmentManager, adxNativeAd, view);
                }
            });
        }
        AdVideoPlayConfig adVideoPlayConfigBuild = new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(true ^ bannerTemplateData.isMute()).build();
        YFLog.debug(this.tag + "[video] bindMediaView videoPlayConfig.isVideoSoundEnable:" + adVideoPlayConfigBuild.isVideoSoundEnable());
        final View videoView = adxNativeAd.getVideoView(getContext(), adVideoPlayConfigBuild);
        adxNativeAd.setVideoPlayListener(new AdxNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter.4
            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                AdxNativeExpressAdapter.this.updateWithVideoPlayComplete(adBannerViewHolder, i);
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayError(int i2, int i3) {
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                AdxNativeExpressAdapter.this.updateWithVideoPlayStart(adBannerViewHolder, bannerTemplateData, adxNativeAd, videoView);
            }
        });
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, AdxNativeAd adxNativeAd) {
        if (adxNativeAd.getInteractionType() == 1) {
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(adxNativeAd.getAppName(), adxNativeAd.getAppVersion(), adxNativeAd.getCorporationName(), adxNativeAd.getIntroductionInfoUrl(), adxNativeAd.getPermissionInfoUrl(), adxNativeAd.getAppPrivacyUrl()));
        } else {
            adBannerViewHolder.complianceContent.setVisibility(8);
        }
    }

    private AdxNativeAd getAdNative(int i) {
        if (!YFListUtils.isEmpty(this.nativeAds2) && i < this.nativeAds2.size()) {
            return this.nativeAds2.get(i);
        }
        YFLog.error("bindData error " + i);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadByNative() {
        AdxSDK.getLoadManager().loadNativeAd(new AdxScene.Builder(AdxSdkUtil.getAdId(this.sdkSupplier)).setEcpm(getEcpm()).setReqId(getRequestId()).adStyle(2).build(), new LoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter.2
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(AdxNativeExpressAdapter.this.tag + " onError " + i + str);
                AdxNativeExpressAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0037 A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0037), top: B:16:0x001e }] */
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onNativeAdLoad(List<AdxNativeAd> list) {
                YFLog.high(AdxNativeExpressAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.isEmpty() || list.get(0) == null) {
                            AdxNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            AdxNativeExpressAdapter.this.updData(list);
                            AdxNativeExpressAdapter.this.handleSucceed();
                        }
                    } catch (Exception e) {
                        YFLog.warn(AdxNativeExpressAdapter.this.tag + "updData error" + e.getMessage());
                        AdxNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    AdxNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needUpdateAction() {
        return this.isShakeAction && this.isShakeActionOne;
    }

    private void registerViewForInteraction(Activity activity, AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData, AdxNativeAd adxNativeAd, int i) {
        LottieAnimationView lottieAnimationView;
        HashMap map = new HashMap();
        if (bannerTemplateData.isTemplateV3()) {
            if (bannerTemplateData.isWholeClick()) {
                map.put(adBannerViewHolder.viewGroup, 4);
            }
            map.put(adBannerViewHolder.adCloseDelay, 4);
            if (bannerTemplateData.isShake()) {
                map.put(adBannerViewHolder.showArea, 1);
            }
        } else {
            View view = adBannerViewHolder.dyClickView;
            if (view != null) {
                map.put(view, 4);
            }
        }
        if (bannerTemplateData.isTitleDesClick()) {
            TextView textView = adBannerViewHolder.adDes;
            if (textView != null) {
                map.put(textView, 4);
            }
            TextView textView2 = adBannerViewHolder.titleDes;
            if (textView2 != null) {
                map.put(textView2, 4);
            }
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && (lottieAnimationView = adBannerViewHolder.mDownloadBar) != null) {
                map.put(lottieAnimationView, 5);
            }
            TextView textView3 = adBannerViewHolder.mDownload;
            if (textView3 != null) {
                map.put(textView3, 5);
            }
        }
        if (!z) {
            bindImageViews(activity, adBannerViewHolder, adxNativeAd, bannerTemplateData, map, i);
        } else {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(activity, adBannerViewHolder, adxNativeAd, bannerTemplateData, map, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updData(List<AdxNativeAd> list) {
        setEcpm(list.get(0).getECPM());
        if (!isDevelop()) {
            this.nativeAds2 = list;
            return;
        }
        this.developAds.clear();
        Iterator<AdxNativeAd> it = list.iterator();
        while (it.hasNext()) {
            this.developAds.add(new AdxNativeAds(it.next(), this.sdkSupplier.getTemplateConf(), this));
        }
    }

    private void updateDownload(BannerTemplateData bannerTemplateData, AdBannerViewHolder adBannerViewHolder, AdxNativeAd adxNativeAd) {
        if (!bannerTemplateData.showDownloadBtn()) {
            adBannerViewHolder.mDownload.setVisibility(8);
            return;
        }
        if (!bannerTemplateData.isTemplateV3()) {
            adBannerViewHolder.mDownload.setVisibility(0);
            adBannerViewHolder.mDownload.setText(TextUtils.isEmpty(adxNativeAd.getActionDescription()) ? getContext().getString(R.string.yf_default_download_text) : adxNativeAd.getActionDescription());
        } else if (bannerTemplateData.isShake()) {
            adBannerViewHolder.mDownload.setVisibility(8);
            adBannerViewHolder.mDownloadBar.setVisibility(0);
        } else {
            adBannerViewHolder.mDownload.setVisibility(0);
            adBannerViewHolder.mDownloadBar.setVisibility(8);
            adBannerViewHolder.mDownload.setText(TextUtils.isEmpty(adxNativeAd.getActionDescription()) ? getContext().getString(R.string.yf_default_download_text) : adxNativeAd.getActionDescription());
        }
    }

    private void updateShakeAction(BannerTemplateData bannerTemplateData) {
        this.isShakeActionOne = bannerTemplateData.isActionOne();
        this.isShakeAction = bannerTemplateData.isShake() || bannerTemplateData.isTwist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithVideoPlayComplete(AdBaseViewHolder adBaseViewHolder, int i) {
        try {
            int width = adBaseViewHolder.mediaViewFrame.getWidth();
            int height = adBaseViewHolder.mediaViewFrame.getHeight();
            YFLog.high("NativeExpress onVideoPlayComplete width " + width + " , height = " + height);
            final ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            AdxNativeAd adNative = getAdNative(i);
            if (adNative == null) {
                imageView.setBackgroundResource(R.mipmap.yf_ad_no_bg);
                adBaseViewHolder.mediaViewFrame.addView(imageView);
                return;
            }
            if (adNative.getEndVideoCoverImage() == null || TextUtils.isEmpty(adNative.getEndVideoCoverImage().getImageUrl())) {
                adNative.getEndVideoBitmap(new AdxNativeAd.AdEndBitmap() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter$$ExternalSyntheticLambda5
                    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdEndBitmap
                    public final void onGetData(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                }, width, height);
            } else {
                ViewUtils.loadImage(adNative.getEndVideoCoverImage().getImageUrl(), imageView);
            }
            adBaseViewHolder.mediaViewFrame.addView(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithVideoPlayStart(final AdBaseViewHolder adBaseViewHolder, final BannerTemplateData bannerTemplateData, final AdxNativeAd adxNativeAd, final View view) {
        adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1030x538a0114(adBaseViewHolder, adxNativeAd, bannerTemplateData, view);
            }
        });
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        AdxImage adxImage;
        final AdxNativeAd adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        final boolean z = adNative.getMaterialType() == 1;
        YFLog.high("bindData " + i + " isVideo " + z + " isSupportShake " + this.isSupportShake);
        if (!this.isSupportShake && bannerTemplateData.isAction()) {
            if (bannerTemplateData.isOnlyAction()) {
                bannerTemplateData.setWholeClick();
            }
            bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        this.isAuto = bannerTemplateData.isAutoClick();
        updateShakeAction(bannerTemplateData);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (adNative.getVideoCoverImage() == null || adNative.getVideoCoverImage().getImageUrl() == null) {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            } else {
                ViewUtils.loadBlurImage(adNative.getVideoCoverImage().getImageUrl(), adBannerViewHolder.imageBlur, 20);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!YFListUtils.isEmpty(adNative.getImageList()) && (adxImage = adNative.getImageList().get(0)) != null && adxImage.isValid() && !TextUtils.isEmpty(adxImage.getImageUrl())) {
                ViewUtils.loadBlurImage(adxImage.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(adxImage.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.setAdx(true);
        bannerTemplateData.updAdLog(R.mipmap.yf_ad_logo);
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        String adDescription = TextUtils.isEmpty(adNative.getTitle()) ? adNative.getAdDescription() : adNative.getTitle();
        String title = TextUtils.isEmpty(adNative.getAdDescription()) ? adNative.getTitle() : adNative.getAdDescription();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (adDescription == null) {
                adDescription = "";
            }
            textView.setText(adDescription);
        }
        TextView textView2 = adBannerViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView2.setText(title);
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(adNative.getAppIconUrl())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(adNative.getAppIconUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        updateDownload(bannerTemplateData, adBannerViewHolder, adNative);
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1024x99543793(z, adNative, i, view);
            }
        });
        registerViewForInteraction(activity, adBannerViewHolder, z, bannerTemplateData, adNative, i);
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        AdxSdkUtil.initAD(this.tag, context, getInitBean(), isListPackage(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                AdxNativeExpressAdapter.this.handleFailed(str, str2);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                AdxNativeExpressAdapter.this.loadByNative();
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        doShowNativeAd(activity);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (YFListUtils.isEmpty(this.nativeAds2)) {
            return (!isDevelop() || YFListUtils.isEmpty(this.developAds)) ? super.getAdInfo() : AdxSdkUtil.getAdInfo(this.developAds.get(0), getRequestId());
        }
        return AdxSdkUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 12;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.ADX.getValue();
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<AdxNativeAd> list = this.nativeAds2;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-adx-AdxNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1024x99543793(boolean z, AdxNativeAd adxNativeAd, int i, View view) {
        if (z) {
            adxNativeAd.reportAdInfo(18, null);
        }
        closeAds(i);
        adxNativeAd.unRegisterViewAction();
    }

    /* JADX INFO: renamed from: lambda$bindImageViews$5$com-yfanads-ads-chanel-adx-AdxNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1025x268adc65(BannerTemplateData bannerTemplateData, AdBannerViewHolder adBannerViewHolder, AdxNativeAd adxNativeAd) {
        bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        updateShakeAction(bannerTemplateData);
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        updateDownload(bannerTemplateData, adBannerViewHolder, adxNativeAd);
        YFOptional.ofNullable(adxNativeAd).ifPresentRun(new AdxNativeExpressAdapter$$ExternalSyntheticLambda9());
    }

    /* JADX INFO: renamed from: lambda$bindImageViews$6$com-yfanads-ads-chanel-adx-AdxNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1026x546376c4(FragmentManager fragmentManager, final AdxNativeAd adxNativeAd, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new OnFeedClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter.5
            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onDismiss() {
            }

            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onTraceFeed() {
                adxNativeAd.traceData(((NativeExpressCustomAdapter) AdxNativeExpressAdapter.this).sdkSupplier != null ? ((NativeExpressCustomAdapter) AdxNativeExpressAdapter.this).sdkSupplier.getTemplateConf() : null, new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(((NativeExpressCustomAdapter) AdxNativeExpressAdapter.this).sdkSupplier), AdxNativeExpressAdapter.this.getRequestId()), false);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$bindImageViews$7$com-yfanads-ads-chanel-adx-AdxNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1027x823c1123(AdxNativeAd adxNativeAd, AdBannerViewHolder adBannerViewHolder) {
        int videoWidth = adxNativeAd.getVideoWidth();
        int videoHeight = adxNativeAd.getVideoHeight();
        updateMaterialArea(adBannerViewHolder.showImg, adBannerViewHolder.showImg.getWidth(), adBannerViewHolder.showImg.getHeight(), videoWidth, videoHeight);
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$2$com-yfanads-ads-chanel-adx-AdxNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1028xaa0c3426(BannerTemplateData bannerTemplateData, AdBannerViewHolder adBannerViewHolder, AdxNativeAd adxNativeAd) {
        bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        updateShakeAction(bannerTemplateData);
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        updateDownload(bannerTemplateData, adBannerViewHolder, adxNativeAd);
        YFOptional.ofNullable(adxNativeAd).ifPresentRun(new AdxNativeExpressAdapter$$ExternalSyntheticLambda9());
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$3$com-yfanads-ads-chanel-adx-AdxNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1029xd7e4ce85(FragmentManager fragmentManager, final AdxNativeAd adxNativeAd, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new OnFeedClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxNativeExpressAdapter.3
            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onDismiss() {
            }

            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onTraceFeed() {
                adxNativeAd.traceData(((NativeExpressCustomAdapter) AdxNativeExpressAdapter.this).sdkSupplier != null ? ((NativeExpressCustomAdapter) AdxNativeExpressAdapter.this).sdkSupplier.getTemplateConf() : null, new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(((NativeExpressCustomAdapter) AdxNativeExpressAdapter.this).sdkSupplier), AdxNativeExpressAdapter.this.getRequestId()), false);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateWithVideoPlayStart$4$com-yfanads-ads-chanel-adx-AdxNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1030x538a0114(AdBaseViewHolder adBaseViewHolder, AdxNativeAd adxNativeAd, BannerTemplateData bannerTemplateData, View view) {
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int videoWidth = adxNativeAd.getVideoWidth();
        int videoHeight = adxNativeAd.getVideoHeight();
        if (bannerTemplateData.isTemplateV3()) {
            updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, height, videoWidth, videoHeight);
        } else if (videoWidth > 0 && videoHeight > 0) {
            FrameLayout frameLayout = adBaseViewHolder.mediaViewFrame;
            ViewUtils.setViewSize(frameLayout, (int) ((((double) videoWidth) / ((double) videoHeight)) * ((double) height)), height);
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adBaseViewHolder.mediaViewFrame.removeAllViews();
        adBaseViewHolder.mediaViewFrame.addView(view);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (YFListUtils.isEmpty(this.nativeAds2)) {
            return;
        }
        Iterator<AdxNativeAd> it = this.nativeAds2.iterator();
        while (it.hasNext()) {
            it.next().reportAdInfo(19, null);
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=");
        SdkSupplier sdkSupplier2 = this.sdkSupplier;
        String shortString = "";
        StringBuilder sbAppend2 = sbAppend.append(sdkSupplier2 != null ? sdkSupplier2.toShortString() : "").append(" loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend2.append(shortString).toString());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        List<AdxNativeAd> list = this.nativeAds2;
        if (list != null) {
            Iterator<AdxNativeAd> it = list.iterator();
            while (it.hasNext()) {
                it.next().destroy(a.NATIVE_EXPRESS);
            }
            this.nativeAds2.clear();
            this.nativeAds2 = null;
        }
        super.doDestroy();
    }
}
