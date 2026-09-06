package com.yfanads.android.db.proxy;

import com.yfanads.android.db.imp.e;
import com.yfanads.android.db.imp.f;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: ConfProxy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.yfanads.android.db.inf.a<String> f9649a;
    public final com.yfanads.android.db.inf.a<String> b;
    public StrategyModel c;

    public a(e eVar, f fVar) {
        this.f9649a = eVar;
        this.b = fVar;
    }

    public final boolean a(String str, boolean z) {
        YFLog.high("loadMemSuccess start");
        StrategyModel strategyModelCovertModel = StrategyModel.covertModel(this.f9649a.load(str));
        this.c = strategyModelCovertModel;
        boolean z2 = strategyModelCovertModel != null && (!z ? !strategyModelCovertModel.isDataValid() : !strategyModelCovertModel.isValid());
        YFLog.high("loadMemSuccess end " + z2);
        return z2;
    }

    public final boolean b(String str, boolean z) {
        YFLog.high("loadSPSuccess start");
        String strLoad = this.b.load(str);
        StrategyModel strategyModelCovertModel = StrategyModel.covertModel(strLoad);
        this.c = strategyModelCovertModel;
        boolean z2 = strategyModelCovertModel != null && (!z ? !strategyModelCovertModel.isDataValid() : !strategyModelCovertModel.isValid());
        if (z2) {
            this.f9649a.a(str, strLoad);
        }
        YFLog.high("loadSPSuccess end " + z2);
        return z2;
    }
}
