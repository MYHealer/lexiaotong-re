package com.adprof.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class l9 implements pg {
    public l9(m9 m9Var) {
    }

    @Override // com.adprof.sdk.pg
    public String a(IBinder iBinder) throws mg, RemoteException {
        qb obVar;
        int i = pb.f1362a;
        if (iBinder == null) {
            obVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
            obVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qb)) ? new ob(iBinder) : (qb) iInterfaceQueryLocalInterface;
        }
        if (obVar != null) {
            return ((ob) obVar).a();
        }
        throw new mg("IdsSupplier is null");
    }
}
