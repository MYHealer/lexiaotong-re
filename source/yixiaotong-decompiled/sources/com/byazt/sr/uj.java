package com.byazt.sr;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 977, 15})
public class uj {
    public static Context getContext() {
        if (com.byazt.mf.c.c().ve() == null) {
            return null;
        }
        return com.byazt.mf.c.c().ve().getContext();
    }

    public static boolean c() {
        com.byazt.mf.ve veVarVe = com.byazt.mf.c.c().ve();
        return veVarVe != null && veVarVe.sp() == 1;
    }

    public static int tt() {
        return com.byazt.mf.c.c().ve().da();
    }
}
