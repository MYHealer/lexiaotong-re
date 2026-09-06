package com.kwad.components.ad.feed;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f {
    public static String p(AdTemplate adTemplate) {
        String strAA = com.kwad.sdk.core.response.helper.a.aA(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        if (com.kwad.components.core.c.b.oL()) {
            return (adTemplate.fromCache ? "【cache】" : "") + strAA;
        }
        return strAA;
    }
}
