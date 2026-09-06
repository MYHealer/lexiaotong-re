package com.ubix.ssp.ad.e.a0.c0.h.r.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Base64;
import android.util.Log;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.v;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements ServiceConnection {
    public Context b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ubix.ssp.ad.e.a0.c0.h.r.a.a.a.C1066a f8667a = new com.ubix.ssp.ad.e.a0.c0.h.r.a.a.a.C1066a();
    public BinderC1067b c = new BinderC1067b();
    public c d = new c();
    public CountDownLatch e = new CountDownLatch(2);

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IBinder f8668a;

        a(IBinder iBinder) {
            this.f8668a = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ubix.ssp.ad.e.a0.c0.h.r.b.a.c bVar;
            try {
                Binder.getCallingPid();
                IBinder iBinder = this.f8668a;
                if (iBinder == null) {
                    bVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                    bVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.ubix.ssp.ad.e.a0.c0.h.r.b.a.c)) ? new com.ubix.ssp.ad.e.a0.c0.h.r.b.a.b(this.f8668a) : (com.ubix.ssp.ad.e.a0.c0.h.r.b.a.c) iInterfaceQueryLocalInterface;
                }
                try {
                    u.e("AdvertisingIdPlatform", "onServiceConnected-debug4-" + bVar);
                    bVar.a(b.this.c);
                    u.e("AdvertisingIdPlatform", "onServiceConnected-debug5-");
                    bVar.b(b.this.d);
                    u.e("AdvertisingIdPlatform", "onServiceConnected-debug6-");
                } catch (Exception e) {
                    e = e;
                    u.e("AdvertisingIdPlatform", "onServiceConnected4");
                    Log.e("AdvertisingIdPlatform", "onServiceConnected error:" + e.getMessage());
                    b.this.e.countDown();
                    b.this.e.countDown();
                    b.this.a();
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.h.r.a.a.b$b, reason: collision with other inner class name */
    class BinderC1067b extends com.ubix.ssp.ad.e.a0.c0.h.r.b.a.a.AbstractBinderC1068a {
        public BinderC1067b() {
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.h.r.b.a.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.h.r.b.a.a
        public void a(int i, Bundle bundle) {
            Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode=" + i + " retInfo=" + bundle);
            if (i != 0 || bundle == null) {
                Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult error retCode=$ " + i);
            } else if (b.this.f8667a != null) {
                String string = bundle.getString("oa_id_flag");
                b.this.f8667a.f8666a = string;
                u.e("AdvertisingIdPlatform", "OAIDCallBack handleResult success " + string);
                try {
                    Context context = b.this.b;
                    Context origApplicationContext = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : com.ubix.ssp.ad.e.a0.c.e();
                    v.b(origApplicationContext, "ubix_sp_special_seed", "seed", Base64.encodeToString(string.getBytes(), 10));
                    v.a(origApplicationContext, "ubix_sp_special_seed", "seed_time", System.currentTimeMillis());
                } catch (Throwable unused) {
                }
            }
            b.this.e.countDown();
        }
    }

    class c extends com.ubix.ssp.ad.e.a0.c0.h.r.b.a.a.AbstractBinderC1068a {
        public c() {
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.h.r.b.a.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.h.r.b.a.a
        public void a(int i, Bundle bundle) {
            Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode=" + i + " retInfo= " + bundle);
            if (i != 0 || bundle == null) {
                Log.e("AdvertisingIdPlatform", "OAIDLimitCallback handleResult error retCode= " + i);
            } else if (b.this.f8667a != null) {
                boolean z = bundle.getBoolean("oa_id_limit_state");
                b.this.f8667a.b = z;
                u.e("AdvertisingIdPlatform", "OAIDLimitCallback handleResult success  isLimit=" + z);
            }
            b.this.e.countDown();
        }
    }

    public b() {
        u.e("AdvertisingIdPlatform", "HonorSC");
    }

    public final void a() {
        u.e("AdvertisingIdPlatform", "disconnect");
        try {
            this.b.unbindService(this);
        } catch (Exception e) {
            Log.e("AdvertisingIdPlatform", "OAIDClientImpl#disconnect#Disconnect error::" + e.getMessage());
        }
    }

    public boolean a(Context context) {
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
        u.e("AdvertisingIdPlatform", "onServiceConnected ");
        new Thread(new a(iBinder)).start();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        u.e("AdvertisingIdPlatform", "onServiceDisconnected ");
        this.e.countDown();
        this.e.countDown();
    }
}
