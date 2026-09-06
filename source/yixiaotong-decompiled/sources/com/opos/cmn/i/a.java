package com.opos.cmn.i;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f6167a;
    private int b;
    private int c;
    private volatile long d;
    private volatile long e;
    private InterfaceC0895a f;
    private Object g;

    /* JADX INFO: renamed from: com.opos.cmn.i.a$a, reason: collision with other inner class name */
    public interface InterfaceC0895a {
        void a();

        void b();
    }

    public interface b {
        void a(InterfaceC0895a interfaceC0895a);
    }

    public a(b bVar) {
        this(bVar, Integer.MAX_VALUE, 0);
    }

    public a(b bVar, int i, int i2) {
        this.d = -1L;
        this.e = -1L;
        this.g = new Object();
        this.f6167a = bVar;
        this.b = i;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0895a interfaceC0895a, boolean z) {
        if (interfaceC0895a != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == interfaceC0895a) {
                this.d = -1L;
                if (z) {
                    this.e = SystemClock.elapsedRealtime();
                }
                this.f = null;
            }
        }
    }

    public void a() {
        if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
            if (this.e <= 0 || this.c <= SystemClock.elapsedRealtime() - this.e) {
                synchronized (this.g) {
                    if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
                        if (this.e <= 0 || this.c <= SystemClock.elapsedRealtime() - this.e) {
                            this.d = SystemClock.elapsedRealtime();
                            this.e = -1L;
                            InterfaceC0895a interfaceC0895a = new InterfaceC0895a() { // from class: com.opos.cmn.i.a.1
                                @Override // com.opos.cmn.i.a.InterfaceC0895a
                                public void a() {
                                    a.this.a(this, true);
                                }

                                @Override // com.opos.cmn.i.a.InterfaceC0895a
                                public void b() {
                                    a.this.a(this, false);
                                }
                            };
                            this.f = interfaceC0895a;
                            this.f6167a.a(interfaceC0895a);
                        }
                    }
                }
            }
        }
    }
}
