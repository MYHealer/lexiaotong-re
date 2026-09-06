package com.opos.mobad.provider.strategy;

import android.content.Context;
import android.os.Bundle;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class StrategyModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.strategy.StrategyModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return StrategyModel.b(context);
        }
    };
    private static volatile StrategyModel b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7280a;
    private a c;

    private StrategyModel(Context context) {
        this.f7280a = context;
        this.c = new a(context);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrategyModel b(Context context) {
        if (b != null) {
            return b;
        }
        synchronized (StrategyModel.class) {
            if (b == null) {
                b = new StrategyModel(context);
            }
        }
        return b;
    }

    private void b() {
        d("dispatch_strategy");
    }

    private void c(String str) {
        d("dispatch_strategy_" + str);
    }

    private void d(String str) {
        if (this.f7280a == null) {
            return;
        }
        this.f7280a.deleteSharedPreferences(str);
    }

    @BridgeMethod
    public Bundle a(String str) {
        return this.c.b(str);
    }

    @BridgeMethod
    public AppInfo a() {
        return this.c.a();
    }

    @BridgeMethod
    public void a(String str, StrategyInfo strategyInfo) {
        this.c.a(str, strategyInfo.b, strategyInfo.f7279a);
    }

    @BridgeMethod
    public void a(String str, String str2, AppInfo appInfo) {
        c(str);
        this.c.a(str2, appInfo.b, appInfo.f7277a);
    }

    @BridgeMethod
    public AppInfo b(String str) {
        return this.c.a(str);
    }
}
