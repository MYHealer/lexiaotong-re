package com.adprof.sdk;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class le {
    public static void a(View view, d dVar, ke keVar, String str) {
        try {
            w6.a(view, dVar, new je(keVar));
        } catch (Throwable th) {
            pk.b(str, "calculateClickTimes error: " + th.getMessage());
        }
    }
}
