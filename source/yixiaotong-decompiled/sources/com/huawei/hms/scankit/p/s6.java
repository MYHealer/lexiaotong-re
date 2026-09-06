package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: UPCEANReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class s6 extends o4 {
    public static final int[] c = {1, 1, 1};
    public static final int[] d = {1, 1, 1, 1, 1};
    public static final int[] e = {1, 1, 1, 1, 1, 1};
    public static final int[][] f;
    public static final int[][] g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f4343a = new StringBuilder(20);
    private final r6 b = new r6();

    protected s6() {
    }

    static int[] a(r rVar) throws a {
        return b(rVar, 0);
    }

    static ArrayList<int[]> b(r rVar) throws a {
        int iE = rVar.e() / 2;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i = 0;
        while (i < iE) {
            try {
                int[] iArrB = b(rVar, i);
                arrayList.add(iArrB);
                i = iArrB[0] + 1;
            } catch (a unused) {
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        throw a.a();
    }

    protected abstract int a(r rVar, int[] iArr, StringBuilder sb) throws a;

    abstract BarcodeFormat a();

    abstract boolean a(int i, int i2, r rVar);

    abstract boolean a(int[] iArr, int[] iArr2) throws a;

    @Override // com.huawei.hms.scankit.p.o4
    public w5 a(int i, r rVar, Map<f1, ?> map) throws a {
        return a(i, rVar, a(rVar), map);
    }

    public w5 a(int i, r rVar, int[] iArr, Map<f1, ?> map) throws a {
        z5 z5Var = map == null ? null : (z5) map.get(f1.NEED_RESULT_POINT_CALLBACK);
        if (z5Var != null) {
            z5Var.a(new y5((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.f4343a;
        sb.setLength(0);
        int iA = a(rVar, iArr, sb);
        if (z5Var != null) {
            z5Var.a(new y5(iA, i));
        }
        int[] iArrA = a(rVar, iA);
        if (iArrA[0] - iA <= 1) {
            if (z5Var != null) {
                z5Var.a(new y5((iArrA[0] + iArrA[1]) / 2.0f, i));
            }
            if (a(iArr, iArrA)) {
                int i2 = iArrA[1];
                if ((i2 - iArrA[0]) + i2 < rVar.e() && a(iArrA[0], i2, rVar)) {
                    String string = sb.toString();
                    if (string.length() >= 8) {
                        if (a(string)) {
                            float f2 = i;
                            w5 w5Var = new w5(string, null, new y5[]{new y5(iArr[0], f2), new y5(iArrA[1], f2)}, a());
                            a(w5Var, iArrA, i, rVar, map);
                            return w5Var;
                        }
                        throw a.a();
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    static int[] b(r rVar, int i) throws a {
        int[] iArr = new int[c.length];
        int[] iArrA = null;
        boolean zA = false;
        while (!zA) {
            int[] iArr2 = c;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrA = a(rVar, i, false, iArr2, iArr);
            int i2 = iArrA[0];
            int i3 = iArrA[1];
            int i4 = i2 - (i3 - i2);
            int i5 = i4 + 3;
            while (i4 <= i5 && (i4 < 0 || !(zA = rVar.a(i4, i2, false, true)))) {
                i4++;
            }
            i = i3;
        }
        return iArrA;
    }

    public static int b(CharSequence charSequence) throws a {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw a.a();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw a.a();
            }
            i3 += iCharAt2;
        }
        return (1000 - i3) % 10;
    }

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f = iArr;
        int[][] iArr2 = new int[20][];
        g = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = f[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            g[i] = iArr4;
        }
    }

    private void a(w5 w5Var, int[] iArr, int i, r rVar, Map<f1, ?> map) throws a {
        int length;
        try {
            w5 w5VarA = this.b.a(i, rVar, iArr[1]);
            w5Var.a(w5VarA.j());
            length = w5VarA.k().length();
        } catch (a unused) {
            length = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(f1.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                if (length == i2) {
                    return;
                }
            }
            throw a.a();
        }
    }

    boolean a(String str) throws a {
        return a((CharSequence) str);
    }

    public static boolean a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return b(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    int[] a(r rVar, int i) throws a {
        return a(rVar, i, false, c);
    }

    static int[] a(r rVar, int i, boolean z, int[] iArr) throws a {
        return a(rVar, i, z, iArr, new int[iArr.length]);
    }

    private static int[] a(r rVar, int i, boolean z, int[] iArr, int[] iArr2) throws a {
        int iE = rVar.e();
        int iD = z ? rVar.d(i) : rVar.c(i);
        int length = iArr.length;
        boolean z2 = z;
        int i2 = 0;
        int i3 = iD;
        while (iD < iE) {
            if (rVar.b(iD) != z2) {
                if (i2 >= 0 && i2 < iArr2.length) {
                    iArr2[i2] = iArr2[i2] + 1;
                } else {
                    throw a.a();
                }
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else {
                    if (o4.a(iArr2, iArr, 0.8f) < 0.46f) {
                        return new int[]{i3, iD};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i4 = i2 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i2] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
            iD++;
        }
        throw a.a();
    }

    static int a(r rVar, int[] iArr, int i, int[][] iArr2) throws a {
        o4.a(rVar, i, iArr);
        int length = iArr2.length;
        float f2 = 0.46f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fA = o4.a(iArr, iArr2[i3], 0.8f);
            if (fA < f2) {
                i2 = i3;
                f2 = fA;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw a.a();
    }
}
