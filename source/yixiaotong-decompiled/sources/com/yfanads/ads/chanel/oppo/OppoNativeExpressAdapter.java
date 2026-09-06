package com.yfanads.ads.chanel.oppo;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.heytap.msp.mobad.api.ad.NativeAdvanceAd;
import com.heytap.msp.mobad.api.ad.NativeTempletAd;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.listener.INativeTempletAdListener;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdSize;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.yfanads.ads.chanel.oppo.utls.OppoUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
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
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class OppoNativeExpressAdapter extends NativeExpressCustomAdapter implements INativeTempletAdListener {
    private List<INativeTempletAdView> dataList;
    List<INativeAdvanceData> mINativeAdvanceDataList;
    private NativeAdvanceAd mNativeAdvanceAd;
    private NativeTempletAd mNativeTempletAd;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 8;
    }

    public OppoNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        OppoUtil.initOppo(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.oppo.OppoNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                OppoNativeExpressAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                OppoNativeExpressAdapter.this.handleFailed(str, str2);
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
        } else if (isNative()) {
            loadBannerAdByNative(context);
        } else {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            if (isTemplate()) {
                doShowTemplateAd();
            } else if (isNative()) {
                doShowNativeAd(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (this.setting == null) {
            return super.isReady();
        }
        int readyIndex = this.setting.getReadyIndex();
        if (!isNative()) {
            return super.isReady();
        }
        List<INativeAdvanceData> list = this.mINativeAdvanceDataList;
        return (list == null || list.get(readyIndex) == null || !this.mINativeAdvanceDataList.get(readyIndex).isAdValid()) ? false : true;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        try {
            NativeTempletAd nativeTempletAd = this.mNativeTempletAd;
            if (nativeTempletAd != null) {
                nativeTempletAd.destroyAd();
                this.mNativeTempletAd = null;
            }
            NativeAdvanceAd nativeAdvanceAd = this.mNativeAdvanceAd;
            if (nativeAdvanceAd != null) {
                nativeAdvanceAd.destroyAd();
                this.mNativeAdvanceAd = null;
            }
            if (YFListUtils.isEmpty(this.mINativeAdvanceDataList)) {
                return;
            }
            Iterator<INativeAdvanceData> it = this.mINativeAdvanceDataList.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.mINativeAdvanceDataList.clear();
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    private void doShowTemplateAd() {
        try {
            List<INativeTempletAdView> list = this.dataList;
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (INativeTempletAdView iNativeTempletAdView : this.dataList) {
                    if (isBidding()) {
                        iNativeTempletAdView.setBidECPM(iNativeTempletAdView.getECPM());
                    }
                    arrayList.add(new YFExpView(iNativeTempletAdView.getAdView(), getAdType()));
                    iNativeTempletAdView.getAdView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    iNativeTempletAdView.render();
                }
                if (this.setting != null) {
                    this.setting.adapterRenderSuccess(this.sdkSupplier, arrayList);
                    return;
                }
                return;
            }
            if (this.setting != null) {
                this.setting.adapterRenderFailed(this.sdkSupplier);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        String shortString = "";
        if (!YFListUtils.isEmpty(this.mINativeAdvanceDataList)) {
            Iterator<INativeAdvanceData> it = this.mINativeAdvanceDataList.iterator();
            while (it.hasNext()) {
                it.next().notifyRankWin(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0);
            }
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (YFListUtils.isEmpty(this.dataList)) {
            return;
        }
        Iterator<INativeTempletAdView> it2 = this.dataList.iterator();
        while (it2.hasNext()) {
            it2.next().notifyRankWin(sdkSupplier != null ? (int) sdkSupplier.ecpm : 0);
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (!YFListUtils.isEmpty(this.mINativeAdvanceDataList) && sdkSupplier != null) {
            Iterator<INativeAdvanceData> it = this.mINativeAdvanceDataList.iterator();
            while (it.hasNext()) {
                it.next().notifyRankLoss(1, "other", (int) sdkSupplier.ecpm);
            }
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (YFListUtils.isEmpty(this.dataList) || sdkSupplier == null) {
            return;
        }
        Iterator<INativeTempletAdView> it2 = this.dataList.iterator();
        while (it2.hasNext()) {
            it2.next().notifyRankLoss(1, "other", (int) sdkSupplier.ecpm);
        }
        YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.mINativeAdvanceDataList)) {
            return OppoUtil.getAdInfo(this.mINativeAdvanceDataList.get(0), getRequestId());
        }
        return super.getAdInfo();
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public ViewGroup getNativeAdContainer() {
        return new NativeAdvanceContainer(getContext());
    }

    private void loadTemplate(Context context) {
        int iPx2dip = ScreenUtil.px2dip(getContext(), ScreenUtil.getScreenWidth(getContext()));
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            iPx2dip = this.setting.getViewWidth();
        }
        YFLog.debug("startLoadAD " + iPx2dip);
        NativeTempletAd nativeTempletAd = new NativeTempletAd(context, this.sdkSupplier.getPotId(), new NativeAdSize.Builder().setWidthInDp(iPx2dip).build(), this);
        this.mNativeTempletAd = nativeTempletAd;
        nativeTempletAd.loadAd();
    }

    private void loadBannerAdByNative(Context context) {
        NativeAdvanceAd nativeAdvanceAd = new NativeAdvanceAd(context, this.sdkSupplier.getPotId(), new INativeAdvanceLoadListener() { // from class: com.yfanads.ads.chanel.oppo.OppoNativeExpressAdapter.2
            /* JADX WARN: Code duplicated, block: B:10:0x0048 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0048), top: B:16:0x001e }] */
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
            public void onAdSuccess(List<INativeAdvanceData> list) {
                YFLog.high(OppoNativeExpressAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() == 0 || list.get(0) == null) {
                            OppoNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            OppoNativeExpressAdapter.this.mINativeAdvanceDataList = list;
                            OppoNativeExpressAdapter oppoNativeExpressAdapter = OppoNativeExpressAdapter.this;
                            oppoNativeExpressAdapter.setEcpm(oppoNativeExpressAdapter.mINativeAdvanceDataList.get(0).getECPM());
                            OppoNativeExpressAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        OppoNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    OppoNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
            public void onAdFailed(int i, String str) {
                YFLog.high(OppoNativeExpressAdapter.this.tag + " onError " + i + str);
                OppoNativeExpressAdapter.this.handleFailed(i, str);
            }
        });
        this.mNativeAdvanceAd = nativeAdvanceAd;
        nativeAdvanceAd.loadAd();
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        String clickBnText;
        INativeAdvanceData adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        adBannerViewHolder.adLogoIcon.setVisibility(0);
        bannerTemplateData.updAdLog(R.mipmap.ad_log_oppo_v3);
        boolean z = adNative.getCreativeType() == 13 || adNative.getCreativeType() == 16;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(adNative.getTitle(), adNative.getDesc(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (adNative.getImgFiles() != null && adNative.getImgFiles().get(0).getUrl() != null) {
                ViewUtils.loadBlurImage(adNative.getImgFiles().get(0).getUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else if (adNative.getImgFiles() != null && adNative.getImgFiles().get(0).getUrl() != null) {
            String url = adNative.getImgFiles().get(0).getUrl();
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            ViewUtils.loadBlurImage(url, adBannerViewHolder.imageBlur, 20);
            ViewUtils.loadImage(url, adBannerViewHolder.showImg);
        }
        String desc = TextUtils.isEmpty(adNative.getTitle()) ? adNative.getDesc() : adNative.getTitle();
        String title = TextUtils.isEmpty(adNative.getDesc()) ? adNative.getTitle() : adNative.getDesc();
        if (bannerTemplateData.isShowTitleAndDes()) {
            TextView textView = adBannerViewHolder.titleDes;
            if (desc == null) {
                desc = "";
            }
            textView.setText(desc);
        }
        TextView textView2 = adBannerViewHolder.adDes;
        if (title == null) {
            title = "";
        }
        textView2.setText(title);
        if (bannerTemplateData.isShowAdIcon() && !YFListUtils.isEmpty(adNative.getIconFiles())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(adNative.getIconFiles().get(0).getUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
            } else {
                adBannerViewHolder.mDownload.setVisibility(0);
                TextView textView3 = adBannerViewHolder.mDownload;
                if (TextUtils.isEmpty(adNative.getClickBnText())) {
                    clickBnText = getContext().getString(R.string.yf_default_download_text);
                } else {
                    clickBnText = adNative.getClickBnText();
                }
                textView3.setText(clickBnText);
                if (this.feedBean != null) {
                    this.feedBean.actBtnString = adNative.getClickBnText();
                }
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.oppo.OppoNativeExpressAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1145xdd1a0de3(i, view);
            }
        });
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.oppo.OppoNativeExpressAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1146xf7358c82(fragmentManager, view);
                }
            });
        }
        registerViewForInteraction(adBannerViewHolder, z, bannerTemplateData, adNative, i);
        complianceContent(adBannerViewHolder);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-oppo-OppoNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1145xdd1a0de3(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-oppo-OppoNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1146xf7358c82(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, BannerTemplateData bannerTemplateData, INativeAdvanceData iNativeAdvanceData, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!bannerTemplateData.isShowDownloadDialog()) {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    arrayList2.add(adBannerViewHolder.viewGroup);
                }
                arrayList2.add(adBannerViewHolder.adCloseDelay);
            } else {
                arrayList2.add(adBannerViewHolder.dyClickView);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                arrayList2.add(adBannerViewHolder.adDes);
                arrayList2.add(adBannerViewHolder.titleDes);
            }
        } else {
            if (bannerTemplateData.isTemplateV3()) {
                if (bannerTemplateData.isWholeClick()) {
                    arrayList.add(adBannerViewHolder.viewGroup);
                }
                arrayList.add(adBannerViewHolder.adCloseDelay);
            } else {
                arrayList.add(adBannerViewHolder.dyClickView);
            }
            if (bannerTemplateData.isTitleDesClick()) {
                arrayList.add(adBannerViewHolder.adDes);
                arrayList.add(adBannerViewHolder.titleDes);
            }
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                arrayList2.add(adBannerViewHolder.mDownloadBar);
            } else {
                arrayList2.add(adBannerViewHolder.mDownload);
            }
        }
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.oppo.OppoNativeExpressAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(adBannerViewHolder, arrayList, arrayList2, iNativeAdvanceData, i);
        } else {
            bindImageViews(adBannerViewHolder, arrayList, arrayList2, iNativeAdvanceData, i);
        }
    }

    private void bindMediaView(AdBannerViewHolder adBannerViewHolder, List<View> list, List<View> list2, INativeAdvanceData iNativeAdvanceData, final int i) {
        if (iNativeAdvanceData == null) {
            return;
        }
        iNativeAdvanceData.setInteractListener(new INativeAdvanceInteractListener() { // from class: com.yfanads.ads.chanel.oppo.OppoNativeExpressAdapter.3
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onClick() {
                OppoNativeExpressAdapter.this.handleClick(i, false);
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onShow() {
                OppoNativeExpressAdapter.this.handleExposure(i);
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onError(int i2, String str) {
                OppoNativeExpressAdapter.this.handleFailed(i2, str);
            }
        });
        iNativeAdvanceData.bindToView(getContext(), (NativeAdvanceContainer) adBannerViewHolder.nativeAdContainer, list, list2);
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            adBannerViewHolder.mediaViewFrame.removeAllViews();
            adBannerViewHolder.mediaViewFrame.addView(mediaView);
        }
        iNativeAdvanceData.bindMediaView(getContext(), mediaView, new INativeAdvanceMediaListener() { // from class: com.yfanads.ads.chanel.oppo.OppoNativeExpressAdapter.4
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayStart() {
                YFLog.debug(OppoNativeExpressAdapter.this.tag + "onVideoPlayStart: ");
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayComplete() {
                YFLog.debug(OppoNativeExpressAdapter.this.tag + "onVideoPlayComplete: ");
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayError(int i2, String str) {
                YFLog.debug(OppoNativeExpressAdapter.this.tag + "onVideoError: ");
                OppoNativeExpressAdapter.this.handleFailed(i2, str);
            }
        });
    }

    private void bindImageViews(AdBannerViewHolder adBannerViewHolder, List<View> list, List<View> list2, INativeAdvanceData iNativeAdvanceData, final int i) {
        if (iNativeAdvanceData == null) {
            return;
        }
        iNativeAdvanceData.setInteractListener(new INativeAdvanceInteractListener() { // from class: com.yfanads.ads.chanel.oppo.OppoNativeExpressAdapter.5
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onClick() {
                OppoNativeExpressAdapter.this.handleClick(i, false);
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onShow() {
                OppoNativeExpressAdapter.this.handleExposure(i);
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onError(int i2, String str) {
                OppoNativeExpressAdapter.this.handleFailed(i2, str);
            }
        });
        iNativeAdvanceData.bindToView(getContext(), (NativeAdvanceContainer) adBannerViewHolder.nativeAdContainer, list, list2);
    }

    private void complianceContent(AdBaseViewHolder adBaseViewHolder) {
        adBaseViewHolder.complianceContent.setVisibility(8);
    }

    private INativeAdvanceData getAdNative(int i) {
        if (YFListUtils.isEmpty(this.mINativeAdvanceDataList) || i >= this.mINativeAdvanceDataList.size()) {
            YFLog.error("bindData error " + i);
            return null;
        }
        return this.mINativeAdvanceDataList.get(i);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<INativeAdvanceData> list = this.mINativeAdvanceDataList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.OPPO.getValue();
    }

    @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
    public void onAdSuccess(List<INativeTempletAdView> list) {
        try {
            YFLog.high(this.tag + "onNativeExpressAdLoad");
            if (list != null && list.size() != 0) {
                this.dataList = list;
                if (this.mNativeTempletAd != null) {
                    setEcpm(list.get(0).getECPM());
                }
                handleSucceed();
                return;
            }
            handleFailed(YFAdError.ERROR_DATA_NULL, "ads empty");
        } catch (Throwable th) {
            th.printStackTrace();
            handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
        }
    }

    @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
    public void onAdFailed(NativeAdError nativeAdError) {
        if (nativeAdError != null) {
            handleFailed(nativeAdError.code, nativeAdError.msg);
        } else {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
    public void onAdClick(INativeTempletAdView iNativeTempletAdView) {
        int index = getIndex(iNativeTempletAdView);
        YFLog.high("onAdClick： " + index);
        handleClick(index, false);
    }

    @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
    public void onAdShow(INativeTempletAdView iNativeTempletAdView) {
        int index = getIndex(iNativeTempletAdView);
        YFLog.high("onAdShow： " + index);
        handleExposure(index);
    }

    @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
    public void onAdClose(INativeTempletAdView iNativeTempletAdView) {
        int index = getIndex(iNativeTempletAdView);
        YFLog.high("onAdClose： " + index);
        closeAds(index);
    }

    @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
    public void onRenderSuccess(INativeTempletAdView iNativeTempletAdView) {
        YFLog.high(" onRenderSuccess ");
    }

    @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
    public void onRenderFailed(NativeAdError nativeAdError, INativeTempletAdView iNativeTempletAdView) {
        YFLog.high(" onRenderFailed ");
        handleRenderFailed(getIndex(iNativeTempletAdView));
    }

    private int getIndex(INativeTempletAdView iNativeTempletAdView) {
        if (YFListUtils.isEmpty(this.dataList)) {
            return -1;
        }
        return this.dataList.indexOf(iNativeTempletAdView);
    }
}
