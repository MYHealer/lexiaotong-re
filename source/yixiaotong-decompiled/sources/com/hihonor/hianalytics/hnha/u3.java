package com.hihonor.hianalytics.hnha;

import android.util.Pair;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class u3 {
    public static <R> R a(int i, R r, q3<R> q3Var) {
        if (i <= 0) {
            j2.g("ThreadUtils", "repeatExecute3 illegal param=" + i);
            return r;
        }
        for (int i2 = 0; i2 < i; i2++) {
            try {
                return q3Var.a();
            } catch (Throwable th) {
                j2.g("ThreadUtils", "repeatExecute3 num=" + i2 + " failE=" + SystemUtils.getDesensitizedException(th));
                com.hihonor.hianalytics.util.k.a(500L);
            }
        }
        return r;
    }

    public static boolean a(int i, Runnable runnable) {
        if (i <= 0) {
            j2.g("ThreadUtils", "repeatExecute illegal param=" + i);
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            try {
                runnable.run();
                return true;
            } catch (Throwable th) {
                j2.g("ThreadUtils", "repeatExecute num=" + i2 + " failE=" + SystemUtils.getDesensitizedException(th));
                com.hihonor.hianalytics.util.k.a(500L);
            }
        }
        return false;
    }

    public static <R> Pair<R, Throwable> b(int i, R r, q3<R> q3Var) {
        if (i <= 0) {
            j2.g("ThreadUtils", "repeatExecute3 illegal param=" + i);
            return Pair.create(r, null);
        }
        Throwable th = null;
        for (int i2 = 0; i2 < i; i2++) {
            try {
                return Pair.create(q3Var.a(), null);
            } catch (Throwable th2) {
                th = th2;
                j2.g("ThreadUtils", "repeatExecute3 num=" + i2 + " failE=" + SystemUtils.getDesensitizedException(th));
                com.hihonor.hianalytics.util.k.a(500L);
            }
        }
        return Pair.create(r, th);
    }
}
