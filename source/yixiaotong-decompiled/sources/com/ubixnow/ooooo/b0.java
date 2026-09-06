package com.ubixnow.ooooo;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b0 implements j {
    private final Context OooO00o;
    private String OooO0O0;

    public class OooO00o implements a0.OooO00o {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.a0.OooO00o
        public String OooO00o(IBinder iBinder) throws RemoteException, k {
            try {
                return b0.this.OooO00o(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (k e2) {
                throw e2;
            } catch (Exception e3) {
                throw new k(e3);
            }
        }
    }

    public b0(Context context) {
        this.OooO00o = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String OooO00o(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, k {
        String packageName = this.OooO00o.getPackageName();
        String str = this.OooO0O0;
        if (str != null) {
            return OooO00o(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.OooO00o.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.OooO0O0 = string;
        return OooO00o(iBinder, packageName, string);
    }

    private String OooO00o(IBinder iBinder, String str, String str2) throws RemoteException, k {
        y0 y0VarOooO00o = y0.OooO0O0.OooO00o(iBinder);
        if (y0VarOooO00o != null) {
            return y0VarOooO00o.OooO00o(str, str2, "OUID");
        }
        throw new k("IOpenID is null");
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        a0.OooO00o(this.OooO00o, intent, iVar, new OooO00o());
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        Context context = this.OooO00o;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            l.OooO00o(e);
            return false;
        }
    }
}
