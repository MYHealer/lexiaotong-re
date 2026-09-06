package com.yfanads.ads.chanel.jd;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.dyf.tt;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.JADSplashListener;
import com.stub.StubApp;
import com.yfanads.ads.chanel.jd.holder.JDSplashViewHolder;
import com.yfanads.ads.chanel.jd.model.JDNativeAds;
import com.yfanads.ads.chanel.jd.model.JDVideoPlayListener;
import com.yfanads.ads.chanel.jd.template.JDSplashTemplateData;
import com.yfanads.ads.chanel.jd.utls.JDUtil;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFVideoPlayConfigImpl;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class JDSplashAdapter extends SplashCustomAdapter implements JADSplashListener, JADNativeLoadListener, JADNativeSplashInteractionListener {
    private static final int mSkitTime = 5;
    private ViewGroup adContainer;
    private View adView;
    private boolean isNeedShow;
    private JADNative mJADNative;
    private JADSplash mJADSplash;
    private JDSplashViewHolder splashViewHolder;

    public JDSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
        this.isNeedShow = false;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        JDUtil.initJD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.jd.JDSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                JDSplashAdapter.this.startLoadAD(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                JDSplashAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        this.adContainer = viewGroup;
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void showSplashAD(Activity activity, ViewGroup viewGroup) {
        if (this.adView != null) {
            onRenderSuccess();
        }
        this.isNeedShow = true;
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void showNativeSplashAd(Activity activity, ViewGroup viewGroup) {
        if (this.mJADNative == null) {
            YFLog.error(this.tag + "doShowADByNative nativeAd == null");
            handleRenderFailed(0, " doShowADByNative nativeAd == null");
            return;
        }
        String templateKey = this.sdkSupplier.getTemplateKey(TemplateRes.SPLASH_V1);
        int template = TemplateRes.getTemplate(templateKey);
        if (template == 0) {
            YFLog.error(this.tag + " addView error has no id");
            handleRenderFailed(0, " addView error has no id");
            return;
        }
        super.showNativeSplashAd(activity, viewGroup);
        JDSplashTemplateData jDSplashTemplateData = new JDSplashTemplateData(templateKey, isFullScreen());
        jDSplashTemplateData.setConf(this.sdkSupplier.getTemplateConf());
        View viewInflate = LayoutInflater.from(activity).inflate(template, (ViewGroup) null);
        this.splashViewHolder = new JDSplashViewHolder(viewInflate, jDSplashTemplateData);
        bindData(activity, jDSplashTemplateData, this.mJADNative);
        addViewLister(viewInflate);
        handleApiExposure();
        doShowAD(viewGroup, viewInflate);
    }

    private void bindData(Activity activity, JDSplashTemplateData jDSplashTemplateData, JADNative jADNative) {
        Context context = getContext();
        boolean zIsScreenLand = YFAdsPhone.getInstance().isScreenLand(activity);
        jDSplashTemplateData.updAdLog(R.mipmap.ad_log_jd_v3);
        int eventInteractionType = 0;
        JADMaterialData jADMaterialData = !YFListUtils.isEmpty(jADNative.getDataList()) ? jADNative.getDataList().get(0) : null;
        boolean z = jADMaterialData != null && isVideoAd(jADMaterialData);
        this.feedBean = new FeedBean("", "", z, jDSplashTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        YFLog.debug("jd isVideo: " + z);
        if (jADMaterialData != null) {
            eventInteractionType = jADMaterialData.getEventInteractionType();
            updateDataView(jDSplashTemplateData, jADMaterialData, z, zIsScreenLand);
        }
        this.splashViewHolder.updateShowView(context, eventInteractionType, jDSplashTemplateData, zIsScreenLand);
        this.splashViewHolder.setTevComplianceGone();
        registerViewForInteraction(activity, jDSplashTemplateData, jADNative, z);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            this.splashViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDSplashAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1118lambda$bindData$0$comyfanadsadschaneljdJDSplashAdapter(fragmentManager, view);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-jd-JDSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1118lambda$bindData$0$comyfanadsadschaneljdJDSplashAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void updateDataView(JDSplashTemplateData jDSplashTemplateData, JADMaterialData jADMaterialData, boolean z, boolean z2) {
        this.feedBean.title = jADMaterialData.getTitle();
        this.feedBean.des = jADMaterialData.getDescription();
        if (z) {
            this.splashViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, this.splashViewHolder.imageBlur);
        } else if (!YFListUtils.isEmpty(jADMaterialData.getImageUrls())) {
            String str = jADMaterialData.getImageUrls().get(0);
            if (!TextUtils.isEmpty(str)) {
                this.feedBean.imageUrl = str;
                ViewUtils.loadBlurImage(str, this.splashViewHolder.imageBlur, 1);
                ViewUtils.loadImage(str, this.splashViewHolder.showImg);
                if (jDSplashTemplateData.isShowTopArea(z2)) {
                    this.feedBean.isFullScreen = true;
                    ViewUtils.loadCircleImage(str, this.splashViewHolder.adIconSmall, 8);
                }
            }
        }
        if (jDSplashTemplateData.isShowTopArea(z2)) {
            this.splashViewHolder.adIconNameSmall.setText(TextUtils.isEmpty(jADMaterialData.getTitle()) ? jADMaterialData.getDescription() : jADMaterialData.getTitle());
        }
        if (jDSplashTemplateData.isTemplateV2()) {
            this.splashViewHolder.adDes.setText(TextUtils.isEmpty(jADMaterialData.getDescription()) ? jADMaterialData.getTitle() : jADMaterialData.getDescription());
        }
    }

    private void registerViewForInteraction(Activity activity, JDSplashTemplateData jDSplashTemplateData, JADNative jADNative, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.splashViewHolder.getCloseView(jDSplashTemplateData));
        if (jDSplashTemplateData.isTemplateV1()) {
            arrayList.add(this.splashViewHolder.dyClickView);
            if (jDSplashTemplateData.isActionClickType()) {
                arrayList.add(this.splashViewHolder.barView);
            }
        } else {
            if (jDSplashTemplateData.isBigStyle()) {
                if (jDSplashTemplateData.isActionClickType()) {
                    arrayList.add(this.splashViewHolder.actionViewBig);
                    arrayList.add(this.splashViewHolder.animationSlideView);
                }
            } else if (jDSplashTemplateData.isActionClickType()) {
                arrayList.add(this.splashViewHolder.barView);
                arrayList.add(this.splashViewHolder.actionView);
                arrayList.add(this.splashViewHolder.animationSlideView);
            }
            if (jDSplashTemplateData.isWholeClick()) {
                arrayList.add(this.splashViewHolder.viewGroup);
                try {
                    if (this.splashViewHolder.viewGroup.getChildCount() > 0 && this.splashViewHolder.viewGroup != null) {
                        for (int i = 0; i < this.splashViewHolder.viewGroup.getChildCount(); i++) {
                            arrayList.add(this.splashViewHolder.viewGroup.getChildAt(i));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            arrayList.add(this.splashViewHolder.adCloseDelay);
        }
        YFLog.high(this.tag + "registerViewForInteraction " + activity + PPSLabelView.Code + arrayList.size());
        jADNative.registerNativeView(activity, this.splashViewHolder.viewGroup, arrayList, arrayList2, this);
        if (z) {
            bindMediaView(activity, jADNative);
        }
    }

    private void bindMediaView(Activity activity, JADNative jADNative) {
        if (activity == null || YFListUtils.isEmpty(jADNative.getDataList())) {
            return;
        }
        final JDNativeAds yfNativeAd = getYfNativeAd(this.splashViewHolder, jADNative, jADNative.getDataList().get(0));
        YFVideoPlayConfigImpl yFVideoPlayConfigImpl = new YFVideoPlayConfigImpl();
        yFVideoPlayConfigImpl.setVideoSoundEnable(!this.sdkSupplier.isMuted());
        final View videoView = yfNativeAd.getVideoView(activity, yFVideoPlayConfigImpl);
        this.splashViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.jd.JDSplashAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1119lambda$bindMediaView$1$comyfanadsadschaneljdJDSplashAdapter(yfNativeAd, videoView);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$bindMediaView$1$com-yfanads-ads-chanel-jd-JDSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1119lambda$bindMediaView$1$comyfanadsadschaneljdJDSplashAdapter(JDNativeAds jDNativeAds, View view) {
        try {
            int width = this.splashViewHolder.mediaViewFrame.getWidth();
            int height = this.splashViewHolder.mediaViewFrame.getHeight();
            if (height == 0) {
                height = ScreenUtil.getRealHeight(getContext());
            }
            int i = height;
            int videoWidth = jDNativeAds.getVideoWidth();
            int videoHeight = jDNativeAds.getVideoHeight();
            YFLog.info("height = " + i + " , videoWidth = " + videoWidth + " , videoHeight = " + videoHeight);
            updateMaterialArea(this.splashViewHolder.mediaViewFrame, width, i, videoWidth, videoHeight);
            if (view == null || view.getParent() != null) {
                return;
            }
            this.splashViewHolder.mediaViewFrame.removeAllViews();
            this.splashViewHolder.mediaViewFrame.addView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JDNativeAds getYfNativeAd(final AdBaseViewHolder adBaseViewHolder, final JADNative jADNative, JADMaterialData jADMaterialData) {
        final JDNativeAds jDNativeAds = new JDNativeAds(getContext(), jADNative, jADMaterialData, new YFNativeCall() { // from class: com.yfanads.ads.chanel.jd.JDSplashAdapter.2
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
        jDNativeAds.setVideoPlayListener(new JDVideoPlayListener() { // from class: com.yfanads.ads.chanel.jd.JDSplashAdapter.3
            @Override // com.yfanads.ads.chanel.jd.model.JDVideoPlayListener
            public void onVideoPlayReady() {
                if (jADNative != null) {
                    YFLog.debug(JDSplashAdapter.this.tag + "onVideoPlayReady");
                    jADNative.getJADVideoReporter().reportVideoWillStart();
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                if (jADNative != null) {
                    YFLog.debug(JDSplashAdapter.this.tag + "onVideoPlayStart " + jDNativeAds.getCurrentTime());
                    jADNative.getJADVideoReporter().reportVideoStart(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                if (jADNative != null) {
                    YFLog.debug(JDSplashAdapter.this.tag + "onVideoPlayPause " + jDNativeAds.getCurrentTime());
                    jADNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                if (jADNative != null) {
                    YFLog.debug(JDSplashAdapter.this.tag + "onVideoPlayResume " + jDNativeAds.getCurrentTime());
                    jADNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
                if (jADNative != null) {
                    YFLog.debug(JDSplashAdapter.this.tag + "onVideoPlayError " + jDNativeAds.getCurrentTime());
                    jADNative.getJADVideoReporter().reportVideoError(jDNativeAds.getCurrentTime(), i, i2);
                    JDSplashAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder, jDNativeAds);
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                if (jADNative != null) {
                    YFLog.debug(JDSplashAdapter.this.tag + "onVideoPlayComplete " + jDNativeAds.getCurrentTime());
                    jADNative.getJADVideoReporter().reportVideoCompleted(jDNativeAds.getCurrentTime());
                    JDSplashAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder, jDNativeAds);
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

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void loadNativeSplashAd(Context context) {
        float f = this.sdkSupplier.requestTimeout > 0 ? this.sdkSupplier.requestTimeout / 1000 : 3.0f;
        TemplateConf templateConf = this.sdkSupplier.getTemplateConf();
        int i = templateConf != null ? templateConf.oat : 5;
        int[] sizeDp = getSizeDp();
        boolean z = false;
        JADNative jADNative = new JADNative(new JADSlot.Builder().setSlotID(this.sdkSupplier.getPotId()).setImageSize(sizeDp[0], sizeDp[1]).setAdType(1).setTolerateTime(f).setSkipTime(i).build());
        this.mJADNative = jADNative;
        jADNative.loadAd(this);
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append("doLoadAD -- ").append(Arrays.toString(sizeDp)).append(" dp, ");
        if (this.mSplashSetting != null && this.mSplashSetting.isCustom()) {
            z = true;
        }
        YFLog.high(sbAppend.append(z).toString());
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void loadSplashAd(Context context) {
        float f = this.sdkSupplier.requestTimeout > 0 ? this.sdkSupplier.requestTimeout / 1000 : 3.0f;
        int[] sizeDp = getSizeDp();
        boolean z = false;
        JADSplash jADSplash = new JADSplash(context, new JADSlot.Builder().setSlotID(this.sdkSupplier.getPotId()).setSize(sizeDp[0], sizeDp[1]).setTolerateTime(f).setSkipTime(5).setSkipButtonHidden(false).build());
        this.mJADSplash = jADSplash;
        jADSplash.loadAd(this);
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append("doLoadAD -- ").append(Arrays.toString(sizeDp)).append(" dp, ");
        if (this.mSplashSetting != null && this.mSplashSetting.isCustom()) {
            z = true;
        }
        YFLog.high(sbAppend.append(z).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.JD.getValue();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        try {
            if (isNative()) {
                JADNative jADNative = this.mJADNative;
                if (jADNative != null) {
                    jADNative.destroy();
                    this.mJADNative = null;
                }
            } else {
                JADSplash jADSplash = this.mJADSplash;
                if (jADSplash != null) {
                    jADSplash.destroy();
                    this.mJADSplash = null;
                }
                ViewGroup viewGroup = this.adContainer;
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                    this.adContainer = null;
                }
                if (this.adView != null) {
                    this.adView = null;
                }
            }
            JDSplashViewHolder jDSplashViewHolder = this.splashViewHolder;
            if (jDSplashViewHolder != null) {
                jDSplashViewHolder.destroy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onLoadSuccess() {
        if (isNative()) {
            JADNative jADNative = this.mJADNative;
            if (jADNative != null) {
                setEcpm(jADNative.getJADExtra().getPrice());
            }
        } else {
            JADSplash jADSplash = this.mJADSplash;
            if (jADSplash != null) {
                setEcpm(jADSplash.getJADExtra().getPrice());
            }
        }
        handleSucceed();
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onLoadFailure(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onRenderSuccess(View view) {
        if (view == null) {
            YFLog.error(this.tag + " onRenderSuccess but adView == null, return ");
            handleRenderFailed();
        } else {
            this.adView = view;
            if (this.isNeedShow) {
                onRenderSuccess();
            }
        }
    }

    private void onRenderSuccess() {
        doShowAD(this.adContainer, this.adView);
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onRenderFailure(int i, String str) {
        YFLog.error("onRenderFailure msg:" + str + "_" + i);
        if (isStartShow()) {
            handleRenderFailed(i, str);
        }
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onExposure() {
        handleExposure();
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onClick() {
        handleClick();
    }

    @Override // com.jd.ad.sdk.splash.JADSplashListener
    public void onClose() {
        adapterDid();
    }

    @Override // com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener
    public void onCountdown(int i) {
        JDSplashViewHolder jDSplashViewHolder = this.splashViewHolder;
        if (jDSplashViewHolder == null) {
            YFLog.debug(" onCountdown splashViewHolder == null");
        } else {
            this.splashViewHolder.setTevCountdown(String.format(TextUtils.isEmpty(jDSplashViewHolder.closeTips) ? getContext().getString(R.string.jump_tip) : this.splashViewHolder.closeTips, Integer.valueOf(i)));
        }
    }

    @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
    public void onClick(View view) {
        handleClick();
    }

    @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
    public void onClose(View view) {
        adapterDid();
    }

    private void adapterDid() {
        try {
            handleClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        JADNative jADNative = this.mJADNative;
        if (jADNative != null && !YFListUtils.isEmpty(jADNative.getDataList())) {
            return JDUtil.getAdInfo(this.mJADNative.getDataList().get(0), getRequestId());
        }
        return super.getAdInfo();
    }

    private boolean isVideoAd(JADMaterialData jADMaterialData) {
        int mediaSpecSetType = jADMaterialData.getMediaSpecSetType();
        YFLog.debug("jd mediaSpecSetType: " + mediaSpecSetType);
        return mediaSpecSetType == 10009 && !TextUtils.isEmpty(jADMaterialData.getVideoUrl());
    }
}
