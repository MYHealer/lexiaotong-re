package com.yfanads.android.strategy;

import android.text.TextUtils;
import com.yfanads.android.callback.UnionSdkResultListener;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BPStrategyControl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class e extends a implements UnionSdkResultListener {
    public final CopyOnWriteArrayList f;
    public final CopyOnWriteArrayList g;
    public BaseChanelAdapter h;
    public BaseChanelAdapter i;
    public final CopyOnWriteArrayList j;
    public final AtomicInteger k;
    public String l;
    public boolean m;
    public final CopyOnWriteArrayList n;
    public final ConcurrentHashMap o;
    public int p;
    public long q;
    public String r;
    public int s;
    public int t;
    public boolean u;

    public e(String str, StrategyModel strategyModel, ConcurrentHashMap concurrentHashMap, j jVar, String str2) {
        super(str, strategyModel, concurrentHashMap, jVar, str2);
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.k = new AtomicInteger(0);
        this.n = new CopyOnWriteArrayList();
        this.o = new ConcurrentHashMap();
    }

    public final void a(String str) {
        BaseChanelAdapter baseChanelAdapter;
        j jVar;
        com.yfanads.android.core.g.a(new StringBuilder("runParallel start in ").append(this.r).append(" , source ").append(str).append(" req:"), this.e);
        this.g.clear();
        this.j.clear();
        this.o.clear();
        this.n.clear();
        this.t = 0;
        if (!this.u && (baseChanelAdapter = this.h) != null && (jVar = this.b) != null) {
            ((d) jVar).a(baseChanelAdapter.getSDKSupplier(), false);
            this.u = true;
        }
        for (SdkSupplier sdkSupplier : this.c.getSdkSupplierList()) {
            if (this.g.size() == this.c.getParallelCnt()) {
                break;
            } else {
                this.g.add(sdkSupplier);
            }
        }
        YFLog.high("saveParallelData " + this.g);
        if (YFListUtils.isEmpty(this.c.getSdkSupplierList()) || YFListUtils.isEmpty(this.g)) {
            if (this.h == null || !b("startParallel has bidding", true)) {
                com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, " runParallel, suppliers or parallel is empty, return.");
                j jVar2 = this.b;
                if (jVar2 != null) {
                    YFAdError err = YFAdError.parseErr(YFAdError.ERROR_DATA_NULL);
                    d dVar = (d) jVar2;
                    if (dVar.g != null) {
                        dVar.g = err;
                    }
                    ((d) this.b).m();
                    return;
                }
                return;
            }
            return;
        }
        if (this.c.isTotalTimeout()) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, "runParallel is timeout, return.");
            return;
        }
        this.k.set(((SdkSupplier) this.g.get(0)).index);
        int size = this.g.size();
        this.p++;
        YFLog.high(this.f9677a + " runParallel batch " + this.p + " size = " + size + " , start");
        for (SdkSupplier sdkSupplier2 : this.g) {
            this.c.removeTopSdkSupplier();
            if (sdkSupplier2.isFromCache()) {
                BaseChanelAdapter baseChanelAdapterA = com.yfanads.android.db.d.a.f9643a.a(sdkSupplier2.getAdId());
                if (baseChanelAdapterA != null && sdkSupplier2.isFromCache()) {
                    SdkSupplier sDKSupplier = baseChanelAdapterA.getSDKSupplier();
                    sDKSupplier.setFromCache(true);
                    YFLog.high(this.f9677a + " parallel hit cache, show " + baseChanelAdapterA.tag + " , " + sDKSupplier);
                    j jVar3 = this.b;
                    if (jVar3 != null) {
                        com.yfanads.android.core.c.b bVar = ((d) jVar3).o;
                        baseChanelAdapterA.setAdsSpotListener(bVar != null ? bVar.a() : null);
                    } else {
                        com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, " parallel hit cache, but activity is null");
                    }
                    baseChanelAdapterA.setUnionSdkResultListener(this);
                    baseChanelAdapterA.handleSucceed(false);
                    com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "adapter start load cache ");
                }
            }
            int adnIdValue = sdkSupplier2.getAdnIdValue();
            YFLog.high(adnIdValue + " runParallel batch " + this.p + " size = " + size + " , start ");
            List<BaseChanelAdapter> list = this.d.get(Integer.valueOf(adnIdValue));
            BaseChanelAdapter baseChanelAdapterA2 = a(sdkSupplier2, adnIdValue);
            if (!(baseChanelAdapterA2 instanceof com.yfanads.android.core.j) && list != null) {
                list.add(baseChanelAdapterA2);
                this.d.put(Integer.valueOf(adnIdValue), list);
            }
            baseChanelAdapterA2.setUnionSdkResultListener(this);
            com.yfanads.android.core.g.a(new StringBuilder("runParallel load ").append(sdkSupplier2.index).append("|hs_").append(baseChanelAdapterA2.hashCode()).append(" req:"), this.e);
            j jVar4 = this.b;
            baseChanelAdapterA2.loadOnly(jVar4 != null ? ((d) jVar4).f() : null);
        }
        YFLog.high(this.f9677a + " runParallel batch " + this.p + " size = " + size + " , end");
        com.yfanads.android.core.g.a(new StringBuilder("runParallel end in ").append(this.r).append(" t_").append(System.currentTimeMillis() - this.q).append(" req:"), this.e);
    }

    public final boolean b(String str, boolean z) {
        if (this.k.get() == -99) {
            return true;
        }
        BaseChanelAdapter baseChanelAdapter = this.h;
        return a(str, (baseChanelAdapter != null && (this.i == null || baseChanelAdapter.getEcpm() > this.i.getEcpm())) ? this.h : this.i, z);
    }

    public final BaseChanelAdapter c() {
        BaseChanelAdapter baseChanelAdapter = null;
        if (YFListUtils.isEmpty(this.j)) {
            return null;
        }
        for (BaseChanelAdapter baseChanelAdapter2 : this.j) {
            if (baseChanelAdapter2.getSDKSupplier() != null && (baseChanelAdapter == null || baseChanelAdapter.getSDKSupplier().ecpm < baseChanelAdapter2.getSDKSupplier().ecpm)) {
                baseChanelAdapter = baseChanelAdapter2;
            }
        }
        return baseChanelAdapter;
    }

    public final boolean e() {
        return this.s == this.f.size();
    }

    public final void f() {
        List<BaseChanelAdapter> list;
        if (this.c == null) {
            YFLog.error("runStrategy but mStrategyModel is null, return.");
            return;
        }
        this.q = System.currentTimeMillis();
        this.r = Thread.currentThread().getName();
        if (this.c.hasBiddingList()) {
            com.yfanads.android.core.g.a(new StringBuilder("runBidding start in ").append(this.r).append(" req:"), this.e);
            this.f.clear();
            this.s = 0;
            this.f.addAll(this.c.getBiddingList());
            YFLog.debug("saveBiddingData " + this.f);
            if (YFListUtils.isEmpty(this.f)) {
                com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, " runBidding, suppliers or parallel is empty, return.");
            } else {
                int size = this.f.size();
                YFLog.debug(this.f9677a + " runBidding size = " + size + " , start ");
                for (int i = 0; i < size; i++) {
                    SdkSupplier sdkSupplier = (SdkSupplier) this.f.get(i);
                    int adnIdValue = sdkSupplier.getAdnIdValue();
                    BaseChanelAdapter baseChanelAdapterA = a(sdkSupplier, adnIdValue);
                    if (!(baseChanelAdapterA instanceof com.yfanads.android.core.j) && (list = this.d.get(Integer.valueOf(adnIdValue))) != null) {
                        list.add(baseChanelAdapterA);
                        this.d.put(Integer.valueOf(adnIdValue), list);
                    }
                    baseChanelAdapterA.setUnionSdkResultListener(this);
                    com.yfanads.android.core.g.a(new StringBuilder("runBidding load ").append(sdkSupplier.index).append("|hs_").append(baseChanelAdapterA.hashCode()).append(" req:"), this.e);
                    j jVar = this.b;
                    baseChanelAdapterA.loadOnly(jVar != null ? ((d) jVar).f() : null);
                }
                YFLog.debug(this.f9677a + " runBidding size = " + size + " , end ");
                com.yfanads.android.core.g.a(new StringBuilder("runBidding end in ").append(this.r).append("|t_").append(System.currentTimeMillis() - this.q).append(" req:"), this.e);
            }
        }
        if (this.c.hasSdkSupplier()) {
            a("runStrategy");
        }
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultFailed(BaseChanelAdapter baseChanelAdapter, YFAdError yFAdError) {
        BaseChanelAdapter baseChanelAdapterC;
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        com.yfanads.android.core.g.a(new StringBuilder("runBPStrategy load fail ").append(sDKSupplier).append("|t_").append(baseChanelAdapter.getLogTime()).append("|ec_").append(yFAdError.code).append("|em_").append(yFAdError.msg).append(" req:"), this.e);
        if (sDKSupplier == null) {
            return;
        }
        if (this.c.isTotalTimeout()) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, "onBPResultFailed is timeout, return.");
            return;
        }
        if (sDKSupplier.isBidding()) {
            this.s++;
            if (e()) {
                if (this.i != null) {
                    a("onBiddingFail has maxParallel show", b(this.f9677a + " onBiddingFail bidding over has max parallel", true));
                    return;
                } else if (this.t == this.g.size()) {
                    a("onBiddingFail runParallel next batch ", "onBiddingFail req:" + this.e);
                    return;
                } else {
                    if (d()) {
                        a("onBiddingFail is biddingHigh show", b(this.f9677a + " onBiddingFail bidding higher other parallel", true));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.t++;
        this.n.add(Integer.valueOf(sDKSupplier.index));
        if (this.t == this.g.size()) {
            if (this.i == null && (!YFListUtils.isEmpty(this.j)) && (baseChanelAdapterC = c()) != null) {
                this.i = baseChanelAdapterC;
            }
            if (e()) {
                if (this.i == null) {
                    a("runParallel parallel next batch ", "onParallelFail req:" + this.e);
                    return;
                } else {
                    a("onParallelFail has max parallel show", b(this.f9677a + " onParallelFail bidding over and has max parallel", true));
                    return;
                }
            }
            return;
        }
        if (sDKSupplier.index != this.k.get()) {
            if (e() && d()) {
                b(this.f9677a + " onParallelFail bidding higher other parallel", true);
                return;
            }
            return;
        }
        for (SdkSupplier sdkSupplier : this.g) {
            if (sdkSupplier != null && !this.n.contains(Integer.valueOf(sdkSupplier.index))) {
                int i = sdkSupplier.index;
                this.k.set(i);
                BaseChanelAdapter baseChanelAdapter2 = (BaseChanelAdapter) this.o.get(Integer.valueOf(i));
                if (baseChanelAdapter2 != null && this.i == null) {
                    this.i = baseChanelAdapter2;
                }
                YFLog.high(this.f9677a + " findShowAdapterIndex update showIndex " + sdkSupplier.index);
                break;
            }
        }
        if (!e() || this.i == null) {
            return;
        }
        b(this.f9677a + " onParallelFail bidding over and index " + sDKSupplier.index + " fail", true);
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultSuccess(BaseChanelAdapter baseChanelAdapter) {
        BaseChanelAdapter baseChanelAdapterC;
        boolean zIsTotalTimeout = this.c.isTotalTimeout();
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        com.yfanads.android.core.g.a(new StringBuilder("runBPStrategy load success ").append(sDKSupplier).append("|t_").append(baseChanelAdapter.getLogTime()).append(" req:"), this.e);
        if (sDKSupplier == null) {
            return;
        }
        if (zIsTotalTimeout) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, "onBPResultSuccess is timeout, return.");
            return;
        }
        if (sDKSupplier.isBidding()) {
            this.s++;
            if (sDKSupplier.isOverPrice()) {
                boolean z = com.yfanads.android.upload.b.e;
                com.yfanads.android.upload.b.a.f9685a.a(sDKSupplier, YFAdsConst.ReportETypeValue.BIDDING_HIGHER.getValue(), "");
                BaseChanelAdapter baseChanelAdapter2 = this.h;
                if (baseChanelAdapter2 == null || sDKSupplier.ecpm > baseChanelAdapter2.getEcpm()) {
                    this.h = baseChanelAdapter;
                }
            } else {
                com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, " findMaxBidding low ecpm, return.");
                boolean z2 = com.yfanads.android.upload.b.e;
                com.yfanads.android.upload.b.a.f9685a.a(sDKSupplier, YFAdsConst.ReportETypeValue.BIDDING_LOWER.getValue(), "");
            }
            if (e()) {
                if (this.i != null) {
                    a("onBiddingSuccess has maxParallel show", b(this.f9677a + " onBiddingSuccess bidding over and has max parallel.", true));
                    return;
                } else if (this.t == this.g.size()) {
                    a(" onBiddingFail runParallel bidding next batch ", "onBiddingSuccess req:" + this.e);
                    return;
                } else {
                    if (d()) {
                        a("onBiddingSuccess is biddingHigh show", b(this.f9677a + " onBiddingSuccess bidding higher other parallel.", true));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.j.add(baseChanelAdapter);
        this.o.put(Integer.valueOf(sDKSupplier.index), baseChanelAdapter);
        this.t++;
        if (sDKSupplier.index == this.k.get()) {
            this.i = baseChanelAdapter;
            if (e()) {
                String str = this.f9677a + " onParallelSuccess show index " + sDKSupplier.index + ", and bidding over.";
                BaseChanelAdapter baseChanelAdapter3 = this.h;
                a(str, (baseChanelAdapter3 != null && (this.i == null || baseChanelAdapter3.getEcpm() > this.i.getEcpm())) ? this.h : this.i, true);
            }
        }
        if (this.t != this.g.size()) {
            if (e() && d()) {
                b(this.f9677a + " onParallelSuccess bidding higher other parallel", true);
                return;
            }
            return;
        }
        if (this.i == null && (!YFListUtils.isEmpty(this.j)) && (baseChanelAdapterC = c()) != null) {
            this.i = baseChanelAdapterC;
        }
        if (e()) {
            a("onParallelSuccess call pb over", b(this.f9677a + " onParallelSuccess call parallel and bidding both over", true));
        }
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onTimeoutSuccess(BaseChanelAdapter baseChanelAdapter) {
        YFLog.debug(this.f9677a + "onTimeoutSuccess " + baseChanelAdapter);
    }

    public final boolean d() {
        BaseChanelAdapter baseChanelAdapter = this.h;
        if (baseChanelAdapter == null) {
            return false;
        }
        long ecpm = baseChanelAdapter.getEcpm();
        for (SdkSupplier sdkSupplier : this.g) {
            if (!this.n.contains(Integer.valueOf(sdkSupplier.index))) {
                BaseChanelAdapter baseChanelAdapter2 = (BaseChanelAdapter) this.o.get(Integer.valueOf(sdkSupplier.index));
                if (baseChanelAdapter2 != null) {
                    if (baseChanelAdapter2.getEcpm() > ecpm) {
                        return false;
                    }
                } else if (sdkSupplier.ecpm > ecpm) {
                    return false;
                }
            }
        }
        return true;
    }

    public final BaseChanelAdapter a(SdkSupplier sdkSupplier, int i) {
        try {
            j jVar = this.b;
            if (jVar == null) {
                YFLog.error(i + " strategyListener is null");
                return new com.yfanads.android.core.j(sdkSupplier);
            }
            BaseChanelAdapter baseChanelAdapterA = ((d) jVar).a(Integer.valueOf(i));
            if (baseChanelAdapterA == null) {
                YFLog.error(i + " adapter is null");
                return new com.yfanads.android.core.j(sdkSupplier);
            }
            StrategyModel strategyModel = this.c;
            if (strategyModel != null) {
                sdkSupplier.setCacheTimeout(strategyModel.getCacheTimeout());
                sdkSupplier.setCType(this.c.getCType());
            }
            sdkSupplier.setWaterfallTime();
            baseChanelAdapterA.setSDKSupplier(sdkSupplier);
            return baseChanelAdapterA;
        } catch (Exception e) {
            e.printStackTrace();
            return new com.yfanads.android.core.j(sdkSupplier);
        }
    }

    @Override // com.yfanads.android.strategy.a
    public final boolean a() {
        BaseChanelAdapter baseChanelAdapterC;
        if (this.i == null && (baseChanelAdapterC = c()) != null) {
            this.i = baseChanelAdapterC;
        }
        if (this.h == null && this.i == null) {
            return false;
        }
        return b(this.f9677a + "checkStrategy time out", false);
    }

    public final void a(String str, String str2) {
        if (this.k.get() == -99) {
            YFLog.high("checkNextParallel has show, return.");
            return;
        }
        if (this.c.isSdkSupplierEmpty()) {
            if (this.h == null || !b("checkNextParallel has bidding", true)) {
                this.g.clear();
                this.j.clear();
                this.o.clear();
                this.n.clear();
                this.t = 0;
                j jVar = this.b;
                if (jVar != null) {
                    YFAdError err = YFAdError.parseErr(YFAdError.ERROR_DATA_NULL);
                    d dVar = (d) jVar;
                    if (dVar.g != null) {
                        dVar.g = err;
                    }
                    ((d) this.b).m();
                    return;
                }
                return;
            }
            return;
        }
        YFLog.traceDebug(str);
        this.q = System.currentTimeMillis();
        a(str2);
    }

    public final void a(String str, boolean z) {
        if (this.m || !z) {
            return;
        }
        if (this.t == this.g.size() && !YFListUtils.isEmpty(this.j)) {
            YFLog.high(str + ", start add cache " + this.j.size());
            StrategyModel strategyModel = this.c;
            int cacheMax = strategyModel != null ? strategyModel.getCacheMax() : 0;
            if (cacheMax <= 0) {
                YFLog.high(str + " addToCache fail, It's cacheMax " + cacheMax);
                this.m = true;
                return;
            }
            for (BaseChanelAdapter baseChanelAdapter : this.j) {
                SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
                if (sDKSupplier != null && (TextUtils.isEmpty(this.l) || !this.l.equals(sDKSupplier.getPotId()))) {
                    if (baseChanelAdapter.isSupportCache() && !baseChanelAdapter.isBidding()) {
                        a(baseChanelAdapter, baseChanelAdapter.getSDKSupplier());
                    }
                }
            }
            this.m = true;
            return;
        }
        YFLog.high(str.concat("ps is not over, or not success load, return. "));
    }

    public final boolean a(String str, BaseChanelAdapter baseChanelAdapter, boolean z) {
        j jVar;
        if (baseChanelAdapter == null) {
            YFLog.error("showChannelAdapter but adapter is null.");
            return false;
        }
        if (z && (jVar = this.b) != null) {
            ((d) jVar).c();
        }
        YFLog.high(str);
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        YFLog.traceDebug("runBParallel find " + sDKSupplier + "|t_" + (System.currentTimeMillis() - this.q) + " req:" + this.e);
        String potId = sDKSupplier.getPotId();
        this.k.set(-99);
        this.l = potId;
        j jVar2 = this.b;
        if (jVar2 != null) {
            ((d) jVar2).a(baseChanelAdapter, sDKSupplier);
        }
        baseChanelAdapter.reportSdk(YFAdsConst.ReportETypeValue.FLOW_PADDING.getValue());
        int value = YFAdsConst.ReportETypeValue.FLOW_PADDING_RT.getValue();
        if (InitUtils.isRTReport(value)) {
            baseChanelAdapter.reportSdk(value, true);
        }
        return true;
    }
}
