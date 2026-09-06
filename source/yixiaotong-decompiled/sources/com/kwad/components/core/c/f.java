package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f {
    private Map<Integer, AdResultData> Pv = new ConcurrentHashMap();
    private AtomicInteger Pw = new AtomicInteger(0);
    private Map<Integer, h> Px = new ConcurrentHashMap();
    private AtomicInteger Py = new AtomicInteger(0);

    static class a {
        static f Pz = new f();
    }

    public static f oU() {
        return a.Pz;
    }

    public final int l(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int iIncrementAndGet = this.Pw.incrementAndGet();
        this.Pv.put(Integer.valueOf(iIncrementAndGet), adResultData);
        return iIncrementAndGet;
    }

    public final AdResultData d(int i, boolean z) {
        AdResultData adResultData = this.Pv.get(Integer.valueOf(i));
        this.Pv.remove(Integer.valueOf(i));
        return adResultData;
    }

    public final int a(h hVar) {
        int iIncrementAndGet = this.Py.incrementAndGet();
        this.Px.put(Integer.valueOf(iIncrementAndGet), hVar);
        return iIncrementAndGet;
    }

    public final h e(int i, boolean z) {
        h hVar = this.Px.get(Integer.valueOf(i));
        this.Px.remove(Integer.valueOf(i));
        return hVar;
    }
}
