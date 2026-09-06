package com.byazt.rx;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 152, 34})
public class a {
    public static final AtomicReference<Long> c = new AtomicReference<>(0L);

    public static void c(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                return;
            }
            AtomicReference<Long> atomicReference = c;
            long jLongValue = atomicReference.get().longValue();
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, Long.valueOf(jLongValue), Long.valueOf(jLongValue | j))) {
                return;
            } else {
                i = i2;
            }
        }
    }
}
