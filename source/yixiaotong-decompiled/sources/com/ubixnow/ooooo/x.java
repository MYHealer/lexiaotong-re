package com.ubixnow.ooooo;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class x implements j {
    private final Context OooO00o;

    public class OooO00o implements a0.OooO00o {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.a0.OooO00o
        public String OooO00o(IBinder iBinder) throws RemoteException, k {
            x0 x0VarOooO00o = x0.OooO0O0.OooO00o(iBinder);
            if (x0VarOooO00o == null) {
                throw new k("MsaIdInterface is null");
            }
            if (x0VarOooO00o.OooO0Oo()) {
                return x0VarOooO00o.OooO00o();
            }
            throw new k("MsaIdInterface#isSupported return false");
        }
    }

    public x(Context context) {
        this.OooO00o = context;
    }

    private void OooO0O0() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.OooO00o.getPackageName());
            this.OooO00o.startForegroundService(intent);
        } catch (Exception e) {
            l.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        OooO0O0();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.OooO00o.getPackageName());
        a0.OooO00o(this.OooO00o, intent, iVar, new OooO00o());
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        Context context = this.OooO00o;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e) {
            l.OooO00o(e);
            return false;
        }
    }
}
