package com.opos.exoplayer.core.c.f;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<u.a> f6340a;
    private final com.opos.exoplayer.core.c.n[] b;
    private boolean c;
    private int d;
    private int e;
    private long f;

    public g(List<u.a> list) {
        this.f6340a = list;
        this.b = new com.opos.exoplayer.core.c.n[list.size()];
    }

    private boolean a(com.opos.exoplayer.core.i.p pVar, int i) {
        if (pVar.b() == 0) {
            return false;
        }
        if (pVar.g() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.c = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        if (z) {
            this.c = true;
            this.f = j;
            this.e = 0;
            this.d = 2;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            u.a aVar = this.f6340a.get(i);
            dVar.a();
            com.opos.exoplayer.core.c.n nVarA = gVar.a(dVar.b(), 3);
            nVarA.a(Format.a(dVar.c(), MimeTypes.APPLICATION_DVBSUBS, (String) null, -1, 0, (List<byte[]>) Collections.singletonList(aVar.c), aVar.f6359a, (DrmInitData) null));
            this.b[i] = nVarA;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.p pVar) {
        if (this.c) {
            if (this.d != 2 || a(pVar, 32)) {
                if (this.d != 1 || a(pVar, 0)) {
                    int iD = pVar.d();
                    int iB = pVar.b();
                    for (com.opos.exoplayer.core.c.n nVar : this.b) {
                        pVar.c(iD);
                        nVar.a(pVar, iB);
                    }
                    this.e += iB;
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
        if (this.c) {
            for (com.opos.exoplayer.core.c.n nVar : this.b) {
                nVar.a(this.f, 1, this.e, 0, null);
            }
            this.c = false;
        }
    }
}
