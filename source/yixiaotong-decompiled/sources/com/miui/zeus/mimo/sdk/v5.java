package com.miui.zeus.mimo.sdk;

import android.app.Application;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v5 implements s5 {
    @Override // com.miui.zeus.mimo.sdk.s5
    public void a(Application application) {
        if (j4.b == null) {
            synchronized (j4.class) {
                if (j4.b == null) {
                    j4.b = new j4();
                }
            }
        }
        j4 j4Var = j4.b;
        j4Var.getClass();
        Thread.setDefaultUncaughtExceptionHandler(j4Var);
    }
}
