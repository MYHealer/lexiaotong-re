package com.opos.exoplayer.core;

import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f6546a;
    private final a b;
    private final z c;
    private int d;
    private Object e;
    private Handler f;
    private int g;
    private long h = -9223372036854775807L;
    private boolean i = true;
    private boolean j;
    private boolean k;
    private boolean l;

    public interface a {
        void a(r rVar);
    }

    public interface b {
        void a(int i, Object obj);
    }

    public r(a aVar, b bVar, z zVar, int i, Handler handler) {
        this.b = aVar;
        this.f6546a = bVar;
        this.c = zVar;
        this.f = handler;
        this.g = i;
    }

    public r a(int i) {
        com.opos.exoplayer.core.i.a.b(!this.j);
        this.d = i;
        return this;
    }

    public r a(Object obj) {
        com.opos.exoplayer.core.i.a.b(!this.j);
        this.e = obj;
        return this;
    }

    public z a() {
        return this.c;
    }

    public synchronized void a(boolean z) {
        this.k = z | this.k;
        this.l = true;
        notifyAll();
    }

    public b b() {
        return this.f6546a;
    }

    public int c() {
        return this.d;
    }

    public Object d() {
        return this.e;
    }

    public Handler e() {
        return this.f;
    }

    public long f() {
        return this.h;
    }

    public int g() {
        return this.g;
    }

    public boolean h() {
        return this.i;
    }

    public r i() {
        com.opos.exoplayer.core.i.a.b(!this.j);
        if (this.h == -9223372036854775807L) {
            com.opos.exoplayer.core.i.a.a(this.i);
        }
        this.j = true;
        this.b.a(this);
        return this;
    }

    public synchronized boolean j() {
        com.opos.exoplayer.core.i.a.b(this.j);
        com.opos.exoplayer.core.i.a.b(this.f.getLooper().getThread() != Thread.currentThread());
        while (!this.l) {
            wait();
        }
        return this.k;
    }
}
