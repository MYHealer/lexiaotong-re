package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.hmsscankit.WriterException;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: MatrixUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[][] f4225a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 170}};
    private static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(a0 a0Var) {
        a0Var.a((byte) -1);
    }

    private static void b(a0 a0Var) throws WriterException {
        if (a0Var.a(8, a0Var.b() - 8) == 0) {
            throw new WriterException();
        }
        a0Var.a(8, a0Var.b() - 8, 1);
    }

    private static boolean b(int i) {
        return i == -1;
    }

    static void c(c7 c7Var, a0 a0Var) throws WriterException {
        if (c7Var.f() < 7) {
            return;
        }
        r rVar = new r();
        a(c7Var, rVar);
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean zB = rVar.b(i);
                i--;
                a0Var.a(i2, (a0Var.b() - 11) + i3, zB);
                a0Var.a((a0Var.b() - 11) + i3, i2, zB);
            }
        }
    }

    private static void d(a0 a0Var) {
        int i = 8;
        while (i < a0Var.c() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (b(a0Var.a(i, 6))) {
                a0Var.a(i, 6, i3);
            }
            if (b(a0Var.a(6, i))) {
                a0Var.a(6, i, i3);
            }
            i = i2;
        }
    }

    static void a(r rVar, r2 r2Var, c7 c7Var, int i, a0 a0Var) throws WriterException {
        a(a0Var);
        a(c7Var, a0Var);
        a(r2Var, i, a0Var);
        c(c7Var, a0Var);
        a(rVar, i, a0Var);
    }

    private static void b(int i, int i2, a0 a0Var) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                a0Var.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void b(c7 c7Var, a0 a0Var) {
        if (c7Var.f() < 2) {
            return;
        }
        int iF = c7Var.f() - 1;
        int[][] iArr = c;
        if (iF < iArr.length) {
            int[] iArr2 = iArr[iF];
            for (int i : iArr2) {
                if (i >= 0) {
                    for (int i2 : iArr2) {
                        if (i2 >= 0 && b(a0Var.a(i2, i))) {
                            b(i2 - 2, i - 2, a0Var);
                        }
                    }
                }
            }
        }
    }

    static void a(c7 c7Var, a0 a0Var) throws WriterException {
        c(a0Var);
        b(a0Var);
        b(c7Var, a0Var);
        d(a0Var);
    }

    private static void d(int i, int i2, a0 a0Var) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (b(a0Var.a(i, i4))) {
                a0Var.a(i, i4, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void c(int i, int i2, a0 a0Var) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f4225a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                a0Var.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    static void a(r2 r2Var, int i, a0 a0Var) throws WriterException {
        r rVar = new r();
        a(r2Var, i, rVar);
        for (int i2 = 0; i2 < rVar.e(); i2++) {
            boolean zB = rVar.b((rVar.e() - 1) - i2);
            int[] iArr = d[i2];
            a0Var.a(iArr[0], iArr[1], zB);
            if (i2 < 8) {
                a0Var.a((a0Var.c() - i2) - 1, 8, zB);
            } else {
                a0Var.a(8, (a0Var.b() - 7) + (i2 - 8), zB);
            }
        }
    }

    private static void c(a0 a0Var) throws WriterException {
        int length = f4225a[0].length;
        c(0, 0, a0Var);
        c(a0Var.c() - length, 0, a0Var);
        c(0, a0Var.c() - length, a0Var);
        a(0, 7, a0Var);
        a(a0Var.c() - 8, 7, a0Var);
        a(0, a0Var.c() - 8, a0Var);
        d(7, 0, a0Var);
        d(a0Var.b() - 8, 0, a0Var);
        d(7, a0Var.b() - 7, a0Var);
    }

    static void a(r rVar, int i, a0 a0Var) throws WriterException {
        boolean zB;
        int iC = a0Var.c() - 1;
        int iB = a0Var.b() - 1;
        int i2 = 0;
        int i3 = -1;
        while (iC > 0) {
            if (iC == 6) {
                iC--;
            }
            while (iB >= 0 && iB < a0Var.b()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = iC - i4;
                    if (b(a0Var.a(i5, iB))) {
                        if (i2 < rVar.e()) {
                            zB = rVar.b(i2);
                            i2++;
                        } else {
                            zB = false;
                        }
                        if (i != -1 && a4.a(i, i5, iB)) {
                            zB = !zB;
                        }
                        a0Var.a(i5, iB, zB);
                    }
                }
                iB += i3;
            }
            i3 = -i3;
            iB += i3;
            iC -= 2;
        }
        if (i2 != rVar.e()) {
            throw new WriterException("Not all bits consumed: " + i2 + IOUtils.DIR_SEPARATOR_UNIX + rVar.e());
        }
    }

    static int a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    static int a(int i, int i2) {
        if (i2 != 0) {
            int iA = a(i2);
            int iA2 = i << (iA - 1);
            while (a(iA2) >= iA) {
                iA2 ^= i2 << (a(iA2) - iA);
            }
            return iA2;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void a(r2 r2Var, int i, r rVar) throws WriterException {
        if (m5.a(i)) {
            int iA = (r2Var.a() << 3) | i;
            rVar.a(iA, 5);
            rVar.a(a(iA, 1335), 10);
            r rVar2 = new r();
            rVar2.a(21522, 15);
            rVar.b(rVar2);
            if (rVar.e() != 15) {
                throw new WriterException("should not happen but we got: " + rVar.e());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void a(c7 c7Var, r rVar) throws WriterException {
        rVar.a(c7Var.f(), 6);
        rVar.a(a(c7Var.f(), 7973), 12);
        if (rVar.e() != 18) {
            throw new WriterException("should not happen but we got: " + rVar.e());
        }
    }

    private static void a(int i, int i2, a0 a0Var) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (b(a0Var.a(i4, i2))) {
                a0Var.a(i4, i2, 0);
            } else {
                throw new WriterException();
            }
        }
    }
}
