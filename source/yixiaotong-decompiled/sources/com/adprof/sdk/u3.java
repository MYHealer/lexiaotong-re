package com.adprof.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class u3 implements pg {
    public u3(v3 v3Var) {
    }

    @Override // com.adprof.sdk.pg
    public String a(IBinder iBinder) throws mg, RemoteException {
        db bbVar;
        int i = cb.f1107a;
        if (iBinder == null) {
            bbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            bbVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof db)) ? new bb(iBinder) : (db) iInterfaceQueryLocalInterface;
        }
        if (bbVar == null) {
            throw new mg("IDidAidlInterface is null");
        }
        bb bbVar2 = (bb) bbVar;
        if (bbVar2.m585a()) {
            return bbVar2.a();
        }
        throw new mg("IDidAidlInterface#isSupport return false");
    }
}
