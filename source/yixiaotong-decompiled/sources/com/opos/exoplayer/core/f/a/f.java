package com.opos.exoplayer.core.f.a;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class f implements com.opos.exoplayer.core.f.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.opos.exoplayer.core.f.b> f6421a;

    public f(List<com.opos.exoplayer.core.f.b> list) {
        this.f6421a = list;
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i) {
        com.opos.exoplayer.core.i.a.a(i == 0);
        return 0L;
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return 1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j) {
        return j >= 0 ? this.f6421a : Collections.emptyList();
    }
}
