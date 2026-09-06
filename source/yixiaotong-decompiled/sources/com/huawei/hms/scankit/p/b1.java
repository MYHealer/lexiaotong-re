package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: DataMatrixReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b1 implements s5 {
    private static final y5[] b = new y5[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m1 f4213a = new m1();

    @Override // com.huawei.hms.scankit.p.s5
    public w5 a(p pVar, Map<f1, ?> map) throws a {
        z1 z1VarA = new v1(pVar.b()).a();
        try {
            o1 o1VarA = this.f4213a.a(z1VarA.a(), map);
            return new w5(o1VarA.d(), o1VarA.c(), z1VarA.d(), BarcodeFormat.DATA_MATRIX);
        } catch (a e) {
            if (z1VarA.d() == null || b3.c) {
                throw e;
            }
            double dSqrt = Math.sqrt(Math.pow(z1VarA.d()[0].b() - z1VarA.d()[1].b(), 2.0d) + Math.pow(z1VarA.d()[0].c() - z1VarA.d()[1].c(), 2.0d));
            double dSqrt2 = Math.sqrt(Math.pow(z1VarA.d()[0].b() - z1VarA.d()[3].b(), 2.0d) + Math.pow(z1VarA.d()[0].c() - z1VarA.d()[3].c(), 2.0d));
            if (this.f4213a.a() == null || Math.abs(dSqrt - dSqrt2) / dSqrt >= 0.1d) {
                throw e;
            }
            return new w5(null, null, z1VarA.d(), BarcodeFormat.DATA_MATRIX);
        }
    }
}
