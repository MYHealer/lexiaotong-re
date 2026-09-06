package com.kwad.sdk.commercial.h;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public String aKA;
    public String aKB;
    public String aKC;
    public String aKs;

    public final a dD(String str) {
        this.aKC = str;
        return this;
    }

    public final a dE(String str) {
        this.aKs = str;
        return this;
    }

    public final a dF(String str) {
        this.aKA = str;
        return this;
    }

    public final a dG(String str) {
        this.aKB = str;
        return this;
    }

    public static a Ix() {
        return new a();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: ck, reason: merged with bridge method [inline-methods] */
    public final a setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
