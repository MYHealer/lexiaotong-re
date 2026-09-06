package com.kwad.components.core.t;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private Set<b> alq;

    static class a {
        private static c alr = new c(0);
    }

    public interface b {
        void onPageClose();
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private c() {
        this.alq = new HashSet();
    }

    public static c wG() {
        return a.alr;
    }

    public final void a(b bVar) {
        this.alq.add(bVar);
    }

    public final void b(b bVar) {
        this.alq.remove(bVar);
    }

    public final void wH() {
        if (this.alq.size() == 0) {
            return;
        }
        Iterator<b> it = this.alq.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }
}
