package com.opos.mobad.provider.monitor;

import android.content.Context;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class MonitorModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.monitor.MonitorModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return MonitorModel.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile MonitorModel f7264a;
    private Context b;

    private MonitorModel(Context context) {
        this.b = context;
        com.opos.cmn.biz.monitor.a.a().a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MonitorModel b(Context context) {
        if (f7264a != null) {
            return f7264a;
        }
        synchronized (MonitorModel.class) {
            if (f7264a == null) {
                f7264a = new MonitorModel(context);
            }
        }
        return f7264a;
    }

    @BridgeMethod
    public void a(String str, MonitorEvent monitorEvent) {
        com.opos.cmn.biz.monitor.a.a().a(this.b, str, monitorEvent);
    }
}
