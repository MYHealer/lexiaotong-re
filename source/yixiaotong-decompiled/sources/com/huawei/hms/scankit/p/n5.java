package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: QRCodeDecoderMetaData.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4314a;

    n5(boolean z) {
        this.f4314a = z;
    }

    public void a(y5[] y5VarArr) {
        if (!this.f4314a || y5VarArr == null || y5VarArr.length < 3) {
            return;
        }
        y5 y5Var = y5VarArr[0];
        y5VarArr[0] = y5VarArr[2];
        y5VarArr[2] = y5Var;
    }
}
