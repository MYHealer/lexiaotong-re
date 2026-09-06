package com.adprof.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ea implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c3 f240a = new c3();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ca f241a = new ca(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public da f242a = new da(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CountDownLatch f243a = new CountDownLatch(2);

    public ea() {
        pk.a("AdvertisingIdPlatform", "HonorSC");
    }

    public final void a() {
        pk.a("AdvertisingIdPlatform", "disconnect");
        try {
            this.f1146a.unbindService(this);
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
        pk.a("AdvertisingIdPlatform", "onServiceConnected ");
        new Thread(new ba(this, iBinder)).start();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        pk.a("AdvertisingIdPlatform", "onServiceDisconnected ");
        this.f243a.countDown();
        this.f243a.countDown();
    }
}
