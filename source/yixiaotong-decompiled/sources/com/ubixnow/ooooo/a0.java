package com.ubixnow.ooooo;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a0 implements ServiceConnection {
    private final Context OooO00o;
    private final i OooO0O0;
    private final OooO00o OooO0OO;

    @FunctionalInterface
    public interface OooO00o {
        String OooO00o(IBinder iBinder) throws RemoteException, k;
    }

    private a0(Context context, i iVar, OooO00o oooO00o) {
        this.OooO00o = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.OooO0O0 = iVar;
        this.OooO0OO = oooO00o;
    }

    public static void OooO00o(Context context, Intent intent, i iVar, OooO00o oooO00o) {
        new a0(context, iVar, oooO00o).OooO00o(intent);
    }

    private void OooO00o(Intent intent) {
        try {
            if (!this.OooO00o.bindService(intent, this, 1)) {
                throw new k("Service binding failed");
            }
            l.OooO00o("Service has been bound: " + intent);
        } catch (Exception e) {
            this.OooO0O0.OooO00o(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        l.OooO00o("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strOooO00o = this.OooO0OO.OooO00o(iBinder);
                    if (strOooO00o == null || strOooO00o.length() == 0) {
                        throw new k("OAID/AAID acquire failed");
                    }
                    l.OooO00o("OAID/AAID acquire success: " + strOooO00o);
                    this.OooO0O0.OooO00o(strOooO00o);
                    this.OooO00o.unbindService(this);
                    l.OooO00o("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    l.OooO00o(e);
                }
            } catch (Exception e2) {
                l.OooO00o(e2);
                this.OooO0O0.OooO00o(e2);
                this.OooO00o.unbindService(this);
                l.OooO00o("Service has been unbound: " + componentName.getClassName());
            }
        } catch (Throwable th) {
            try {
                this.OooO00o.unbindService(this);
                l.OooO00o("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e3) {
                l.OooO00o(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        l.OooO00o("Service has been disconnected: " + componentName.getClassName());
    }
}
