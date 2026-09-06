package com.heytap.msp.opos.sv.a;

import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.opos.sv.interapi.BuildConfig;
import com.heytap.msp.opos.sv.interapi.MSPSvModule;
import com.heytap.msp.opos.sv.interapi.bean.csc.InitConfig;
import com.heytap.mspsdk.MspSdk;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.log.MspLog;
import com.opos.process.bridge.provider.BridgeException;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f3454a = new AtomicBoolean(false);
    private Context b;

    @Override // com.heytap.msp.opos.sv.a.c
    public void enableLog() {
        com.opos.cmn.an.f.a.a();
        MspLog.setDebug(true);
    }

    @Override // com.heytap.msp.opos.sv.a.c
    public int getSDKVerCode() {
        return BuildConfig.SDK_VER_CODE;
    }

    @Override // com.heytap.msp.opos.sv.a.c
    public String getSDKVerName() {
        return BuildConfig.SDK_VER_NAME;
    }

    @Override // com.heytap.msp.opos.sv.a.c
    public void init(Context context) {
        if (!this.f3454a.compareAndSet(false, true)) {
            com.opos.cmn.an.f.a.a("MSPSvSDKImpl", "already initialized");
        } else {
            this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.heytap.msp.opos.sv.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MspSdk.init(d.this.b);
                        Bundle bundle = new Bundle();
                        com.heytap.msp.opos.sv.a.b.a.a(bundle);
                        ((MSPSvModule.Interface) MspSdk.apiProxy(new MSPSvModule.Client(d.this.b, bundle))).init(new InitConfig());
                    } catch (MspSdkException | BridgeException e) {
                        com.opos.cmn.an.f.a.d("MSPSvSDKImpl", "init", e);
                    }
                }
            });
        }
    }
}
