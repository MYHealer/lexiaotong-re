package com.opos.cmn.an.f.b;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f5892a;
    private static volatile Boolean b;

    public static synchronized void a(boolean z) {
        b = Boolean.valueOf(z);
    }

    public static synchronized boolean a(Context context) {
        if (Build.VERSION.SDK_INT <= 29) {
            return true;
        }
        if (b != null) {
            return b.booleanValue();
        }
        return b(context);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000e A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:7:0x0008, B:9:0x000e, B:10:0x0012, B:12:0x0017, B:14:0x002b), top: B:26:0x0008 }] */
    public static synchronized boolean b(Context context) {
        boolean z;
        if (f5892a == null) {
            try {
                if (Build.VERSION.SDK_INT <= 29) {
                    z = true;
                    f5892a = z;
                } else if (context != null) {
                    if (Settings.Global.getInt(StubApp.getOrigApplicationContext(context.getApplicationContext()).getContentResolver(), "oplus_customize_system_stable_plan_switch") == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    f5892a = z;
                }
            } catch (Throwable unused) {
            }
        }
        if (f5892a == null) {
            f5892a = true;
        }
        return f5892a.booleanValue();
    }
}
