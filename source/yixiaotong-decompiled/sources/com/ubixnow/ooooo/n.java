package com.ubixnow.ooooo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n implements j {
    private final Context OooO00o;

    public class OooO00o implements a0.OooO00o {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.a0.OooO00o
        public String OooO00o(IBinder iBinder) throws RemoteException, k {
            q0 q0VarOooO00o = q0.OooO0O0.OooO00o(iBinder);
            if (q0VarOooO00o == null) {
                throw new k("IDidAidlInterface is null");
            }
            if (q0VarOooO00o.OooO0o()) {
                return q0VarOooO00o.OooO00o();
            }
            throw new k("IDidAidlInterface#isSupport return false");
        }
    }

    public n(Context context) {
        this.OooO00o = context;
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        a0.OooO00o(this.OooO00o, intent, iVar, new OooO00o());
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        Context context = this.OooO00o;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e) {
            l.OooO00o(e);
            return false;
        }
    }
}
