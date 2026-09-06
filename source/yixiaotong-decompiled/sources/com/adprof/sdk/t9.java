package com.adprof.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class t9 implements pg {
    public t9(u9 u9Var) {
    }

    @Override // com.adprof.sdk.pg
    public String a(IBinder iBinder) throws mg, RemoteException {
        qa oaVar;
        int i = pa.f1361a;
        if (iBinder == null) {
            oaVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAdvertisingIdService.DESCRIPTOR);
            oaVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof qa)) ? new oa(iBinder) : (qa) iInterfaceQueryLocalInterface;
        }
        oa oaVar2 = (oa) oaVar;
        oaVar2.a(true);
        return oaVar2.a();
    }
}
