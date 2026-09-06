package com.yfanads.ads.chanel.jd;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import com.jd.ad.sdk.nativead.JADNativeWidget;
import com.yfanads.ads.chanel.jd.model.JDNativeAds;
import com.yfanads.ads.chanel.jd.model.JDVideoPlayListener;
import com.yfanads.ads.chanel.jd.utls.JDUtil;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFVideoPlayConfigImpl;
import com.yfanads.android.core.toppush.YFTopPushSetting;
import com.yfanads.android.custom.TopPushCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdTopPushViewHolder;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.TopPushTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class JDTopPushAdapter extends TopPushCustomAdapter implements JADNativeInteractionListener {
    private JADNative jdNative;
    private JADSlot mSlot;
    private JADMaterialData nativeAds;

    public JDTopPushAdapter(YFTopPushSetting yFTopPushSetting) {
        super(yFTopPushSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        JDUtil.initJD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.jd.JDTopPushAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                JDTopPushAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                JDTopPushAdapter.this.handleFailed(str, str2);
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
        try {
            loadInterstitialAdByNative(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void loadInterstitialAdByNative(Context context) {
        this.mSlot = new JADSlot.Builder().setSlotID(this.sdkSupplier.getPotId()).setImageSize(513.0f, 912.0f).setAdType(2).build();
        JADNative jADNative = new JADNative(this.mSlot);
        this.jdNative = jADNative;
        jADNative.loadAd(new JADNativeLoadListener() { // from class: com.yfanads.ads.chanel.jd.JDTopPushAdapter.2
            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadSuccess() {
                YFLog.high(JDTopPushAdapter.this.tag + "onNativeAdLoad");
                try {
                    List<JADMaterialData> dataList = JDTopPushAdapter.this.jdNative.getDataList();
                    if (dataList != null && dataList.size() != 0 && dataList.get(0) != null) {
                        JDTopPushAdapter.this.nativeAds = dataList.get(0);
                        if (JDTopPushAdapter.this.jdNative != null) {
                            JDTopPushAdapter jDTopPushAdapter = JDTopPushAdapter.this;
                            jDTopPushAdapter.setEcpm(jDTopPushAdapter.jdNative.getJADExtra().getPrice());
                        }
                        JDTopPushAdapter.this.handleSucceed();
                        return;
                    }
                    JDTopPushAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Throwable th) {
                    th.printStackTrace();
                    JDTopPushAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadFailure(int i, String str) {
                JDTopPushAdapter.this.handleFailed(i, str);
            }
        });
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        try {
            showNativeADs(activity);
        } catch (Exception e) {
            e.printStackTrace();
            handleShowFailed();
        }
    }

    private void showNativeADs(Activity activity) {
        if (this.nativeAds == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
        } else {
            addView(activity, new FrameLayout(getContext()), 1);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.JD.getValue();
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void bindData(Activity activity, TopPushTemplateData topPushTemplateData, final AdBaseViewHolder adBaseViewHolder) {
        try {
            boolean z = !TextUtils.isEmpty(this.nativeAds.getVideoUrl());
            YFLog.high(this.tag + "jd bindData isVideo " + z);
            this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDescription(), z, topPushTemplateData);
            this.feedBean.updateSupplerInfo(this.sdkSupplier);
            adBaseViewHolder.adLogoIcon.setVisibility(8);
            if (activity != null) {
                this.feedBean.contextName = activity.getLocalClassName();
                final FragmentManager fragmentManager = activity.getFragmentManager();
                adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDTopPushAdapter$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.m1120lambda$bindData$0$comyfanadsadschaneljdJDTopPushAdapter(fragmentManager, view);
                    }
                });
            }
            if (this.nativeAds == null) {
                YFLog.error(this.tag + " bindData, but is null, return.");
                return;
            }
            if (z) {
                adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            } else {
                adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
                adBaseViewHolder.showImageArea.setVisibility(4);
                if (!YFListUtils.isEmpty(this.nativeAds.getImageUrls())) {
                    String str = this.nativeAds.getImageUrls().get(0);
                    if (!TextUtils.isEmpty(str)) {
                        ViewUtils.loadBlurImage(str, adBaseViewHolder.imageBlur, 0);
                        ViewUtils.loadImage(str, adBaseViewHolder.showImg, new ViewUtils.ViewImageCallback() { // from class: com.yfanads.ads.chanel.jd.JDTopPushAdapter$$ExternalSyntheticLambda2
                            @Override // com.yfanads.android.utils.ViewUtils.ViewImageCallback
                            public final void onResourceReady() {
                                adBaseViewHolder.showImageArea.setVisibility(0);
                            }
                        });
                    }
                }
            }
            adBaseViewHolder.adLogoIcon.setVisibility(0);
            topPushTemplateData.updAdLog(R.mipmap.ad_log_jd_v4);
            String description = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getDescription() : this.nativeAds.getTitle();
            String title = TextUtils.isEmpty(this.nativeAds.getDescription()) ? this.nativeAds.getTitle() : this.nativeAds.getDescription();
            if (topPushTemplateData.isReplaceTitle()) {
                if (!TextUtils.isEmpty(topPushTemplateData.getReplaceTitle())) {
                    description = topPushTemplateData.getReplaceTitle();
                }
                if (!TextUtils.isEmpty(topPushTemplateData.getReplaceDesc())) {
                    title = topPushTemplateData.getReplaceDesc();
                }
            }
            AdTopPushViewHolder adTopPushViewHolder = (AdTopPushViewHolder) adBaseViewHolder;
            Bitmap jDLogo = JADNativeWidget.getJDLogo(getContext());
            ViewUtils.setRadius(adTopPushViewHolder.adIcon, 8);
            adTopPushViewHolder.adIcon.setImageBitmap(jDLogo);
            TextView textView = adTopPushViewHolder.titleDes;
            if (description == null) {
                description = "";
            }
            textView.setText(description);
            TextView textView2 = adTopPushViewHolder.adDes;
            if (title == null) {
                title = "";
            }
            textView2.setText(title);
            topPushTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
            adTopPushViewHolder.updateShowView(getContext(), topPushTemplateData);
            adTopPushViewHolder.getCloseView(topPushTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDTopPushAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1121lambda$bindData$2$comyfanadsadschaneljdJDTopPushAdapter(view);
                }
            });
            if (activity != null) {
                this.feedBean.contextName = activity.getLocalClassName();
            }
            YFLog.high(this.tag + "jd bindData registerViewForInteraction " + activity);
            registerViewForInteraction(activity, topPushTemplateData, adTopPushViewHolder, z);
            complianceContent(adTopPushViewHolder);
            startCountDown(adTopPushViewHolder, topPushTemplateData);
        } catch (Exception e) {
            e.printStackTrace();
            YFLog.error(this.tag + "jd bindData error " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-jd-JDTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1120lambda$bindData$0$comyfanadsadschaneljdJDTopPushAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    /* JADX INFO: renamed from: lambda$bindData$2$com-yfanads-ads-chanel-jd-JDTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1121lambda$bindData$2$comyfanadsadschaneljdJDTopPushAdapter(View view) {
        closeAds();
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        JADNative jADNative = this.jdNative;
        if (jADNative != null) {
            jADNative.destroy();
            this.jdNative = null;
        }
    }

    private void registerViewForInteraction(Activity activity, TopPushTemplateData topPushTemplateData, AdTopPushViewHolder adTopPushViewHolder, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(adTopPushViewHolder.viewGroup);
        if (adTopPushViewHolder.adCloseDelay != null) {
            arrayList.add(adTopPushViewHolder.adCloseDelay);
        }
        if (z) {
            bindMediaView(activity, adTopPushViewHolder, arrayList, arrayList2);
        } else {
            bindImageViews(activity, adTopPushViewHolder, arrayList, arrayList2);
        }
    }

    private void bindImageViews(Activity activity, AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2) {
        if (activity == null || this.jdNative == null) {
            return;
        }
        YFLog.high(this.tag + "jd bindData bindImageViews registerViewForInteraction");
        this.jdNative.registerNativeView(activity, adBaseViewHolder.viewGroup, list, list2, this);
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2) {
        if (activity != null) {
            YFLog.high(this.tag + "jd bindData bindMediaView registerViewForInteraction");
            this.jdNative.registerNativeView(activity, adBaseViewHolder.viewGroup, list, list2, this);
            final JDNativeAds yfNativeAd = getYfNativeAd(adBaseViewHolder, this.nativeAds);
            YFVideoPlayConfigImpl yFVideoPlayConfigImpl = new YFVideoPlayConfigImpl();
            yFVideoPlayConfigImpl.setVideoSoundEnable(!this.sdkSupplier.isMuted());
            final View videoView = yfNativeAd.getVideoView(activity, yFVideoPlayConfigImpl);
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.jd.JDTopPushAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    JDTopPushAdapter.lambda$bindMediaView$3(adBaseViewHolder, yfNativeAd, videoView);
                }
            });
        }
    }

    static /* synthetic */ void lambda$bindMediaView$3(AdBaseViewHolder adBaseViewHolder, JDNativeAds jDNativeAds, View view) {
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int videoWidth = jDNativeAds.getVideoWidth();
        int videoHeight = jDNativeAds.getVideoHeight();
        YFLog.high("height = " + height + " , videoWidth = " + videoWidth + " , videoHeight = " + videoHeight);
        if (videoWidth > 0 && videoHeight > 0) {
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, width, (videoHeight * width) / videoWidth);
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adBaseViewHolder.mediaViewFrame.removeAllViews();
        adBaseViewHolder.mediaViewFrame.addView(view);
    }

    private JDNativeAds getYfNativeAd(final AdBaseViewHolder adBaseViewHolder, JADMaterialData jADMaterialData) {
        final JDNativeAds jDNativeAds = new JDNativeAds(getContext(), this.jdNative, jADMaterialData, new YFNativeCall() { // from class: com.yfanads.ads.chanel.jd.JDTopPushAdapter.3
            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void handleClickByIndex(boolean z, int i) {
                YFLog.high(JDTopPushAdapter.this.tag + "newVersionAd handleClickByIndex");
            }

            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void handleClose() {
                YFLog.high(JDTopPushAdapter.this.tag + "newVersionAd handleClose");
            }

            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void handleExposureByIndex(int i) {
                YFLog.high(JDTopPushAdapter.this.tag + "newVersionAd handleExposureByIndex");
            }

            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void handleFailed(String str, String str2) {
                YFLog.high(JDTopPushAdapter.this.tag + "newVersionAd handleFailed");
            }

            @Override // com.yfanads.android.core.render.api.YFNativeCall
            public void showFeedBackDialog(FragmentManager fragmentManager, String str) {
                YFLog.high(JDTopPushAdapter.this.tag + "newVersionAd showFeedBackDialog");
            }
        });
        jDNativeAds.setVideoPlayListener(new JDVideoPlayListener() { // from class: com.yfanads.ads.chanel.jd.JDTopPushAdapter.4
            @Override // com.yfanads.ads.chanel.jd.model.JDVideoPlayListener
            public void onVideoPlayReady() {
                if (JDTopPushAdapter.this.jdNative != null) {
                    YFLog.debug(JDTopPushAdapter.this.tag + "onVideoPlayReady");
                    JDTopPushAdapter.this.jdNative.getJADVideoReporter().reportVideoWillStart();
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                if (JDTopPushAdapter.this.jdNative != null) {
                    YFLog.debug(JDTopPushAdapter.this.tag + "onVideoPlayStart " + jDNativeAds.getCurrentTime());
                    JDTopPushAdapter.this.jdNative.getJADVideoReporter().reportVideoStart(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                if (JDTopPushAdapter.this.jdNative != null) {
                    YFLog.debug(JDTopPushAdapter.this.tag + "onVideoPlayPause " + jDNativeAds.getCurrentTime());
                    JDTopPushAdapter.this.jdNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                if (JDTopPushAdapter.this.jdNative != null) {
                    YFLog.debug(JDTopPushAdapter.this.tag + "onVideoPlayResume " + jDNativeAds.getCurrentTime());
                    JDTopPushAdapter.this.jdNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
                if (JDTopPushAdapter.this.jdNative != null) {
                    YFLog.debug(JDTopPushAdapter.this.tag + "onVideoPlayError " + jDNativeAds.getCurrentTime());
                    JDTopPushAdapter.this.jdNative.getJADVideoReporter().reportVideoError(jDNativeAds.getCurrentTime(), i, i2);
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                if (JDTopPushAdapter.this.jdNative != null) {
                    YFLog.debug(JDTopPushAdapter.this.tag + "onVideoPlayComplete " + jDNativeAds.getCurrentTime());
                    JDTopPushAdapter.this.jdNative.getJADVideoReporter().reportVideoCompleted(jDNativeAds.getCurrentTime());
                    JDTopPushAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder, jDNativeAds);
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

    @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
    public void onExposure() {
        YFLog.high(this.tag + "newVersionAd onExposure");
        handleExposure();
    }

    @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
    public void onClick(View view) {
        YFLog.high(this.tag + "newVersionAd onClick");
        handleClick();
        closeAdsDelay();
    }

    @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
    public void onClose(View view) {
        YFLog.high(this.tag + "newVersionAd onAdClose");
        closeAds();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return JDUtil.getAdInfo(this.nativeAds, getRequestId());
    }
}
