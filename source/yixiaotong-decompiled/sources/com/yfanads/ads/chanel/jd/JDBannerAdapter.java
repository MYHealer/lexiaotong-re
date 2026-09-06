package com.yfanads.ads.chanel.jd;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.feed.JADFeedListener;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import com.jd.ad.sdk.nativead.JADNativeWidget;
import com.yfanads.ads.chanel.jd.model.JDNativeAds;
import com.yfanads.ads.chanel.jd.model.JDVideoPlayListener;
import com.yfanads.ads.chanel.jd.utls.JDUtil;
import com.yfanads.android.core.banner.YFBannerSetting;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFVideoPlayConfigImpl;
import com.yfanads.android.custom.BannerCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class JDBannerAdapter extends BannerCustomAdapter implements JADFeedListener, JADNativeInteractionListener {
    private ViewGroup adContainer;
    private View adView;
    private boolean isNeedShow;
    JADNative jdNative;
    JADFeed mJADFeed;
    private JADMaterialData nativeAds;
    private long startTime;

    public JDBannerAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
        this.isNeedShow = false;
        this.startTime = 0L;
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        JDUtil.initJD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.jd.JDBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                JDBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                JDBannerAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        this.adContainer = viewGroup;
        if (isNative()) {
            showNativeADs(activity, viewGroup);
            return;
        }
        try {
            if (this.adView != null) {
                onRenderSuccess();
            }
            this.isNeedShow = true;
        } catch (Throwable th) {
            th.printStackTrace();
            handleShowFailed();
        }
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAds == null || viewGroup == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            YFLog.debug(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = ");
            addView(activity, viewGroup);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            loadBannerAdByNative(context);
        } else {
            loadBannerAd(context);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isNative() {
        return this.sdkSupplier.getRenderId(1) == 2;
    }

    private void loadBannerAd(Context context) {
        int iPx2dip = ScreenUtil.px2dip(getContext(), ScreenUtil.getScreenWidth(getContext()));
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            iPx2dip = this.setting.getViewWidth();
        }
        JADFeed jADFeed = new JADFeed(context, new JADSlot.Builder().setSlotID(this.sdkSupplier.getPotId()).setSize(iPx2dip, 0.0f).setCloseButtonHidden(false).build());
        this.mJADFeed = jADFeed;
        jADFeed.loadAd(this);
    }

    private void loadBannerAdByNative(Context context) {
        int iPx2dip = ScreenUtil.px2dip(getContext(), ScreenUtil.getScreenWidth(getContext()));
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            iPx2dip = this.setting.getViewWidth();
        }
        JADNative jADNative = new JADNative(new JADSlot.Builder().setSlotID(this.sdkSupplier.getPotId()).setImageSize(iPx2dip, 0.0f).setAdType(2).build());
        this.jdNative = jADNative;
        jADNative.loadAd(new JADNativeLoadListener() { // from class: com.yfanads.ads.chanel.jd.JDBannerAdapter.2
            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadSuccess() {
                YFLog.high(JDBannerAdapter.this.tag + "onNativeAdLoad");
                try {
                    List<JADMaterialData> dataList = JDBannerAdapter.this.jdNative.getDataList();
                    if (dataList != null && dataList.size() != 0 && dataList.get(0) != null) {
                        JDBannerAdapter.this.nativeAds = dataList.get(0);
                        if (JDBannerAdapter.this.jdNative != null) {
                            JDBannerAdapter jDBannerAdapter = JDBannerAdapter.this;
                            jDBannerAdapter.setEcpm(jDBannerAdapter.jdNative.getJADExtra().getPrice());
                        }
                        JDBannerAdapter.this.handleSucceed();
                        return;
                    }
                    JDBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Throwable th) {
                    th.printStackTrace();
                    JDBannerAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadFailure(int i, String str) {
                YFLog.high(JDBannerAdapter.this.tag + "onLoadFailure :" + i + ",error:" + str);
                JDBannerAdapter.this.handleFailed(i, str);
            }
        });
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (isNative()) {
            JADNative jADNative = this.jdNative;
            if (jADNative != null) {
                jADNative.destroy();
                this.jdNative = null;
                return;
            }
            return;
        }
        ViewGroup viewGroup = this.adContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.adContainer = null;
        }
        JADFeed jADFeed = this.mJADFeed;
        if (jADFeed != null) {
            jADFeed.destroy();
            this.mJADFeed = null;
        }
        if (this.adView != null) {
            this.adView = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.JD.getValue();
    }

    @Override // com.yfanads.android.custom.BannerCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, ViewGroup viewGroup, AdBannerViewHolder adBannerViewHolder) {
        boolean zIsVideoAd = isVideoAd(this.nativeAds);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDescription(), zIsVideoAd, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (zIsVideoAd) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            this.feedBean.imageUrl = this.nativeAds.getVideoUrl();
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!YFListUtils.isEmpty(this.nativeAds.getImageUrls())) {
                String str = this.nativeAds.getImageUrls().get(0);
                this.feedBean.imageUrl = str;
                if (!TextUtils.isEmpty(str)) {
                    ViewUtils.loadBlurImage(str, adBannerViewHolder.imageBlur, 20);
                    ViewUtils.loadImage(str, adBannerViewHolder.showImg);
                }
            }
        }
        YFLog.debug("jd imageUrl: " + this.feedBean.imageUrl + " isVideo:" + zIsVideoAd);
        bannerTemplateData.updAdLog(R.mipmap.ad_log_jd_v3);
        String description = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getDescription() : this.nativeAds.getTitle();
        String title = TextUtils.isEmpty(this.nativeAds.getDescription()) ? this.nativeAds.getTitle() : this.nativeAds.getDescription();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (description == null) {
                description = "";
            }
            textView.setText(description);
        }
        TextView textView2 = adBannerViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView2.setText(title);
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
            } else {
                adBannerViewHolder.mDownload.setVisibility(0);
                adBannerViewHolder.mDownload.setText(getContext().getString(R.string.yf_default_download_text));
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        if (bannerTemplateData.isShowAdIcon()) {
            adBannerViewHolder.adIcon.setVisibility(0);
            adBannerViewHolder.adIcon.setImageBitmap(JADNativeWidget.getJDLogo(getContext()));
        }
        registerViewForInteraction(activity, adBannerViewHolder, zIsVideoAd, bannerTemplateData);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDBannerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1113lambda$bindData$0$comyfanadsadschaneljdJDBannerAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-jd-JDBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1113lambda$bindData$0$comyfanadsadschaneljdJDBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(Activity activity, AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData) {
        ArrayList arrayList = new ArrayList();
        if (bannerTemplateData.isTemplateV3()) {
            if (bannerTemplateData.isWholeClick()) {
                arrayList.add(adBannerViewHolder.viewGroup);
            }
            arrayList.add(adBannerViewHolder.adCloseDelay);
        } else {
            arrayList.add(adBannerViewHolder.dyClickView);
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                arrayList.add(adBannerViewHolder.mDownloadBar);
            } else {
                arrayList.add(adBannerViewHolder.mDownload);
            }
        }
        if (bannerTemplateData.isTitleDesClick()) {
            arrayList.add(adBannerViewHolder.adDes);
            arrayList.add(adBannerViewHolder.titleDes);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(adBannerViewHolder.getCloseView(bannerTemplateData));
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDBannerAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(activity, adBannerViewHolder, arrayList, arrayList2);
        } else {
            bindImageViews(activity, adBannerViewHolder, arrayList, arrayList2);
        }
    }

    private void bindImageViews(Activity activity, AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2) {
        if (activity != null) {
            this.jdNative.registerNativeView(activity, adBaseViewHolder.viewGroup, list, list2, this);
        }
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2) {
        if (activity != null) {
            this.jdNative.registerNativeView(activity, adBaseViewHolder.viewGroup, list, list2, this);
            final JDNativeAds yfNativeAd = getYfNativeAd(adBaseViewHolder, this.nativeAds);
            YFVideoPlayConfigImpl yFVideoPlayConfigImpl = new YFVideoPlayConfigImpl();
            yFVideoPlayConfigImpl.setVideoSoundEnable(!this.sdkSupplier.isMuted());
            final View videoView = yfNativeAd.getVideoView(activity, yFVideoPlayConfigImpl);
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.jd.JDBannerAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    JDBannerAdapter.lambda$bindMediaView$2(adBaseViewHolder, yfNativeAd, videoView);
                }
            });
        }
    }

    static /* synthetic */ void lambda$bindMediaView$2(AdBaseViewHolder adBaseViewHolder, JDNativeAds jDNativeAds, View view) {
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int videoWidth = jDNativeAds.getVideoWidth();
        int videoHeight = jDNativeAds.getVideoHeight();
        YFLog.high("height = " + height + " , videoWidth = " + videoWidth + " , videoHeight = " + videoHeight);
        if (videoWidth > 0 && videoHeight > 0 && !ViewUtils.isHorizontal(videoWidth, videoHeight)) {
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, (height * videoWidth) / videoHeight, videoHeight);
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adBaseViewHolder.mediaViewFrame.removeAllViews();
        adBaseViewHolder.mediaViewFrame.addView(view);
    }

    private JDNativeAds getYfNativeAd(final AdBaseViewHolder adBaseViewHolder, JADMaterialData jADMaterialData) {
        final JDNativeAds jDNativeAds = new JDNativeAds(getContext(), this.jdNative, jADMaterialData, new YFNativeCall() { // from class: com.yfanads.ads.chanel.jd.JDBannerAdapter.3
            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void handleClickByIndex(boolean z, int i) {
            }

            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void handleClose() {
            }

            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void handleExposureByIndex(int i) {
            }

            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void handleFailed(String str, String str2) {
            }

            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void showFeedBackDialog(FragmentManager fragmentManager, String str) {
            }
        });
        jDNativeAds.setVideoPlayListener(new JDVideoPlayListener() { // from class: com.yfanads.ads.chanel.jd.JDBannerAdapter.4
            @Override // com.yfanads.ads.chanel.jd.model.JDVideoPlayListener
            public void onVideoPlayReady() {
                if (JDBannerAdapter.this.jdNative != null) {
                    YFLog.debug(JDBannerAdapter.this.tag + "onVideoPlayReady");
                    JDBannerAdapter.this.jdNative.getJADVideoReporter().reportVideoWillStart();
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                if (JDBannerAdapter.this.jdNative != null) {
                    YFLog.debug(JDBannerAdapter.this.tag + "onVideoPlayStart " + jDNativeAds.getCurrentTime());
                    JDBannerAdapter.this.jdNative.getJADVideoReporter().reportVideoStart(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                if (JDBannerAdapter.this.jdNative != null) {
                    YFLog.debug(JDBannerAdapter.this.tag + "onVideoPlayPause " + jDNativeAds.getCurrentTime());
                    JDBannerAdapter.this.jdNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                if (JDBannerAdapter.this.jdNative != null) {
                    YFLog.debug(JDBannerAdapter.this.tag + "onVideoPlayResume " + jDNativeAds.getCurrentTime());
                    JDBannerAdapter.this.jdNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
                if (JDBannerAdapter.this.jdNative != null) {
                    YFLog.debug(JDBannerAdapter.this.tag + "onVideoPlayError " + jDNativeAds.getCurrentTime());
                    JDBannerAdapter.this.jdNative.getJADVideoReporter().reportVideoError(jDNativeAds.getCurrentTime(), i, i2);
                    JDBannerAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder, jDNativeAds);
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                if (JDBannerAdapter.this.jdNative != null) {
                    YFLog.debug(JDBannerAdapter.this.tag + "onVideoPlayComplete " + jDNativeAds.getCurrentTime());
                    JDBannerAdapter.this.jdNative.getJADVideoReporter().reportVideoCompleted(jDNativeAds.getCurrentTime());
                    JDBannerAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder, jDNativeAds);
                }
            }
        });
        return jDNativeAds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWithVideoPlayComplete(AdBaseViewHolder adBaseViewHolder, JDNativeAds jDNativeAds) {
        try {
            int width = adBaseViewHolder.mediaViewFrame.getWidth();
            int height = adBaseViewHolder.mediaViewFrame.getHeight();
            YFLog.high("NativeExpress onVideoPlayComplete width " + width + " , height = " + height);
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (jDNativeAds != null) {
                String str = jDNativeAds.getImageList().get(0);
                if (!TextUtils.isEmpty(str)) {
                    ViewUtils.loadImage(str, imageView);
                    adBaseViewHolder.mediaViewFrame.addView(imageView);
                } else {
                    imageView.setBackgroundResource(R.mipmap.yf_ad_no_bg);
                    adBaseViewHolder.mediaViewFrame.addView(imageView);
                }
            } else {
                imageView.setBackgroundResource(R.mipmap.yf_ad_no_bg);
                adBaseViewHolder.mediaViewFrame.addView(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder) {
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onLoadSuccess() {
        JADFeed jADFeed = this.mJADFeed;
        if (jADFeed != null) {
            setEcpm(jADFeed.getExtra().getPrice());
        }
        handleSucceed();
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onLoadFailure(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onRenderSuccess(View view) {
        YFLog.high(this.tag + "ExpressView onRenderSuccess，cost：" + (System.currentTimeMillis() - this.startTime));
        if (view == null) {
            YFLog.error(this.tag + " onRenderSuccess but view == null, return ");
            handleRenderFailed();
        } else {
            this.adView = view;
            if (this.isNeedShow) {
                onRenderSuccess();
            }
        }
    }

    private void onRenderSuccess() {
        ViewGroup viewGroup = this.adContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.adContainer.addView(this.adView);
        }
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onRenderFailure(int i, String str) {
        YFLog.high(this.tag + "ExpressView onRenderFail ，cost：" + (System.currentTimeMillis() - this.startTime));
        handleRenderFailed();
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onExposure() {
        YFLog.high(this.tag + "onExposure");
        handleExposure();
    }

    @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
    public void onClick(View view) {
        handleClick();
    }

    @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
    public void onClose(View view) {
        closeAds(this.adContainer);
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onClick() {
        handleClick();
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onClose() {
        if (isNative()) {
            ViewGroup viewGroup = this.adContainer;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        } else {
            JADFeed jADFeed = this.mJADFeed;
            if (jADFeed != null) {
                jADFeed.removeFeedView();
            }
        }
        handleClose();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return JDUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    private boolean isVideoAd(JADMaterialData jADMaterialData) {
        int mediaSpecSetType = jADMaterialData.getMediaSpecSetType();
        YFLog.debug("jd mediaSpecSetType: " + mediaSpecSetType);
        return (mediaSpecSetType == 10007 || mediaSpecSetType == 10008) && !TextUtils.isEmpty(jADMaterialData.getVideoUrl());
    }
}
