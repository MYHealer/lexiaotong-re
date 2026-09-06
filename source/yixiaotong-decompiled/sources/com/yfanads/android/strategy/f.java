package com.yfanads.android.strategy;

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

/* JADX INFO: compiled from: BiddingStrategyControl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class f extends a implements UnionSdkResultListener {
    public List<SdkSupplier> f;
    public BaseChanelAdapter g;
    public int h;
    public long i;

    public f(String str, StrategyModel strategyModel, ConcurrentHashMap concurrentHashMap, j jVar, String str2) {
        super(str, strategyModel, concurrentHashMap, jVar, str2);
    }

    @Override // com.yfanads.android.strategy.a
    public final boolean a() {
        synchronized (this) {
            BaseChanelAdapter baseChanelAdapter = this.g;
            if (baseChanelAdapter == null) {
                return false;
            }
            SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
            YFLog.traceDebug("BTotalTimeout runBidding find " + sDKSupplier + "|t_" + (System.currentTimeMillis() - this.i) + " req:" + this.e);
            j jVar = this.b;
            if (jVar != null) {
                ((d) jVar).a(baseChanelAdapter, sDKSupplier);
            }
            baseChanelAdapter.reportSdk(YFAdsConst.ReportETypeValue.FLOW_PADDING.getValue());
            int value = YFAdsConst.ReportETypeValue.FLOW_PADDING_RT.getValue();
            if (InitUtils.isRTReport(value)) {
                baseChanelAdapter.reportSdk(value, true);
            }
            return true;
        }
    }

    public final void c() {
        com.yfanads.android.core.g.a(new StringBuilder("runBidding callback end t_").append(System.currentTimeMillis() - this.i).append(" req:"), this.e);
        j jVar = this.b;
        if (jVar == null) {
            YFLog.error("onBiddingCallback sdkSupplierListener is null");
            return;
        }
        BaseChanelAdapter baseChanelAdapter = this.g;
        if (baseChanelAdapter != null) {
            ((d) jVar).a(baseChanelAdapter.getSDKSupplier(), true);
        } else {
            ((d) jVar).k();
        }
        if (!YFListUtils.isEmpty(this.f)) {
            this.f.clear();
        }
        StrategyModel strategyModel = this.c;
        if (strategyModel != null) {
            strategyModel.setBiddingList(null);
        }
    }

    public final void d() {
        BaseChanelAdapter jVar;
        List<BaseChanelAdapter> list;
        this.i = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        com.yfanads.android.core.g.a(new StringBuilder("runBidding start in ").append(name).append(" req:"), this.e);
        this.f = this.c.getBiddingList();
        YFLog.debug("saveBiddingData " + this.f);
        if (YFListUtils.isEmpty(this.f)) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, " runBidding, suppliers or parallel is empty, return.");
            return;
        }
        if (this.c.isTotalTimeout()) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, "runBidding is timeout, return.");
            return;
        }
        int size = this.f.size();
        YFLog.debug(this.f9677a + " runBidding size = " + size + " , start ");
        for (int i = 0; i < size; i++) {
            SdkSupplier sdkSupplier = this.f.get(i);
            int adnIdValue = sdkSupplier.getAdnIdValue();
            try {
                j jVar2 = this.b;
                if (jVar2 == null) {
                    YFLog.error(adnIdValue + " strategyListener is null");
                    jVar = new com.yfanads.android.core.j(sdkSupplier);
                } else {
                    jVar = ((d) jVar2).a(Integer.valueOf(adnIdValue));
                    if (jVar == null) {
                        YFLog.error(adnIdValue + " adapter is null");
                        jVar = new com.yfanads.android.core.j(sdkSupplier);
                    } else {
                        StrategyModel strategyModel = this.c;
                        if (strategyModel != null) {
                            sdkSupplier.setCacheTimeout(strategyModel.getCacheTimeout());
                            sdkSupplier.setCType(this.c.getCType());
                        }
                        sdkSupplier.setWaterfallTime();
                        jVar.setSDKSupplier(sdkSupplier);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                jVar = new com.yfanads.android.core.j(sdkSupplier);
            }
            if (!(jVar instanceof com.yfanads.android.core.j) && (list = this.d.get(Integer.valueOf(adnIdValue))) != null) {
                list.add(jVar);
                this.d.put(Integer.valueOf(adnIdValue), list);
            }
            jVar.setUnionSdkResultListener(this);
            com.yfanads.android.core.g.a(new StringBuilder("runBidding load ").append(sdkSupplier.index).append("|hs_").append(jVar.hashCode()).append(" req:"), this.e);
            j jVar3 = this.b;
            jVar.loadOnly(jVar3 != null ? ((d) jVar3).f() : null);
        }
        YFLog.debug(this.f9677a + " runBidding size = " + size + " , end ");
        com.yfanads.android.core.g.a(new StringBuilder("runBidding end in ").append(name).append("|t_").append(System.currentTimeMillis() - this.i).append(" req:"), this.e);
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultFailed(BaseChanelAdapter baseChanelAdapter, YFAdError yFAdError) {
        com.yfanads.android.core.g.a(new StringBuilder("runBidding load fail ").append(baseChanelAdapter.getSDKSupplier()).append("|t_").append(baseChanelAdapter.getLogTime()).append("|ec_").append(yFAdError.code).append("|em_").append(yFAdError.msg).append(" req:"), this.e);
        if (this.c.isTotalTimeout()) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, "onBiddingResultFailed is timeout, return.");
            return;
        }
        this.h++;
        YFLog.high(this.f9677a + " onBiddingResultFailed loadList " + this.h + " , mBiddingList size " + this.f.size());
        if (this.h == this.f.size()) {
            c();
        }
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultSuccess(BaseChanelAdapter baseChanelAdapter) {
        boolean zIsTotalTimeout = this.c.isTotalTimeout();
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        com.yfanads.android.core.g.a(new StringBuilder("runBidding load success ").append(sDKSupplier).append("|t_").append(baseChanelAdapter.getLogTime()).append(" req:"), this.e);
        if (zIsTotalTimeout) {
            com.yfanads.android.core.h.a(new StringBuilder(), this.f9677a, "onBiddingResultSuccess is timeout, return.");
            return;
        }
        this.h++;
        if (sDKSupplier.isOverPrice()) {
            boolean z = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b.a.f9685a.a(sDKSupplier, YFAdsConst.ReportETypeValue.BIDDING_HIGHER.getValue(), "");
            BaseChanelAdapter baseChanelAdapter2 = this.g;
            if (baseChanelAdapter2 == null || sDKSupplier.ecpm > baseChanelAdapter2.getEcpm()) {
                this.g = baseChanelAdapter;
            }
        } else {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, " findMaxBidding low ecpm, return.");
            boolean z2 = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b.a.f9685a.a(sDKSupplier, YFAdsConst.ReportETypeValue.BIDDING_LOWER.getValue(), "");
        }
        YFLog.high(this.f9677a + " onBiddingResultSuccess loadList " + this.h + " , mBiddingList size " + this.f.size());
        if (this.h == this.f.size()) {
            c();
        }
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onTimeoutSuccess(BaseChanelAdapter baseChanelAdapter) {
        YFLog.debug(this.f9677a + "onTimeoutSuccess " + baseChanelAdapter);
    }
}
