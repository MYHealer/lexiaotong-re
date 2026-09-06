package com.opos.mobad.d.c;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f6871a;
    private b b;

    /* JADX INFO: renamed from: com.opos.mobad.d.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0957a {
        void a();

        void b();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6872a;
        private int b;
        private InterfaceC0957a e;
        private volatile long c = -1;
        private volatile long d = -1;
        private Object f = new Object();

        public b(int i, int i2) {
            this.f6872a = i;
            this.b = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(InterfaceC0957a interfaceC0957a, boolean z) {
            if (interfaceC0957a != this.e) {
                return;
            }
            synchronized (this.f) {
                if (this.e == interfaceC0957a) {
                    this.c = -1L;
                    if (z) {
                        this.d = SystemClock.elapsedRealtime();
                    }
                    this.e = null;
                }
            }
        }

        public void a(c cVar) {
            if (cVar == null) {
                com.opos.cmn.an.f.a.b("action driver", "start but null action");
                return;
            }
            if (this.c <= 0 || this.f6872a <= SystemClock.elapsedRealtime() - this.c) {
                if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
                    synchronized (this.f) {
                        if (this.c <= 0 || this.f6872a <= SystemClock.elapsedRealtime() - this.c) {
                            if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
                                this.c = SystemClock.elapsedRealtime();
                                this.d = -1L;
                                InterfaceC0957a interfaceC0957a = new InterfaceC0957a() { // from class: com.opos.mobad.d.c.a.b.1
                                    @Override // com.opos.mobad.d.c.a.InterfaceC0957a
                                    public void a() {
                                        b.this.a(this, true);
                                    }

                                    @Override // com.opos.mobad.d.c.a.InterfaceC0957a
                                    public void b() {
                                        b.this.a(this, false);
                                    }
                                };
                                this.e = interfaceC0957a;
                                cVar.a(interfaceC0957a);
                            }
                        }
                    }
                }
            }
        }
    }

    public interface c {
        void a(InterfaceC0957a interfaceC0957a);
    }

    public a(c cVar, int i, int i2) {
        this.f6871a = cVar;
        this.b = new b(i, i2);
    }

    public void a() {
        this.b.a(this.f6871a);
    }
}
