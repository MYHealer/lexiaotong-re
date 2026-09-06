package com.jg.ids.i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public abstract class b extends Binder implements a {
    public static a a(IBinder iBinder) {
        a cVar;
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) {
                cVar = new c(iBinder);
            } else {
                cVar = (a) iInterfaceQueryLocalInterface;
            }
            return cVar;
        } catch (Throwable th) {
            return null;
        }
    }
}
