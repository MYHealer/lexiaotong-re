package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h {
    private static volatile h aTu;
    private List<a> aTt = new CopyOnWriteArrayList();

    public interface a {
        void a(f fVar, int i);
    }

    public static h Mg() {
        if (aTu == null) {
            synchronized (h.class) {
                if (aTu == null) {
                    aTu = new h();
                }
            }
        }
        return aTu;
    }

    private h() {
    }

    public final void a(a aVar) {
        this.aTt.add(aVar);
    }

    final void b(f fVar, int i) {
        Iterator<a> it = this.aTt.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, i);
        }
    }
}
