package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: Token.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
abstract class k6 {
    static final k6 b = new d6(null, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k6 f4296a;

    k6(k6 k6Var) {
        this.f4296a = k6Var;
    }

    final k6 a() {
        return this.f4296a;
    }

    abstract void a(r rVar, byte[] bArr);

    final k6 b(int i, int i2) {
        return new q(this, i, i2);
    }

    final k6 a(int i, int i2) {
        return new d6(this, i, i2);
    }
}
