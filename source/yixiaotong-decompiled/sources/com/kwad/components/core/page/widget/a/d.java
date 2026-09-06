package com.kwad.components.core.page.widget.a;

import android.app.Activity;
import android.app.Fragment;
import com.kwad.components.core.proxy.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    private j aht;

    public final j a(String str, Activity activity, j jVar) {
        return a(str, activity, jVar, new f(), -1);
    }

    private j a(String str, Activity activity, j jVar, g gVar, int i) {
        return a(str, activity, jVar, gVar, -1, null);
    }

    private j a(String str, Activity activity, j jVar, g gVar, int i, c cVar) {
        if (gVar == null) {
            gVar = new f();
        }
        e eVarBc = gVar.bc(str);
        eVarBc.ahE = i;
        eVarBc.ahG = null;
        eVarBc.ahz = 0.8f;
        eVarBc.ahA = com.kwad.sdk.c.a.a.a(activity, 4.0f);
        a(activity, eVarBc);
        return a(activity, jVar, eVarBc);
    }

    private static void a(Activity activity, e eVar) {
        float f = eVar.ahx;
        if (f >= 1.0f) {
            eVar.ahw = true;
            eVar.ahx = 1.0f;
        } else if (f < 0.0f) {
            eVar.ahx = 0.0f;
        }
        if (eVar.ahw) {
            eVar.ahy = com.kwad.sdk.c.a.a.k(activity);
        } else {
            if (eVar.ahx <= 0.0f || eVar.ahx > 1.0f) {
                return;
            }
            eVar.ahy = com.kwad.sdk.c.a.a.k(activity) * f;
        }
    }

    private j a(Activity activity, j jVar, e eVar) {
        j jVarA = a(jVar, eVar);
        this.aht = jVarA;
        jVarA.a(activity.getFragmentManager(), "WEB_HALF_DIALOG");
        return this.aht;
    }

    private j a(j jVar, e eVar) {
        a aVarA = a.a(eVar);
        if (!eVar.ahC) {
            aVarA.bC((int) eVar.ahy);
        }
        return a(aVarA, jVar, eVar);
    }

    private b a(a aVar, final j jVar, e eVar) {
        aVar.a(new b.a() { // from class: com.kwad.components.core.page.widget.a.d.1
            @Override // com.kwad.components.core.page.widget.a.b.a
            public final Fragment vj() {
                return jVar;
            }
        });
        if (eVar.ahE > 0) {
            aVar.bB(eVar.ahE);
        }
        return aVar;
    }

    public final void dismiss() {
        j jVar = this.aht;
        if (jVar != null) {
            jVar.dismiss();
        }
    }
}
