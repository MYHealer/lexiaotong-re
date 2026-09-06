package com.kwad.framework.filedownloader.download;

import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c aAZ;
    private com.kwad.framework.filedownloader.f.c.a aBa;
    private com.kwad.framework.filedownloader.f.c.b aBb;
    private com.kwad.framework.filedownloader.f.c.e aBc;
    private volatile com.kwad.framework.filedownloader.b.a aBd;
    private com.kwad.framework.filedownloader.f.c.d aBe;

    static final class a {
        private static final b aBf = new b();
    }

    public static b Ca() {
        return a.aBf;
    }

    public final void a(com.kwad.framework.filedownloader.services.c.b bVar) {
        synchronized (this) {
            this.aAZ = new com.kwad.framework.filedownloader.services.c(bVar);
            this.aBb = null;
            this.aBc = null;
            this.aBd = null;
            this.aBe = null;
        }
    }

    public final void b(com.kwad.framework.filedownloader.services.c.b bVar) {
        synchronized (this) {
            this.aAZ = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final com.kwad.framework.filedownloader.a.b ca(String str) {
        try {
            return Cg().bX(str);
        } catch (Throwable unused) {
            com.kwad.framework.filedownloader.a.c.b bVar = new com.kwad.framework.filedownloader.a.c.b();
            this.aBb = bVar;
            return bVar.bX(str);
        }
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return Ch().c(file);
    }

    public final com.kwad.framework.filedownloader.f.c.d Cb() {
        com.kwad.framework.filedownloader.f.c.d dVar = this.aBe;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.aBe == null) {
                this.aBe = Ci().Dh();
            }
        }
        return this.aBe;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a Cc() {
        if (this.aBd != null) {
            return this.aBd;
        }
        this.aBd = Ci().Dd();
        a(this.aBd.BR());
        return this.aBd;
    }

    public final int Cd() {
        return Ci().Cd();
    }

    public final boolean Ce() {
        Ch();
        return true;
    }

    public final int a(int i, String str, String str2, long j) {
        return Cf().ab(j);
    }

    private com.kwad.framework.filedownloader.f.c.a Cf() {
        com.kwad.framework.filedownloader.f.c.a aVar = this.aBa;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.aBa == null) {
                this.aBa = Ci().Dg();
            }
        }
        return this.aBa;
    }

    private com.kwad.framework.filedownloader.f.c.b Cg() {
        com.kwad.framework.filedownloader.f.c.b bVar = this.aBb;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.aBb == null) {
                this.aBb = Ci().Df();
            }
        }
        return this.aBb;
    }

    private com.kwad.framework.filedownloader.f.c.e Ch() {
        com.kwad.framework.filedownloader.f.c.e eVar = this.aBc;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.aBc == null) {
                this.aBc = Ci().De();
            }
        }
        return this.aBc;
    }

    private com.kwad.framework.filedownloader.services.c Ci() {
        com.kwad.framework.filedownloader.services.c cVar = this.aAZ;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.aAZ == null) {
                this.aAZ = new com.kwad.framework.filedownloader.services.c();
            }
        }
        return this.aAZ;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x010d A[Catch: all -> 0x0137, TryCatch #1 {all -> 0x0137, blocks: (B:52:0x00ec, B:36:0x00a0, B:41:0x00c7, B:43:0x00ce, B:47:0x00db, B:50:0x00e6, B:54:0x00f7, B:56:0x010d, B:58:0x0111, B:59:0x0129, B:60:0x0131), top: B:78:0x00ec }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0111 A[Catch: all -> 0x0137, TryCatch #1 {all -> 0x0137, blocks: (B:52:0x00ec, B:36:0x00a0, B:41:0x00c7, B:43:0x00ce, B:47:0x00db, B:50:0x00e6, B:54:0x00f7, B:56:0x010d, B:58:0x0111, B:59:0x0129, B:60:0x0131), top: B:78:0x00ec }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0184  */
    private static void a(com.kwad.framework.filedownloader.b.a.InterfaceC0713a interfaceC0713a) throws Throwable {
        String str;
        int id;
        int iF;
        String str2 = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        Iterator<com.kwad.framework.filedownloader.d.c> it = interfaceC0713a.iterator();
        com.kwad.framework.filedownloader.f.c.d dVarCb = Ca().Cb();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        while (it.hasNext()) {
            try {
                try {
                    com.kwad.framework.filedownloader.d.c next = it.next();
                    if (next.AH() == 3 || next.AH() == 2 || next.AH() == -1 || (next.AH() == 1 && next.CX() > 0)) {
                        next.d((byte) -2);
                    }
                    String targetFilePath = next.getTargetFilePath();
                    try {
                        if (targetFilePath == null) {
                            str = str2;
                            jCurrentTimeMillis = jCurrentTimeMillis;
                        } else {
                            File file = new File(targetFilePath);
                            if (next.AH() == -2) {
                                str = str2;
                                try {
                                    if (com.kwad.framework.filedownloader.f.f.a(next.getId(), next, next.getPath(), null)) {
                                        File file2 = new File(next.Cp());
                                        if (!file2.exists() && file.exists()) {
                                            boolean zRenameTo = file.renameTo(file2);
                                            if (com.kwad.framework.filedownloader.f.d.aDr) {
                                                com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(zRenameTo), file.getPath(), file2.getPath());
                                            }
                                        }
                                    }
                                    if (next.AH() == 1 || next.CX() > 0) {
                                        if (com.kwad.framework.filedownloader.f.f.b(next.getId(), next) && !file.exists()) {
                                            id = next.getId();
                                            iF = dVarCb.f(next.getUrl(), next.getPath(), next.AB());
                                            if (iF != id) {
                                                if (com.kwad.framework.filedownloader.f.d.aDr) {
                                                    com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(id), Integer.valueOf(iF));
                                                }
                                                next.setId(iF);
                                                interfaceC0713a.a(id, next);
                                                j3++;
                                            }
                                            interfaceC0713a.c(next);
                                            j++;
                                        }
                                        str2 = str;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                    str2 = str;
                                    com.kwad.framework.filedownloader.f.f.ba(com.kwad.framework.filedownloader.f.c.Dx());
                                    interfaceC0713a.BS();
                                    if (com.kwad.framework.filedownloader.f.d.aDr) {
                                        com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                    }
                                    throw th;
                                }
                            } else {
                                str = str2;
                            }
                            if (next.AH() == 1) {
                            }
                            if (com.kwad.framework.filedownloader.f.f.b(next.getId(), next)) {
                                id = next.getId();
                                iF = dVarCb.f(next.getUrl(), next.getPath(), next.AB());
                                if (iF != id) {
                                    if (com.kwad.framework.filedownloader.f.d.aDr) {
                                        com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(id), Integer.valueOf(iF));
                                    }
                                    next.setId(iF);
                                    interfaceC0713a.a(id, next);
                                    j3++;
                                }
                                interfaceC0713a.c(next);
                                j++;
                                str2 = str;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                            }
                        }
                        it.remove();
                        j2++;
                        str2 = str;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = str;
                        com.kwad.framework.filedownloader.f.f.ba(com.kwad.framework.filedownloader.f.c.Dx());
                        interfaceC0713a.BS();
                        if (com.kwad.framework.filedownloader.f.d.aDr) {
                            com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jCurrentTimeMillis = jCurrentTimeMillis;
                    com.kwad.framework.filedownloader.f.f.ba(com.kwad.framework.filedownloader.f.c.Dx());
                    interfaceC0713a.BS();
                    if (com.kwad.framework.filedownloader.f.d.aDr) {
                        com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        String str3 = str2;
        long j4 = jCurrentTimeMillis;
        com.kwad.framework.filedownloader.f.f.ba(com.kwad.framework.filedownloader.f.c.Dx());
        interfaceC0713a.BS();
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str3, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(System.currentTimeMillis() - j4));
        }
    }
}
