package com.kwad.sdk.utils.a;

import android.content.Context;
import android.util.Log;
import com.kwad.sdk.utils.y;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    static ExecutorService biO = Executors.newSingleThreadExecutor();
    static boolean bpr = init();

    private static boolean init() {
        d.setExecutor(biO);
        d.a(new c.d() { // from class: com.kwad.sdk.utils.a.e.1
            @Override // com.kwad.sdk.utils.a.c.d
            public final void i(String str, String str2) {
                com.kwad.sdk.core.d.c.i("UnionKv", "name:" + str + " msg:" + str2);
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void a(String str, Exception exc) {
                com.kwad.sdk.core.d.c.w("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void e(String str, Throwable th) {
                com.kwad.sdk.core.d.c.e("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(th));
            }
        });
        bpr = true;
        return true;
    }

    public static c aF(Context context, String str) {
        if (!bpr) {
            init();
        }
        return new c.a(y.T(context, "ks_union"), str).XC();
    }
}
