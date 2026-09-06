package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: compiled from: TwoDimDecoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class m6 {
    public static byte[] a(p pVar, Map<f1, Object> map, w5 w5Var, int[] iArr, double[] dArr) throws a {
        if (pVar == null) {
            return null;
        }
        Collection collection = map != null ? (Collection) map.get(f1.POSSIBLE_FORMATS) : null;
        if ((collection != null && !collection.contains(BarcodeFormat.QR_CODE) && !collection.contains(BarcodeFormat.PDF_417)) || w5Var == null || w5Var.k() != null) {
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            return pVar.d();
        }
        if (collection != null) {
            collection.clear();
            f1 f1Var = f1.POSSIBLE_FORMATS;
            map.remove(f1Var);
            collection.add(w5Var.c());
            map.put(f1Var, collection);
        } else if (map != null) {
            f1 f1Var2 = f1.POSSIBLE_FORMATS;
            map.remove(f1Var2);
            Vector vector = new Vector();
            vector.add(w5Var.c());
            map.put(f1Var2, vector);
        }
        float f = 3.0f / b3.e;
        if (f < 1.0f) {
            f = 1.0f;
        }
        dArr[5] = f;
        return a(pVar, w5Var.j(), dArr, iArr);
    }

    private static byte[] a(p pVar, y5[] y5VarArr, double[] dArr, int[] iArr) throws a {
        if (y5VarArr == null) {
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            return pVar.d();
        }
        int iE = pVar.e();
        int iB = iE;
        int iC = pVar.c();
        int iB2 = 0;
        int iC2 = 0;
        for (y5 y5Var : y5VarArr) {
            if (y5Var != null) {
                if (((int) y5Var.b()) < iB) {
                    iB = (int) y5Var.b();
                }
                if (((int) y5Var.c()) < iC) {
                    iC = (int) y5Var.c();
                }
                if (((int) y5Var.b()) > iB2) {
                    iB2 = (int) y5Var.b();
                }
                if (((int) y5Var.c()) > iC2) {
                    iC2 = (int) y5Var.c();
                }
            }
        }
        return a(y5VarArr, pVar, iArr, Math.max(iB2 - iB, iC2 - iC), dArr);
    }

    private static byte[] a(y5[] y5VarArr, p pVar, int[] iArr, float f, double[] dArr) throws a {
        float fB = y5VarArr[0].b();
        float fB2 = y5VarArr[1].b();
        float fB3 = y5VarArr[2].b();
        float fC = y5VarArr[0].c();
        float fC2 = y5VarArr[1].c();
        float fC3 = y5VarArr[2].c();
        if (fB >= 0.0f && fB2 >= 0.0f && fB3 >= 0.0f && fC >= 0.0f && fC2 >= 0.0f && fC3 >= 0.0f && fB <= pVar.e() && fB2 <= pVar.e() && fB3 <= pVar.e() && fC <= pVar.c() && fC2 <= pVar.c() && fC3 <= pVar.c()) {
            int i = ((int) (fC + fC3)) / 2;
            int i2 = (int) ((((int) (fB + fB3)) / 2) - f);
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = (int) (i - f);
            if (i3 < 0) {
                i3 = 0;
            }
            int iC = ((int) f) * 2;
            int iE = i2 + iC <= pVar.e() ? iC : pVar.e() - i2;
            if (i3 + iC > pVar.c()) {
                iC = pVar.c() - i3;
            }
            p pVarA = pVar.a(i2, i3, iE, iC);
            double degrees = dArr[0] + Math.toDegrees(a(y5VarArr[0], y5VarArr[1])) + 90.0d;
            dArr[0] = degrees;
            dArr[1] = i2;
            dArr[2] = i3;
            double d = iE;
            dArr[3] = d;
            double d2 = iC;
            dArr[4] = d2;
            double radians = Math.toRadians(degrees);
            int iAbs = (int) (((Math.abs(Math.sin(radians)) * d) + (Math.abs(Math.cos(radians)) * d2)) * dArr[5]);
            int iAbs2 = (int) (((d2 * Math.abs(Math.sin(radians))) + (d * Math.abs(Math.cos(radians)))) * dArr[5]);
            iArr[0] = iAbs2;
            iArr[1] = iAbs;
            byte[] bArrImageRotate = LoadOpencvJNIUtil.imageRotate(pVarA.d(), pVarA.c(), pVarA.e(), iAbs, iAbs2, (float) dArr[0], dArr[5]);
            if (bArrImageRotate != null) {
                return bArrImageRotate;
            }
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            return pVar.d();
        }
        iArr[0] = pVar.e();
        iArr[1] = pVar.c();
        throw a.a();
    }

    public static double a(y5 y5Var, y5 y5Var2) {
        return Math.atan2(y5Var2.c() - y5Var.c(), y5Var2.b() - y5Var.b());
    }

    public static y5[] a(y5[] y5VarArr, int i, int i2, double[] dArr) {
        y5[] y5VarArr2;
        int i3;
        y5 y5Var = null;
        if (y5VarArr == null) {
            return null;
        }
        double d = dArr[3];
        int i4 = d != 0.0d ? (int) d : i;
        double d2 = dArr[4];
        int i5 = d2 != 0.0d ? (int) d2 : i2;
        double d3 = dArr[5];
        y5[] y5VarArr3 = new y5[y5VarArr.length];
        int i6 = 0;
        double radians = Math.toRadians(dArr[0]);
        double dCos = Math.cos(radians) * d3;
        double dSin = Math.sin(radians) * d3;
        double d4 = i5;
        double d5 = i4;
        double dAbs = (((Math.abs(dSin) - dSin) * d4) + ((Math.abs(dCos) - dCos) * d5)) / 2.0d;
        double d6 = -dSin;
        double dAbs2 = ((d4 * (Math.abs(dCos) - dCos)) + (d5 * (Math.abs(dSin) + dSin))) / 2.0d;
        while (i6 < y5VarArr.length) {
            y5 y5Var2 = y5VarArr[i6];
            if (y5Var2 != null) {
                y5VarArr2 = y5VarArr3;
                i3 = i6;
                double dB = (((((double) y5Var2.b()) - dAbs) * dCos) + ((dAbs2 - ((double) y5Var2.c())) * dSin)) / ((dCos * dCos) - (dSin * d6));
                y5VarArr2[i3] = new y5(Math.round(dB) + ((long) ((int) dArr[1])), Math.round(dSin == 0.0d ? (((double) y5Var2.c()) - dAbs2) / dCos : ((((double) y5Var2.b()) - dAbs) - (dCos * dB)) / dSin) + ((long) ((int) dArr[2])));
                y5Var = null;
            } else {
                y5VarArr2 = y5VarArr3;
                i3 = i6;
                y5VarArr2[i3] = y5Var;
            }
            i6 = i3 + 1;
            d6 = d6;
            y5VarArr3 = y5VarArr2;
        }
        return y5VarArr3;
    }
}
