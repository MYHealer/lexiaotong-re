package com.kwad.sdk.core.adlog.b;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int aKI;
    public int aLP;
    public String aLQ;
    public boolean aLZ;
    public int aMa;
    public int aMb;
    public long aMc;
    public int retryCount;
    public int status;

    public final b az(long j) {
        this.aMc = j;
        return this;
    }

    public final b bE(boolean z) {
        this.aLZ = z;
        return this;
    }

    public final b dK(int i) {
        this.status = i;
        return this;
    }

    public final b dL(int i) {
        this.aKI = i;
        return this;
    }

    public final b dM(int i) {
        this.retryCount = i;
        return this;
    }

    public final b dN(int i) {
        this.aLP = i;
        return this;
    }

    public final b dO(int i) {
        this.aMa = i;
        return this;
    }

    public final b dP(int i) {
        this.aMb = i;
        return this;
    }

    public final b dY(String str) {
        this.aLQ = str;
        return this;
    }

    public static b Jd() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: cD, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
