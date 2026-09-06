package com.kwad.components.core.l;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    private CopyOnWriteArrayList<b> abc = new CopyOnWriteArrayList<>();
    private volatile boolean abd;

    /* JADX INFO: renamed from: com.kwad.components.core.l.a$a, reason: collision with other inner class name */
    static final class C0675a {
        private static final a abe = new a();
    }

    public interface c {
        void bL();
    }

    public static a tm() {
        return C0675a.abe;
    }

    public static class b {
        private final c abf;
        public boolean abg;

        public b(c cVar) {
            this.abf = cVar;
        }
    }

    public final void a(b bVar) {
        if (this.abc.contains(bVar)) {
            return;
        }
        if (!this.abd) {
            this.abd = true;
            bVar.abg = true;
        }
        this.abc.add(bVar);
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.abg;
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.abg) {
            bVar.abg = false;
            this.abd = false;
        }
        this.abc.remove(bVar);
        if (this.abc.size() == 0 || this.abd) {
            return;
        }
        this.abc.get(0).abg = true;
        this.abd = true;
        this.abc.get(0).abf.bL();
    }
}
