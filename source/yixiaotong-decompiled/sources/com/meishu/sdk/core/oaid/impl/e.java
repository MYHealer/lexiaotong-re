package com.meishu.sdk.core.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.meishu.sdk.core.oaid.OAIDException;

/* JADX INFO: compiled from: FreemeImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4830a;

    /* JADX INFO: compiled from: FreemeImpl.java */
    public class a implements m.a {
        public a(e eVar) {
        }

        @Override // com.meishu.sdk.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.meishu.sdk.core.oaid.repeackage.com.android.creator.a c0801a;
            int i = com.meishu.sdk.core.oaid.repeackage.com.android.creator.a.AbstractBinderC0800a.f4844a;
            if (iBinder == null) {
                c0801a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
                c0801a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.meishu.sdk.core.oaid.repeackage.com.android.creator.a)) ? new com.meishu.sdk.core.oaid.repeackage.com.android.creator.a.AbstractBinderC0800a.C0801a(iBinder) : (com.meishu.sdk.core.oaid.repeackage.com.android.creator.a) iInterfaceQueryLocalInterface;
            }
            if (c0801a != null) {
                return c0801a.a();
            }
            throw new OAIDException("IdsSupplier is null");
        }
    }

    public e(Context context) {
        this.f4830a = context;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        Context context = this.f4830a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4830a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        m.a(this.f4830a, intent, aVar, new a(this));
    }
}
