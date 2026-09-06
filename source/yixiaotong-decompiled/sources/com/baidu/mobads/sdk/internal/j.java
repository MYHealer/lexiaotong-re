package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public abstract class j<T> implements Runnable {
    private static final String b = "BaseTask";
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static b j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Future<T> f1815a;
    private String f;
    private long g;
    private long h;
    private long i;

    public String a() {
        return this.f;
    }

    public void a(long j2) {
        this.g = j2;
    }

    protected void a(T t) {
    }

    protected void a(Throwable th) {
    }

    public void a(Future future) {
        this.f1815a = future;
    }

    public long e() {
        return this.h - this.g;
    }

    public long f() {
        return this.i - this.g;
    }

    public long g() {
        return this.i - this.h;
    }

    protected abstract T i();

    protected void j() {
    }

    public j() {
        this.f = "default";
    }

    public j(String str) {
        this.f = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public void a(boolean z) {
        Future<T> future = this.f1815a;
        if (future != null) {
            future.cancel(z);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.f1815a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.f1815a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public j h() {
        try {
            this.h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } catch (Throwable th) {
            try {
                k().obtainMessage(2, new a(this, th)).sendToTarget();
            } finally {
                this.i = System.currentTimeMillis();
            }
        }
        return this;
    }

    private static Handler k() {
        b bVar;
        synchronized (j.class) {
            if (j == null) {
                j = new b(Looper.getMainLooper());
            }
            bVar = j;
        }
        return bVar;
    }

    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.f1816a.a(aVar.b);
            } else if (i == 2) {
                aVar.f1816a.a((Throwable) aVar.b);
            } else {
                if (i != 3) {
                    return;
                }
                aVar.f1816a.j();
            }
        }
    }

    private static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final j f1816a;
        final T b;

        a(j jVar, T t) {
            this.f1816a = jVar;
            this.b = t;
        }
    }
}
