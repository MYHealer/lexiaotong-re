package com.meishu.sdk.core.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.meishu.sdk.core.oaid.OAIDException;
import com.stub.StubApp;

/* JADX INFO: compiled from: CoolpadImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4827a;

    /* JADX INFO: compiled from: CoolpadImpl.java */
    public class a implements m.a {
        public a() {
        }

        @Override // com.meishu.sdk.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.meishu.sdk.core.oaid.repeackage.com.coolpad.deviceidsupport.a c0807a;
            int i = com.meishu.sdk.core.oaid.repeackage.com.coolpad.deviceidsupport.a.AbstractBinderC0806a.f4850a;
            if (iBinder == null) {
                c0807a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                c0807a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.meishu.sdk.core.oaid.repeackage.com.coolpad.deviceidsupport.a)) ? new com.meishu.sdk.core.oaid.repeackage.com.coolpad.deviceidsupport.a.AbstractBinderC0806a.C0807a(iBinder) : (com.meishu.sdk.core.oaid.repeackage.com.coolpad.deviceidsupport.a) iInterfaceQueryLocalInterface;
            }
            if (c0807a != null) {
                return c0807a.a(b.this.f4827a.getPackageName());
            }
            throw new OAIDException("IDeviceIdManager is null");
        }
    }

    public b(Context context) {
        if (context instanceof Application) {
            this.f4827a = context;
        } else {
            this.f4827a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        Context context = this.f4827a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4827a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        m.a(this.f4827a, intent, aVar, new a());
    }
}
