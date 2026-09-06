package com.kwad.components.core.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class g {
    private final List<f> RR;

    public static class a {
        private static final g RS = new g(0);
    }

    /* synthetic */ g(byte b) {
        this();
    }

    private g() {
        this.RR = new CopyOnWriteArrayList();
    }

    public static g qK() {
        return a.RS;
    }

    public final void a(f fVar) {
        this.RR.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.RR.remove(fVar);
        }
    }

    public final void qL() {
        Iterator<f> it = this.RR.iterator();
        while (it.hasNext()) {
            it.next().show();
        }
    }

    public final void qM() {
        Iterator<f> it = this.RR.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
        }
    }
}
