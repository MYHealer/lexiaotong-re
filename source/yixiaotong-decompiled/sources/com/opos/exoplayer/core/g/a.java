package com.opos.exoplayer.core.g;

import com.google.android.exoplayer2.ExoPlayer;
import com.opos.exoplayer.core.e.l;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends b {
    private final com.opos.exoplayer.core.h.d d;
    private final int e;
    private final long f;
    private final long g;
    private final long h;
    private final float i;
    private final float j;
    private final long k;
    private final com.opos.exoplayer.core.i.e l;
    private float m;
    private int n;
    private int o;
    private long p;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.g.a$a, reason: collision with other inner class name */
    public static final class C0926a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.exoplayer.core.h.d f6465a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final float f;
        private final float g;
        private final long h;
        private final com.opos.exoplayer.core.i.e i;

        public C0926a(com.opos.exoplayer.core.h.d dVar) {
            this(dVar, 800000, 10000, 25000, 25000, 0.75f, 0.75f, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, com.opos.exoplayer.core.i.e.f6500a);
        }

        public C0926a(com.opos.exoplayer.core.h.d dVar, int i, int i2, int i3, int i4, float f, float f2, long j, com.opos.exoplayer.core.i.e eVar) {
            this.f6465a = dVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = f;
            this.g = f2;
            this.h = j;
            this.i = eVar;
        }

        @Override // com.opos.exoplayer.core.g.f.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b(l lVar, int... iArr) {
            return new a(lVar, iArr, this.f6465a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
    }

    public a(l lVar, int[] iArr, com.opos.exoplayer.core.h.d dVar, int i, long j, long j2, long j3, float f, float f2, long j4, com.opos.exoplayer.core.i.e eVar) {
        super(lVar, iArr);
        this.d = dVar;
        this.e = i;
        this.f = j * 1000;
        this.g = j2 * 1000;
        this.h = j3 * 1000;
        this.i = f;
        this.j = f2;
        this.k = j4;
        this.l = eVar;
        this.m = 1.0f;
        this.n = a(Long.MIN_VALUE);
        this.o = 1;
        this.p = -9223372036854775807L;
    }

    private int a(long j) {
        long jA = this.d.a();
        long j2 = jA == -1 ? this.e : (long) (jA * this.i);
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            if (j == Long.MIN_VALUE || !a(i2, j)) {
                if (Math.round(a(i2).b * this.m) <= j2) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    @Override // com.opos.exoplayer.core.g.b, com.opos.exoplayer.core.g.f
    public void a() {
        this.p = -9223372036854775807L;
    }

    @Override // com.opos.exoplayer.core.g.b, com.opos.exoplayer.core.g.f
    public void a(float f) {
        this.m = f;
    }

    @Override // com.opos.exoplayer.core.g.f
    public int b() {
        return this.n;
    }
}
