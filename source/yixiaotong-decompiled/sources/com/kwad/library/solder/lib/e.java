package com.kwad.library.solder.lib;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e implements com.kwad.library.solder.lib.a.d {
    private final com.kwad.library.solder.lib.ext.c aEj;
    private final com.kwad.library.solder.lib.a.c aEl;
    private final com.kwad.library.solder.lib.a.f aEm;
    private final com.kwad.library.solder.lib.a.b aEn;
    private final com.kwad.library.solder.lib.ext.a aEo;
    private Map<String, b> aEp;

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.c DK() {
        return this.aEj;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.c DL() {
        return this.aEl;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.f DM() {
        return this.aEm;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.b DN() {
        return this.aEn;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.a DO() {
        return this.aEo;
    }

    public e(com.kwad.library.solder.lib.a.c cVar, com.kwad.library.solder.lib.a.f fVar, com.kwad.library.solder.lib.a.b bVar, com.kwad.library.solder.lib.ext.c cVar2, com.kwad.library.solder.lib.ext.a aVar) {
        this.aEl = cVar;
        this.aEm = fVar;
        this.aEn = bVar;
        this.aEj = cVar2;
        this.aEo = aVar;
    }

    public final com.kwad.library.solder.lib.a.e a(com.kwad.library.solder.lib.a.e eVar, a aVar) {
        if (eVar.DX() == null) {
            eVar.a(this);
        }
        eVar.Eb();
        eVar.DY();
        aVar.j(eVar);
        return eVar;
    }

    public final b a(com.kwad.library.solder.lib.a.e eVar, int i) {
        return b(eVar, a.a(this, 16));
    }

    private b b(final com.kwad.library.solder.lib.a.e eVar, final a aVar) {
        b bVarCz = cz(eVar.Eb());
        if (bVarCz != null) {
            bVarCz.cancel();
        }
        eVar.a(this);
        b bVar = new b(eVar, this.aEj.Eu().submit(new Callable<com.kwad.library.solder.lib.a.e>() { // from class: com.kwad.library.solder.lib.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: DP, reason: merged with bridge method [inline-methods] */
            public com.kwad.library.solder.lib.a.e call() {
                return e.this.a(eVar, aVar);
            }
        }));
        a(eVar.Eb(), bVar);
        return bVar;
    }

    public final void i(com.kwad.library.solder.lib.a.e eVar) {
        b bVarCz = cz(eVar.Eb());
        if (bVarCz != null) {
            bVarCz.cancel();
        }
        a(eVar.Eb(), (b) null);
    }

    private synchronized b cz(String str) {
        Map<String, b> mapE = e(this.aEp);
        this.aEp = mapE;
        if (str == null) {
            return null;
        }
        return mapE.get(str);
    }

    private synchronized void a(String str, b bVar) {
        Map<String, b> mapE = e(this.aEp);
        this.aEp = mapE;
        if (str != null) {
            mapE.put(str, bVar);
        }
    }

    private static Map<String, b> e(Map<String, b> map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    public static abstract class a {
        final com.kwad.library.solder.lib.a.d aEt;

        public abstract void j(com.kwad.library.solder.lib.a.e eVar);

        public static a a(com.kwad.library.solder.lib.a.d dVar, int i) {
            if (i == 1) {
                return new b(dVar);
            }
            return new C0723a(dVar);
        }

        public a(com.kwad.library.solder.lib.a.d dVar) {
            this.aEt = dVar;
        }

        static class b extends a {
            b(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.aEt.DM().k(eVar);
            }
        }

        /* JADX INFO: renamed from: com.kwad.library.solder.lib.e$a$a, reason: collision with other inner class name */
        static class C0723a extends a {
            C0723a(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.aEt.DL().g(eVar);
            }
        }
    }

    public static class b {
        private final com.kwad.library.solder.lib.a.e aEu;
        private final Future<com.kwad.library.solder.lib.a.e> aEv;

        public b(com.kwad.library.solder.lib.a.e eVar, Future<com.kwad.library.solder.lib.a.e> future) {
            this.aEu = eVar;
            this.aEv = future;
        }

        public final void cancel() {
            this.aEu.cancel();
            this.aEv.cancel(true);
        }
    }
}
