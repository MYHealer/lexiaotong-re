package com.opos.exoplayer.core.c.f;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class l implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.i.p f6348a = new com.opos.exoplayer.core.i.p(10);
    private com.opos.exoplayer.core.c.n b;
    private boolean c;
    private long d;
    private int e;
    private int f;

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.c = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        if (z) {
            this.c = true;
            this.d = j;
            this.e = 0;
            this.f = 0;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        com.opos.exoplayer.core.c.n nVarA = gVar.a(dVar.b(), 4);
        this.b = nVarA;
        nVarA.a(Format.a(dVar.c(), MimeTypes.APPLICATION_ID3, (String) null, -1, (DrmInitData) null));
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.p pVar) {
        if (this.c) {
            int iB = pVar.b();
            int i = this.f;
            if (i < 10) {
                int iMin = Math.min(iB, 10 - i);
                System.arraycopy(pVar.f6510a, pVar.d(), this.f6348a.f6510a, this.f, iMin);
                if (this.f + iMin == 10) {
                    this.f6348a.c(0);
                    if (73 != this.f6348a.g() || 68 != this.f6348a.g() || 51 != this.f6348a.g()) {
                        com.opos.cmn.an.f.a.c("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.f6348a.d(3);
                        this.e = this.f6348a.t() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iB, this.e - this.f);
            this.b.a(pVar, iMin2);
            this.f += iMin2;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
        int i;
        if (this.c && (i = this.e) != 0 && this.f == i) {
            this.b.a(this.d, 1, i, 0, null);
            this.c = false;
        }
    }
}
