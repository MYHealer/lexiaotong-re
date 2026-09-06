package com.opos.exoplayer.core.c.a;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class e extends b {
    private final p b;
    private final p c;
    private int d;
    private boolean e;
    private int f;

    public e(n nVar) {
        super(nVar);
        this.b = new p(com.opos.exoplayer.core.i.n.f6506a);
        this.c = new p(4);
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected boolean a(p pVar) throws b.a {
        int iG = pVar.g();
        int i = (iG >> 4) & 15;
        int i2 = iG & 15;
        if (i2 != 7) {
            throw new b.a("Video format not supported: " + i2);
        }
        this.f = i;
        return i != 5;
    }

    @Override // com.opos.exoplayer.core.c.a.b
    protected void b(p pVar, long j) throws o {
        int iG = pVar.g();
        long jL = j + (((long) pVar.l()) * 1000);
        if (iG == 0 && !this.e) {
            p pVar2 = new p(new byte[pVar.b()]);
            pVar.a(pVar2.f6510a, 0, pVar.b());
            com.opos.exoplayer.core.video.a aVarA = com.opos.exoplayer.core.video.a.a(pVar2);
            this.d = aVarA.b;
            this.f6281a.a(Format.a((String) null, MimeTypes.VIDEO_H264, (String) null, -1, -1, aVarA.c, aVarA.d, -1.0f, aVarA.f6551a, -1, aVarA.e, (DrmInitData) null));
            this.e = true;
            return;
        }
        if (iG == 1 && this.e) {
            byte[] bArr = this.c.f6510a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.d;
            int i2 = 0;
            while (pVar.b() > 0) {
                pVar.a(this.c.f6510a, i, this.d);
                this.c.c(0);
                int iU = this.c.u();
                this.b.c(0);
                this.f6281a.a(this.b, 4);
                this.f6281a.a(pVar, iU);
                i2 = i2 + 4 + iU;
            }
            this.f6281a.a(jL, this.f == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
