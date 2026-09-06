package com.kwad.sdk.commercial.d;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aKs;
    public String aKt;

    public final b dw(String str) {
        this.aKs = str;
        return this;
    }

    public final b dx(String str) {
        this.aKt = str;
        return this;
    }

    public static b Ir() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: cj, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
