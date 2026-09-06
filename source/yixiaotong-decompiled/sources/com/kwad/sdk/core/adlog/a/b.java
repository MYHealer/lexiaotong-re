package com.kwad.sdk.core.adlog.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private final c aLR;
    private final List<com.kwad.sdk.core.adlog.a.a> aLS;

    static final class a {
        private static final b aLU = new b(0);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.aLS = new CopyOnWriteArrayList();
        this.aLR = (c) ac.b(((h) ServiceProvider.get(h.class)).Gh(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ com.kwad.sdk.core.b IA() {
                return Jb();
            }

            private static c Jb() {
                return new c();
            }
        });
    }

    public static b IV() {
        return a.aLU;
    }

    public final void a(com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i, String str2) {
        try {
            if (IZ()) {
                return;
            }
            if (!Ja() || d(aVar2)) {
                if (aVar == null) {
                    if (aVar2 != null) {
                        com.kwad.sdk.core.adlog.a.C0733a c0733a = aVar2.Jg() == null ? new com.kwad.sdk.core.adlog.a.C0733a() : aVar2.Jg();
                        c0733a.aLf = 1;
                        aVar2.a(c0733a);
                        ac.putValue(jSONObject, "clientExtData", aVar2.QZ.toJson().toString());
                    }
                    aVar = com.kwad.sdk.core.adlog.a.a.IU().dW(str).j(jSONObject).c(aVar2).ay(System.currentTimeMillis());
                }
                aVar.dJ(i).dX(str2);
                com.kwad.sdk.core.adlog.b.a.a(aVar, this.aLR, this.aLS.size());
                if (aVar.retryCount >= this.aLR.aLW) {
                    com.kwad.sdk.core.adlog.b.a.c(aVar, this.aLR, this.aLS.size());
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + aVar);
                    return;
                }
                if (this.aLS.size() >= this.aLR.aLY) {
                    com.kwad.sdk.core.adlog.a.a aVarIX = IX();
                    com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache limit size: " + this.aLS.size() + ", remove log：" + aVarIX);
                    com.kwad.sdk.core.adlog.b.a.e(aVarIX, this.aLR, this.aLS.size());
                }
                a(aVar);
                com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache success size: " + this.aLS.size() + ", log: " + aVar);
                com.kwad.sdk.core.adlog.b.a.b(aVar, this.aLR, this.aLS.size());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void IW() {
        try {
            if (IZ() || ar.R(this.aLS)) {
                return;
            }
            by.runOnUiThread(new bi() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.IS();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.aLS.add(aVar);
    }

    private synchronized com.kwad.sdk.core.adlog.a.a IX() {
        if (ar.R(this.aLS)) {
            return null;
        }
        return this.aLS.remove(0);
    }

    public final com.kwad.sdk.core.adlog.a.a IY() {
        com.kwad.sdk.core.adlog.a.a aVarIX = IX();
        if (aVarIX == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(aVarIX, this.aLR, this.aLS.size());
        long jCurrentTimeMillis = System.currentTimeMillis() - aVarIX.aLO;
        if (jCurrentTimeMillis > this.aLR.aLX * 1000) {
            com.kwad.sdk.core.adlog.b.a.b(aVarIX, this.aLR, this.aLS.size(), jCurrentTimeMillis);
            com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + jCurrentTimeMillis + ", adLogCache：" + aVarIX);
            return null;
        }
        aVarIX.retryCount++;
        com.kwad.sdk.core.adlog.b.a.a(aVarIX, this.aLR, this.aLS.size(), jCurrentTimeMillis);
        com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache success：" + aVarIX);
        return aVarIX;
    }

    private boolean IZ() {
        c cVar = this.aLR;
        return cVar == null || !cVar.aLV;
    }

    private boolean Ja() {
        c cVar = this.aLR;
        return cVar != null && cVar.aLZ;
    }

    private static boolean d(com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        return aVar.aKI == 1 || aVar.aKI == 2;
    }
}
