package com.opos.exoplayer.core.f;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class i extends com.opos.exoplayer.core.b.f implements d {
    private d c;
    private long d;

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j) {
        return this.c.a(j - this.d);
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i) {
        return this.c.a(i) + this.d;
    }

    @Override // com.opos.exoplayer.core.b.a
    public void a() {
        super.a();
        this.c = null;
    }

    public void a(long j, d dVar, long j2) {
        ((com.opos.exoplayer.core.b.f) this).f6276a = j;
        this.c = dVar;
        if (j2 == Long.MAX_VALUE) {
            j2 = ((com.opos.exoplayer.core.b.f) this).f6276a;
        }
        this.d = j2;
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.c.b();
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<b> b(long j) {
        return this.c.b(j - this.d);
    }

    public abstract void e();
}
