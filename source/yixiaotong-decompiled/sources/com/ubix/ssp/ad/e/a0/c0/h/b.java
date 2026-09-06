package com.ubix.ssp.ad.e.a0.c0.h;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8641a;

    class a implements m.a {
        a() {
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.h.m.a
        public String a(IBinder iBinder) {
            com.ubix.ssp.ad.e.a0.c0.i.e.a aVarA = com.ubix.ssp.ad.e.a0.c0.i.e.a.AbstractBinderC1078a.a(iBinder);
            if (aVarA != null) {
                return aVarA.e(b.this.f8641a.getPackageName());
            }
            throw new com.ubix.ssp.ad.e.a0.c0.e("IDeviceIdManager is null");
        }
    }

    public b(Context context) {
        this.f8641a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8641a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        m.a(this.f8641a, intent, cVar, new a());
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        Context context = this.f8641a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
            return false;
        }
    }
}
