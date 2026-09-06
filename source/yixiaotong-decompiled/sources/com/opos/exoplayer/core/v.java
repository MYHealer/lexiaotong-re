package com.opos.exoplayer.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f6547a = new v(0);
    public final int b;

    public v(int i) {
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && v.class == obj.getClass() && this.b == ((v) obj).b;
    }

    public int hashCode() {
        return this.b;
    }
}
