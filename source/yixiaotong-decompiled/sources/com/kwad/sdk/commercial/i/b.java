package com.kwad.sdk.commercial.i;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String aKA;
    public String aKB;
    public int aKI;
    public int requestType;
    public int status;

    public final b dF(int i) {
        this.status = i;
        return this;
    }

    public final b dG(int i) {
        this.aKI = i;
        return this;
    }

    public final b dH(int i) {
        this.requestType = i;
        return this;
    }

    public final b dL(String str) {
        this.aKA = str;
        return this;
    }

    public final b dM(String str) {
        this.aKB = str;
        return this;
    }

    public static b IB() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: dI, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: dN, reason: merged with bridge method [inline-methods] */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: cl, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
