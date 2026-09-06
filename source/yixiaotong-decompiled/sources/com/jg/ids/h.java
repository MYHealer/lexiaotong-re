package com.jg.ids;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
final class h implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ g f4602a;

    h(g gVar) {
        this.f4602a = gVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f4602a.a(iBinder);
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
