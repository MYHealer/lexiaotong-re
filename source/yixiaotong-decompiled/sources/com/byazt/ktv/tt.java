package com.byazt.ktv;

import com.byazt.omf.gt;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 154, 13})
public class tt {
    public static volatile Random c;
    public static volatile boolean tt;

    public static boolean c() {
        return tt;
    }

    public static void tt() {
        c(gt.tt().kk(), true);
    }

    public static boolean c(float f, boolean z) {
        if (f <= 0.0f) {
            if (z) {
                tt = false;
            }
            return false;
        }
        int iNextInt = ve().nextInt(10000);
        int i = (int) (f * 10000.0f);
        if (z) {
            tt = iNextInt < i;
        }
        return iNextInt < i;
    }

    private static Random ve() {
        if (c != null) {
            return c;
        }
        Random randomVe = com.byazt.nr.c.ve();
        c = randomVe;
        return randomVe;
    }
}
