package com.opos.exoplayer.core.c.f;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class s implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.exoplayer.core.i.w f6355a;
    private com.opos.exoplayer.core.c.n b;
    private boolean c;

    @Override // com.opos.exoplayer.core.c.f.q
    public void a(com.opos.exoplayer.core.i.p pVar) {
        if (!this.c) {
            if (this.f6355a.c() == -9223372036854775807L) {
                return;
            }
            this.b.a(Format.a((String) null, MimeTypes.APPLICATION_SCTE35, this.f6355a.c()));
            this.c = true;
        }
        int iB = pVar.b();
        this.b.a(pVar, iB);
        this.b.a(this.f6355a.b(), 1, iB, 0, null);
    }

    @Override // com.opos.exoplayer.core.c.f.q
    public void a(com.opos.exoplayer.core.i.w wVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        this.f6355a = wVar;
        dVar.a();
        com.opos.exoplayer.core.c.n nVarA = gVar.a(dVar.b(), 4);
        this.b = nVarA;
        nVarA.a(Format.a(dVar.c(), MimeTypes.APPLICATION_SCTE35, (String) null, -1, (DrmInitData) null));
    }
}
