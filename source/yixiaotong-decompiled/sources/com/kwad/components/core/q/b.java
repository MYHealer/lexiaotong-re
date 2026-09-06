package com.kwad.components.core.q;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {
    private static volatile b akr = null;
    private static volatile int aks = 204800;
    static volatile boolean akt = true;
    static volatile boolean aku;
    static volatile Set<c> akv = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static void f(boolean z, int i) {
        if (i > 0) {
            aks = i * 1024;
        }
        akt = z;
    }

    public static boolean wg() {
        return akt;
    }

    public static void register() {
        try {
            com.kwad.sdk.service.c.a(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    public static b wf() {
        if (akr == null) {
            synchronized (b.class) {
                if (akr == null) {
                    akr = new b();
                }
            }
        }
        return akr;
    }

    private static synchronized InputStream wrap(InputStream inputStream) {
        c cVar;
        cVar = new c(inputStream, aks / (akv.size() + 1));
        akv.add(cVar);
        return cVar;
    }

    public static synchronized void a(c cVar) {
        if (akv.contains(cVar)) {
            akv.remove(cVar);
        }
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public static int wh() {
        return aks / 1024;
    }

    public final synchronized int wi() {
        int iWj;
        iWj = 0;
        try {
            Iterator<c> it = akv.iterator();
            while (it.hasNext()) {
                iWj += (int) it.next().wj();
            }
        } catch (Exception unused) {
        }
        return iWj;
    }
}
