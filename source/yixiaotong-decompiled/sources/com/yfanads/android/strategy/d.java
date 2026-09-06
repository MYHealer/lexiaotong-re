package com.yfanads.android.strategy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.callback.AdsControlCallback;
import com.yfanads.android.callback.BaseAdListener;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.custom.InterstitialCustomAdapter;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.lifecycle.LifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.AdControl;
import com.yfanads.android.model.DataStatue;
import com.yfanads.android.model.EventData;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.lang.ref.SoftReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AdsControlImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d implements com.yfanads.android.core.c, j, LifecycleListener {
    public long A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseAdListener f9681a;
    public final String b;
    public SoftReference<Activity> c;
    public SoftReference<Activity> d;
    public Context e;
    public YFAdError g;
    public BaseChanelAdapter i;
    public YFAdType j;
    public StrategyModel k;
    public Runnable l;
    public Runnable m;
    public String n;
    public com.yfanads.android.core.c.b o;
    public a p;
    public f q;
    public long r;
    public com.yfanads.android.core.c.a w;
    public AdsControlCallback x;
    public Runnable y;
    public int f = -1;
    public final ConcurrentHashMap h = new ConcurrentHashMap();
    public int s = 0;
    public int t = 0;
    public boolean u = false;
    public boolean v = false;
    public boolean z = false;

    public d(Context context, String str, BaseAdListener baseAdListener) {
        a(Util.getRandomUuid());
        this.e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (context instanceof Activity) {
            this.c = new SoftReference<>((Activity) context);
        }
        this.b = str + "|req:" + g() + "|>>";
        this.f9681a = baseAdListener;
        YFLog.high("init context = " + context);
    }

    public final void a(String str) {
        this.n = str;
    }

    public final boolean b(BaseChanelAdapter baseChanelAdapter) {
        if (baseChanelAdapter == null) {
            YFLog.warn(this.b + "isNextAdValidForLoop nextAdapter is null");
            return false;
        }
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        if (sDKSupplier == null) {
            YFLog.warn(this.b + "isNextAdValidForLoop nextSupplier is null: ");
            return false;
        }
        if (!(baseChanelAdapter instanceof InterstitialCustomAdapter)) {
            YFLog.warn(this.b + "isNextAdValidForLoop nextAdapter is not inter: " + baseChanelAdapter.getClass().getSimpleName());
            return false;
        }
        if (!sDKSupplier.isInterNative()) {
            YFLog.warn(this.b + "isNextAdValidForLoop nextAdapter is not native: ");
            return false;
        }
        String templateKey = sDKSupplier.getTemplateKey(TemplateRes.INT_V_2);
        YFLog.debug(this.b + "isNextAdValidForLoop templateKey: " + templateKey + "|" + Objects.equals(templateKey, TemplateRes.INT_V_3));
        return Objects.equals(templateKey, TemplateRes.INT_V_3);
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void c(Activity activity) {
        try {
            YFLog.debug(this.b + "showAds showMaxCacheAds");
            if (this.u) {
                YFLog.debug(this.b + "App is in background, skip showMaxCacheAds ads");
                return;
            }
            if (this.z) {
                YFLog.debug(this.b + " showMaxCacheAds stopped by click, return");
                return;
            }
            if (this.s >= this.t) {
                YFLog.debug(this.b + " showMaxCacheAds interstitialLoopCount=" + this.s + " >= " + this.t);
                return;
            }
            BaseChanelAdapter baseChanelAdapter = this.i;
            if (baseChanelAdapter != null && (baseChanelAdapter.isHasClose() || this.i.isDestroy())) {
                YFLog.debug(this.b + " showMaxCacheAds onlyLoadAdapter isHasClose or isDestroy, return");
                return;
            }
            Runnable runnable = this.m;
            if (runnable != null) {
                YFUtil.MAIN_HANDLER.removeCallbacks(runnable);
            }
            LinkedHashMap linkedHashMapB = b();
            if (linkedHashMapB != null && !linkedHashMapB.isEmpty()) {
                BaseChanelAdapter baseChanelAdapter2 = (BaseChanelAdapter) ((Map.Entry) linkedHashMapB.entrySet().iterator().next()).getKey();
                if (!b(baseChanelAdapter2)) {
                    YFLog.debug(this.b + " showMaxCacheAds next ad is not valid for loop, return");
                    return;
                }
                BaseChanelAdapter baseChanelAdapter3 = this.i;
                if (baseChanelAdapter3 != null && (baseChanelAdapter3 instanceof InterstitialCustomAdapter)) {
                    ((InterstitialCustomAdapter) baseChanelAdapter3).closeAdsWithoutEvent();
                }
                this.i = baseChanelAdapter2;
                if (baseChanelAdapter2.getSDKSupplier() != null && !Objects.equals(baseChanelAdapter2.getSDKSupplier().getReqId(), this.n)) {
                    baseChanelAdapter2.getSDKSupplier().setReqId(this.n);
                }
                baseChanelAdapter2.reportSdk(YFAdsConst.ReportETypeValue.FLOW_PADDING.getValue());
                int value = YFAdsConst.ReportETypeValue.FLOW_PADDING_RT.getValue();
                if (InitUtils.isRTReport(value)) {
                    baseChanelAdapter2.reportSdk(value, true);
                }
                BaseChanelAdapter baseChanelAdapter4 = this.i;
                if (baseChanelAdapter4 != null) {
                    this.s++;
                    SdkSupplier sDKSupplier = baseChanelAdapter4.getSDKSupplier();
                    if (sDKSupplier != null) {
                        if (!Objects.equals(sDKSupplier.getReqId(), this.n)) {
                            YFLog.debug(this.b + " showMaxCacheAds set reqId to " + this.n);
                            sDKSupplier.setReqId(this.n);
                        }
                        if (sDKSupplier.isTimeOut()) {
                            YFLog.debug(this.b + " showMaxCacheAds supplier is time out, set adStatus to load success");
                            sDKSupplier.setAdStatus(1);
                        }
                        if (sDKSupplier.ecpm > 0) {
                            float factors = InitUtils.getFactors();
                            if (factors == 0.0f) {
                                factors = 1.0f;
                            }
                            this.r = Math.round(sDKSupplier.ecpm * factors);
                        }
                        this.f = YFUtil.toInt(sDKSupplier.getAdnId(), -1);
                    }
                    this.i.reportSdk(YFAdsConst.ReportETypeValue.SHOW_NEXT_INTERSTITIAL.getValue());
                    a(activity, 1);
                    return;
                }
                return;
            }
            YFLog.debug(this.b + " showMaxCacheAds supplierMap is empty, return");
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder().append(this.b).append(" showMaxCacheAds "));
        }
    }

    public final String g() {
        return this.n;
    }

    public final void h() {
        String str = "广告瀑布流超时 req:" + this.n + " delay:" + (System.currentTimeMillis() - this.A) + "ms";
        YFLog.traceDebug(str);
        com.yfanads.android.core.d.a(new StringBuilder(), this.b, str);
        StrategyModel strategyModel = this.k;
        if (strategyModel != null) {
            strategyModel.setTotalTimeout(true);
        }
        if (this.i != null) {
            YFLog.high(this.b + " has already success req:" + this.n);
            return;
        }
        com.yfanads.android.core.e.a(new StringBuilder(), this.b, " check ads load");
        a aVar = this.p;
        if (aVar != null && aVar.a()) {
            String str2 = " check ads load success in parallel, return req:" + this.n;
            YFLog.traceDebug(str2);
            com.yfanads.android.core.e.a(new StringBuilder(), this.b, str2);
            return;
        }
        f fVar = this.q;
        if (fVar != null && fVar.a()) {
            String str3 = " check ads load success in bidding, return req:" + this.n;
            YFLog.traceDebug(str3);
            com.yfanads.android.core.e.a(new StringBuilder(), this.b, str3);
        } else if (a()) {
            String str4 = " check ads load success in list, return req:" + this.n;
            YFLog.traceDebug(str4);
            com.yfanads.android.core.e.a(new StringBuilder(), this.b, str4);
        } else {
            this.g = YFAdError.parseErr("1005");
            a(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), YFAdType.NONE.getValue(), this.n, "1005");
            a(false, true);
        }
    }

    public final void j() {
        Iterator it = this.h.keySet().iterator();
        while (it.hasNext()) {
            List<BaseChanelAdapter> list = (List) this.h.get((Integer) it.next());
            if (!YFListUtils.isEmpty(list)) {
                for (BaseChanelAdapter baseChanelAdapter : list) {
                    if (baseChanelAdapter != null && baseChanelAdapter.getSDKSupplier() != null && !baseChanelAdapter.getSDKSupplier().isFromCache()) {
                        baseChanelAdapter.destroy("onAdapterDestroy ads adapter");
                    } else if (baseChanelAdapter != null && baseChanelAdapter.getSDKSupplier() != null && baseChanelAdapter.getSDKSupplier().isFromCache()) {
                        YFLog.debug(this.b + "onAdapterDestroy cache adapter isn't destroy " + baseChanelAdapter.getSDKSupplier());
                    }
                }
                list.clear();
            }
        }
        this.h.clear();
    }

    public final void k() {
        YFUtil.switchMainThread("onBiddingTotalFailed", new d$$ExternalSyntheticLambda10(this));
    }

    public final void l() {
        this.g = YFAdError.parseErr(YFAdError.ERROR_EMPTY);
        a(true, false);
    }

    public final void m() {
        a(true, true);
    }

    public final void n() {
        s();
        if (this.k.isBFSerial()) {
            if (!this.k.hasBiddingList()) {
                q();
                return;
            }
            YFLog.traceDebug(this.b + " runBidding req:" + this.n);
            f fVar = new f(this.b, this.k, this.h, this, this.n);
            this.q = fVar;
            fVar.d();
            return;
        }
        try {
            YFLog.high(this.b + " strategy bp running");
            if (!this.k.hasSdkSupplier() && !this.k.hasBiddingList()) {
                YFLog.high(this.b + "strategy bp run empty");
                m();
            } else if (this.k.isAdControlEmpty()) {
                YFLog.error(this.b + "strategy bp adControl empty");
                m();
            } else if (this.k.getAdControl().isCParallelStrategyModel()) {
                p();
            } else {
                o();
            }
        } catch (Exception e) {
            YFLog.error(this.b + "selectSdkSupplier bp " + e.getMessage());
            this.g = YFAdError.parseErr(YFAdError.ERROR_SUPPLIER_SELECT);
            m();
        }
    }

    public final void o() {
        YFLog.traceDebug("runBParallel req:" + this.n);
        e eVar = new e(this.b, this.k, this.h, this, this.n);
        this.p = eVar;
        eVar.f();
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public final void onActivityPaused(Activity activity) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public final void onActivityResumed(Activity activity) {
    }

    public final void p() {
        YFLog.traceDebug("runCBParallel req:" + this.n);
        g gVar = new g(this.b, this.k, this.h, this, this.n);
        this.p = gVar;
        gVar.i();
    }

    public final void q() {
        try {
            YFLog.high(this.b + " strategy running");
            if (this.k.isSdkSupplierEmpty()) {
                YFLog.high(this.b + "strategy run empty");
                m();
            } else if (!this.k.isAdControlEmpty()) {
                r();
            } else {
                YFLog.error(this.b + "strategy adControl empty");
                m();
            }
        } catch (Exception e) {
            YFLog.error(this.b + "selectSdkSupplier " + e.getMessage());
            this.g = YFAdError.parseErr(YFAdError.ERROR_SUPPLIER_SELECT);
            m();
        }
    }

    public final void r() {
        if (this.k.getAdControl().isSerialModel()) {
            YFLog.traceDebug("runSerial req:" + this.n);
            new i(this.b, this.k, this.h, this, this.n).c();
        } else {
            YFLog.traceDebug("runParallel req:" + this.n);
            h hVar = new h(this.b, this.k, this.h, this, this.n);
            this.p = hVar;
            hVar.d();
        }
    }

    public final void s() {
        long totalReqTime = this.k.hasTotalReqTime() ? this.k.getTotalReqTime() : 5000L;
        this.A = System.currentTimeMillis();
        YFLog.high(this.b + " has total timeout " + totalReqTime);
        Runnable runnable = new Runnable() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.h();
            }
        };
        this.l = runnable;
        Util.MAIN_HANDLER.removeCallbacks(runnable);
        Util.MAIN_HANDLER.postDelayed(this.l, totalReqTime);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x024c  */
    public final DataStatue u() {
        DataStatue dataStatue;
        String str;
        String str2;
        ArrayList arrayList;
        try {
            if (YFListUtils.isMapEmpty(this.h)) {
                Iterator<Integer> it = InitUtils.getChannels().iterator();
                while (it.hasNext()) {
                    this.h.put(it.next(), new ArrayList());
                }
                YFLog.debug(this.b + "initChanelAdapterList size = " + this.h.size());
            }
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder().append(this.b).append("initChanelAdapterList "));
        }
        com.yfanads.android.db.d dVar = com.yfanads.android.db.d.a.f9643a;
        StrategyModel strategyModel = this.k;
        dVar.getClass();
        AdControl adControl = strategyModel.getAdControl();
        String sectionID = strategyModel.getSectionID();
        if (adControl == null || TextUtils.isEmpty(sectionID)) {
            YFLog.debug("isHitFrequency adControl is null or sessionId is null, return.");
            dataStatue = DataStatue.NORMAL;
        } else if (new com.yfanads.android.db.imp.d(sectionID, adControl.showInterval).a()) {
            dataStatue = DataStatue.HIT_FREQUENCY;
        } else if (new com.yfanads.android.db.imp.c(sectionID, adControl.showLimitHour).a()) {
            dataStatue = DataStatue.HIT_HOUR;
        } else {
            dataStatue = new com.yfanads.android.db.imp.a(sectionID, (long) adControl.showLimitDay).a() ? DataStatue.HIT_DAY : DataStatue.NORMAL;
        }
        SdkSupplier sdkSupplier = null;
        if (dataStatue != DataStatue.NORMAL) {
            DataStatue dataStatue2 = dataStatue;
            YFLog.debug("updateData hit frequency, set model null, return.");
            this.k = null;
            return dataStatue2;
        }
        List<SdkSupplier> sdkSupplierList = this.k.getSdkSupplierList();
        YFLog.traceDebug("[cache] filter start list.size " + sdkSupplierList.size() + " req:" + this.n);
        Iterator<SdkSupplier> it2 = sdkSupplierList.iterator();
        String adId = this.k.getAdId();
        SdkSupplier sdkSupplierA = dVar.a(this.n, adId);
        StrategyModel.Section section = this.k.getSection();
        StrategyModel.AB ab = this.k.getAb();
        int refresh = this.k.getRefresh();
        ArrayList arrayList2 = new ArrayList();
        String str3 = "";
        com.yfanads.android.upload.b.a.f9685a.a(sdkSupplierA, YFAdsConst.ReportETypeValue.ADS_CACHE_INTERRUPT_START.getValue(), "");
        String str4 = this.n;
        while (it2.hasNext()) {
            SdkSupplier next = it2.next();
            if (next == null) {
                str2 = str4;
            } else {
                int channel = next.getChannel();
                if (InitUtils.isFactoryChannel(channel)) {
                    if (InitUtils.hasImpSDK(channel)) {
                        str = str4;
                        if (!YFAdsPhone.getInstance().isPhoneType(channel)) {
                        }
                        str2 = str;
                    } else {
                        str = str4;
                    }
                    it2.remove();
                    str2 = str;
                } else {
                    str = str4;
                }
                if (YFAdsPhone.getInstance().needFilterJD(channel)) {
                    it2.remove();
                    str2 = str;
                } else {
                    String str5 = section != null ? section.sectionId : str3;
                    String str6 = ab != null ? ab.abId : str3;
                    String str7 = ab != null ? ab.groupId : str3;
                    section = section;
                    String str8 = adId;
                    str2 = str;
                    adId = adId;
                    str3 = str3;
                    String str9 = str6;
                    ab = ab;
                    arrayList = arrayList2;
                    String str10 = str7;
                    dataStatue = dataStatue;
                    refresh = refresh;
                    next.initKeys(str8, str5, str9, str10, str2);
                    next.setRefreshInterval(refresh);
                    if (next.isBidding()) {
                        if (sdkSupplierA == null || !TextUtils.equals(next.getPotId(), sdkSupplierA.getPotId())) {
                            arrayList.add(next);
                        } else {
                            arrayList.add(sdkSupplierA);
                        }
                        it2.remove();
                    } else if (sdkSupplierA != null && sdkSupplierA.ecpm >= next.ecpm) {
                        it2.remove();
                        sdkSupplier = sdkSupplierA;
                    }
                }
                refresh = refresh;
                str3 = str3;
                arrayList2 = arrayList;
                adId = adId;
                ab = ab;
                dataStatue = dataStatue;
                section = section;
                str4 = str2;
            }
            arrayList = arrayList2;
            refresh = refresh;
            str3 = str3;
            arrayList2 = arrayList;
            adId = adId;
            ab = ab;
            dataStatue = dataStatue;
            section = section;
            str4 = str2;
        }
        DataStatue dataStatue3 = dataStatue;
        String str11 = str4;
        String str12 = str3;
        ArrayList arrayList3 = arrayList2;
        if (!arrayList3.isEmpty()) {
            this.k.setBiddingList(arrayList3);
        }
        if (sdkSupplier != null) {
            if (sdkSupplier.isBidding()) {
                if (this.k.getBiddingList() != null) {
                    StrategyModel strategyModel2 = this.k;
                    if (strategyModel2 != null && !YFListUtils.isEmpty(strategyModel2.getBiddingList())) {
                        String potId = sdkSupplier.getPotId();
                        if (TextUtils.isEmpty(potId)) {
                            this.k.getBiddingList().add(sdkSupplier);
                            break;
                        }
                        Iterator<SdkSupplier> it3 = this.k.getBiddingList().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                this.k.getBiddingList().add(sdkSupplier);
                                break;
                            }
                            SdkSupplier next2 = it3.next();
                            if (next2 != null && potId.equals(next2.getPotId())) {
                                break;
                            }
                        }
                    } else {
                        this.k.getBiddingList().add(sdkSupplier);
                        break;
                    }
                }
            } else {
                sdkSupplierList.add(sdkSupplier);
            }
        } else if (sdkSupplierA != null && !sdkSupplierA.isBidding() && sdkSupplierList.isEmpty()) {
            sdkSupplierA.updateData(str11);
            sdkSupplierList.add(sdkSupplierA);
        }
        for (int i = 0; i < sdkSupplierList.size(); i++) {
            sdkSupplierList.get(i).position = i;
        }
        this.k.setSdkSupplierList(sdkSupplierList);
        com.yfanads.android.upload.b.a.f9685a.a(sdkSupplierA, YFAdsConst.ReportETypeValue.ADS_CACHE_INTERRUPT_END.getValue(), str12);
        YFLog.traceDebug("[cache] filter end bidding.size " + this.k.getBiddingList().size() + ", wf.size " + sdkSupplierList.size() + " req:" + this.n);
        if (YFAdsManager.getInstance().getYFAdsConfig() == null) {
            return dataStatue3;
        }
        YFAdsManager.getInstance().getYFAdsConfig().setIp(this.k.getIP());
        return dataStatue3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        boolean zSendBiddingResult;
        int i;
        SdkSupplier sDKSupplier;
        BaseChanelAdapter baseChanelAdapter = this.i;
        if (baseChanelAdapter == null) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.b, " sendBidingResult start adapter is null, return.");
            return;
        }
        StrategyModel strategyModel = this.k;
        SdkSupplier sdkSupplier = null;
        String[] biddingReport = strategyModel != null ? strategyModel.getBiddingReport() : null;
        YFLog.high(this.b + " sendBiddingResult start " + Arrays.toString(biddingReport));
        ArrayList<BaseChanelAdapter> arrayList = new ArrayList();
        for (List<BaseChanelAdapter> list : this.h.values()) {
            if (!YFListUtils.isEmpty(list)) {
                for (BaseChanelAdapter baseChanelAdapter2 : list) {
                    if (!baseChanelAdapter2.equals(baseChanelAdapter) && (sDKSupplier = baseChanelAdapter2.getSDKSupplier()) != null && sDKSupplier.isLoadSuccess()) {
                        int channel = sDKSupplier.getChannel();
                        if (8 != channel && 12 != channel) {
                            if (biddingReport != null) {
                                int length = biddingReport.length;
                                int i2 = 0;
                                while (true) {
                                    if (i2 < length) {
                                        if (YFUtil.toInt(biddingReport[i2], -1) != channel) {
                                            i2++;
                                        }
                                    }
                                }
                            }
                        }
                        arrayList.add(baseChanelAdapter2);
                        if (sdkSupplier == null || sdkSupplier.ecpm < sDKSupplier.ecpm) {
                            sdkSupplier = sDKSupplier;
                        }
                    }
                }
            }
        }
        SdkSupplier sDKSupplier2 = baseChanelAdapter.getSDKSupplier();
        int channel2 = sDKSupplier2.getChannel();
        if (8 == channel2 || 12 == channel2) {
            baseChanelAdapter.updateAdInfos();
            zSendBiddingResult = baseChanelAdapter.sendBiddingResult(sDKSupplier2, sdkSupplier);
        } else {
            if (biddingReport != null) {
                int length2 = biddingReport.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length2) {
                        if (YFUtil.toInt(biddingReport[i3], -1) == channel2) {
                            baseChanelAdapter.updateAdInfos();
                            zSendBiddingResult = baseChanelAdapter.sendBiddingResult(sDKSupplier2, sdkSupplier);
                        } else {
                            i3++;
                        }
                    }
                }
            }
            zSendBiddingResult = false;
        }
        if (YFListUtils.isEmpty(arrayList)) {
            i = 0;
        } else {
            i = 0;
            for (BaseChanelAdapter baseChanelAdapter3 : arrayList) {
                if (baseChanelAdapter3 != null && baseChanelAdapter3.sendBiddingResult(sDKSupplier2, sdkSupplier)) {
                    i++;
                }
            }
            arrayList.clear();
        }
        YFLog.high(this.b + " sendBiddingResult end wind=" + sDKSupplier2 + ",result=" + zSendBiddingResult + " ,secLoss=" + sdkSupplier + " , size=" + i);
    }

    public final void a(final Activity activity, int... iArr) {
        try {
            BaseChanelAdapter baseChanelAdapter = this.i;
            if (baseChanelAdapter != null) {
                final SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
                if (sDKSupplier != null && !Objects.equals(sDKSupplier.getReqId(), this.n)) {
                    sDKSupplier.setReqId(this.n);
                }
                YFLog.traceDebug("showAds " + (sDKSupplier != null ? sDKSupplier.toShortString() : "") + "|req:" + this.n + "|act:" + activity + "|ct_" + this.s + " this:" + this);
                this.d = new SoftReference<>(activity);
                this.i.show(activity, iArr);
                if (sDKSupplier != null && sDKSupplier.isFromCache()) {
                    com.yfanads.android.db.d dVar = com.yfanads.android.db.d.a.f9643a;
                    String adId = sDKSupplier.getAdId();
                    BaseChanelAdapter baseChanelAdapter2 = this.i;
                    List list = (List) dVar.f9642a.get(adId);
                    if (YFListUtils.isEmpty(list)) {
                        YFLog.high("DataManager cache has no");
                    } else {
                        boolean zRemove = list.remove(baseChanelAdapter2);
                        dVar.f9642a.put(adId, list);
                        SdkSupplier sDKSupplier2 = baseChanelAdapter2.getSDKSupplier();
                        if (com.yfanads.android.db.d.a(sDKSupplier2)) {
                            dVar.b.remove(sDKSupplier2);
                        }
                        YFLog.high("DataManager removeCache statue " + zRemove);
                    }
                    YFLog.high(this.i.hashCode() + " remove [cache] " + sDKSupplier + "|req:" + this.n);
                }
                this.w = new com.yfanads.android.core.c.a() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda2
                    @Override // com.yfanads.android.core.c.a
                    public final void a() {
                        this.f$0.a(sDKSupplier, activity);
                    }
                };
            }
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder("show ads exception "));
        }
    }

    public final void c() {
        StrategyModel strategyModel = this.k;
        if (strategyModel == null || !strategyModel.hasTotalReqTime() || this.l == null) {
            return;
        }
        com.yfanads.android.core.d.a(new StringBuilder(), this.b, " clearTotalReqTimeout");
        Util.MAIN_HANDLER.removeCallbacks(this.l);
    }

    public final Context f() {
        SoftReference<Activity> softReference = this.c;
        if (softReference != null) {
            if (softReference.get() != null) {
                return this.c.get();
            }
            YFLog.warn(this.b + " Method GetContext Has GC, recovery.");
        }
        return this.e;
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public final void onBackToBackground() {
        this.u = true;
        com.yfanads.android.core.d.a(new StringBuilder(), this.b, "pauseCarouselTasks");
        Runnable runnable = this.m;
        if (runnable != null) {
            YFUtil.MAIN_HANDLER.removeCallbacks(runnable);
            this.m = null;
        }
        Runnable runnable2 = this.y;
        if (runnable2 != null) {
            YFUtil.MAIN_HANDLER.removeCallbacks(runnable2);
            this.y = null;
        }
        this.v = true;
    }

    public final boolean t() {
        if (this.s >= this.t) {
            return false;
        }
        YFLog.debug(this.b + "isNeedInterstitialLooper carouselCountCheck: " + (this.k.getCarouselCount() > 0) + ", carouselCount: " + this.k.getCarouselCount());
        LinkedHashMap linkedHashMapB = b();
        if (linkedHashMapB != null && !linkedHashMapB.isEmpty()) {
            return a((BaseChanelAdapter) ((Map.Entry) linkedHashMapB.entrySet().iterator().next()).getKey());
        }
        com.yfanads.android.core.d.a(new StringBuilder(), this.b, "isNeedInterstitialLooper no next ads available");
        return false;
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public final void onBackToForeground() {
        BaseChanelAdapter baseChanelAdapter;
        this.u = false;
        try {
            if (!this.v || (baseChanelAdapter = this.i) == null || this.s >= this.t) {
                return;
            }
            if (baseChanelAdapter != null && (baseChanelAdapter instanceof InterstitialCustomAdapter) && baseChanelAdapter.getSDKSupplier() != null) {
                SdkSupplier sDKSupplier = this.i.getSDKSupplier();
                if (Objects.equals(sDKSupplier.getTemplateKey(TemplateRes.INT_V_2), TemplateRes.INT_V_3) && sDKSupplier.isInterNative()) {
                    SoftReference<Activity> softReference = this.d;
                    final Activity activity = softReference != null ? softReference.get() : null;
                    if (activity != null && !activity.isFinishing()) {
                        Runnable runnable = new Runnable() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda6
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.a(activity);
                            }
                        };
                        this.m = runnable;
                        YFUtil.MAIN_HANDLER.postDelayed(runnable, this.k.getCarouselInterval());
                        a(activity, this.k.getCarouselInterval() + AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth);
                    }
                    this.v = false;
                    return;
                }
            }
            YFLog.debug(this.b + " onBackToForeground resume carousel isn’t supportTopPush, return.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        BaseChanelAdapter baseChanelAdapter = this.i;
        if (baseChanelAdapter != null && (baseChanelAdapter.isHasClose() || this.i.isDestroy())) {
            com.yfanads.android.core.d.a(new StringBuilder(), this.b, " mToastNotificationRunnable isHasClose or isDestroy, return");
            return;
        }
        if (this.z) {
            com.yfanads.android.core.d.a(new StringBuilder(), this.b, " mToastNotificationRunnable stopped by click, return");
            return;
        }
        if (this.u) {
            com.yfanads.android.core.d.a(new StringBuilder(), this.b, "App is in background, skip showToast");
        } else if (!t()) {
            YFLog.debug(this.b + "!shouldShowNextAdToast, skip showToast interstitialLoopCount:" + this.s + " max:" + this.t + " this:" + this);
        } else {
            e(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SdkSupplier sdkSupplier, final Activity activity) {
        BaseChanelAdapter baseChanelAdapter = this.i;
        if (!(baseChanelAdapter instanceof InterstitialCustomAdapter) || !a(baseChanelAdapter)) {
            YFLog.debug("isn't support interstitialLooper, return");
            return;
        }
        if (this.j == YFAdType.INTR) {
            LifecycleObserver.getInstance().registerLifecycleListener(this);
        }
        YFLog.debug(this.b + " Interstitial hasRealExposure " + (sdkSupplier != null ? sdkSupplier.toShortString() : "") + "|req:" + this.n);
        a(activity, this.k.getCarouselInterval() + AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth);
        if (this.s < this.t) {
            Runnable runnable = new Runnable() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c(activity);
                }
            };
            this.m = runnable;
            YFUtil.MAIN_HANDLER.postDelayed(runnable, this.k.getCarouselInterval());
        }
    }

    public final boolean a(BaseChanelAdapter baseChanelAdapter) {
        boolean z = this.k.getCarouselCount() > 0;
        boolean z2 = baseChanelAdapter instanceof InterstitialCustomAdapter;
        boolean z3 = (baseChanelAdapter == null || baseChanelAdapter.getSDKSupplier() == null) ? false : true;
        boolean z4 = z3 && baseChanelAdapter.getSDKSupplier().isInterNative();
        boolean z5 = z3 && Objects.equals(z3 ? baseChanelAdapter.getSDKSupplier().getTemplateKey(TemplateRes.INT_V_2) : null, TemplateRes.INT_V_3);
        boolean z6 = z && z2 && z3 && z4 && z5;
        YFLog.debug(this.b + "checkInterstitialLooperConditions final result: " + z6 + ", c: " + z + ", a: " + z2 + ", s: " + z3 + ", i: " + z4 + ", t: " + z5);
        return z6;
    }

    public final void a(final Activity activity, long j) {
        long jMax = Math.max(0L, j);
        if (this.m != null) {
            YFUtil.MAIN_HANDLER.removeCallbacks(this.y);
        }
        Runnable runnable = new Runnable() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(activity);
            }
        };
        this.y = runnable;
        YFUtil.MAIN_HANDLER.postDelayed(runnable, jMax);
    }

    public final boolean a() {
        SdkSupplier next;
        BaseChanelAdapter baseChanelAdapterA;
        StrategyModel strategyModel = this.k;
        if (strategyModel == null) {
            return false;
        }
        List<SdkSupplier> sdkSupplierList = strategyModel.getSdkSupplierList();
        if (YFListUtils.isEmpty(sdkSupplierList)) {
            return false;
        }
        Iterator<SdkSupplier> it = sdkSupplierList.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (next.isBidding()) {
                    int adnIdValue = next.getAdnIdValue();
                    List list = (List) this.h.get(Integer.valueOf(adnIdValue));
                    if (list != null) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                baseChanelAdapterA = (BaseChanelAdapter) it2.next();
                                if (Util.isStrEquals(next.getPotId(), baseChanelAdapterA.getPotID())) {
                                    YFLog.high(adnIdValue + " hasBiddingOrCache hit bidding list");
                                    break;
                                }
                            }
                        }
                    }
                } else if (next.isFromCache()) {
                    baseChanelAdapterA = com.yfanads.android.db.d.a.f9643a.a(next.getAdId());
                    if (next.isTimeOut()) {
                        next.setAdStatus(1);
                    }
                    com.yfanads.android.core.e.a(new StringBuilder(), this.b, " hasBiddingOrCache hit cache list");
                    break;
                }
            }
            next = null;
            baseChanelAdapterA = null;
            break;
        }
        if (baseChanelAdapterA == null) {
            return false;
        }
        a(baseChanelAdapterA, next);
        baseChanelAdapterA.reportSdk(YFAdsConst.ReportETypeValue.FLOW_PADDING.getValue());
        int value = YFAdsConst.ReportETypeValue.FLOW_PADDING_RT.getValue();
        if (InitUtils.isRTReport(value)) {
            baseChanelAdapterA.reportSdk(value, true);
        }
        return true;
    }

    public final LinkedHashMap a(ArrayList arrayList) {
        BaseChanelAdapter baseChanelAdapterA;
        BaseChanelAdapter baseChanelAdapter;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<Map.Entry> arrayList2 = new ArrayList();
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SdkSupplier sdkSupplier = (SdkSupplier) it.next();
                if (sdkSupplier != null) {
                    boolean zEquals = Objects.equals(sdkSupplier.getTemplateKey(TemplateRes.INT_V_2), TemplateRes.INT_V_3);
                    if (sdkSupplier.isFromCache() && sdkSupplier.isInterNative() && zEquals) {
                        com.yfanads.android.db.d dVar = com.yfanads.android.db.d.a.f9643a;
                        dVar.getClass();
                        try {
                            baseChanelAdapter = com.yfanads.android.db.d.a(sdkSupplier) ? (BaseChanelAdapter) dVar.b.get(sdkSupplier) : null;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (baseChanelAdapter != null && sdkSupplier.getAdStatus() != -1) {
                            if (sdkSupplier.isTimeOut()) {
                                sdkSupplier.setAdStatus(1);
                            }
                            arrayList2.add(new AbstractMap.SimpleEntry(baseChanelAdapter, sdkSupplier));
                        }
                    }
                }
            }
            Collections.sort(arrayList2, new Comparator() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda11
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return d.a((Map.Entry) obj, (Map.Entry) obj2);
                }
            });
            for (Map.Entry entry : arrayList2) {
                linkedHashMap.put((BaseChanelAdapter) entry.getKey(), (SdkSupplier) entry.getValue());
            }
        } catch (Exception e2) {
            YFLog.error(this.b + " checkAllStrategyFromCache exception: " + e2.getMessage());
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SdkSupplier sdkSupplier2 = (SdkSupplier) it2.next();
                if (sdkSupplier2 != null && sdkSupplier2.isFromCache() && (baseChanelAdapterA = com.yfanads.android.db.d.a.f9643a.a(sdkSupplier2.getAdId())) != null) {
                    if (sdkSupplier2.isTimeOut()) {
                        sdkSupplier2.setAdStatus(1);
                    }
                    linkedHashMap.put(baseChanelAdapterA, sdkSupplier2);
                }
            }
        }
        return linkedHashMap;
    }

    public static /* synthetic */ int a(Map.Entry entry, Map.Entry entry2) {
        SdkSupplier sdkSupplier = (SdkSupplier) entry.getValue();
        SdkSupplier sdkSupplier2 = (SdkSupplier) entry2.getValue();
        if (sdkSupplier == null && sdkSupplier2 == null) {
            return 0;
        }
        if (sdkSupplier == null) {
            return 1;
        }
        if (sdkSupplier2 == null) {
            return -1;
        }
        return Long.compare(sdkSupplier2.ecpm, sdkSupplier.ecpm);
    }

    public final void a(int i, int i2, String str, String str2) {
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b bVar = com.yfanads.android.upload.b.a.f9685a;
        bVar.getClass();
        if (com.yfanads.android.upload.b.a(i)) {
            return;
        }
        EventData eventData = new EventData();
        eventData.eId = Util.getRandomUuid();
        eventData.eType = i;
        eventData.t = Util.getCurrentTime();
        eventData.aType = i2;
        eventData.rId = str;
        StrategyModel strategyModel = this.k;
        if (strategyModel != null) {
            eventData.adId = strategyModel.getAdId();
        }
        if (!TextUtils.isEmpty(str2)) {
            eventData.cd = str2;
        }
        bVar.a(eventData);
    }

    public static void e(final Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        final String str = "即将播放下一条广告";
        Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(activity, str, 0).show();
            }
        });
    }

    public final void e() {
        StrategyModel strategyModel = this.k;
        if (strategyModel == null || strategyModel.getAdControl() == null || (this.k.isSdkSupplierEmpty() && this.k.isBiddingEmpty())) {
            YFUtil.switchMainThread("dispatchSuppliers", new BaseEnsureListener() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda4
                @Override // com.yfanads.android.callback.BaseEnsureListener
                public final void ensure() {
                    this.f$0.l();
                }
            });
            return;
        }
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b bVar = com.yfanads.android.upload.b.a.f9685a;
        StrategyModel strategyModel2 = this.k;
        String adId = strategyModel2 != null ? strategyModel2.getAdId() : "";
        StrategyModel strategyModel3 = this.k;
        String sectionID = strategyModel3 != null ? strategyModel3.getSectionID() : "";
        StrategyModel strategyModel4 = this.k;
        String abId = strategyModel4 != null ? strategyModel4.getAbId() : "";
        StrategyModel strategyModel5 = this.k;
        String gId = strategyModel5 != null ? strategyModel5.getGId() : "";
        String randomUuid = Util.getRandomUuid();
        int value = YFAdsConst.ReportETypeValue.FLOW_REQ.getValue();
        YFAdType yFAdType = YFAdType.NONE;
        int value2 = yFAdType.getValue();
        String str = this.n;
        bVar.getClass();
        if (!com.yfanads.android.upload.b.a(value)) {
            EventData eventData = new EventData();
            eventData.eId = randomUuid;
            eventData.t = Util.getCurrentTime();
            eventData.eType = value;
            eventData.aType = value2;
            eventData.rId = str;
            eventData.adId = adId;
            eventData.sId = sectionID;
            eventData.abId = abId;
            eventData.gId = gId;
            bVar.a(eventData);
        }
        int value3 = YFAdsConst.ReportETypeValue.FLOW_REQ_RT.getValue();
        if (InitUtils.isRTReport(value3)) {
            String randomUuid2 = Util.getRandomUuid();
            int value4 = yFAdType.getValue();
            String str2 = this.n;
            EventData eventData2 = new EventData();
            eventData2.eId = randomUuid2;
            eventData2.t = Util.getCurrentTime();
            eventData2.eType = value3;
            eventData2.aType = value4;
            eventData2.rId = str2;
            eventData2.adId = adId;
            eventData2.sId = sectionID;
            eventData2.abId = abId;
            eventData2.gId = gId;
            try {
                bVar.b();
                bVar.f9684a.d(eventData2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        YFUtil.switchMainThread("dispatchSuppliers", new BaseEnsureListener() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda5
            @Override // com.yfanads.android.callback.BaseEnsureListener
            public final void ensure() {
                this.f$0.n();
            }
        });
    }

    public final void a(String str, int i, int i2) {
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b bVar = com.yfanads.android.upload.b.a.f9685a;
        bVar.getClass();
        if (com.yfanads.android.upload.b.a(i)) {
            return;
        }
        EventData eventData = new EventData();
        eventData.eId = Util.getRandomUuid();
        eventData.eType = i;
        eventData.t = Util.getCurrentTime();
        eventData.aType = i2;
        eventData.rId = str;
        StrategyModel strategyModel = this.k;
        if (strategyModel != null) {
            eventData.adId = strategyModel.getAdId();
        }
        try {
            bVar.b();
            bVar.f9684a.d(eventData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(boolean z, boolean z2) {
        try {
            YFLog.debug(this.b + " onTotalFailed ,isClearTimeout:" + z + " ,report:" + z2 + ",req:" + this.n);
            if (z) {
                c();
            }
            if (this.g == null) {
                this.g = YFAdError.parseErr(YFAdError.ERROR_DATA_NULL, "");
            }
            if (z2) {
                YFAdType yFAdType = this.j;
                int type = yFAdType != null ? yFAdType.getType() : YFAdType.NONE.getValue();
                a(YFAdsConst.ReportETypeValue.FLOW_PADDING_FAIL.getValue(), type, this.n, null);
                int value = YFAdsConst.ReportETypeValue.FLOW_PADDING_FAIL_RT.getValue();
                if (InitUtils.isRTReport(value)) {
                    a(this.n, value, type);
                }
            }
            a(this.g);
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder().append(this.b).append(" onTotalFailed exception "));
        }
    }

    public final void d() {
        try {
            YFLog.high(this.b + " adControl start destroy");
            LifecycleObserver.getInstance().unRegisterLifecycleListener(this);
            this.s = 0;
            Runnable runnable = this.m;
            if (runnable != null) {
                YFUtil.MAIN_HANDLER.removeCallbacks(runnable);
            }
            Runnable runnable2 = this.y;
            if (runnable2 != null) {
                YFUtil.MAIN_HANDLER.removeCallbacks(runnable2);
            }
            this.w = null;
            this.z = false;
            if (!YFListUtils.isMapEmpty(this.h)) {
                j();
            }
            c();
            BaseChanelAdapter baseChanelAdapter = this.i;
            if (baseChanelAdapter != null) {
                baseChanelAdapter.destroy("ads control");
                this.i = null;
            }
            SoftReference<Activity> softReference = this.c;
            if (softReference != null && softReference.get() != null) {
                this.c.clear();
                this.c = null;
            }
            SoftReference<Activity> softReference2 = this.d;
            if (softReference2 != null && softReference2.get() != null) {
                this.d.clear();
                this.d = null;
            }
            if (this.e != null) {
                this.e = null;
            }
            if (this.o != null) {
                this.o = null;
            }
            if (this.f9681a != null) {
                this.f9681a = null;
            }
            a aVar = this.p;
            if (aVar != null) {
                aVar.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.yfanads.android.core.f.a(e, new StringBuilder("destroy exception "));
        }
    }

    public final LinkedHashMap b() {
        StrategyModel strategyModel = this.k;
        if (strategyModel == null) {
            return null;
        }
        List<SdkSupplier> copyWaterfall = strategyModel.getCopyWaterfall();
        List<SdkSupplier> biddingList = this.k.getBiddingList();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(copyWaterfall);
        arrayList.addAll(biddingList);
        if (YFListUtils.isEmpty(arrayList)) {
            return null;
        }
        LinkedHashMap linkedHashMapA = a(arrayList);
        YFLog.debug(this.b + " checkStrategyFromCache size " + arrayList.size() + " , supplierMapCache size " + linkedHashMapA.size());
        return linkedHashMapA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(YFAdError yFAdError) {
        BaseAdListener baseAdListener = this.f9681a;
        if (baseAdListener != null) {
            baseAdListener.onAdFailed(yFAdError);
        }
        try {
            AdsControlCallback adsControlCallback = this.x;
            if (adsControlCallback != null) {
                adsControlCallback.loadResult(false);
                this.x = null;
            }
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder().append(this.b).append(" loadResult "));
        }
    }

    public final BaseChanelAdapter a(Integer num) {
        try {
            com.yfanads.android.core.c.b bVar = this.o;
            BaseAdapterEvent baseAdapterEventA = bVar == null ? null : bVar.a();
            if (baseAdapterEventA == null) {
                YFLog.error(this.b + " loadNewAdapter adsSpotCallback is null, return.");
                return null;
            }
            return c.a(num, this.j, baseAdapterEventA);
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder().append(this.b).append(" initAdapter "));
            return null;
        }
    }

    public final void a(final YFAdError yFAdError) {
        com.yfanads.android.core.g.a(new StringBuilder("adapterDidFail ").append(yFAdError != null ? yFAdError.msg : "").append(" req:"), this.n);
        YFUtil.switchMainThread("adapterDidFail", new BaseEnsureListener() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda7
            @Override // com.yfanads.android.callback.BaseEnsureListener
            public final void ensure() {
                this.f$0.b(yFAdError);
            }
        });
    }

    public final void a(BaseChanelAdapter baseChanelAdapter, SdkSupplier sdkSupplier) {
        try {
            YFLog.traceDebug("adapterDidSuccess " + sdkSupplier + "|req:" + this.n);
            if (baseChanelAdapter != null && baseChanelAdapter.getSDKSupplier() != null) {
                baseChanelAdapter.getSDKSupplier().setBidSuccess(true);
            }
            this.i = baseChanelAdapter;
            this.s = 0;
            if (sdkSupplier.ecpm > 0) {
                float factors = InitUtils.getFactors();
                if (factors == 0.0f) {
                    factors = 1.0f;
                }
                this.r = Math.round(sdkSupplier.ecpm * factors);
            }
            this.f = YFUtil.toInt(sdkSupplier.getAdnId(), -1);
            BaseAdListener baseAdListener = this.f9681a;
            if (baseAdListener != null) {
                baseAdListener.onAdSuccess();
            }
            if (baseChanelAdapter != null) {
                baseChanelAdapter.didSuccess();
            }
            try {
                AdsControlCallback adsControlCallback = this.x;
                if (adsControlCallback != null) {
                    adsControlCallback.loadResult(true);
                    this.x = null;
                }
            } catch (Exception e) {
                YFLog.error(this.b + " loadResult " + e.getMessage());
            }
            Util.EXECUTOR.submit(new Runnable() { // from class: com.yfanads.android.strategy.d$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.i();
                }
            });
        } catch (Exception e2) {
            com.yfanads.android.core.f.a(e2, new StringBuilder().append(this.b).append(" adapterDidSuccess "));
        }
    }

    public final void a(SdkSupplier sdkSupplier, boolean z) {
        if (sdkSupplier != null) {
            com.yfanads.android.core.g.a(new StringBuilder().append(this.b).append(" bidding updateData = ").append(sdkSupplier.ecpm).append(" req:"), this.n);
            boolean z2 = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b.a.f9685a.a(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_BIDDING_INTERRUPT_START.getValue(), "");
            List<SdkSupplier> sdkSupplierList = this.k.getSdkSupplierList();
            if (!sdkSupplierList.isEmpty()) {
                Iterator<SdkSupplier> it = sdkSupplierList.iterator();
                while (it.hasNext()) {
                    if (it.next().ecpm <= sdkSupplier.ecpm) {
                        it.remove();
                    }
                }
            }
            if (z && (sdkSupplierList.isEmpty() || !sdkSupplierList.get(sdkSupplierList.size() - 1).isFromCache())) {
                sdkSupplierList.add(sdkSupplier);
            }
            this.k.setSdkSupplierList(sdkSupplierList);
            com.yfanads.android.upload.b.a.f9685a.a(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_BIDDING_INTERRUPT_END.getValue(), "");
            com.yfanads.android.core.g.a(new StringBuilder().append(this.b).append(" bidding updateData ").append(this.k.getSdkSupplierList()).append(" req:"), this.n);
        }
        if (z) {
            YFUtil.switchMainThread("onBiddingTotalSuccess", new d$$ExternalSyntheticLambda10(this));
        }
    }
}
