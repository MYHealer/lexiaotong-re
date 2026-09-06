package com.jg.ids;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public abstract class g extends f {
    private ServiceConnection b;

    protected abstract Intent a();

    protected abstract void a(IBinder iBinder);

    public g(Context context) {
        super(context);
        this.b = new h(this);
        if (c() && d()) {
            try {
                this.f4599a.bindService(a(), this.b, 1);
            } catch (Throwable th) {
            }
        }
    }

    protected final void b() {
        try {
            this.f4599a.unbindService(this.b);
        } catch (Throwable th) {
        }
    }
}
