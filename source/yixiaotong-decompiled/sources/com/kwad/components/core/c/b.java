package com.kwad.components.core.c;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b {
    public static void b(e eVar) {
        ai("使用缓存策略: " + eVar.oQ());
    }

    private static void ai(String str) {
        if (oL() && com.kwad.sdk.o.Gs().Fx()) {
            ae.V(ServiceProvider.getContext(), str);
        }
    }

    public static boolean oL() {
        return false;
    }
}
