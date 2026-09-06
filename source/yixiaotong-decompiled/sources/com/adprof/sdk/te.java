package com.adprof.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class te implements pg {
    public te(ue ueVar) {
    }

    @Override // com.adprof.sdk.pg
    public String a(IBinder iBinder) throws mg, RemoteException {
        se qeVar;
        int i = re.f1403a;
        if (iBinder == null) {
            qeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            qeVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof se)) ? new qe(iBinder) : (se) iInterfaceQueryLocalInterface;
        }
        if (qeVar == null) {
            throw new mg("MsaIdInterface is null");
        }
        qe qeVar2 = (qe) qeVar;
        if (qeVar2.m712a()) {
            return qeVar2.a();
        }
        throw new mg("MsaIdInterface#isSupported return false");
    }
}
