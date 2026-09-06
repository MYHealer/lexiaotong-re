package com.hihonor.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdvertisingIdClient.Info f3492a;
    public Context b;
    public final BinderC0423a c = new BinderC0423a();
    public final b d = new b();
    public final CountDownLatch e = new CountDownLatch(2);

    /* JADX INFO: renamed from: com.hihonor.ads.identifier.a$a, reason: collision with other inner class name */
    public class BinderC0423a extends com.hihonor.cloudservice.oaid.a.AbstractBinderC0473a {
        public BinderC0423a() {
        }

        @Override // com.hihonor.cloudservice.oaid.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.hihonor.cloudservice.oaid.a
        public void a(int i, Bundle bundle) {
            Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode = " + i + " retInfo = " + bundle);
            try {
                if (i == 0) {
                    try {
                        AdvertisingIdClient.Info info = a.this.f3492a;
                        if (info != null) {
                            info.id = bundle.getString("oa_id_flag");
                            Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult success");
                        }
                    } catch (Exception e) {
                        Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult error: " + e.getMessage());
                    }
                }
            } finally {
                a.a(a.this);
            }
        }
    }

    public class b extends com.hihonor.cloudservice.oaid.a.AbstractBinderC0473a {
        public b() {
        }

        @Override // com.hihonor.cloudservice.oaid.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.hihonor.cloudservice.oaid.a
        public void a(int i, Bundle bundle) {
            Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult retCode=" + i + " retInfo= " + bundle);
            if (i == 0) {
                try {
                    try {
                        if (a.this.f3492a != null) {
                            boolean z = bundle.getBoolean("oa_id_limit_state");
                            a.this.f3492a.isLimit = z;
                            Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult success  isLimit=" + z);
                        }
                    } catch (Exception e) {
                        Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult error:  " + e.getMessage());
                    }
                } finally {
                    a.a(a.this);
                }
            }
        }
    }

    public static void a(a aVar) {
        aVar.getClass();
        try {
            aVar.e.countDown();
        } catch (Exception e) {
            Log.i("AdvertisingIdPlatform", "doCountDown  error:  " + e.getMessage());
        }
    }

    public final void a() {
        Log.i("AdvertisingIdPlatform", "release");
        try {
            this.e.countDown();
            this.e.countDown();
        } catch (Exception e) {
            Log.e("AdvertisingIdPlatform", "release error=" + e.getMessage() + " : " + e.getClass().getSimpleName());
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
}
