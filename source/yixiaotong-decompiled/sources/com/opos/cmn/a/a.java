package com.opos.cmn.a;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f5874a = new AtomicBoolean(false);
    private static volatile boolean b = false;
    private static AtomicReference<String> c = new AtomicReference<>(null);
    private static AtomicBoolean d = new AtomicBoolean(false);

    public static void a(boolean z, String str) {
        if (f5874a.compareAndSet(false, true)) {
            b = z;
        }
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(c, null, str);
    }

    public static boolean a() {
        a(false, "CN");
        return b;
    }

    public static String b() {
        String str = c.get();
        return TextUtils.isEmpty(str) ? "CN" : str;
    }

    public static void c() {
        d.compareAndSet(false, true);
    }
}
