package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.o;
import java.io.EOFException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class f {
    private static final int h = y.f("OggS");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6327a;
    public int b;
    public long c;
    public int d;
    public int e;
    public int f;
    public final int[] g = new int[255];
    private final p i = new p(255);

    f() {
    }

    public void a() {
        this.f6327a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public boolean a(com.opos.exoplayer.core.c.f fVar, boolean z) throws o, EOFException {
        this.i.a();
        a();
        if ((fVar.d() != -1 && fVar.d() - fVar.b() < 27) || !fVar.b(this.i.f6510a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        }
        if (this.i.m() != h) {
            if (z) {
                return false;
            }
            throw new o("expected OggS capture pattern at begin of page");
        }
        int iG = this.i.g();
        this.f6327a = iG;
        if (iG != 0) {
            if (z) {
                return false;
            }
            throw new o("unsupported bit stream revision");
        }
        this.b = this.i.g();
        this.c = this.i.r();
        this.i.n();
        this.i.n();
        this.i.n();
        int iG2 = this.i.g();
        this.d = iG2;
        this.e = iG2 + 27;
        this.i.a();
        fVar.c(this.i.f6510a, 0, this.d);
        for (int i = 0; i < this.d; i++) {
            this.g[i] = this.i.g();
            this.f += this.g[i];
        }
        return true;
    }
}
