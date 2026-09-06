package com.yfanads.android.core;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.callback.AdCoreAction;
import com.yfanads.android.callback.AdsControlCallback;
import com.yfanads.android.callback.AdsSpotCallback;
import com.yfanads.android.callback.BaseAdListener;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.callback.BaseExpAdListener;
import com.yfanads.android.callback.OnResultListener;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.model.DataStatue;
import com.yfanads.android.model.EventData;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.List;

/* JADX INFO: compiled from: BaseAdsSpot.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class i implements AdCoreAction, BaseAdapterEvent {
    private c adsControl;
    private AdsSpotCallback adsSpotCallback;
    private String requestId;
    private final String tag;

    /* JADX INFO: compiled from: BaseAdsSpot.java */
    public class a implements OnResultListener<StrategyModel> {
        public a() {
        }

        @Override // com.yfanads.android.callback.OnResultListener
        public final void onFailed(int i, String str) {
            YFLog.traceDebug("toGetData onFailed " + i + " req:" + i.this.requestId);
            i.this.onAdFailed(YFAdError.parseErr("1001", str));
        }

        @Override // com.yfanads.android.callback.OnResultListener
        public final void onSuccess(StrategyModel strategyModel) {
            YFLog.traceDebug("toGetData onSuccess req:" + i.this.requestId);
            i.this.startAds(strategyModel);
        }
    }

    public i(Context context, BaseAdListener baseAdListener) {
        String str = "[" + getClass().getSimpleName() + "] ";
        this.tag = str;
        try {
            com.yfanads.android.strategy.d dVar = new com.yfanads.android.strategy.d(context, str, baseAdListener);
            this.adsControl = dVar;
            this.requestId = dVar.g();
        } catch (Exception e) {
            f.a(e, new StringBuilder().append(this.tag).append(" FCAdsBaseSpot "));
        }
    }

    private boolean isInterstitialAd() {
        return getAType() == YFAdType.INTR.getValue();
    }

    private void report(String str, String str2) {
        EventData eventData = new EventData();
        eventData.eId = Util.getRandomUuid();
        eventData.rId = str;
        eventData.eType = YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue();
        eventData.aType = getAType();
        eventData.t = Util.getCurrentTime();
        eventData.cd = str2;
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b.a.f9685a.a(eventData);
    }

    private void reportStartLoadEvent(String str) {
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b bVar = com.yfanads.android.upload.b.a.f9685a;
        YFAdsConst.ReportETypeValue reportETypeValue = YFAdsConst.ReportETypeValue.ADS_LOAD_START;
        int value = reportETypeValue.getValue();
        bVar.getClass();
        if (com.yfanads.android.upload.b.a(value)) {
            return;
        }
        YFLog.debug(this.tag + " reportStartLoadEvent req:" + this.requestId + ",eventId:" + reportETypeValue.getValue());
        EventData eventData = new EventData();
        eventData.eId = Util.getRandomUuid();
        eventData.rId = this.requestId;
        eventData.adId = str;
        eventData.eType = reportETypeValue.getValue();
        eventData.aType = getAType();
        eventData.t = Util.getCurrentTime();
        bVar.a(eventData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAds(final StrategyModel strategyModel) {
        Util.EXECUTOR.submit(new Runnable() { // from class: com.yfanads.android.core.i$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1212lambda$startAds$3$comyfanadsandroidcorei(strategyModel);
            }
        });
    }

    public void closeAds() {
        c cVar = this.adsControl;
        if (cVar instanceof com.yfanads.android.strategy.d) {
            com.yfanads.android.strategy.d dVar = (com.yfanads.android.strategy.d) cVar;
            dVar.getClass();
            try {
                StringBuilder sbAppend = new StringBuilder().append(dVar.b).append(" forceCloseTopPushAd ");
                BaseChanelAdapter baseChanelAdapter = dVar.i;
                YFLog.debug(sbAppend.append(baseChanelAdapter != null ? Integer.valueOf(baseChanelAdapter.getCType()) : "").toString());
                BaseChanelAdapter baseChanelAdapter2 = dVar.i;
                if (baseChanelAdapter2 == null || baseChanelAdapter2.getCType() != YFAdType.TOPPUSH.getValue()) {
                    return;
                }
                dVar.i.closeAds();
            } catch (Exception e) {
                f.a(e, new StringBuilder().append(dVar.b).append(" forceCloseTopPushAd exception: "));
            }
        }
    }

    @Override // com.yfanads.android.callback.AdCoreAction
    public void destroy() {
        try {
            YFLog.traceDebug(this.tag + " ad destroy req:" + this.requestId);
            c cVar = this.adsControl;
            if (cVar != null) {
                ((com.yfanads.android.strategy.d) cVar).d();
                this.adsControl = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getAType() {
        return 0;
    }

    @Override // com.yfanads.android.callback.AdCoreAction
    public long getEcpm() {
        if (!InitUtils.isEpsOpen()) {
            YFLog.high("ecpm not support.");
            return 0L;
        }
        c cVar = this.adsControl;
        if (cVar != null) {
            return ((com.yfanads.android.strategy.d) cVar).r;
        }
        return 0L;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public boolean isSupportShopMall() {
        c cVar = this.adsControl;
        if (cVar == null) {
            return false;
        }
        cVar.getClass();
        return true;
    }

    /* JADX INFO: renamed from: lambda$startAds$0$com-yfanads-android-core-i, reason: not valid java name */
    /* synthetic */ void m1210lambda$startAds$0$comyfanadsandroidcorei(DataStatue dataStatue) {
        onAdFailed(YFAdError.parseErr(dataStatue.getValue()));
    }

    /* JADX INFO: renamed from: lambda$startAds$2$com-yfanads-android-core-i, reason: not valid java name */
    /* synthetic */ BaseAdapterEvent m1211lambda$startAds$2$comyfanadsandroidcorei() {
        return this;
    }

    @Override // com.yfanads.android.callback.AdCoreAction
    public void loadOnly(final String str) {
        boolean z;
        com.yfanads.android.b bVar = com.yfanads.android.b.a.f9633a;
        synchronized (bVar) {
            z = bVar.b == 1;
        }
        if (z) {
            h.a(new StringBuilder(), this.tag, " loadOnly SDK has no init, return failed");
        } else if (bVar.a()) {
            bVar.f9632a.add(new com.yfanads.android.b.InterfaceC1176b() { // from class: com.yfanads.android.core.i$$ExternalSyntheticLambda4
                @Override // com.yfanads.android.b.InterfaceC1176b
                public final void a() {
                    this.f$0.m1209lambda$loadOnly$4$comyfanadsandroidcorei(str);
                }
            });
        } else {
            m1209lambda$loadOnly$4$comyfanadsandroidcorei(str);
        }
    }

    @Deprecated
    public void onActivityResult(int i, int i2) {
        YFLog.warn("onActivityResult call, but not");
    }

    public void setAdsSpotCallback(AdsSpotCallback adsSpotCallback) {
        this.adsSpotCallback = adsSpotCallback;
    }

    public void setStopLooperByClick(boolean z) {
        if (this.adsControl == null || !isInterstitialAd()) {
            return;
        }
        ((com.yfanads.android.strategy.d) this.adsControl).z = z;
    }

    /* JADX INFO: renamed from: startLoad, reason: merged with bridge method [inline-methods] */
    public void m1209lambda$loadOnly$4$comyfanadsandroidcorei(String str) {
        YFLog.traceDebug("toGetData start req:" + this.requestId + ", adId:" + str + ", appId:" + YFAdsManager.getInstance().getYFAdsConfig().getAppId() + ".");
        reportStartLoadEvent(str);
        com.yfanads.android.db.d.a.f9643a.a(str, new a(), this.requestId, YFAdsManager.getInstance().getYFAdsConfig());
    }

    @Override // com.yfanads.android.callback.BaseAdapterEvent
    public void adapterDidClicked(SdkSupplier sdkSupplier, boolean z) {
        if (this.adsControl == null) {
            h.a(new StringBuilder(), this.tag, "adapterDidClicked adsControl is null");
            return;
        }
        g.a(new StringBuilder("adapterDidClicked ").append(sdkSupplier).append("|needCallback:").append(z).append("|req:"), this.requestId);
        if (!z) {
            setStopLooperByClick(true);
            return;
        }
        setStopLooperByClick(true);
        BaseAdListener baseAdListener = ((com.yfanads.android.strategy.d) this.adsControl).f9681a;
        if (baseAdListener == null) {
            YFLog.error("adapterDidClicked adListener is null");
            return;
        }
        try {
            if (baseAdListener instanceof BaseExpAdListener) {
                ((BaseExpAdListener) baseAdListener).onAdClicked((ExpView) sdkSupplier.getCustom());
            } else {
                baseAdListener.onAdClicked();
            }
        } catch (Exception e) {
            YFLog.error("adapterDidClicked " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.callback.BaseAdapterEvent
    public void adapterDidClosed(SdkSupplier sdkSupplier) {
        if (this.adsControl == null) {
            h.a(new StringBuilder(), this.tag, "adapterDidClosed adsControl is null");
            return;
        }
        g.a(new StringBuilder("adapterDidClosed ").append(sdkSupplier).append("|req:"), this.requestId);
        BaseAdListener baseAdListener = ((com.yfanads.android.strategy.d) this.adsControl).f9681a;
        if (baseAdListener == null) {
            YFLog.error("adapterDidClosed adListener is null");
            return;
        }
        try {
            setStopLooperByClick(false);
            if (baseAdListener instanceof BaseExpAdListener) {
                ((BaseExpAdListener) baseAdListener).onAdClosed((ExpView) sdkSupplier.getCustom());
            } else {
                baseAdListener.onAdClosed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.callback.BaseAdapterEvent
    public void adapterDidExposure(SdkSupplier sdkSupplier) {
        c cVar = this.adsControl;
        if (cVar == null) {
            h.a(new StringBuilder(), this.tag, "adapterDidExposure adsControl is null");
            return;
        }
        com.yfanads.android.strategy.d dVar = (com.yfanads.android.strategy.d) cVar;
        if (dVar.w != null) {
            dVar.w.a();
        }
        g.a(new StringBuilder("adapterDidExposure ").append(sdkSupplier).append("|req:"), this.requestId);
        BaseAdListener baseAdListener = ((com.yfanads.android.strategy.d) this.adsControl).f9681a;
        if (baseAdListener == null) {
            YFLog.error("adapterDidExposure adListener is null");
            return;
        }
        try {
            if (baseAdListener instanceof BaseExpAdListener) {
                ((BaseExpAdListener) baseAdListener).onAdExposure((ExpView) sdkSupplier.getCustom());
            } else {
                baseAdListener.onAdExposure();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.callback.BaseAdapterEvent
    public void adapterRenderFailed(SdkSupplier sdkSupplier) {
        if (this.adsControl == null) {
            h.a(new StringBuilder(), this.tag, "adapterRenderFailed adsControl is null");
            return;
        }
        g.a(new StringBuilder("adapterRenderFailed ").append(sdkSupplier).append("|req:"), this.requestId);
        BaseAdListener baseAdListener = ((com.yfanads.android.strategy.d) this.adsControl).f9681a;
        if (baseAdListener == null) {
            YFLog.error("adapterRenderFailed adListener is null");
            return;
        }
        try {
            if (baseAdListener instanceof BaseExpAdListener) {
                ((BaseExpAdListener) baseAdListener).onAdRenderFailed((ExpView) sdkSupplier.getCustom());
            } else {
                baseAdListener.onAdRenderFailed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean findReadyAd() {
        c cVar = this.adsControl;
        if (cVar == null) {
            return false;
        }
        com.yfanads.android.strategy.d dVar = (com.yfanads.android.strategy.d) cVar;
        String str = "广告瀑布流findReadyAd 主动调用超时 req:" + dVar.n;
        YFLog.traceDebug(str);
        d.a(new StringBuilder(), dVar.b, str);
        String str2 = dVar.n;
        int value = YFAdsConst.ReportETypeValue.CHECK_AD_READY.getValue();
        YFAdType yFAdType = YFAdType.NONE;
        dVar.a(value, yFAdType.getValue(), str2, null);
        StrategyModel strategyModel = dVar.k;
        if (strategyModel != null) {
            strategyModel.setTotalTimeout(true);
        }
        if (dVar.i != null) {
            YFLog.high(dVar.b + "findReadyAd 主动调用超时 has already success req:" + dVar.n);
            return false;
        }
        e.a(new StringBuilder(), dVar.b, " check ads load");
        com.yfanads.android.strategy.a aVar = dVar.p;
        if (aVar == null || !aVar.a()) {
            com.yfanads.android.strategy.f fVar = dVar.q;
            if (fVar != null && fVar.a()) {
                String str3 = "findReadyAd 主动调用超时 check ads load success in bidding, return req:" + dVar.n;
                YFLog.traceDebug(str3);
                YFLog.high(dVar.b + str3);
                dVar.c();
            } else {
                if (!dVar.a()) {
                    YFLog.traceDebug("findReadyAd 主动调用超时 ad is null, return req:" + dVar.n);
                    dVar.g = YFAdError.parseErr("1005");
                    dVar.a(YFAdsConst.ReportETypeValue.CHECK_AD_READY_NULL.getValue(), yFAdType.getValue(), dVar.n, "1005");
                    dVar.a(true, true);
                    return false;
                }
                String str4 = "findReadyAd 主动调用超时 check ads load success in list, return req:" + dVar.n;
                YFLog.traceDebug(str4);
                YFLog.high(dVar.b + str4);
                dVar.c();
            }
        } else {
            String str5 = "findReadyAd 主动调用超时 check ads load success in parallel, return req:" + dVar.n;
            YFLog.traceDebug(str5);
            YFLog.high(dVar.b + str5);
            dVar.c();
        }
        return true;
    }

    public int getCurrentType() {
        c cVar = this.adsControl;
        if (cVar != null) {
            return ((com.yfanads.android.strategy.d) cVar).f;
        }
        return 0;
    }

    public boolean isReady() {
        c cVar = this.adsControl;
        if (cVar == null) {
            return false;
        }
        com.yfanads.android.strategy.d dVar = (com.yfanads.android.strategy.d) cVar;
        dVar.getClass();
        try {
            BaseChanelAdapter baseChanelAdapter = dVar.i;
            if (baseChanelAdapter != null) {
                return baseChanelAdapter.isReady();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            f.a(e, new StringBuilder("isReady ads exception "));
            return false;
        }
    }

    /* JADX INFO: renamed from: lambda$startAds$3$com-yfanads-android-core-i, reason: not valid java name */
    void m1212lambda$startAds$3$comyfanadsandroidcorei(final StrategyModel strategyModel) {
        final DataStatue dataStatueU;
        com.yfanads.android.strategy.d dVar;
        StrategyModel strategyModel2;
        c cVar = this.adsControl;
        if (cVar != null) {
            com.yfanads.android.strategy.d dVar2 = (com.yfanads.android.strategy.d) cVar;
            try {
                dVar2.k = strategyModel;
                dVar2.t = strategyModel.getCarouselCount();
                YFLog.debug(dVar2.b + " setData MAX_INTERSTITIAL_LOOP_COUNT = " + dVar2.t + " this:" + dVar2);
                StrategyModel strategyModel3 = dVar2.k;
                if (strategyModel3 == null || strategyModel3.getAdControl() == null || (dVar2.k.isSdkSupplierEmpty() && dVar2.k.isBiddingEmpty())) {
                    YFLog.error(dVar2.b + " setData sdkSupplier is empty, return");
                    dataStatueU = DataStatue.NORMAL;
                } else {
                    dataStatueU = dVar2.u();
                }
            } catch (Exception e) {
                e.printStackTrace();
                f.a(e, new StringBuilder().append(dVar2.b).append(" setData "));
                dataStatueU = DataStatue.NORMAL;
            }
            if (dataStatueU != DataStatue.NORMAL) {
                report(((com.yfanads.android.strategy.d) this.adsControl).n, dataStatueU.getValue());
            }
        } else {
            dataStatueU = DataStatue.NORMAL;
        }
        com.yfanads.android.upload.a aVar = com.yfanads.android.upload.a.C1178a.f9683a;
        if (!aVar.f9682a) {
            aVar.f9682a = true;
            boolean z = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b.a.f9685a.getClass();
            com.yfanads.android.upload.b.a();
        }
        c cVar2 = this.adsControl;
        if (cVar2 == null || (strategyModel2 = (dVar = (com.yfanads.android.strategy.d) cVar2).k) == null || strategyModel2.getAdControl() == null || (dVar.k.isSdkSupplierEmpty() && dVar.k.isBiddingEmpty())) {
            YFLog.warn(this.tag + " emptySuppliers, return");
            YFUtil.switchMainThread("emptySuppliers", new BaseEnsureListener() { // from class: com.yfanads.android.core.i$$ExternalSyntheticLambda3
                @Override // com.yfanads.android.callback.BaseEnsureListener
                public final void ensure() {
                    this.f$0.m1210lambda$startAds$0$comyfanadsandroidcorei(dataStatueU);
                }
            });
            return;
        }
        try {
            YFOptional.ofNullable(this.adsSpotCallback).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.android.core.i$$ExternalSyntheticLambda1
                @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
                public final void accept(Object obj) {
                    ((AdsSpotCallback) obj).loadResult(strategyModel.getBindInfo());
                }
            });
            com.yfanads.android.strategy.d dVar3 = (com.yfanads.android.strategy.d) this.adsControl;
            dVar3.o = new c.b() { // from class: com.yfanads.android.core.i$$ExternalSyntheticLambda2
                @Override // com.yfanads.android.core.c.b
                public final BaseAdapterEvent a() {
                    return this.f$0.m1211lambda$startAds$2$comyfanadsandroidcorei();
                }
            };
            dVar3.e();
        } catch (Exception e2) {
            f.a(e2, new StringBuilder().append(this.tag).append(" startLoad "));
        }
    }

    public void logSupplier(String str, SdkSupplier sdkSupplier) {
        c cVar = this.adsControl;
        if (cVar != null) {
            YFLog.high(((com.yfanads.android.strategy.d) cVar).b + "_" + str + "_, sdkSupplier = " + sdkSupplier);
        }
    }

    public void onAdFailed(YFAdError yFAdError) {
        if (this.adsControl == null) {
            h.a(new StringBuilder(), this.tag, "onAdFailed adsControl is null");
            return;
        }
        YFLog.traceDebug("onAdFailed " + yFAdError);
        BaseAdListener baseAdListener = ((com.yfanads.android.strategy.d) this.adsControl).f9681a;
        if (baseAdListener == null) {
            YFLog.error("onAdFailed adListener is null");
            return;
        }
        try {
            if (baseAdListener instanceof BaseExpAdListener) {
                ((BaseExpAdListener) baseAdListener).onAdFailed(yFAdError);
            } else {
                baseAdListener.onAdFailed(yFAdError);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAdType(YFAdType yFAdType) {
        c cVar = this.adsControl;
        if (cVar != null) {
            ((com.yfanads.android.strategy.d) cVar).j = yFAdType;
        }
    }

    public void setAdsFailCallback(AdsControlCallback adsControlCallback) {
        c cVar = this.adsControl;
        if (cVar != null) {
            ((com.yfanads.android.strategy.d) cVar).x = adsControlCallback;
        }
    }

    public void showAds(Activity activity) {
        c cVar = this.adsControl;
        if (cVar != null) {
            ((com.yfanads.android.strategy.d) cVar).a(activity, new int[0]);
        }
    }

    public void showAds(Activity activity, ViewGroup viewGroup) {
        com.yfanads.android.strategy.d dVar;
        BaseChanelAdapter baseChanelAdapter;
        c cVar = this.adsControl;
        if (cVar == null || (baseChanelAdapter = (dVar = (com.yfanads.android.strategy.d) cVar).i) == null) {
            return;
        }
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        YFLog.traceDebug("showAds " + sDKSupplier + "|req:" + dVar.n + "|act:" + activity);
        dVar.i.show(activity, viewGroup);
        if (sDKSupplier == null || !sDKSupplier.isFromCache()) {
            return;
        }
        com.yfanads.android.db.d dVar2 = com.yfanads.android.db.d.a.f9643a;
        String adId = sDKSupplier.getAdId();
        BaseChanelAdapter baseChanelAdapter2 = dVar.i;
        List list = (List) dVar2.f9642a.get(adId);
        if (YFListUtils.isEmpty(list)) {
            YFLog.high("DataManager cache has no");
        } else {
            boolean zRemove = list.remove(baseChanelAdapter2);
            dVar2.f9642a.put(adId, list);
            SdkSupplier sDKSupplier2 = baseChanelAdapter2.getSDKSupplier();
            if (com.yfanads.android.db.d.a(sDKSupplier2)) {
                dVar2.b.remove(sDKSupplier2);
            }
            YFLog.high("DataManager removeCache statue " + zRemove);
        }
        YFLog.high("remove [cache] " + sDKSupplier + "|req:" + dVar.n);
    }
}
