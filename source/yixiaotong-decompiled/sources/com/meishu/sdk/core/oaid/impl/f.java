package com.meishu.sdk.core.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;
import com.meishu.sdk.core.oaid.OAIDException;

/* JADX INFO: compiled from: GmsImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4831a;

    /* JADX INFO: compiled from: GmsImpl.java */
    public class a implements m.a {
        public a(f fVar) {
        }

        @Override // com.meishu.sdk.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a c0809a;
            int i = com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a.AbstractBinderC0808a.f4852a;
            if (iBinder == null) {
                c0809a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAdvertisingIdService.DESCRIPTOR);
                c0809a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a)) ? new com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a.AbstractBinderC0808a.C0809a(iBinder) : (com.meishu.sdk.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a) iInterfaceQueryLocalInterface;
            }
            c0809a.a(true);
            return c0809a.c();
        }
    }

    public f(Context context) {
        this.f4831a = context;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        Context context = this.f4831a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4831a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        m.a(this.f4831a, intent, aVar, new a(this));
    }
}
