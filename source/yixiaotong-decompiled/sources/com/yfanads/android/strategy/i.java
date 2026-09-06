package com.yfanads.android.strategy;

import com.yfanads.android.callback.UnionSdkResultListener;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SerialStrategyControl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class i extends a implements UnionSdkResultListener {
    public i(String str, StrategyModel strategyModel, ConcurrentHashMap concurrentHashMap, j jVar, String str2) {
        super(str, strategyModel, concurrentHashMap, jVar, str2);
    }

    @Override // com.yfanads.android.strategy.a
    public final boolean a() {
        return false;
    }

    public final boolean a(SdkSupplier sdkSupplier, List<BaseChanelAdapter> list) {
        if (!sdkSupplier.isBidding()) {
            return false;
        }
        for (BaseChanelAdapter baseChanelAdapter : list) {
            YFLog.high(" isBidding start " + sdkSupplier.getPotId() + " , adapter " + baseChanelAdapter.getPotID());
            if (Util.isStrEquals(sdkSupplier.getPotId(), baseChanelAdapter.getPotID())) {
                onResultSuccess(baseChanelAdapter);
                return true;
            }
        }
        return false;
    }

    public final void c() {
        String name = Thread.currentThread().getName();
        com.yfanads.android.core.g.a(new StringBuilder("runSerial start in ").append(name).append(" req:"), this.e);
        SdkSupplier topSdkSupplier = this.c.getTopSdkSupplier();
        if (!this.c.isSdkSupplierEmpty() && topSdkSupplier != null) {
            int adnIdValue = topSdkSupplier.getAdnIdValue();
            try {
                this.c.removeTopSdkSupplier();
                if (topSdkSupplier.isFromCache() && a(topSdkSupplier)) {
                    return;
                }
                List<BaseChanelAdapter> list = this.d.get(Integer.valueOf(adnIdValue));
                if (list == null || this.b == null) {
                    YFLog.error("未支持的SDK渠道，跳过该渠道加载。请先检查是否引入了该渠道处理依赖，如已引入，检查下发渠道信息，如未在渠道已支持列表中，请请查看文档使用自定义渠道来完成广告加载 sdk=" + adnIdValue);
                    j jVar = this.b;
                    if (jVar != null) {
                        YFAdError err = YFAdError.parseErr(-1, YFAdsConst.NOT_SUPPORT_CHANEL_TIPS);
                        d dVar = (d) jVar;
                        if (dVar.g != null) {
                            dVar.g = err;
                        }
                        ((d) this.b).q();
                    }
                } else {
                    if (a(topSdkSupplier, list)) {
                        return;
                    }
                    BaseChanelAdapter baseChanelAdapterA = ((d) this.b).a(Integer.valueOf(adnIdValue));
                    if (baseChanelAdapterA == null) {
                        YFLog.error(adnIdValue + " adapter is null");
                        ((d) this.b).a(true, true);
                    } else {
                        topSdkSupplier.setCacheTimeout(this.c.getCacheTimeout());
                        topSdkSupplier.setWaterfallTime();
                        topSdkSupplier.setCType(this.c.getCType());
                        baseChanelAdapterA.setSDKSupplier(topSdkSupplier);
                        baseChanelAdapterA.setUnionSdkResultListener(this);
                        baseChanelAdapterA.loadOnly(((d) this.b).f());
                        list.add(baseChanelAdapterA);
                        this.d.put(Integer.valueOf(adnIdValue), list);
                        YFLog.traceDebug("runSerial load " + topSdkSupplier.index + "|hs_" + baseChanelAdapterA.hashCode() + " req:" + this.e);
                    }
                }
            } catch (Exception e) {
                com.yfanads.android.core.f.a(e, new StringBuilder().append(this.f9677a).append(" runSerial "));
                ((d) this.b).a(true, true);
            }
        }
        com.yfanads.android.core.g.a(new StringBuilder("runSerial end in ").append(name).append(" req:"), this.e);
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultFailed(BaseChanelAdapter baseChanelAdapter, YFAdError yFAdError) {
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        long logTime = baseChanelAdapter.getLogTime();
        boolean zIsTotalTimeout = this.c.isTotalTimeout();
        String str = "load fail " + sDKSupplier + "|t" + logTime + " req:" + this.e;
        YFLog.traceDebug("runSerial " + str);
        YFLog.high(this.f9677a + "onSerialResultFailed " + str);
        if (zIsTotalTimeout) {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "onSerialResultFailed total timeout.");
            return;
        }
        j jVar = this.b;
        if (jVar != null) {
            YFAdError err = YFAdError.parseErr(YFAdError.ERROR_DATA_NULL);
            d dVar = (d) jVar;
            if (dVar.g != null) {
                dVar.g = err;
            }
            ((d) this.b).q();
            com.yfanads.android.core.g.a(new StringBuilder("runSerial next req:"), this.e);
        }
    }

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onResultSuccess(BaseChanelAdapter baseChanelAdapter) {
        boolean zIsTotalTimeout = this.c.isTotalTimeout();
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        String str = "load success " + sDKSupplier + "|t" + baseChanelAdapter.getLogTime() + " req:" + this.e;
        YFLog.traceDebug("runSerial " + str);
        YFLog.high(this.f9677a + "onSerialResultSuccess " + str);
        if (zIsTotalTimeout) {
            com.yfanads.android.core.e.a(new StringBuilder(), this.f9677a, "onSerialResultSuccess total timeout.");
            return;
        }
        j jVar = this.b;
        if (jVar != null) {
            ((d) jVar).c();
        }
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

    @Override // com.yfanads.android.callback.UnionSdkResultListener
    public final void onTimeoutSuccess(BaseChanelAdapter baseChanelAdapter) {
        YFLog.debug(this.f9677a + "onTimeoutSuccess " + baseChanelAdapter);
    }

    public final boolean a(SdkSupplier sdkSupplier) {
        SdkSupplier sDKSupplier;
        BaseChanelAdapter baseChanelAdapterA = com.yfanads.android.db.d.a.f9643a.a(sdkSupplier.getAdId());
        if (baseChanelAdapterA == null || (sDKSupplier = baseChanelAdapterA.getSDKSupplier()) == null || sDKSupplier.ecpm < sdkSupplier.ecpm) {
            return false;
        }
        YFLog.high(this.f9677a + " serial hit cache, show " + baseChanelAdapterA.tag + " , " + baseChanelAdapterA.getSDKSupplier());
        j jVar = this.b;
        if (jVar != null) {
            ((d) jVar).c();
        }
        baseChanelAdapterA.setUnionSdkResultListener(this);
        baseChanelAdapterA.handleSucceed(false);
        return true;
    }
}
