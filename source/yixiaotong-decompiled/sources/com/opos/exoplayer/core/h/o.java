package com.opos.exoplayer.core.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class o extends q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6489a;
    private final t<? super g> b;
    private final int c;
    private final int d;
    private final boolean e;

    public o(String str, t<? super g> tVar) {
        this(str, tVar, 8000, 8000, false);
    }

    public o(String str, t<? super g> tVar, int i, int i2, boolean z) {
        this.f6489a = str;
        this.b = tVar;
        this.c = i;
        this.d = i2;
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.h.q.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public n b(q.f fVar) {
        return new n(this.f6489a, null, this.b, this.c, this.d, this.e, fVar);
    }
}
