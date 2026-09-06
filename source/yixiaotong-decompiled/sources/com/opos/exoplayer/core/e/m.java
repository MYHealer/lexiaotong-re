package com.opos.exoplayer.core.e;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f6403a = new m(new l[0]);
    public final int b;
    private final l[] c;
    private int d;

    public m(l... lVarArr) {
        this.c = lVarArr;
        this.b = lVarArr.length;
    }

    public int a(l lVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.c[i] == lVar) {
                return i;
            }
        }
        return -1;
    }

    public l a(int i) {
        return this.c[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.b == mVar.b && Arrays.equals(this.c, mVar.c);
    }

    public int hashCode() {
        if (this.d == 0) {
            this.d = Arrays.hashCode(this.c);
        }
        return this.d;
    }
}
