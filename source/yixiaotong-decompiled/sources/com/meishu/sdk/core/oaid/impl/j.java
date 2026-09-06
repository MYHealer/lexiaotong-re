package com.meishu.sdk.core.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.meishu.sdk.core.oaid.OAIDException;

/* JADX INFO: compiled from: MsaImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4835a;

    /* JADX INFO: compiled from: MsaImpl.java */
    public class a implements m.a {
        public a(j jVar) {
        }

        @Override // com.meishu.sdk.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.meishu.sdk.core.oaid.repeackage.com.bun.lib.a c0805a;
            int i = com.meishu.sdk.core.oaid.repeackage.com.bun.lib.a.AbstractBinderC0804a.f4848a;
            if (iBinder == null) {
                c0805a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
                c0805a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.meishu.sdk.core.oaid.repeackage.com.bun.lib.a)) ? new com.meishu.sdk.core.oaid.repeackage.com.bun.lib.a.AbstractBinderC0804a.C0805a(iBinder) : (com.meishu.sdk.core.oaid.repeackage.com.bun.lib.a) iInterfaceQueryLocalInterface;
            }
            if (c0805a == null) {
                throw new OAIDException("MsaIdInterface is null");
            }
            if (c0805a.d()) {
                return c0805a.a();
            }
            throw new OAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public j(Context context) {
        this.f4835a = context;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        Context context = this.f4835a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4835a == null || aVar == null) {
            return;
        }
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f4835a.getPackageName());
            this.f4835a.startForegroundService(intent);
        } catch (Exception unused) {
        }
        Intent intent2 = new Intent("com.bun.msa.action.bindto.service");
        intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent2.putExtra("com.bun.msa.param.pkgname", this.f4835a.getPackageName());
        m.a(this.f4835a, intent2, aVar, new a(this));
    }
}
