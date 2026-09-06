package com.adprof.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ja implements pg {
    public ja(ka kaVar) {
    }

    @Override // com.adprof.sdk.pg
    public String a(IBinder iBinder) throws mg, RemoteException {
        bh zgVar;
        int i = ah.f1033a;
        if (iBinder == null) {
            zgVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            zgVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof bh)) ? new zg(iBinder) : (bh) iInterfaceQueryLocalInterface;
        }
        zg zgVar2 = (zg) zgVar;
        if (zgVar2.m738a()) {
            throw new mg("User has disabled advertising identifier");
        }
        return zgVar2.a();
    }
}
