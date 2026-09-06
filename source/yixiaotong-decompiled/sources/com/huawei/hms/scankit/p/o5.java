package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* JADX INFO: compiled from: QRCodeReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class o5 implements s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f4319a = new n1();

    public static void a(y3 y3Var) {
        int iA = y3Var.a();
        if (iA == y3Var.c() && iA == 805) {
            b3.r[0] = true;
        }
    }

    public static void a(y3 y3Var, w5 w5Var) {
        boolean z;
        int iA = y3Var.a();
        int iC = y3Var.c();
        while (true) {
            if (b3.s.size() == 0) {
                z = false;
                break;
            }
            int iIntValue = b3.s.pop().intValue();
            if (iIntValue != 0 && iA % iIntValue == 0) {
                z = true;
                break;
            }
        }
        if (iA != iC || !z || w5Var == null || w5Var.j() == null) {
            return;
        }
        if ((Math.max(Math.max(w5Var.j()[0].b(), w5Var.j()[1].b()), w5Var.j()[2].b()) - Math.min(Math.min(w5Var.j()[0].b(), w5Var.j()[1].b()), w5Var.j()[2].b())) * (Math.max(Math.max(w5Var.j()[0].c(), w5Var.j()[1].c()), w5Var.j()[2].c()) - Math.min(Math.min(w5Var.j()[0].c(), w5Var.j()[1].c()), w5Var.j()[2].c())) > ((double) (iA * iC)) * 0.8d) {
            b3.r[1] = true;
        }
    }

    @Override // com.huawei.hms.scankit.p.s5
    public final w5 a(p pVar, Map<f1, ?> map) throws a {
        o1 o1VarA;
        boolean z = true;
        b3.f++;
        try {
            z1 z1VarA = new x1(pVar.b()).a(map);
            int iA = a(z1VarA);
            boolean z2 = iA > 0;
            try {
                o1VarA = this.f4319a.a(z1VarA.a(), map);
                z = false;
            } catch (Exception unused) {
                o1VarA = null;
            }
            if (b3.c) {
                if (z && iA >= 2) {
                    return new w5(null, null, z1VarA.b(), BarcodeFormat.QR_CODE);
                }
            } else if (z && z2) {
                return new w5(null, null, z1VarA.b(), BarcodeFormat.QR_CODE);
            }
            if (z) {
                throw a.a();
            }
            if (o1VarA == null) {
                return null;
            }
            y5[] y5VarArrD = z1VarA.d();
            if (o1VarA.b() instanceof n5) {
                ((n5) o1VarA.b()).a(y5VarArrD);
            }
            w5 w5Var = new w5(o1VarA.d(), o1VarA.c(), y5VarArrD, BarcodeFormat.QR_CODE);
            w5Var.b(z1VarA.b());
            return w5Var;
        } catch (a unused2) {
            throw a.a();
        }
    }

    private int a(z1 z1Var) {
        b3.e = z1Var.c();
        s sVarA = z1Var.a();
        int[] iArr = {3, sVarA.e() - 4, 3};
        int[] iArr2 = {3, 3, sVarA.c() - 4};
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            if (a(sVarA, iArr[i2], iArr2[i2])) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    private boolean a(s sVar, int i, int i2) {
        int i3;
        if (sVar == null || sVar.c() < 21 || sVar.e() < 21) {
            return false;
        }
        ?? B = sVar.b(i, i2);
        if (sVar.b(i + 1, i2)) {
            i3 = B;
            i3 = B + 1;
        }
        i3 = B;
        int i4 = i3;
        if (!sVar.b(i + 2, i2)) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (sVar.b(i + 3, i2)) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (sVar.b(i - 1, i2)) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (!sVar.b(i - 2, i2)) {
            i7 = i6 + 1;
        }
        int i8 = i7;
        if (sVar.b(i - 3, i2)) {
            i8 = i7 + 1;
        }
        int i9 = i8;
        if (sVar.b(i, i2 + 1)) {
            i9 = i8 + 1;
        }
        int i10 = i9;
        if (!sVar.b(i, i2 + 2)) {
            i10 = i9 + 1;
        }
        int i11 = i10;
        if (sVar.b(i, i2 + 3)) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (sVar.b(i, i2 - 1)) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (!sVar.b(i, i2 - 2)) {
            i13 = i12 + 1;
        }
        int i14 = i13;
        if (sVar.b(i, i2 - 3)) {
            i14 = i13 + 1;
        }
        return i14 > 10;
    }
}
