package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.byazt.dyf.tt;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.cdo.oaps.ad.OapsKey;
import com.qq.e.ads.cfg.VideoOption;
import com.yfanads.ads.chanel.csj.holder.CsjSplashViewHolder;
import com.yfanads.ads.chanel.csj.template.AdSplashCloseViewHolder;
import com.yfanads.ads.chanel.csj.template.CsjSplashTemplateData;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.SplashCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.custom.view.AdSplashViewContainer;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.SplashTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjSplashAdapter extends SplashCustomAdapter implements CSJSplashAd.SplashAdListener, TTAdNative.CSJSplashAdListener, TTAdNative.FeedAdListener, TTNativeAd.AdInteractionListener, TTFeedAd.VideoAdListener {
    protected String ecpm;
    public TTFeedAd nativeAds;
    protected CSJSplashAd splashAd;
    private AdSplashCloseViewHolder splashCloseViewHolder;
    protected SplashTemplateData splashTemplateData;
    private CsjSplashViewHolder splashViewHolder;
    String tips;
    private AdSplashViewContainer yfSplashViewContainer;

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdComplete(TTFeedAd tTFeedAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdPaused(TTFeedAd tTFeedAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoError(int i, int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoLoad(TTFeedAd tTFeedAd) {
    }

    public CsjSplashAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        try {
            AdSplashCloseViewHolder adSplashCloseViewHolder = this.splashCloseViewHolder;
            if (adSplashCloseViewHolder != null) {
                adSplashCloseViewHolder.destroy();
                this.splashCloseViewHolder = null;
            }
            CSJSplashAd cSJSplashAd = this.splashAd;
            if (cSJSplashAd != null && cSJSplashAd.getMediationManager() != null) {
                this.splashAd.getMediationManager().destroy();
            }
            this.splashAd = null;
            this.yfSplashViewContainer = null;
            this.splashTemplateData = null;
            TTFeedAd tTFeedAd = this.nativeAds;
            if (tTFeedAd != null) {
                tTFeedAd.destroy();
                this.nativeAds = null;
            }
            CsjSplashViewHolder csjSplashViewHolder = this.splashViewHolder;
            if (csjSplashViewHolder != null) {
                csjSplashViewHolder.destroy();
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void showSplashAD(Activity activity, ViewGroup viewGroup) {
        if (this.splashAd == null) {
            handleShowFailed(this.tag + " doShowAD but splashAd is empty.");
            return;
        }
        if (isBidding()) {
            this.splashAd.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
        }
        if (this.splashAd.getMediationManager() != null && this.splashAd.getMediationManager().getBestEcpm() != null) {
            YFLog.debug(this.tag + " showSplashAD sdkName:" + this.splashAd.getMediationManager().getBestEcpm().getSdkName() + " view:" + this.splashAd.getSplashView());
        }
        if (viewGroup != null && isYFCloseStyle()) {
            AdSplashViewContainer adSplashViewContainer = new AdSplashViewContainer(viewGroup.getContext());
            this.yfSplashViewContainer = adSplashViewContainer;
            viewGroup.addView(adSplashViewContainer);
            super.doShowAD(this.yfSplashViewContainer, this.splashAd.getSplashView());
            return;
        }
        super.doShowAD(viewGroup, this.splashAd.getSplashView());
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void showNativeSplashAd(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAds == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
            return;
        }
        if (isBidding()) {
            this.nativeAds.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
        }
        String templateKey = this.sdkSupplier.getTemplateKey(TemplateRes.SPLASH_V2);
        int template = TemplateRes.getTemplate(templateKey);
        if (template == 0) {
            handleRenderFailed(0, " addView error has no id");
            return;
        }
        super.showNativeSplashAd(activity, viewGroup);
        CsjSplashTemplateData csjSplashTemplateData = new CsjSplashTemplateData(templateKey, isFullScreen());
        csjSplashTemplateData.setConf(this.sdkSupplier.getTemplateConf());
        View viewInflate = LayoutInflater.from(getContext()).inflate(template, (ViewGroup) null);
        this.splashViewHolder = new CsjSplashViewHolder(viewInflate, csjSplashTemplateData);
        bindData(activity, csjSplashTemplateData, this.nativeAds);
        addViewLister(viewInflate);
        handleApiExposure();
        doShowAD(viewGroup, viewInflate);
    }

    private void bindData(Activity activity, CsjSplashTemplateData csjSplashTemplateData, TTFeedAd tTFeedAd) {
        Context context = getContext();
        boolean zIsScreenLand = YFAdsPhone.getInstance().isScreenLand(activity);
        csjSplashTemplateData.updAdLog(R.mipmap.ad_log_ylh_v3);
        boolean zIsVideo = isVideo();
        if (!this.isSupportShake && csjSplashTemplateData.isAction()) {
            if (csjSplashTemplateData.isOnlyAction()) {
                csjSplashTemplateData.setBtnClick();
            }
            if (csjSplashTemplateData.isTemplateV1()) {
                csjSplashTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue());
            } else {
                csjSplashTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
            }
        }
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDescription(), zIsVideo, csjSplashTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        YFLog.high(this.tag + " bindData isVideo " + isVideo());
        updateDataView(csjSplashTemplateData, tTFeedAd, zIsVideo, zIsScreenLand);
        this.splashViewHolder.updateShowView(context, csjSplashTemplateData, zIsScreenLand);
        complianceContent(this.splashViewHolder, tTFeedAd);
        this.splashViewHolder.getCloseView(csjSplashTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjSplashAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1092lambda$bindData$0$comyfanadsadschanelcsjCsjSplashAdapter(view);
            }
        });
        registerViewForInteraction(zIsVideo, csjSplashTemplateData, this.splashViewHolder, tTFeedAd);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            this.splashViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjSplashAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1093lambda$bindData$1$comyfanadsadschanelcsjCsjSplashAdapter(fragmentManager, view);
                }
            });
        }
        int autoCloseTime = csjSplashTemplateData.getAutoCloseTime(5);
        String string = TextUtils.isEmpty(this.splashViewHolder.closeTips) ? getContext().getString(R.string.jump_tip) : this.splashViewHolder.closeTips;
        this.tips = string;
        this.splashViewHolder.setTevCountdown(String.format(string, Integer.valueOf(autoCloseTime)));
        startCloutDown(autoCloseTime, this.tips);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-csj-CsjSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1092lambda$bindData$0$comyfanadsadschanelcsjCsjSplashAdapter(View view) {
        handleClose(true);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-csj-CsjSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1093lambda$bindData$1$comyfanadsadschanelcsjCsjSplashAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(boolean z, CsjSplashTemplateData csjSplashTemplateData, CsjSplashViewHolder csjSplashViewHolder, TTFeedAd tTFeedAd) {
        int i = 0;
        try {
            if (isGromoreAdn() && csjSplashViewHolder.viewGroup != null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < csjSplashViewHolder.viewGroup.getChildCount(); i2++) {
                    arrayList.add(csjSplashViewHolder.viewGroup.getChildAt(i2));
                }
                csjSplashViewHolder.viewGroup.removeAllViews();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    relativeLayout.addView((View) arrayList.get(i3));
                }
                frameLayout.addView(relativeLayout);
                csjSplashViewHolder.viewGroup.addView(frameLayout);
            }
        } catch (Exception e) {
            e.printStackTrace();
            YFLog.error(this.tag + " registerViewForInteraction " + e.getLocalizedMessage());
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (csjSplashTemplateData.isWholeClick()) {
            if (csjSplashTemplateData.isShowDownloadDialog()) {
                arrayList2.add(this.splashViewHolder.viewGroup);
                if (isGromoreAdn() && csjSplashViewHolder.viewGroup.getChildCount() > 0 && csjSplashViewHolder.viewGroup.getChildAt(0) != null) {
                    View childAt = csjSplashViewHolder.viewGroup.getChildAt(0);
                    arrayList2.add(childAt);
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        if (viewGroup.getChildAt(0) != null) {
                            arrayList2.add(viewGroup.getChildAt(0));
                        }
                    }
                }
            } else {
                arrayList4.add(this.splashViewHolder.viewGroup);
                if (isGromoreAdn() && this.splashViewHolder.viewGroup.getChildCount() > 0 && this.splashViewHolder.viewGroup.getChildAt(0) != null) {
                    arrayList4.add(this.splashViewHolder.viewGroup.getChildAt(0));
                }
            }
            i = 1;
        }
        arrayList2.add(this.splashViewHolder.adCloseDelay);
        if (csjSplashTemplateData.isActionClickType()) {
            if (isDownloadType(tTFeedAd) && !csjSplashTemplateData.isActionShowDialog()) {
                arrayList4.add(this.splashViewHolder.barView);
                arrayList4.add(this.splashViewHolder.actionView);
                arrayList4.add(this.splashViewHolder.animationSlideView);
                if (csjSplashTemplateData.isBigStyle()) {
                    arrayList4.add(this.splashViewHolder.actionViewBig);
                }
            } else if (CsjUtil.getMAdnId(tTFeedAd) == 3) {
                arrayList2.add(this.splashViewHolder.barView);
                arrayList2.add(this.splashViewHolder.actionView);
                arrayList2.add(this.splashViewHolder.animationSlideView);
                if (csjSplashTemplateData.isBigStyle()) {
                    arrayList2.add(this.splashViewHolder.actionViewBig);
                }
            } else {
                arrayList3.add(this.splashViewHolder.barView);
                arrayList3.add(this.splashViewHolder.actionView);
                arrayList3.add(this.splashViewHolder.animationSlideView);
                if (csjSplashTemplateData.isBigStyle()) {
                    arrayList3.add(this.splashViewHolder.actionViewBig);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            arrayList2.add(new View(getContext()));
        }
        new FrameLayout.LayoutParams(1, 1).gravity = 53;
        if (z) {
            csjSplashViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjSplashAdapter$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(i, csjSplashViewHolder, tTFeedAd, arrayList2, arrayList3, arrayList4);
        } else {
            bindImageViews(csjSplashViewHolder, tTFeedAd, arrayList2, arrayList3, arrayList4);
        }
    }

    private void bindMediaView(int i, final AdBaseViewHolder adBaseViewHolder, final TTFeedAd tTFeedAd, List<View> list, List<View> list2, List<View> list3) {
        tTFeedAd.setVideoAdListener(this);
        final View adView = tTFeedAd.getAdView();
        if (i == 1 && isGromoreAdn()) {
            list.add(adView);
        }
        ViewGroup viewGroup = adBaseViewHolder.viewGroup;
        if (isGromoreAdn() && adBaseViewHolder.viewGroup.getChildCount() > 0) {
            viewGroup = (ViewGroup) adBaseViewHolder.viewGroup.getChildAt(0);
        }
        ViewGroup viewGroup2 = viewGroup;
        if (isGromoreAdn() && CsjUtil.getMAdnId(tTFeedAd) == 2) {
            m1094x21bfd92f(adBaseViewHolder, tTFeedAd, adView);
        } else {
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjSplashAdapter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1094x21bfd92f(adBaseViewHolder, tTFeedAd, adView);
                }
            });
        }
        tTFeedAd.registerViewForInteraction(viewGroup2, (List<View>) null, list, list2, list3, adBaseViewHolder.dislikeBtn, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addMediaView, reason: merged with bridge method [inline-methods] */
    public void m1094x21bfd92f(AdBaseViewHolder adBaseViewHolder, TTFeedAd tTFeedAd, View view) {
        try {
            int width = adBaseViewHolder.mediaViewFrame.getWidth();
            int width2 = adBaseViewHolder.mediaViewFrame.getWidth();
            int adViewWidth = tTFeedAd.getAdViewWidth();
            int adViewHeight = tTFeedAd.getAdViewHeight();
            if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
                updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, width2, adViewWidth, adViewHeight);
            } else if (adViewWidth != 0) {
                ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, width, (adViewHeight * width) / adViewWidth);
            }
            if (view == null || view.getParent() != null) {
                return;
            }
            adBaseViewHolder.mediaViewFrame.removeAllViews();
            adBaseViewHolder.mediaViewFrame.addView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bindImageViews(AdBaseViewHolder adBaseViewHolder, TTFeedAd tTFeedAd, List<View> list, List<View> list2, List<View> list3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adBaseViewHolder.showImg);
        ViewGroup viewGroup = adBaseViewHolder.viewGroup;
        if (isGromoreAdn() && adBaseViewHolder.viewGroup.getChildCount() > 0) {
            viewGroup = (ViewGroup) adBaseViewHolder.viewGroup.getChildAt(0);
        }
        tTFeedAd.registerViewForInteraction(viewGroup, arrayList, list, list2, list3, adBaseViewHolder.dislikeBtn, this);
    }

    private void updateDataView(CsjSplashTemplateData csjSplashTemplateData, TTFeedAd tTFeedAd, boolean z, boolean z2) {
        TTImage tTImage;
        if (z) {
            this.splashViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (tTFeedAd.getVideoCoverImage() != null && !TextUtils.isEmpty(tTFeedAd.getVideoCoverImage().getImageUrl())) {
                ViewUtils.loadBlurImage(tTFeedAd.getVideoCoverImage().getImageUrl(), this.splashViewHolder.imageBlur, 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, this.splashViewHolder.imageBlur);
            }
        } else {
            this.splashViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (!YFListUtils.isEmpty(tTFeedAd.getImageList()) && (tTImage = tTFeedAd.getImageList().get(0)) != null && !TextUtils.isEmpty(tTImage.getImageUrl())) {
                this.feedBean.imageUrl = tTImage.getImageUrl();
                ViewUtils.loadBlurImage(tTImage.getImageUrl(), this.splashViewHolder.imageBlur, 20);
                if (ViewUtils.isHorizontal(tTImage.getWidth(), tTImage.getHeight())) {
                    setHBackground(this.splashViewHolder.showImageArea);
                }
                ViewUtils.loadImage(tTImage.getImageUrl(), this.splashViewHolder.showImg);
            }
        }
        if (isGromoreAdn()) {
            int mAdnId = CsjUtil.getMAdnId(tTFeedAd);
            if (mAdnId == 4) {
                csjSplashTemplateData.updAdLog(R.mipmap.ad_log_ks_v3);
            } else if (mAdnId == 3) {
                csjSplashTemplateData.updAdLog(R.mipmap.ad_log_bd_v3);
            } else if (mAdnId == 2) {
                csjSplashTemplateData.updAdLog(R.mipmap.ad_log_ylh_v3);
            } else {
                csjSplashTemplateData.updAdLog(R.mipmap.ad_log_csj_v3);
            }
        } else {
            csjSplashTemplateData.updAdLog(R.mipmap.ad_log_csj_v3);
        }
        if (csjSplashTemplateData.isShowTopArea(z2)) {
            TTImage icon = tTFeedAd.getIcon();
            if (icon != null) {
                ViewUtils.loadCircleImage(icon.getImageUrl(), this.splashViewHolder.adIconSmall, 8);
            }
            this.splashViewHolder.adIconNameSmall.setText(TextUtils.isEmpty(tTFeedAd.getTitle()) ? tTFeedAd.getDescription() : tTFeedAd.getTitle());
        }
        if (csjSplashTemplateData.isTemplateV2()) {
            this.splashViewHolder.adDes.setText(TextUtils.isEmpty(tTFeedAd.getDescription()) ? tTFeedAd.getTitle() : tTFeedAd.getDescription());
        }
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder, TTFeedAd tTFeedAd) {
        if (isDownloadType(tTFeedAd)) {
            ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
            if (complianceInfo == null) {
                YFLog.error(this.tag + " has no complianceInfo, return.");
                adBaseViewHolder.complianceContent.setVisibility(8);
                return;
            } else {
                complianceView(adBaseViewHolder, new DownloadAppInfo(complianceInfo.getAppName(), complianceInfo.getAppVersion(), complianceInfo.getDeveloperName(), complianceInfo.getFunctionDescUrl(), complianceInfo.getPermissionUrl(), complianceInfo.getPrivacyUrl()));
                if (this.feedBean != null) {
                    this.feedBean.updateAppInfo(complianceInfo.getAppName(), complianceInfo.getAppVersion(), complianceInfo.getDeveloperName());
                    return;
                }
                return;
            }
        }
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    private boolean isDownloadType(TTFeedAd tTFeedAd) {
        YFLog.debug("adType getInteractionType:" + tTFeedAd.getInteractionType());
        return tTFeedAd.getInteractionType() == 4;
    }

    private boolean isVideo() {
        return this.nativeAds.getImageMode() == 5 || this.nativeAds.getImageMode() == 15;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isNative()) {
            TTFeedAd tTFeedAd = this.nativeAds;
            return tTFeedAd != null ? CsjUtil.getReqId(tTFeedAd.getMediaExtraInfo()) : "";
        }
        CSJSplashAd cSJSplashAd = this.splashAd;
        return cSJSplashAd != null ? CsjUtil.getReqId(cSJSplashAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YFLog.debug(this.tag + " start to doLoadAD");
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjSplashAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YFLog.debug(CsjSplashAdapter.this.tag + " init success context:" + context + " real to doLoadAD");
                if (CsjSplashAdapter.this.splashTemplateData == null) {
                    CsjSplashAdapter.this.splashTemplateData = new SplashTemplateData("", CsjSplashAdapter.this.mSplashSetting == null || CsjSplashAdapter.this.isFullScreen());
                    if (CsjSplashAdapter.this.sdkSupplier != null) {
                        CsjSplashAdapter.this.splashTemplateData.setConf(CsjSplashAdapter.this.sdkSupplier.getTemplateConf());
                    }
                }
                CsjSplashAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjSplashAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void loadSplashAd(Context context) {
        int[] sizeDp = getSizeDp();
        int[] sizePx = getSizePx();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setSupportDeepLink(true).setExpressViewAcceptedSize(sizeDp[0], sizeDp[1]).setImageAcceptedSize(sizePx[0], sizePx[1]).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setVolume(0.7f).setBidNotify(true).build()).build();
        TTAdNative tTAdNativeCreateAdNative = CsjUtil.getADManger().createAdNative(context);
        YFLog.high(this.tag + "doLoadAD -- " + Arrays.toString(sizeDp) + " dp, " + (this.mSplashSetting != null && this.mSplashSetting.isCustom()));
        tTAdNativeCreateAdNative.loadSplashAd(adSlotBuild, this, this.sdkSupplier.requestTimeout > 0 ? (int) this.sdkSupplier.requestTimeout : 3000);
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void loadNativeSplashAd(Context context) {
        TTAdNative tTAdNativeCreateAdNative = CsjUtil.getADManger().createAdNative(context);
        SplashTemplateData splashTemplateData = this.splashTemplateData;
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setExtraObject(MediationConstant.KEY_GDT_VIDEO_OPTION, new VideoOption.Builder().setAutoPlayMuted(this.sdkSupplier.isMute()).setEnableUserControl(splashTemplateData == null || !splashTemplateData.isWholeClick()).setAutoPlayPolicy(1).build()).setExtraObject(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS, new FrameLayout.LayoutParams(0, 0)).build()).setSupportDeepLink(true).build();
        YFLog.high(this.tag + "doLoadAD -- ");
        tTAdNativeCreateAdNative.loadFeedAd(adSlotBuild, this);
    }

    private void newApiAdFailed(CSJAdError cSJAdError, String str, String str2) {
        YFAdError err;
        try {
            if (cSJAdError == null) {
                err = YFAdError.parseErr(str, str2);
            } else {
                err = YFAdError.parseErr(cSJAdError.getCode(), cSJAdError.getMsg());
            }
            handleFailed(err);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (isNative()) {
            TTFeedAd tTFeedAd = this.nativeAds;
            return (tTFeedAd == null || tTFeedAd.getMediationManager() == null || !this.nativeAds.getMediationManager().isReady()) ? false : true;
        }
        CSJSplashAd cSJSplashAd = this.splashAd;
        return (cSJSplashAd == null || cSJSplashAd.getMediaExtraInfo() == null || !this.splashAd.getMediationManager().isReady()) ? false : true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
        CSJSplashAd cSJSplashAd2;
        if (isGromoreAdn() && isBidding() && (cSJSplashAd2 = this.splashAd) != null && cSJSplashAd2.getMediationManager() != null) {
            MediationAdEcpmInfo showEcpm = this.splashAd.getMediationManager().getShowEcpm();
            if (showEcpm != null) {
                String mShowEcpm = CsjUtil.getMShowEcpm(showEcpm);
                this.ecpm = mShowEcpm;
                if (!TextUtils.isEmpty(mShowEcpm)) {
                    setEcpmByStr(this.ecpm);
                }
            }
            YFLog.high(this.tag + "onSplashAdShow onAdShow tt onAdShow ep_" + this.ecpm);
        } else {
            YFLog.high(this.tag + "onSplashAdShow onAdShow tt");
        }
        handleExposure();
        try {
            if (this.yfSplashViewContainer == null || this.splashTemplateData == null || !isYFCloseStyle()) {
                return;
            }
            AdSplashCloseViewHolder adSplashCloseViewHolder = new AdSplashCloseViewHolder(this.yfSplashViewContainer);
            this.splashCloseViewHolder = adSplashCloseViewHolder;
            adSplashCloseViewHolder.updateClose(getContext(), this.splashTemplateData, new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjSplashAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1095x846d1ee4(view);
                }
            });
            Util.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjSplashAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1097xb9aea3e6();
                }
            }, this.splashTemplateData.getCloseDelay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: lambda$onSplashAdShow$4$com-yfanads-ads-chanel-csj-CsjSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1095x846d1ee4(View view) {
        handleClose();
    }

    /* JADX INFO: renamed from: lambda$onSplashAdShow$5$com-yfanads-ads-chanel-csj-CsjSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1096x1f0de165(View view) {
        handleClose();
    }

    /* JADX INFO: renamed from: lambda$onSplashAdShow$6$com-yfanads-ads-chanel-csj-CsjSplashAdapter, reason: not valid java name */
    /* synthetic */ void m1097xb9aea3e6() {
        AdSplashCloseViewHolder adSplashCloseViewHolder = this.splashCloseViewHolder;
        if (adSplashCloseViewHolder != null) {
            adSplashCloseViewHolder.setCloseListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjSplashAdapter$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1096x1f0de165(view);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
        handlePauseTimer();
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i) {
        YFLog.high(this.tag + "onSplashAdClose closeType:" + i);
        handlePauseTimer();
        handleClose(i == 1);
    }

    private void handlePauseTimer() {
        AdSplashCloseViewHolder adSplashCloseViewHolder = this.splashCloseViewHolder;
        if (adSplashCloseViewHolder != null) {
            adSplashCloseViewHolder.pauseTimer("onClick");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
        YFLog.high(this.tag + "onSplashLoadSuccess");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashLoadFail(CSJAdError cSJAdError) {
        YFLog.high(this.tag + "onSplashLoadFail " + this.sdkSupplier);
        newApiAdFailed(cSJAdError, YFAdError.ERROR_EXCEPTION_LOAD, "onSplashLoadFail ");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
        YFLog.high(this.tag + "onAdLoaded");
        if (cSJSplashAd == null) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL, this.tag + " TTSplashAd null"));
            return;
        }
        this.splashAd = cSJSplashAd;
        if (this.splashTemplateData == null) {
            this.splashTemplateData = new SplashTemplateData("", this.mSplashSetting == null || isFullScreen());
            if (this.sdkSupplier != null) {
                this.splashTemplateData.setConf(this.sdkSupplier.getTemplateConf());
            }
        }
        if (this.mSplashSetting != null && isYFCloseStyle()) {
            YFLog.debug(this.tag + "hideSkipButton is true");
            CSJSplashAd cSJSplashAd2 = this.splashAd;
            if (cSJSplashAd2 != null) {
                cSJSplashAd2.hideSkipButton();
            }
        } else {
            YFLog.debug(this.tag + "hideSkipButton is false");
        }
        if (isBidding()) {
            updPrice();
            setEcpmByStr(this.ecpm);
        }
        handleSucceed();
        CSJSplashAd cSJSplashAd3 = this.splashAd;
        if (cSJSplashAd3 != null) {
            cSJSplashAd3.setSplashAdListener(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
        if (isStartShow()) {
            if (cSJAdError != null) {
                YFLog.error(this.tag + " onSplashRenderFail msg: " + cSJAdError.getMsg() + "_" + cSJAdError.getCode());
                handleRenderFailed(cSJAdError.getCode(), cSJAdError.getMsg());
            } else {
                handleRenderFailed();
            }
            YFLog.high(this.tag + "onSplashRenderFail");
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    protected void updPrice() {
        try {
            CSJSplashAd cSJSplashAd = this.splashAd;
            Object obj = "1";
            if (cSJSplashAd != null && cSJSplashAd.getMediaExtraInfo() != null) {
                Object obj2 = this.splashAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                if (obj2 == null) {
                    obj2 = "1";
                }
                this.ecpm = String.valueOf(obj2);
            }
            TTFeedAd tTFeedAd = this.nativeAds;
            if (tTFeedAd == null || tTFeedAd.getMediaExtraInfo() == null) {
                return;
            }
            Object obj3 = this.nativeAds.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
            if (obj3 != null) {
                obj = obj3;
            }
            this.ecpm = String.valueOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.custom.SplashCustomAdapter
    public void countDownTimerOnTick(String str, int i) {
        super.countDownTimerOnTick(str, i);
        CsjSplashViewHolder csjSplashViewHolder = this.splashViewHolder;
        if (csjSplashViewHolder != null) {
            csjSplashViewHolder.setTevCountdown(String.format(str, Integer.valueOf(i)));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        CSJSplashAd cSJSplashAd = this.splashAd;
        String shortString = "";
        if (cSJSplashAd != null) {
            cSJSplashAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        TTFeedAd tTFeedAd = this.nativeAds;
        if (tTFeedAd != null) {
            tTFeedAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        CSJSplashAd cSJSplashAd = this.splashAd;
        if (cSJSplashAd != null && sdkSupplier != null) {
            cSJSplashAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        TTFeedAd tTFeedAd = this.nativeAds;
        if (tTFeedAd == null || sdkSupplier == null) {
            return;
        }
        tTFeedAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    private boolean isYFCloseStyle() {
        SplashTemplateData splashTemplateData = this.splashTemplateData;
        return splashTemplateData != null && splashTemplateData.getSplashCloseStyle() == 2;
    }

    private boolean isGromoreAdn() {
        return getAdnId() == YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        YFLog.high(this.tag + "onNativeAdLoad");
        if (list != null) {
            try {
                if (!list.isEmpty() && list.get(0) != null) {
                    this.nativeAds = list.get(0);
                    if (isBidding()) {
                        updPrice();
                        setEcpmByStr(this.ecpm);
                    }
                    handleSucceed();
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                return;
            }
        }
        handleFailed(YFAdError.ERROR_DATA_NULL, "");
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        YFLog.high(this.tag + "onAdShow onAdShow");
        if (isGromoreAdn() && isBidding() && tTNativeAd != null && tTNativeAd.getMediationManager() != null) {
            MediationAdEcpmInfo showEcpm = tTNativeAd.getMediationManager().getShowEcpm();
            if (showEcpm != null) {
                String mShowEcpm = CsjUtil.getMShowEcpm(showEcpm);
                this.ecpm = mShowEcpm;
                if (!TextUtils.isEmpty(mShowEcpm)) {
                    setEcpmByStr(this.ecpm);
                }
            }
            YFLog.high(this.tag + "native onAdShow ep_" + this.ecpm);
        } else {
            YFLog.high(this.tag + "native onAdShow tt");
        }
        handleExposure();
    }
}
