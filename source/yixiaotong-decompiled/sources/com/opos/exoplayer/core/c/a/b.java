package com.opos.exoplayer.core.c.a;

import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final n f6281a;

    public static final class a extends o {
        public a(String str) {
            super(str);
        }

        @Override // com.opos.exoplayer.core.o, com.opos.exoplayer.core.i.c
        public String a() {
            return "UnsupportedFormatException";
        }
    }

    protected b(n nVar) {
        this.f6281a = nVar;
    }

    public final void a(p pVar, long j) {
        if (a(pVar)) {
            b(pVar, j);
        }
    }

    protected abstract boolean a(p pVar);

    protected abstract void b(p pVar, long j);
}
