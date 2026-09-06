package com.yfanads.android.strategy;

import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AbsStrategyControl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9677a;
    public final j b;
    public final StrategyModel c;
    public final Map<Integer, List<BaseChanelAdapter>> d;
    public final String e;

    public a(String str, StrategyModel strategyModel, ConcurrentHashMap concurrentHashMap, j jVar, String str2) {
        this.f9677a = str;
        this.c = strategyModel;
        this.d = concurrentHashMap;
        this.b = jVar;
        this.e = str2;
    }

    public final void a(BaseChanelAdapter baseChanelAdapter, SdkSupplier sdkSupplier) {
        if (baseChanelAdapter == null || sdkSupplier == null) {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "add [cache] adapter or supplier is null, return.");
            return;
        }
        if (!baseChanelAdapter.isSupportCache()) {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "add [cache] is not support, return. ");
            return;
        }
        if (baseChanelAdapter.isStartShow() || baseChanelAdapter.isExposure()) {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "[cache] has start show, do not add. ");
            return;
        }
        if (sdkSupplier.isBidding() && !sdkSupplier.isOverPrice()) {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "[cache] Bidding ecpm is too low, skip add. ");
            return;
        }
        StrategyModel strategyModel = this.c;
        if (strategyModel == null || strategyModel.getCacheMax() <= 0) {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "add [cache] cacheMax is zero, return.");
            return;
        }
        YFLog.high("add [cache] start " + sdkSupplier);
        com.yfanads.android.db.d dVar = com.yfanads.android.db.d.a.f9643a;
        String adId = sdkSupplier.getAdId();
        int cacheMax = this.c.getCacheMax();
        dVar.getClass();
        try {
            if (baseChanelAdapter.getSDKSupplier() == null) {
                YFLog.high("DataManager current adapter is not support [cache], return. " + baseChanelAdapter.tag);
                return;
            }
            if (cacheMax <= 0) {
                YFLog.high("DataManageradd [cache] cacheMax is zero, return.");
                return;
            }
            List<BaseChanelAdapter> arrayList = (List) dVar.f9642a.get(adId);
            if (arrayList == null) {
                YFLog.high("DataManager has no [cache], new array list. ");
                arrayList = new ArrayList<>();
            }
            boolean z = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b bVar = com.yfanads.android.upload.b.a.f9685a;
            bVar.a(baseChanelAdapter.getSDKSupplier(), YFAdsConst.ReportETypeValue.ADS_CACHE_ADD.getValue(), "");
            YFLog.high("DataManager [cache] before " + arrayList + "|cacheMax_" + cacheMax);
            if (arrayList.isEmpty() || arrayList.size() < cacheMax || dVar.a(baseChanelAdapter, arrayList)) {
                dVar.a(adId, baseChanelAdapter, arrayList);
            } else {
                YFLog.high("add [cache] fail, because max and lower price.");
                bVar.a(baseChanelAdapter.getSDKSupplier(), YFAdsConst.ReportETypeValue.ADS_CACHE_ADD_FAIL_FULL.getValue(), "");
            }
            YFLog.high("DataManager [cache] after " + arrayList);
        } catch (Exception e) {
            YFLog.high("DataManager addCache exception" + e.getMessage());
            e.printStackTrace();
        }
    }

    public abstract boolean a();

    public void b() {
    }
}
