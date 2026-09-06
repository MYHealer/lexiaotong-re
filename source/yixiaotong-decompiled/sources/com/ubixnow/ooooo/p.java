package com.ubixnow.ooooo;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class p implements j {
    private final Context OooO00o;

    public class OooO00o implements a0.OooO00o {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.a0.OooO00o
        public String OooO00o(IBinder iBinder) throws RemoteException, k {
            v0 v0VarOooO00o = v0.OooO0O0.OooO00o(iBinder);
            if (v0VarOooO00o != null) {
                return v0VarOooO00o.OooO0o(p.this.OooO00o.getPackageName());
            }
            throw new k("IDeviceIdManager is null");
        }
    }

    public p(Context context) {
        this.OooO00o = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        a0.OooO00o(this.OooO00o, intent, iVar, new OooO00o());
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        Context context = this.OooO00o;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            l.OooO00o(e);
            return false;
        }
    }
}
