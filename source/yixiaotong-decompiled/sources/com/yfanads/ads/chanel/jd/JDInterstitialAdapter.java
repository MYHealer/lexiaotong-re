package com.yfanads.ads.chanel.jd;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFVideoPlayConfigImpl;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.model.template.InterV3TemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class JDInterstitialAdapter extends InterstitialCustomAdapter implements JADNativeInteractionListener {
    private JADNative jdNative;
    private JADSlot mSlot;
    private JADMaterialData nativeAds;

    public JDInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        JDUtil.initJD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                JDInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                JDInterstitialAdapter.this.handleFailed(str, str2);
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
        jADNative.loadAd(new JADNativeLoadListener() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter.2
            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadSuccess() {
                YFLog.high(JDInterstitialAdapter.this.tag + "onNativeAdLoad");
                try {
                    List<JADMaterialData> dataList = JDInterstitialAdapter.this.jdNative.getDataList();
                    if (dataList != null && dataList.size() != 0 && dataList.get(0) != null) {
                        JDInterstitialAdapter.this.nativeAds = dataList.get(0);
                        if (JDInterstitialAdapter.this.jdNative != null) {
                            JDInterstitialAdapter jDInterstitialAdapter = JDInterstitialAdapter.this;
                            jDInterstitialAdapter.setEcpm(jDInterstitialAdapter.jdNative.getJADExtra().getPrice());
                        }
                        JDInterstitialAdapter.this.handleSucceed();
                        return;
                    }
                    JDInterstitialAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } catch (Throwable th) {
                    th.printStackTrace();
                    JDInterstitialAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadFailure(int i, String str) {
                JDInterstitialAdapter.this.handleFailed(i, str);
            }
        });
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
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

    /* JADX WARN: Code duplicated, block: B:30:0x010c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0113  */
    /* JADX WARN: Code duplicated, block: B:34:0x0125  */
    /* JADX WARN: Code duplicated, block: B:35:0x012c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0136  */
    /* JADX WARN: Code duplicated, block: B:40:0x013b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0141  */
    /* JADX WARN: Code duplicated, block: B:44:0x0157  */
    /* JADX WARN: Code duplicated, block: B:46:0x015c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0170  */
    /* JADX WARN: Code duplicated, block: B:52:0x0178  */
    /* JADX WARN: Code duplicated, block: B:55:0x0192  */
    /* JADX WARN: Code duplicated, block: B:57:0x0198  */
    /* JADX WARN: Code duplicated, block: B:59:0x019e  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x01cc  */
    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, final AdBaseViewHolder adBaseViewHolder) {
        String title;
        String description;
        View view;
        View shakeView;
        int value;
        AdInterV2ViewHolder adInterV2ViewHolder;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.nativeAds.getVideoUrl());
        boolean z3 = adBaseViewHolder instanceof AdInterV2ViewHolder;
        YFLog.high(this.tag + "jd bindData isVideo " + z2 + " isInterV2 " + z3);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDescription(), z2, interTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        adBaseViewHolder.adLogoIcon.setVisibility(8);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.m1114x9c9923d6(fragmentManager, view2);
                }
            });
        }
        if (this.nativeAds == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        if (z2) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            adBaseViewHolder.showImageArea.setVisibility(4);
            if (!YFListUtils.isEmpty(this.nativeAds.getImageUrls())) {
                String str = this.nativeAds.getImageUrls().get(0);
                if (!TextUtils.isEmpty(str)) {
                    ViewUtils.loadBlurImage(str, adBaseViewHolder.imageBlur, z3 ? 20 : 0);
                    if (z3 && ViewUtils.isHorizontal(this.nativeAds.getImageWidth(), this.nativeAds.getImageHeight())) {
                        setHBackground(adBaseViewHolder.showImageArea);
                    } else {
                        z = false;
                    }
                    ViewUtils.loadImage(str, adBaseViewHolder.showImg, new ViewUtils.ViewImageCallback() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter$$ExternalSyntheticLambda1
                        @Override // com.yfanads.android.utils.ViewUtils.ViewImageCallback
                        public final void onResourceReady() {
                            adBaseViewHolder.showImageArea.setVisibility(0);
                        }
                    });
                }
            }
            adBaseViewHolder.adLogoIcon.setVisibility(0);
            interTemplateData.updAdLog(R.mipmap.ad_log_jd_v3);
            if (TextUtils.isEmpty(this.nativeAds.getTitle())) {
                title = this.nativeAds.getDescription();
            } else {
                title = this.nativeAds.getTitle();
            }
            if (TextUtils.isEmpty(this.nativeAds.getDescription())) {
                description = this.nativeAds.getTitle();
            } else {
                description = this.nativeAds.getDescription();
            }
            if (z3) {
                adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
                if (z) {
                    adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_SMALL);
                } else {
                    adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_BIG);
                }
                adInterV2ViewHolder.adIcon.setImageBitmap(JADNativeWidget.getJDLogo(getContext()));
                TextView textView = adInterV2ViewHolder.adIconName;
                if (title == null) {
                    title = "";
                }
                textView.setText(title);
            } else {
                AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
                adInterV3ViewHolder.adIcon.setImageBitmap(JADNativeWidget.getJDLogo(getContext()));
                TextView textView2 = adInterV3ViewHolder.adIconName;
                if (title == null) {
                    title = "";
                }
                textView2.setText(title);
            }
            TextView textView3 = adBaseViewHolder.adDes;
            if (description == null) {
                description = "";
            }
            textView3.setText(description);
            if (interTemplateData.isActionType(BaseTemplateData.InteractiveStyle.SHAKE.getValue(), BaseTemplateData.InteractiveStyle.CLICK_SHAKE.getValue())) {
                shakeView = getShakeView(adBaseViewHolder);
                if (shakeView == null) {
                    if (interTemplateData.isOnlyAction()) {
                        interTemplateData.setWholeClick();
                    }
                    if (z3) {
                        value = BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue();
                    } else {
                        value = BaseTemplateData.InteractiveStyle.CLICK_V3.getValue();
                    }
                    interTemplateData.resetActivityStyle(value);
                }
                view = shakeView;
            } else {
                view = null;
            }
            adBaseViewHolder.updateShowView(getContext(), interTemplateData);
            adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.m1115x9bac57d8(view2);
                }
            });
            if (activity != null) {
                this.feedBean.contextName = activity.getLocalClassName();
            }
            registerViewForInteraction(activity, interTemplateData, adBaseViewHolder, z2, view);
            complianceContent(adBaseViewHolder);
            startCountDown(adBaseViewHolder, interTemplateData);
        }
        z = false;
        adBaseViewHolder.adLogoIcon.setVisibility(0);
        interTemplateData.updAdLog(R.mipmap.ad_log_jd_v3);
        if (TextUtils.isEmpty(this.nativeAds.getTitle())) {
            title = this.nativeAds.getDescription();
        } else {
            title = this.nativeAds.getTitle();
        }
        if (TextUtils.isEmpty(this.nativeAds.getDescription())) {
            description = this.nativeAds.getTitle();
        } else {
            description = this.nativeAds.getDescription();
        }
        if (z3) {
            adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (z) {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_SMALL);
            } else {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_BIG);
            }
            adInterV2ViewHolder.adIcon.setImageBitmap(JADNativeWidget.getJDLogo(getContext()));
            TextView textView4 = adInterV2ViewHolder.adIconName;
            if (title == null) {
                title = "";
            }
            textView4.setText(title);
        } else {
            AdInterV3ViewHolder adInterV3ViewHolder2 = (AdInterV3ViewHolder) adBaseViewHolder;
            adInterV3ViewHolder2.adIcon.setImageBitmap(JADNativeWidget.getJDLogo(getContext()));
            TextView textView5 = adInterV3ViewHolder2.adIconName;
            if (title == null) {
                title = "";
            }
            textView5.setText(title);
        }
        TextView textView6 = adBaseViewHolder.adDes;
        if (description == null) {
            description = "";
        }
        textView6.setText(description);
        if (interTemplateData.isActionType(BaseTemplateData.InteractiveStyle.SHAKE.getValue(), BaseTemplateData.InteractiveStyle.CLICK_SHAKE.getValue())) {
            shakeView = getShakeView(adBaseViewHolder);
            if (shakeView == null) {
                if (interTemplateData.isOnlyAction()) {
                    interTemplateData.setWholeClick();
                }
                if (z3) {
                    value = BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue();
                } else {
                    value = BaseTemplateData.InteractiveStyle.CLICK_V3.getValue();
                }
                interTemplateData.resetActivityStyle(value);
            }
            view = shakeView;
        } else {
            view = null;
        }
        adBaseViewHolder.updateShowView(getContext(), interTemplateData);
        adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m1115x9bac57d8(view2);
            }
        });
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
        }
        registerViewForInteraction(activity, interTemplateData, adBaseViewHolder, z2, view);
        complianceContent(adBaseViewHolder);
        startCountDown(adBaseViewHolder, interTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-jd-JDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1114x9c9923d6(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    /* JADX INFO: renamed from: lambda$bindData$2$com-yfanads-ads-chanel-jd-JDInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1115x9bac57d8(View view) {
        closeAds();
    }

    private View getShakeView(AdBaseViewHolder adBaseViewHolder) {
        View shakeAnimationView = JADNativeWidget.getShakeAnimationView(getContext());
        if (shakeAnimationView != null) {
            addToView(shakeAnimationView, adBaseViewHolder);
        }
        return shakeAnimationView;
    }

    private void addToView(View view, AdBaseViewHolder adBaseViewHolder) {
        if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            int iDip2px = ScreenUtil.dip2px(getContext(), 100.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDip2px, iDip2px);
            layoutParams.addRule(13);
            view.setLayoutParams(layoutParams);
            view.setVisibility(4);
            adInterV2ViewHolder.viewGroup.addView(view);
            adInterV2ViewHolder.actionView.setVisibility(0);
            return;
        }
        AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
        int iDip2px2 = ScreenUtil.dip2px(getContext(), 50.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDip2px2, iDip2px2);
        layoutParams2.addRule(13);
        view.setLayoutParams(layoutParams2);
        adInterV3ViewHolder.viewGroup.addView(view);
        adInterV3ViewHolder.actionView.setVisibility(0);
    }

    private boolean isShakeType(BaseTemplateData baseTemplateData) {
        return baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.SHAKE || baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_SHAKE;
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    private void release(String str) {
        try {
            JADNative jADNative = this.jdNative;
            if (jADNative != null) {
                jADNative.destroy();
                this.jdNative = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + str + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void closeAds(boolean z) {
        release("closeAds");
        super.closeAds(z);
    }

    private void registerViewForInteraction(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder, boolean z, View view) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (view != null) {
            arrayList.add(view);
        }
        if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            arrayList.add(adInterV2ViewHolder.dyClickView);
            if (interTemplateData.isActionClickType()) {
                arrayList.add(adInterV2ViewHolder.animationClickView);
            }
        } else if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (interTemplateData instanceof InterV3TemplateData) {
                if (((InterV3TemplateData) interTemplateData).isWholeClick()) {
                    arrayList.add(adInterV3ViewHolder.viewGroup);
                    if (adInterV3ViewHolder.animationArea != null) {
                        arrayList.add(adInterV3ViewHolder.animationArea);
                    }
                }
                arrayList.add(adInterV3ViewHolder.adCloseDelay);
                if (interTemplateData.isActionClickType()) {
                    arrayList.add(adInterV3ViewHolder.actionView);
                    arrayList.add(adInterV3ViewHolder.animationClickView);
                }
            }
        }
        if (z) {
            adBaseViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(activity, adBaseViewHolder, arrayList, arrayList2);
        } else {
            bindImageViews(activity, adBaseViewHolder, arrayList, arrayList2);
        }
    }

    private void bindImageViews(Activity activity, AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2) {
        JADNative jADNative;
        if (activity == null || (jADNative = this.jdNative) == null) {
            return;
        }
        if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            jADNative.registerNativeView(activity, ((AdInterV3ViewHolder) adBaseViewHolder).animationArea, list, list2, this);
        } else {
            jADNative.registerNativeView(activity, adBaseViewHolder.viewGroup, list, list2, this);
        }
    }

    private void bindMediaView(Activity activity, final AdBaseViewHolder adBaseViewHolder, List<View> list, List<View> list2) {
        if (activity != null) {
            this.jdNative.registerNativeView(activity, adBaseViewHolder.viewGroup, list, list2, this);
            final JDNativeAds yfNativeAd = getYfNativeAd(adBaseViewHolder, this.nativeAds);
            YFVideoPlayConfigImpl yFVideoPlayConfigImpl = new YFVideoPlayConfigImpl();
            yFVideoPlayConfigImpl.setVideoSoundEnable(!this.sdkSupplier.isMuted());
            final View videoView = yfNativeAd.getVideoView(activity, yFVideoPlayConfigImpl);
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    JDInterstitialAdapter.lambda$bindMediaView$4(adBaseViewHolder, yfNativeAd, videoView);
                }
            });
        }
    }

    static /* synthetic */ void lambda$bindMediaView$4(AdBaseViewHolder adBaseViewHolder, JDNativeAds jDNativeAds, View view) {
        boolean z = adBaseViewHolder instanceof AdInterV3ViewHolder;
        int height = adBaseViewHolder.mediaViewFrame.getHeight();
        int width = adBaseViewHolder.mediaViewFrame.getWidth();
        int videoWidth = jDNativeAds.getVideoWidth();
        int videoHeight = jDNativeAds.getVideoHeight();
        YFLog.high("height = " + height + " , videoWidth = " + videoWidth + " , videoHeight = " + videoHeight);
        if (z) {
            if (videoWidth > 0 && videoHeight > 0 && !ViewUtils.isHorizontal(videoWidth, videoHeight)) {
                ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, (height * videoWidth) / videoHeight, videoHeight);
            }
        } else if (videoWidth > 0 && videoHeight > 0) {
            ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, width, (videoHeight * width) / videoWidth);
        }
        if (view == null || view.getParent() != null) {
            return;
        }
        adBaseViewHolder.mediaViewFrame.removeAllViews();
        adBaseViewHolder.mediaViewFrame.addView(view);
    }

    private JDNativeAds getYfNativeAd(final AdBaseViewHolder adBaseViewHolder, JADMaterialData jADMaterialData) {
        final JDNativeAds jDNativeAds = new JDNativeAds(getContext(), this.jdNative, jADMaterialData, new YFNativeCall() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter.3
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
        jDNativeAds.setVideoPlayListener(new JDVideoPlayListener() { // from class: com.yfanads.ads.chanel.jd.JDInterstitialAdapter.4
            @Override // com.yfanads.ads.chanel.jd.model.JDVideoPlayListener
            public void onVideoPlayReady() {
                if (JDInterstitialAdapter.this.jdNative != null) {
                    YFLog.debug(JDInterstitialAdapter.this.tag + "onVideoPlayReady");
                    JDInterstitialAdapter.this.jdNative.getJADVideoReporter().reportVideoWillStart();
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                if (JDInterstitialAdapter.this.jdNative != null) {
                    YFLog.debug(JDInterstitialAdapter.this.tag + "onVideoPlayStart " + jDNativeAds.getCurrentTime());
                    JDInterstitialAdapter.this.jdNative.getJADVideoReporter().reportVideoStart(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
                if (JDInterstitialAdapter.this.jdNative != null) {
                    YFLog.debug(JDInterstitialAdapter.this.tag + "onVideoPlayPause " + jDNativeAds.getCurrentTime());
                    JDInterstitialAdapter.this.jdNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
                if (JDInterstitialAdapter.this.jdNative != null) {
                    YFLog.debug(JDInterstitialAdapter.this.tag + "onVideoPlayResume " + jDNativeAds.getCurrentTime());
                    JDInterstitialAdapter.this.jdNative.getJADVideoReporter().reportVideoPause(jDNativeAds.getCurrentTime());
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
                if (JDInterstitialAdapter.this.jdNative != null) {
                    YFLog.debug(JDInterstitialAdapter.this.tag + "onVideoPlayError " + jDNativeAds.getCurrentTime());
                    JDInterstitialAdapter.this.jdNative.getJADVideoReporter().reportVideoError(jDNativeAds.getCurrentTime(), i, i2);
                }
            }

            @Override // com.yfanads.android.core.render.api.YFNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                if (JDInterstitialAdapter.this.jdNative != null) {
                    YFLog.debug(JDInterstitialAdapter.this.tag + "onVideoPlayComplete " + jDNativeAds.getCurrentTime());
                    JDInterstitialAdapter.this.jdNative.getJADVideoReporter().reportVideoCompleted(jDNativeAds.getCurrentTime());
                    JDInterstitialAdapter.this.updateWithVideoPlayComplete(adBaseViewHolder, jDNativeAds);
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
