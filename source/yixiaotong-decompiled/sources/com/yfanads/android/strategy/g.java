package com.yfanads.android.strategy;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.android.callback.UnionSdkResultListener;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.libs.utils.NamedThreadFactory;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CrossBPStrategyControl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class g extends a implements UnionSdkResultListener {
    public static final int z = Runtime.getRuntime().availableProcessors();
    public final CopyOnWriteArrayList f;
    public final CopyOnWriteArrayList g;
    public BaseChanelAdapter h;
    public BaseChanelAdapter i;
    public final CopyOnWriteArrayList j;
    public final CopyOnWriteArrayList k;
    public final AtomicInteger l;
    public String m;
    public boolean n;
    public final CopyOnWriteArraySet o;
    public final ConcurrentHashMap p;
    public long q;
    public String r;
    public int s;
    public ThreadPoolExecutor t;
    public final AtomicInteger u;
    public final AtomicBoolean v;
    public final AtomicBoolean w;
    public final AtomicBoolean x;
    public final int y;

    public g(String str, StrategyModel strategyModel, ConcurrentHashMap concurrentHashMap, j jVar, String str2) {
        super(str, strategyModel, concurrentHashMap, jVar, str2);
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        this.l = new AtomicInteger(0);
        this.o = new CopyOnWriteArraySet();
        this.p = new ConcurrentHashMap();
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.u = new AtomicInteger(0);
        this.v = new AtomicBoolean(false);
        this.y = strategyModel.getParallelCnt();
    }

    public final boolean a(String str, SdkSupplier sdkSupplier) {
        BaseChanelAdapter baseChanelAdapterA = com.yfanads.android.db.d.a.f9643a.a(sdkSupplier.getAdId());
        if (baseChanelAdapterA != null && sdkSupplier.isFromCache()) {
            SdkSupplier sDKSupplier = baseChanelAdapterA.getSDKSupplier();
            sDKSupplier.setFromCache(true);
            YFLog.high("CrossBPStrategyControl " + this.f9677a + PPSLabelView.Code + str + " hit [cache], show " + baseChanelAdapterA.tag + " , " + sDKSupplier);
            j jVar = this.b;
            if (jVar != null) {
                com.yfanads.android.core.c.b bVar = ((d) jVar).o;
                baseChanelAdapterA.setAdsSpotListener(bVar == null ? null : bVar.a());
                if (sDKSupplier.isTimeOut()) {
                    YFLog.debug("CrossBPStrategyControl " + this.f9677a + PPSLabelView.Code + str + " hit [cache], but is timeout, change status to success.");
                    sDKSupplier.setAdStatus(1);
                }
                baseChanelAdapterA.resetCallBack();
                baseChanelAdapterA.setUnionSdkResultListener(this);
                baseChanelAdapterA.handleSucceed(false);
                return true;
            }
            YFLog.error("CrossBPStrategyControl " + this.f9677a + PPSLabelView.Code + str + " hit [cache], but strategyListener is null");
        }
        return false;
    }

    public final boolean b(String str, boolean z2) {
        if (!this.v.get()) {
            return a(str, h() ? this.h : this.i, z2);
        }
        com.yfanads.android.core.d.a(new StringBuilder("CrossBPStrategyControl "), this.f9677a, " maxAdapterToShow: already completed");
        return true;
    }

    public final BaseChanelAdapter c() {
        BaseChanelAdapter baseChanelAdapter = null;
        if (YFListUtils.isEmpty(this.j)) {
            return null;
        }
        long j = Long.MIN_VALUE;
        for (BaseChanelAdapter baseChanelAdapter2 : this.j) {
            SdkSupplier sDKSupplier = baseChanelAdapter2.getSDKSupplier();
            if (sDKSupplier != null) {
                long j2 = sDKSupplier.ecpm;
                if (j2 > j) {
                    baseChanelAdapter = baseChanelAdapter2;
                    j = j2;
                }
            }
        }
        return baseChanelAdapter;
    }

    public final void d() {
        int i;
        do {
            try {
                i = this.u.get();
                if (i < this.g.size() && !this.w.get() && !this.v.get()) {
                }
                YFLog.debug("CrossBPStrategyControl " + this.f9677a + " idx  " + i + " ,mParallelList.size() " + this.g.size() + " ,isCompleted " + this.v.get() + " ,isisParallelCompleted " + this.w.get() + " return.");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } while (!this.u.compareAndSet(i, i + 1));
        SdkSupplier sdkSupplier = (SdkSupplier) this.g.get(i);
        BaseChanelAdapter baseChanelAdapter = this.h;
        if (baseChanelAdapter != null && baseChanelAdapter.getEcpm() >= sdkSupplier.ecpm) {
            this.x.set(true);
            YFLog.debug("CrossBPStrategyControl " + this.f9677a + " idx  " + i + " ,mParallelList.size() " + this.g.size() + " ,maxBiddingAdapter.p_" + this.h.getEcpm() + " ,supplier.p_" + sdkSupplier.ecpm + " return.");
            return;
        }
        if (sdkSupplier.isFromCache() && a("parallel", sdkSupplier)) {
            YFLog.high("CrossBPStrategyControl " + this.f9677a + " adapter load parallel with [cache] " + sdkSupplier);
            return;
        }
        int adnIdValue = sdkSupplier.getAdnIdValue();
        List<BaseChanelAdapter> list = this.d.get(Integer.valueOf(adnIdValue));
        BaseChanelAdapter baseChanelAdapterA = a(sdkSupplier, adnIdValue);
        if (!(baseChanelAdapterA instanceof com.yfanads.android.core.j) && list != null) {
            list.add(baseChanelAdapterA);
            this.d.put(Integer.valueOf(adnIdValue), list);
        }
        baseChanelAdapterA.setUnionSdkResultListener(this);
        YFLog.traceDebug("CrossBPStrategyControl  runParallel load supplier " + sdkSupplier + "|hs_" + baseChanelAdapterA.hashCode() + " req:" + this.e);
        j jVar = this.b;
        baseChanelAdapterA.loadOnly(jVar != null ? ((d) jVar).f() : null);
    }

    public final boolean f() {
        return this.s == this.f.size();
    }

    public final boolean g() {
        YFLog.debug("CrossBPStrategyControl isPSOver " + this.l.get() + " mParallelList.size() " + this.g.size() + " failList.size() " + this.o.size() + " pSucLoad.size() " + this.j.size());
        return this.j.size() + this.o.size() >= this.g.size();
    }

    public final void i() {
        List<BaseChanelAdapter> list;
        if (this.c == null) {
            YFLog.error("CrossBPStrategyControl  runStrategy but mStrategyModel is null, return.");
            return;
        }
        this.q = System.currentTimeMillis();
        this.r = Thread.currentThread().getName();
        if (this.c.hasBiddingList()) {
            com.yfanads.android.core.g.a(new StringBuilder("CrossBPStrategyControl runBidding start in ").append(this.r).append(" req:"), this.e);
            this.f.clear();
            this.k.clear();
            this.s = 0;
            this.f.addAll(this.c.getBiddingList());
            if (YFListUtils.isEmpty(this.f)) {
                com.yfanads.android.core.h.a(new StringBuilder("CrossBPStrategyControl "), this.f9677a, " runBidding, suppliers or parallel is empty, return.");
            } else {
                YFLog.debug("CrossBPStrategyControl " + this.f9677a + " runBidding size = " + this.f.size() + " , start ");
                for (SdkSupplier sdkSupplier : this.f) {
                    try {
                        int adnIdValue = sdkSupplier.getAdnIdValue();
                        BaseChanelAdapter baseChanelAdapterA = a(sdkSupplier, adnIdValue);
                        if (sdkSupplier.isFromCache() && a("bidding", sdkSupplier)) {
                            YFLog.high("CrossBPStrategyControl " + this.f9677a + " adapter load bidding with [cache] " + sdkSupplier);
                        } else {
                            if (!(baseChanelAdapterA instanceof com.yfanads.android.core.j) && (list = this.d.get(Integer.valueOf(adnIdValue))) != null) {
                                list.add(baseChanelAdapterA);
                                this.d.put(Integer.valueOf(adnIdValue), list);
                            }
                            baseChanelAdapterA.setUnionSdkResultListener(this);
                            YFLog.traceDebug("CrossBPStrategyControl runBidding load " + sdkSupplier + "|hs_" + baseChanelAdapterA.hashCode() + " req:" + this.e);
                            j jVar = this.b;
                            baseChanelAdapterA.loadOnly(jVar != null ? ((d) jVar).f() : null);
                        }
                    } catch (Exception e) {
                        com.yfanads.android.core.f.a(e, new StringBuilder("CrossBPStrategyControl handleBiddingRequest error: "));
                    }
                }
            }
        }
        if (this.c.hasSdkSupplier()) {
            j();
        } else {
            this.w.set(true);
            YFLog.debug("CrossBPStrategyControl  runStrategy but sdkSupplier is empty, return.");
        }
    }

    public final void j() {
        com.yfanads.android.core.g.a(new StringBuilder("CrossBPStrategyControl  runParallel start in thread:").append(this.r).append(" req:"), this.e);
        this.g.clear();
        this.j.clear();
        this.p.clear();
        this.o.clear();
        this.u.set(0);
        this.l.set(0);
        this.g.addAll(this.c.getSdkSupplierList());
        if (YFListUtils.isEmpty(this.c.getSdkSupplierList()) || YFListUtils.isEmpty(this.g)) {
            if (this.h == null || !b("startParallel has bidding", true)) {
                com.yfanads.android.core.h.a(new StringBuilder("CrossBPStrategyControl "), this.f9677a, " runParallel, suppliers or parallel is empty, return.");
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
        if (this.c.isTotalTimeout()) {
            com.yfanads.android.core.h.a(new StringBuilder("CrossBPStrategyControl "), this.f9677a, "runParallel is timeout, return.");
            return;
        }
        int i = ((SdkSupplier) this.g.get(0)).position;
        this.l.set(i);
        YFLog.debug("CrossBPStrategyControl " + this.f9677a + " setMaxEcpmShowIndex " + i);
        YFLog.high("CrossBPStrategyControl " + this.f9677a + " runParallel size = " + this.g.size() + " , start");
        try {
            ThreadPoolExecutor threadPoolExecutor = this.t;
            if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                this.t.shutdownNow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int iMin = Math.min(this.y + 2, z * 2);
        int iMax = Math.max(iMin + 5, 20);
        this.t = new ThreadPoolExecutor(iMin, iMax, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(16), new NamedThreadFactory("Waterfall"), new ThreadPoolExecutor.CallerRunsPolicy());
        YFLog.debug("CrossBPStrategyControl Waterfall executor initialized: core=" + iMin + ", max=" + iMax);
        for (int i2 = 0; i2 < Math.min(this.y, this.g.size()); i2++) {
            this.t.execute(new g$$ExternalSyntheticLambda0(this));
        }
    }

    public final void k() {
        try {
            int i = this.u.get();
            if (a(i < this.g.size() ? (SdkSupplier) this.g.get(i) : null)) {
                return;
            }
            YFLog.debug("CrossBPStrategyControl onParallelFail 补位. currentIndex " + this.u);
            this.t.execute(new g$$ExternalSyntheticLambda0(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultFailed(BaseChanelAdapter baseChanelAdapter, YFAdError yFAdError) {
        BaseChanelAdapter baseChanelAdapterC;
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        com.yfanads.android.core.g.a(new StringBuilder("CrossBPStrategyControl runBPStrategy load fail supplier ").append(sDKSupplier).append("|t_").append(baseChanelAdapter.getLogTime()).append("|").append(yFAdError.toString()).append(" req:"), this.e);
        if (sDKSupplier == null) {
            return;
        }
        if (this.c.isTotalTimeout()) {
            com.yfanads.android.core.h.a(new StringBuilder("CrossBPStrategyControl "), this.f9677a, "onBPResultFailed is timeout, return.");
            return;
        }
        if (sDKSupplier.isBidding()) {
            this.s++;
            YFLog.debug("CrossBPStrategyControl onBiddingFail: " + this.f9677a + " count=" + this.s + "/" + this.f.size() + " supplier " + sDKSupplier);
            if (f()) {
                if (this.i != null) {
                    a("onBiddingFail:hasMaxParallel", b(this.f9677a + " onBiddingFail:有最高并行广告", true));
                    return;
                }
                if (e()) {
                    a("onBiddingFail:isBiddingHigh", b(this.f9677a + " onBiddingFail:竞价广告最高", true));
                    return;
                }
                if (!this.c.hasSdkSupplier() && !this.w.get()) {
                    this.w.set(true);
                }
                YFLog.warn("CrossBPStrategyControl onBiddingFail: " + this.f9677a + " 无可展示广告 isParallelCompleted " + this.w.get());
                if (this.w.get()) {
                    a("onBiddingFail:bd&wf all over.", b(this.f9677a + " onBiddingFail:无可展示广告", true));
                    return;
                }
                return;
            }
            return;
        }
        if (this.w.get()) {
            YFLog.debug("CrossBPStrategyControl onParallelFail hasParallelCompleted, return.");
            return;
        }
        if (this.v.get()) {
            YFLog.debug("CrossBPStrategyControl onParallelFail hasCompleted, return.");
            return;
        }
        int i = sDKSupplier.position;
        this.o.add(Integer.valueOf(i));
        if (i == this.l.get()) {
            this.l.getAndIncrement();
            YFLog.debug("CrossBPStrategyControl onParallelFail. -- record new maxEcpmIndex=" + this.l.get() + " fail position " + i + " failList " + this.o.size());
        }
        if (!this.g.isEmpty() && !this.o.isEmpty()) {
            int i2 = this.l.get();
            CopyOnWriteArrayList copyOnWriteArrayList = this.g;
            int i3 = ((SdkSupplier) copyOnWriteArrayList.get(copyOnWriteArrayList.size() - 1)).position;
            YFLog.debug("CrossBPStrategyControl onParallelFail. update before maxEcpmIndex=" + i2 + " lastPos " + i3 + " failList " + this.o.size());
            while (i2 < i3 && this.o.contains(Integer.valueOf(i2))) {
                i2++;
            }
            this.l.set(i2);
            YFLog.debug("CrossBPStrategyControl onParallelFail. update after maxEcpmIndex=" + i2);
        }
        if (a("onParallelFail.successAds maxEcpmIndex=", " onParallelFail show index ", (SdkSupplier) null)) {
            YFLog.debug("CrossBPStrategyControl onParallelFail. -- hasFindCBPStrategyMax=" + this.l.get());
            return;
        }
        if (g()) {
            YFLog.debug("CrossBPStrategyControl onParallelFail. maxEcpmIndex=" + this.l.get() + " all ps over ");
            this.w.set(true);
            if (this.i == null && (!YFListUtils.isEmpty(this.j)) && (baseChanelAdapterC = c()) != null) {
                this.i = baseChanelAdapterC;
            }
            if (f()) {
                a("onParallelFail has max parallel show", b(this.f9677a + " onParallelFail bidding over and has max parallel", true));
                return;
            }
            return;
        }
        if (sDKSupplier.position == this.l.get()) {
            YFLog.debug("CrossBPStrategyControl onParallelFail. maxEcpmIndex=" + this.l.get() + " supplier.position == maxEcpmIndex.get() ");
            boolean z2 = this.i == null;
            Iterator it = this.g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    YFLog.warn("CrossBPStrategyControl " + this.f9677a + " findShowAdapterIndex: all positions failed");
                    break;
                }
                SdkSupplier sdkSupplier = (SdkSupplier) it.next();
                if (sdkSupplier != null) {
                    int i4 = sdkSupplier.position;
                    if (!this.o.contains(Integer.valueOf(i4))) {
                        this.l.set(i4);
                        YFLog.debug("CrossBPStrategyControl " + this.f9677a + " setMaxEcpmShowIndex " + i4);
                        BaseChanelAdapter baseChanelAdapter2 = (BaseChanelAdapter) this.p.get(Integer.valueOf(i4));
                        if (baseChanelAdapter2 != null && z2) {
                            this.i = baseChanelAdapter2;
                        }
                        YFLog.high("CrossBPStrategyControl " + this.f9677a + " findShowAdapterIndex update showIndex " + i4);
                        break;
                    }
                }
            }
            if (f() && this.i != null) {
                a(" onParallelFail bidding over and index " + sDKSupplier.index + " fail", b(this.f9677a + " onParallelFail bidding over and index " + sDKSupplier.index + " fail", true));
            }
        } else if (f() && e()) {
            a(this.f9677a + " onParallelFail bidding higher other parallel", b(this.f9677a + " onParallelFail bidding higher other parallel", true));
        }
        if (this.x.get()) {
            YFLog.error("CrossBPStrategyControl onParallelFail. - isBiddingIntercept, return.");
        } else {
            k();
        }
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultSuccess(BaseChanelAdapter baseChanelAdapter) {
        BaseChanelAdapter baseChanelAdapterC;
        if (baseChanelAdapter == null) {
            YFLog.error("CrossBPStrategyControl onCBPResultSuccess called with null adapter");
            return;
        }
        boolean zIsTotalTimeout = this.c.isTotalTimeout();
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        com.yfanads.android.core.g.a(new StringBuilder("CrossBPStrategyControl runBPStrategy load success supplier ").append(sDKSupplier).append("|t_").append(baseChanelAdapter.getLogTime()).append(" req:"), this.e);
        if (sDKSupplier == null) {
            return;
        }
        if (zIsTotalTimeout) {
            com.yfanads.android.core.h.a(new StringBuilder("CrossBPStrategyControl "), this.f9677a, "onBPResultSuccess is timeout, return.");
            return;
        }
        if (sDKSupplier.isBidding()) {
            this.s++;
            if (sDKSupplier.isOverPrice()) {
                boolean z2 = com.yfanads.android.upload.b.e;
                com.yfanads.android.upload.b.a.f9685a.a(sDKSupplier, YFAdsConst.ReportETypeValue.BIDDING_HIGHER.getValue(), "");
                BaseChanelAdapter baseChanelAdapter2 = this.h;
                if (baseChanelAdapter2 == null || sDKSupplier.ecpm > baseChanelAdapter2.getEcpm()) {
                    this.h = baseChanelAdapter;
                }
            } else {
                com.yfanads.android.core.e.a(new StringBuilder("CrossBPStrategyControl "), this.f9677a, " Bidding ecpm is too low, skip.");
                boolean z3 = com.yfanads.android.upload.b.e;
                com.yfanads.android.upload.b.a.f9685a.a(sDKSupplier, YFAdsConst.ReportETypeValue.BIDDING_LOWER.getValue(), "");
            }
            this.k.add(baseChanelAdapter);
            YFLog.debug("CrossBPStrategyControl onBiddingSuccess: " + this.f9677a + " count=" + this.s + "/" + this.f.size() + " supplier " + sDKSupplier);
            if (f()) {
                if (this.i != null) {
                    a("onBiddingSuccess has maxParallel show", b(this.f9677a + " onBiddingSuccess bidding over and has max parallel.", true));
                    return;
                } else if (e()) {
                    a("onBiddingSuccess is biddingHigh show", b(this.f9677a + " onBiddingSuccess bidding higher other parallel.", true));
                    return;
                } else {
                    if (this.w.get()) {
                        a("onBiddingSuccess bidding over and no maxParallel show", b(this.f9677a + " onBiddingSuccess bidding over and no max parallel.", true));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.w.get()) {
            YFLog.debug("CrossBPStrategyControl onParallelSuccess hasParallelCompleted, return.");
        } else {
            if (!this.v.get()) {
                if (a("onParallelSuccess.successAds maxEcpmIndex=", " onParallelSuccess show index - ", sDKSupplier)) {
                    YFLog.error("CrossBPStrategyControl onParallelSuccess checkSuccessListForCurrentIndex, return.");
                    return;
                }
                if (sDKSupplier.position == this.l.get()) {
                    this.w.set(true);
                }
                if (this.w.get()) {
                    this.j.add(baseChanelAdapter);
                    this.p.put(Integer.valueOf(sDKSupplier.position), baseChanelAdapter);
                    this.i = baseChanelAdapter;
                    if (f()) {
                        a(this.f9677a + " onParallelSuccess show index -- " + sDKSupplier.index + ", and bidding over.", a(this.f9677a + " onParallelSuccess show index -- " + sDKSupplier.index + ", and bidding over.", h() ? this.h : this.i, true));
                    }
                } else {
                    YFLog.debug("CrossBPStrategyControl isHighPrioritySuccess maxEcpmIndex=" + this.l.get() + " supplier.index " + sDKSupplier.index);
                    if (sDKSupplier.index > this.l.get()) {
                        YFLog.debug("CrossBPStrategyControl onParallelSuccess maxEcpmIndex=" + this.l.get() + ",supplier.index " + sDKSupplier.index + " adapter " + baseChanelAdapter + " 存到已成功列表里.");
                        this.j.add(baseChanelAdapter);
                        this.p.put(Integer.valueOf(sDKSupplier.position), baseChanelAdapter);
                    }
                }
                if (!g()) {
                    if (f() && e()) {
                        a("onParallelSuccess bidding higher other parallel", b(this.f9677a + " onParallelSuccess bidding higher other parallel", true));
                        return;
                    }
                    return;
                }
                if (this.i == null && (!YFListUtils.isEmpty(this.j)) && (baseChanelAdapterC = c()) != null) {
                    this.i = baseChanelAdapterC;
                }
                if (f()) {
                    a("onParallelSuccess call pb over", b(this.f9677a + " onParallelSuccess call parallel and bidding both over", true));
                    return;
                }
                return;
            }
            YFLog.debug("CrossBPStrategyControl onParallelSuccess hasCompleted, return.");
        }
        if (!TextUtils.isEmpty(this.m) && sDKSupplier.getPotId() != null && this.m.equals(sDKSupplier.getPotId())) {
            YFLog.debug("CrossBPStrategyControl onParallelSuccess add [cache] this channelAdapter is showPotId, return ");
            return;
        }
        StrategyModel strategyModel = this.c;
        int cacheMax = strategyModel != null ? strategyModel.getCacheMax() : 0;
        if (cacheMax > 0) {
            a(baseChanelAdapter, sDKSupplier);
        } else {
            YFLog.high("CrossBPStrategyControl onParallelSuccess [cache] addToCache " + this.f9677a + " addToCache fail, It's cacheMax " + cacheMax);
            this.n = true;
        }
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onTimeoutSuccess(BaseChanelAdapter baseChanelAdapter) {
        YFLog.debug(this.f9677a + "[cache] onTimeoutSuccess " + baseChanelAdapter);
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        if (!TextUtils.isEmpty(this.m) && this.m.equals(sDKSupplier.getPotId())) {
            com.yfanads.android.core.d.a(new StringBuilder("CrossBPStrategyControl [cache] onTimeoutSuccess "), this.f9677a, " this channelAdapter is showPotId, return ");
        } else if (!baseChanelAdapter.isSupportCache() || this.c.isTotalTimeout()) {
            YFLog.debug("CrossBPStrategyControl " + this.f9677a + "[cache] onTimeoutSuccess this channelAdapter is not support cache or isTotalTimeout:" + this.c.isTotalTimeout() + " ,return ");
        } else {
            a(baseChanelAdapter, sDKSupplier);
        }
    }

    public final boolean e() {
        BaseChanelAdapter baseChanelAdapter = this.h;
        if (baseChanelAdapter == null) {
            return false;
        }
        long ecpm = baseChanelAdapter.getEcpm();
        for (SdkSupplier sdkSupplier : this.g) {
            if (!this.o.contains(Integer.valueOf(sdkSupplier.position))) {
                long ecpm2 = sdkSupplier.ecpm;
                BaseChanelAdapter baseChanelAdapter2 = (BaseChanelAdapter) this.p.get(Integer.valueOf(sdkSupplier.position));
                if (baseChanelAdapter2 != null) {
                    ecpm2 = baseChanelAdapter2.getEcpm();
                }
                if (ecpm2 > ecpm) {
                    YFLog.debug("CrossBPStrategyControl isBiddingHigh: NOT HIGHEST");
                    return false;
                }
            }
        }
        YFLog.debug("CrossBPStrategyControl isBiddingHigh: HIGHEST");
        return true;
    }

    public final boolean h() {
        if (this.h == null) {
            return false;
        }
        if (this.i == null) {
            return true;
        }
        YFLog.debug("CrossBPStrategyControl isShowBidding bp_" + this.h.getEcpm() + " pp_" + this.i.getEcpm());
        return this.h.getEcpm() >= this.i.getEcpm();
    }

    public final BaseChanelAdapter a(SdkSupplier sdkSupplier, int i) {
        try {
            j jVar = this.b;
            if (jVar == null) {
                YFLog.error("CrossBPStrategyControl " + i + " strategyListener is null");
                return new com.yfanads.android.core.j(sdkSupplier);
            }
            BaseChanelAdapter baseChanelAdapterA = ((d) jVar).a(Integer.valueOf(i));
            if (baseChanelAdapterA == null) {
                YFLog.error("CrossBPStrategyControl " + i + " adapter is null");
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

    public final boolean a(String str, BaseChanelAdapter baseChanelAdapter, boolean z2) {
        com.yfanads.android.db.d dVar;
        SdkSupplier sdkSupplierA;
        BaseChanelAdapter baseChanelAdapterA;
        j jVar;
        if (!z2) {
            com.yfanads.android.db.d dVar2 = com.yfanads.android.db.d.a.f9643a;
            SdkSupplier sdkSupplierA2 = dVar2.a(this.e, this.c.getAdId());
            if (sdkSupplierA2 != null) {
                BaseChanelAdapter baseChanelAdapterA2 = dVar2.a(sdkSupplierA2.getAdId());
                if (baseChanelAdapterA2 == null) {
                    YFLog.debug("CrossBPStrategyControl Cached adapter is null for adId: " + sdkSupplierA2.getAdId());
                } else {
                    if (baseChanelAdapter == null || baseChanelAdapterA2.getEcpm() >= baseChanelAdapter.getEcpm()) {
                        baseChanelAdapterA2.resetCallBack();
                        YFLog.debug("CrossBPStrategyControl Using cached adapter with higher eCPM: " + baseChanelAdapterA2.getEcpm());
                        baseChanelAdapter = baseChanelAdapterA2;
                    }
                    SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
                    if (sDKSupplier != null && sDKSupplier.isFromCache() && sDKSupplier.isTimeOut()) {
                        YFLog.debug("CrossBPStrategyControl " + this.f9677a + " tryUseCachedAdapterIfBetter hit [cache], but is timeout, change status to success.");
                        sDKSupplier.setAdStatus(1);
                    }
                }
            }
        } else if (baseChanelAdapter != null && baseChanelAdapter.isBidding() && (sdkSupplierA = (dVar = com.yfanads.android.db.d.a.f9643a).a(this.e, this.c.getAdId())) != null && sdkSupplierA.isBidding() && (baseChanelAdapterA = dVar.a(sdkSupplierA.getAdId())) != null && baseChanelAdapterA.getEcpm() >= baseChanelAdapter.getEcpm()) {
            if (baseChanelAdapterA.getSDKSupplier().isTimeOut()) {
                baseChanelAdapterA.getSDKSupplier().setAdStatus(1);
            }
            baseChanelAdapterA.resetCallBack();
            YFLog.debug("CrossBPStrategyControl " + str + " showChannelAdapter use cache.");
            baseChanelAdapter = baseChanelAdapterA;
        }
        if (baseChanelAdapter == null) {
            YFLog.debug("CrossBPStrategyControl " + str + " showChannelAdapter but adapter is null.");
            j jVar2 = this.b;
            if (jVar2 != null) {
                YFAdError err = YFAdError.parseErr(YFAdError.ERROR_DATA_NULL);
                d dVar3 = (d) jVar2;
                if (dVar3.g != null) {
                    dVar3.g = err;
                }
                ((d) this.b).m();
            }
            YFLog.debug("CrossBPStrategyControl shutdown When the bidding&wf ends, terminate the thread");
            this.v.set(true);
            ThreadPoolExecutor threadPoolExecutor = this.t;
            if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                this.t.shutdownNow();
            }
            this.t = null;
            return false;
        }
        if (z2 && (jVar = this.b) != null) {
            ((d) jVar).c();
        }
        YFLog.high("CrossBPStrategyControl  thread:" + Thread.currentThread().getName() + PPSLabelView.Code + str);
        SdkSupplier sDKSupplier2 = baseChanelAdapter.getSDKSupplier();
        YFLog.traceDebug("CrossBPStrategyControl runBParallel find " + sDKSupplier2 + "|t_" + (System.currentTimeMillis() - this.q) + " req:" + this.e);
        this.m = sDKSupplier2.getPotId();
        j jVar3 = this.b;
        if (jVar3 != null) {
            ((d) jVar3).a(baseChanelAdapter, sDKSupplier2);
        }
        baseChanelAdapter.reportSdk(YFAdsConst.ReportETypeValue.FLOW_PADDING.getValue());
        int value = YFAdsConst.ReportETypeValue.FLOW_PADDING_RT.getValue();
        if (InitUtils.isRTReport(value)) {
            baseChanelAdapter.reportSdk(value, true);
        }
        YFLog.debug("CrossBPStrategyControl shutdown When the bidding&wf ends, terminate the thread");
        this.v.set(true);
        ThreadPoolExecutor threadPoolExecutor2 = this.t;
        if (threadPoolExecutor2 != null && !threadPoolExecutor2.isShutdown()) {
            this.t.shutdownNow();
        }
        this.t = null;
        return true;
    }

    public final boolean a(SdkSupplier sdkSupplier) {
        if (sdkSupplier == null) {
            YFLog.debug("CrossBPStrategyControl 跳过补位:shouldSkipReplacement: nextSupplier is null. 原因：没有更多的并行广告位可供加载.");
            return true;
        }
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            SdkSupplier sDKSupplier = ((BaseChanelAdapter) it.next()).getSDKSupplier();
            if (sDKSupplier != null && sDKSupplier.ecpm > sdkSupplier.ecpm) {
                YFLog.debug("CrossBPStrategyControl hasHigherEcpmInSuccessList: 发现更高 eCPM 广告, 当前广告 eCPM=" + sdkSupplier.ecpm + ", 已成功广告 eCPM=" + sDKSupplier.ecpm);
                YFLog.debug("CrossBPStrategyControl 跳过补位:shouldSkipReplacement: 已有更高eCPM广告. 原因：成功列表中存在比当前补位广告(" + sdkSupplier.ecpm + ")更高的eCPM值.");
                return true;
            }
        }
        BaseChanelAdapter baseChanelAdapter = this.h;
        if (baseChanelAdapter != null && baseChanelAdapter.getEcpm() >= sdkSupplier.ecpm) {
            YFLog.debug("CrossBPStrategyControl 跳过补位:shouldSkipReplacement: 高价Bidding拦截. 原因：当前Bidding的ecpm(" + this.h.getEcpm() + ") >= 下一个并行广告位ecpm(" + sdkSupplier.ecpm + ").");
            return true;
        }
        if (this.x.get()) {
            YFLog.debug("CrossBPStrategyControl 跳过补位:shouldSkipReplacement: Bidding已拦截补位请求. 原因：高优先级Bidding广告已经胜出.");
            return true;
        }
        if (this.w.get()) {
            YFLog.debug("CrossBPStrategyControl 跳过补位:shouldSkipReplacement: 并行流程已完成. 原因：最高ecpm广告位已经成功加载并展示.");
            return true;
        }
        if (this.v.get()) {
            YFLog.debug("CrossBPStrategyControl 跳过补位:shouldSkipReplacement: 策略已全部完成. 原因：竞价(Bidding)和瀑布流(WF)流程都已经结束.");
            return true;
        }
        if (this.u.get() < this.g.size()) {
            return false;
        }
        YFLog.debug("CrossBPStrategyControl 跳过补位:shouldSkipReplacement: currentIndex超出范围. 原因：当前索引(" + this.u.get() + ") >= 并行列表大小(" + this.g.size() + ").");
        return true;
    }

    public final boolean a(String str, String str2, SdkSupplier sdkSupplier) {
        int i = this.l.get();
        for (BaseChanelAdapter baseChanelAdapter : this.j) {
            SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
            if (sDKSupplier.position == i) {
                YFLog.debug(String.format("%s%s%d wf 竞价成功.", "CrossBPStrategyControl ", str, Integer.valueOf(i)));
                if (sDKSupplier.position == this.l.get()) {
                    this.w.set(true);
                }
                this.i = baseChanelAdapter;
                if (f()) {
                    Object[] objArr = new Object[3];
                    objArr[0] = this.f9677a;
                    objArr[1] = str2;
                    objArr[2] = Integer.valueOf(sdkSupplier != null ? sdkSupplier.index : -1);
                    String str3 = String.format("%s%s%d, and bidding over.", objArr);
                    a(str3, a(str3, h() ? this.h : this.i, true));
                }
                return true;
            }
        }
        return false;
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
        boolean zB = b(this.f9677a + "checkStrategy time out", false);
        a("checkStrategy totalTimeOut", zB);
        return zB;
    }

    public final void a(String str, CopyOnWriteArrayList copyOnWriteArrayList) {
        if (YFListUtils.isEmpty(copyOnWriteArrayList)) {
            return;
        }
        String strA = com.yfanads.android.db.e.a("CrossBPStrategyControl [cache] ", str);
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            BaseChanelAdapter baseChanelAdapter = (BaseChanelAdapter) it.next();
            SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
            if (sDKSupplier != null) {
                if (!TextUtils.isEmpty(this.m) && sDKSupplier.getPotId() != null && this.m.equals(sDKSupplier.getPotId())) {
                    YFLog.debug(strA + " this channelAdapter is showPotId, return ");
                } else if (baseChanelAdapter.isSupportCache()) {
                    a(baseChanelAdapter, sDKSupplier);
                } else {
                    YFLog.debug(strA + " this channelAdapter is not support cache, return ");
                }
            }
        }
    }

    @Override // com.yfanads.android.strategy.a
    public final void b() {
        YFLog.debug("CrossBPStrategyControl destroy");
        try {
            YFLog.debug("CrossBPStrategyControl shutdown When the bidding&wf ends, terminate the thread");
            this.v.set(true);
            ThreadPoolExecutor threadPoolExecutor = this.t;
            if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                this.t.shutdownNow();
            }
            this.t = null;
            this.f.clear();
            this.g.clear();
            this.j.clear();
            this.k.clear();
            this.o.clear();
            this.p.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(String str, boolean z2) {
        if (this.n || !z2) {
            return;
        }
        if (YFListUtils.isEmpty(this.j) && YFListUtils.isEmpty(this.k)) {
            YFLog.error("CrossBPStrategyControl [cache] addToCache " + str + " load success list is empty, return. ");
            return;
        }
        StrategyModel strategyModel = this.c;
        int cacheMax = strategyModel != null ? strategyModel.getCacheMax() : 0;
        YFLog.high("CrossBPStrategyControl [cache] addToCache " + str + ", start addToCache " + this.j.size() + " totalCacheMax " + cacheMax + " pSucLoadList " + this.j);
        if (cacheMax <= 0) {
            this.n = true;
            return;
        }
        a("parallel addToCache " + str, this.j);
        a("bidding addToCache " + str, this.k);
        this.n = true;
    }
}
