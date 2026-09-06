package com.opos.exoplayer.core.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.opos.exoplayer.core.e.l;
import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.u;
import com.opos.exoplayer.core.v;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class e extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<Map<m, b>> f6471a = new SparseArray<>();
    private final SparseBooleanArray b = new SparseBooleanArray();
    private int c = 0;
    private a d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6472a;
        private final int[] b;
        private final m[] c;
        private final int[] d;
        private final int[][][] e;
        private final m f;

        a(int[] iArr, m[] mVarArr, int[] iArr2, int[][][] iArr3, m mVar) {
            this.b = iArr;
            this.c = mVarArr;
            this.e = iArr3;
            this.d = iArr2;
            this.f = mVar;
            this.f6472a = mVarArr.length;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f.a f6473a;
        public final int b;
        public final int[] c;

        public f a(m mVar) {
            return this.f6473a.b(mVar.a(this.b), this.c);
        }
    }

    private static int a(u[] uVarArr, l lVar) {
        int length = uVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < uVarArr.length; i2++) {
            u uVar = uVarArr[i2];
            for (int i3 = 0; i3 < lVar.f6402a; i3++) {
                int iA = uVar.a(lVar.a(i3)) & 7;
                if (iA > i) {
                    if (iA == 4) {
                        return i2;
                    }
                    length = i2;
                    i = iA;
                }
            }
        }
        return length;
    }

    private static void a(u[] uVarArr, m[] mVarArr, int[][][] iArr, v[] vVarArr, f[] fVarArr, int i) {
        boolean z;
        if (i == 0) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            if (i2 >= uVarArr.length) {
                z = true;
                break;
            }
            int iA = uVarArr[i2].a();
            f fVar = fVarArr[i2];
            if ((iA == 1 || iA == 2) && fVar != null && a(iArr[i2], mVarArr[i2], fVar)) {
                if (iA == 1) {
                    if (i4 != -1) {
                        z = false;
                        break;
                    }
                    i4 = i2;
                } else {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i2;
                }
            }
            i2++;
        }
        if (i4 != -1 && i3 != -1) {
            z2 = true;
        }
        if (z && z2) {
            v vVar = new v(i);
            vVarArr[i4] = vVar;
            vVarArr[i3] = vVar;
        }
    }

    private static boolean a(int[][] iArr, m mVar, f fVar) {
        if (fVar == null) {
            return false;
        }
        int iA = mVar.a(fVar.d());
        for (int i = 0; i < fVar.e(); i++) {
            if ((iArr[iA][fVar.b(i)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    private static int[] a(u uVar, l lVar) {
        int[] iArr = new int[lVar.f6402a];
        for (int i = 0; i < lVar.f6402a; i++) {
            iArr[i] = uVar.a(lVar.a(i));
        }
        return iArr;
    }

    private static int[] a(u[] uVarArr) {
        int length = uVarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = uVarArr[i].m();
        }
        return iArr;
    }

    private boolean[] a(u[] uVarArr, f[] fVarArr) {
        int length = fVarArr.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = !this.b.get(i) && (uVarArr[i].a() == 5 || fVarArr[i] != null);
        }
        return zArr;
    }

    @Override // com.opos.exoplayer.core.g.h
    public final i a(u[] uVarArr, m mVar) {
        int[] iArr = new int[uVarArr.length + 1];
        int length = uVarArr.length + 1;
        l[][] lVarArr = new l[length][];
        int[][][] iArr2 = new int[uVarArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = mVar.b;
            lVarArr[i] = new l[i2];
            iArr2[i] = new int[i2][];
        }
        int[] iArrA = a(uVarArr);
        for (int i3 = 0; i3 < mVar.b; i3++) {
            l lVarA = mVar.a(i3);
            int iA = a(uVarArr, lVarA);
            int[] iArrA2 = iA == uVarArr.length ? new int[lVarA.f6402a] : a(uVarArr[iA], lVarA);
            int i4 = iArr[iA];
            lVarArr[iA][i4] = lVarA;
            iArr2[iA][i4] = iArrA2;
            iArr[iA] = i4 + 1;
        }
        m[] mVarArr = new m[uVarArr.length];
        int[] iArr3 = new int[uVarArr.length];
        for (int i5 = 0; i5 < uVarArr.length; i5++) {
            int i6 = iArr[i5];
            mVarArr[i5] = new m((l[]) Arrays.copyOf(lVarArr[i5], i6));
            iArr2[i5] = (int[][]) Arrays.copyOf(iArr2[i5], i6);
            iArr3[i5] = uVarArr[i5].a();
        }
        m mVar2 = new m((l[]) Arrays.copyOf(lVarArr[uVarArr.length], iArr[uVarArr.length]));
        f[] fVarArrA = a(uVarArr, mVarArr, iArr2);
        int i7 = 0;
        while (true) {
            if (i7 >= uVarArr.length) {
                break;
            }
            if (this.b.get(i7)) {
                fVarArrA[i7] = null;
            } else {
                m mVar3 = mVarArr[i7];
                if (a(i7, mVar3)) {
                    b bVar = this.f6471a.get(i7).get(mVar3);
                    fVarArrA[i7] = bVar != null ? bVar.a(mVar3) : null;
                }
            }
            i7++;
        }
        boolean[] zArrA = a(uVarArr, fVarArrA);
        a aVar = new a(iArr3, mVarArr, iArrA, iArr2, mVar2);
        v[] vVarArr = new v[uVarArr.length];
        for (int i8 = 0; i8 < uVarArr.length; i8++) {
            vVarArr[i8] = zArrA[i8] ? v.f6547a : null;
        }
        a(uVarArr, mVarArr, iArr2, vVarArr, fVarArrA, this.c);
        return new i(mVar, zArrA, new g(fVarArrA), aVar, vVarArr);
    }

    @Override // com.opos.exoplayer.core.g.h
    public final void a(Object obj) {
        this.d = (a) obj;
    }

    public final boolean a(int i, m mVar) {
        Map<m, b> map = this.f6471a.get(i);
        return map != null && map.containsKey(mVar);
    }

    protected abstract f[] a(u[] uVarArr, m[] mVarArr, int[][][] iArr);
}
