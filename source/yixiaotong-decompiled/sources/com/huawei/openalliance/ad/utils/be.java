package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.fh;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class be {
    private static final String Code = "be";
    private static final int V = 1;

    public static <RESULT> RESULT Code(Callable<RESULT> callable, long j, RESULT result) {
        return (RESULT) Code(callable, result, j, TimeUnit.MILLISECONDS);
    }

    public static <RESULT> RESULT Code(Callable<RESULT> callable, RESULT result) {
        return (RESULT) Code(callable, result, 1L, TimeUnit.SECONDS);
    }

    private static <RESULT> RESULT Code(Callable<RESULT> callable, RESULT result, long j, TimeUnit timeUnit) {
        String str;
        StringBuilder sb;
        if (callable == null) {
            return result;
        }
        try {
            return (RESULT) i.Code(callable, i.a.SYNC_CALL).get(j, timeUnit);
        } catch (InterruptedException e) {
            e = e;
            str = Code;
            sb = new StringBuilder("call ");
            fh.I(str, sb.append(e.getClass().getSimpleName()).toString());
            return result;
        } catch (Throwable th) {
            e = th;
            str = Code;
            sb = new StringBuilder("call ");
            fh.I(str, sb.append(e.getClass().getSimpleName()).toString());
            return result;
        }
    }
}
