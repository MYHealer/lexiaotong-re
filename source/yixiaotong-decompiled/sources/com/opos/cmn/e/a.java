package com.opos.cmn.e;

import android.content.Context;
import com.heytap.msp.opos.sv.api.CommonAdModuleManager;
import com.heytap.msp.opos.sv.api.MSPSvSDK;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkRequest;
import com.opos.cmn.i.h;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6057a;
    private Context b;
    private AtomicBoolean c = new AtomicBoolean(false);

    private a() {
    }

    public static a a() {
        a aVar = f6057a;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = f6057a;
                if (aVar == null) {
                    aVar = new a();
                    f6057a = aVar;
                }
            }
        }
        return aVar;
    }

    private void b(Context context) {
        try {
            if (this.c.compareAndSet(false, true)) {
                a(context);
            }
            com.opos.cmn.an.f.a.b("MspServiceManager", "initIfNeed() hasInitialized=", this.c);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("MspServiceManager", "initIfNeed() fail", th);
        }
    }

    public void a(Context context) {
        MSPSvSDK.getInstance().init(context);
        if (context != null) {
            this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    public boolean a(Context context, Map<String, String> map) {
        try {
            b(context);
            DeepLinkRequest deepLinkRequest = new DeepLinkRequest();
            deepLinkRequest.setDeepLinkUrl(h.a(map, "dpUrl"));
            deepLinkRequest.setDpToken(h.a(map, "dpToken"));
            deepLinkRequest.setReqId(h.a(map, "reqId"));
            deepLinkRequest.setPkgName(h.a(map, "appPackageName"));
            deepLinkRequest.setDpRequestId(h.a(map, "dpRequestId"));
            return CommonAdModuleManager.getInstance().executeDeepLink(this.b, deepLinkRequest).getCode() == 0;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("MspServiceManager", "executeDeepLink() fail", th);
            return false;
        }
    }
}
