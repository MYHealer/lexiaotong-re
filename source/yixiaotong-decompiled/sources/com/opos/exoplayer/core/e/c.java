package com.opos.exoplayer.core.e;

import android.net.Uri;
import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c implements e, o.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f6389a;
    private final com.opos.exoplayer.core.h.g.a b;
    private final com.opos.exoplayer.core.c.h c;
    private final int d;
    private final f.a e;
    private final String f;
    private final int g;
    private e.a h;
    private long i;
    private boolean j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.exoplayer.core.h.g.a f6390a;
        private com.opos.exoplayer.core.c.h b;
        private String c;
        private int d = -1;
        private int e = 1048576;
        private boolean f;

        public a(com.opos.exoplayer.core.h.g.a aVar) {
            this.f6390a = aVar;
        }

        public c a(Uri uri) {
            return a(uri, null, null);
        }

        public c a(Uri uri, Handler handler, f fVar) {
            this.f = true;
            if (this.b == null) {
                this.b = new com.opos.exoplayer.core.c.c();
            }
            return new c(uri, this.f6390a, this.b, this.d, handler, fVar, this.c, this.e, null);
        }
    }

    static /* synthetic */ class b {
    }

    private c(Uri uri, com.opos.exoplayer.core.h.g.a aVar, com.opos.exoplayer.core.c.h hVar, int i, Handler handler, f fVar, String str, int i2) {
        this.f6389a = uri;
        this.b = aVar;
        this.c = hVar;
        this.d = i;
        this.e = new f.a(handler, fVar);
        this.f = str;
        this.g = i2;
    }

    /* synthetic */ c(Uri uri, com.opos.exoplayer.core.h.g.a aVar, com.opos.exoplayer.core.c.h hVar, int i, Handler handler, f fVar, String str, int i2, b bVar) {
        this(uri, aVar, hVar, i, handler, fVar, str, i2);
    }

    private void b(long j, boolean z) {
        this.i = j;
        this.j = z;
        this.h.a(this, new k(this.i, this.j, false), null);
    }

    @Override // com.opos.exoplayer.core.e.e
    public d a(e.b bVar, com.opos.exoplayer.core.h.b bVar2) {
        com.opos.exoplayer.core.i.a.a(bVar.f6391a == 0);
        return new o(this.f6389a, this.b.a(), this.c.a(), this.d, this.e, this, bVar2, this.f, this.g);
    }

    @Override // com.opos.exoplayer.core.e.e
    public void a() {
    }

    @Override // com.opos.exoplayer.core.e.o.e
    public void a(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.i;
        }
        if (this.i == j && this.j == z) {
            return;
        }
        b(j, z);
    }

    @Override // com.opos.exoplayer.core.e.e
    public void a(d dVar) {
        ((o) dVar).f();
    }

    @Override // com.opos.exoplayer.core.e.e
    public void a(com.opos.exoplayer.core.i iVar, boolean z, e.a aVar) {
        this.h = aVar;
        b(-9223372036854775807L, false);
    }

    @Override // com.opos.exoplayer.core.e.e
    public void b() {
        this.h = null;
    }
}
