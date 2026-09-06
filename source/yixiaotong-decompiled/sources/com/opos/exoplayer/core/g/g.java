package com.opos.exoplayer.core.g;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6474a;
    private final f[] b;
    private int c;

    public g(f... fVarArr) {
        this.b = fVarArr;
        this.f6474a = fVarArr.length;
    }

    public f a(int i) {
        return this.b[i];
    }

    public f[] a() {
        return (f[]) this.b.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((g) obj).b);
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b) + 527;
        }
        return this.c;
    }
}
