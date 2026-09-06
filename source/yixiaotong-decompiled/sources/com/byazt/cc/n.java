package com.byazt.cc;

import android.os.Looper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 46})
public class n {
    public static boolean c() {
        return (com.byazt.by.n.c().t() & 8) == 8;
    }

    public static void c(Runnable runnable) {
        if (c()) {
            if (Looper.myLooper() == com.byazt.nr.da.ve().getLooper()) {
                runnable.run();
                return;
            } else {
                com.byazt.nr.da.ve().post(runnable);
                return;
            }
        }
        com.byazt.bzd.x.c(runnable);
    }

    public static void tt(Runnable runnable) {
        if (c() && Looper.myLooper() != com.byazt.nr.da.ve().getLooper()) {
            com.byazt.nr.da.ve().post(runnable);
        } else {
            runnable.run();
        }
    }
}
