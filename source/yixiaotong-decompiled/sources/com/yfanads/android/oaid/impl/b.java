package com.yfanads.android.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;
import com.yfanads.android.oaid.repackage.com.coolpad.deviceidsupport.IDeviceIdManager;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: CoolpadImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9656a;

    public b(Context context) {
        if (context instanceof Application) {
            this.f9656a = context;
        } else {
            this.f9656a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        Context context = this.f9656a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            YFLog.debug("supported " + e);
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9656a != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            n.a(this.f9656a, intent, aVar, new n.a() { // from class: com.yfanads.android.oaid.impl.b$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.oaid.impl.n.a
                public final String a(IBinder iBinder) {
                    return this.f$0.a(iBinder);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String a(IBinder iBinder) throws com.yfanads.android.oaid.a, RemoteException {
        IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
        if (iDeviceIdManagerAsInterface != null) {
            return iDeviceIdManagerAsInterface.getOAID(this.f9656a.getPackageName());
        }
        throw new com.yfanads.android.oaid.a("IDeviceIdManager is null");
    }
}
