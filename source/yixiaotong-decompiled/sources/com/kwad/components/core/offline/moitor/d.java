package com.kwad.components.core.offline.moitor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String acX;
    public long acY;
    public long acZ;
    public String adb;
    public long adc;

    public final d M(long j) {
        this.acY = j;
        return this;
    }

    public final d N(long j) {
        this.acZ = j;
        return this;
    }

    public final d O(long j) {
        this.adc = j;
        return this;
    }

    public final d aV(String str) {
        this.acX = str;
        return this;
    }

    public final d aX(String str) {
        this.adb = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: bu, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public final d aW(String str) {
        this.errorMsg = str;
        return this;
    }
}
