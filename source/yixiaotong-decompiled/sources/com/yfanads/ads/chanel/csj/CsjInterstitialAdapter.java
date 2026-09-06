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
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.qq.e.ads.cfg.VideoOption;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.model.template.InterV3TemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjInterstitialAdapter extends InterstitialCustomAdapter implements TTAdNative.FullScreenVideoAdListener, TTFeedAd.VideoAdListener, TTAdNative.FeedAdListener, TTFullScreenVideoAd.FullScreenVideoAdInteractionListener, TTNativeAd.AdInteractionListener {
    protected String ecpm;
    protected InterTemplateData interTemplateData;
    public TTFeedAd nativeAds;
    public TTFullScreenVideoAd newVersionAd;
    private View video;

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    public CsjInterstitialAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        release("doDestroy");
    }

    public void release(String str) {
        try {
            TTFeedAd tTFeedAd = this.nativeAds;
            if (tTFeedAd != null) {
                tTFeedAd.destroy();
                this.nativeAds = null;
            }
            TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
            if (tTFullScreenVideoAd != null && tTFullScreenVideoAd.getMediationManager() != null) {
                this.newVersionAd.getMediationManager().destroy();
            }
            this.newVersionAd = null;
            View view = this.video;
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) this.video.getParent()).removeAllViews();
                }
                this.video = null;
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

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjInterstitialAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                if (CsjInterstitialAdapter.this.interTemplateData == null) {
                    CsjInterstitialAdapter.this.interTemplateData = new InterTemplateData(context, "", CsjInterstitialAdapter.this.sdkSupplier.getTemplateConf());
                }
                CsjInterstitialAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjInterstitialAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        try {
            if (isNative()) {
                showNativeADs(activity);
                return;
            }
            if (this.newVersionAd != null && activity != null) {
                if (isBidding()) {
                    this.newVersionAd.setPrice(Double.valueOf(YFUtil.toDouble(this.ecpm, 1.0d)));
                }
                this.newVersionAd.showFullScreenVideoAd(activity);
                return;
            }
            handleShowFailed();
        } catch (Exception e) {
            e.printStackTrace();
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isNative()) {
            TTFeedAd tTFeedAd = this.nativeAds;
            return tTFeedAd != null ? CsjUtil.getReqId(tTFeedAd.getMediaExtraInfo()) : "";
        }
        TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
        return tTFullScreenVideoAd != null ? CsjUtil.getReqId(tTFullScreenVideoAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isNative()) {
            loadInterstitialAdByNative(context);
        } else {
            loadInterstitialAd(context);
        }
    }

    private void loadInterstitialAd(Context context) {
        CsjUtil.getADManger().createAdNative(context).loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setVolume(0.7f).setBidNotify(true).build()).setSupportDeepLink(true).build(), this);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (isNative()) {
            TTFeedAd tTFeedAd = this.nativeAds;
            return (tTFeedAd == null || tTFeedAd.getMediationManager() == null || !this.nativeAds.getMediationManager().isReady()) ? false : true;
        }
        TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
        return (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getMediaExtraInfo() == null || !this.newVersionAd.getMediationManager().isReady()) ? false : true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    private void loadInterstitialAdByNative(Context context) {
        TTAdNative tTAdNativeCreateAdNative = CsjUtil.getADManger().createAdNative(context);
        InterTemplateData interTemplateData = this.interTemplateData;
        tTAdNativeCreateAdNative.loadFeedAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setExtraObject(MediationConstant.KEY_GDT_VIDEO_OPTION, new VideoOption.Builder().setAutoPlayMuted(this.sdkSupplier.isMute()).setEnableUserControl(interTemplateData == null || !interTemplateData.isWholeClick()).setAutoPlayPolicy(1).build()).setExtraObject(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS, new FrameLayout.LayoutParams(0, 0)).build()).setSupportDeepLink(true).build(), this);
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

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        TTImage tTImage;
        int value;
        TTFeedAd tTFeedAd = this.nativeAds;
        if (tTFeedAd == null) {
            YFLog.error(this.tag + " bindData, but is null, return.");
            return;
        }
        boolean z = true;
        boolean z2 = false;
        boolean z3 = tTFeedAd.getImageMode() == 5 || this.nativeAds.getImageMode() == 15;
        boolean z4 = adBaseViewHolder instanceof AdInterV2ViewHolder;
        if (!this.isSupportShake && interTemplateData.isAction()) {
            if (interTemplateData.isOnlyAction()) {
                interTemplateData.setWholeClick();
            }
            if (z4) {
                value = BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue();
            } else {
                value = BaseTemplateData.InteractiveStyle.CLICK_V3.getValue();
            }
            interTemplateData.resetActivityStyle(value);
        }
        YFLog.high(this.tag + " bindData isVideo " + z3);
        this.feedBean = new FeedBean(this.nativeAds.getTitle(), this.nativeAds.getDescription(), z3, interTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z3) {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO);
            if (this.nativeAds.getVideoCoverImage() != null && !TextUtils.isEmpty(this.nativeAds.getVideoCoverImage().getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getVideoCoverImage().getImageUrl(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
            } else if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && this.nativeAds.getImageList().get(0) != null && !TextUtils.isEmpty(this.nativeAds.getImageList().get(0).getImageUrl())) {
                ViewUtils.loadBlurImage(this.nativeAds.getImageList().get(0).getImageUrl(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBaseViewHolder.imageBlur);
            }
        } else {
            adBaseViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG);
            if (!YFListUtils.isEmpty(this.nativeAds.getImageList()) && (tTImage = this.nativeAds.getImageList().get(0)) != null && !TextUtils.isEmpty(tTImage.getImageUrl())) {
                this.feedBean.imageUrl = tTImage.getImageUrl();
                ViewUtils.loadBlurImage(tTImage.getImageUrl(), adBaseViewHolder.imageBlur, z4 ? 20 : 0);
                if (z4 && ViewUtils.isHorizontal(tTImage.getWidth(), tTImage.getHeight())) {
                    setHBackground(adBaseViewHolder.showImageArea);
                } else {
                    z = false;
                }
                ViewUtils.loadImage(tTImage.getImageUrl(), adBaseViewHolder.showImg);
                z2 = z;
            }
        }
        if (isGromoreAdn()) {
            int mAdnId = CsjUtil.getMAdnId(this.nativeAds);
            if (mAdnId == 4) {
                interTemplateData.updAdLog(R.mipmap.ad_log_ks_v3);
            } else if (mAdnId == 3) {
                interTemplateData.updAdLog(R.mipmap.ad_log_bd_v3);
            } else if (mAdnId == 2) {
                interTemplateData.updAdLog(R.mipmap.ad_log_ylh_v3);
            } else {
                interTemplateData.updAdLog(R.mipmap.ad_log_csj_v3);
            }
        } else {
            interTemplateData.updAdLog(R.mipmap.ad_log_csj_v3);
        }
        String description = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getDescription() : this.nativeAds.getTitle();
        String title = TextUtils.isEmpty(this.nativeAds.getDescription()) ? this.nativeAds.getTitle() : this.nativeAds.getDescription();
        if (z4) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (z2) {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_SMALL);
            } else {
                adInterV2ViewHolder.showImageStyle(AdInterV2ViewHolder.ImageStyle.TYPE_BIG);
            }
            TTImage icon = this.nativeAds.getIcon();
            if (icon != null) {
                ViewUtils.loadCircleImage(icon.getImageUrl(), adInterV2ViewHolder.adIcon, 20);
            }
            TextView textView = adInterV2ViewHolder.adIconName;
            if (description == null) {
                description = "";
            }
            textView.setText(description);
        } else {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            TTImage icon2 = this.nativeAds.getIcon();
            if (icon2 != null) {
                ViewUtils.loadCircleImage(icon2.getImageUrl(), adInterV3ViewHolder.adIcon, 20);
            }
            TextView textView2 = adInterV3ViewHolder.adIconName;
            if (description == null) {
                description = "";
            }
            textView2.setText(description);
        }
        TextView textView3 = adBaseViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView3.setText(title);
        adBaseViewHolder.updateShowView(getContext(), interTemplateData);
        adBaseViewHolder.getCloseView(interTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjInterstitialAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1082x2ac9d0bc(view);
            }
        });
        registerViewForInteraction(adBaseViewHolder, interTemplateData, z3, this.nativeAds);
        if (activity != null) {
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBaseViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjInterstitialAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1083x6e54ee7d(fragmentManager, view);
                }
            });
        }
        complianceContent(adBaseViewHolder, this.nativeAds);
        startCountDown(adBaseViewHolder, interTemplateData);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-csj-CsjInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1082x2ac9d0bc(View view) {
        closeAds();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-csj-CsjInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1083x6e54ee7d(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, boolean z, TTFeedAd tTFeedAd) {
        int i = 0;
        try {
            if (isGromoreAdn() && adBaseViewHolder.viewGroup != null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < adBaseViewHolder.viewGroup.getChildCount(); i2++) {
                    arrayList.add(adBaseViewHolder.viewGroup.getChildAt(i2));
                }
                adBaseViewHolder.viewGroup.removeAllViews();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    relativeLayout.addView((View) arrayList.get(i3));
                }
                frameLayout.addView(relativeLayout);
                adBaseViewHolder.viewGroup.addView(frameLayout);
            }
        } catch (Exception e) {
            e.printStackTrace();
            YFLog.error(this.tag + " registerViewForInteraction " + e.getLocalizedMessage());
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (adBaseViewHolder instanceof AdInterV2ViewHolder) {
            AdInterV2ViewHolder adInterV2ViewHolder = (AdInterV2ViewHolder) adBaseViewHolder;
            if (interTemplateData.isShowDownloadDialog()) {
                arrayList2.add(adInterV2ViewHolder.dyClickView);
            } else {
                arrayList4.add(adInterV2ViewHolder.dyClickView);
            }
            if (interTemplateData.isActionClickType()) {
                if (isDownloadType(tTFeedAd) && !interTemplateData.isActionShowDialog()) {
                    arrayList4.add(adInterV2ViewHolder.animationClickView);
                } else if (CsjUtil.getMAdnId(tTFeedAd) == 3) {
                    arrayList2.add(adInterV2ViewHolder.animationClickView);
                } else {
                    arrayList3.add(adInterV2ViewHolder.animationClickView);
                }
            }
            adBaseViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.csj.CsjInterstitialAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
        } else if (adBaseViewHolder instanceof AdInterV3ViewHolder) {
            AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
            if (interTemplateData instanceof InterV3TemplateData) {
                if (((InterV3TemplateData) interTemplateData).isWholeClick()) {
                    if (interTemplateData.isShowDownloadDialog()) {
                        arrayList2.add(adInterV3ViewHolder.viewGroup);
                        if (isGromoreAdn() && adInterV3ViewHolder.viewGroup.getChildCount() > 0 && adInterV3ViewHolder.viewGroup.getChildAt(0) != null) {
                            View childAt = adInterV3ViewHolder.viewGroup.getChildAt(0);
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
                        arrayList2.add(adInterV3ViewHolder.showArea);
                    } else {
                        arrayList4.add(adInterV3ViewHolder.viewGroup);
                        if (isGromoreAdn() && adInterV3ViewHolder.viewGroup.getChildCount() > 0 && adInterV3ViewHolder.viewGroup.getChildAt(0) != null) {
                            View childAt2 = adInterV3ViewHolder.viewGroup.getChildAt(0);
                            arrayList4.add(childAt2);
                            if (childAt2 instanceof ViewGroup) {
                                while (true) {
                                    ViewGroup viewGroup2 = (ViewGroup) childAt2;
                                    if (i >= viewGroup2.getChildCount()) {
                                        break;
                                    }
                                    arrayList4.add(viewGroup2.getChildAt(i));
                                    i++;
                                }
                            }
                        }
                        arrayList4.add(adInterV3ViewHolder.showArea);
                    }
                    i = 1;
                }
                arrayList2.add(adInterV3ViewHolder.adCloseDelay);
                if (interTemplateData.isActionClickType()) {
                    if (isDownloadType(tTFeedAd) && !interTemplateData.isActionShowDialog()) {
                        arrayList4.add(adInterV3ViewHolder.actionView);
                        arrayList4.add(adInterV3ViewHolder.animationClickView);
                    } else if (CsjUtil.getMAdnId(tTFeedAd) == 3) {
                        arrayList2.add(adInterV3ViewHolder.actionView);
                        arrayList2.add(adInterV3ViewHolder.animationClickView);
                    } else {
                        arrayList3.add(adInterV3ViewHolder.actionView);
                        arrayList3.add(adInterV3ViewHolder.animationClickView);
                    }
                }
            }
        }
        int i4 = i;
        if (arrayList2.isEmpty()) {
            arrayList2.add(new View(getContext()));
        }
        if (z) {
            bindMediaView(i4, adBaseViewHolder, tTFeedAd, arrayList2, arrayList3, arrayList4);
        } else {
            bindImageViews(adBaseViewHolder, tTFeedAd, arrayList2, arrayList3, arrayList4);
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
            m1084xb931938a(adBaseViewHolder, tTFeedAd, adView);
        } else {
            adBaseViewHolder.mediaViewFrame.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjInterstitialAdapter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1084xb931938a(adBaseViewHolder, tTFeedAd, adView);
                }
            });
        }
        tTFeedAd.registerViewForInteraction(viewGroup2, (List<View>) null, list, list2, list3, adBaseViewHolder.dislikeBtn, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addMediaView, reason: merged with bridge method [inline-methods] */
    public void m1084xb931938a(AdBaseViewHolder adBaseViewHolder, TTFeedAd tTFeedAd, View view) {
        try {
            int width = adBaseViewHolder.mediaViewFrame.getWidth();
            int width2 = adBaseViewHolder.mediaViewFrame.getWidth();
            int adViewWidth = tTFeedAd.getAdViewWidth();
            int adViewHeight = tTFeedAd.getAdViewHeight();
            boolean z = adBaseViewHolder instanceof AdInterV3ViewHolder;
            if (z) {
                updateMaterialArea(adBaseViewHolder.mediaViewFrame, width, width2, adViewWidth, adViewHeight);
            } else if (adViewWidth != 0) {
                ViewUtils.setViewSize(adBaseViewHolder.mediaViewFrame, width, (adViewHeight * width) / adViewWidth);
            }
            if (view != null && view.getParent() == null) {
                adBaseViewHolder.mediaViewFrame.removeAllViews();
                adBaseViewHolder.mediaViewFrame.addView(view);
            }
            if (z) {
                this.video = view;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public void onAdapterConfigurationChanged(AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, int i) {
        super.onAdapterConfigurationChanged(adBaseViewHolder, interTemplateData, i);
        updateVideoView(adBaseViewHolder);
    }

    private void updateVideoView(AdBaseViewHolder adBaseViewHolder) {
        if (this.nativeAds == null || this.video == null || !(adBaseViewHolder instanceof AdInterV3ViewHolder)) {
            return;
        }
        final AdInterV3ViewHolder adInterV3ViewHolder = (AdInterV3ViewHolder) adBaseViewHolder;
        adInterV3ViewHolder.showArea.post(new Runnable() { // from class: com.yfanads.ads.chanel.csj.CsjInterstitialAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1085xc8d0f16(adInterV3ViewHolder);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateVideoView$4$com-yfanads-ads-chanel-csj-CsjInterstitialAdapter, reason: not valid java name */
    /* synthetic */ void m1085xc8d0f16(AdInterV3ViewHolder adInterV3ViewHolder) {
        View view = this.video;
        if (view == null || view.getParent() == null) {
            return;
        }
        adInterV3ViewHolder.mediaViewFrame.removeAllViews();
        adInterV3ViewHolder.mediaViewFrame.addView(this.video);
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

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onError(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        try {
            YFLog.high(this.tag + "onFullScreenVideoAdLoad");
            this.newVersionAd = tTFullScreenVideoAd;
            if (tTFullScreenVideoAd == null) {
                handleFailed(YFAdError.ERROR_DATA_NULL, "new ints ad null");
                return;
            }
            tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(this);
            if (isBidding()) {
                updPrice();
                setEcpmByStr(this.ecpm);
            }
            handleSucceed();
        } catch (Throwable th) {
            th.printStackTrace();
            handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
        YFLog.high(this.tag + "onFullScreenVideoCached");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        String string = "";
        if (tTFullScreenVideoAd != null) {
            try {
                string = tTFullScreenVideoAd.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        YFLog.high(this.tag + "onFullScreenVideoCached( " + string + ")");
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        TTFullScreenVideoAd tTFullScreenVideoAd;
        YFLog.high(this.tag + "newVersionAd onAdShow");
        if (isGromoreAdn() && isBidding() && (tTFullScreenVideoAd = this.newVersionAd) != null && tTFullScreenVideoAd.getMediationManager() != null) {
            MediationAdEcpmInfo showEcpm = this.newVersionAd.getMediationManager().getShowEcpm();
            if (showEcpm != null) {
                String mShowEcpm = CsjUtil.getMShowEcpm(showEcpm);
                this.ecpm = mShowEcpm;
                if (!TextUtils.isEmpty(mShowEcpm)) {
                    setEcpmByStr(this.ecpm);
                }
            }
            YFLog.high(this.tag + "newVersionAd onAdShow tt onAdShow ep_" + this.ecpm);
        } else {
            YFLog.high(this.tag + "newVersionAd onAdShow tt");
        }
        handleExposure();
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

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        YFLog.high(this.tag + "newVersionAd onAdVideoBarClick");
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        YFLog.high(this.tag + "newVersionAd onAdClose");
        closeAds();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        YFLog.debug(this.tag + " native onAdClicked");
        handleClick();
        closeAdsDelay();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        YFLog.high(this.tag + "newVersionAd onVideoComplete");
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        YFLog.high(this.tag + "newVersionAd onSkippedVideo");
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
        try {
            Object obj = "1";
            if (isNative()) {
                TTFeedAd tTFeedAd = this.nativeAds;
                if (tTFeedAd != null && tTFeedAd.getMediaExtraInfo() != null) {
                    Object obj2 = this.nativeAds.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                    if (obj2 != null) {
                        obj = obj2;
                    }
                    this.ecpm = String.valueOf(obj);
                }
            } else {
                TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
                if (tTFullScreenVideoAd != null && tTFullScreenVideoAd.getMediaExtraInfo() != null) {
                    Object obj3 = this.newVersionAd.getMediaExtraInfo().get(OapsKey.KEY_PRICE);
                    if (obj3 != null) {
                        obj = obj3;
                    }
                    this.ecpm = String.valueOf(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
        String shortString = "";
        if (tTFullScreenVideoAd != null) {
            tTFullScreenVideoAd.win(Double.valueOf(sdkSupplier != null ? sdkSupplier.ecpm : YFUtil.toDouble(this.ecpm, 1.0d)));
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
        TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
        if (tTFullScreenVideoAd != null && sdkSupplier != null) {
            tTFullScreenVideoAd.loss(Double.valueOf(sdkSupplier.ecpm), "102", CsjUtil.getAdnName(sdkSupplier.getAdnId()));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
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

    @Override // com.yfanads.android.custom.InterstitialCustomAdapter
    public boolean isSupportAutoClick() {
        return !isGromoreAdn();
    }
}
