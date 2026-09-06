package com.opos.cmn.biz.monitor.a;

import android.os.SystemClock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f5975a;
    private int b;
    private int c;
    private InterfaceC0872a f;
    private volatile long d = -1;
    private volatile long e = -1;
    private Object g = new Object();

    /* JADX INFO: renamed from: com.opos.cmn.biz.monitor.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0872a {
        void a();

        void b();
    }

    public interface b {
        void a(InterfaceC0872a interfaceC0872a);
    }

    public a(b bVar, int i, int i2) {
        this.f5975a = bVar;
        this.b = i;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0872a interfaceC0872a) {
        if (interfaceC0872a != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == interfaceC0872a) {
                this.d = -1L;
                this.e = SystemClock.elapsedRealtime();
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
                            InterfaceC0872a interfaceC0872a = new InterfaceC0872a() { // from class: com.opos.cmn.biz.monitor.a.a.1
                                @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0872a
                                public void a() {
                                    a.this.a(this);
                                }

                                @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0872a
                                public void b() {
                                    a.this.a(this);
                                }
                            };
                            this.f = interfaceC0872a;
                            this.f5975a.a(interfaceC0872a);
                        }
                    }
                }
            }
        }
    }
}
