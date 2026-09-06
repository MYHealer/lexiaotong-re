package com.byazt.bwm;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 33, 15})
public final class uj {
    private static void c(Throwable th) {
        String.valueOf(th.getMessage());
    }

    public static int c() {
        ThreadGroup threadGroupTt = tt();
        if (threadGroupTt == null) {
            return 0;
        }
        int iActiveCount = threadGroupTt.activeCount();
        try {
            return threadGroupTt.enumerate(new Thread[(iActiveCount / 2) + iActiveCount]);
        } catch (Throwable unused) {
            return iActiveCount;
        }
    }

    public static ThreadGroup tt() {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e) {
            c(e);
            return null;
        }
    }
}
