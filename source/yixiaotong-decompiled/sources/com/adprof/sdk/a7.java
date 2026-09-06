package com.adprof.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class a7 implements pg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b7 f1026a;

    public a7(b7 b7Var) {
        this.f1026a = b7Var;
    }

    @Override // com.adprof.sdk.pg
    public String a(IBinder iBinder) throws mg, RemoteException {
        ua saVar;
        int i = ta.f1436a;
        if (iBinder == null) {
            saVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            saVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ua)) ? new sa(iBinder) : (ua) iInterfaceQueryLocalInterface;
        }
        if (saVar != null) {
            return ((sa) saVar).a(this.f1026a.f1067a.getPackageName());
        }
        throw new mg("IDeviceIdManager is null");
    }
}
