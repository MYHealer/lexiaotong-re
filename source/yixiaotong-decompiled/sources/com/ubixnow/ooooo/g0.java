package com.ubixnow.ooooo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g0 implements ServiceConnection {
    public Context OooO0O0;
    public f0.OooO00o OooO00o = new f0.OooO00o();
    public OooO0O0 OooO0OO = new OooO0O0();
    public OooO0OO OooO0Oo = new OooO0OO();
    public CountDownLatch OooO0o0 = new CountDownLatch(2);

    public class OooO00o implements Runnable {
        public final /* synthetic */ IBinder OooO00o;

        public OooO00o(IBinder iBinder) {
            this.OooO00o = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            i0 c1137OooO00o;
            try {
                Binder.getCallingPid();
                IBinder iBinder = this.OooO00o;
                if (iBinder == null) {
                    c1137OooO00o = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                    c1137OooO00o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof i0)) ? new i0.OooO00o.C1137OooO00o(this.OooO00o) : (i0) iInterfaceQueryLocalInterface;
                }
                c1137OooO00o.OooO00o(g0.this.OooO0OO);
                c1137OooO00o.OooO0O0(g0.this.OooO0Oo);
            } catch (Exception e) {
                Log.e("AdvertisingIdPlatform", "onServiceConnected error:" + e.getMessage());
                g0.this.OooO0o0.countDown();
                g0.this.OooO0o0.countDown();
                g0.this.OooO00o();
            }
        }
    }

    public class OooO0O0 extends h0.OooO00o {
        public OooO0O0() {
        }

        @Override // com.ubixnow.ooooo.h0
        public void OooO00o(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.ubixnow.ooooo.h0
        public void OooO00o(int i, Bundle bundle) {
            Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode=" + i + " retInfo=" + bundle);
            if (i != 0 || bundle == null) {
                Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult error retCode=$ " + i);
            } else if (g0.this.OooO00o != null) {
                String string = bundle.getString("oa_id_flag");
                g0.this.OooO00o.OooO00o = string;
                try {
                    oOo00o00.OooO00o("oaid", string);
                } catch (Throwable unused) {
                }
            }
            g0.this.OooO0o0.countDown();
        }
    }

    public class OooO0OO extends h0.OooO00o {
        public OooO0OO() {
        }

        @Override // com.ubixnow.ooooo.h0
        public void OooO00o(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.ubixnow.ooooo.h0
        public void OooO00o(int i, Bundle bundle) {
            Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode=" + i + " retInfo= " + bundle);
            if (i != 0 || bundle == null) {
                Log.e("AdvertisingIdPlatform", "OAIDLimitCallback handleResult error retCode= " + i);
            } else if (g0.this.OooO00o != null) {
                g0.this.OooO00o.OooO0O0 = bundle.getBoolean("oa_id_limit_state");
            }
            g0.this.OooO0o0.countDown();
        }
    }

    public final void OooO00o() {
        try {
            this.OooO0O0.unbindService(this);
        } catch (Exception e) {
            Log.e("AdvertisingIdPlatform", "OAIDClientImpl#disconnect#Disconnect error::" + e.getMessage());
        }
    }

    public boolean OooO00o(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.hihonor.id", 0);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new Thread(new OooO00o(iBinder)).start();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.OooO0o0.countDown();
        this.OooO0o0.countDown();
    }
}
