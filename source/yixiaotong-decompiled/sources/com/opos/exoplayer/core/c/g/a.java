package com.opos.exoplayer.core.c.g;

import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.k;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.o;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6364a = new C0914a();
    private g b;
    private n c;
    private b d;
    private int e;
    private int f;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.g.a$a, reason: collision with other inner class name */
    static class C0914a implements h {
        C0914a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public e[] a() {
            return new e[]{new a()};
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(f fVar, k kVar) throws o {
        if (this.d == null) {
            b bVarA = c.a(fVar);
            this.d = bVarA;
            if (bVarA == null) {
                throw new o("Unsupported or unrecognized wav header.");
            }
            this.c.a(Format.a((String) null, MimeTypes.AUDIO_RAW, (String) null, bVarA.e(), 32768, this.d.g(), this.d.f(), this.d.h(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            this.e = this.d.d();
        }
        if (!this.d.c()) {
            c.a(fVar, this.d);
            this.b.a(this.d);
        }
        int iA = this.c.a(fVar, 32768 - this.f, true);
        if (iA != -1) {
            this.f += iA;
        }
        int i = this.f / this.e;
        if (i > 0) {
            long jA = this.d.a(fVar.c() - ((long) this.f));
            int i2 = i * this.e;
            int i3 = this.f - i2;
            this.f = i3;
            this.c.a(jA, 1, i2, i3, null);
        }
        return iA == -1 ? -1 : 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.f = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.b = gVar;
        this.c = gVar.a(0, 1);
        this.d = null;
        gVar.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(f fVar) {
        return c.a(fVar) != null;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
