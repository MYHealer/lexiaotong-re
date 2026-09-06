package com.hihonor.id.router;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ServiceConnection f3719a;

    a(ServiceConnection serviceConnection) {
        this.f3719a = serviceConnection;
    }

    @Override // com.hihonor.id.router.e
    public final void b(final ComponentName componentName) {
        Handler handler = c.f3721a;
        final ServiceConnection serviceConnection = this.f3719a;
        handler.post(new Runnable() { // from class: com.hihonor.id.router.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                serviceConnection.onBindingDied(componentName);
            }
        });
    }

    @Override // com.hihonor.id.router.e
    public final void c(final ComponentName componentName) {
        if (Build.VERSION.SDK_INT >= 28) {
            Handler handler = c.f3721a;
            final ServiceConnection serviceConnection = this.f3719a;
            handler.post(new Runnable() { // from class: com.hihonor.id.router.a$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    serviceConnection.onNullBinding(componentName);
                }
            });
        }
    }

    @Override // com.hihonor.id.router.e
    public final void a(final ComponentName componentName, final IBinder iBinder) {
        Handler handler = c.f3721a;
        final ServiceConnection serviceConnection = this.f3719a;
        handler.post(new Runnable() { // from class: com.hihonor.id.router.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
        });
    }

    @Override // com.hihonor.id.router.e
    public final void a(final ComponentName componentName) {
        Handler handler = c.f3721a;
        final ServiceConnection serviceConnection = this.f3719a;
        handler.post(new Runnable() { // from class: com.hihonor.id.router.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                serviceConnection.onServiceDisconnected(componentName);
            }
        });
    }
}
