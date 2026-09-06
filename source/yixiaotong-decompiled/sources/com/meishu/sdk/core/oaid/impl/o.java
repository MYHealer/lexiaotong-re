package com.meishu.sdk.core.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.meishu.sdk.core.oaid.OAIDException;

/* JADX INFO: compiled from: SamsungImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4841a;

    /* JADX INFO: compiled from: SamsungImpl.java */
    public class a implements m.a {
        public a(o oVar) {
        }

        @Override // com.meishu.sdk.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.meishu.sdk.core.oaid.repeackage.com.samsung.android.deviceidservice.a c0813a;
            int i = com.meishu.sdk.core.oaid.repeackage.com.samsung.android.deviceidservice.a.AbstractBinderC0812a.f4856a;
            if (iBinder == null) {
                c0813a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                c0813a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.meishu.sdk.core.oaid.repeackage.com.samsung.android.deviceidservice.a)) ? new com.meishu.sdk.core.oaid.repeackage.com.samsung.android.deviceidservice.a.AbstractBinderC0812a.C0813a(iBinder) : (com.meishu.sdk.core.oaid.repeackage.com.samsung.android.deviceidservice.a) iInterfaceQueryLocalInterface;
            }
            if (c0813a != null) {
                return c0813a.a();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public o(Context context) {
        this.f4841a = context;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        Context context = this.f4841a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4841a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        m.a(this.f4841a, intent, aVar, new a(this));
    }
}
