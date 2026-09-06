package com.ubix.ssp.ad.e.a0.y.e.f;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    private int d;
    private int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f8746a = new b(310);
    private c[] b = new c[310];
    private d[] c = new d[310];
    private double[] f = new double[310];

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.y.e.f.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C1089a {
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        C1090a[] f8747a;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.y.e.f.a$b$a, reason: collision with other inner class name */
        class C1090a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f8748a;
            int b;
            int c;
            double d;

            C1090a() {
            }

            double a() {
                return a.this.f[this.b + 1] - a.this.f[this.f8748a];
            }

            void a(int i, int i2) {
                this.f8748a = i;
                this.b = i2;
                this.d = 0.0d;
                this.c = 0;
            }

            int b() {
                return (this.f8748a + this.b) >> 1;
            }
        }

        public b(int i) {
            int i2 = i * 3;
            this.f8747a = new C1090a[i2];
            for (int i3 = 1; i3 < i2; i3++) {
                this.f8747a[i3] = new C1090a();
            }
        }

        void a(int i) {
            C1090a c1090a;
            double dA;
            C1090a[] c1090aArr = this.f8747a;
            if (c1090aArr[i].c > 0) {
                c1090a = c1090aArr[i];
                dA = c1090a.a();
            } else {
                if (c1090aArr[i].f8748a != c1090aArr[i].b) {
                    C1090a c1090a2 = c1090aArr[i];
                    int i2 = i << 1;
                    c1090a2.d = c1090aArr[i2].d + c1090aArr[i2 | 1].d;
                    return;
                }
                c1090a = c1090aArr[i];
                dA = 0.0d;
            }
            c1090a.d = dA;
        }

        void a(int i, int i2, int i3) {
            this.f8747a[i3].a(i, i2);
            if (i == i2) {
                return;
            }
            int iB = this.f8747a[i3].b();
            int i4 = i3 << 1;
            a(i, iB, i4);
            a(iB + 1, i2, i4 | 1);
        }

        void a(int i, int i2, int i3, int i4) {
            C1090a[] c1090aArr = this.f8747a;
            if (c1090aArr[i3].f8748a >= i && c1090aArr[i3].b <= i2) {
                c1090aArr[i3].c += i4;
                a(i3);
            } else {
                int iB = c1090aArr[i3].b();
                if (i <= iB) {
                    a(i, i2, i3 << 1, i4);
                }
                if (i2 > iB) {
                    a(i, i2, (i3 << 1) | 1, i4);
                }
                a(i3);
            }
        }
    }

    private class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8749a;
        int b;
        int c;
        double d;

        private c() {
        }

        /* synthetic */ c(a aVar, C1089a c1089a) {
            this();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            double d = this.d;
            double d2 = cVar.d;
            if (d < d2) {
                return -1;
            }
            return (d != d2 || this.c <= cVar.c) ? 1 : -1;
        }
    }

    private class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8750a;
        double b;

        private d() {
        }

        /* synthetic */ d(a aVar, C1089a c1089a) {
            this();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.b < dVar.b ? -1 : 1;
        }
    }

    public a() {
        for (int i = 0; i <= 300; i += 2) {
            C1089a c1089a = null;
            this.b[i] = new c(this, c1089a);
            int i2 = i + 1;
            this.b[i2] = new c(this, c1089a);
            this.c[i] = new d(this, c1089a);
            this.c[i2] = new d(this, c1089a);
        }
    }

    private void a() {
        Arrays.sort(this.c, 1, (this.d * 2) + 1);
        this.e = 1;
        for (int i = 1; i <= this.d * 2; i++) {
            if (i > 1) {
                d[] dVarArr = this.c;
                if (dVarArr[i].b != dVarArr[i - 1].b) {
                    this.e++;
                }
            }
            double[] dArr = this.f;
            int i2 = this.e;
            d[] dVarArr2 = this.c;
            dArr[i2] = dVarArr2[i].b;
            int i3 = dVarArr2[i].f8750a;
            c[] cVarArr = this.b;
            if (i3 > 0) {
                c cVar = cVarArr[i3];
                cVarArr[i3 + 1].f8749a = i2;
                cVar.f8749a = i2;
            } else {
                int i4 = -i3;
                c cVar2 = cVarArr[i4];
                cVarArr[i4 + 1].b = i2;
                cVar2.b = i2;
            }
        }
    }

    private void b(List<com.ubix.ssp.ad.e.a0.y.e.f.b> list) {
        int i = 1;
        for (com.ubix.ssp.ad.e.a0.y.e.f.b bVar : list) {
            c[] cVarArr = this.b;
            cVarArr[i].d = bVar.f8751a;
            cVarArr[i].c = 1;
            d[] dVarArr = this.c;
            dVarArr[i].f8750a = i;
            dVarArr[i].b = bVar.b;
            int i2 = i + 1;
            cVarArr[i2].d = bVar.c;
            cVarArr[i2].c = -1;
            dVarArr[i2].f8750a = -i;
            dVarArr[i2].b = bVar.d;
            i += 2;
        }
    }

    public double a(List<com.ubix.ssp.ad.e.a0.y.e.f.b> list) {
        double d2 = 0.0d;
        try {
            System.currentTimeMillis();
            this.d = list.size();
            b(list);
            a();
            Arrays.sort(this.b, 1, (this.d * 2) + 1);
            this.f8746a.a(1, this.e - 1, 1);
            b bVar = this.f8746a;
            c[] cVarArr = this.b;
            bVar.a(cVarArr[1].f8749a, cVarArr[1].b - 1, 1, 1);
            for (int i = 2; i <= this.d * 2; i++) {
                b bVar2 = this.f8746a;
                double d3 = bVar2.f8747a[1].d;
                c[] cVarArr2 = this.b;
                d2 += d3 * (cVarArr2[i].d - cVarArr2[i - 1].d);
                bVar2.a(cVarArr2[i].f8749a, cVarArr2[i].b - 1, 1, cVarArr2[i].c);
            }
            System.currentTimeMillis();
            new DecimalFormat("0.00");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return d2;
    }
}
