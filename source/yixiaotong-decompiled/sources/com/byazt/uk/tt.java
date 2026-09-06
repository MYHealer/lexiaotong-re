package com.byazt.uk;

import android.os.Build;
import com.byakv.f.FlippedV2Impl;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 87, 13})
public class tt {
    public static final AtomicBoolean c = new AtomicBoolean(false);

    public static void c() {
        AtomicBoolean atomicBoolean = c;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (tt.class) {
            if (atomicBoolean.compareAndSet(false, true)) {
                tt().invokeHiddenApiRestrictions();
            }
        }
    }

    private static com.byazt.fus.ve tt() {
        if (ve()) {
            return new FlippedV2Impl();
        }
        if (uj()) {
            return new com.byazt.fus.tt();
        }
        return new com.byazt.fus.c();
    }

    private static boolean ve() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    private static boolean uj() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
