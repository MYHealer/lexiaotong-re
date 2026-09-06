package com.adprof.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ud implements pg {
    public ud(vd vdVar) {
    }

    @Override // com.adprof.sdk.pg
    public String a(IBinder iBinder) throws mg, RemoteException {
        ab yaVar;
        int i = za.f1553a;
        if (iBinder == null) {
            yaVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            yaVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ab)) ? new ya(iBinder) : (ab) iInterfaceQueryLocalInterface;
        }
        if (yaVar == null) {
            throw new mg("IDeviceidInterface is null");
        }
        ya yaVar2 = (ya) yaVar;
        if (yaVar2.m730a()) {
            return yaVar2.a();
        }
        throw new mg("IDeviceidInterface#isSupport return false");
    }
}
