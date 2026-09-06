package com.kwad.components.core.t;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {
    private static volatile b alo;

    public static b wF() {
        if (alo == null) {
            synchronized (b.class) {
                if (alo == null) {
                    alo = new b();
                }
            }
        }
        return alo;
    }

    private b() {
    }

    public final boolean a(final AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.d.c.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (bVar != null) {
            bVar.b(adTemplate, null, null, null);
        }
        boolean zB = com.kwad.sdk.core.adlog.c.b(adTemplate, jSONObject, bVar);
        try {
            boolean z = false;
            if (adTemplate.mAdScene != null && adTemplate.mAdScene.adStyle == 10000) {
                z = true;
            }
            if (adTemplate.adStyle == 3 || adTemplate.adStyle == 2 || adTemplate.adStyle == 13 || z) {
                com.kwad.sdk.core.response.helper.e.eO(adTemplate);
                if (zB && com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class) != null) {
                    com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class);
                }
            }
        } catch (Throwable unused) {
        }
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.components.core.t.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.components.core.c.a aVarOI = com.kwad.components.core.c.a.oI();
                if (aVarOI != null) {
                    aVarOI.z(com.kwad.sdk.core.response.helper.e.eY(adTemplate));
                }
            }
        });
        com.kwad.components.core.c.g.oV().aC(adTemplate);
        bg(adTemplate);
        if (zB && com.kwad.sdk.core.response.helper.a.dG(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            com.kwad.components.core.innerEc.logger.a.aP(adTemplate);
        }
        return zB;
    }

    private static void bg(AdTemplate adTemplate) {
        if (com.kwad.components.core.innerEc.f.aK(adTemplate)) {
            com.kwad.components.core.innerEc.f.init();
        }
    }
}
