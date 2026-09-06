package com.adprof.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class nn implements ra {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f1329a = new ln(Looper.getMainLooper());

    static {
        new CopyOnWriteArrayList();
    }

    public void a(fn.a aVar) {
        try {
            t3.a(aVar);
            gn.f1196a.submit(new kn(this, new v9(aVar)));
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
