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
import com.stub.StubApp;
import com.yfanads.ads.chanel.jd.model.JDNativeAds;
import com.yfanads.ads.chanel.jd.model.JDVideoPlayListener;
import com.yfanads.ads.chanel.jd.utls.JDUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFVideoPlayConfigImpl;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
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
public class JDNativeExpressAdapter extends NativeExpressCustomAdapter implements JADFeedListener, YFNativeCall {
    private YFExpView expView;
    private boolean isNeedShow;
    private JADFeed jadFeed;
    JADNative jdNative;
    private List<JADMaterialData> nativeAds2;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 9;
    }

    public JDNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
        this.isNeedShow = false;
        this.setting = yFNativeExpressSetting;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        JDUtil.initJD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                JDNativeExpressAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                JDNativeExpressAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        if (isTemplate()) {
            loadTemplate(context);
        } else if (isNative() || isDevelop()) {
            loadAdByNative(context);
        } else {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    private void loadAdByNative(Context context) {
        int iPx2dip = ScreenUtil.px2dip(context, ScreenUtil.getScreenWidth(context));
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            iPx2dip = this.setting.getViewWidth();
        }
        JADNative jADNative = new JADNative(new JADSlot.Builder().setSlotID(this.sdkSupplier.getPotId()).setImageSize(iPx2dip, 0.0f).setAdType(2).build());
        this.jdNative = jADNative;
        jADNative.loadAd(new JADNativeLoadListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter.2
            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadSuccess() {
                YFLog.high(JDNativeExpressAdapter.this.tag + "onNativeAdLoad");
                try {
                    List<JADMaterialData> dataList = JDNativeExpressAdapter.this.jdNative.getDataList();
                    if (!YFListUtils.isEmpty(dataList) && dataList.get(0) != null) {
                        JDNativeExpressAdapter.this.updData(dataList);
                        if (JDNativeExpressAdapter.this.jdNative != null) {
                            JDNativeExpressAdapter jDNativeExpressAdapter = JDNativeExpressAdapter.this;
                            jDNativeExpressAdapter.setEcpm(jDNativeExpressAdapter.jdNative.getJADExtra().getPrice());
                        }
                        JDNativeExpressAdapter.this.handleSucceed();
                        return;
                    }
                    JDNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Exception e) {
                    YFLog.error(JDNativeExpressAdapter.this.tag + " onNativeAdLoad " + e.getMessage());
                    JDNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadFailure(int i, String str) {
                JDNativeExpressAdapter.this.handleFailed(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updData(List<JADMaterialData> list) {
        if (!isDevelop()) {
            this.nativeAds2 = list;
            return;
        }
        this.developAds.clear();
        for (int i = 0; i < list.size(); i++) {
            this.developAds.add(new JDNativeAds(getContext(), this.jdNative, list.get(i), this));
        }
    }

    private void loadTemplate(Context context) {
        YFLog.debug(this.tag + "loadTemplate context " + context);
        int iPx2dip = ScreenUtil.px2dip(getContext(), ScreenUtil.getScreenWidth(getContext()));
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            iPx2dip = this.setting.getViewWidth();
        }
        JADFeed jADFeed = new JADFeed(StubApp.getOrigApplicationContext(context.getApplicationContext()), new JADSlot.Builder().setSlotID(this.sdkSupplier.getPotId()).setSize(iPx2dip, 0.0f).setCloseButtonHidden(false).build());
        this.jadFeed = jADFeed;
        jADFeed.loadAd(this);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        try {
            super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
            if (isTemplate()) {
                doShowTemplateAd();
            } else if (isNative() || isDevelop()) {
                doShowNativeAd(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            handleShowFailed();
        }
    }

    private void doShowTemplateAd() {
        try {
            if (this.expView != null) {
                onRenderSuccess();
            }
            this.isNeedShow = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        JADMaterialData adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        boolean zIsVideoAd = isVideoAd(adNative);
        YFLog.debug("jd isVideo: " + zIsVideoAd);
        this.feedBean = new FeedBean(adNative.getTitle(), adNative.getDescription(), zIsVideoAd, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (zIsVideoAd) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            this.feedBean.imageUrl = adNative.getVideoUrl();
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!YFListUtils.isEmpty(adNative.getImageUrls())) {
                String str = adNative.getImageUrls().get(0);
                if (!TextUtils.isEmpty(str)) {
                    this.feedBean.imageUrl = str;
                    ViewUtils.loadBlurImage(str, adBannerViewHolder.imageBlur, 20);
                    ViewUtils.loadImage(str, adBannerViewHolder.showImg);
                }
            }
        }
        YFLog.debug("jd imageUrl: " + this.feedBean.imageUrl + " isVideo:" + zIsVideoAd);
        bannerTemplateData.updAdLog(R.mipmap.ad_log_jd_v3);
        String description = TextUtils.isEmpty(adNative.getTitle()) ? adNative.getDescription() : adNative.getTitle();
        String title = TextUtils.isEmpty(adNative.getDescription()) ? adNative.getTitle() : adNative.getDescription();
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
        registerViewForInteraction(activity, adBannerViewHolder, zIsVideoAd, bannerTemplateData, adNative, i);
        if (activity != null) {
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1116x7b04c6c3(fragmentManager, view);
                }
            });
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1117x6cae6ce2(i, view);
            }
        });
        complianceContent(adBannerViewHolder);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-jd-JDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1116x7b04c6c3(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-jd-JDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1117x6cae6ce2(int i, View view) {
        closeAds(i);
    }

    private void registerViewForInteraction(Activity activity, AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData, JADMaterialData jADMaterialData, int i) {
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
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(activity, adBannerViewHolder, arrayList, arrayList2, jADMaterialData, i);
        } else {
            bindImageViews(activity, adBannerViewHolder, arrayList, arrayList2, i);
        }
    }

    private void bindImageViews(Activity activity, AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2, final int i) {
        if (activity != null) {
            this.jdNative.registerNativeView(activity, adBaseViewHolder.viewGroup, list, list2, new JADNativeInteractionListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter.3
                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public void onClose(View view) {
                }

                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public void onExposure() {
                    JDNativeExpressAdapter.this.handleExposure(i);
                }

                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public void onClick(View view) {
                    JDNativeExpressAdapter.this.handleClick(i, false);
                }
            });
        }
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2, JADMaterialData jADMaterialData, final int i) {
        this.jdNative.registerNativeView(activity, adBaseViewHolder.viewGroup, list, list2, new JADNativeInteractionListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter.4
            @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
            public void onClose(View view) {
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
            public void onExposure() {
                JDNativeExpressAdapter.this.handleExposure(i);
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
            public void onClick(View view) {
                JDNativeExpressAdapter.this.handleClick(i, false);
            }
        });
        final JDNativeAds yfNativeAd = getYfNativeAd(adBaseViewHolder, jADMaterialData);
        YFVideoPlayConfigImpl yFVideoPlayConfigImpl = new YFVideoPlayConfigImpl();
        yFVideoPlayConfigImpl.setVideoSoundEnable(!this.sdkSupplier.isMuted());
        final View videoView = yfNativeAd.getVideoView(activity, yFVideoPlayConfigImpl);
        adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                JDNativeExpressAdapter.lambda$bindMediaView$3(adBaseViewHolder, yfNativeAd, videoView);
            }
        });
    }

    static /* synthetic */ void lambda$bindMediaView$3(AdBaseViewHolder adBaseViewHolder, JDNativeAds jDNativeAds, View view) {
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
        final JDNativeAds jDNativeAds = new JDNativeAds(getContext(), this.jdNative, jADMaterialData, new YFNativeCall() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter.5
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
        jDNativeAds.setVideoPlayListener(new JDVideoPlayListener() { // from class: com.yfanads.ads.chanel.jd.JDNativeExpressAdapter.6
            @Override // com.yfanads.ads.chanel.jd.model.JDVideoPlayListener
            public void onVideoPlayReady() {
                if (JDNativeExpressAdapter.this.jdNative != null) {
                    YFLog.debug(JDNativeExpressAdapter.this.tag + "onVideoPlayReady");
                    JDNativeExpressAdapter.this.jdNative.getJADVideoReporter().reportVideoWillStart();
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                if (JDNativeExpressAdapter.this.jdNative != null) {
                    YFLog.debug(JDNativeExpressAdapter.this.tag + "onVideoPlayStart " + jDNativeAds.getCurrentTime());
                    JDNativeExpressAdapter.this.jdNative.getJADVideoReporter().reportVideoStart(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                if (JDNativeExpressAdapter.this.jdNative != null) {
                    YFLog.debug(JDNativeExpressAdapter.this.tag + "onVideoPlayPause " + jDNativeAds.getCurrentTime());
                    JDNativeExpressAdapter.this.jdNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                if (JDNativeExpressAdapter.this.jdNative != null) {
                    YFLog.debug(JDNativeExpressAdapter.this.tag + "onVideoPlayResume " + jDNativeAds.getCurrentTime());
                    JDNativeExpressAdapter.this.jdNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
                if (JDNativeExpressAdapter.this.jdNative != null) {
                    YFLog.debug(JDNativeExpressAdapter.this.tag + "onVideoPlayError " + jDNativeAds.getCurrentTime());
                    JDNativeExpressAdapter.this.jdNative.getJADVideoReporter().reportVideoError(jDNativeAds.getCurrentTime(), i, i2);
                    JDNativeExpressAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder, jDNativeAds);
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                if (JDNativeExpressAdapter.this.jdNative != null) {
                    YFLog.debug(JDNativeExpressAdapter.this.tag + "onVideoPlayComplete " + jDNativeAds.getCurrentTime());
                    JDNativeExpressAdapter.this.jdNative.getJADVideoReporter().reportVideoCompleted(jDNativeAds.getCurrentTime());
                    JDNativeExpressAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder, jDNativeAds);
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

    private JADMaterialData getAdNative(int i) {
        if (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size()) {
            YFLog.error("bindData error " + i);
            return null;
        }
        return this.nativeAds2.get(i);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<JADMaterialData> list = this.nativeAds2;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        JADFeed jADFeed = this.jadFeed;
        if (jADFeed != null) {
            jADFeed.destroy();
            this.jadFeed = null;
        }
        List<JADMaterialData> list = this.nativeAds2;
        if (list != null && !list.isEmpty()) {
            this.nativeAds2.clear();
        }
        JADNative jADNative = this.jdNative;
        if (jADNative != null) {
            jADNative.destroy();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.JD.getValue();
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onLoadSuccess() {
        JADFeed jADFeed = this.jadFeed;
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
        if (view == null) {
            YFLog.error(this.tag + " onRenderSuccess but view == null, return ");
            handleRenderFailed();
        } else {
            this.expView = new YFExpView(view, getAdType());
            if (this.isNeedShow) {
                onRenderSuccess();
            }
        }
    }

    private void onRenderSuccess() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.expView);
        if (this.setting != null) {
            this.setting.adapterRenderSuccess(this.sdkSupplier, arrayList);
        }
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onRenderFailure(int i, String str) {
        YFLog.error(this.tag + " onRenderFailure msg:" + str + "_" + i);
        handleRenderFailed();
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onExposure() {
        handleExposure(this.expView);
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onClick() {
        handleClick(this.expView);
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onClose() {
        JADFeed jADFeed = this.jadFeed;
        if (jADFeed != null) {
            jADFeed.removeFeedView();
        }
        handleClose(this.expView);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            return JDUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
        }
        return super.getAdInfo();
    }

    private boolean isVideoAd(JADMaterialData jADMaterialData) {
        int mediaSpecSetType = jADMaterialData.getMediaSpecSetType();
        YFLog.debug("jd mediaSpecSetType: " + mediaSpecSetType);
        return (mediaSpecSetType == 10007 || mediaSpecSetType == 10008) && !TextUtils.isEmpty(jADMaterialData.getVideoUrl());
    }
}
