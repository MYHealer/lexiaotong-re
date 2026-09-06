package com.opos.exoplayer.core.f.f;

import com.opos.exoplayer.core.i.y;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class f implements com.opos.exoplayer.core.f.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f6447a;
    private final long[] b;
    private final Map<String, b> c;
    private final Map<String, d> d;

    public f(c cVar, Map<String, b> map, Map<String, d> map2) {
        this.f6447a = cVar;
        this.d = map2;
        this.c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.b = cVar.b();
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j) {
        int iB = y.b(this.b, j, false, false);
        if (iB < this.b.length) {
            return iB;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i) {
        return this.b[i];
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.b.length;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j) {
        return this.f6447a.a(j, this.c, this.d);
    }
}
