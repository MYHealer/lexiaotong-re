package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: Dimension.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4214a;
    private final int b;

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f4214a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b2)) {
            return false;
        }
        b2 b2Var = (b2) obj;
        return this.f4214a == b2Var.f4214a && this.b == b2Var.b;
    }

    public int hashCode() {
        return (this.f4214a * 32713) + this.b;
    }

    public String toString() {
        return this.f4214a + "x" + this.b;
    }
}
