package com.yfanads.android.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.yfanads.android.oaid.repackage.com.zui.deviceidservice.IDeviceidInterface;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: LenovoImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class i implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9665a;

    public i(Context context) {
        this.f9665a = context;
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        Context context = this.f9665a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e) {
            YFLog.debug("" + e);
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9665a != null) {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            n.a(this.f9665a, intent, aVar, new n.a() { // from class: com.yfanads.android.oaid.impl.i$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.oaid.impl.n.a
                public final String a(IBinder iBinder) {
                    return i.a(iBinder);
                }
            });
        }
    }

    public static /* synthetic */ String a(IBinder iBinder) throws com.yfanads.android.oaid.a, RemoteException {
        IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
        if (iDeviceidInterfaceAsInterface != null) {
            if (iDeviceidInterfaceAsInterface.isSupport()) {
                return iDeviceidInterfaceAsInterface.getOAID();
            }
            throw new com.yfanads.android.oaid.a("IDeviceidInterface#isSupport return false");
        }
        throw new com.yfanads.android.oaid.a("IDeviceidInterface is null");
    }
}
