package com.ubix.ssp.ad.e.w;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class i extends a implements Cloneable {
    boolean j;

    public i(String str) {
        this.f8892a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public i clone() {
        try {
            return (i) super.clone();
        } catch (CloneNotSupportedException e) {
            h.a(e);
            return this;
        }
    }

    public i a(int i) {
        this.d = Math.max(1, i);
        return this;
    }

    public i a(long j) {
        this.e = Math.max(16777216L, j);
        return this;
    }

    public i a(boolean z) {
        this.g = z;
        this.j = true;
        return this;
    }

    public i b() {
        this.b = true;
        return this;
    }

    public i b(int i) {
        this.c = Math.max(5, i);
        return this;
    }
}
