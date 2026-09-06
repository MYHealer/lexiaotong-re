package com.kwad.framework.filedownloader.services;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private final b aCV;

    public interface a {
        com.kwad.framework.filedownloader.f.c.b Cg();
    }

    public c() {
        this.aCV = null;
    }

    public c(b bVar) {
        this.aCV = bVar;
    }

    public final int Cd() {
        b bVar = this.aCV;
        if (bVar == null) {
            return Dj();
        }
        Integer num = bVar.aCX;
        if (num != null) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwad.framework.filedownloader.f.e.dd(num.intValue());
        }
        return Dj();
    }

    public final com.kwad.framework.filedownloader.b.a Dd() {
        b bVar = this.aCV;
        if (bVar == null || bVar.aCW == null) {
            return new com.kwad.framework.filedownloader.b.c();
        }
        com.kwad.framework.filedownloader.b.a aVarDy = this.aCV.aCW.Dy();
        return aVarDy != null ? aVarDy : new com.kwad.framework.filedownloader.b.c();
    }

    public final com.kwad.framework.filedownloader.f.c.e De() {
        b bVar = this.aCV;
        if (bVar == null) {
            return Dk();
        }
        com.kwad.framework.filedownloader.f.c.e eVar = bVar.aCY;
        if (eVar != null) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return Dk();
    }

    public final com.kwad.framework.filedownloader.f.c.b Df() {
        com.kwad.framework.filedownloader.f.c.b bVarCg;
        b bVar = this.aCV;
        if (bVar == null) {
            return Dl();
        }
        a aVar = bVar.aDa;
        return (aVar == null || (bVarCg = aVar.Cg()) == null) ? Dl() : bVarCg;
    }

    public final com.kwad.framework.filedownloader.f.c.a Dg() {
        b bVar = this.aCV;
        if (bVar == null) {
            return Dm();
        }
        com.kwad.framework.filedownloader.f.c.a aVar = bVar.aDb;
        if (aVar != null) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return Dm();
    }

    public final com.kwad.framework.filedownloader.f.c.d Dh() {
        b bVar = this.aCV;
        if (bVar == null) {
            return Di();
        }
        com.kwad.framework.filedownloader.f.c.d dVar = bVar.aDc;
        if (dVar != null) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return Di();
    }

    private static com.kwad.framework.filedownloader.f.c.d Di() {
        return new com.kwad.framework.filedownloader.services.b();
    }

    private static int Dj() {
        return com.kwad.framework.filedownloader.f.e.Dz().aDw;
    }

    private static com.kwad.framework.filedownloader.f.c.e Dk() {
        return new com.kwad.framework.filedownloader.e.b.a();
    }

    private static com.kwad.framework.filedownloader.f.c.b Dl() {
        return new com.kwad.framework.filedownloader.a.c.b();
    }

    private static com.kwad.framework.filedownloader.f.c.a Dm() {
        return new com.kwad.framework.filedownloader.a.a();
    }

    public static class b {
        com.kwad.framework.filedownloader.f.c.InterfaceC0718c aCW;
        Integer aCX;
        com.kwad.framework.filedownloader.f.c.e aCY;
        com.kwad.framework.filedownloader.f.c.b aCZ;
        a aDa;
        com.kwad.framework.filedownloader.f.c.a aDb;
        com.kwad.framework.filedownloader.f.c.d aDc;

        public final b a(com.kwad.framework.filedownloader.f.c.b bVar) {
            this.aCZ = bVar;
            return this;
        }

        public final b a(a aVar) {
            this.aDa = aVar;
            return this;
        }

        public final b cZ(int i) {
            this.aCX = Integer.MAX_VALUE;
            return this;
        }

        public final String toString() {
            return com.kwad.framework.filedownloader.f.f.c("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.aCW, this.aCX, this.aCY, this.aCZ, this.aDb);
        }
    }
}
