package com.kwad.components.core.c;

import com.huawei.openalliance.ad.constant.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g {
    private static volatile g PB;
    private ConcurrentHashMap<String, WeakReference<Object>> PA = new ConcurrentHashMap<>();

    public static g oV() {
        if (PB == null) {
            synchronized (g.class) {
                if (PB == null) {
                    PB = new g();
                }
            }
        }
        return PB;
    }

    public final boolean a(i iVar) {
        String strB = b(iVar);
        com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains key: " + strB);
        boolean z = false;
        if (!this.PA.containsKey(strB)) {
            return false;
        }
        WeakReference<Object> weakReference = this.PA.get(strB);
        if (weakReference != null && weakReference.get() != null) {
            z = true;
        }
        if (z) {
            com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.PA.put(aD(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    public final void aC(AdTemplate adTemplate) {
        this.PA.remove(aD(adTemplate));
    }

    private static String b(i iVar) {
        return iVar.oP() + x.A + iVar.pc();
    }

    private static String aD(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.helper.e.eH(adTemplate) + x.A + com.kwad.sdk.core.response.helper.e.eY(adTemplate);
    }
}
