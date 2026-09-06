package com.opos.cmn.func.dl.base.g;

import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.exception.DlException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.libs.a.a f6141a;
    private b b;
    private DownloadRequest c;
    private DownloadResponse d = new DownloadResponse();
    private com.opos.cmn.func.dl.base.a.b e;

    public a(com.opos.cmn.func.dl.base.a.b bVar, b bVar2) {
        this.e = bVar;
        this.c = bVar.q;
        this.b = bVar2;
        com.opos.libs.a.a.C0933a c0933aA = new com.opos.libs.a.a.C0933a(0).a(0, 1).a(1, 2, 7, 4).a(2, 3, 4, 5).a(3, 4, 5, 6, 7).a(4, 1, 5);
        if (bVar.o) {
            c0933aA.a(7, 1, 5, 4);
        }
        this.f6141a = c0933aA.a();
    }

    private synchronized boolean a(int i) {
        boolean z;
        int iA = a();
        z = i == this.f6141a.a(i) && i != iA;
        com.opos.cmn.an.f.a.a("StatusController", "Change state:" + iA + "to " + i + ",result:" + z);
        return z;
    }

    private void i() {
        this.d.f6100a = a();
        this.d.d = this.e.k;
        this.d.b = this.e.l;
        this.d.c = this.e.s.get();
        this.d.e = a() == 3 ? this.d.e : 0L;
    }

    public final synchronized int a() {
        return this.f6141a.a();
    }

    public final synchronized void a(long j) {
        if (a() == 3) {
            i();
            this.d.e = j;
            this.b.c(this.c, this.d);
        }
    }

    public final synchronized void a(DlException dlException) {
        if (a(7)) {
            if (!this.e.m) {
                this.e.l = 0L;
                this.e.a(0L);
            }
            i();
            this.b.a(this.c, this.d, dlException);
        }
    }

    public final synchronized boolean b() {
        int iA = a();
        return (iA == 5 || iA == 4) ? false : true;
    }

    public final synchronized boolean c() {
        return a(1);
    }

    public final synchronized boolean d() {
        if (!a(2)) {
            return false;
        }
        i();
        this.b.a(this.c, this.d);
        return true;
    }

    public final synchronized boolean e() {
        if (!a(3)) {
            return false;
        }
        i();
        this.b.b(this.c, this.d);
        return true;
    }

    public final synchronized boolean f() {
        if (!a(4)) {
            return false;
        }
        if (!this.e.m) {
            this.e.l = 0L;
            this.e.a(0L);
        }
        i();
        this.b.d(this.c, this.d);
        return true;
    }

    public final synchronized boolean g() {
        if (!a(5)) {
            return false;
        }
        i();
        this.b.e(this.c, this.d);
        return true;
    }

    public final synchronized void h() {
        if (a(6)) {
            if (this.e.k == -1) {
                com.opos.cmn.func.dl.base.a.b bVar = this.e;
                bVar.k = bVar.s.get();
            }
            i();
            this.b.f(this.c, this.d);
        }
    }
}
