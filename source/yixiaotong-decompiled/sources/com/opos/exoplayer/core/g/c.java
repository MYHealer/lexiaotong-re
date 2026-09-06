package com.opos.exoplayer.core.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.e.l;
import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f6467a = new int[0];
    private final f.a b;
    private final AtomicReference<a> c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6468a = new a();
        public final String b;
        public final String c;
        public final boolean d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final int j;
        public final int k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;

        private a() {
            this(null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        private a(String str, String str2, boolean z, int i, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4, boolean z5, boolean z6, int i5, int i6, boolean z7) {
            this.b = y.b(str);
            this.c = y.b(str2);
            this.d = z;
            this.e = i;
            this.m = z2;
            this.n = z3;
            this.o = z4;
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.i = z5;
            this.p = z6;
            this.j = i5;
            this.k = i6;
            this.l = z7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.d == aVar.d && this.e == aVar.e && this.m == aVar.m && this.n == aVar.n && this.o == aVar.o && this.f == aVar.f && this.g == aVar.g && this.i == aVar.i && this.p == aVar.p && this.l == aVar.l && this.j == aVar.j && this.k == aVar.k && this.h == aVar.h && TextUtils.equals(this.b, aVar.b) && TextUtils.equals(this.c, aVar.c);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((this.d ? 1 : 0) * 31) + this.e) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + (this.o ? 1 : 0)) * 31) + this.f) * 31) + this.g) * 31) + (this.i ? 1 : 0)) * 31) + (this.p ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + this.j) * 31) + this.k) * 31) + this.h) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6469a;
        public final int b;
        public final String c;

        public b(int i, int i2, String str) {
            this.f6469a = i;
            this.b = i2;
            this.c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f6469a == bVar.f6469a && this.b == bVar.b && TextUtils.equals(this.c, bVar.c);
        }

        public int hashCode() {
            int i = ((this.f6469a * 31) + this.b) * 31;
            String str = this.c;
            return i + (str != null ? str.hashCode() : 0);
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.g.c$c, reason: collision with other inner class name */
    private static final class C0928c implements Comparable<C0928c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f6470a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;

        public C0928c(Format format, a aVar, int i) {
            this.f6470a = aVar;
            this.b = c.a(i, false) ? 1 : 0;
            this.c = c.a(format, aVar.b) ? 1 : 0;
            this.d = (format.x & 1) != 0 ? 1 : 0;
            this.e = format.r;
            this.f = format.s;
            this.g = format.b;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0928c c0928c) {
            int i = this.b;
            int i2 = c0928c.b;
            if (i != i2) {
                return c.c(i, i2);
            }
            int i3 = this.c;
            int i4 = c0928c.c;
            if (i3 != i4) {
                return c.c(i3, i4);
            }
            int i5 = this.d;
            int i6 = c0928c.d;
            if (i5 != i6) {
                return c.c(i5, i6);
            }
            if (this.f6470a.m) {
                return c.c(c0928c.g, this.g);
            }
            int i7 = i != 1 ? -1 : 1;
            int i8 = this.e;
            int i9 = c0928c.e;
            return i7 * ((i8 == i9 && (i8 = this.f) == (i9 = c0928c.f)) ? c.c(this.g, c0928c.g) : c.c(i8, i9));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0928c.class != obj.getClass()) {
                return false;
            }
            C0928c c0928c = (C0928c) obj;
            return this.b == c0928c.b && this.c == c0928c.c && this.d == c0928c.d && this.e == c0928c.e && this.f == c0928c.f && this.g == c0928c.g;
        }

        public int hashCode() {
            return (((((((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        }
    }

    public c() {
        this(null);
    }

    public c(f.a aVar) {
        this.b = aVar;
        this.c = new AtomicReference<>(a.f6468a);
    }

    private static int a(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int iIntValue = list.get(i6).intValue();
            if (a(lVar.a(iIntValue), str, iArr[iIntValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    private static int a(l lVar, int[] iArr, b bVar) {
        int i = 0;
        for (int i2 = 0; i2 < lVar.f6402a; i2++) {
            if (a(lVar.a(i2), iArr[i2], bVar)) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0010  */
    private static Point a(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if ((i3 > i4) == (i > i2)) {
                i2 = i;
                i = i2;
            }
        } else {
            i2 = i;
            i = i2;
        }
        int i5 = i3 * i;
        int i6 = i4 * i2;
        return i5 >= i6 ? new Point(i2, y.a(i6, i3)) : new Point(y.a(i5, i4), i);
    }

    private static List<Integer> a(l lVar, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(lVar.f6402a);
        for (int i4 = 0; i4 < lVar.f6402a; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i5 = Integer.MAX_VALUE;
            for (int i6 = 0; i6 < lVar.f6402a; i6++) {
                Format formatA = lVar.a(i6);
                int i7 = formatA.j;
                if (i7 > 0 && (i3 = formatA.k) > 0) {
                    Point pointA = a(z, i, i2, i7, i3);
                    int i8 = formatA.j;
                    int i9 = formatA.k;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (pointA.x * 0.98f)) && i9 >= ((int) (pointA.y * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
            if (i5 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int iA = lVar.a(((Integer) arrayList.get(size)).intValue()).a();
                    if (iA == -1 || iA > i5) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    protected static boolean a(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    protected static boolean a(Format format) {
        return TextUtils.isEmpty(format.y) || a(format, C.LANGUAGE_UNDETERMINED);
    }

    private static boolean a(Format format, int i, b bVar) {
        if (!a(i, false) || format.r != bVar.f6469a || format.s != bVar.b) {
            return false;
        }
        String str = bVar.c;
        return str == null || TextUtils.equals(str, format.f);
    }

    protected static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, y.b(format.y));
    }

    private static boolean a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!a(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !y.a(format.f, str)) {
            return false;
        }
        int i6 = format.j;
        if (i6 != -1 && i6 > i3) {
            return false;
        }
        int i7 = format.k;
        if (i7 != -1 && i7 > i4) {
            return false;
        }
        int i8 = format.b;
        return i8 == -1 || i8 <= i5;
    }

    private static int[] a(l lVar, int[] iArr, boolean z) {
        int iA;
        HashSet hashSet = new HashSet();
        int i = 0;
        b bVar = null;
        for (int i2 = 0; i2 < lVar.f6402a; i2++) {
            Format formatA = lVar.a(i2);
            b bVar2 = new b(formatA.r, formatA.s, z ? null : formatA.f);
            if (hashSet.add(bVar2) && (iA = a(lVar, iArr, bVar2)) > i) {
                i = iA;
                bVar = bVar2;
            }
        }
        if (i <= 1) {
            return f6467a;
        }
        int[] iArr2 = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < lVar.f6402a; i4++) {
            if (a(lVar.a(i4), iArr[i4], bVar)) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return iArr2;
    }

    private static int[] a(l lVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        String str;
        int iA;
        if (lVar.f6402a < 2) {
            return f6467a;
        }
        List<Integer> listA = a(lVar, i5, i6, z2);
        if (listA.size() < 2) {
            return f6467a;
        }
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i7 = 0;
            for (int i8 = 0; i8 < listA.size(); i8++) {
                String str3 = lVar.a(listA.get(i8).intValue()).f;
                if (hashSet.add(str3) && (iA = a(lVar, iArr, i, str3, i2, i3, i4, listA)) > i7) {
                    i7 = iA;
                    str2 = str3;
                }
            }
            str = str2;
        }
        b(lVar, iArr, i, str, i2, i3, i4, listA);
        return listA.size() < 2 ? f6467a : y.a(listA);
    }

    private static int b(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00a3  */
    private static f b(m mVar, int[][] iArr, a aVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        int iA = -1;
        int i5 = -1;
        int i6 = 0;
        l lVar = null;
        int i7 = 0;
        int i8 = 0;
        while (i6 < mVar.b) {
            l lVarA = mVar.a(i6);
            List<Integer> listA = a(lVarA, aVar.j, aVar.k, aVar.l);
            int[] iArr2 = iArr[i6];
            int i9 = 0;
            while (i9 < lVarA.f6402a) {
                if (a(iArr2[i9], aVar.p)) {
                    Format formatA = lVarA.a(i9);
                    boolean z = listA.contains(Integer.valueOf(i9)) && ((i = formatA.j) == i4 || i <= aVar.f) && (((i2 = formatA.k) == i4 || i2 <= aVar.g) && ((i3 = formatA.b) == i4 || i3 <= aVar.h));
                    if (z || aVar.i) {
                        int i10 = z ? 2 : 1;
                        boolean zA = a(iArr2[i9], false);
                        if (zA) {
                            i10 += 1000;
                        }
                        boolean z2 = i10 > i8;
                        if (i10 == i8) {
                            if (!aVar.m) {
                                int iA2 = formatA.a();
                                int iB = iA2 != iA ? b(iA2, iA) : b(formatA.b, i5);
                                if (zA && z) {
                                    if (iB > 0) {
                                        i5 = formatA.b;
                                        iA = formatA.a();
                                        lVar = lVarA;
                                        i7 = i9;
                                        i8 = i10;
                                    }
                                } else if (iB < 0) {
                                    i5 = formatA.b;
                                    iA = formatA.a();
                                    lVar = lVarA;
                                    i7 = i9;
                                    i8 = i10;
                                }
                            } else if (b(formatA.b, i5) < 0) {
                                i5 = formatA.b;
                                iA = formatA.a();
                                lVar = lVarA;
                                i7 = i9;
                                i8 = i10;
                            }
                        } else if (z2) {
                            i5 = formatA.b;
                            iA = formatA.a();
                            lVar = lVarA;
                            i7 = i9;
                            i8 = i10;
                        }
                    }
                }
                i9++;
                i4 = -1;
            }
            i6++;
            i4 = -1;
        }
        if (lVar == null) {
            return null;
        }
        return new d(lVar, i7);
    }

    private static f b(u uVar, m mVar, int[][] iArr, a aVar, f.a aVar2) {
        int i = aVar.o ? 24 : 16;
        boolean z = aVar.n && (uVar.m() & i) != 0;
        for (int i2 = 0; i2 < mVar.b; i2++) {
            l lVarA = mVar.a(i2);
            int[] iArrA = a(lVarA, iArr[i2], z, i, aVar.f, aVar.g, aVar.h, aVar.j, aVar.k, aVar.l);
            if (iArrA.length > 0) {
                return aVar2.b(lVarA, iArrA);
            }
        }
        return null;
    }

    private static void b(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!a(lVar.a(iIntValue), str, iArr[iIntValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    protected f a(int i, m mVar, int[][] iArr, a aVar) {
        l lVar = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < mVar.b; i4++) {
            l lVarA = mVar.a(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < lVarA.f6402a; i5++) {
                if (a(iArr2[i5], aVar.p)) {
                    int i6 = (lVarA.a(i5).x & 1) != 0 ? 2 : 1;
                    if (a(iArr2[i5], false)) {
                        i6 += 1000;
                    }
                    if (i6 > i3) {
                        lVar = lVarA;
                        i2 = i5;
                        i3 = i6;
                    }
                }
            }
        }
        if (lVar == null) {
            return null;
        }
        return new d(lVar, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected f a(m mVar, int[][] iArr, a aVar) {
        int i = 0;
        int i2 = 0;
        l lVar = null;
        for (int i3 = 0; i3 < mVar.b; i3++) {
            l lVarA = mVar.a(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < lVarA.f6402a; i4++) {
                if (a(iArr2[i4], aVar.p)) {
                    Format formatA = lVarA.a(i4);
                    int i5 = formatA.x & (~aVar.e);
                    int i6 = 1;
                    Object[] objArr = (i5 & 1) != 0;
                    Object[] objArr2 = (i5 & 2) != 0;
                    boolean zA = a(formatA, aVar.c);
                    if (zA || (aVar.d && a(formatA))) {
                        i6 = (objArr == true ? 8 : objArr2 == false ? 6 : 4) + (zA ? 1 : 0);
                    } else if (objArr == true) {
                        i6 = 3;
                    } else if (objArr2 != false) {
                        if (a(formatA, aVar.b)) {
                            i6 = 2;
                        }
                    }
                    if (a(iArr2[i4], false)) {
                        i6 += 1000;
                    }
                    if (i6 > i2) {
                        lVar = lVarA;
                        i = i4;
                        i2 = i6;
                    }
                }
            }
        }
        if (lVar == null) {
            return null;
        }
        return new d(lVar, i);
    }

    protected f a(m mVar, int[][] iArr, a aVar, f.a aVar2) {
        int i = -1;
        int i2 = -1;
        C0928c c0928c = null;
        for (int i3 = 0; i3 < mVar.b; i3++) {
            l lVarA = mVar.a(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < lVarA.f6402a; i4++) {
                if (a(iArr2[i4], aVar.p)) {
                    C0928c c0928c2 = new C0928c(lVarA.a(i4), aVar, iArr2[i4]);
                    if (c0928c == null || c0928c2.compareTo(c0928c) > 0) {
                        i = i3;
                        i2 = i4;
                        c0928c = c0928c2;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        l lVarA2 = mVar.a(i);
        if (!aVar.m && aVar2 != null) {
            int[] iArrA = a(lVarA2, iArr[i], aVar.n);
            if (iArrA.length > 0) {
                return aVar2.b(lVarA2, iArrA);
            }
        }
        return new d(lVarA2, i2);
    }

    protected f a(u uVar, m mVar, int[][] iArr, a aVar, f.a aVar2) {
        f fVarB = (aVar.m || aVar2 == null) ? null : b(uVar, mVar, iArr, aVar, aVar2);
        return fVarB == null ? b(mVar, iArr, aVar) : fVarB;
    }

    @Override // com.opos.exoplayer.core.g.e
    protected f[] a(u[] uVarArr, m[] mVarArr, int[][][] iArr) {
        int length = uVarArr.length;
        f[] fVarArr = new f[length];
        a aVar = this.c.get();
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (true) {
            if (i >= length) {
                break;
            }
            if (2 == uVarArr[i].a()) {
                if (!z) {
                    f fVarA = a(uVarArr[i], mVarArr[i], iArr[i], aVar, this.b);
                    fVarArr[i] = fVarA;
                    z = fVarA != null;
                }
                z2 |= mVarArr[i].b > 0;
            }
            i++;
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i2 = 0; i2 < length; i2++) {
            int iA = uVarArr[i2].a();
            if (iA != 1) {
                if (iA != 2) {
                    if (iA != 3) {
                        fVarArr[i2] = a(uVarArr[i2].a(), mVarArr[i2], iArr[i2], aVar);
                    } else if (!z4) {
                        f fVarA2 = a(mVarArr[i2], iArr[i2], aVar);
                        fVarArr[i2] = fVarA2;
                        z4 = fVarA2 != null;
                    }
                }
            } else if (!z3) {
                f fVarA3 = a(mVarArr[i2], iArr[i2], aVar, z2 ? null : this.b);
                fVarArr[i2] = fVarA3;
                z3 = fVarA3 != null;
            }
        }
        return fVarArr;
    }
}
