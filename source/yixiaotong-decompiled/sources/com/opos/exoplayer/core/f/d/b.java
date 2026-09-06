package com.opos.exoplayer.core.f.d;

import com.opos.exoplayer.core.f.d;
import com.opos.exoplayer.core.i.y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.f.b[] f6439a;
    private final long[] b;

    public b(com.opos.exoplayer.core.f.b[] bVarArr, long[] jArr) {
        this.f6439a = bVarArr;
        this.b = jArr;
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
        com.opos.exoplayer.core.i.a.a(i >= 0);
        com.opos.exoplayer.core.i.a.a(i < this.b.length);
        return this.b[i];
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.b.length;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j) {
        com.opos.exoplayer.core.f.b bVar;
        int iA = y.a(this.b, j, true, false);
        return (iA == -1 || (bVar = this.f6439a[iA]) == null) ? Collections.emptyList() : Collections.singletonList(bVar);
    }
}
