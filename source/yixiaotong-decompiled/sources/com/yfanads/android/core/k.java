package com.yfanads.android.core;

import android.view.View;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: TrackerChannelAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class k extends BaseChanelAdapter implements b {
    protected a viewTracker;

    public k(BaseAdapterEvent baseAdapterEvent) {
        super(baseAdapterEvent);
    }

    public void addViewLister(View view) {
        com.yfanads.android.strategy.b bVar = new com.yfanads.android.strategy.b(this);
        this.viewTracker = bVar;
        bVar.a(view);
    }

    @Override // com.yfanads.android.core.b
    public void collectExposureData(long j) {
        try {
            reportSdk(YFAdsConst.ReportETypeValue.SDK_SHOW_API_REAL.getValue());
            removeListener();
            YFLog.traceDebug("trackerExposure |H" + hashCode() + "|>> " + this.sdkSupplier + "|et_" + j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeListener() {
        a aVar = this.viewTracker;
        if (aVar != null) {
            ((com.yfanads.android.strategy.b) aVar).c();
            this.viewTracker = null;
            e.a(new StringBuilder(), this.tag, " removeListener success");
        }
    }
}
