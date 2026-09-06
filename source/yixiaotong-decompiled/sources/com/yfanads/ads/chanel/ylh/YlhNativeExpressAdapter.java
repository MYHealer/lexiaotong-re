package com.yfanads.ads.chanel.ylh;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.dyf.tt;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhNativeExpressAdapter extends NativeExpressCustomAdapter {
    List<NativeExpressADView> nativeAds;
    private List<NativeUnifiedADData> nativeAds2;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.nativeAds != null) {
            this.nativeAds = null;
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 2;
    }

    public YlhNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
        try {
            this.setting = yFNativeExpressSetting;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.YLH.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhNativeExpressAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhNativeExpressAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else if (isTemplate()) {
            loadTemplate(context);
        } else if (isNative()) {
            loadBannerAdByNative(context);
        }
    }

    private void loadBannerAdByNative(Context context) {
        new NativeUnifiedAD(context, this.sdkSupplier.getPotId(), new NativeADUnifiedListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeExpressAdapter.2
            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YlhNativeExpressAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }

            /* JADX WARN: Code duplicated, block: B:10:0x004b A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x004b), top: B:16:0x001e }] */
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                YFLog.high(YlhNativeExpressAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.size() != 0 && list.get(0) != null) {
                            YlhNativeExpressAdapter.this.nativeAds2 = list;
                            YlhNativeExpressAdapter ylhNativeExpressAdapter = YlhNativeExpressAdapter.this;
                            ylhNativeExpressAdapter.setEcpm(((NativeUnifiedADData) ylhNativeExpressAdapter.nativeAds2.get(0)).getECPM());
                            YlhNativeExpressAdapter.this.handleSucceed();
                        } else {
                            YlhNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        }
                    } catch (Throwable th) {
                        YFLog.error("onADLoaded = " + th.getMessage());
                        YlhNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    YlhNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        }).loadData(1);
    }

    private void loadTemplate(Context context) {
        NativeExpressAD nativeExpressAD = new NativeExpressAD(context, new ADSize((this.setting == null || this.setting.getViewWidth() <= 0) ? -1 : this.setting.getViewWidth(), -2), this.sdkSupplier.getPotId(), new NativeExpressAD.NativeExpressADListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeExpressAdapter.3
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(List<NativeExpressADView> list) {
                YlhNativeExpressAdapter.this.onADLoadedEV(list);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                YlhNativeExpressAdapter.this.onRenderFailEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                YlhNativeExpressAdapter.this.onRenderSuccessEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(NativeExpressADView nativeExpressADView) {
                YlhNativeExpressAdapter.this.onADExposureEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(NativeExpressADView nativeExpressADView) {
                YlhNativeExpressAdapter.this.onADClickedEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(NativeExpressADView nativeExpressADView) {
                YlhNativeExpressAdapter.this.onADClosedEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YlhNativeExpressAdapter.this.onNoADDel(adError);
            }
        });
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(this.sdkSupplier.isMuted()).build());
        nativeExpressAD.loadAD(this.setting.getAdsNumbers());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (this.setting == null) {
            return super.isReady();
        }
        int readyIndex = this.setting.getReadyIndex();
        if (isNative()) {
            List<NativeUnifiedADData> list = this.nativeAds2;
            return (list == null || list.get(readyIndex) == null || !this.nativeAds2.get(readyIndex).isValid()) ? false : true;
        }
        List<NativeExpressADView> list2 = this.nativeAds;
        return (list2 == null || list2.get(readyIndex) == null || !this.nativeAds.get(readyIndex).isValid()) ? false : true;
    }

    public void onADLoadedEV(List<NativeExpressADView> list) {
        boolean z;
        YFLog.high(this.tag + "onADLoadedEV");
        if (list == null || list.isEmpty()) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
            return;
        }
        Iterator<NativeExpressADView> it = list.iterator();
        loop0: while (true) {
            z = true;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                NativeExpressADView next = it.next();
                if (!z || next != null) {
                    z = false;
                }
            }
        }
        if (z) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
            return;
        }
        this.nativeAds = list;
        setEcpm(list.get(0).getECPM());
        handleSucceed();
    }

    public void onRenderFailEV(NativeExpressADView nativeExpressADView) {
        YFLog.high(this.tag + "onRenderFailEV");
        handleRenderFailed(getIndex(nativeExpressADView));
    }

    public void onRenderSuccessEV(View view) {
        YFLog.high(this.tag + "onRenderSuccessEV");
    }

    public void onADExposureEV(NativeExpressADView nativeExpressADView) {
        int index = getIndex(nativeExpressADView);
        YFLog.high(this.tag + "onADExposureEV = " + index);
        handleExposure(index);
    }

    public void onADClickedEV(NativeExpressADView nativeExpressADView) {
        int index = getIndex(nativeExpressADView);
        YFLog.high(this.tag + "onADClickedEV = " + index);
        handleClick(index, false);
    }

    public void onADClosedEV(NativeExpressADView nativeExpressADView) {
        int index = getIndex(nativeExpressADView);
        YFLog.high(this.tag + "onADClosedEV = " + index);
        closeAds(index);
    }

    private int getIndex(NativeExpressADView nativeExpressADView) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return -1;
        }
        return this.nativeAds.indexOf(nativeExpressADView);
    }

    public void onNoADDel(AdError adError) {
        int errorCode;
        String errorMsg;
        YFLog.high(this.tag + "onNoADEV");
        if (adError != null) {
            errorCode = adError.getErrorCode();
            errorMsg = adError.getErrorMsg();
        } else {
            errorCode = -1;
            errorMsg = "default onNoAD";
        }
        handleFailed(errorCode, errorMsg);
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

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public ViewGroup getNativeAdContainer() {
        return new NativeAdContainer(getContext());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isTemplate()) {
            List<NativeExpressADView> list = this.nativeAds;
            return (list == null || i >= list.size() || this.nativeAds.get(i) == null) ? "" : YlhUtil.getReqId(this.nativeAds.get(i).getExtraInfo());
        }
        List<NativeUnifiedADData> list2 = this.nativeAds2;
        return (list2 == null || i >= list2.size() || this.nativeAds2.get(i) == null) ? "" : YlhUtil.getReqId(this.nativeAds2.get(i).getExtraInfo());
    }

    private NativeUnifiedADData getAdNative(int i) {
        if (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size()) {
            YFLog.error("bindData error " + i);
            return null;
        }
        return this.nativeAds2.get(i);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<NativeUnifiedADData> list = this.nativeAds2;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private void doShowTemplateAd() {
        try {
            List<NativeExpressADView> list = this.nativeAds;
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.nativeAds.size(); i++) {
                    NativeExpressADView nativeExpressADView = this.nativeAds.get(i);
                    arrayList.add(new YFExpView(nativeExpressADView.getRootView(), getAdType(), i));
                    nativeExpressADView.render();
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
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            for (NativeExpressADView nativeExpressADView : this.nativeAds) {
                nativeExpressADView.sendWinNotification(YlhUtil.getWindBiddingMap(nativeExpressADView.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " los=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (YFListUtils.isEmpty(this.nativeAds2)) {
            return;
        }
        for (NativeUnifiedADData nativeUnifiedADData : this.nativeAds2) {
            nativeUnifiedADData.sendWinNotification(YlhUtil.getWindBiddingMap(nativeUnifiedADData.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds2.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" los=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (!YFListUtils.isEmpty(this.nativeAds) && sdkSupplier != null) {
            int adnId = YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier());
            Iterator<NativeExpressADView> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, adnId));
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (YFListUtils.isEmpty(this.nativeAds2) || sdkSupplier == null) {
            return;
        }
        int adnId2 = YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier());
        Iterator<NativeUnifiedADData> it2 = this.nativeAds2.iterator();
        while (it2.hasNext()) {
            it2.next().sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, adnId2));
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (YFListUtils.isEmpty(this.nativeAds2)) {
            return null;
        }
        return YlhUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        String buttonText;
        NativeUnifiedADData adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        boolean z = adNative.getAdPatternType() == 2;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(adNative.getTitle(), adNative.getDesc(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (!TextUtils.isEmpty(adNative.getImgUrl())) {
                ViewUtils.loadBlurImage(adNative.getImgUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            this.feedBean.imageUrl = adNative.getImgUrl();
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            ViewUtils.loadBlurImage(adNative.getImgUrl(), adBannerViewHolder.imageBlur, 20);
            ViewUtils.loadImage(adNative.getImgUrl(), adBannerViewHolder.showImg);
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_ylh_v3);
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
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
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
            } else {
                adBannerViewHolder.mDownload.setVisibility(0);
                TextView textView3 = adBannerViewHolder.mDownload;
                if (TextUtils.isEmpty(adNative.getButtonText())) {
                    buttonText = getContext().getString(R.string.yf_default_download_text);
                } else {
                    buttonText = adNative.getButtonText();
                }
                textView3.setText(buttonText);
                this.feedBean.actBtnString = adNative.getButtonText();
            }
        } else {
            adBannerViewHolder.mDownload.setVisibility(8);
        }
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(adNative.getIconUrl())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(adNative.getIconUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeExpressAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1171x23f86d93(i, view);
            }
        });
        registerViewForInteraction(adBannerViewHolder, z, adNative, bannerTemplateData, i);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeExpressAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1172x51d107f2(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ylh-YlhNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1171x23f86d93(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ylh-YlhNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1172x51d107f2(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, NativeUnifiedADData nativeUnifiedADData) {
        if (isDownloadAd(nativeUnifiedADData)) {
            NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
            if (appMiitInfo == null) {
                adBannerViewHolder.complianceContent.setVisibility(8);
                return;
            }
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(appMiitInfo.getAppName(), appMiitInfo.getVersionName(), appMiitInfo.getAuthorName(), appMiitInfo.getDescriptionUrl(), appMiitInfo.getPermissionsUrl(), appMiitInfo.getPrivacyAgreement()));
            if (this.feedBean != null) {
                this.feedBean.updateAppInfo(appMiitInfo.getAppName(), appMiitInfo.getVersionName(), appMiitInfo.getAuthorName());
                return;
            }
            return;
        }
        adBannerViewHolder.complianceContent.setVisibility(8);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public boolean isDownloadType(int i) {
        List<NativeUnifiedADData> list = this.nativeAds2;
        if (list != null && list.get(i) != null) {
            return isDownloadAd(this.nativeAds2.get(i));
        }
        return super.isDownloadType(i);
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, NativeUnifiedADData nativeUnifiedADData, BannerTemplateData bannerTemplateData, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (bannerTemplateData.isShowDownloadDialog()) {
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
        } else {
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
        }
        if (bannerTemplateData.isCtaClick()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake() && adBannerViewHolder.mDownloadBar != null) {
                if (isDownloadAd(nativeUnifiedADData) && !bannerTemplateData.isActionShowDialog()) {
                    arrayList2.add(adBannerViewHolder.mDownloadBar);
                } else {
                    arrayList.add(adBannerViewHolder.mDownloadBar);
                }
            } else if (isDownloadAd(nativeUnifiedADData) && !bannerTemplateData.isActionShowDialog()) {
                arrayList2.add(adBannerViewHolder.mDownload);
            } else {
                arrayList.add(adBannerViewHolder.mDownload);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
        layoutParams.gravity = 53;
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeExpressAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(adBannerViewHolder, bannerTemplateData, nativeUnifiedADData, layoutParams, arrayList, arrayList2, bannerTemplateData.isMute(), i);
        } else {
            bindImageViews(adBannerViewHolder, nativeUnifiedADData, arrayList, arrayList2, layoutParams, i);
        }
    }

    private void bindMediaView(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, NativeUnifiedADData nativeUnifiedADData, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2, boolean z, final int i) {
        nativeUnifiedADData.bindAdToView(getContext(), (NativeAdContainer) adBannerViewHolder.nativeAdContainer, layoutParams, list, list2);
        VideoOption videoOptionBuild = new VideoOption.Builder().setAutoPlayMuted(z).setAutoPlayPolicy(1).setNeedCoverImage(true).setEnableUserControl(bannerTemplateData.isTemplateV3() && !bannerTemplateData.isWholeClick()).build();
        MediaView mediaView = new MediaView(getContext());
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (mediaView.getParent() == null) {
            adBannerViewHolder.mediaViewFrame.removeAllViews();
            adBannerViewHolder.mediaViewFrame.addView(mediaView);
        }
        nativeUnifiedADData.bindMediaView(mediaView, videoOptionBuild, new NativeADMediaListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeExpressAdapter.4
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoReady: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i2) {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoStart: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoPause: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoResume: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoCompleted: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoError: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoStop: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                YFLog.debug(YlhNativeExpressAdapter.this.tag + "onVideoClicked: ");
            }
        });
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeExpressAdapter.5
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                YlhNativeExpressAdapter.this.handleExposure(i);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                YlhNativeExpressAdapter.this.handleClick(i, false);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                YlhNativeExpressAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }
        });
    }

    private void bindImageViews(AdBannerViewHolder adBannerViewHolder, NativeUnifiedADData nativeUnifiedADData, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, final int i) {
        nativeUnifiedADData.bindAdToView(getContext(), (NativeAdContainer) adBannerViewHolder.nativeAdContainer, layoutParams, list, list2);
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.yfanads.ads.chanel.ylh.YlhNativeExpressAdapter.6
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                YlhNativeExpressAdapter.this.handleExposure(i);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                YlhNativeExpressAdapter.this.handleClick(i, false);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                YlhNativeExpressAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }
        });
    }

    private boolean isDownloadAd(NativeUnifiedADData nativeUnifiedADData) {
        return nativeUnifiedADData.isAppAd();
    }
}
