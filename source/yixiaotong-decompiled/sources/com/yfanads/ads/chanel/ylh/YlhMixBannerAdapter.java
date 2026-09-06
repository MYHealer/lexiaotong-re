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
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
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
import com.yfanads.ads.chanel.ylh.model.YlhNativeAds;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.MixBannerCustomAdapter;
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
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhMixBannerAdapter extends MixBannerCustomAdapter implements YFNativeCall {
    private UnifiedBannerView bannerView;
    private boolean isExposure;
    private boolean isFirst;
    List<NativeExpressADView> nativeAds;
    private List<NativeUnifiedADData> nativeAds2;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 2;
    }

    public YlhMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
        this.isExposure = false;
        this.isFirst = true;
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
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhMixBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhMixBannerAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadNativeAd(Context context) {
        loadAdByNative(context);
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadTemplateAd(Context context) {
        loadTemplate(context);
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadBannerAd(Context context) {
        if (context instanceof Activity) {
            this.bannerView = new UnifiedBannerView((Activity) context, this.sdkSupplier.getPotId(), new UnifiedBannerADListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter.2
                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADLeftApplication() {
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onNoAD(AdError adError) {
                    int errorCode;
                    String errorMsg;
                    if (adError != null) {
                        try {
                            errorCode = adError.getErrorCode();
                            errorMsg = adError.getErrorMsg();
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    } else {
                        errorCode = -1;
                        errorMsg = "default onNoAD";
                    }
                    YFLog.error(" onError: code = " + errorCode + " msg = " + errorMsg);
                    YlhMixBannerAdapter.this.handleFailed(YFAdError.parseErr(errorCode, errorMsg));
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADReceive() {
                    try {
                        YFLog.high(YlhMixBannerAdapter.this.tag + "---onADReceive--- isExposure " + YlhMixBannerAdapter.this.isExposure + " isFirst " + YlhMixBannerAdapter.this.isFirst);
                        if (YlhMixBannerAdapter.this.isDestroy || YlhMixBannerAdapter.this.hasClose) {
                            return;
                        }
                        if ((YlhMixBannerAdapter.this.isFirst || YlhMixBannerAdapter.this.isExposure) && YlhMixBannerAdapter.this.bannerView != null) {
                            YlhMixBannerAdapter ylhMixBannerAdapter = YlhMixBannerAdapter.this;
                            ylhMixBannerAdapter.setEcpm(ylhMixBannerAdapter.bannerView.getECPM());
                            YlhMixBannerAdapter.this.handleSucceed();
                        }
                        YlhMixBannerAdapter.this.isFirst = false;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        YlhMixBannerAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
                    }
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADExposure() {
                    YlhMixBannerAdapter.this.isExposure = true;
                    YlhMixBannerAdapter.this.handleExposure(0);
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADClosed() {
                    YlhMixBannerAdapter.this.closeAds(0);
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADClicked() {
                    YlhMixBannerAdapter.this.handleClick(0, false);
                }
            });
            YFLog.high(this.tag + " load banner setRefresh " + this.sdkSupplier.getRefreshInterval());
            this.bannerView.setRefresh(this.sdkSupplier.getRefreshInterval() / 1000);
            this.bannerView.loadAD();
            return;
        }
        YFLog.error("loadBannerAd context is not activity " + context);
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_YLH_CONTEXT));
    }

    private void loadAdByNative(Context context) {
        new NativeUnifiedAD(context, this.sdkSupplier.getPotId(), new NativeADUnifiedListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter.3
            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YlhMixBannerAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> list) {
                YFLog.high(YlhMixBannerAdapter.this.tag + "onNativeAdLoad");
                try {
                    if (!YFListUtils.isEmpty(list) && list.get(0) != null) {
                        YlhMixBannerAdapter.this.updData(list);
                        YlhMixBannerAdapter.this.updPrice();
                        YlhMixBannerAdapter.this.handleSucceed();
                    } else {
                        YlhMixBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                    }
                } catch (Exception e) {
                    YFLog.error("onADLoaded = " + e.getMessage());
                    YlhMixBannerAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }
        }).loadData(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updData(List<NativeUnifiedADData> list) {
        if (!isDevelop()) {
            this.nativeAds2 = list;
            return;
        }
        this.developAds.clear();
        for (int i = 0; i < list.size(); i++) {
            this.developAds.add(new YlhNativeAds(getContext(), list.get(i), this, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updPrice() {
        if (isNative()) {
            List<NativeUnifiedADData> list = this.nativeAds2;
            if (list == null || list.get(0) == null) {
                return;
            }
            setEcpm(this.nativeAds2.get(0).getECPM());
            return;
        }
        if (!isDevelop() || YFListUtils.isEmpty(this.developAds) || this.developAds.get(0) == null) {
            return;
        }
        setEcpm(this.developAds.get(0).getECPM());
    }

    private void loadTemplate(Context context) {
        NativeExpressAD nativeExpressAD = new NativeExpressAD(context, new ADSize((this.setting == null || this.setting.getViewWidth() <= 0) ? -1 : this.setting.getViewWidth(), -2), this.sdkSupplier.getPotId(), new NativeExpressAD.NativeExpressADListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter.4
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(List<NativeExpressADView> list) {
                YlhMixBannerAdapter.this.onADLoadedEV(list);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                YlhMixBannerAdapter.this.onRenderFailEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                YlhMixBannerAdapter.this.onRenderSuccessEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(NativeExpressADView nativeExpressADView) {
                YlhMixBannerAdapter.this.onADExposureEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(NativeExpressADView nativeExpressADView) {
                YlhMixBannerAdapter.this.onADClickedEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(NativeExpressADView nativeExpressADView) {
                YlhMixBannerAdapter.this.onADClosedEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YlhMixBannerAdapter.this.onNoADDel(adError);
            }
        });
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(this.sdkSupplier.isMuted()).build());
        nativeExpressAD.loadAD(this.setting.getAdsNumbers());
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowTemplateAd(Activity activity) {
        doShowTemplateAd();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowBannerAd(Activity activity) {
        doShowBannerAd();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isTemplate()) {
            List<NativeExpressADView> list = this.nativeAds;
            return (list == null || i >= list.size() || this.nativeAds.get(i) == null) ? "" : YlhUtil.getReqId(this.nativeAds.get(i).getExtraInfo());
        }
        if (isNative()) {
            List<NativeUnifiedADData> list2 = this.nativeAds2;
            return (list2 == null || i >= list2.size() || this.nativeAds2.get(i) == null) ? "" : YlhUtil.getReqId(this.nativeAds2.get(i).getExtraInfo());
        }
        if (isBanner()) {
            UnifiedBannerView unifiedBannerView = this.bannerView;
            return unifiedBannerView != null ? YlhUtil.getReqId(unifiedBannerView.getExtraInfo()) : "";
        }
        if (isDevelop() && !YFListUtils.isEmpty(this.developAds) && i < this.developAds.size()) {
            YFNativeAd yFNativeAd = this.developAds.get(i);
            if (yFNativeAd instanceof YlhNativeAds) {
                return ((YlhNativeAds) yFNativeAd).getAdReqId();
            }
        }
        return "";
    }

    private void doShowTemplateAd() {
        try {
            List<NativeExpressADView> list = this.nativeAds;
            if (list != null && !list.isEmpty()) {
                this.viewList.clear();
                for (int i = 0; i < this.nativeAds.size(); i++) {
                    NativeExpressADView nativeExpressADView = this.nativeAds.get(i);
                    if (isBidding()) {
                        nativeExpressADView.setBidECPM(nativeExpressADView.getECPM());
                    }
                    this.viewList.add(new YFExpView(nativeExpressADView.getRootView(), getAdType(), i));
                    nativeExpressADView.render();
                }
                if (this.setting != null) {
                    this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
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

    private void doShowBannerAd() {
        try {
            if (this.bannerView != null) {
                this.viewList.clear();
                if (this.setting != null) {
                    this.viewList.add(new YFExpView(this.bannerView, getAdType(), 0));
                    if (isBidding()) {
                        UnifiedBannerView unifiedBannerView = this.bannerView;
                        unifiedBannerView.setBidECPM(unifiedBannerView.getECPM());
                    }
                    ViewGroup.LayoutParams layoutParams = this.bannerView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = getBannerWidth();
                        layoutParams.height = getBannerHeight();
                        this.bannerView.setLayoutParams(layoutParams);
                    } else {
                        this.bannerView.setLayoutParams(new ViewGroup.LayoutParams(getBannerWidth(), getBannerHeight()));
                    }
                    this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
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

    private int getBannerWidth() {
        if (this.setting != null && this.setting.getViewWidth() != 0) {
            return ScreenUtil.dip2px(getContext(), this.setting.getViewWidth());
        }
        return ScreenUtil.getScreenWidth(getContext());
    }

    private int getBannerHeight() {
        return Math.round(getBannerWidth() / 6.4f);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (this.setting == null || isDevelop()) {
            return super.isReady();
        }
        int readyIndex = this.setting.getReadyIndex();
        if (isNative()) {
            List<NativeUnifiedADData> list = this.nativeAds2;
            return (list == null || list.get(readyIndex) == null || !this.nativeAds2.get(readyIndex).isValid()) ? false : true;
        }
        if (isBanner()) {
            UnifiedBannerView unifiedBannerView = this.bannerView;
            return unifiedBannerView != null && unifiedBannerView.isValid();
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

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        List<NativeExpressADView> list = this.nativeAds;
        if (list != null) {
            Iterator<NativeExpressADView> it = list.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
        }
        this.nativeAds = null;
        List<NativeUnifiedADData> list2 = this.nativeAds2;
        if (list2 != null) {
            Iterator<NativeUnifiedADData> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().destroy();
            }
        }
        this.nativeAds2 = null;
        UnifiedBannerView unifiedBannerView = this.bannerView;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
        this.bannerView = null;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public ViewGroup getNativeAdContainer() {
        return new NativeAdContainer(getContext());
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
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1169lambda$bindData$0$comyfanadsadschanelylhYlhMixBannerAdapter(i, view);
            }
        });
        registerViewForInteraction(adBannerViewHolder, z, adNative, bannerTemplateData, i);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1170lambda$bindData$1$comyfanadsadschanelylhYlhMixBannerAdapter(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-ylh-YlhMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1169lambda$bindData$0$comyfanadsadschanelylhYlhMixBannerAdapter(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-ylh-YlhMixBannerAdapter, reason: not valid java name */
    /* synthetic */ void m1170lambda$bindData$1$comyfanadsadschanelylhYlhMixBannerAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
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
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            for (NativeUnifiedADData nativeUnifiedADData : this.nativeAds2) {
                nativeUnifiedADData.sendWinNotification(YlhUtil.getWindBiddingMap(nativeUnifiedADData.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " los=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        UnifiedBannerView unifiedBannerView = this.bannerView;
        if (unifiedBannerView != null) {
            unifiedBannerView.sendWinNotification(YlhUtil.getWindBiddingMap(unifiedBannerView.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof YlhNativeAds) {
                YlhNativeAds ylhNativeAds = (YlhNativeAds) yFNativeAd;
                ylhNativeAds.sendWinNotification(YlhUtil.getWindBiddingMap(ylhNativeAds.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.developAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append(" los=");
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
        if (!YFListUtils.isEmpty(this.nativeAds2) && sdkSupplier != null) {
            int adnId2 = YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier());
            Iterator<NativeUnifiedADData> it2 = this.nativeAds2.iterator();
            while (it2.hasNext()) {
                it2.next().sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, adnId2));
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        UnifiedBannerView unifiedBannerView = this.bannerView;
        if (unifiedBannerView != null && sdkSupplier != null) {
            unifiedBannerView.sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier())));
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof YlhNativeAds) {
                YlhNativeAds ylhNativeAds = (YlhNativeAds) yFNativeAd;
                ylhNativeAds.sendLossNotification(YlhUtil.getWindBiddingMap(ylhNativeAds.getECPM(), sdkSupplier2 != null ? (int) sdkSupplier2.ecpm : 0));
            }
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.developAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            return YlhUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
        }
        return super.getAdInfo();
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
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter$$ExternalSyntheticLambda0
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
        nativeUnifiedADData.bindMediaView(mediaView, videoOptionBuild, new NativeADMediaListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter.5
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoReady: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i2) {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoStart: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoPause: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoResume: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoCompleted: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoError: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoStop: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
                YFLog.debug(YlhMixBannerAdapter.this.tag + "onVideoClicked: ");
            }
        });
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter.6
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                YlhMixBannerAdapter.this.handleExposure(i);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                YlhMixBannerAdapter.this.handleClick(i, false);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                YlhMixBannerAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }
        });
    }

    private void bindImageViews(AdBannerViewHolder adBannerViewHolder, NativeUnifiedADData nativeUnifiedADData, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, final int i) {
        nativeUnifiedADData.bindAdToView(getContext(), (NativeAdContainer) adBannerViewHolder.nativeAdContainer, layoutParams, list, list2);
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.yfanads.ads.chanel.ylh.YlhMixBannerAdapter.7
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                YlhMixBannerAdapter.this.handleExposure(i);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                YlhMixBannerAdapter.this.handleClick(i, false);
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                YlhMixBannerAdapter.this.handleFailed(adError.getErrorCode(), adError.getErrorMsg());
            }
        });
    }

    private boolean isDownloadAd(NativeUnifiedADData nativeUnifiedADData) {
        return nativeUnifiedADData.isAppAd();
    }
}
