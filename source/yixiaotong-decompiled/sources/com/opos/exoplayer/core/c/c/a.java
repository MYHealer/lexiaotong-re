package com.opos.exoplayer.core.c.c;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.i;
import com.opos.exoplayer.core.c.j;
import com.opos.exoplayer.core.c.k;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.o;
import java.io.EOFException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6292a = new C0908a();
    private static final int b = y.f("Xing");
    private static final int c = y.f("Info");
    private static final int d = y.f("VBRI");
    private final int e;
    private final long f;
    private final p g;
    private final j h;
    private final i i;
    private g j;
    private n k;
    private int l;
    private Metadata m;
    private b n;
    private long o;
    private long p;
    private int q;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.c.a$a, reason: collision with other inner class name */
    static class C0908a implements h {
        C0908a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public e[] a() {
            return new e[]{new a()};
        }
    }

    interface b extends l {
        long a(long j);
    }

    public a() {
        this(0);
    }

    public a(int i) {
        this(i, -9223372036854775807L);
    }

    public a(int i, long j) {
        this.e = i;
        this.f = j;
        this.g = new p(10);
        this.h = new j();
        this.i = new i();
        this.o = -9223372036854775807L;
    }

    private static int a(p pVar, int i) {
        if (pVar.c() >= i + 4) {
            pVar.c(i);
            int iO = pVar.o();
            if (iO == b || iO == c) {
                return iO;
            }
        }
        if (pVar.c() < 40) {
            return 0;
        }
        pVar.c(36);
        int iO2 = pVar.o();
        int i2 = d;
        if (iO2 == i2) {
            return i2;
        }
        return 0;
    }

    private static boolean a(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private boolean a(f fVar, boolean z) throws o {
        int iB;
        int i;
        int iA;
        int i2 = z ? 16384 : 131072;
        fVar.a();
        if (fVar.c() == 0) {
            c(fVar);
            iB = (int) fVar.b();
            if (!z) {
                fVar.b(iB);
            }
            i = 0;
        } else {
            iB = 0;
            i = 0;
        }
        int i3 = i;
        int i4 = i3;
        while (true) {
            if (!fVar.b(this.g.f6510a, 0, 4, i > 0)) {
                break;
            }
            this.g.c(0);
            int iO = this.g.o();
            if ((i3 == 0 || a(iO, i3)) && (iA = j.a(iO)) != -1) {
                i++;
                if (i != 1) {
                    if (i == 4) {
                        break;
                    }
                } else {
                    j.a(iO, this.h);
                    i3 = iO;
                }
                fVar.c(iA - 4);
            } else {
                int i5 = i4 + 1;
                if (i4 == i2) {
                    if (z) {
                        return false;
                    }
                    throw new o("Searched too many bytes.");
                }
                if (z) {
                    fVar.a();
                    fVar.c(iB + i5);
                } else {
                    fVar.b(1);
                }
                i3 = 0;
                i4 = i5;
                i = 0;
            }
        }
        if (z) {
            fVar.b(iB + i4);
        } else {
            fVar.a();
        }
        this.l = i3;
        return true;
    }

    private int b(f fVar) {
        if (this.q == 0) {
            fVar.a();
            if (!fVar.b(this.g.f6510a, 0, 4, true)) {
                return -1;
            }
            this.g.c(0);
            int iO = this.g.o();
            if (!a(iO, this.l) || j.a(iO) == -1) {
                fVar.b(1);
                this.l = 0;
                return 0;
            }
            j.a(iO, this.h);
            if (this.o == -9223372036854775807L) {
                this.o = this.n.a(fVar.c());
                if (this.f != -9223372036854775807L) {
                    this.o += this.f - this.n.a(0L);
                }
            }
            this.q = this.h.c;
        }
        int iA = this.k.a(fVar, this.q, true);
        if (iA == -1) {
            return -1;
        }
        int i = this.q - iA;
        this.q = i;
        if (i > 0) {
            return 0;
        }
        long j = this.o;
        long j2 = this.p * 1000000;
        j jVar = this.h;
        this.k.a(j + (j2 / ((long) jVar.d)), 1, jVar.c, 0, null);
        this.p += (long) this.h.g;
        this.q = 0;
        return 0;
    }

    private void c(f fVar) {
        int i = 0;
        while (true) {
            fVar.c(this.g.f6510a, 0, 10);
            this.g.c(0);
            if (this.g.k() != com.opos.exoplayer.core.metadata.id3.a.f6535a) {
                fVar.a();
                fVar.c(i);
                return;
            }
            this.g.d(3);
            int iT = this.g.t();
            int i2 = iT + 10;
            if (this.m == null) {
                byte[] bArr = new byte[i2];
                System.arraycopy(this.g.f6510a, 0, bArr, 0, 10);
                fVar.c(bArr, 10, iT);
                Metadata metadataA = new com.opos.exoplayer.core.metadata.id3.a((this.e & 2) != 0 ? i.f6367a : null).a(bArr, i2);
                this.m = metadataA;
                if (metadataA != null) {
                    this.i.a(metadataA);
                }
            } else {
                fVar.c(iT);
            }
            i += i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
    private b d(f fVar) {
        int i;
        p pVar = new p(this.h.c);
        fVar.c(pVar.f6510a, 0, this.h.c);
        j jVar = this.h;
        int i2 = jVar.f6368a & 1;
        int i3 = jVar.e;
        if (i2 != 0) {
            if (i3 != 1) {
                i = 36;
            } else {
                i = 21;
            }
        } else if (i3 != 1) {
            i = 21;
        } else {
            i = 13;
        }
        int i4 = i;
        int iA = a(pVar, i4);
        if (iA != b && iA != c) {
            if (iA != d) {
                fVar.a();
                return null;
            }
            c cVarA = c.a(fVar.d(), fVar.c(), this.h, pVar);
            fVar.b(this.h.c);
            return cVarA;
        }
        d dVarA = d.a(fVar.d(), fVar.c(), this.h, pVar);
        if (dVarA != null && !this.i.a()) {
            fVar.a();
            fVar.c(i4 + MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID);
            fVar.c(this.g.f6510a, 0, 3);
            this.g.c(0);
            this.i.a(this.g.k());
        }
        fVar.b(this.h.c);
        return (dVarA == null || dVarA.a() || iA != c) ? dVarA : e(fVar);
    }

    private b e(f fVar) {
        fVar.c(this.g.f6510a, 0, 4);
        this.g.c(0);
        j.a(this.g.o(), this.h);
        return new com.opos.exoplayer.core.c.c.b(fVar.d(), fVar.c(), this.h);
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(f fVar, k kVar) throws o {
        if (this.l == 0) {
            try {
                a(fVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.n == null) {
            b bVarD = d(fVar);
            this.n = bVarD;
            if (bVarD == null || (!bVarD.a() && (this.e & 1) != 0)) {
                this.n = e(fVar);
            }
            this.j.a(this.n);
            n nVar = this.k;
            j jVar = this.h;
            String str = jVar.b;
            int i = jVar.e;
            int i2 = jVar.d;
            i iVar = this.i;
            nVar.a(Format.a((String) null, str, (String) null, -1, 4096, i, i2, -1, iVar.b, iVar.c, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, (this.e & 2) != 0 ? null : this.m));
        }
        return b(fVar);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.l = 0;
        this.o = -9223372036854775807L;
        this.p = 0L;
        this.q = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.j = gVar;
        this.k = gVar.a(0, 1);
        this.j.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(f fVar) {
        return a(fVar, true);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
