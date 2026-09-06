package com.huawei.hms.scankit.p;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: HighLevelEncoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class l3 {
    static final String[] b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    private static final int[][] d;
    static final int[][] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f4302a;

    /* JADX INFO: compiled from: HighLevelEncoder.java */
    static class a<State> implements Comparator<e6> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e6 e6Var, e6 e6Var2) {
            return e6Var.b() - e6Var2.b();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        d = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            d[0][i] = i - 63;
        }
        d[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            d[1][i2] = i2 - 95;
        }
        d[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            d[2][i3] = i3 - 46;
        }
        int[] iArr2 = d[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 126, 127};
        for (int i4 = 0; i4 < 28; i4++) {
            d[3][iArr3[i4]] = i4;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, AppTypeIdUtil.NewDevice4GBathOTA, AppTypeIdUtil.NewDevice4GDrinkOTA_2};
        for (int i5 = 0; i5 < 31; i5++) {
            int i6 = iArr4[i5];
            if (i6 > 0) {
                d[4][i6] = i5;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = e;
        if (y6.a(iArr7, 0) && y6.a(iArr7[0], 4)) {
            iArr7[0][4] = 0;
        }
        if (y6.a(iArr7, 1) && y6.a(iArr7[1], 4)) {
            iArr7[1][4] = 0;
        }
        if (y6.a(iArr7, 1) && y6.a(iArr7[1], 0)) {
            iArr7[1][0] = 28;
        }
        if (y6.a(iArr7, 3) && y6.a(iArr7[3], 4)) {
            iArr7[3][4] = 0;
        }
        if (y6.a(iArr7, 2) && y6.a(iArr7[2], 4)) {
            iArr7[2][4] = 0;
        }
        if (y6.a(iArr7, 2) && y6.a(iArr7[2], 0)) {
            iArr7[2][0] = 15;
        }
    }

    public l3(byte[] bArr) {
        this.f4302a = bArr;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x003d  */
    public r a() {
        int i;
        Collection<e6> collectionSingletonList = Collections.singletonList(e6.e);
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f4302a;
            if (i2 >= bArr.length) {
                return ((e6) Collections.min(collectionSingletonList, new a())).a(this.f4302a);
            }
            int i3 = i2 + 1;
            byte b2 = i3 < bArr.length ? bArr[i3] : (byte) 0;
            byte b3 = bArr[i2];
            if (b3 != 13) {
                if (b3 != 44) {
                    if (b3 != 46) {
                        if (b3 == 58 && b2 == 32) {
                            i = 5;
                        } else {
                            i = 0;
                        }
                    } else if (b2 == 32) {
                        i = 3;
                    } else {
                        i = 0;
                    }
                } else if (b2 == 32) {
                    i = 4;
                } else {
                    i = 0;
                }
            } else if (b2 == 10) {
                i = 2;
            } else {
                i = 0;
            }
            if (i > 0) {
                collectionSingletonList = a(collectionSingletonList, i2, i);
                i2 = i3;
            } else {
                collectionSingletonList = a(collectionSingletonList, i2);
            }
            i2++;
        }
    }

    private Collection<e6> a(Iterable<e6> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator<e6> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i, linkedList);
        }
        return a(linkedList);
    }

    private void a(e6 e6Var, int i, Collection<e6> collection) {
        if (y6.a(this.f4302a, i)) {
            char c2 = (char) (this.f4302a[i] & 255);
            int[][] iArr = d;
            boolean z = y6.a(iArr, e6Var.c()) && y6.a(iArr[e6Var.c()], (int) c2) && iArr[e6Var.c()][c2] > 0;
            e6 e6VarB = null;
            for (int i2 = 0; i2 <= 4; i2++) {
                int[][] iArr2 = d;
                int i3 = (y6.a(iArr2, i2) && y6.a(iArr2[i2], (int) c2)) ? iArr2[i2][c2] : 0;
                if (i3 > 0) {
                    if (e6VarB == null) {
                        e6VarB = e6Var.b(i);
                    }
                    if (!z || i2 == e6Var.c() || i2 == 2) {
                        collection.add(e6VarB.a(i2, i3));
                    }
                    if (!z && e[e6Var.c()][i2] >= 0) {
                        collection.add(e6VarB.b(i2, i3));
                    }
                }
            }
            int[][] iArr3 = d;
            if (y6.a(iArr3, e6Var.c()) && y6.a(iArr3[e6Var.c()], (int) c2)) {
                if (e6Var.a() > 0 || iArr3[e6Var.c()][c2] == 0) {
                    collection.add(e6Var.a(i));
                }
            }
        }
    }

    private static Collection<e6> a(Iterable<e6> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<e6> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i, i2, linkedList);
        }
        return a(linkedList);
    }

    private static void a(e6 e6Var, int i, int i2, Collection<e6> collection) {
        e6 e6VarB = e6Var.b(i);
        collection.add(e6VarB.a(4, i2));
        if (e6Var.c() != 4) {
            collection.add(e6VarB.b(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(e6VarB.a(2, 16 - i2).a(2, 1));
        }
        if (e6Var.a() > 0) {
            collection.add(e6Var.a(i).a(i + 1));
        }
    }

    private static Collection<e6> a(Iterable<e6> iterable) {
        LinkedList linkedList = new LinkedList();
        for (e6 e6Var : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (it.hasNext()) {
                    e6 e6Var2 = (e6) it.next();
                    if (e6Var2.a(e6Var)) {
                        break;
                    }
                    if (e6Var.a(e6Var2)) {
                        it.remove();
                    }
                } else {
                    linkedList.add(e6Var);
                    break;
                }
            }
        }
        return linkedList;
    }
}
