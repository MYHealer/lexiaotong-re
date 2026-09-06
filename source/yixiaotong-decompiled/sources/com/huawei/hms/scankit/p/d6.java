package com.huawei.hms.scankit.p;

import com.j256.ormlite.stmt.query.SimpleComparison;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SimpleToken.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class d6 extends k6 {
    private final short c;
    private final short d;

    d6(k6 k6Var, int i, int i2) {
        super(k6Var);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // com.huawei.hms.scankit.p.k6
    void a(r rVar, byte[] bArr) {
        rVar.a(this.c, this.d);
    }

    public String toString() {
        short s = this.c;
        int i = 1 << this.d;
        return SimpleComparison.LESS_THAN_OPERATION + Integer.toBinaryString((s & (i - 1)) | i | (1 << this.d)).substring(1) + Typography.greater;
    }
}
