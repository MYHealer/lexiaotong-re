package com.adprof.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class b7 implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1067a;

    public b7(Context context) {
        this.f1067a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1067a == null || ebVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        qg.a(this.f1067a, intent, ebVar, new a7(this));
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        Context context = this.f1067a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
