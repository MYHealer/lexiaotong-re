package com.kwad.framework.filedownloader;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class q {
    private final b aAd = new b();

    q() {
    }

    static class a {
        private static final q aAe = new q();

        static {
            com.kwad.framework.filedownloader.message.e.CR().a(new aa());
        }
    }

    public static q BE() {
        return a.aAe;
    }

    final synchronized void a(x.b bVar) {
        this.aAd.c(bVar);
    }

    final synchronized void b(x.b bVar) {
        this.aAd.b(bVar);
    }

    static class b {
        private ThreadPoolExecutor aAf;
        private LinkedBlockingQueue<Runnable> aAg;

        b() {
            init();
        }

        public final void c(x.b bVar) {
            this.aAf.execute(new c(bVar));
        }

        public final void b(x.b bVar) {
            this.aAg.remove(bVar);
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aAg = linkedBlockingQueue;
            this.aAf = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }
    }

    static class c implements Runnable {
        private final x.b aAh;
        private boolean aAi = false;

        c(x.b bVar) {
            this.aAh = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.aAi) {
                return;
            }
            this.aAh.start();
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aAh;
        }
    }
}
