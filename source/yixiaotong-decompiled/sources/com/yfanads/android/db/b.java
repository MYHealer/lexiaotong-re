package com.yfanads.android.db;

import com.baidu.mobads.sdk.internal.ax;
import com.yfanads.android.callback.OnResultListener;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: DataManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b implements OnResultListener<StrategyModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.yfanads.android.db.proxy.a f9640a;
    public final /* synthetic */ String b;
    public final /* synthetic */ OnResultListener c;
    public final /* synthetic */ String d;
    public final /* synthetic */ d e;

    public b(d dVar, com.yfanads.android.db.proxy.a aVar, String str, OnResultListener onResultListener, String str2) {
        this.e = dVar;
        this.f9640a = aVar;
        this.b = str;
        this.c = onResultListener;
        this.d = str2;
    }

    @Override // com.yfanads.android.callback.OnResultListener
    public final void onSuccess(StrategyModel strategyModel) {
        StrategyModel strategyModel2 = strategyModel;
        if (strategyModel2 == null) {
            StrategyModel strategyModel3 = this.f9640a.c;
            if (strategyModel3 == null || !strategyModel3.isDataValid()) {
                d dVar = this.e;
                OnResultListener onResultListener = this.c;
                dVar.getClass();
                d.a("network covertModel", -3, "cache empty", onResultListener);
            } else {
                YFLog.high("loadFromNet use cache again.");
                strategyModel3.updateTimeFromServer();
                com.yfanads.android.db.proxy.a aVar = this.f9640a;
                String str = this.b;
                aVar.getClass();
                String strCovertString = StrategyModel.covertString(strategyModel3);
                aVar.f9649a.a(str, strCovertString);
                aVar.b.a(str, strCovertString);
                d dVar2 = this.e;
                OnResultListener onResultListener2 = this.c;
                dVar2.getClass();
                d.c(onResultListener2, strategyModel3);
            }
        } else if (strategyModel2.isDataValid()) {
            YFLog.high("loadFromNet success.");
            strategyModel2.updateTimeFromServer();
            com.yfanads.android.db.proxy.a aVar2 = this.f9640a;
            String str2 = this.b;
            aVar2.getClass();
            String strCovertString2 = StrategyModel.covertString(strategyModel2);
            aVar2.f9649a.a(str2, strCovertString2);
            aVar2.b.a(str2, strCovertString2);
            YFLog.high("loadFromNet use new data, save success.");
            d dVar3 = this.e;
            OnResultListener onResultListener3 = this.c;
            dVar3.getClass();
            d.c(onResultListener3, strategyModel2);
        } else {
            d dVar4 = this.e;
            OnResultListener onResultListener4 = this.c;
            dVar4.getClass();
            d.a("network covertModel", -4, "waterfall is empty", onResultListener4);
        }
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b.a.f9685a.a(this.d, YFAdsConst.ReportETypeValue.ADS_CONFIG_SUCCESS.getValue(), this.b);
    }

    @Override // com.yfanads.android.callback.OnResultListener
    public final void onFailed(int i, String str) {
        com.yfanads.android.db.proxy.a aVar = this.f9640a;
        String str2 = this.b;
        if (aVar.a(str2, false) || aVar.b(str2, false)) {
            YFLog.high("loadFromNet use local data.");
            d dVar = this.e;
            StrategyModel strategyModel = this.f9640a.c;
            OnResultListener onResultListener = this.c;
            dVar.getClass();
            d.a(ax.f1734a, strategyModel, onResultListener);
            return;
        }
        d dVar2 = this.e;
        OnResultListener onResultListener2 = this.c;
        dVar2.getClass();
        d.a("network", i, str, onResultListener2);
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b.a.f9685a.a(this.d, YFAdsConst.ReportETypeValue.ADS_CONFIG_FAIL.getValue(), this.b);
    }
}
