package com.jd.ad.sdk.jad_hk;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_fs extends AbstractList<jad_cp> implements RandomAccess {
    public final jad_cp[] jad_an;
    public final int[] jad_bo;

    public jad_fs(jad_cp[] jad_cpVarArr, int[] iArr) {
        this.jad_an = jad_cpVarArr;
        this.jad_bo = iArr;
    }

    public static void jad_an(long j, jad_an jad_anVar, int i, List<jad_cp> list, int i2, int i3, List<Integer> list2) {
        int iIntValue;
        int i4;
        int i5;
        long j2;
        jad_an jad_anVar2;
        int i6;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        for (int i7 = i2; i7 < i3; i7++) {
            if (list.get(i7).jad_cp() < i) {
                throw new AssertionError();
            }
        }
        jad_cp jad_cpVar = list.get(i2);
        jad_cp jad_cpVar2 = list.get(i3 - 1);
        if (i == jad_cpVar.jad_cp()) {
            int i8 = i2 + 1;
            i4 = i8;
            iIntValue = list2.get(i2).intValue();
            jad_cpVar = list.get(i8);
        } else {
            iIntValue = -1;
            i4 = i2;
        }
        long j3 = 4;
        if (jad_cpVar.jad_an(i) != jad_cpVar2.jad_an(i)) {
            int i9 = 1;
            for (int i10 = i4 + 1; i10 < i3; i10++) {
                if (list.get(i10 - 1).jad_an(i) != list.get(i10).jad_an(i)) {
                    i9++;
                }
            }
            long j4 = j + ((long) ((int) (jad_anVar.jad_bo / 4))) + 2 + ((long) (i9 * 2));
            jad_anVar.jad_cp(i9);
            jad_anVar.jad_cp(iIntValue);
            for (int i11 = i4; i11 < i3; i11++) {
                byte bJad_an = list.get(i11).jad_an(i);
                if (i11 == i4 || bJad_an != list.get(i11 - 1).jad_an(i)) {
                    jad_anVar.jad_cp(bJad_an & 255);
                }
            }
            jad_anVar2 = new jad_an();
            int i12 = i4;
            while (i12 < i3) {
                byte bJad_an2 = list.get(i12).jad_an(i);
                int i13 = i12 + 1;
                int i14 = i13;
                while (true) {
                    if (i14 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (bJad_an2 != list.get(i14).jad_an(i)) {
                            i6 = i14;
                            break;
                        }
                        i14++;
                    }
                }
                if (i13 == i6 && i + 1 == list.get(i12).jad_cp()) {
                    jad_anVar.jad_cp(list2.get(i12).intValue());
                } else {
                    jad_anVar.jad_cp((int) ((((long) ((int) (jad_anVar2.jad_bo / j3))) + j4) * (-1)));
                    jad_an(j4, jad_anVar2, i + 1, list, i12, i6, list2);
                }
                jad_anVar2 = jad_anVar2;
                i12 = i6;
                j3 = 4;
            }
            j2 = jad_anVar2.jad_bo;
        } else {
            int iMin = Math.min(jad_cpVar.jad_cp(), jad_cpVar2.jad_cp());
            int i15 = 0;
            for (int i16 = i; i16 < iMin && jad_cpVar.jad_an(i16) == jad_cpVar2.jad_an(i16); i16++) {
                i15++;
            }
            long j5 = 1 + j + ((long) ((int) (jad_anVar.jad_bo / 4))) + 2 + ((long) i15);
            jad_anVar.jad_cp(-i15);
            jad_anVar.jad_cp(iIntValue);
            int i17 = i;
            while (true) {
                i5 = i + i15;
                if (i17 >= i5) {
                    break;
                }
                jad_anVar.jad_cp(jad_cpVar.jad_an(i17) & 255);
                i17++;
            }
            if (i4 + 1 == i3) {
                if (i5 != list.get(i4).jad_cp()) {
                    throw new AssertionError();
                }
                jad_anVar.jad_cp(list2.get(i4).intValue());
                return;
            } else {
                jad_an jad_anVar3 = new jad_an();
                jad_anVar.jad_cp((int) ((((long) ((int) (jad_anVar3.jad_bo / 4))) + j5) * (-1)));
                jad_an(j5, jad_anVar3, i5, list, i4, i3, list2);
                j2 = jad_anVar3.jad_bo;
                jad_anVar2 = jad_anVar3;
            }
        }
        jad_anVar.jad_bo(jad_anVar2, j2);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return this.jad_an[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.jad_an.length;
    }

    public static jad_fs jad_an(jad_cp... jad_cpVarArr) {
        int iJad_bo;
        if (jad_cpVarArr.length == 0) {
            return new jad_fs(new jad_cp[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(jad_cpVarArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, jad_cpVarArr[i2]), Integer.valueOf(i2));
        }
        if (((jad_cp) arrayList.get(0)).jad_cp() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            jad_cp jad_cpVar = (jad_cp) arrayList.get(i3);
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 < arrayList.size()) {
                jad_cp jad_cpVar2 = (jad_cp) arrayList.get(i5);
                jad_cpVar2.getClass();
                if (!jad_cpVar2.jad_an(0, jad_cpVar, 0, jad_cpVar.jad_cp())) {
                    break;
                }
                if (jad_cpVar2.jad_cp() == jad_cpVar.jad_cp()) {
                    throw new IllegalArgumentException("duplicate option: " + jad_cpVar2);
                }
                if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                    arrayList.remove(i5);
                    arrayList2.remove(i5);
                } else {
                    i5++;
                }
            }
            i3 = i4;
        }
        jad_an jad_anVar = new jad_an();
        jad_an(0L, jad_anVar, 0, arrayList, 0, arrayList.size(), arrayList2);
        int i6 = (int) (jad_anVar.jad_bo / 4);
        int[] iArr = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            long j = jad_anVar.jad_bo;
            if (j >= 4) {
                jad_jw jad_jwVar = jad_anVar.jad_an;
                int i8 = jad_jwVar.jad_bo;
                int i9 = jad_jwVar.jad_cp;
                if (i9 - i8 < 4) {
                    iJad_bo = ((jad_anVar.jad_bo() & 255) << 24) | ((jad_anVar.jad_bo() & 255) << 16) | ((jad_anVar.jad_bo() & 255) << 8) | (jad_anVar.jad_bo() & 255);
                } else {
                    byte[] bArr = jad_jwVar.jad_an;
                    int i10 = i8 + 3;
                    int i11 = ((bArr[i8 + 1] & 255) << 16) | ((bArr[i8] & 255) << 24) | ((bArr[i8 + 2] & 255) << 8);
                    int i12 = i8 + 4;
                    int i13 = (bArr[i10] & 255) | i11;
                    jad_anVar.jad_bo = j - 4;
                    if (i12 == i9) {
                        jad_anVar.jad_an = jad_jwVar.jad_an();
                        jad_kx.jad_an(jad_jwVar);
                    } else {
                        jad_jwVar.jad_bo = i12;
                    }
                    iJad_bo = i13;
                }
                iArr[i7] = iJad_bo;
            } else {
                throw new IllegalStateException(jad_pc.jad_an("size < 4: ").append(jad_anVar.jad_bo).toString());
            }
        }
        if (jad_anVar.jad_bo == 0) {
            return new jad_fs((jad_cp[]) jad_cpVarArr.clone(), iArr);
        }
        throw new AssertionError();
    }
}
