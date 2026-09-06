package com.yfanads.ads.chanel.zd;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.ad.banner.BannerAdEventListener;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.IBannerAd;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdEventListener;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.AdErrorInfo;
import com.yfanads.ads.chanel.zd.model.ZDNativeAds;
import com.yfanads.ads.chanel.zd.utils.ZDUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.custom.MixBannerCustomAdapter;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ZDMixBannerAdapter extends MixBannerCustomAdapter implements YFNativeCall, BannerAdEventListener, InteractionListener {
    private BannerAdLoader bannerAdLoader;
    private IBannerAd bannerView;
    private RecyclerMixAdLoader nativeAd;
    private List<RecyclerAdData> nativeAds;

    public ZDMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        ZDUtil.initZD(this.tag, this.sdkSupplier, getContext(), getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.zd.ZDMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                ZDMixBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YFLog.error(ZDMixBannerAdapter.this.tag + " onNoAd msg:" + str + "_" + str2);
                ZDMixBannerAdapter.this.handleFailed(YFAdError.parseErr(YFAdError.ERROR_INIT_FAILED));
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadBannerAd(Context context) {
        try {
            if (context instanceof Activity) {
                BannerAdLoader bannerAdLoader = new BannerAdLoader((Activity) context, new MsAdSlot.Builder().setPid(getPotID()).setFetchCount(1).setVideoMute(true).build(), this);
                this.bannerAdLoader = bannerAdLoader;
                bannerAdLoader.loadAd();
                YFLog.high(this.tag + " loadBannerAd end -- ");
            } else {
                handleFailed(YFAdError.parseErr(YFAdError.ERROR_JINDAI_CONTEXT));
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " loadBannerAd error:" + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadTemplateAd(Context context) {
        loadNativeByMix(context);
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadNativeAd(Context context) {
        loadNativeByMix(context);
    }

    private void loadNativeByMix(Context context) {
        try {
            RecyclerMixAdLoader recyclerMixAdLoader = new RecyclerMixAdLoader(context, new MsAdSlot.Builder().setPid(getPotID()).setFetchCount(1).setVideoMute(true).build(), new RecyclerAdEventListener() { // from class: com.yfanads.ads.chanel.zd.ZDMixBannerAdapter.2
                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdError(AdErrorInfo adErrorInfo) {
                    try {
                        YFLog.debug("onAdFailed " + adErrorInfo);
                        ZDMixBannerAdapter.this.handleFailed(adErrorInfo.getErrorType(), " ad fail " + adErrorInfo.getMessage());
                    } catch (Exception e) {
                        YFLog.error(ZDMixBannerAdapter.this.tag + " onError:" + e.getMessage());
                    }
                }

                @Override // com.meishu.sdk.core.ad.IAdEventListener
                public void onAdReady(List<RecyclerAdData> list) {
                    try {
                        if (!YFListUtils.isEmpty(list) && list.get(0) != null) {
                            ZDMixBannerAdapter.this.updData(list);
                            ZDMixBannerAdapter.this.updPrice();
                            ZDMixBannerAdapter.this.handleSucceed();
                        } else {
                            ZDMixBannerAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        }
                    } catch (Throwable th) {
                        YFLog.error(ZDMixBannerAdapter.this.tag + " onNativeAdLoad " + th.getMessage());
                        ZDMixBannerAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                }
            });
            this.nativeAd = recyclerMixAdLoader;
            recyclerMixAdLoader.loadAd();
            YFLog.high(this.tag + " doLoadAD end -- ");
        } catch (Exception e) {
            YFLog.error(this.tag + " doLoadAD error:" + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowTemplateAd(Activity activity) {
        try {
            YFLog.high(this.tag + " doShowTemplateAd--");
            if (!YFListUtils.isEmpty(this.nativeAds)) {
                List<ExpView> expViews = getExpViews();
                if (this.setting != null) {
                    this.setting.adapterRenderSuccess(this.sdkSupplier, expViews);
                }
            } else if (this.setting != null) {
                this.setting.adapterRenderFailed(this.sdkSupplier);
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " doShowTemplateAd--" + e.getMessage());
            handleShowFailed();
        }
    }

    private List<ExpView> getExpViews() {
        ArrayList arrayList = new ArrayList();
        Context context = getContext();
        for (int i = 0; i < this.nativeAds.size(); i++) {
            RecyclerAdData recyclerAdData = this.nativeAds.get(i);
            FrameLayout frameLayout = new FrameLayout(context);
            YFExpView yFExpView = new YFExpView(frameLayout, getAdType(), i);
            arrayList.add(yFExpView);
            ZDExpViewListener zDExpViewListener = new ZDExpViewListener(yFExpView, this);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(frameLayout);
            recyclerAdData.bindAdToView(context, frameLayout, arrayList2, zDExpViewListener);
        }
        return arrayList;
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowBannerAd(Activity activity) {
        try {
            YFLog.high(this.tag + " doShowBannerAd--");
            if (this.bannerView != null) {
                FrameLayout frameLayout = new FrameLayout(activity);
                this.viewList.add(new YFExpView(frameLayout, getAdType()));
                if (this.setting != null) {
                    this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
                }
                this.bannerView.showAd(frameLayout);
                return;
            }
            if (this.setting != null) {
                this.setting.adapterRenderFailed(this.sdkSupplier);
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " doShowBannerAd--" + e.getMessage());
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        try {
            if (isTemplate()) {
                List<RecyclerAdData> list = this.nativeAds;
                return (list == null || list.get(0) == null || !this.nativeAds.get(0).isAdValid()) ? false : true;
            }
            if (isBanner()) {
                IBannerAd iBannerAd = this.bannerView;
                return iBannerAd != null && iBannerAd.isAdValid();
            }
            if (isDevelop() && !YFListUtils.isEmpty(this.developAds)) {
                YFNativeAd yFNativeAd = this.developAds.get(0);
                return yFNativeAd instanceof ZDNativeAds ? ((ZDNativeAds) yFNativeAd).isReady() : super.isReady();
            }
            return super.isReady();
        } catch (Exception e) {
            YFLog.error("isReady " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        try {
            if (isTemplate()) {
                return (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size() || this.nativeAds.get(i) == null || this.nativeAds.get(0).getData() == null) ? "" : this.nativeAds.get(0).getData().getReqId();
            }
            if (isBanner()) {
                IBannerAd iBannerAd = this.bannerView;
                return (iBannerAd == null || iBannerAd.getData() == null) ? "" : this.bannerView.getData().getReqId();
            }
            if (isDevelop() && !YFListUtils.isEmpty(this.developAds) && i < this.developAds.size()) {
                YFNativeAd yFNativeAd = this.developAds.get(i);
                return yFNativeAd instanceof ZDNativeAds ? ((ZDNativeAds) yFNativeAd).getAdReqId() : "";
            }
        } catch (Exception e) {
            YFLog.error("getRequestId " + e.getMessage());
        }
        return "";
    }

    @Override // com.meishu.sdk.core.ad.IAdEventListener
    public void onAdError(AdErrorInfo adErrorInfo) {
        try {
            YFLog.debug("onAdFailed " + adErrorInfo);
            handleFailed(adErrorInfo.getErrorType(), " ad fail " + adErrorInfo.getMessage());
        } catch (Exception e) {
            YFLog.error(this.tag + " onError:" + e.getMessage());
        }
    }

    @Override // com.meishu.sdk.core.ad.IAdEventListener
    public void onAdReady(IBannerAd iBannerAd) {
        if (iBannerAd == null) {
            handleFailed(YFAdError.ERROR_DATA_NULL, this.tag + " KsSplashScreenAd null");
            return;
        }
        this.bannerView = iBannerAd;
        iBannerAd.setInteractionListener(this);
        if (iBannerAd.getData() != null) {
            setEcpmByStr(iBannerAd.getData().getEcpm());
        }
        handleSucceed();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        HashMap map = new HashMap();
        String shortString = "";
        map.put("winPrice", Integer.valueOf(YFUtil.toInt(getEcpm() + "", 0)));
        map.put("highestLossPrice", Integer.valueOf(sdkSupplier != null ? YFUtil.toInt(sdkSupplier.ecpm + "", 0) : 0));
        IBannerAd iBannerAd = this.bannerView;
        if (iBannerAd != null) {
            iBannerAd.sendWinNotification(map);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            Iterator<RecyclerAdData> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().sendWinNotification(map);
            }
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof ZDNativeAds) {
                ((ZDNativeAds) yFNativeAd).sendSucBiddingResult(map);
            }
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        HashMap map = new HashMap();
        String shortString = "";
        map.put("winPrice", Integer.valueOf(sdkSupplier != null ? YFUtil.toInt(sdkSupplier.ecpm + "", 0) : 0));
        map.put("lossReason", 1);
        map.put("adnId", 2);
        IBannerAd iBannerAd = this.bannerView;
        if (iBannerAd != null) {
            iBannerAd.sendLossNotification(map);
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        IBannerAd iBannerAd2 = this.bannerView;
        if (iBannerAd2 != null) {
            iBannerAd2.sendLossNotification(map);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier2 != null) {
                shortString = sdkSupplier2.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
        if (!YFListUtils.isEmpty(this.nativeAds)) {
            Iterator<RecyclerAdData> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().sendLossNotification(map);
            }
        }
        if (YFListUtils.isEmpty(this.developAds)) {
            return;
        }
        for (YFNativeAd yFNativeAd : this.developAds) {
            if (yFNativeAd instanceof ZDNativeAds) {
                ((ZDNativeAds) yFNativeAd).sendLossBiddingResult(map);
            }
        }
    }

    protected static final class ZDExpViewListener extends NativeExpressCustomAdapter.ExpViewListener<ZDMixBannerAdapter> implements RecylcerAdInteractionListener {
        private final ExpView expView;

        public ZDExpViewListener(YFExpView yFExpView, ZDMixBannerAdapter zDMixBannerAdapter) {
            super(zDMixBannerAdapter);
            this.expView = yFExpView;
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
        public void onAdClosed() {
            YFLog.debug(" onAdClose ");
            if (getAdapter() != null) {
                getAdapter().handleClose(this.expView);
            }
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
        public void onAdRenderFailed() {
            YFLog.error("onRenderFail msg ");
            if (getAdapter() == null || getAdapter().setting == null) {
                return;
            }
            getAdapter().setting.adapterRenderFailed(getAdapter().sdkSupplier);
        }

        @Override // com.meishu.sdk.core.loader.InteractionListener
        public void onAdClicked() {
            YFLog.debug(" onAdClicked");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
        public void onAdExposure() {
            YFLog.debug("onAdShow onAdShow");
            if (getAdapter() != null) {
                getAdapter().handleExposure(this.expView);
            }
        }
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdClicked() {
        YFLog.debug("onAdClicked ");
        handleClick();
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdExposure() {
        YFLog.debug("onAdExposure");
        handleExposure();
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdClosed() {
        YFLog.debug("onAdClosed ");
        handleClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updData(List<RecyclerAdData> list) {
        if (!isDevelop()) {
            this.nativeAds = list;
            return;
        }
        this.developAds.clear();
        for (int i = 0; i < list.size(); i++) {
            this.developAds.add(new ZDNativeAds(getContext(), list.get(i), this));
        }
        YFLog.error("has no develop");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updPrice() {
        if (isDevelop()) {
            if (YFListUtils.isEmpty(this.developAds) || this.developAds.get(0) == null) {
                return;
            }
            setEcpm(this.developAds.get(0).getECPM());
            return;
        }
        List<RecyclerAdData> list = this.nativeAds;
        if (list == null || list.get(0) == null || this.nativeAds.get(0).getData() == null) {
            return;
        }
        setEcpmByStr(this.nativeAds.get(0).getData().getEcpm());
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        YFLog.high(this.tag + "doDestroy");
        super.doDestroy();
        BannerAdLoader bannerAdLoader = this.bannerAdLoader;
        if (bannerAdLoader != null) {
            bannerAdLoader.destroy();
        }
        List<RecyclerAdData> list = this.nativeAds;
        if (list != null) {
            Iterator<RecyclerAdData> it = list.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.nativeAds.clear();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.ZD.getValue();
    }
}
