package com.jg.ids;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public abstract class a extends f {
    private static Handler b = new Handler(Looper.getMainLooper());
    private Handler c;
    private HandlerThread d;

    protected abstract void a(Message message);

    protected abstract void b();

    public a(Context context, String str) {
        super(context);
        this.c = null;
        this.d = null;
        try {
            this.d = new HandlerThread(str);
            this.d.start();
            this.c = new b(this, this.d.getLooper());
            if (c() && d()) {
                b();
            }
        } catch (Throwable th) {
        }
    }

    protected final void b(Message message) {
        this.c.sendMessage(message);
    }

    protected final Message a() {
        return this.c.obtainMessage();
    }

    protected static void a(Runnable runnable) {
        b.post(runnable);
    }

    protected void a(int i, String str) {
        switch (i) {
            case 0:
                a(new c(this, str));
                break;
            case 1:
                a(new d(this, str));
                break;
            case 2:
                a(new e(this, str));
                break;
        }
    }
}
