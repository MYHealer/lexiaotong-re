package com.byazt.mg;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 170, 130})
public final class m {
    public static Thread c(Runnable runnable, String str) {
        com.byazt.jtc.ve veVar;
        if (runnable == null) {
            return null;
        }
        if (str == null) {
            veVar = new com.byazt.jtc.ve(runnable, "hreadExecutor");
        } else {
            veVar = new com.byazt.jtc.ve(runnable, str);
        }
        veVar.start();
        return veVar;
    }

    public static Thread c(Runnable runnable) {
        return c(runnable, null);
    }
}
