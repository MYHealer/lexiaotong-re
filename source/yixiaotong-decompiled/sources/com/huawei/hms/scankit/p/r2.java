package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: ErrorCorrectionLevel.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public enum r2 {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final r2[] f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4333a;

    static {
        r2 r2Var = L;
        r2 r2Var2 = M;
        r2 r2Var3 = Q;
        f = new r2[]{r2Var2, r2Var, H, r2Var3};
    }

    r2(int i) {
        this.f4333a = i;
    }

    public int a() {
        return this.f4333a;
    }

    public static r2 a(int i) {
        if (i >= 0) {
            r2[] r2VarArr = f;
            if (i < r2VarArr.length) {
                return r2VarArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
