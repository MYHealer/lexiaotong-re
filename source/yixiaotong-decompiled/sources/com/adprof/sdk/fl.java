package com.adprof.sdk;

import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class fl extends q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int[] f1176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final transient byte[][] f296a;

    public fl(l6 l6Var, int i) {
        super(null);
        eo.a(l6Var.f1279a, 0L, i);
        dl dlVar = l6Var.f436a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = dlVar.b;
            int i6 = dlVar.f1133a;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            dlVar = dlVar.f224a;
        }
        this.f296a = new byte[i4][];
        this.f1176a = new int[i4 * 2];
        dl dlVar2 = l6Var.f436a;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.f296a;
            bArr[i7] = dlVar2.f226a;
            int i8 = dlVar2.b;
            int i9 = dlVar2.f1133a;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f1176a;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            dlVar2.f225a = true;
            i7++;
            dlVar2 = dlVar2.f224a;
        }
    }

    private Object writeReplace() {
        return m626a();
    }

    @Override // com.adprof.sdk.q6
    public byte a(int i) {
        eo.a(this.f1176a[this.f296a.length - 1], i, 1L);
        int iM625a = m625a(i);
        int i2 = iM625a == 0 ? 0 : this.f1176a[iM625a - 1];
        int[] iArr = this.f1176a;
        byte[][] bArr = this.f296a;
        return bArr[iM625a][(i - i2) + iArr[bArr.length + iM625a]];
    }

    @Override // com.adprof.sdk.q6
    public int a() {
        return this.f1176a[this.f296a.length - 1];
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final int m625a(int i) {
        int iBinarySearch = Arrays.binarySearch(this.f1176a, 0, this.f296a.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final q6 m626a() {
        int[] iArr = this.f1176a;
        byte[][] bArr = this.f296a;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f1176a;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f296a[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return new q6(bArr2);
    }

    @Override // com.adprof.sdk.q6
    public q6 a(int i, int i2) {
        return m626a().a(i, i2);
    }

    @Override // com.adprof.sdk.q6
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo627a() {
        return m626a().mo627a();
    }

    @Override // com.adprof.sdk.q6
    public void a(l6 l6Var) {
        int length = this.f296a.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f1176a;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            dl dlVar = new dl(this.f296a[i], i3, (i3 + i4) - i2);
            dl dlVar2 = l6Var.f436a;
            if (dlVar2 == null) {
                dlVar.f227b = dlVar;
                dlVar.f224a = dlVar;
                l6Var.f436a = dlVar;
            } else {
                dlVar2.f227b.a(dlVar);
            }
            i++;
            i2 = i4;
        }
        l6Var.f1279a += (long) i2;
    }

    @Override // com.adprof.sdk.q6
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > a() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iM625a = m625a(i);
        while (i3 > 0) {
            int i4 = iM625a == 0 ? 0 : this.f1176a[iM625a - 1];
            int iMin = Math.min(i3, ((this.f1176a[iM625a] - i4) + i4) - i);
            int[] iArr = this.f1176a;
            byte[][] bArr2 = this.f296a;
            if (!eo.a(bArr2[iM625a], (i - i4) + iArr[bArr2.length + iM625a], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iM625a++;
        }
        return true;
    }

    @Override // com.adprof.sdk.q6
    public String b() {
        q6 q6VarM626a = m626a();
        String str = q6VarM626a.f667a;
        if (str != null) {
            return str;
        }
        String str2 = new String(q6VarM626a.f668a, eo.f1157a);
        q6VarM626a.f667a = str2;
        return str2;
    }

    @Override // com.adprof.sdk.q6
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q6) {
            q6 q6Var = (q6) obj;
            if (q6Var.a() == a()) {
                int iA = a();
                if (a() - iA >= 0) {
                    int iM625a = m625a(0);
                    int i = 0;
                    int i2 = 0;
                    while (iA > 0) {
                        int i3 = iM625a == 0 ? 0 : this.f1176a[iM625a - 1];
                        int iMin = Math.min(iA, ((this.f1176a[iM625a] - i3) + i3) - i2);
                        int[] iArr = this.f1176a;
                        byte[][] bArr = this.f296a;
                        if (q6Var.a(i, bArr[iM625a], (i2 - i3) + iArr[bArr.length + iM625a], iMin)) {
                            i2 += iMin;
                            i += iMin;
                            iA -= iMin;
                            iM625a++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.adprof.sdk.q6
    public int hashCode() {
        int i = ((q6) this).f666a;
        if (i != 0) {
            return i;
        }
        int length = this.f296a.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f296a[i2];
            int[] iArr = this.f1176a;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        ((q6) this).f666a = i3;
        return i3;
    }

    @Override // com.adprof.sdk.q6
    public String toString() {
        return m626a().toString();
    }
}
