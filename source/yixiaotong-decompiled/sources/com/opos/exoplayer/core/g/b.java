package com.opos.exoplayer.core.g;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.e.l;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final l f6466a;
    protected final int b;
    protected final int[] c;
    private final Format[] d;
    private final long[] e;
    private int f;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.g.b$b, reason: collision with other inner class name */
    private static final class C0927b implements Comparator<Format> {
        private C0927b() {
        }

        /* synthetic */ C0927b(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Format format, Format format2) {
            return format2.b - format.b;
        }
    }

    public b(l lVar, int... iArr) {
        int i = 0;
        com.opos.exoplayer.core.i.a.b(iArr.length > 0);
        this.f6466a = (l) com.opos.exoplayer.core.i.a.a(lVar);
        int length = iArr.length;
        this.b = length;
        this.d = new Format[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = lVar.a(iArr[i2]);
        }
        Arrays.sort(this.d, new C0927b(null));
        this.c = new int[this.b];
        while (true) {
            int i3 = this.b;
            if (i >= i3) {
                this.e = new long[i3];
                return;
            } else {
                this.c[i] = lVar.a(this.d[i]);
                i++;
            }
        }
    }

    @Override // com.opos.exoplayer.core.g.f
    public final Format a(int i) {
        return this.d[i];
    }

    @Override // com.opos.exoplayer.core.g.f
    public void a() {
    }

    @Override // com.opos.exoplayer.core.g.f
    public void a(float f) {
    }

    protected final boolean a(int i, long j) {
        return this.e[i] > j;
    }

    @Override // com.opos.exoplayer.core.g.f
    public final int b(int i) {
        return this.c[i];
    }

    @Override // com.opos.exoplayer.core.g.f
    public void c() {
    }

    @Override // com.opos.exoplayer.core.g.f
    public final l d() {
        return this.f6466a;
    }

    @Override // com.opos.exoplayer.core.g.f
    public final int e() {
        return this.c.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6466a == bVar.f6466a && Arrays.equals(this.c, bVar.c);
    }

    @Override // com.opos.exoplayer.core.g.f
    public final Format f() {
        return this.d[b()];
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = (System.identityHashCode(this.f6466a) * 31) + Arrays.hashCode(this.c);
        }
        return this.f;
    }
}
