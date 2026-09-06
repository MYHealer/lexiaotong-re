package com.byazt.or;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 579, 46})
public class n {
    public static void c(com.byazt.bwm.sp spVar, int i) {
        if (spVar == null) {
            return;
        }
        com.byazt.mf.ve veVarVe = com.byazt.mf.c.c().ve();
        ExecutorService executorServiceYp = veVarVe != null ? veVarVe.yp() : null;
        if (executorServiceYp != null) {
            spVar.c(i);
            executorServiceYp.execute(spVar);
        } else {
            com.byazt.bwm.n.c(spVar, i);
        }
    }

    public static void tt(com.byazt.bwm.sp spVar, int i) {
        if (spVar == null) {
            return;
        }
        com.byazt.mf.ve veVarVe = com.byazt.mf.c.c().ve();
        ExecutorService executorServiceU = veVarVe != null ? veVarVe.u() : null;
        if (executorServiceU != null) {
            spVar.c(i);
            executorServiceU.execute(spVar);
        } else {
            com.byazt.bwm.n.c(spVar);
        }
    }

    public static ScheduledFuture c(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.byazt.bwm.n.uj().schedule(runnable, j, timeUnit);
    }
}
