package com.kwad.components.core.t;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class n {
    public static boolean e(AdTemplate adTemplate, boolean z) {
        if (!z && com.kwad.sdk.core.response.helper.b.dQ(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            return com.kwad.sdk.core.config.e.Kz();
        }
        return false;
    }

    public static void i(Context context, AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0661a(context).aq(true).aJ(adTemplate));
    }
}
