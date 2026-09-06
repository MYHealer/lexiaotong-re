package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FinderPatternFinder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class u2 {
    private static boolean h;
    private static boolean i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f4352a;
    private final z5 e;
    private static final int[] f = {1, 3, 1, 1};
    private static final int[] g = {1, 1, 3, 1};
    private static final c j = new c(null);
    private final List<t2> b = new ArrayList();
    private final int[] d = new int[5];
    private final List<t2> c = new ArrayList();

    /* JADX INFO: compiled from: FinderPatternFinder.java */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: FinderPatternFinder.java */
    private static final class b implements Comparator<t2>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f4353a;

        /* synthetic */ b(float f, a aVar) {
            this(f);
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(t2 t2Var, t2 t2Var2) {
            int iCompare = Integer.compare(t2Var2.a(), t2Var.a());
            return iCompare == 0 ? Float.compare(Math.abs(t2Var.e() - this.f4353a), Math.abs(t2Var2.e() - this.f4353a)) : iCompare;
        }

        private b(float f) {
            this.f4353a = f;
        }
    }

    /* JADX INFO: compiled from: FinderPatternFinder.java */
    private static final class c implements Comparator<t2>, Serializable {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(t2 t2Var, t2 t2Var2) {
            return Float.compare(t2Var.e(), t2Var2.e());
        }
    }

    /* JADX INFO: compiled from: FinderPatternFinder.java */
    private static final class d implements Comparator<t2>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f4354a;

        /* synthetic */ d(float f, a aVar) {
            this(f);
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(t2 t2Var, t2 t2Var2) {
            return Float.compare(Math.abs(t2Var2.e() - this.f4354a), Math.abs(t2Var.e() - this.f4354a));
        }

        private d(float f) {
            this.f4354a = f;
        }
    }

    public u2(s sVar, z5 z5Var) {
        this.f4352a = sVar;
        this.e = z5Var;
    }

    protected static float a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            float f7 = iArr2[i5] * f4;
            float f8 = i6;
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    private t2[] c() throws com.huawei.hms.scankit.p.a {
        t2[] t2VarArrA = this.b.size() > 2 ? a(true) : null;
        if (this.b.size() == 2) {
            int i2 = this.b.get(0).e() > this.b.get(1).e() ? 0 : 1;
            if (Math.max(this.b.get(0).e(), this.b.get(1).e()) / Math.min(this.b.get(0).e(), this.b.get(1).e()) > 1.5d) {
                t2 t2Var = this.b.get(i2);
                this.b.clear();
                this.b.add(t2Var);
            }
        }
        if (this.b.size() == 1 && this.c.size() > 1) {
            t2VarArrA = g();
        }
        if (this.b.size() == 1 && this.c.size() == 1) {
            this.b.addAll(this.c);
            this.c.clear();
        }
        if (this.b.size() == 2) {
            try {
                t2VarArrA = h();
            } catch (com.huawei.hms.scankit.p.a unused) {
                t2VarArrA = a();
            }
        }
        if (this.b.size() != 0) {
            return t2VarArrA;
        }
        this.b.addAll(this.c);
        return this.b.size() < 20 ? a(false) : f();
    }

    private int[] d() {
        a(this.d);
        return this.d;
    }

    private static void e() {
        h = false;
        i = false;
    }

    private t2[] f() throws com.huawei.hms.scankit.p.a {
        int size = this.b.size();
        if (size < 3) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        a aVar = null;
        float fE = 0.0f;
        if (size > 3) {
            Iterator<t2> it = this.b.iterator();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (it.hasNext()) {
                float fE2 = it.next().e();
                f2 += fE2;
                f3 += fE2 * fE2;
            }
            float f4 = size;
            float f5 = f2 / f4;
            float fSqrt = (float) Math.sqrt((f3 / f4) - (f5 * f5));
            Collections.sort(this.b, new d(f5, aVar));
            float fMax = Math.max(0.2f * f5, fSqrt);
            int i2 = 0;
            while (i2 < this.b.size() && this.b.size() > 3) {
                if (Math.abs(this.b.get(i2).e() - f5) > fMax) {
                    this.b.remove(i2);
                    i2--;
                }
                i2++;
            }
        }
        if (this.b.size() > 3) {
            Iterator<t2> it2 = this.b.iterator();
            while (it2.hasNext()) {
                fE += it2.next().e();
            }
            Collections.sort(this.b, new b(fE / this.b.size(), aVar));
            List<t2> list = this.b;
            list.subList(3, list.size()).clear();
        }
        double[] dArr = {a(this.b.get(0), this.b.get(1)), a(this.b.get(1), this.b.get(2)), a(this.b.get(0), this.b.get(2))};
        Arrays.sort(dArr);
        double d2 = dArr[1];
        double d3 = dArr[0];
        if (Math.abs(((d2 + d3) - dArr[2]) / ((Math.sqrt(d3) * 2.0d) * Math.sqrt(dArr[1]))) <= 0.25d) {
            return new t2[]{this.b.get(0), this.b.get(1), this.b.get(2)};
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private t2[] g() throws com.huawei.hms.scankit.p.a {
        boolean z;
        Collections.sort(this.c, j);
        double[] dArr = new double[3];
        t2[] t2VarArr = new t2[3];
        int i2 = 0;
        double d2 = Double.MAX_VALUE;
        while (i2 < this.b.size()) {
            t2 t2Var = this.b.get(i2);
            float fE = t2Var.e();
            int i3 = 0;
            while (i3 < this.c.size() - 1) {
                t2 t2Var2 = this.c.get(i3);
                double dE = t2Var2.e() / fE;
                if (dE <= 1.25d && dE >= 0.75d) {
                    double dA = a(t2Var, t2Var2);
                    if (Math.sqrt(dA) >= fE * 13.0f) {
                        int i4 = i3 + 1;
                        while (i4 < this.c.size()) {
                            t2 t2Var3 = this.c.get(i4);
                            int i5 = i2;
                            double dE2 = t2Var3.e() / fE;
                            if (dE2 > 1.25d || dE2 < 0.75d) {
                                z = true;
                            } else {
                                dArr[0] = dA;
                                dArr[1] = a(t2Var2, t2Var3);
                                dArr[2] = a(t2Var, t2Var3);
                                Arrays.sort(dArr);
                                double dAbs = Math.abs(dArr[2] - (dArr[1] * 2.0d)) + Math.abs(dArr[2] - (dArr[0] * 2.0d));
                                double d3 = dArr[2];
                                double d4 = dAbs / d3;
                                z = true;
                                double d5 = dArr[1];
                                double d6 = dArr[0];
                                double dSqrt = ((d5 + d6) - d3) / ((Math.sqrt(d6) * 2.0d) * Math.sqrt(dArr[1]));
                                if (d4 < d2 && Math.abs(dSqrt) < 0.2d) {
                                    t2VarArr[0] = t2Var;
                                    t2VarArr[1] = t2Var2;
                                    t2VarArr[2] = t2Var3;
                                    d2 = d4;
                                }
                            }
                            i4++;
                            i2 = i5;
                        }
                    }
                }
                i3++;
                i2 = i2;
            }
            i2++;
        }
        if (d2 != Double.MAX_VALUE) {
            return t2VarArr;
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private t2[] h() throws com.huawei.hms.scankit.p.a {
        t2 t2Var;
        t2 t2Var2;
        double d2;
        char c2 = 0;
        t2 t2Var3 = this.b.get(0);
        char c3 = 1;
        t2 t2Var4 = this.b.get(1);
        t2 t2Var5 = this.b.get(1);
        double dA = a(t2Var3, t2Var4);
        double[] dArr = new double[3];
        float fMin = Math.min(t2Var3.e(), t2Var4.e());
        Collections.sort(this.b, new d(fMin, null));
        int i2 = 0;
        double d3 = Double.MAX_VALUE;
        while (i2 < this.c.size()) {
            t2 t2Var6 = this.c.get(i2);
            float fE = t2Var6.e();
            if (fE > 1.25f * fMin || fE < 0.75f * fMin) {
                t2Var = t2Var3;
                t2Var2 = t2Var4;
                d2 = dA;
            } else {
                dArr[c2] = dA;
                dArr[c3] = a(t2Var4, t2Var6);
                dArr[2] = a(t2Var3, t2Var6);
                Arrays.sort(dArr);
                double dAbs = Math.abs(dArr[2] - (dArr[c3] * 2.0d)) + Math.abs(dArr[2] - (dArr[c2] * 2.0d));
                double d4 = dArr[2];
                double d5 = dAbs / d4;
                double d6 = dArr[c3];
                double d7 = dArr[c2];
                double dSqrt = ((d6 + d7) - d4) / ((Math.sqrt(d7) * 2.0d) * Math.sqrt(dArr[c3]));
                if (!b3.d || Math.abs(dSqrt) >= 0.25d) {
                    t2Var = t2Var3;
                    t2Var2 = t2Var4;
                    d2 = dA;
                } else {
                    char c4 = (t2Var3.b() >= ((float) this.f4352a.e()) * 0.3f || t2Var4.b() <= ((float) this.f4352a.e()) * 0.7f) ? c2 : (char) 1;
                    boolean z = t2Var4.b() < ((float) this.f4352a.e()) * 0.3f && t2Var3.b() > ((float) this.f4352a.e()) * 0.7f;
                    boolean z2 = t2Var3.c() < ((float) this.f4352a.c()) * 0.3f && t2Var4.c() > ((float) this.f4352a.c()) * 0.7f;
                    t2Var2 = t2Var4;
                    boolean z3 = t2Var4.c() < ((float) this.f4352a.c()) * 0.3f && t2Var3.c() > ((float) this.f4352a.c()) * 0.7f;
                    t2Var = t2Var3;
                    boolean z4 = t2Var6.b() < ((float) this.f4352a.e()) * 0.3f || t2Var6.b() > ((float) this.f4352a.e()) * 0.7f;
                    d2 = dA;
                    boolean z5 = t2Var6.c() < ((float) this.f4352a.c()) * 0.3f || t2Var6.c() > ((float) this.f4352a.c()) * 0.7f;
                    if (((c4 != 0 || z) && !z4) || ((z2 || z3) && !z5)) {
                    }
                }
                if (d5 < d3 && Math.abs(dSqrt) < 0.25d) {
                    t2Var5 = t2Var6;
                    d3 = d5;
                }
            }
            i2++;
            t2Var4 = t2Var2;
            t2Var3 = t2Var;
            dA = d2;
            c2 = 0;
            c3 = 1;
        }
        if (d3 == Double.MAX_VALUE) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        this.b.add(t2Var5);
        return new t2[]{this.b.get(0), this.b.get(1), this.b.get(2)};
    }

    final v2 b() throws com.huawei.hms.scankit.p.a {
        int iC = this.f4352a.c();
        int iE = this.f4352a.e();
        int i2 = (iC * 3) / MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT;
        if (i2 < 3) {
            i2 = 3;
        }
        if (b3.j) {
            i2 = 2;
        }
        a(i2, iC, iE);
        t2[] t2VarArrC = c();
        if (t2VarArrC == null) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        y5.a(t2VarArrC);
        if (((double) (this.f4352a.c() * this.f4352a.e())) / (Math.sqrt(a(t2VarArrC[0], t2VarArrC[1])) * Math.sqrt(a(t2VarArrC[1], t2VarArrC[2]))) <= 900.0d) {
            return new v2(t2VarArrC);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    protected final void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private boolean d(int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        int i7;
        s sVar = this.f4352a;
        while (i2 >= 0 && !sVar.b(i3, i2) && (i7 = iArr[3]) <= i4) {
            iArr[3] = i7 + 1;
            i2--;
        }
        if (i2 >= 0 && iArr[3] <= i4) {
            while (i2 >= 0 && sVar.b(i3, i2) && (i6 = iArr[2]) <= i4) {
                iArr[2] = i6 + 1;
                i2--;
            }
            if (i2 >= 0 && iArr[2] <= i4) {
                while (i2 >= 0 && !sVar.b(i3, i2)) {
                    int i8 = iArr[1];
                    if (i8 > i4) {
                        break;
                    }
                    iArr[1] = i8 + 1;
                    i2--;
                }
                if (i2 >= 0 && iArr[1] <= i4) {
                    while (i2 >= 0 && sVar.b(i3, i2) && (i5 = iArr[0]) <= i4) {
                        iArr[0] = i5 + 1;
                        i2--;
                    }
                    return iArr[0] > i4;
                }
            }
        }
        return true;
    }

    private void a(int i2, int i3, int i4) {
        int i5;
        int[] iArr = new int[5];
        for (int i6 = i2 - 1; i6 < i3; i6 += i2) {
            a(iArr);
            int[] iArr2 = {0, i6, 0, i4, i2};
            int i7 = 0;
            while (i7 < i4) {
                iArr2[2] = i7;
                if (this.f4352a.b(i7, i6)) {
                    a(iArr, iArr2);
                } else {
                    if (b(iArr, iArr2)) {
                    }
                    i7++;
                }
                i7 = iArr2[2];
                i2 = iArr2[4];
                i7++;
            }
            if (b(iArr)) {
                i5 = i4;
                for (int i8 = iArr2[0]; i8 > 2; i8--) {
                    i5 -= iArr[i8];
                }
                b(iArr, i6, i5);
            } else {
                i5 = i4;
            }
            if (a(iArr, false) && a(iArr, i6, i5, false)) {
                i2 = 2;
            }
        }
    }

    private boolean b(int[] iArr, int[] iArr2) {
        int i2 = iArr2[0];
        if ((i2 & 1) != 0) {
            iArr[i2] = iArr[i2] + 1;
        } else if (i2 == 4) {
            if (a(iArr, false)) {
                boolean zA = a(iArr, iArr2[1], iArr2[2], false);
                if (zA) {
                    iArr2[4] = 2;
                }
                if (!zA) {
                    zA = a(iArr, iArr2[1], iArr2[2]);
                }
                if (zA) {
                    iArr2[0] = 0;
                    a(iArr);
                    return true;
                }
            }
            if (b(iArr)) {
                int i3 = iArr2[2];
                for (int i4 = iArr2[0]; i4 > 2; i4--) {
                    i3 -= iArr[i4];
                }
                if (b(iArr, iArr2[1], i3)) {
                    d(iArr);
                    iArr2[0] = 3;
                    return true;
                }
            }
            if (b3.d && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                iArr2[0] = 0;
                a(iArr);
                return true;
            }
            d(iArr);
            iArr2[0] = 3;
        } else {
            int i5 = i2 + 1;
            iArr2[0] = i5;
            iArr[i5] = iArr[i5] + 1;
        }
        return false;
    }

    protected static boolean c(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = 0.75f * f2;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private void a(int[] iArr, int[] iArr2) {
        int i2 = iArr2[0];
        if ((i2 & 1) == 1) {
            iArr2[0] = i2 + 1;
        }
        int i3 = iArr2[0];
        if (i3 >= 0 && i3 < iArr.length) {
            iArr[i3] = iArr[i3] + 1;
        }
        if (iArr2[2] == iArr2[3] - 1 && iArr2[0] == 4) {
            if (a(iArr, false)) {
                boolean zA = a(iArr, iArr2[1], iArr2[2], false);
                if (zA) {
                    iArr2[4] = 2;
                }
                if (!zA) {
                    zA = a(iArr, iArr2[1], iArr2[2]);
                }
                if (zA) {
                    iArr2[0] = 0;
                    a(iArr);
                    while (iArr2[2] < this.f4352a.e() && !this.f4352a.b(iArr2[2], iArr2[1])) {
                        iArr2[2] = iArr2[2] + 1;
                    }
                }
            }
            if (b3.d && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                iArr2[0] = 0;
                a(iArr);
            }
        }
    }

    private boolean c(int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        s sVar = this.f4352a;
        while (i2 >= 0 && !sVar.b(i3, i2) && (i6 = iArr[1]) <= i4) {
            iArr[1] = i6 + 1;
            i2--;
        }
        if (i2 < 0 || iArr[1] > i4) {
            return true;
        }
        while (i2 >= 0 && sVar.b(i3, i2) && (i5 = iArr[0]) <= i4) {
            iArr[0] = i5 + 1;
            i2--;
        }
        return iArr[0] > i4;
    }

    private static float a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected static boolean a(int[] iArr, boolean z) {
        float f2;
        float f3;
        e();
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        if (z && b3.d) {
            f3 = 0.75f;
            f2 = 1.0f;
        } else {
            f2 = 3.0f;
            f3 = 0.5f;
        }
        float f4 = i2 / 7.0f;
        float f5 = f3 * f4;
        if (Math.abs(f4 - iArr[0]) < f5 && Math.abs(f4 - iArr[1]) < f5 && Math.abs((3.0f * f4) - iArr[2]) < f2 * f5 && Math.abs(f4 - iArr[3]) < f5 && Math.abs(f4 - iArr[4]) < f5) {
            return true;
        }
        if (!z) {
            return false;
        }
        int[] iArr2 = new int[iArr.length - 1];
        int i5 = 0;
        while (i5 < iArr.length - 1) {
            int i6 = i5 + 1;
            iArr2[i5] = iArr[i6];
            i5 = i6;
        }
        int[] iArr3 = new int[iArr.length - 1];
        for (int i7 = 0; i7 < iArr.length - 1; i7++) {
            iArr3[i7] = iArr[i7];
        }
        float fA = a(iArr2, f, 0.5f);
        float fA2 = a(iArr3, g, 0.5f);
        boolean z2 = fA < 0.3f;
        h = z2;
        boolean z3 = fA2 < 0.3f;
        i = z3;
        return z2 || z3;
    }

    private float b(int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7;
        s sVar = this.f4352a;
        int iC = sVar.c();
        int[] iArrD = d();
        if (b(i2, i3, i4, iArrD)) {
            return Float.NaN;
        }
        int i8 = i2 + 1;
        while (i8 < iC && sVar.b(i3, i8)) {
            iArrD[2] = iArrD[2] + 1;
            i8++;
        }
        if (i8 == iC) {
            return Float.NaN;
        }
        while (i8 < iC && !sVar.b(i3, i8) && (i7 = iArrD[3]) < i4) {
            iArrD[3] = i7 + 1;
            i8++;
        }
        if (i8 == iC || iArrD[3] >= i4) {
            return Float.NaN;
        }
        while (i8 < iC && sVar.b(i3, i8) && (i6 = iArrD[4]) < i4) {
            iArrD[4] = i6 + 1;
            i8++;
        }
        int i9 = iArrD[4];
        if (i9 >= i4 && !i && !h) {
            return Float.NaN;
        }
        int i10 = iArrD[0] + iArrD[1] + iArrD[2] + iArrD[3] + i9;
        if (z) {
            if (Math.abs(i10 - i5) * 5 >= i5 * 3 && !i && !h) {
                return Float.NaN;
            }
        } else if (i10 >= i5 * 3 || i10 * 3 <= i5) {
            return Float.NaN;
        }
        if (a(iArrD, z)) {
            return a(iArrD, i8);
        }
        return Float.NaN;
    }

    protected final void a(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
    }

    private boolean a(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] iArrD = d();
        int i7 = 0;
        while (i2 >= i7 && i3 >= i7 && this.f4352a.b(i3 - i7, i2 - i7)) {
            iArrD[2] = iArrD[2] + 1;
            i7++;
        }
        if (iArrD[2] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && !this.f4352a.b(i3 - i7, i2 - i7)) {
            iArrD[1] = iArrD[1] + 1;
            i7++;
        }
        if (iArrD[1] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && this.f4352a.b(i3 - i7, i2 - i7)) {
            iArrD[0] = iArrD[0] + 1;
            i7++;
        }
        if (iArrD[0] == 0) {
            return false;
        }
        int iC = this.f4352a.c();
        int iE = this.f4352a.e();
        int i8 = 1;
        while (true) {
            int i9 = i2 + i8;
            if (i9 >= iC || (i6 = i3 + i8) >= iE || !this.f4352a.b(i6, i9)) {
                break;
            }
            iArrD[2] = iArrD[2] + 1;
            i8++;
        }
        while (true) {
            int i10 = i2 + i8;
            if (i10 >= iC || (i5 = i3 + i8) >= iE || this.f4352a.b(i5, i10)) {
                break;
            }
            iArrD[3] = iArrD[3] + 1;
            i8++;
        }
        if (iArrD[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i2 + i8;
            if (i11 >= iC || (i4 = i3 + i8) >= iE || !this.f4352a.b(i4, i11)) {
                break;
            }
            iArrD[4] = iArrD[4] + 1;
            i8++;
        }
        if (iArrD[4] == 0) {
            return false;
        }
        return c(iArrD);
    }

    private boolean b(int i2, int i3, int i4, int[] iArr) {
        int i5;
        s sVar = this.f4352a;
        while (i2 >= 0 && sVar.b(i3, i2)) {
            iArr[2] = iArr[2] + 1;
            i2--;
        }
        if (i2 < 0) {
            return true;
        }
        while (i2 >= 0 && !sVar.b(i3, i2)) {
            int i6 = iArr[1];
            if (i6 > i4) {
                break;
            }
            iArr[1] = i6 + 1;
            i2--;
        }
        if (i2 < 0 || iArr[1] > i4) {
            return true;
        }
        while (i2 >= 0 && sVar.b(i3, i2) && (i5 = iArr[0]) <= i4) {
            iArr[0] = i5 + 1;
            i2--;
        }
        return (iArr[0] <= i4 || i || h) ? false : true;
    }

    protected static boolean b(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = 0.5f * f2;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs((5.0f * f2) - ((float) iArr[1])) < f3 && Math.abs(f2 - ((float) iArr[2])) < f3;
    }

    private float b(int i2, int i3, int i4, int i5) {
        int i6;
        s sVar = this.f4352a;
        int iC = sVar.c();
        int[] iArrD = d();
        if (d(i2, i3, i4, iArrD)) {
            return Float.NaN;
        }
        int i7 = i2 + 1;
        while (i7 < iC && !sVar.b(i3, i7) && (i6 = iArrD[3]) <= i4) {
            iArrD[3] = i6 + 1;
            i7++;
        }
        if (i7 < 0 || iArrD[3] > i4) {
            return Float.NaN;
        }
        while (i7 < iC && sVar.b(i3, i7)) {
            iArrD[4] = iArrD[4] + 1;
            i7++;
        }
        int i8 = iArrD[4];
        if (i8 <= i4 && Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + i8) - i5) * 5 < i5 * 2 && a(iArrD, true)) {
            return a(iArrD, i7);
        }
        return Float.NaN;
    }

    private float a(int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7;
        s sVar = this.f4352a;
        int iE = sVar.e();
        int[] iArrD = d();
        if (a(i2, i3, i4, iArrD)) {
            return Float.NaN;
        }
        int i8 = i2 + 1;
        while (i8 < iE && sVar.b(i8, i3)) {
            iArrD[2] = iArrD[2] + 1;
            i8++;
        }
        if (i8 == iE) {
            return Float.NaN;
        }
        while (i8 < iE && !sVar.b(i8, i3) && (i7 = iArrD[3]) < i4) {
            iArrD[3] = i7 + 1;
            i8++;
        }
        if (i8 == iE || iArrD[3] >= i4) {
            return Float.NaN;
        }
        while (i8 < iE && sVar.b(i8, i3) && (i6 = iArrD[4]) < i4) {
            iArrD[4] = i6 + 1;
            i8++;
        }
        int i9 = iArrD[4];
        if (i9 >= i4 && !i && !h) {
            return Float.NaN;
        }
        if ((Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + i9) - i5) * 5 < i5 || i || h) && a(iArrD, z)) {
            return a(iArrD, i8);
        }
        return Float.NaN;
    }

    protected final boolean b(int[] iArr, int i2, int i3) {
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = i4 + i5 + iArr[2];
        float f2 = i3 - (i6 / 2);
        int i7 = (int) f2;
        float fA = a(i2, i7, i5, i6);
        if (Float.isNaN(fA)) {
            int i8 = iArr[1];
            fA = a(i2, (int) (f2 - ((i8 * 2) / 5)), (int) (((i8 * 2) / 5) + f2), i8, i6);
            if (Float.isNaN(fA) && b3.d) {
                fA = b(i2, i7, iArr[1], i6);
            }
        }
        if (Float.isNaN(fA)) {
            return false;
        }
        return a(false, fA, f2, i6 / 7.0f);
    }

    private boolean a(int i2, int i3, int i4, int[] iArr) {
        int i5;
        s sVar = this.f4352a;
        while (i2 >= 0 && sVar.b(i2, i3)) {
            iArr[2] = iArr[2] + 1;
            i2--;
        }
        if (i2 < 0) {
            return true;
        }
        while (i2 >= 0 && !sVar.b(i2, i3)) {
            int i6 = iArr[1];
            if (i6 > i4) {
                break;
            }
            iArr[1] = i6 + 1;
            i2--;
        }
        if (i2 < 0 || iArr[1] > i4) {
            return true;
        }
        while (i2 >= 0 && sVar.b(i2, i3) && (i5 = iArr[0]) <= i4) {
            iArr[0] = i5 + 1;
            i2--;
        }
        return (iArr[0] <= i4 || i || h) ? false : true;
    }

    protected final boolean a(int[] iArr, int i2, int i3, boolean z) {
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int i8 = iArr[4];
        int i9 = h ? i5 + i5 + i6 + i7 + i8 : i ? i4 + i5 + i6 + i7 + i7 : i4 + i5 + i6 + i7 + i8;
        int iA = (int) a(iArr, i3);
        float fB = b(i2, iA, iArr[2], i9, z);
        if (!Float.isNaN(fB)) {
            float f2 = i9 / 7.0f;
            int i10 = (int) fB;
            float fA = a(iA, i10, iArr[2], i9, z);
            if (!Float.isNaN(fA) && (a(i10, (int) fA) || (z && (i || h)))) {
                if (!z) {
                    for (int i11 = 0; i11 < this.b.size(); i11++) {
                        t2 t2Var = this.b.get(i11);
                        if (t2Var.b(f2, fB, fA)) {
                            this.b.set(i11, t2Var.a(fB, fA, f2, true));
                            return true;
                        }
                    }
                    t2 t2Var2 = new t2(fA, fB, f2, true);
                    this.b.add(t2Var2);
                    z5 z5Var = this.e;
                    if (z5Var != null) {
                        z5Var.a(t2Var2);
                    }
                    return true;
                }
                return a(false, fB, fA, f2);
            }
        }
        return false;
    }

    private static double a(t2 t2Var, t2 t2Var2) {
        double dB = t2Var.b() - t2Var2.b();
        double dC = t2Var.c() - t2Var2.c();
        return (dB * dB) + (dC * dC);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00d1  */
    private t2[] a(boolean z) throws com.huawei.hms.scankit.p.a {
        float f2;
        Collections.sort(this.b, j);
        float f3 = z ? 0.4f : 0.25f;
        double[] dArr = new double[3];
        t2[] t2VarArr = new t2[3];
        int i2 = 0;
        double d2 = Double.MAX_VALUE;
        while (true) {
            char c2 = 2;
            if (i2 >= this.b.size() - 2) {
                break;
            }
            t2 t2Var = this.b.get(i2);
            float fE = t2Var.e();
            i2++;
            int i3 = i2;
            while (i3 < this.b.size() - 1) {
                t2 t2Var2 = this.b.get(i3);
                double dA = a(t2Var, t2Var2);
                i3++;
                int i4 = i3;
                while (i4 < this.b.size()) {
                    t2 t2Var3 = this.b.get(i4);
                    if (t2Var3.e() > 1.4f * fE) {
                        f2 = fE;
                    } else {
                        dArr[0] = dA;
                        dArr[1] = a(t2Var2, t2Var3);
                        dArr[c2] = a(t2Var, t2Var3);
                        Arrays.sort(dArr);
                        double dAbs = Math.abs(dArr[c2] - (dArr[1] * 2.0d)) + Math.abs(dArr[c2] - (dArr[0] * 2.0d));
                        double d3 = dArr[c2];
                        double d4 = dAbs / d3;
                        double d5 = dArr[1];
                        double d6 = dArr[0];
                        double dSqrt = ((d5 + d6) - d3) / ((Math.sqrt(d6) * 2.0d) * Math.sqrt(dArr[1]));
                        if (d4 < d2) {
                            f2 = fE;
                            if (Math.abs(dSqrt) < f3) {
                                t2VarArr[0] = t2Var;
                                t2VarArr[1] = t2Var2;
                                c2 = 2;
                                t2VarArr[2] = t2Var3;
                                d2 = d4;
                            } else {
                                c2 = 2;
                            }
                        } else {
                            f2 = fE;
                        }
                    }
                    i4++;
                    fE = f2;
                }
            }
        }
        if (Double.MAX_VALUE != d2) {
            return t2VarArr;
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private float a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        s sVar = this.f4352a;
        int iC = sVar.c();
        int[] iArrD = d();
        if (c(i2, i3, i4, iArrD)) {
            return Float.NaN;
        }
        int i8 = i2 + 1;
        while (i8 < iC && !sVar.b(i3, i8)) {
            int i9 = iArrD[1];
            if (i9 > i4) {
                break;
            }
            iArrD[1] = i9 + 1;
            i8++;
        }
        if (i8 < 0 || iArrD[1] > i4) {
            return Float.NaN;
        }
        while (i8 < iC && sVar.b(i3, i8)) {
            iArrD[2] = iArrD[2] + 1;
            i8++;
        }
        if (i8 == iC) {
            return Float.NaN;
        }
        while (i8 < iC && !sVar.b(i3, i8) && (i7 = iArrD[3]) < i4) {
            iArrD[3] = i7 + 1;
            i8++;
        }
        if (i8 == iC || iArrD[3] >= i4) {
            return Float.NaN;
        }
        while (i8 < iC && sVar.b(i3, i8) && (i6 = iArrD[4]) < i4) {
            iArrD[4] = i6 + 1;
            i8++;
        }
        int i10 = iArrD[4];
        if (i10 >= i4 || Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + i10) - i5) * 5 >= i5 * 2) {
            return Float.NaN;
        }
        if (b3.d) {
            if (a(iArrD, true)) {
                return a(iArrD, i8);
            }
            return Float.NaN;
        }
        if (a(iArrD, false)) {
            return a(iArrD, i8);
        }
        return Float.NaN;
    }

    private float a(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        s sVar = this.f4352a;
        int iC = sVar.c();
        int i9 = i3;
        while (i9 <= i4) {
            int[] iArrD = d();
            int i10 = i2;
            while (i10 >= 0 && !sVar.b(i9, i10) && (i8 = iArrD[1]) <= i5) {
                iArrD[1] = i8 + 1;
                i10--;
            }
            if (i10 >= 0) {
                double d2 = ((double) i5) * 1.5d;
                if (iArrD[1] > d2) {
                    continue;
                } else {
                    while (i10 >= 0 && sVar.b(i9, i10) && (i7 = iArrD[0]) <= i5) {
                        iArrD[0] = i7 + 1;
                        i10--;
                    }
                    if (iArrD[0] > i5 / 2) {
                        continue;
                    } else {
                        int i11 = i2 + 1;
                        while (i11 < iC && !sVar.b(i9, i11)) {
                            int i12 = iArrD[1];
                            if (i12 > i5) {
                                break;
                            }
                            iArrD[1] = i12 + 1;
                            i11++;
                        }
                        if (i11 >= 0 && iArrD[1] <= d2) {
                            while (i11 < iC && sVar.b(i9, i11)) {
                                iArrD[2] = iArrD[2] + 1;
                                i11++;
                            }
                            if (Math.abs(((iArrD[0] + iArrD[1]) + iArrD[2]) - i6) * 5 < i6 * 2 && b(iArrD)) {
                                return (i11 - (iArrD[1] / 2)) - iArrD[2];
                            }
                        }
                    }
                }
            }
            i9 += i4 - i3;
        }
        return Float.NaN;
    }

    protected final boolean a(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float fA = a(iArr, i3);
        float fB = b(i2, (int) fA, iArr[2], i4, false);
        if (Float.isNaN(fB)) {
            int i5 = iArr[2];
            int i6 = iArr[1];
            int i7 = iArr[3];
            fB = a(i2, (int) ((fA - (i5 / 2)) - (i6 / 2)), (int) ((i5 / 2) + fA + (i7 / 2)), i6 + i5 + i7, i4);
        }
        if (Float.isNaN(fB)) {
            return false;
        }
        return a(false, fB, fA, i4 / 7.0f);
    }

    private boolean a(boolean z, float f2, float f3, float f4) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            t2 t2Var = this.c.get(i2);
            if (t2Var.b(f4, f2, f3)) {
                this.c.set(i2, t2Var.a(f2, f3, f4, false));
                return true;
            }
        }
        if (z) {
            return true;
        }
        t2 t2Var2 = new t2(f3, f2, f4, false);
        this.c.add(t2Var2);
        z5 z5Var = this.e;
        if (z5Var == null) {
            return true;
        }
        z5Var.a(t2Var2);
        return true;
    }

    private t2[] a() throws com.huawei.hms.scankit.p.a {
        t2 t2Var = this.b.get(0);
        t2 t2Var2 = this.b.get(1);
        float[] fArr = t2Var.b() < t2Var2.b() ? new float[]{t2Var.b(), t2Var2.b()} : new float[]{t2Var2.b(), t2Var.b()};
        float[] fArr2 = t2Var.b() < t2Var2.b() ? new float[]{t2Var.c(), t2Var2.c()} : new float[]{t2Var2.c(), t2Var.c()};
        float fE = (t2Var.e() + t2Var2.e()) / 2.0f;
        float fE2 = ((t2Var.e() + t2Var2.e()) * 7.0f) / 1.5f;
        if (Math.abs(fArr[0] - fArr[1]) > fE2 && Math.abs(fArr2[0] - fArr2[1]) <= fE2) {
            float f2 = fArr[0];
            float f3 = fArr2[0];
            this.b.add(new t2((f2 + f3) - fArr2[1], (f3 + fArr[1]) - f2, fE, false, 0));
        } else if (Math.abs(fArr[0] - fArr[1]) <= fE2 && Math.abs(fArr2[0] - fArr2[1]) > fE2) {
            float f4 = fArr[0];
            float f5 = fArr[1];
            if (f4 < f5) {
                float f6 = fArr2[0] + f5;
                float f7 = fArr2[1];
                this.b.add(new t2(f6 - f7, (f7 + f5) - f4, fE, false, 0));
            } else {
                float f8 = fArr2[1] + f4;
                float f9 = fArr2[0];
                this.b.add(new t2(f8 - f9, (f9 + f4) - f5, fE, false, 0));
            }
        } else if (Math.abs(fArr[0] - fArr[1]) > fE2 && Math.abs(fArr2[0] - fArr2[1]) > fE2) {
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr2[1];
            float f13 = fArr2[0];
            this.b.add(new t2((((f10 + f11) + f12) - f13) / 2.0f, (((f13 + f12) + f10) - f11) / 2.0f, fE, false, 0));
        }
        if (this.b.size() == 3) {
            return new t2[]{this.b.get(0), this.b.get(1), this.b.get(2)};
        }
        throw com.huawei.hms.scankit.p.a.a();
    }
}
