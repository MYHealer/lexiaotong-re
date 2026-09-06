package com.meishu.sdk.core.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.meishu.sdk.core.oaid.OAIDException;

/* JADX INFO: compiled from: LenovoImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4833a;

    /* JADX INFO: compiled from: LenovoImpl.java */
    public class a implements m.a {
        public a(h hVar) {
        }

        @Override // com.meishu.sdk.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice.a c0815a;
            int i = com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice.a.AbstractBinderC0814a.f4858a;
            if (iBinder == null) {
                c0815a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
                c0815a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice.a)) ? new com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice.a.AbstractBinderC0814a.C0815a(iBinder) : (com.meishu.sdk.core.oaid.repeackage.com.zui.deviceidservice.a) iInterfaceQueryLocalInterface;
            }
            if (c0815a == null) {
                throw new OAIDException("IDeviceidInterface is null");
            }
            if (c0815a.b()) {
                return c0815a.a();
            }
            throw new OAIDException("IDeviceidInterface#isSupport return false");
        }
    }

    public h(Context context) {
        this.f4833a = context;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        Context context = this.f4833a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4833a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        m.a(this.f4833a, intent, aVar, new a(this));
    }
}
