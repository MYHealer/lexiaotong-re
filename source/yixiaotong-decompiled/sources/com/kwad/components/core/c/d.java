package com.kwad.components.core.c;

import android.util.SparseArray;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class d {
    private static volatile d Pn = null;
    private static boolean Po = true;
    private final SparseArray<c> Pm;

    static /* synthetic */ boolean a(d dVar) {
        return oN();
    }

    public static d oM() {
        if (Pn == null) {
            synchronized (d.class) {
                if (Pn == null) {
                    Pn = new d();
                }
            }
        }
        return Pn;
    }

    private d() {
        SparseArray<c> sparseArray = new SparseArray<>();
        this.Pm = sparseArray;
        sparseArray.append(0, new o());
        sparseArray.append(1, new n());
        sparseArray.append(2, new m());
    }

    public final void d(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Oe().submit(new bi() { // from class: com.kwad.components.core.c.d.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                final e eVarA = e.A(aVar.getPosId());
                by.runOnUiThread(new bi() { // from class: com.kwad.components.core.c.d.1.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        b.b(eVarA);
                    }
                });
                c cVar = (d.a(d.this) || !(eVarA.isDefault() || eVarA.isEnable())) ? (c) d.this.Pm.get(0) : (c) d.this.Pm.get(eVarA.oQ());
                if (cVar == null) {
                    cVar = (c) d.this.Pm.get(1);
                }
                com.kwad.components.core.request.j jVarWb = aVar.wb();
                if (jVarWb != null) {
                    cVar.getName();
                    jVarWb.ak();
                }
                d dVar = d.this;
                d.a(aVar, cVar);
                com.kwad.sdk.commercial.convert.e.c(aVar.abn.adScene, aVar.wc());
                cVar.d(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.components.core.request.model.a aVar, c cVar) {
        String name = cVar.getName();
        name.hashCode();
        if (name.equals("StrategyNetworkFirst")) {
            aVar.bi("network_first");
        } else if (name.equals("StrategyLocalCacheFirst")) {
            aVar.bi("cache_first");
        } else {
            aVar.bi("network_only");
        }
    }

    private static boolean oN() {
        if (!Po) {
            return false;
        }
        try {
            if (com.kwad.sdk.components.g.dP("KEY_ENABLE_FORCE_ENABLE_AD_CACHE")) {
                return false;
            }
            Class.forName("com.kwad.devTools.PosConfigFetcher");
            Po = true;
        } catch (ClassNotFoundException unused) {
            Po = false;
        }
        return Po;
    }
}
