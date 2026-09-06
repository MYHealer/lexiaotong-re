package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.qq.e.ads.cfg.VideoOption;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.toppush.YFTopPushSetting;
import com.yfanads.android.custom.TopPushCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdTopPushViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.TopPushTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjTopPushAdapter extends TopPushCustomAdapter implements TTFeedAd.VideoAdListener, TTAdNative.FeedAdListener, TTNativeAd.AdInteractionListener {
    protected String ecpm;
    protected TopPushTemplateData interTemplateData;
    public TTFeedAd nativeAds;

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    public CsjTopPushAdapter(YFTopPushSetting yFTopPushSetting) {
        super(yFTopPushSetting);
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        try {
            TTFeedAd tTFeedAd = this.nativeAds;
            if (tTFeedAd != null) {
                tTFeedAd.destroy();
                this.nativeAds = null;
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjTopPushAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                if (CsjTopPushAdapter.this.interTemplateData == null) {
                    CsjTopPushAdapter.this.interTemplateData = new TopPushTemplateData(context, "", CsjTopPushAdapter.this.sdkSupplier.getTemplateConf());
                }
                CsjTopPushAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjTopPushAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        try {
            if (isNative()) {
                showNativeADs(activity);
            } else {
                handleShowFailed();
            }
        } catch (Exception e) {
            e.printStackTrace();
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        TTFeedAd tTFeedAd;
        return (!isNative() || (tTFeedAd = this.nativeAds) == null) ? "" : CsjUtil.getReqId(tTFeedAd.getMediaExtraInfo());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            loadInterstitialAdByNative(context);
        } else {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        TTFeedAd tTFeedAd;
        return isNative() && (tTFeedAd = this.nativeAds) != null && tTFeedAd.getMediationManager() != null && this.nativeAds.getMediationManager().isReady();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    private void loadInterstitialAdByNative(Context context) {
        CsjUtil.getADManger().createAdNative(context).loadFeedAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setExtraObject(MediationConstant.KEY_GDT_VIDEO_OPTION, new VideoOption.Builder().setAutoPlayMuted(this.sdkSupplier.isMute()).setEnableUserControl(false).setAutoPlayPolicy(1).build()).setExtraObject(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS, new FrameLayout.LayoutParams(0, 0)).build()).setSupportDeepLink(true).build(), this);
    }

    private void showNativeADs(Activity activity) {
        if (this.nativeAds == null) {
            handleShowFailed(this.tag + " nativeAds is null, return. ");
            return;
        }
        if (isBidding()) {
            this.nativeAds.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
        }
        YFLog.high(this.tag + " adId = " + this.sdkSupplier.getAdId() + " showNativeADs = " + this.nativeAds.getMediaExtraInfo() + " isReady = " + (this.nativeAds.getMediationManager() != null ? Boolean.valueOf(this.nativeAds.getMediationManager().isReady()) : ""));
        addView(activity);
    }

    @Override // com.yfanads.android.custom.TopPushCustomAdapter
    public void bindData(Activity activity, TopPushTemplateData topPushTemplateData, AdBaseViewHolder adBaseViewHolder) {
        TTImage tTImage;
        TTImage tTImage2;
        if (this.nativeAds == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        topPushTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        boolean z = this.nativeAds.getImageMode() == 5 || this.nativeAds.getImageMode() == 15;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDescription(), z, topPushTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (this.nativeAds.getVideoCoverImage() != null && !TextUtils.isEmpty(this.nativeAds.getVideoCoverImage().getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adBaseViewHolder.imageBlur, 0);
            } else if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && this.nativeAds.getImageList().get(0) != null && !TextUtils.isEmpty(this.nativeAds.getImageList().get(0).getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImageList().get(0).getImageUrl(), adBaseViewHolder.imageBlur, 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (tTImage = this.nativeAds.getImageList().get(0)) != null && !TextUtils.isEmpty(tTImage.getImageUrl())) {
                this.feedBean.imageUrl = tTImage.getImageUrl();
                ViewUtils.loadBlurImage(tTImage.getImageUrl(), adBaseViewHolder.imageBlur, 0);
                ViewUtils.loadImage(tTImage.getImageUrl(), adBaseViewHolder.showImg);
            }
        }
        if (isGromoreAdn()) {
            int mAdnId = CsjUtil.getMAdnId(this.nativeAds);
            if (mAdnId == 4) {
                topPushTemplateData.updAdLog(R.mipmap.ad_log_ks_v4);
            } else if (mAdnId == 3) {
                topPushTemplateData.updAdLog(R.mipmap.ad_log_bd_v4);
            } else if (mAdnId == 2) {
                topPushTemplateData.updAdLog(R.mipmap.ad_log_ylh_v4);
            } else {
                topPushTemplateData.updAdLog(R.mipmap.ad_log_csj_v4);
            }
        } else {
            topPushTemplateData.updAdLog(R.mipmap.ad_log_csj_v4);
        }
        AdTopPushViewHolder adTopPushViewHolder = (AdTopPushViewHolder) adBaseViewHolder;
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
        TTImage icon = this.nativeAds.getIcon();
        if (icon != null) {
            ViewUtils.loadCircleImage(icon.getImageUrl(), adTopPushViewHolder.adIcon, 8);
        } else if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (tTImage2 = this.nativeAds.getImageList().get(0)) != null && !TextUtils.isEmpty(tTImage2.getImageUrl())) {
            ViewUtils.loadImage(tTImage2.getImageUrl(), adTopPushViewHolder.adIcon);
        }
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
        adTopPushViewHolder.updateShowView(getContext(), topPushTemplateData);
        updateUi(adTopPushViewHolder);
        adTopPushViewHolder.getCloseView(topPushTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjTopPushAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1098lambda$bindData$0$comyfanadsadschanelcsjCsjTopPushAdapter(view);
            }
        });
        registerViewForInteraction(adTopPushViewHolder, topPushTemplateData, z, this.nativeAds);
        if (activity != null) {
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adTopPushViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjTopPushAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1099lambda$bindData$1$comyfanadsadschanelcsjCsjTopPushAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adTopPushViewHolder, this.nativeAds);
        startCountDown(adTopPushViewHolder, topPushTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-csj-CsjTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1098lambda$bindData$0$comyfanadsadschanelcsjCsjTopPushAdapter(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-csj-CsjTopPushAdapter, reason: not valid java name */
    /* synthetic */ void m1099lambda$bindData$1$comyfanadsadschanelcsjCsjTopPushAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void updateUi(AdTopPushViewHolder adTopPushViewHolder) {
        if (adTopPushViewHolder.closeBtn != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) adTopPushViewHolder.closeBtn.getLayoutParams();
            layoutParams.addRule(21);
            adTopPushViewHolder.closeBtn.setLayoutParams(layoutParams);
        }
        if (adTopPushViewHolder.comlianceArea != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adTopPushViewHolder.comlianceArea.getLayoutParams();
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = ScreenUtil.dip2px(getContext(), 3.0f);
            adTopPushViewHolder.comlianceArea.setLayoutParams(layoutParams2);
            adTopPushViewHolder.comlianceArea.requestLayout();
        }
    }

    private void registerViewForInteraction(AdTopPushViewHolder adTopPushViewHolder, TopPushTemplateData topPushTemplateData, boolean z, TTFeedAd tTFeedAd) {
        int i = 0;
        try {
            if (isGromoreAdn() && adTopPushViewHolder.viewGroup != null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < adTopPushViewHolder.viewGroup.getChildCount(); i2++) {
                    arrayList.add(adTopPushViewHolder.viewGroup.getChildAt(i2));
                }
                adTopPushViewHolder.viewGroup.removeAllViews();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    relativeLayout.addView((View) arrayList.get(i3));
                }
                frameLayout.addView(relativeLayout);
                adTopPushViewHolder.viewGroup.addView(frameLayout);
            }
        } catch (Exception e) {
            e.printStackTrace();
            YFLog.error(this.tag + " registerViewForInteraction " + e.getLocalizedMessage());
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList2.add(adTopPushViewHolder.viewGroup);
        if (isGromoreAdn() && adTopPushViewHolder.viewGroup.getChildCount() > 0 && adTopPushViewHolder.viewGroup.getChildAt(0) != null) {
            View childAt = adTopPushViewHolder.viewGroup.getChildAt(0);
            arrayList2.add(childAt);
            if (childAt instanceof ViewGroup) {
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    }
                    arrayList2.add(viewGroup.getChildAt(i));
                    i++;
                }
            }
        }
        if (adTopPushViewHolder.adCloseDelay != null) {
            arrayList2.add(adTopPushViewHolder.adCloseDelay);
        }
        if (z) {
            bindMediaView(1, adTopPushViewHolder, tTFeedAd, arrayList2, arrayList3, arrayList4);
        } else {
            bindImageViews(adTopPushViewHolder, tTFeedAd, arrayList2, arrayList3, arrayList4);
        }
    }

    private boolean isGromoreAdn() {
        return getAdnId() == YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }

    private boolean isDownloadType(TTFeedAd tTFeedAd) {
        YFLog.debug("adType getInteractionType:" + tTFeedAd.getInteractionType());
        return tTFeedAd.getInteractionType() == 4;
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
            ViewGroup.LayoutParams layoutParams = adView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = -2;
            } else {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(13);
            } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            }
            adView.setLayoutParams(layoutParams);
            m1100x6f562b3a(adBaseViewHolder, tTFeedAd, adView);
        } else {
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjTopPushAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1100x6f562b3a(adBaseViewHolder, tTFeedAd, adView);
                }
            });
        }
        tTFeedAd.registerViewForInteraction(viewGroup2, (List<View>) null, list, list2, list3, adBaseViewHolder.dislikeBtn, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addMediaView, reason: merged with bridge method [inline-methods] */
    public void m1100x6f562b3a(AdBaseViewHolder adBaseViewHolder, TTFeedAd tTFeedAd, View view) {
        try {
            updateMaterialArea(adBaseViewHolder.mediaViewFrame, adBaseViewHolder.mediaViewFrame.getWidth(), adBaseViewHolder.mediaViewFrame.getWidth(), tTFeedAd.getAdViewWidth(), tTFeedAd.getAdViewHeight());
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
            list.add(viewGroup);
        }
        tTFeedAd.registerViewForInteraction(viewGroup, arrayList, list, list2, list3, adBaseViewHolder.dislikeBtn, this);
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

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        YFLog.high(this.tag + "onNativeAdLoad");
        if (list != null) {
            try {
                if (list.size() != 0 && list.get(0) != null) {
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

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
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

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        YFLog.debug(this.tag + " native onAdClicked");
        handleClick();
        closeAdsDelay();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        handleClick();
        closeAdsDelay();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    protected void updPrice() {
        TTFeedAd tTFeedAd;
        try {
            if (!isNative() || (tTFeedAd = this.nativeAds) == null || tTFeedAd.getMediaExtraInfo() == null) {
                return;
            }
            Object obj = this.nativeAds.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
            if (obj == null) {
                obj = "1";
            }
            this.ecpm = String.valueOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        TTFeedAd tTFeedAd = this.nativeAds;
        if (tTFeedAd != null) {
            tTFeedAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
            String shortString = "";
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        TTFeedAd tTFeedAd = this.nativeAds;
        if (tTFeedAd == null || sdkSupplier == null) {
            return;
        }
        tTFeedAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return CsjUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoLoad(TTFeedAd tTFeedAd) {
        YFLog.debug(this.tag + "onVideoLoad");
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoError(int i, int i2) {
        YFLog.debug(this.tag + "onVideoError " + i + PPSLabelView.Code + i2 + PPSLabelView.Code + i);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
        YFLog.debug(this.tag + "onVideoAdStartPlay");
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdPaused(TTFeedAd tTFeedAd) {
        YFLog.debug(this.tag + "onVideoAdPaused");
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
        YFLog.debug(this.tag + "onVideoAdContinuePlay");
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdComplete(TTFeedAd tTFeedAd) {
        YFLog.debug(this.tag + "onVideoAdComplete");
    }
}
