package com.huawei.hms.scankit.p;

import com.j256.ormlite.stmt.query.SimpleComparison;
import kotlin.text.Typography;

/* JADX INFO: compiled from: BinaryShiftToken.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class q extends k6 {
    private final short c;
    private final short d;

    q(k6 k6Var, int i, int i2) {
        super(k6Var);
        this.c = (short) i;
        this.d = (short) i2;
    }

    public String toString() {
        return SimpleComparison.LESS_THAN_OPERATION + ((int) this.c) + "::" + ((this.c + this.d) - 1) + Typography.greater;
    }

    @Override // com.huawei.hms.scankit.p.k6
    public void a(r rVar, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.d;
            if (i >= s) {
                return;
            }
            if (i == 0 || (i == 31 && s <= 62)) {
                rVar.a(31, 5);
                short s2 = this.d;
                if (s2 > 62) {
                    rVar.a(s2 - 31, 16);
                } else if (i == 0) {
                    rVar.a(Math.min((int) s2, 31), 5);
                } else {
                    rVar.a(s2 - 31, 5);
                }
            }
            rVar.a(bArr[this.c + i], 8);
            i++;
        }
    }
}
