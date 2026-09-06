package com.adprof.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class bl implements pg {
    public bl(cl clVar) {
    }

    @Override // com.adprof.sdk.pg
    public String a(IBinder iBinder) throws mg, RemoteException {
        xa vaVar;
        int i = wa.f1496a;
        if (iBinder == null) {
            vaVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            vaVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof xa)) ? new va(iBinder) : (xa) iInterfaceQueryLocalInterface;
        }
        if (vaVar != null) {
            return ((va) vaVar).a();
        }
        throw new mg("IDeviceIdService is null");
    }
}
