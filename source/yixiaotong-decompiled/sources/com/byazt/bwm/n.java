package com.byazt.bwm;

import com.byazt.dna.qp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 33, 46})
public class n {
    public static qp c;

    public static void c(sp spVar) {
        spVar.c(10);
        n().executeFastTask(spVar);
    }

    public static ExecutorService c() {
        return n().getIoExecutor();
    }

    public static void tt(sp spVar) {
        c().execute(spVar);
    }

    public static void c(sp spVar, int i) {
        spVar.c(i);
        c().execute(spVar);
    }

    public static ExecutorService tt() {
        return n().getNormalExecutor();
    }

    public static void ve(sp spVar) {
        tt().execute(spVar);
    }

    public static void tt(sp spVar, int i) {
        spVar.c(i);
        n().getAIDLExecutor().execute(spVar);
    }

    public static ExecutorService ve() {
        return c();
    }

    public static void uj(sp spVar) {
        n().executeFastTask(spVar);
    }

    private static qp n() {
        if (c == null) {
            c = (qp) com.byazt.ut.uj.getService("thread_service");
        }
        return c;
    }

    public static ScheduledExecutorService uj() {
        return n().getScheduledThreadPool();
    }
}
