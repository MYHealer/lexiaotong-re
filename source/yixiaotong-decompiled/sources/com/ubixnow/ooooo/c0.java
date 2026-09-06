package com.ubixnow.ooooo;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c0 implements j {
    private final Context OooO00o;

    public class OooO00o implements a0.OooO00o {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.a0.OooO00o
        public String OooO00o(IBinder iBinder) throws RemoteException, k {
            t0 t0VarOooO00o = t0.OooO0O0.OooO00o(iBinder);
            if (t0VarOooO00o != null) {
                return t0VarOooO00o.OooO00o();
            }
            throw new k("IDeviceIdService is null");
        }
    }

    public c0(Context context) {
        this.OooO00o = context;
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        a0.OooO00o(this.OooO00o, intent, iVar, new OooO00o());
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        Context context = this.OooO00o;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e) {
            l.OooO00o(e);
            return false;
        }
    }
}
