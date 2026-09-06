package com.opos.cmn.biz.requeststatistic.cache;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f6008a;
    private int b;
    private int c;
    private volatile long d;
    private volatile long e;
    private b f;
    private Object g;

    /* JADX INFO: renamed from: com.opos.cmn.biz.requeststatistic.cache.a$a, reason: collision with other inner class name */
    class C0878a implements b {
        C0878a() {
        }

        @Override // com.opos.cmn.biz.requeststatistic.cache.a.b
        public void onFail() {
            a.this.a(this);
        }

        @Override // com.opos.cmn.biz.requeststatistic.cache.a.b
        public void onSuccess() {
            a.this.a(this);
        }
    }

    public interface b {
        void onFail();

        void onSuccess();
    }

    public interface c {
        void a(b bVar);
    }

    public a(c cVar, int i) {
        this(cVar, i, 0);
    }

    public a(c cVar, int i, int i2) {
        this.d = -1L;
        this.e = -1L;
        this.g = new Object();
        this.f6008a = cVar;
        this.b = i;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        com.opos.cmn.an.f.a.a("ActionDriver", "endActionIfRunning,is callback change=" + (bVar != this.f));
        if (bVar != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == bVar) {
                this.d = -1L;
                this.e = SystemClock.elapsedRealtime();
                this.f = null;
            }
        }
    }

    public void a() {
        if (this.d > 0 && this.b > SystemClock.elapsedRealtime() - this.d) {
            com.opos.cmn.an.f.a.a("ActionDriver", "start,doing write db!");
            return;
        }
        if (this.e > 0 && this.c > SystemClock.elapsedRealtime() - this.e) {
            com.opos.cmn.an.f.a.a("ActionDriver", "start,end no timeout!");
            return;
        }
        synchronized (this.g) {
            if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
                if (this.e <= 0 || this.c <= SystemClock.elapsedRealtime() - this.e) {
                    this.d = SystemClock.elapsedRealtime();
                    this.e = -1L;
                    C0878a c0878a = new C0878a();
                    this.f = c0878a;
                    this.f6008a.a(c0878a);
                }
            }
        }
    }
}
