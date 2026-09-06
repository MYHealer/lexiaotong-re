package com.yfanads.android.strategy;

import com.yfanads.android.callback.UnionSdkResultListener;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ParallelStrategyControl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class h extends a implements UnionSdkResultListener {
    public final ArrayList f;
    public final CopyOnWriteArrayList g;
    public final ConcurrentHashMap h;
    public final CopyOnWriteArrayList i;
    public final AtomicInteger j;
    public int k;
    public long l;

    public h(String str, StrategyModel strategyModel, ConcurrentHashMap concurrentHashMap, j jVar, String str2) {
        super(str, strategyModel, concurrentHashMap, jVar, str2);
        this.f = new ArrayList();
        this.g = new CopyOnWriteArrayList();
        this.h = new ConcurrentHashMap();
        this.i = new CopyOnWriteArrayList();
        this.j = new AtomicInteger(0);
        this.k = 0;
    }

    @Override // com.yfanads.android.strategy.a
    public final boolean a() {
        return a("TotalTimeout", this.i, false);
    }

    public final void c() {
        this.f.clear();
        this.i.clear();
        this.g.clear();
        this.h.clear();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x021b A[Catch: Exception -> 0x0264, TryCatch #0 {Exception -> 0x0264, blocks: (B:46:0x0217, B:48:0x021b, B:49:0x0221, B:51:0x022d, B:52:0x0249, B:54:0x024d, B:55:0x025d), top: B:76:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0221 A[Catch: Exception -> 0x0264, TryCatch #0 {Exception -> 0x0264, blocks: (B:46:0x0217, B:48:0x021b, B:49:0x0221, B:51:0x022d, B:52:0x0249, B:54:0x024d, B:55:0x025d), top: B:76:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x022d A[Catch: Exception -> 0x0264, TryCatch #0 {Exception -> 0x0264, blocks: (B:46:0x0217, B:48:0x021b, B:49:0x0221, B:51:0x022d, B:52:0x0249, B:54:0x024d, B:55:0x025d), top: B:76:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0249 A[Catch: Exception -> 0x0264, TryCatch #0 {Exception -> 0x0264, blocks: (B:46:0x0217, B:48:0x021b, B:49:0x0221, B:51:0x022d, B:52:0x0249, B:54:0x024d, B:55:0x025d), top: B:76:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x024d A[Catch: Exception -> 0x0264, TryCatch #0 {Exception -> 0x0264, blocks: (B:46:0x0217, B:48:0x021b, B:49:0x0221, B:51:0x022d, B:52:0x0249, B:54:0x024d, B:55:0x025d), top: B:76:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:76:0x0217 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void d() {
        BaseChanelAdapter jVar;
        j jVar2;
        StrategyModel strategyModel;
        this.l = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        YFLog.traceDebug("runParallel start in " + name + " req:" + this.e);
        c();
        for (SdkSupplier sdkSupplier : this.c.getSdkSupplierList()) {
            if (this.f.size() == this.c.getParallelCnt()) {
                break;
            } else {
                this.f.add(sdkSupplier);
            }
        }
        YFLog.high("saveParallelData " + this.f);
        if (YFListUtils.isEmpty(this.c.getSdkSupplierList()) || YFListUtils.isEmpty(this.f)) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, " runParallel, suppliers or parallel is empty, return.");
            j jVar3 = this.b;
            if (jVar3 != null) {
                YFAdError err = YFAdError.parseErr(YFAdError.ERROR_DATA_NULL);
                d dVar = (d) jVar3;
                if (dVar.g != null) {
                    dVar.g = err;
                }
                ((d) this.b).m();
                return;
            }
            return;
        }
        if (this.c.isTotalTimeout()) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, "runParallel is timeout, return.");
            return;
        }
        boolean z = false;
        this.j.set(((SdkSupplier) this.f.get(0)).index);
        int size = this.f.size();
        this.k++;
        YFLog.high(this.f9677a + " runParallel batch " + this.k + " size = " + size + " , start");
        for (SdkSupplier sdkSupplier2 : this.f) {
            this.c.removeTopSdkSupplier();
            if (sdkSupplier2.isFromCache()) {
                BaseChanelAdapter baseChanelAdapterA = com.yfanads.android.db.d.a.f9643a.a(sdkSupplier2.getAdId());
                if (baseChanelAdapterA != null && sdkSupplier2.isFromCache()) {
                    SdkSupplier sDKSupplier = baseChanelAdapterA.getSDKSupplier();
                    sDKSupplier.setFromCache(true);
                    YFLog.high(this.f9677a + " parallel hit cache, show " + baseChanelAdapterA.tag + " , " + sDKSupplier);
                    j jVar4 = this.b;
                    if (jVar4 != null) {
                        com.yfanads.android.core.c.b bVar = ((d) jVar4).o;
                        baseChanelAdapterA.setAdsSpotListener(bVar != null ? bVar.a() : null);
                    } else {
                        com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, " parallel hit cache, but activity is null");
                    }
                    baseChanelAdapterA.setUnionSdkResultListener(this);
                    baseChanelAdapterA.handleSucceed(z);
                    com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "adapter start load cache ");
                }
            }
            int adnIdValue = sdkSupplier2.getAdnIdValue();
            YFLog.high(adnIdValue + " runParallel batch " + this.k + " size = " + size + " , start ");
            List<BaseChanelAdapter> list = this.d.get(Integer.valueOf(adnIdValue));
            if (sdkSupplier2.isBidding()) {
                Iterator<BaseChanelAdapter> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        BaseChanelAdapter next = it.next();
                        YFLog.high(" isBidding start " + sdkSupplier2.getPotId() + " , adapter " + next.getPotID());
                        if (Util.isStrEquals(sdkSupplier2.getPotId(), next.getPotID())) {
                            onResultSuccess(next);
                            YFLog.high(adnIdValue + " runParallel is bidding onResultSuccess ");
                        }
                    } else {
                        try {
                            jVar2 = this.b;
                            if (jVar2 == null) {
                                jVar = new com.yfanads.android.core.j(sdkSupplier2);
                            } else {
                                jVar = ((d) jVar2).a(Integer.valueOf(adnIdValue));
                                if (jVar == null) {
                                    YFLog.high(adnIdValue + " adapter is null");
                                    jVar = new com.yfanads.android.core.j(sdkSupplier2);
                                } else {
                                    strategyModel = this.c;
                                    if (strategyModel != null) {
                                        sdkSupplier2.setCacheTimeout(strategyModel.getCacheTimeout());
                                        sdkSupplier2.setCType(this.c.getCType());
                                    }
                                    sdkSupplier2.setWaterfallTime();
                                    jVar.setSDKSupplier(sdkSupplier2);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            jVar = new com.yfanads.android.core.j(sdkSupplier2);
                        }
                        if (!(jVar instanceof com.yfanads.android.core.j) && list != null) {
                            list.add(jVar);
                            this.d.put(Integer.valueOf(adnIdValue), list);
                        }
                        jVar.setUnionSdkResultListener(this);
                        com.yfanads.android.core.g.a(new StringBuilder("runParallel load ").append(sdkSupplier2.index).append("|hs_").append(jVar.hashCode()).append(" req:"), this.e);
                        j jVar5 = this.b;
                        jVar.loadOnly(jVar5 != null ? ((d) jVar5).f() : null);
                    }
                }
            } else {
                jVar2 = this.b;
                if (jVar2 == null) {
                    jVar = new com.yfanads.android.core.j(sdkSupplier2);
                } else {
                    jVar = ((d) jVar2).a(Integer.valueOf(adnIdValue));
                    if (jVar == null) {
                        YFLog.high(adnIdValue + " adapter is null");
                        jVar = new com.yfanads.android.core.j(sdkSupplier2);
                    } else {
                        strategyModel = this.c;
                        if (strategyModel != null) {
                            sdkSupplier2.setCacheTimeout(strategyModel.getCacheTimeout());
                            sdkSupplier2.setCType(this.c.getCType());
                        }
                        sdkSupplier2.setWaterfallTime();
                        jVar.setSDKSupplier(sdkSupplier2);
                    }
                }
                if (!(jVar instanceof com.yfanads.android.core.j)) {
                    list.add(jVar);
                    this.d.put(Integer.valueOf(adnIdValue), list);
                }
                jVar.setUnionSdkResultListener(this);
                com.yfanads.android.core.g.a(new StringBuilder("runParallel load ").append(sdkSupplier2.index).append("|hs_").append(jVar.hashCode()).append(" req:"), this.e);
                j jVar6 = this.b;
                jVar.loadOnly(jVar6 != null ? ((d) jVar6).f() : null);
            }
            z = false;
        }
        YFLog.high(this.f9677a + " runParallel batch " + this.k + " size = " + size + " , end");
        com.yfanads.android.core.g.a(new StringBuilder("runParallel end in ").append(name).append(" t_").append(System.currentTimeMillis() - this.l).append(" req:"), this.e);
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onTimeoutSuccess(BaseChanelAdapter baseChanelAdapter) {
        YFLog.debug(this.f9677a + "onTimeoutSuccess " + baseChanelAdapter);
    }

    public final synchronized boolean a(String str, CopyOnWriteArrayList copyOnWriteArrayList, boolean z) {
        LinkedList linkedList = new LinkedList();
        Iterator it = copyOnWriteArrayList.iterator();
        BaseChanelAdapter baseChanelAdapter = null;
        while (it.hasNext()) {
            BaseChanelAdapter baseChanelAdapter2 = (BaseChanelAdapter) it.next();
            SdkSupplier sDKSupplier = baseChanelAdapter2.getSDKSupplier();
            if (sDKSupplier != null && sDKSupplier.isLoadSuccess()) {
                if (baseChanelAdapter2.isSupportCache()) {
                    linkedList.add(baseChanelAdapter2);
                }
                if (baseChanelAdapter == null || baseChanelAdapter.getSDKSupplier().ecpm < baseChanelAdapter2.getSDKSupplier().ecpm) {
                    baseChanelAdapter = baseChanelAdapter2;
                }
            }
        }
        if (baseChanelAdapter != null && baseChanelAdapter.isSupportCache()) {
            linkedList.remove(baseChanelAdapter);
        }
        if (baseChanelAdapter == null) {
            YFLog.high(this.f9677a + str + " has not show adapter");
            a(str, linkedList);
            return false;
        }
        if (baseChanelAdapter.getSDKSupplier() != null && this.j.get() == -99) {
            YFLog.high(this.f9677a + str + " show adapter is show, return.");
            a(str, linkedList);
            return true;
        }
        YFLog.high(this.f9677a + str + ", show all index = " + baseChanelAdapter.getSDKSupplier().index);
        a(baseChanelAdapter, z);
        a(str, linkedList);
        return true;
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultFailed(BaseChanelAdapter baseChanelAdapter, YFAdError yFAdError) {
        boolean zA;
        CopyOnWriteArrayList copyOnWriteArrayList = this.i;
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        String str = "load fail bt_" + this.k + "|" + sDKSupplier + "|t_" + baseChanelAdapter.getLogTime() + "|ec_" + yFAdError.code + "|em_" + yFAdError.msg + " req:" + this.e;
        YFLog.traceDebug("runParallel " + str);
        YFLog.high(this.f9677a + "onParallelResultFailed " + str);
        if (this.c.isTotalTimeout()) {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "onParallelResultFailed is timeout, return.");
            return;
        }
        copyOnWriteArrayList.add(baseChanelAdapter);
        if (sDKSupplier != null) {
            this.g.add(Integer.valueOf(sDKSupplier.index));
        }
        YFLog.high(this.f9677a + " onParallelResultFailed size = " + copyOnWriteArrayList.size() + " , " + this.f.size());
        if (this.i.size() != this.f.size()) {
            if (this.j.get() == -99) {
                return;
            }
            for (SdkSupplier sdkSupplier : this.f) {
                if (sdkSupplier != null && !this.g.contains(Integer.valueOf(sdkSupplier.index))) {
                    int i = sdkSupplier.index;
                    this.j.set(i);
                    BaseChanelAdapter baseChanelAdapter2 = (BaseChanelAdapter) this.h.get(Integer.valueOf(i));
                    if (baseChanelAdapter2 != null) {
                        a(baseChanelAdapter2, true);
                        com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "findShowAdapterIndex in successMap ");
                    }
                    YFLog.high(this.f9677a + " findShowAdapterIndex update showIndex " + sdkSupplier.index);
                    return;
                }
            }
            return;
        }
        com.yfanads.android.core.g.a(new StringBuilder("runParallel callback in batch ").append(this.k).append(" end t_").append(System.currentTimeMillis() - this.l).append(" req:"), this.e);
        synchronized (this) {
            zA = a("onParallelResultFailed", copyOnWriteArrayList, true);
        }
        if (zA) {
            YFLog.high(this.f9677a + " onParallelResultFailed has one show, return.");
            c();
            return;
        }
        if (this.f.size() != this.c.getParallelCnt()) {
            c();
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
        com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "onParallelResultFailed start parallelSuppliers");
        if (!this.c.isSdkSupplierEmpty()) {
            YFLog.traceDebug("runParallel next batch req:" + this.e);
            d();
            return;
        }
        c();
        j jVar2 = this.b;
        if (jVar2 != null) {
            YFAdError err2 = YFAdError.parseErr(YFAdError.ERROR_DATA_NULL);
            d dVar2 = (d) jVar2;
            if (dVar2.g != null) {
                dVar2.g = err2;
            }
            ((d) this.b).m();
        }
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultSuccess(BaseChanelAdapter baseChanelAdapter) {
        boolean zA;
        CopyOnWriteArrayList copyOnWriteArrayList = this.i;
        boolean zIsTotalTimeout = this.c.isTotalTimeout();
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        String str = "load success bt_" + this.k + "|" + sDKSupplier + "|t_" + baseChanelAdapter.getLogTime() + " req:" + this.e;
        YFLog.traceDebug("runParallel " + str);
        YFLog.high(this.f9677a + " onParallelResultSuccess " + str);
        if (zIsTotalTimeout) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, "onParallelResultSuccess is timeout, return.");
            return;
        }
        copyOnWriteArrayList.add(baseChanelAdapter);
        if (sDKSupplier != null) {
            this.h.put(Integer.valueOf(sDKSupplier.index), baseChanelAdapter);
        }
        YFLog.high(this.f9677a + " onParallelResultSuccess size = " + copyOnWriteArrayList.size() + " , " + this.f.size());
        if (sDKSupplier != null && sDKSupplier.index == this.j.get()) {
            YFLog.high(this.f9677a + " onParallelResultSuccess, showChannelAdapter showIndex = " + sDKSupplier.index);
            a(baseChanelAdapter, true);
        }
        if (this.i.size() == this.f.size()) {
            com.yfanads.android.core.g.a(new StringBuilder("runParallel callback in batch ").append(this.k).append(" end t_").append(System.currentTimeMillis() - this.l).append(" req:"), this.e);
            synchronized (this) {
                zA = a("onParallelResultSuccess", copyOnWriteArrayList, true);
            }
            YFLog.high(this.f9677a + " onParallelResultSuccess  showChannelAdapter = " + zA);
            c();
        }
    }

    public final void a(BaseChanelAdapter baseChanelAdapter, boolean z) {
        j jVar;
        if (z && (jVar = this.b) != null) {
            ((d) jVar).c();
        }
        this.j.set(-99);
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        com.yfanads.android.core.g.a(new StringBuilder("runParallel find ").append(sDKSupplier).append("|t_").append(System.currentTimeMillis() - this.l).append(" req:"), this.e);
        j jVar2 = this.b;
        if (jVar2 != null) {
            ((d) jVar2).a(baseChanelAdapter, sDKSupplier);
        }
        baseChanelAdapter.reportSdk(YFAdsConst.ReportETypeValue.FLOW_PADDING.getValue());
        int value = YFAdsConst.ReportETypeValue.FLOW_PADDING_RT.getValue();
        if (InitUtils.isRTReport(value)) {
            baseChanelAdapter.reportSdk(value, true);
        }
    }

    public final void a(String str, LinkedList linkedList) {
        if (YFListUtils.isEmpty(linkedList)) {
            YFLog.high(this.f9677a + str + " addToCache empty");
            return;
        }
        StrategyModel strategyModel = this.c;
        if (strategyModel != null && strategyModel.getCacheMax() <= 0) {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, " addCache cacheMax is zero, return.");
            return;
        }
        YFLog.high(this.f9677a + str + " addToCache ");
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            BaseChanelAdapter baseChanelAdapter = (BaseChanelAdapter) it.next();
            a(baseChanelAdapter, baseChanelAdapter.getSDKSupplier());
        }
    }
}
