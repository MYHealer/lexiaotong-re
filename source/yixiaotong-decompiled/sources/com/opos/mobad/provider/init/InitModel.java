package com.opos.mobad.provider.init;

import android.content.Context;
import com.opos.cmn.an.custom.policy.PolicyConfig;
import com.opos.cmn.an.custom.policy.PolicyManager;
import com.opos.cmn.biz.a.d;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;
import com.stub.StubApp;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class InitModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.init.InitModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return InitModel.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile InitModel f7263a;
    private Context b;

    public InitModel(Context context) {
        this.b = context;
    }

    private static void a() {
        HashMap map = new HashMap();
        map.put(PolicyConfig.UserData.KEY_IMEI, false);
        PolicyManager.getInstance().setPolicyConfig(new PolicyConfig.Builder().setCanReadUserDataMap(map).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitModel b(Context context) {
        if (f7263a != null) {
            return f7263a;
        }
        synchronized (InitModel.class) {
            if (f7263a == null) {
                f7263a = new InitModel(context);
            }
        }
        return f7263a;
    }

    @BridgeMethod
    public void a(boolean z, boolean z2, String str) {
        a();
        com.opos.cmn.c.a.a(StubApp.getOrigApplicationContext(this.b.getApplicationContext()), z, z2);
        d.a(StubApp.getOrigApplicationContext(this.b.getApplicationContext()), str);
        com.opos.cmn.an.f.a.b("", "init ContentProvider Log " + z2 + "," + str);
    }
}
