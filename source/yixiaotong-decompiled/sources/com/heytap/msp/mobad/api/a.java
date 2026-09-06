package com.heytap.msp.mobad.api;

import com.opos.mobad.g.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f3416a;

    private a() {
    }

    public static e a() {
        if (f3416a == null) {
            synchronized (a.class) {
                if (f3416a == null) {
                    f3416a = new e();
                }
            }
        }
        return f3416a;
    }
}
