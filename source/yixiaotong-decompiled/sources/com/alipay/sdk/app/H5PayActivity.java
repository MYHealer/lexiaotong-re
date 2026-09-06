package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class H5PayActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alipay.sdk.widget.g f1610a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private String g;

    static {
        StubApp.interface11(12887);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void b() {
        try {
            super.requestWindowFeature(1);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.alipay.sdk.widget.g gVar = this.f1610a;
        if (gVar instanceof com.alipay.sdk.widget.h) {
            gVar.b();
            return;
        }
        if (!gVar.b()) {
            super.onBackPressed();
        }
        j.a(j.c());
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    public void a() {
        Object obj = PayTask.f1613a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.alipay.sdk.widget.g gVar = this.f1610a;
        if (gVar != null) {
            gVar.a();
        }
    }
}
