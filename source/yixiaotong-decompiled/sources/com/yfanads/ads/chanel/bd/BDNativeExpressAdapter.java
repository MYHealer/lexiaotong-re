package com.yfanads.ads.chanel.bd;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XNativeView;
import com.byazt.dyf.tt;
import com.yfanads.ads.chanel.bd.model.BDNativeAds;
import com.yfanads.ads.chanel.bd.utils.BDUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class BDNativeExpressAdapter extends NativeExpressCustomAdapter implements BaiduNativeManager.ExpressAdListener, YFNativeCall {
    private View actionView;
    private List<ExpressResponse> nativeAds;
    private List<NativeResponse> nativeAds2;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 3;
    }

    public BDNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        BDUtil.initBDAccount(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                BDNativeExpressAdapter bDNativeExpressAdapter = BDNativeExpressAdapter.this;
                bDNativeExpressAdapter.startLoadAD(bDNativeExpressAdapter.getContext());
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                BDNativeExpressAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
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
            loadBannerAdByNative(context);
        } else {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }

    private void loadTemplate(Context context) {
        if (this.sdkSupplier != null) {
            int iPx2dip = ScreenUtil.px2dip(context, ScreenUtil.getScreenWidth(context));
            if (this.setting != null && this.setting.getViewWidth() > 0) {
                iPx2dip = this.setting.getViewWidth();
            }
            RequestParameters.Builder builder = new RequestParameters.Builder();
            builder.setWidth(iPx2dip);
            BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.sdkSupplier.getPotId());
            InitBean initBean = getInitBean();
            if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
                YFLog.high(this.tag + " setAppSid:" + initBean.appId);
                baiduNativeManager.setAppSid(initBean.appId);
            }
            baiduNativeManager.loadExpressAd(builder.build(), this);
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            YFLog.high(this.tag + " doShowAD--");
            if (isTemplate()) {
                doShowTemplateAd(activity);
            } else if (isNative() || isDevelop()) {
                doShowNativeAd(activity);
            } else {
                handleShowFailed(this.tag + " it's a not config");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (this.setting == null || isDevelop()) {
            return super.isReady();
        }
        int readyIndex = this.setting.getReadyIndex();
        if (isNative()) {
            List<NativeResponse> list = this.nativeAds2;
            return (list == null || list.get(readyIndex) == null || !this.nativeAds2.get(readyIndex).isAdAvailable(getContext())) ? false : true;
        }
        List<ExpressResponse> list2 = this.nativeAds;
        return (list2 == null || list2.get(readyIndex) == null || !this.nativeAds.get(readyIndex).isAdAvailable()) ? false : true;
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getSize() {
        List<NativeResponse> list = this.nativeAds2;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private void doShowTemplateAd(Activity activity) {
        List<ExpressResponse> list = this.nativeAds;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.nativeAds.size(); i++) {
                ExpressResponse expressResponse = this.nativeAds.get(i);
                YFExpView yFExpView = new YFExpView(expressResponse.getExpressAdView(), getAdType(), i);
                arrayList.add(yFExpView);
                expressResponse.bindInteractionActivity(activity);
                BDExpViewListener bDExpViewListener = new BDExpViewListener(yFExpView, this);
                expressResponse.setInteractionListener(bDExpViewListener);
                expressResponse.setAdDislikeListener(bDExpViewListener);
                expressResponse.render();
            }
            if (this.setting != null) {
                this.setting.adapterRenderSuccess(this.sdkSupplier, arrayList);
                return;
            }
            return;
        }
        handleShowFailed();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        String shortString = "";
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            Iterator<ExpressResponse> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda0
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public final void onBiddingResult(boolean z, String str, HashMap map) {
                        this.f$0.m1066x4d78796b(z, str, map);
                    }
                });
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            Iterator<NativeResponse> it2 = this.nativeAds2.iterator();
            while (it2.hasNext()) {
                it2.next().biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda1
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public final void onBiddingResult(boolean z, String str, HashMap map) {
                        this.f$0.m1067x3f221f8a(z, str, map);
                    }
                });
            }
            YFLog.high(this.tag + " sendBiddingSucResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof BDNativeAds) {
                ((BDNativeAds) yFNativeAd).biddingSuccess(BDUtil.getWindBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda2
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public final void onBiddingResult(boolean z, String str, HashMap map) {
                        this.f$0.m1068x30cbc5a9(z, str, map);
                    }
                });
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.developAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$0$com-yfanads-ads-chanel-bd-BDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1066x4d78796b(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$1$com-yfanads-ads-chanel-bd-BDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1067x3f221f8a(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    /* JADX INFO: renamed from: lambda$sendSucBiddingResult$2$com-yfanads-ads-chanel-bd-BDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1068x30cbc5a9(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-win: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            Iterator<ExpressResponse> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda5
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public final void onBiddingResult(boolean z, String str, HashMap map) {
                        this.f$0.m1063xb358d514(z, str, map);
                    }
                });
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            Iterator<NativeResponse> it2 = this.nativeAds2.iterator();
            while (it2.hasNext()) {
                it2.next().biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda6
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public final void onBiddingResult(boolean z, String str, HashMap map) {
                        this.f$0.m1064xa5027b33(z, str, map);
                    }
                });
            }
            YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds2.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof BDNativeAds) {
                ((BDNativeAds) yFNativeAd).biddingFail(BDUtil.getLossBiddingMap(sdkSupplier), new BiddingListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda7
                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                    public final void onBiddingResult(boolean z, String str, HashMap map) {
                        this.f$0.m1065x96ac2152(z, str, map);
                    }
                });
            }
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.developAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$3$com-yfanads-ads-chanel-bd-BDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1063xb358d514(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$4$com-yfanads-ads-chanel-bd-BDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1064xa5027b33(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    /* JADX INFO: renamed from: lambda$sendLossBiddingResult$5$com-yfanads-ads-chanel-bd-BDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1065x96ac2152(boolean z, String str, HashMap map) {
        YFLog.debug(this.tag + "onBiddingResult-loss: " + z + " msg信息：" + str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (!YFListUtils.isEmpty(this.nativeAds2) && i < this.nativeAds2.size()) {
            return this.nativeAds2.get(i) != null ? BDUtil.getReqId(this.nativeAds2.get(i).getAdDataForKey("request_id")) : "";
        }
        if (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size()) {
            return (YFListUtils.isEmpty(this.developAds) || i >= this.developAds.size()) ? "" : ((BDNativeAds) this.developAds.get(i)).getReqId();
        }
        return this.nativeAds.get(i) != null ? BDUtil.getReqId(this.nativeAds.get(i).getAdDataForKey("request_id")) : "";
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!YFListUtils.isEmpty(this.nativeAds2)) {
            return BDUtil.getAdInfo(this.nativeAds2.get(0), getRequestId());
        }
        return super.getAdInfo();
    }

    private static class BDExpViewListener extends NativeExpressCustomAdapter.ExpViewListener<BDNativeExpressAdapter> implements ExpressResponse.ExpressInteractionListener, ExpressResponse.ExpressDislikeListener, ExpressResponse.ExpressCloseListener {
        private final ExpView expView;

        public BDExpViewListener(ExpView expView, BDNativeExpressAdapter bDNativeExpressAdapter) {
            super(bDNativeExpressAdapter);
            this.expView = expView;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdClick() {
            YFLog.debug("BDNativeExpressAdapter template onAdClick");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdExposed() {
            YFLog.debug("BDNativeExpressAdapter template onAdExposed");
            if (getAdapter() != null) {
                getAdapter().handleExposure(this.expView);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdRenderFail(View view, String str, int i) {
            if (getAdapter() != null) {
                YFLog.debug(getAdapter().tag + " onAdRenderFail: " + str + "_" + i);
                getAdapter().handleRenderFailed(this.expView);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdRenderSuccess(View view, float f, float f2) {
            YFLog.debug("BDNativeExpressAdapter onAdRenderSuccess");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public void onAdUnionClick() {
            YFLog.debug("BDNativeExpressAdapter template onAdUnionClick");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public void onDislikeWindowShow() {
            YFLog.debug("BDNativeExpressAdapter template onDislikeWindowShow");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public void onDislikeItemClick(String str) {
            YFLog.debug("BDNativeExpressAdapter template onDislikeItemClick " + str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public void onDislikeWindowClose() {
            YFLog.debug("BDNativeExpressAdapter template onDislikeWindowClose");
            if (getAdapter() != null) {
                getAdapter().handleClose(this.expView);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressCloseListener
        public void onAdClose(ExpressResponse expressResponse) {
            YFLog.debug("BDNativeExpressAdapter template onAdClose");
            if (getAdapter() != null) {
                getAdapter().handleClose(this.expView);
            }
        }
    }

    private void loadBannerAdByNative(Context context) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, this.sdkSupplier.getPotId());
        RequestParameters requestParametersBuild = new RequestParameters.Builder().build();
        InitBean initBean = getInitBean();
        if (initBean != null && !TextUtils.isEmpty(initBean.appId)) {
            YFLog.high(this.tag + " setAppSid:" + initBean.appId);
            baiduNativeManager.setAppSid(initBean.appId);
        }
        baiduNativeManager.loadFeedAd(requestParametersBuild, new BaiduNativeManager.FeedAdListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter.2
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                YFLog.high(BDNativeExpressAdapter.this.tag + "onNativeAdLoad");
                try {
                    if (!YFListUtils.isEmpty(list) && list.get(0) != null) {
                        BDNativeExpressAdapter.this.updData(list);
                        BDNativeExpressAdapter.this.updPrice();
                        BDNativeExpressAdapter.this.handleSucceed();
                    } else {
                        BDNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                    }
                } catch (Throwable th) {
                    YFLog.error(BDNativeExpressAdapter.this.tag + "onNativeAdLoad error:" + th.getMessage());
                    BDNativeExpressAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
                BDNativeExpressAdapter.this.handleFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i, String str, NativeResponse nativeResponse) {
                BDNativeExpressAdapter.this.handleFailed(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updData(List<NativeResponse> list) {
        if (!isDevelop()) {
            this.nativeAds2 = list;
            return;
        }
        this.developAds.clear();
        for (int i = 0; i < list.size(); i++) {
            this.developAds.add(new BDNativeAds(getContext(), list.get(i), this.sdkSupplier.getTemplateConf(), this, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updPrice() {
        if (isNative()) {
            List<NativeResponse> list = this.nativeAds2;
            if (list == null || list.get(0) == null) {
                return;
            }
            setEcpmByStr(this.nativeAds2.get(0).getECPMLevel());
            return;
        }
        if (!isDevelop() || YFListUtils.isEmpty(this.developAds) || this.developAds.get(0) == null) {
            return;
        }
        setEcpm(this.developAds.get(0).getECPM());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        List<ExpressResponse> list = this.nativeAds;
        if (list != null && !list.isEmpty()) {
            Iterator<ExpressResponse> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().bindInteractionActivity(null);
            }
            this.nativeAds.clear();
        }
        List<NativeResponse> list2 = this.nativeAds2;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        this.nativeAds2.clear();
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onNativeLoad(List<ExpressResponse> list) {
        YFLog.high(this.tag + "onNativeLoad");
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    handleFailed(YFAdError.ERROR_DATA_NULL, "");
                } else {
                    this.nativeAds = list;
                    setEcpmByStr(list.get(0).getECPMLevel());
                    handleSucceed();
                }
            } catch (Throwable unused) {
                handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
            }
        } else {
            handleFailed(YFAdError.ERROR_DATA_NULL, "");
        }
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onNativeFail(int i, String str, ExpressResponse expressResponse) {
        YFLog.warn(this.tag + " onNativeFail ");
        handleFailed(i + "", str);
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onNoAd(int i, String str, ExpressResponse expressResponse) {
        YFLog.warn(this.tag + " onNoAd code = " + i + " msg " + str);
        handleFailed(i + "", str);
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onVideoDownloadSuccess() {
        YFLog.high(this.tag + "onVideoDownloadSuccess");
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onVideoDownloadFailed() {
        YFLog.error(this.tag + "onVideoDownloadFailed");
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
    public void onLpClosed() {
        YFLog.high(this.tag + "onLpClosed");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.BAIDU.getValue();
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, final int i, AdBannerViewHolder adBannerViewHolder) {
        NativeResponse adNative = getAdNative(i);
        if (adNative == null) {
            YFLog.error("bindData error " + i);
            return;
        }
        boolean z = adNative.getMaterialType() == NativeResponse.MaterialType.VIDEO;
        YFLog.high(this.tag + " bindData isVideo " + z);
        this.feedBean = new FeedBean(adNative.getTitle(), adNative.getDesc(), z, bannerTemplateData);
        this.feedBean.updateSupplerInfo(this.sdkSupplier);
        this.feedBean.imageUrl = adNative.getImageUrl();
        if (z) {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_VIDEO, false);
            if (!TextUtils.isEmpty(adNative.getImageUrl())) {
                ViewUtils.loadBlurImage(adNative.getImageUrl(), adBannerViewHolder.imageBlur, 20);
            } else {
                ViewUtils.loadImageByLocal(R.mipmap.yf_ad_no_bg, adBannerViewHolder.imageBlur);
            }
        } else {
            adBannerViewHolder.showStyleView(AdBaseViewHolder.Style.TYPE_IMG, false);
            if (!TextUtils.isEmpty(adNative.getImageUrl())) {
                ViewUtils.loadBlurImage(adNative.getImageUrl(), adBannerViewHolder.imageBlur, 20);
                ViewUtils.loadImage(adNative.getImageUrl(), adBannerViewHolder.showImg);
            }
        }
        bannerTemplateData.updAdLog(R.mipmap.ad_log_bd_v3);
        if (!this.isSupportShake && bannerTemplateData.isOnlyAction()) {
            bannerTemplateData.setWholeClick();
            bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
            actionShakeToView(bannerTemplateData, adNative, adBannerViewHolder);
            if (this.actionView == null) {
                YFLog.error("shakeView is null, resetActivityStyle CLICK_V3.");
                if (bannerTemplateData.isOnlyAction()) {
                    bannerTemplateData.setWholeClick();
                }
                bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
            }
        }
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
        updateDownload(bannerTemplateData, adBannerViewHolder, adNative);
        if (bannerTemplateData.isShowAdIcon() && !TextUtils.isEmpty(adNative.getIconUrl())) {
            adBannerViewHolder.adIcon.setVisibility(0);
            ViewUtils.loadCircleImage(adNative.getIconUrl(), adBannerViewHolder.adIcon, (bannerTemplateData.scale * 15) / 100);
        }
        adBannerViewHolder.getCloseView(bannerTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1060xcf4e6e7d(i, view);
            }
        });
        registerViewForInteraction(adBannerViewHolder, z, adNative, bannerTemplateData, i);
        if (activity != null) {
            this.feedBean.contextName = activity.getLocalClassName();
            final FragmentManager fragmentManager = activity.getFragmentManager();
            adBannerViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m1061xc0f8149c(fragmentManager, view);
                }
            });
        }
        complianceContent(adBannerViewHolder, bannerTemplateData, adNative);
    }

    /* JADX INFO: renamed from: lambda$bindData$6$com-yfanads-ads-chanel-bd-BDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1060xcf4e6e7d(int i, View view) {
        closeAds(i);
    }

    /* JADX INFO: renamed from: lambda$bindData$7$com-yfanads-ads-chanel-bd-BDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1061xc0f8149c(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE);
    }

    private void updateDownload(BannerTemplateData bannerTemplateData, AdBannerViewHolder adBannerViewHolder, NativeResponse nativeResponse) {
        String actButtonString;
        if (bannerTemplateData.showDownloadBtn()) {
            if (bannerTemplateData.isTemplateV3() && bannerTemplateData.isShake()) {
                adBannerViewHolder.mDownload.setVisibility(8);
                adBannerViewHolder.mDownloadBar.setVisibility(0);
                return;
            }
            adBannerViewHolder.mDownload.setVisibility(0);
            if (adBannerViewHolder.mDownloadBar != null) {
                adBannerViewHolder.mDownloadBar.setVisibility(8);
            }
            TextView textView = adBannerViewHolder.mDownload;
            if (TextUtils.isEmpty(nativeResponse.getActButtonString())) {
                actButtonString = getContext().getString(R.string.yf_default_download_text);
            } else {
                actButtonString = nativeResponse.getActButtonString();
            }
            textView.setText(actButtonString);
            if (this.feedBean != null) {
                this.feedBean.actBtnString = nativeResponse.getActButtonString();
                return;
            }
            return;
        }
        adBannerViewHolder.mDownload.setVisibility(8);
    }

    private NativeResponse getAdNative(int i) {
        if (YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size()) {
            YFLog.error("bindData error " + i);
            return null;
        }
        return this.nativeAds2.get(i);
    }

    private View getShakeView(final BannerTemplateData bannerTemplateData, final NativeResponse nativeResponse, final AdBannerViewHolder adBannerViewHolder) {
        return nativeResponse.renderShakeView(80, 80, new NativeResponse.AdShakeViewListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda9
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
            public final void onDismiss() {
                this.f$0.m1062xb8b5b7ed(bannerTemplateData, adBannerViewHolder, nativeResponse);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getShakeView$8$com-yfanads-ads-chanel-bd-BDNativeExpressAdapter, reason: not valid java name */
    /* synthetic */ void m1062xb8b5b7ed(BannerTemplateData bannerTemplateData, AdBannerViewHolder adBannerViewHolder, NativeResponse nativeResponse) {
        this.actionView.setVisibility(8);
        bannerTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        adBannerViewHolder.updateShowView(getContext(), bannerTemplateData);
        updateDownload(bannerTemplateData, adBannerViewHolder, nativeResponse);
    }

    private void actionShakeToView(BannerTemplateData bannerTemplateData, NativeResponse nativeResponse, AdBannerViewHolder adBannerViewHolder) {
        View shakeView = getShakeView(bannerTemplateData, nativeResponse, adBannerViewHolder);
        this.actionView = shakeView;
        addToView(bannerTemplateData, shakeView, adBannerViewHolder);
    }

    private void addToView(BannerTemplateData bannerTemplateData, View view, AdBannerViewHolder adBannerViewHolder) {
        if (view == null) {
            return;
        }
        int iDip2px = ScreenUtil.dip2px(getContext(), 80.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDip2px, iDip2px);
        if (bannerTemplateData.isTemplateV3_W615() || bannerTemplateData.isTemplateV3_W626()) {
            layoutParams.addRule(15, R.id.show_area);
            layoutParams.addRule(18, R.id.show_area);
            layoutParams.addRule(19, R.id.show_area);
        } else {
            layoutParams.addRule(13);
        }
        view.setLayoutParams(layoutParams);
        adBannerViewHolder.viewGroup.addView(view);
    }

    private void registerViewForInteraction(AdBannerViewHolder adBannerViewHolder, boolean z, NativeResponse nativeResponse, BannerTemplateData bannerTemplateData, int i) {
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
                if (isDownloadType(nativeResponse) && !bannerTemplateData.isActionShowDialog()) {
                    arrayList2.add(adBannerViewHolder.mDownloadBar);
                    arrayList2.add(adBannerViewHolder.mDownload);
                } else {
                    arrayList.add(adBannerViewHolder.mDownloadBar);
                    arrayList.add(adBannerViewHolder.mDownload);
                }
            } else if (isDownloadType(nativeResponse) && !bannerTemplateData.isActionShowDialog()) {
                arrayList2.add(adBannerViewHolder.mDownload);
            } else {
                arrayList.add(adBannerViewHolder.mDownload);
            }
        }
        if (z) {
            adBannerViewHolder.onClickView.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YFLog.debug("onClickView");
                }
            });
            bindMediaView(adBannerViewHolder, nativeResponse, arrayList, arrayList2, bannerTemplateData.isMute(), i);
        } else {
            bindImageViews(adBannerViewHolder, nativeResponse, arrayList, arrayList2, i);
        }
    }

    private boolean isDownloadType(NativeResponse nativeResponse) {
        return nativeResponse.getAdActionType() == 2;
    }

    private void bindMediaView(AdBaseViewHolder adBaseViewHolder, NativeResponse nativeResponse, List<View> list, List<View> list2, boolean z, final int i) {
        nativeResponse.registerViewForInteraction(adBaseViewHolder.viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter.3
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i2) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BDNativeExpressAdapter.this.handleClick(i, false);
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                BDNativeExpressAdapter.this.handleExposure(i);
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i2) {
                YFLog.error(BDNativeExpressAdapter.this.tag + " bindMediaView onADExposureFailed: " + i2);
                BDNativeExpressAdapter.this.handleRenderFailed(i);
            }
        });
        final XNativeView xNativeView = new XNativeView(getContext());
        xNativeView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        xNativeView.setBackgroundColor(-16776961);
        xNativeView.setNativeItem(nativeResponse);
        xNativeView.setUseDownloadFrame(true);
        xNativeView.setVideoMute(z);
        xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter.4
            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onCompletion() {
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onError() {
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onPause() {
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onRenderingStart() {
                YFLog.debug("Renderint start " + xNativeView.getWidth() + ", " + xNativeView.getHeight());
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onResume() {
                xNativeView.render();
            }
        });
        if (xNativeView.getParent() == null) {
            adBaseViewHolder.mediaViewFrame.removeAllViews();
            adBaseViewHolder.mediaViewFrame.addView(xNativeView);
        }
        xNativeView.render();
    }

    private void bindImageViews(AdBaseViewHolder adBaseViewHolder, NativeResponse nativeResponse, List<View> list, List<View> list2, final int i) {
        nativeResponse.registerViewForInteraction(adBaseViewHolder.viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.yfanads.ads.chanel.bd.BDNativeExpressAdapter.5
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i2) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BDNativeExpressAdapter.this.handleClick(i, false);
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                BDNativeExpressAdapter.this.handleExposure(i);
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i2) {
                YFLog.error(BDNativeExpressAdapter.this.tag + " bindImageViews onADExposureFailed: " + i2);
                BDNativeExpressAdapter.this.handleRenderFailed(i);
            }
        });
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public boolean isDownloadType(int i) {
        List<NativeResponse> list = this.nativeAds2;
        if (list != null && list.get(i) != null) {
            return isDownloadAd(this.nativeAds2.get(i));
        }
        return super.isDownloadType(i);
    }

    private void complianceContent(AdBannerViewHolder adBannerViewHolder, BannerTemplateData bannerTemplateData, NativeResponse nativeResponse) {
        if (isDownloadAd(nativeResponse)) {
            complianceView(adBannerViewHolder, bannerTemplateData, new DownloadAppInfo(nativeResponse.getBrandName(), nativeResponse.getAppVersion(), nativeResponse.getPublisher(), nativeResponse.getAppFunctionLink(), nativeResponse.getAppPermissionLink(), nativeResponse.getAppPrivacyLink()));
            if (this.feedBean != null) {
                this.feedBean.updateAppInfo(nativeResponse.getBrandName(), nativeResponse.getAppVersion(), nativeResponse.getPublisher());
                return;
            }
            return;
        }
        adBannerViewHolder.complianceContent.setVisibility(8);
    }

    private boolean isDownloadAd(NativeResponse nativeResponse) {
        return (!isDownloadType(nativeResponse) || TextUtils.isEmpty(nativeResponse.getAppVersion()) || TextUtils.isEmpty(nativeResponse.getPublisher()) || TextUtils.isEmpty(nativeResponse.getAppPrivacyLink()) || TextUtils.isEmpty(nativeResponse.getAppPermissionLink())) ? false : true;
    }
}
