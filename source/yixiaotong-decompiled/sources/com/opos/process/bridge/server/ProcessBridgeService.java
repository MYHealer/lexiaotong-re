package com.opos.process.bridge.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.opos.process.bridge.a.f;
import com.opos.process.bridge.a.g;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import com.stub.StubApp;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ProcessBridgeService extends Service {
    protected IBinder a(Intent intent) {
        HashMap map = new HashMap();
        String stringExtra = intent.getStringExtra("callingPackage");
        ProcessBridgeLog.d("ProcessBridgeService", "callingPackage:" + stringExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        g gVarA = new g.a().a(StubApp.getOrigApplicationContext(getApplicationContext())).a(stringExtra).a(intent.getExtras()).a(map).a();
        for (f fVar : c.a().b()) {
            com.opos.process.bridge.a.b bVarA = fVar.a(gVarA);
            ProcessBridgeLog.d("ProcessBridgeService", "PreLinkServerInterceptor: " + fVar.getClass().getName() + ", result:" + bVarA);
            if (bVarA.c()) {
                c.a().a(stringExtra, bVarA);
                ProcessBridgeLog.d("ProcessBridgeService", "return NULL");
                return null;
            }
        }
        ProcessBridgeLog.d("ProcessBridgeService", "return ProcessBridgeBinder");
        return new b(StubApp.getOrigApplicationContext(getApplicationContext()), map);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ProcessBridgeLog.d("ProcessBridgeService", "onBind");
        return a(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d.a().a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d.a().b(this);
    }
}
