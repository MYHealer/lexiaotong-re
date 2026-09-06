package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReedSolomonEncoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y2 f4356a;
    private final List<z2> b;

    public u5(y2 y2Var) {
        this.f4356a = y2Var;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new z2(y2Var, new int[]{1}));
    }

    private z2 a(int i) {
        if (i >= this.b.size()) {
            List<z2> list = this.b;
            z2 z2VarC = list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                y2 y2Var = this.f4356a;
                z2VarC = z2VarC.c(new z2(y2Var, new int[]{1, y2Var.a((size - 1) + y2Var.a())}));
                this.b.add(z2VarC);
            }
        }
        return this.b.get(i);
    }

    public void a(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                z2 z2VarA = a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] iArrA = new z2(this.f4356a, iArr2).a(i, 1).b(z2VarA)[1].a();
                int length2 = i - iArrA.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(iArrA, 0, iArr, length + length2, iArrA.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
