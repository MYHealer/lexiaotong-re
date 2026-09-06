package com.hihonor.id.router;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Executor f3720a;
    final /* synthetic */ ServiceConnection b;

    b(Executor executor, ServiceConnection serviceConnection) {
        this.f3720a = executor;
        this.b = serviceConnection;
    }

    @Override // com.hihonor.id.router.e
    public final void b(final ComponentName componentName) {
        Executor executor = this.f3720a;
        final ServiceConnection serviceConnection = this.b;
        executor.execute(new Runnable() { // from class: com.hihonor.id.router.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                serviceConnection.onBindingDied(componentName);
            }
        });
    }

    @Override // com.hihonor.id.router.e
    public final void c(final ComponentName componentName) {
        if (Build.VERSION.SDK_INT >= 28) {
            Executor executor = this.f3720a;
            final ServiceConnection serviceConnection = this.b;
            executor.execute(new Runnable() { // from class: com.hihonor.id.router.b$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    serviceConnection.onNullBinding(componentName);
                }
            });
        }
    }

    @Override // com.hihonor.id.router.e
    public final void a(final ComponentName componentName, final IBinder iBinder) {
        Executor executor = this.f3720a;
        final ServiceConnection serviceConnection = this.b;
        executor.execute(new Runnable() { // from class: com.hihonor.id.router.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
        });
    }

    @Override // com.hihonor.id.router.e
    public final void a(final ComponentName componentName) {
        Executor executor = this.f3720a;
        final ServiceConnection serviceConnection = this.b;
        executor.execute(new Runnable() { // from class: com.hihonor.id.router.b$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                serviceConnection.onServiceDisconnected(componentName);
            }
        });
    }
}
