package com.kwad.sdk.core.diskcache.b;

import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    static void a(final com.kwad.sdk.core.diskcache.a.a aVar, final String str, final String str2) {
        i.execute(new bi() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                OutputStream outputStreamEs = null;
                try {
                    com.kwad.sdk.core.diskcache.a.a.C0736a c0736aEo = aVar.eo(str2);
                    if (c0736aEo != null) {
                        outputStreamEs = c0736aEo.es(0);
                        if (b.a(str, outputStreamEs, new com.kwad.sdk.core.network.a.a.C0746a())) {
                            c0736aEo.commit();
                        } else {
                            c0736aEo.abort();
                        }
                        aVar.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamEs);
                }
            }
        });
    }

    static File a(com.kwad.sdk.core.diskcache.a.a aVar, String str) throws Throwable {
        com.kwad.sdk.core.diskcache.a.a.c cVarEn;
        com.kwad.sdk.core.diskcache.a.a.c cVar = null;
        try {
            cVarEn = aVar.en(str);
            if (cVarEn != null) {
                try {
                    File fileEv = cVarEn.ev(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVarEn);
                    return fileEv;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar = cVarEn;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVarEn = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVarEn);
        return null;
    }

    static boolean a(com.kwad.sdk.core.diskcache.a.a aVar, String str, String str2, com.kwad.sdk.core.network.a.a.C0746a c0746a) {
        boolean z = false;
        OutputStream outputStreamEs = null;
        try {
            try {
                com.kwad.sdk.core.diskcache.a.a.C0736a c0736aEo = aVar.eo(str2);
                if (c0736aEo != null) {
                    outputStreamEs = c0736aEo.es(0);
                    if (a(str, outputStreamEs, c0746a)) {
                        c0736aEo.commit();
                        z = true;
                    } else {
                        c0736aEo.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e) {
                c0746a.msg = e.getMessage();
            }
            return z;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamEs);
        }
    }

    public static boolean a(String str, OutputStream outputStream, com.kwad.sdk.core.network.a.a.C0746a c0746a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0746a, -1L, true, null);
    }
}
