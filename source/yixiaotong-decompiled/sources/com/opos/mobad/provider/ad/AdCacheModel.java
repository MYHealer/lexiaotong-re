package com.opos.mobad.provider.ad;

import android.content.Context;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class AdCacheModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.ad.AdCacheModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return AdCacheModel.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile AdCacheModel f7261a;
    private b b;

    private AdCacheModel(Context context) {
        this.b = new b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdCacheModel b(Context context) {
        if (f7261a != null) {
            return f7261a;
        }
        synchronized (AdCacheModel.class) {
            if (f7261a == null) {
                f7261a = new AdCacheModel(context);
            }
        }
        return f7261a;
    }

    @BridgeMethod
    public AdEntity a(String str) {
        return this.b.a(str);
    }

    @BridgeMethod
    public void a(String str, AdEntity adEntity) {
        this.b.a(str, adEntity);
    }
}
