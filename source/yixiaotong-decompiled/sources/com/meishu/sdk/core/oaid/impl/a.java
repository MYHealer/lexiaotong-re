package com.meishu.sdk.core.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.meishu.sdk.core.oaid.OAIDException;

/* JADX INFO: compiled from: AsusImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4826a;

    /* JADX INFO: renamed from: com.meishu.sdk.core.oaid.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsusImpl.java */
    public class C0799a implements m.a {
        public C0799a(a aVar) {
        }

        @Override // com.meishu.sdk.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a c0803a;
            int i = com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a.AbstractBinderC0802a.f4846a;
            if (iBinder == null) {
                c0803a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c0803a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a)) ? new com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a.AbstractBinderC0802a.C0803a(iBinder) : (com.meishu.sdk.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a) iInterfaceQueryLocalInterface;
            }
            if (c0803a == null) {
                throw new OAIDException("IDidAidlInterface is null");
            }
            if (c0803a.b()) {
                return c0803a.a();
            }
            throw new OAIDException("IDidAidlInterface#isSupport return false");
        }
    }

    public a(Context context) {
        this.f4826a = context;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        Context context = this.f4826a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4826a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        m.a(this.f4826a, intent, aVar, new C0799a(this));
    }
}
